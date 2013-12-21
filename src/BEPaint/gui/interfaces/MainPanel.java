package BEPaint.gui.interfaces;

import BEPaint.model.interfaces.ColorKey;
import BEPaint.model.interfaces.ShapeKey;
import BEPaint.model.main.LineData;
import BEPaint.model.main.ShapeData;

public interface MainPanel {
	public static final int PANEL_WIDTH = 1024;
	public static final int PANEL_HEIGHT = 680;
	
	public ShapeData getShapeData();
	public void setShapeData(ShapeData sd);
	public LineData getLineData();
	public void setLineData(LineData ld);
	public void setTypeDrawing(ShapeKey key);
	public void setColorDrawing(ColorKey key);
}
