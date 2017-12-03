package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel {

	private JButton btnStart,btnHelp;
	private JLabel lblTitle,lblImage;
	private ImageIcon imageHangMan;
	private Font fnt;
	private ButtonListener btnL;
	private PrimaryPanel primary;
	
	public StartPanel(PrimaryPanel p) {
		
		primary = p;
		
		setPreferredSize(new Dimension(400,400));
		setBackground(Color.white);
		setLayout(null);
		
		fnt = new Font("consolas",Font.BOLD,15);
		
		btnL = new ButtonListener();
		
		lblTitle = new JLabel("HANG MAN GAME");
		lblTitle.setFont(new Font("consolas",Font.BOLD,45));
		lblTitle.setBounds(30,100,340,50);
		add(lblTitle);
		
		imageHangMan = new ImageIcon("Images/hangman.png");
		
		lblImage = new JLabel(imageHangMan);
		lblImage.setBounds(185, 170, 200, 200);
		add(lblImage);
		
		btnStart = new JButton("START");
		btnStart.setBounds(50,220,130,30);
		btnStart.setFont(fnt);
		btnStart.setBackground(Color.white);
		btnStart.addActionListener(btnL);
		add(btnStart);
	
		btnHelp = new JButton("HOW TO PLAY");
		btnHelp.setBackground(Color.white);
		btnHelp.setBounds(50,280,130,30);
		btnHelp.addActionListener(btnL);
		add(btnHelp);	
	}

	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			Object obj = event.getSource();
			
			if (obj == btnStart) {
				primary.setVisibleGamePanel();
			} else if (obj == btnHelp) {
				primary.setVisibleHowToPlayPanel();
				
			}
				
		}
	}
}
