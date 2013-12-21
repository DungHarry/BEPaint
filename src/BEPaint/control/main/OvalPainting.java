package BEPaint.control.main;

import java.awt.Color;
import java.awt.Graphics;

import BEPaint.control.interfaces.Oval;

public class OvalPainting extends ShapeBased implements Oval {
	public OvalPainting(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
	
	public OvalPainting() {
		super();
	}
	
	@Override
	public void paintOval(Graphics g) {
		g.setColor(this.getColor());
		g.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

}
