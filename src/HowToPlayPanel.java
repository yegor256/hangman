import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HowToPlayPanel extends JPanel {

	private JLabel lblTitle,lblFirst,lblSecond,lblThird,lblForth;
	private JButton btnBack;
	private Font fnt;
	private PrimaryPanel primary;
	private ButtonListener btnL;
	
	public HowToPlayPanel(PrimaryPanel p) {
		
		setPreferredSize(new Dimension(400,400));
		setBackground(Color.white);
		setLayout(null);
		
		primary = p;
		
		fnt = new Font("Consolas",Font.BOLD,15);
		
		btnL = new ButtonListener();
		
		lblTitle = new JLabel("GAME RULES");
		lblTitle.setFont(new Font("consolas",Font.BOLD,40));
		lblTitle.setBounds(75,30,250,40);
		add(lblTitle);
		
		lblFirst = new JLabel("1. Guess and Write a letter");
		lblFirst.setFont(fnt);
		lblFirst.setBounds(20,100,370,40);
		add(lblFirst);
		
		lblSecond = new JLabel("<html>2. If the letter is in a word, <br>you can know the position of the letter<br></html>");
		lblSecond.setFont(fnt);
		lblSecond.setBounds(20,160,370,40);
		add(lblSecond);
		
		lblThird = new JLabel("<html>3. If you do not finish within a limited<br>number, you will be defeated.<br></html>");
		lblThird.setFont(fnt);
		lblThird.setBounds(20,220,370,40);
		add(lblThird);
		
		lblForth = new JLabel("4. You win if you match the word");
		lblForth.setFont(fnt);
		lblForth.setBounds(20,280,370,40);
		add(lblForth);
		
		btnBack = new JButton("<<BACK");
		btnBack.setBounds(250,320,90,30);
		btnBack.setBackground(Color.white);
		btnBack.setFont(new Font("consolas",Font.BOLD,13));
		btnBack.addActionListener(btnL);
	
		add(btnBack);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			Object obj = event.getSource();
			
			if (obj ==btnBack) {
				primary.setVisibleStarPanel();
			}
				
		}
	}
}
