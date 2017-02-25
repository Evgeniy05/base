package com.exmaples.factory;

import javax.swing.JFrame;

public class SwingApplication {
	public static void main(String[] args) throws Exception {
		JFrame frame = new SwingWorkerFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
