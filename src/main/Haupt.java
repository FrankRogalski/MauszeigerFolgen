package main;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class Haupt {
	private final JFrame oberflaeche = new JFrame("Beispiel JFrame");
	private final JPanel panel = new JPanel();
	private final JButton button = new JButton("(✿ ◕‿◕) ᓄ✂╰U╯");
	private int x = 0, y = 0;
	
	public final void haupt() {
		oberflaeche.setLocationRelativeTo(oberflaeche);
		oberflaeche.setPreferredSize(new Dimension(700, 700));
		oberflaeche.setResizable(false);
		
		panel.add(button);
		oberflaeche.add(panel);
		
		button.setEnabled(false);
		button.setLocation(oberflaeche.getWidth() / 2, oberflaeche.getHeight() / 2);
		
		oberflaeche.pack();
		oberflaeche.setVisible(true);
		
		panel.addMouseMotionListener(new MouseMotionAdapter() {
            public final void mouseMoved(final MouseEvent e) {
            	x = e.getX() - button.getWidth() / 2;
            	y = e.getY() - button.getHeight() / 2;
            }
        });
		int xDistance, yDistance;
		double distance;
		final int max = 5;
		
		while (oberflaeche.isShowing()) {
			try {
				Thread.sleep(10);
			} catch (final Exception ex) { }
			xDistance = x - button.getX();
			yDistance = y - button.getY();
			distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
			if (distance != 0) {
				/*if (xDistance > max) {
					xDistance = max;
				} else if (xDistance < max * -1) {
					xDistance = max * -1;
				}
				
				if (yDistance > max) {
					yDistance = max;
				} else if (yDistance < max * -1) {
					yDistance = max * -1;
				}*/
				xDistance = (int) (button.getX() + xDistance * 0.05);
				yDistance = (int) (button.getY() + yDistance * 0.05);
				button.setLocation(xDistance, yDistance);
				//panel.repaint();
			}
		}
	}
}