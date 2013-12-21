package BEPaint.model.interfaces;

import java.awt.Color;

public interface LineModel {
	public void initialize(int x1, int y1, int x2, int y2, Color color);
	public int getX1();
	public int getX2();
	public int getY1();
	public int getY2();
	public void setX1(int x1);
	public void setX2(int x2);
	public void setY1(int y1);
	public void setY2(int y2);
	public void setColor(Color color);
	public Color getColor();
}
