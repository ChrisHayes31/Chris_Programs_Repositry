import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sample_TV_Controller_V1 
	{

	private JFrame frmSampleTvController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
		{
		EventQueue.invokeLater(new Runnable() 
			{
			public void run() 
				{
				try 
					{
					Sample_TV_Controller_V1 window = new Sample_TV_Controller_V1();
					window.frmSampleTvController.setVisible(true);
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
	public Sample_TV_Controller_V1() 
		{
		initialize();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
		{
		frmSampleTvController = new JFrame();
		frmSampleTvController.setTitle("Sample TV Controller");
		frmSampleTvController.setBounds(100, 100, 307, 540);
		frmSampleTvController.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSampleTvController.getContentPane().setLayout(null);
		
		JButton btnPWRButton = new JButton("Power");
		btnPWRButton.setToolTipText("Press to turn Power on or off");
		btnPWRButton.setBounds(77, 62, 97, 25);
		frmSampleTvController.getContentPane().add(btnPWRButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(12, 0, 119, 26);
		frmSampleTvController.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save As");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		mntmNewMenuItem_3.addActionListener(new ActionListener() 
			{
			public void actionPerformed(ActionEvent e) 
				{
				System.exit(0);
				}
			});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JButton btnAuthenticateButton = new JButton("Authenticate");
		btnAuthenticateButton.setToolTipText("Press to Authenticate to TV");
		btnAuthenticateButton.setBounds(155, 100, 119, 25);
		frmSampleTvController.getContentPane().add(btnAuthenticateButton);
		
		JButton btnConnectButton = new JButton("Connect");
		btnConnectButton.setToolTipText("Press to Connect to TV");
		btnConnectButton.setBounds(12, 100, 119, 25);
		frmSampleTvController.getContentPane().add(btnConnectButton);
		
		JButton btnChannelUpButton = new JButton("CH UP");
		btnChannelUpButton.setToolTipText("Press to Channel Up");
		btnChannelUpButton.setBounds(12, 138, 119, 25);
		frmSampleTvController.getContentPane().add(btnChannelUpButton);
		
		JButton btnChannelDownButton = new JButton("CH DOWN");
		btnChannelDownButton.setToolTipText("Press for Channel Down");
		btnChannelDownButton.setBounds(12, 176, 120, 25);
		frmSampleTvController.getContentPane().add(btnChannelDownButton);
		
		JButton btnVolumeUpButton = new JButton("Vol Up");
		btnVolumeUpButton.setToolTipText("Press to adjust TV volume up");
		btnVolumeUpButton.setBounds(155, 138, 119, 25);
		frmSampleTvController.getContentPane().add(btnVolumeUpButton);
		
		JButton btnVolumeDownButton = new JButton("Vol Dwn");
		btnVolumeDownButton.setToolTipText("Press to adjust volume down");
		btnVolumeDownButton.setBounds(155, 176, 119, 25);
		frmSampleTvController.getContentPane().add(btnVolumeDownButton);
		
		JButton btnHDMI1Button = new JButton("HDMI - 1");
		btnHDMI1Button.setToolTipText("Press to select HDMI 1 input");
		btnHDMI1Button.setBounds(12, 214, 119, 25);
		frmSampleTvController.getContentPane().add(btnHDMI1Button);
		
		JButton btnHDMI2Button = new JButton("HDMI - 2");
		btnHDMI2Button.setToolTipText("Press to Select HDMI 2 input");
		btnHDMI2Button.setBounds(12, 253, 119, 25);
		frmSampleTvController.getContentPane().add(btnHDMI2Button);
		
		JButton btnAV1Button = new JButton("AV1");
		btnAV1Button.setToolTipText("Press to select AV1 input");
		btnAV1Button.setBounds(155, 214, 119, 25);
		frmSampleTvController.getContentPane().add(btnAV1Button);
		
		JButton btnAV2Button = new JButton("AV2");
		btnAV2Button.setToolTipText("Press to select AV2 input");
		btnAV2Button.setBounds(155, 253, 119, 25);
		frmSampleTvController.getContentPane().add(btnAV2Button);
		}

	}
