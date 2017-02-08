package com.exmaples.factory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SwingWorkerFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFALUT_HEIGHT = 350;
	private JFileChooser chooser;
	private JTextArea textArea;
	private JLabel statusLine;
	private JMenuItem openItem;
	private JMenuItem cancelItem;
	private Thread workerThread;

	public SwingWorkerFrame() {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		textArea = new JTextArea();
		add(new JScrollPane(textArea));
		setSize(DEFAULT_WIDTH, DEFALUT_HEIGHT);
		statusLine = new JLabel();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("File");
		menu.add(menu);

		openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					readFile(chooser.getSelectedFile());
				}
			}
		});

		cancelItem = new JMenuItem("Cancel");
		menu.add(cancelItem);
		cancelItem.setEnabled(false);
		cancelItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (workerThread != null)
					workerThread.interrupt();
			}
		});
	}

	public void readFile(final File file) {

		Runnable task = new SwingWorkerTask() {

			@Override
			public void init() {
				lineNumber = 0;
				openItem.setEnabled(false);
				cancelItem.setEnabled(true);
			}

			@Override
			public void update() {
				statusLine.setText("" + lineNumber);
			}

			@Override
			public void finish() {
				workerThread = null;
				openItem.setEnabled(true);
				cancelItem.setEnabled(false);
				statusLine.setText("Done");
			}

			@Override
			public void work() {
				try {
					Scanner in = new Scanner(new FileInputStream(file));
					textArea.setText("");
					while (!Thread.currentThread().isInterrupted() && in.hasNext()) {
						lineNumber++;
						line = in.nextLine();
						textArea.append(line);
						textArea.append("\n");
						doUpdate();
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "" + e);
				}
			}

			private int lineNumber;
			private String line;
		};
		workerThread = new Thread(task);
		workerThread.start();
	}
}
