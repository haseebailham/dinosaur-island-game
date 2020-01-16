package edu.ben.visual;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 * Progress bar customization.
 * 
 * @author haseebailham
 * @version 1.0
 */
public class ProgressBar extends BasicProgressBarUI {

	/**
	 * Rectangle object
	 */
	Rectangle rec = new Rectangle();

	/**
	 * Customizes the progress bar using graphics.
	 */
	@Override
	protected void paintIndeterminate(Graphics g, JComponent c) {
		rec = getBox(rec);
		g.fillOval(rec.x, rec.y, rec.width, rec.height);
		g.setColor(progressBar.getForeground());
	}
}
