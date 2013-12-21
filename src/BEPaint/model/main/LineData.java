package BEPaint.model.main;

import java.awt.Color;

import BEPaint.model.interfaces.LineModel;

public class LineData implements LineModel {
	private int x1, x2, y1, y2;
	private Color color;

	public LineData(int x1, int y1, int x2, int y2, Color color) {
		this.initialize(x1, y1, x2, y2, color);
	}
	
	public LineData() {
		this.initialize(0, 0, 0, 0, Color.BLUE);
	}
	
	@Override
	public void initialize(int x1, int y1, int x2, int y2, Color color) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;
	}

	@Override
	public int getX1() {
		return this.x1;
	}

	@Override
	public int getX2() {
		return this.x2;
	}

	@Override
	public int getY1() {
		return this.y1;
	}

	@Override
	public int getY2() {
		return this.y2;
	}

	@Override
	public void setX1(int x1) {
		this.x1 = x1;
	}

	@Override
	public void setX2(int x2) {
		this.x2 = x2;
	}

	@Override
	public void setY1(int y1) {
		this.y1 = y1;
	}

	@Override
	public void setY2(int y2) {
		this.y2 = y2;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

}
