package gui;
import javax.swing.*;
import java.awt.*;

public class PrimaryPanel extends JPanel {

	private StartPanel startPanel;
	private HowToPlayPanel howPanel;
	private GamePanel gamePanel;
	Thread gameExec;
	
	public PrimaryPanel() {
		setPreferredSize(new Dimension(450,400));
		setBackground(Color.white);
		setLayout(null);
		
		
		startPanel = new StartPanel(this);
		startPanel.setBounds(0,0,450,400);
		startPanel.setVisible(true);
		
		howPanel = new HowToPlayPanel(this);
		howPanel.setBounds(0,0,450,400);
		howPanel.setVisible(false);
		
		gamePanel = new GamePanel(this);
		gamePanel.setBounds(0,0,450,400);
		gamePanel.setVisible(false);
		gameExec = new Thread(gamePanel);
		
		add(startPanel);
		add(howPanel);
		add(gamePanel);
		
	}
	public void setVisibleGamePanel() {
		howPanel.setVisible(false);
		startPanel.setVisible(false);
		gamePanel.setVisible(true);
		gameExec.start();
	}
	
	public void setVisibleHowToPlayPanel() {
		howPanel.setVisible(true);
		startPanel.setVisible(false);
		gamePanel.setVisible(false);	
	}
	public void setVisibleStarPanel() {
		
		howPanel.setVisible(false);
		startPanel.setVisible(true);
		gamePanel.setVisible(false);
	}
}
