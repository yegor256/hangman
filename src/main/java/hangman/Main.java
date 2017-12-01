/**
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
package hangman;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

class JTextFieldLimit extends PlainDocument {  // 글자 수 제한 클래스
	private int limit;
	private boolean toUppercase = false;
	public JTextFieldLimit(int limit) {
		super();
		this.limit = limit;
	}
	public JTextFieldLimit(int limit, boolean upper) {
		super();
		this.limit = limit;
		this.toUppercase = upper;
	}
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if(str == null)
			return;
		if((getLength() + str.length()) <= limit) {
			if(toUppercase) {
				str = str.toUpperCase();
			}
			super.insertString(offset, str, attr);
		}
	}
}

class KeyAnswer extends KeyAdapter {
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			
		}
	}
}

public class Main extends JFrame {

    private final InputStream input;
    private final OutputStream output;
    private final int max;
    private static final String[] WORDS = {
        "simplicity", "equality", "grandmother",
        "neighborhood", "relationship", "mathematics",
        "university", "explanation"
    };
    // component 생성
    JLabel wordBox;
    JLabel info;
    JTextField answer;
    JLabel man;
    
    public Main(final InputStream in, final OutputStream out, final int m) {
    	super("hangman");
    	Container c = getContentPane();
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	c.setLayout(null);
    	
    	wordBox = new JLabel();
    	wordBox.setFont(new Font("Serif", Font.PLAIN, 15));
    	info = new JLabel("Guess a letter: ");
    	answer = new JTextField();
    	answer.setDocument(new JTextFieldLimit(1));
    	answer.setHorizontalAlignment(JTextField.CENTER);
    	answer.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
    	answer.addKeyListener(new KeyAnswer());
    	answer.setBounds(140, 50, 30, 30);
    	info.setBounds(50, 50, 100, 30);
    	wordBox.setBounds(50, 90, 150, 30);
    	
    	c.add(info);
    	c.add(wordBox);
    	c.add(answer);
    	
        this.input = in;
        this.output = out;
        this.max = m;
        
        setSize(new Dimension(400, 300));
        setVisible(true);
    }

    public static void main(final String... args) {
        new Main(System.in, System.out, 5).exec();
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
        
        try (final PrintStream out = new PrintStream(this.output)) {
            final Iterator<String> scanner = new Scanner(this.input);
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
               
                //out.print("Guess a letter: ");
                char chr = scanner.next().charAt(0);
                boolean hit = false;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) == chr && !visible[i]) {
                        visible[i] = true;
                        hit = true;
                    }
                }
                if (hit) {
                    out.print("Hit!\n");
                } else {
                    out.printf(
                        "Missed, mistake #%d out of %d\n",
                        mistakes + 1, this.max
                    );
                    ++mistakes;
                }
                out.append("The word: ");
                for (int i = 0; i < word.length(); ++i) {
                    if (visible[i]) {
                        out.print(word.charAt(i));
                    } else {
                        out.print("?");
                    }
                }
                out.append("\n\n");
            }
            if (done) {
                out.print("You won!\n");
            } else {
                out.print("You lost.\n");
            }
        }
    }

}
