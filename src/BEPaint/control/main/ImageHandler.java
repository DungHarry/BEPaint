package BEPaint.control.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.annotation.processing.FilerException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import BEPaint.control.interfaces.ImageITF;
import BEPaint.gui.main.PaintingPanel;

public class ImageHandler implements ImageITF {

	@Override
	public void saveImage(JPanel panel) {
		BufferedImage bufferImg = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferImg.getGraphics();
		JFileChooser chooser = new JFileChooser();
		
		panel.printAll(g);
		g.drawImage(bufferImg, 0, 0, panel.getWidth(), panel.getHeight(), null);
		chooser.setFileFilter(new FileNameExtensionFilter("JPG Images", "jpg"));
		
		int result = chooser.showSaveDialog(null);
		
		if(result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			
			try {
				ImageIO.write(bufferImg, "jpg", file);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
