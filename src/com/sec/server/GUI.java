package com.sec.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GUI extends JPanel {
	private EncryptedServer server;
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
				//TODO: Toggle server
			}
		});
		//JTextArea
		jta_log.setEditable(false);
		jta_log.setLineWrap(true);
		jta_log.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				System.out.println("Log updated!");
				jta_log.setCaretPosition(jta_log.getDocument().getLength());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {}
			@Override
			public void removeUpdate(DocumentEvent e) {}
			
		});
		//JScrollPane
		jsp_log.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	private void toggleServer() {
		if(server == null) {
			server = new SECServer();
			b_startstop.setText("Stop");
		} else {
			server.close();
			server = null;
			b_startstop.setText("Start");
		}
	}
}
