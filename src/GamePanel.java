package gui;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {

    private int max;
    private static ArrayList<String> Words;
    private PrimaryPanel primary;
    // component 생성
    private JLabel wordBox;
    private JLabel info;
    private JTextField answer;
    private JLabel message;
    private String input;
    
    public GamePanel(PrimaryPanel p) {
    	
    	setPreferredSize(new Dimension(400, 400));
        setBackground(Color.white);
        setLayout(null);
        
    	primary = p;
    	
    	max = 10;
    	input = new String("wait");
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
    }
    
	@Override
	public void run() {
		try {
			Words = readWords();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String word = Words.get(new Random().nextInt(Words.size()));
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
            	message.setText(input+" " + answer.getText());
               	if(!input.equals("wait")) {
               		input = "wait";
               		break;
               	}
             }
             // 문제 되는 부분  
             boolean hit = false;
             for (int i = 0; i < word.length(); ++i) {
            	 System.out.println(answer.getText().charAt(0) + " " + word.charAt(i));
                if (word.charAt(i) == answer.getText().charAt(0) && !visible[i]) {
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
                  	str.append("_ ");
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
	
	public static ArrayList<String> readWords() throws IOException {
    	String path = GamePanel.class.getResource("").getPath();
		BufferedReader br = new BufferedReader(new FileReader(path + "Words.txt"));
    	ArrayList<String> L = new ArrayList<String>();
    	while(true) {
            String line = br.readLine();
            if (line==null) break;
            L.add(line);
        }
        br.close();
        
        return L;
    }
}