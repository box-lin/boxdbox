package com.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

import com.controller.Decrypter;
import com.controller.Encrypter;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class mainWindow {

	private JFrame frame;
	private JTextField inputDirText;
	private JPasswordField passwordField;
	private JTextField outputDirText;
	

	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
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
	public mainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(mainWindow.class.getResource("/img/icon.png")));
		frame.setBounds(100, 100, 453, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Instructions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Description", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	 
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Input Directory: ");
		
		inputDirText = new JTextField();
		inputDirText.setToolTipText("");
		inputDirText.setEnabled(false);
		inputDirText.setEditable(false);
		inputDirText.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ouput Directory: ");
		
		outputDirText = new JTextField();
		outputDirText.setToolTipText("");
		outputDirText.setEnabled(false);
		outputDirText.setEditable(false);
		outputDirText.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1_1)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(outputDirText, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
								.addComponent(inputDirText, 293, 293, 293))))
					.addGap(17))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(inputDirText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(outputDirText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15))
		);
		
		JLabel lblNewLabel = new JLabel("@Box and unBox your file through HuffmanCode and SHA256 ");
		ImageIcon name = new ImageIcon("/img/name.png");
		lblNewLabel.setIcon(name);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		panel_1.add(lblNewLabel);
		
		JButton encryptBtn = new JButton("Box File");
		encryptBtn.setIcon(new ImageIcon(mainWindow.class.getResource("/img/box.png")));
		JButton decryptBtn = new JButton("Unbox File");
		decryptBtn.setIcon(new ImageIcon(mainWindow.class.getResource("/img/unbox.png")));
		encryptBtn.setEnabled(false);
		encryptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save");
				int status = fileChooser.showSaveDialog(encryptBtn);
				if (status == JFileChooser.APPROVE_OPTION) {
					String outPath = fileChooser.getSelectedFile().getAbsolutePath();
					outputDirText.setText(outPath);
					
					String inPath = inputDirText.getText();
					String password = passwordField.getText();
					Encrypter en = new Encrypter(inPath, outPath, password);
					en.box();	
					
					// reset passwordField
					passwordField.setText(null);
					encryptBtn.setEnabled(false);
					decryptBtn.setEnabled(false);
				}
				
			}
		});
		
		decryptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save");
				int status = fileChooser.showSaveDialog(encryptBtn);
				if (status == JFileChooser.APPROVE_OPTION) {
					String outPath = fileChooser.getSelectedFile().getAbsolutePath();
					String inPath = inputDirText.getText();
					String password = passwordField.getText();
					Decrypter de = new Decrypter(inPath, outPath, password);
					boolean okUnBox = de.unBox();	
					
					if (!okUnBox) {
						JOptionPane.showMessageDialog(null, "error: unable to unbox");
						return;
					}
					
					outputDirText.setText(outPath);
					// reset passwordField
					passwordField.setText(null);
					encryptBtn.setEnabled(false);
					decryptBtn.setEnabled(false);
					
				}
			}
		});
		decryptBtn.setEnabled(false);
		
		JButton loadFileBtn = new JButton("Load File");
		loadFileBtn.setIcon(new ImageIcon(mainWindow.class.getResource("/img/add.png")));
		loadFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				outputDirText.setText(null);
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to load");
				int status = fileChooser.showOpenDialog(loadFileBtn);
				
				
				if (status == JFileChooser.APPROVE_OPTION) {
					String absPath = fileChooser.getSelectedFile().getAbsolutePath();
					inputDirText.setText(absPath);
					
				} 
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (passwordField.getPassword().length > 0 && inputDirText.getText().length() > 0) {
					encryptBtn.setEnabled(true);
					decryptBtn.setEnabled(true);
				}else {
					encryptBtn.setEnabled(false);
					decryptBtn.setEnabled(false);
				}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Enter Secrete Key");
		lblNewLabel_2.setIcon(new ImageIcon(mainWindow.class.getResource("/img/password.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(decryptBtn)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(loadFileBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(encryptBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(80)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(loadFileBtn, GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(encryptBtn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(decryptBtn)
							.addGap(23))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About us");
		mntmNewMenuItem.setIcon(new ImageIcon(mainWindow.class.getResource("/img/about.png")));
		menuBar.add(mntmNewMenuItem);

	}
}
