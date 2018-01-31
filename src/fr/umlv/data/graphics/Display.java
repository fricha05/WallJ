package fr.umlv.data.graphics;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.umlv.data.canvas.Element;
import fr.umlv.data.canvas.Garbage;
import fr.umlv.data.canvas.Level;
import fr.umlv.zen5.ApplicationContext;

public class Display {
	private Rectangle2D.Float rectangle;
	
	public Display() {
		rectangle = new Rectangle2D.Float(0, 0, 0, 0);
	}
	
	public void drawTable(ApplicationContext context, Level lvl, int heightElem, int widthElem) {
		for (int i = 0; i < lvl.nbLine ; i++) {
			for (int j = 0; j < lvl.nbCol; j++) {
				final Element e = lvl.getLvl()[i][j];
				if(e != null) {
					String s = e.toString();
					if(s == "W"){
						context.renderFrame(graphics -> {
//							graphics.setColor(Color.ORANGE);
//		        			rectangle = new Rectangle2D.Float(e.getPosY() * heightElem, e.getPosX() * widthElem, heightElem, widthElem);
//		        			graphics.fill(rectangle);
		        			BufferedImage img;
							try {
								img = ImageIO.read(new File("files/wall.gif"));
								graphics.drawImage(img, e.getPosY() * widthElem, e.getPosX() * heightElem, e.getPosY() * widthElem + widthElem, e.getPosX() * heightElem + heightElem, 0, 0, 150, 150, null);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			    	    });						
					}
					if(s == "T") {
						context.renderFrame(graphics -> {
							graphics.setColor(Color.BLUE);
	    	        		rectangle = new Rectangle2D.Float(e.getPosY() * widthElem, e.getPosX() * heightElem, widthElem, heightElem);
	    	        		graphics.fill(rectangle);
						});
					}
					if(s == "G") {
						if(((Garbage)e).getStatus()) {
							context.renderFrame(graphics -> {
								graphics.setColor(Color.RED);
			        			rectangle = new Rectangle2D.Float(e.getPosY() * widthElem, e.getPosX() * heightElem, widthElem, heightElem);
			        			graphics.fill(rectangle);
							});
						}
					}
					if(s == "R") {
						context.renderFrame(graphics -> {
//							graphics.setColor(Color.GREEN);
//		        			rectangle = new Rectangle2D.Float(e.getPosY() * heightElem, e.getPosX() * widthElem, heightElem, widthElem);
//		        			graphics.fill(rectangle);
		        			BufferedImage img;
							try {
								img = ImageIO.read(new File("files/wallj.png"));
								graphics.drawImage(img, e.getPosY() * widthElem, e.getPosX() * heightElem, e.getPosY() * widthElem + widthElem, e.getPosX() * heightElem + heightElem, 0, 0, 1484, 2847, null);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						});
					}
				}
			}
		}
	}

}
