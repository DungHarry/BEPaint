package BEPaint.control.main;

import java.awt.Color;

import BEPaint.control.interfaces.Shape;

public class ShapeBased implements Shape {
	private int x, y, width, height;
	private Color color;
	
	public ShapeBased(int x, int y, int width, int height, Color color) {
		this.initialize(x, y, width, height, color);
	}
	
	public ShapeBased() {
		this.initialize(0, 0, 0, 0, Color.white);
	}
	
	public void initialize(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.color = color;
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

}
