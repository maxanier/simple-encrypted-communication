package com.sec.client;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUIClient extends JFrame {
	public static void main(String[] args) {
		new GUIClient("GUIClient");
	}
	// Anfang Attribute
	private SECClient c;
	private JButton jButton1 = new JButton();
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel2 = new JLabel();
	private JTextField jtfIP = new JTextField();
	private JTextField jtfPort = new JTextField();
	private JTextField jtfSenden = new JTextField();
	private JButton jButton2 = new JButton();
	private JLabel jLabel3 = new JLabel();

	// Ende Attribute

	private JTextField jtfEmpfang = new JTextField();

	public GUIClient(String title) {
		// Frame-Initialisierung
		super(title);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		int frameWidth = 486;
		int frameHeight = 256;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		jButton1.setBounds(24, 16, 217, 33);
		jButton1.setText("mit Server verbinden");
		jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		cp.add(jButton1);
		jLabel1.setBounds(256, 16, 39, 16);
		jLabel1.setText("IP:");
		jLabel1.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
		cp.add(jLabel1);
		jLabel2.setBounds(256, 40, 51, 16);
		jLabel2.setText("Port:");
		jLabel2.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
		cp.add(jLabel2);
		jtfIP.setBounds(312, 16, 121, 24);
		jtfIP.setText("127.0.0.1");
		cp.add(jtfIP);
		jtfPort.setBounds(312, 40, 121, 24);
		jtfPort.setText("1000");
		cp.add(jtfPort);
		jtfSenden.setBounds(112, 112, 337, 24);
		jtfSenden.setText("");
		cp.add(jtfSenden);
		jButton2.setBounds(16, 112, 91, 25);
		jButton2.setText("Senden");
		jButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton2_ActionPerformed(evt);
			}
		});
		cp.add(jButton2);
		jLabel3.setBounds(16, 168, 81, 16);
		jLabel3.setText("Empfang:");
		jLabel3.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
		cp.add(jLabel3);
		jtfEmpfang.setBounds(112, 168, 337, 24);
		jtfEmpfang.setText("");
		cp.add(jtfEmpfang);
		// Ende Komponenten

		setResizable(false);
		setVisible(true);
		jButton1.setEnabled(true);
		jButton2.setEnabled(false);
	}

	// Anfang Methoden
	public void jButton1_ActionPerformed(ActionEvent evt) {
		c = new SECClient(jtfIP.getText(),
				Integer.parseInt(jtfPort.getText()));
		jButton1.setEnabled(false);
		jButton2.setEnabled(true);
	}

	// Ende Methoden

	public void jButton2_ActionPerformed(ActionEvent evt) {
		c.send(jtfSenden.getText());
	}
}
