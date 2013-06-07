package main;

import java.awt.Dimension;
import java.awt.EventQueue;

import gui.*;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import core.Ged;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow1 window = new MainWindow1();
					window.frmGed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
