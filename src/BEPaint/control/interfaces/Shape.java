package BEPaint.control.interfaces;

import java.awt.Color;

public interface Shape {
	public void initialize(int x, int y, int width, int height, Color color);
	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public void setWidth(int width);
	public void setHeight(int height);
	public int getWidth();
	public int getHeight();
	public Color getColor();
	public void setColor(Color color);
}
