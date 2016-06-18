package SmartTVCTLGUIFrames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class Frame1 
	{
	private JFrame frmSmartHome;
	private JTextField txtBrandSelected;
	private JTextField textTVModelSelected;
	private JTextField txtFileName;
	String parentnodetext;
	String oldSubString;
	String node;
	int nodeOrder;
	int selectedNode;
	int StringLength;
	String snodeSelected;
	int scharCounted;
	String fileToUseName;
	
	
	private JTextField txtTest2;
	//int listindexpos
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
					Frame1 window = new Frame1();
					window.frmSmartHome.setVisible(true);
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
	public Frame1() 
		{
		initialize();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
		{
		frmSmartHome = new JFrame("Smart Home - TV Control GUI");
		frmSmartHome.getContentPane().setBackground(Color.WHITE);
		frmSmartHome.setBackground(Color.LIGHT_GRAY);
		frmSmartHome.setTitle("Smart Home - TV Control GUI");
		frmSmartHome.setBounds(100, 100, 1055, 710);
		frmSmartHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSmartHome.getContentPane().setLayout(null);
		JTextArea jTextArea1 = new JTextArea();
		jTextArea1.setDragEnabled(true);
		jTextArea1.setName("Raw Data");
		jTextArea1.setToolTipText("Raw File Data");
		jTextArea1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jTextArea1.setBounds(400, 348, 321, 260);
		frmSmartHome.getContentPane().add(jTextArea1);		

		JMenuBar menubar = new JMenuBar();
		frmSmartHome.setJMenuBar(menubar);
		
		JMenu mnufile = new JMenu("File");
		menubar.add(mnufile);
		
		JMenuItem mnuopen = new JMenuItem("Open");
		mnuopen.addActionListener(new ActionListener() 
			{
			public void actionPerformed(ActionEvent e) 
				{
				JFileChooser fileDir = new JFileChooser();
				fileDir.setCurrentDirectory(new java.io.File("c:/Home Automation Control"));
				fileDir.setDialogTitle("Open File");
				fileDir.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (fileDir.showOpenDialog(mnuopen) == JFileChooser.APPROVE_OPTION);
					{
						fileToUseName = fileDir.getSelectedFile().getAbsolutePath();
						txtFileName.setText(fileDir.getSelectedFile().getName());
						txtTest2.setText(fileDir.getSelectedFile().getAbsolutePath());
						//txtFileName.setText(fileDir.getSelectedFile().getName());
					};
				
				try // now load data
					{
					FileReader reader = new FileReader(fileToUseName);
					BufferedReader br = new BufferedReader(reader);
					jTextArea1.read(br, null );
					br.close();
					jTextArea1.requestFocus();
					
					}
				catch(Exception e1)
					{
					JOptionPane.showMessageDialog(null, e1);
					}
					
				
				
				}
			});
		
		mnufile.add(mnuopen);
		
		JMenuItem mnusave = new JMenuItem("Save");
		mnufile.add(mnusave);
		
		JMenuItem mnusaveas = new JMenuItem("Save As");
		mnufile.add(mnusaveas);
		
		JMenuItem mnuexit = new JMenuItem("Exit");
		mnufile.add(mnuexit);
		
		JMenu mnuhelp = new JMenu("Help");
		menubar.add(mnuhelp);
		
		JMenuItem mnuabout = new JMenuItem("About");
		mnuhelp.add(mnuabout);
		
		class exitaction implements ActionListener
			{
			public void actionPerformed (ActionEvent e)
				{
				System.exit(0);
				}
			}
		mnuexit.addActionListener(new exitaction());
		//frmSmartHome.getContentPane().add(menuBar);
		
		
		
		JTree JTreeTVBrandModel = new JTree();
		JTreeTVBrandModel.setAutoscrolls(true);
	
		JTreeTVBrandModel.setVisible(false);
		JTreeTVBrandModel.setToolTipText("Brands and Models available");
		
		JTreeTVBrandModel.addTreeSelectionListener(new TreeSelectionListener() 
			{
			public void valueChanged(TreeSelectionEvent tsl) 
				{
				if (tsl.getNewLeadSelectionPath() !=null)
					{
					int pathcount = tsl.getPath().getPathCount();
										
					if (pathcount == 1)
						{
						String boo = tsl.getPath().getPathComponent(0).toString();
						txtBrandSelected.setText(boo);
						}
					if (pathcount == 2)
						{
						String boo = tsl.getPath().getPathComponent(1).toString();
						txtBrandSelected.setText(boo);
						}
					if (pathcount == 3)
						{
						String boo1 = tsl.getPath().getPathComponent(1).toString();
						String boo =  tsl.getPath().getPathComponent(2).toString();
						textTVModelSelected.setText(boo);
						txtBrandSelected.setText(boo1);
						}
					}
				}
			});
		
		
		JTreeTVBrandModel.setBackground(Color.WHITE);
		JTreeTVBrandModel.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("TV Brand - Model") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Samsung");
						node_1.add(new DefaultMutableTreeNode("UA40F6400 (Helen)"));
						node_1.add(new DefaultMutableTreeNode("UA55C7000 (Lounge)"));
						node_1.add(new DefaultMutableTreeNode("UA40Fxxxx (Bungalow)"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Panasonic");
						node_1.add(new DefaultMutableTreeNode("TBA1"));
						node_1.add(new DefaultMutableTreeNode("TBA2"));
						node_1.add(new DefaultMutableTreeNode("TBA3"));
						node_1.add(new DefaultMutableTreeNode("TBA4"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("LG");
						node_1.add(new DefaultMutableTreeNode("TBA1"));
						node_1.add(new DefaultMutableTreeNode("TBA2"));
						node_1.add(new DefaultMutableTreeNode("TBA3"));
						node_1.add(new DefaultMutableTreeNode("TBA4"));
					add(node_1);
				}
			}
		));
		JTreeTVBrandModel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JTreeTVBrandModel.setBounds(80, 225, 191, 318);
		frmSmartHome.getContentPane().add(JTreeTVBrandModel);
		
		JButton btnSelectTVBrandModel = new JButton("Select TV Brand and Model");
		btnSelectTVBrandModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				JTreeTVBrandModel.setVisible(true);
				
			}
		});
		btnSelectTVBrandModel.setToolTipText("Select TV Brand and Model from List");
		btnSelectTVBrandModel.setBounds(70, 186, 222, 25);
		frmSmartHome.getContentPane().add(btnSelectTVBrandModel);
		
		JLabel lblModelSelected = new JLabel("TV Model Selected: ");
		lblModelSelected.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelSelected.setBounds(330, 221, 139, 25);
		frmSmartHome.getContentPane().add(lblModelSelected);
		
		JLabel lblTVBrand = new JLabel("TV Brand Selected: ");
		lblTVBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTVBrand.setBounds(330, 186, 139, 25);
		frmSmartHome.getContentPane().add(lblTVBrand);
		
		txtBrandSelected = new JTextField();
		txtBrandSelected.setToolTipText("TV Brand Selected");
		txtBrandSelected.setHorizontalAlignment(SwingConstants.CENTER);
		txtBrandSelected.setText("TV Brand");
		txtBrandSelected.setBounds(492, 188, 293, 22);
		frmSmartHome.getContentPane().add(txtBrandSelected);
		txtBrandSelected.setColumns(10);
		
		textTVModelSelected = new JTextField();
		textTVModelSelected.setHorizontalAlignment(SwingConstants.CENTER);
		textTVModelSelected.setToolTipText("TV M<odel Selected");
		textTVModelSelected.setText("TV Model");
		textTVModelSelected.setBounds(492, 223, 293, 22);
		frmSmartHome.getContentPane().add(textTVModelSelected);
		textTVModelSelected.setColumns(10);
		
		txtFileName = new JTextField();
		txtFileName.setText("test");
		txtFileName.setBounds(492, 258, 293, 22);
		frmSmartHome.getContentPane().add(txtFileName);
		txtFileName.setColumns(10);
		
		txtTest2 = new JTextField();
		txtTest2.setText("test");
		txtTest2.setColumns(10);
		txtTest2.setBounds(492, 293, 293, 22);
		frmSmartHome.getContentPane().add(txtTest2);
		

		
		
		JTreeTVBrandModel.addMouseListener(new MouseAdapter() 
			{
			@Override
				public void mouseClicked(MouseEvent e2) 
					{
					
					// Search forward from first visible row looking for any visible node
					// whose name starts with prefix.
					//int startRow = 0;
					//String prefix = "S";
			
					//TreePath path = JTreeTVBrandModel.getPathForLocation(e2.getX(), e2.getY());
		    
					//TreePath path = JTreeTVBrandModel.getNextMatch(prefix, startRow, Position.Bias.Forward);
					//System.out.println("Samsung");
		    
					//System.out.println(path);
					//txtTest2.setText(path.toString());
			
					//txtTest1.setText(tsl.getComponentCount());
					//JTreeTVBrandModel.setVisible(false);
					}
			});
		}
	}
