package BEPaint.main;

import java.awt.Color;

import javax.swing.JFrame;

import BEPaint.gui.main.PaintingPanel;

public class BEPaint extends JFrame {
	PaintingPanel panel;
	
	public BEPaint(String title, int width, int height) {
		this.initialize(title, width, height);
	}
	
	private void initialize(String title, int width, int height) {
		this.panel = new PaintingPanel();
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.panel.setFocusable(true);
		
		this.add(this.panel);
		
		this.setVisible(true);
	}
	
	public static void main(String args[]) {
		BEPaint obj = new BEPaint("BEPaint - Author: Dung Harry. Copyright 2013 - All rights reserved", PaintingPanel.PANEL_WIDTH, PaintingPanel.PANEL_HEIGHT);
	}
}
