package BEPaint.model.main;

import java.awt.Color;

import BEPaint.model.interfaces.ShapeModel;

public class ShapeData implements ShapeModel {
	private int x, y, height, width;
	private Color color;
	
	public ShapeData(int x, int y, int width, int height, Color color) {
		this.initialize(x, y, width, height, color);
	}
	
	public ShapeData() {
		this.initialize(0, 0, 0, 0, Color.BLUE);
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
