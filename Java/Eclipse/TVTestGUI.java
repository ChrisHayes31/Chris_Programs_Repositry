import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.io.BufferedReader;


import javax.swing.JFrame;
import javax.swing.JMenu;

import javax.swing.JButton;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TVTestGUI 
	{
	private JFrame TVRemoteframe;
	private JTextField txtSentText;
	private JTextField txtRecevied;
	String data_to_count;
	String data_tx;
	//int char_counted;
	// tewst
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
		{
		EventQueue.invokeLater(new Runnable() 
			{
			public void run() 
				{
				try {
					TVTestGUI window = new TVTestGUI();
					window.TVRemoteframe.setVisible(true);
					} 
				catch (Exception e) 
					{
					e.printStackTrace();
					}
				}
			});
		}

	/**
	 * Create the application.
	 */
	public TVTestGUI() 
		{
		initialize();
		}
	public static int countchars() // need to look at how to count characters in a string
		{
		int x =  data_to_count.length();
		
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
		{
		TVRemoteframe = new JFrame("Smart Home - TV Control Samsung Test");
		TVRemoteframe.setBackground(Color.LIGHT_GRAY);
		TVRemoteframe.setBounds(100, 100, 328, 463);
		TVRemoteframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TVRemoteframe.getContentPane().setLayout(null);
		
		JButton btnTVPwrButton = new JButton("Power");
		btnTVPwrButton.setToolTipText("Press to turn Power On or Off");
		btnTVPwrButton.setBounds(104, 13, 97, 25);
		TVRemoteframe.getContentPane().add(btnTVPwrButton);
		
		JButton btnChDwn = new JButton("Channel Down");
		btnChDwn.setToolTipText("Press to change TV Channel Down");
		btnChDwn.setBounds(12, 148, 115, 25);
		TVRemoteframe.getContentPane().add(btnChDwn);
		
		JButton btnChUp = new JButton("Channel Up");
		btnChUp.setToolTipText("Press to change TV Channel Up");
		btnChUp.setBounds(12, 110, 115, 25);
		TVRemoteframe.getContentPane().add(btnChUp);
		
		JButton btnVolDwn = new JButton("Volume Down");
		btnVolDwn.setToolTipText("Press to turn sound level down");
		btnVolDwn.setBounds(170, 148, 115, 25);
		TVRemoteframe.getContentPane().add(btnVolDwn);
		
		JButton btnVolUp = new JButton("Volume Up");
		btnVolUp.setToolTipText("Press to turn sound level up");
		btnVolUp.setBounds(170, 110, 115, 25);
		TVRemoteframe.getContentPane().add(btnVolUp);
		
		JButton btHDMI1Button = new JButton("HDMI - 1");
		btHDMI1Button.addActionListener(new ActionListener() 
			{
			public void actionPerformed(ActionEvent e) 
				{
				
				}
			});
		btHDMI1Button.setToolTipText("Press to select HDMI 1 input");
		btHDMI1Button.setBounds(12, 209, 115, 25);
		TVRemoteframe.getContentPane().add(btHDMI1Button);
		
		JButton btnHDMI2Button = new JButton("HDMI - 2");
		btnHDMI2Button.setToolTipText("Press to select HDMI 2 input");
		btnHDMI2Button.setBounds(12, 247, 115, 25);
		TVRemoteframe.getContentPane().add(btnHDMI2Button);
		
		JButton btnAV1Button = new JButton("AV - 1");
		btnAV1Button.setToolTipText("Press to select AV 1 input");
		btnAV1Button.setBounds(170, 209, 115, 25);
		TVRemoteframe.getContentPane().add(btnAV1Button);
		
		JButton btnAV2Button = new JButton("AV - 2");
		btnAV2Button.setToolTipText("Press to select AV 2 input");
		btnAV2Button.setBounds(170, 247, 115, 25);
		TVRemoteframe.getContentPane().add(btnAV2Button);
		
		JButton btnAuthenticate = new JButton("Authenticate");
		btnAuthenticate.setToolTipText("Press to Authenticate to TV -0 needs only be done once");
		btnAuthenticate.setBounds(12, 51, 115, 25);
		TVRemoteframe.getContentPane().add(btnAuthenticate);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setToolTipText("Press to Connect to TV - re-establish connection");
		btnConnect.setBounds(170, 51, 115, 25);
		TVRemoteframe.getContentPane().add(btnConnect);
		
		txtSentText = new JTextField();
		txtSentText.setToolTipText("String to be sent to TV");
		txtSentText.setText("Sent Text");
		txtSentText.setBounds(22, 291, 263, 22);
		TVRemoteframe.getContentPane().add(txtSentText);
		txtSentText.setColumns(10);
		
		txtRecevied = new JTextField();
		txtRecevied.setToolTipText("String received from TV");
		txtRecevied.setText("Received Text");
		txtRecevied.setColumns(10);
		txtRecevied.setBounds(22, 326, 263, 22);
		TVRemoteframe.getContentPane().add(txtRecevied);

		JMenuBar TVCtlmenubar = new JMenuBar();
		TVRemoteframe.setJMenuBar(TVCtlmenubar);
		
		JMenu mnufile = new JMenu("File");
		TVCtlmenubar.add(mnufile);
		
		JMenuItem mnuexit = new JMenuItem("Exit");
		mnufile.add(mnuexit);

		class exitaction implements ActionListener
			{
			public void actionPerformed (ActionEvent e2)
				{
				System.exit(0);
				}
			}
		mnuexit.addActionListener(new exitaction());
		}
	}
