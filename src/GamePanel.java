/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 */
package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


@SuppressWarnings("serial")
public class GamePanel extends JPanel {

    private int max;
    private static final String[] WORDS = {
        "simplicity", "equality", "grandmother",
        "neighborhood", "relationship", "mathematics",
        "university", "explanation"
    };
    // component 생성
    private JLabel wordBox;
    private JLabel info;
    private JTextField answer;
    JLabel message;
    public String input;
    
    public GamePanel(PrimaryPanel p) {
    	max = 10;
    	input = new String();
    	message = new JLabel("input...");
    	message.setFont(new Font("Serif", Font.PLAIN, 15));
    	wordBox = new JLabel();
    	wordBox.setFont(new Font("Serif", Font.PLAIN, 15));
    	info = new JLabel("Guess a letter: ");
    	answer = new JTextField();
    	answer.setDocument(new JTextFieldLimit(1));
    	answer.setHorizontalAlignment(SwingConstants.CENTER);
    	answer.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
    	answer.addKeyListener(new KeyAdapter() {
    		public void keyPressed(KeyEvent e) {
    			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
    				input = answer.getText();
    			}
    		}
    	});
    	answer.setBounds(140, 50, 30, 30);
    	info.setBounds(50, 50, 100, 30);
    	wordBox.setBounds(50, 90, 150, 30);
    	message.setBounds(50, 140, 150, 30);
    	
    	add(message);
    	add(info);
    	add(wordBox);
    	add(answer);
        
        setSize(new Dimension(400, 300));
        setVisible(true);
    }

    public void exec() {
        String word = WORDS[new Random().nextInt(WORDS.length)];
        boolean[] visible = new boolean[word.length()];  // 단어가 보여지는지의 여부
        int mistakes = 0;
        StringBuffer str = new StringBuffer();
        for(int i=0; i<word.length(); i++) {
        	str.append("_ ");
        }
        wordBox.setText(str.toString());
        
        boolean done = true;
        while (mistakes < this.max) {  // 실수가 최대값을 넘지 않는 동안
             done = true;
             for (int i = 0; i < word.length(); ++i) {  // 맞춰야 될 단어 글자 수 만큼 진행
                if (!visible[i]) {  // 공개가 되지 않은 글자가 있다면
                    done = false;
                }
             }
             if (done) {  // 글자들이 모두 공개가 됐다면 종료
                break;
             }
             while(true) {
               	if(!input.isEmpty() && input.charAt(0) == answer.getText().charAt(0))
               		break;
             }
                
             boolean hit = false;
             for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) == input.charAt(0) && !visible[i]) {
                    visible[i] = true;
                    hit = true;
                }
             }
             if (hit) {
                message.setText("Hit!\n");
             }
             else {
               	++mistakes;
               	message.setText("\"Missed, mistake "+ mistakes + " out of "+ this.max);                    
             }
             str = new StringBuffer("The word: ");
             for (int i = 0; i < word.length(); ++i) {
                if (visible[i]) {
                   	str.append(word.charAt(i));
                }
                else {
                  	str.append(" _ ");
                }
             }
        }
        if (done) {
           	message.setText("You won!");
        }
        else {
           	message.setText("You lost.");
        }
    }
}