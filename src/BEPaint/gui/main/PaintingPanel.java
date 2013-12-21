package BEPaint.gui.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import BEPaint.control.main.ImageHandler;
import BEPaint.control.main.LinePainting;
import BEPaint.control.main.OvalPainting;
import BEPaint.control.main.RectanglePainting;
import BEPaint.gui.interfaces.MainPanel;
import BEPaint.model.interfaces.ColorKey;
import BEPaint.model.interfaces.ShapeKey;
import BEPaint.model.main.LineData;
import BEPaint.model.main.ShapeData;

public class PaintingPanel extends JPanel implements MainPanel {
	private ColorKey colorDrawing;
	private ShapeKey shapeDrawing;
	private ShapeData shapeData;
	private LineData lineData;
	private LinePainting line;
	private OvalPainting oval;
	private RectanglePainting rectangle;
	private ImageHandler imgHandler;
	
	public PaintingPanel() {
		this.initialize();
		this.addController();
	}
	
	private void initialize() {
		this.colorDrawing = ColorKey.BEPAINT_BLUE;
		this.shapeDrawing = ShapeKey.BEPAINT_RECTANGLE;
		this.shapeData = new ShapeData();
		this.lineData = new LineData();
		this.line = new LinePainting();
		this.rectangle = new RectanglePainting();
		this.oval = new OvalPainting();
		this.imgHandler = new ImageHandler();
	}
	
	private void addController() {
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(shapeDrawing == ShapeKey.BEPAINT_LINE) {
					setLineData(new LineData(e.getX(), e.getY(), e.getX(), e.getY(), lineData.getColor()));
				} else {
					setShapeData(new ShapeData(e.getX(), e.getY(), 0, 0, shapeData.getColor()));
				}
			};
			
			public void mouseReleased(MouseEvent e) {
				if(shapeDrawing == ShapeKey.BEPAINT_OVAL) {
					setShapeData(new ShapeData(shapeData.getX(), shapeData.getY(), e.getX() - shapeData.getX(), e.getY() - shapeData.getY(), shapeData.getColor()));
				}
				
				repaint();
			};
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x1 = lineData.getX2();
				int y1 = lineData.getY2();
				
				if(shapeDrawing == ShapeKey.BEPAINT_LINE) {
					setLineData(new LineData(x1, y1, e.getX(), e.getY(), lineData.getColor()));
				} else if(shapeDrawing == ShapeKey.BEPAINT_RECTANGLE) {
					setShapeData(new ShapeData(shapeData.getX(), shapeData.getY(), e.getX() - shapeData.getX(), e.getY() - shapeData.getY(), shapeData.getColor()));
				}
				
				repaint();
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_1: setColorDrawing(ColorKey.BEPAINT_BLACK);
						break;
						
					case KeyEvent.VK_2: setColorDrawing(ColorKey.BEPAINT_WHITE);
						break;
					
					case KeyEvent.VK_3: setColorDrawing(ColorKey.BEPAINT_BLUE);
						break;
						
					case KeyEvent.VK_4: setColorDrawing(ColorKey.BEPAINT_GREEN);
						break;
						
					case KeyEvent.VK_5: setColorDrawing(ColorKey.BEPAINT_RED);
						break;
						
					case KeyEvent.VK_6: setColorDrawing(ColorKey.BEPAINT_YELLOW);
						break;
						
					case KeyEvent.VK_L: setTypeDrawing(ShapeKey.BEPAINT_LINE);
						break;
						
					case KeyEvent.VK_O: setTypeDrawing(ShapeKey.BEPAINT_OVAL);
						break;
						
					case KeyEvent.VK_R: setTypeDrawing(ShapeKey.BEPAINT_RECTANGLE);
						break;
						
					case KeyEvent.VK_S: imgHandler.saveImage(getItself());
						break;
						
					default:
						break;
				}
			}
		});
	}
	
	private JPanel getItself() {
		return this;
	}
	
	@Override
	public ShapeData getShapeData() {
		return this.shapeData;
	}

	@Override
	public void setShapeData(ShapeData sd) {
		this.shapeData.setX(sd.getX());
		this.shapeData.setY(sd.getY());
		this.shapeData.setColor(sd.getColor());
		this.shapeData.setHeight(sd.getHeight());
		this.shapeData.setWidth(sd.getWidth());
	}

	@Override
	public LineData getLineData() {
		return this.lineData;
	}

	@Override
	public void setLineData(LineData ld) {
		this.lineData.setColor(ld.getColor());
		this.lineData.setX1(ld.getX1());
		this.lineData.setX2(ld.getX2());
		this.lineData.setY1(ld.getY1());
		this.lineData.setY2(ld.getY2());
	}

	@Override
	public void setTypeDrawing(ShapeKey key) {
		this.shapeDrawing = key;
	}

	@Override
	public void setColorDrawing(ColorKey key) {
		this.colorDrawing = key;
		
		if(this.colorDrawing == ColorKey.BEPAINT_BLACK) {
			this.lineData.setColor(Color.black);
			this.shapeData.setColor(Color.black);
		} else if(this.colorDrawing == ColorKey.BEPAINT_BLUE) {
			this.lineData.setColor(Color.blue);
			this.shapeData.setColor(Color.blue);
		} else if(this.colorDrawing == ColorKey.BEPAINT_GREEN) {
			this.lineData.setColor(Color.green);
			this.shapeData.setColor(Color.green);
		} else if(this.colorDrawing == ColorKey.BEPAINT_RED) {
			this.lineData.setColor(Color.red);
			this.shapeData.setColor(Color.red);
		} else if(this.colorDrawing == ColorKey.BEPAINT_YELLOW) {
			this.lineData.setColor(Color.yellow);
			this.shapeData.setColor(Color.yellow);
		} else if(this.colorDrawing == ColorKey.BEPAINT_WHITE) {
			this.lineData.setColor(Color.white);
			this.shapeData.setColor(Color.white);
		}
	}
	
	public void paintComponent(Graphics g) {
		if(this.shapeDrawing == ShapeKey.BEPAINT_LINE) {
			this.line.initialize(this.lineData.getX1(), this.lineData.getY1(), this.lineData.getX2(), this.lineData.getY2(), this.lineData.getColor());
			
			this.line.drawLine(g);
		} else if(this.shapeDrawing == ShapeKey.BEPAINT_OVAL) {
			this.oval.initialize(this.shapeData.getX(), this.shapeData.getY(), this.shapeData.getWidth(), this.shapeData.getHeight(), this.shapeData.getColor());
		
			this.oval.paintOval(g);
		} else if(this.shapeDrawing == ShapeKey.BEPAINT_RECTANGLE) {
			this.rectangle.initialize(this.shapeData.getX(), this.shapeData.getY(), this.shapeData.getWidth(), this.shapeData.getHeight(), this.shapeData.getColor());
		
			this.rectangle.drawRectangle(g);
		}
	}
	
}
