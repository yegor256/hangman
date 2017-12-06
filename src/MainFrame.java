package gui;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		PrimaryPanel primary= new PrimaryPanel();
		frame.getContentPane().add(primary);
		
		frame.pack();
		frame.setLocation(500, 200);
		frame.setVisible(true);
		
	}

}
