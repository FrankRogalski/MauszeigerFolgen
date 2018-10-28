package main;

import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Kreis extends JComponent{

	@Override
	public void paintComponent(Graphics g) {
		g.drawOval(10, 10, 100, 101);
	}
}