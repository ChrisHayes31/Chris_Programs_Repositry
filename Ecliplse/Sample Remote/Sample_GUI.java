import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class Sample_GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sample_GUI window = new Sample_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sample_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 674, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(60, 26, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAuthenticateButton_1 = new JButton("Authenticate");
		btnAuthenticateButton_1.setBounds(60, 64, 112, 25);
		frame.getContentPane().add(btnAuthenticateButton_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(60, 102, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFileMenu = new JMenu("File");
		menuBar.add(mnFileMenu);
		
		JMenuItem mntmOpenMenuItem = new JMenuItem("Open");
		mnFileMenu.add(mntmOpenMenuItem);
		
		JMenuItem mntmSaveMenuItem = new JMenuItem("Save");
		mnFileMenu.add(mntmSaveMenuItem);
		
		JMenuItem mntmSaveAsMenuItem = new JMenuItem("Save As");
		mnFileMenu.add(mntmSaveAsMenuItem);
		
		JMenuItem mntmExitMenuItem = new JMenuItem("Exit");
		mnFileMenu.add(mntmExitMenuItem);
	}
}
