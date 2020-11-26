package com.heightconvtool;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HeightConverter {

	private JFrame frmConverter;
	private JTextField inchesTextField;
	private JTextField feetTextField;
	private JTextField centimetersTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeightConverter window = new HeightConverter();
					window.frmConverter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HeightConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConverter = new JFrame();
		frmConverter.setTitle("Height Converter");
		frmConverter.setBounds(100, 100, 450, 330);
		frmConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		frmConverter.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel inchesLabel = new JLabel("Inches");
		inchesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		inchesLabel.setBounds(80, 85, 100, 17);
		panel.add(inchesLabel);
		
		JLabel centimetersLabel = new JLabel("Centimeters");
		centimetersLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		centimetersLabel.setBounds(80, 185, 100, 17);
		panel.add(centimetersLabel);
		
		inchesTextField = new JTextField();
		inchesTextField.setBounds(260, 80, 86, 30);
		panel.add(inchesTextField);
		inchesTextField.setColumns(10);
		
		feetTextField = new JTextField();
		feetTextField.setBounds(260, 25, 86, 30);
		panel.add(feetTextField);
		feetTextField.setColumns(10);
		
		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double inches;
				double feet;
				double centimeter;
				
				inches = Double.parseDouble(inchesTextField.getText());
				feet = Double.parseDouble(feetTextField.getText());
				
				centimeter = (feet * 12 + inches) * 2.54;
				centimetersTextField.setText(String.valueOf(centimeter));				
			}
		});
		convertButton.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		convertButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		convertButton.setBounds(170, 137, 89, 23);
		panel.add(convertButton);
		
		centimetersTextField = new JTextField();
		centimetersTextField.setBounds(260, 180, 86, 30);
		panel.add(centimetersTextField);
		centimetersTextField.setColumns(10);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feetTextField.setText("");
				inchesTextField.setText("");
				centimetersTextField.setText("");
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		clearButton.setBounds(80, 238, 89, 23);
		panel.add(clearButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setForeground(Color.RED);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		exitButton.setBounds(257, 238, 89, 23);
		panel.add(exitButton);
		
		JLabel feetLabel = new JLabel("Feet");
		feetLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		feetLabel.setBounds(80, 30, 100, 17);
		panel.add(feetLabel);
	}
}
