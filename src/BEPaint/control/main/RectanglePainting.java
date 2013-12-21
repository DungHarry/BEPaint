package BEPaint.control.main;

import java.awt.Color;
import java.awt.Graphics;

import BEPaint.control.interfaces.Rectangle;

public class RectanglePainting extends ShapeBased implements Rectangle {
	public RectanglePainting(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
	
	public RectanglePainting() {
		super();
	}

	@Override
	public void drawRectangle(Graphics g) {
		g.setColor(this.getColor());
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

}
