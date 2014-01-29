package com.sec.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI extends JPanel {
	private SECServer server;
	private JButton b_startstop;
	private static JTextArea jta_log;
	private JScrollPane jsp_log;
	
	public GUI() {
		b_startstop = new JButton("Start");
		jta_log = new JTextArea(15,45);
		jsp_log = new JScrollPane(jta_log);
		
		//JButton
		b_startstop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				toggleServer();
			}
		});
		//JTextArea
		jta_log.setEditable(false);
		jta_log.setLineWrap(true);
		//JScrollPane
		jsp_log.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(b_startstop);
		add(jsp_log);
	}
	
	private void toggleServer() {
		if(server == null) {
			server = new SECServer();
			b_startstop.setText("Stop");
			log("Server started");
		} else {
			server.close();
			server = null;
			b_startstop.setText("Start");
			log("Server stopped");
		}
	}
	
	public static void log(String message) {
		jta_log.append(message + "\n");
		jta_log.setCaretPosition(jta_log.getDocument().getLength());
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Simple Encrypted Commpunication Server");
		f.setSize(530,320);
		f.add(new GUI());
		f.setResizable(false);
		f.setVisible(true);
	}
}
