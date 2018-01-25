package fr.umlv.data.Main;

import java.awt.Color;
//import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.*;
import fr.umlv.data.Canvas.*;
import fr.umlv.zen5.*;

public class Main {	
	
    static class Area{
//    	private Ellipse2D.Float ellipse = new Ellipse2D.Float(0, 0, 0, 0);
    	private Rectangle2D.Float rectangle = new Rectangle2D.Float(0, 0, 0, 0);
    	
//    	void draw(ApplicationContext context, float x, float y) {
//    		ScreenInfo screenInfo = context.getScreenInfo();
//    	    float width = screenInfo.getWidth();
//    	    float height = screenInfo.getHeight();
//    	    float sizeElementX = width/58;
//    	    float sizeElementY = height/13;
//    	      context.renderFrame(graphics -> {
//    	        // hide the previous rectangle
//    	        graphics.setColor(Color.ORANGE);
//    	        graphics.fill(ellipse);
//    	        
//    	        // show a new ellipse at the position of the pointer
//    	        graphics.setColor(Color.MAGENTA);
//    	        rectangle = new Rectangle2D.Float(sizeElementY, sizeElementX, x, y);
//    	        graphics.fill(ellipse);
//    	      });
//    	    }

	void drawTable(ApplicationContext context, Level lvl) {		
			for (int i = 0; i < lvl.nbLine ; i++) {
				for (int j = 0; j < lvl.nbCol; j++) {
					final Element e = lvl.getLvl()[i][j];
					if(e != null) {
						String s = e.toString();
						if(s == "W"){
							context.renderFrame(graphics -> {
								graphics.setColor(Color.ORANGE);
			        			rectangle = new Rectangle2D.Float(e.getPosY() * 23, e.getPosX() * 57, 23, 57);
			        			graphics.fill(rectangle);
				    	    });						
						}
						if(s == "T") {
							context.renderFrame(graphics -> {
								graphics.setColor(Color.BLUE);
		    	        		rectangle = new Rectangle2D.Float(e.getPosY() * 23, e.getPosX() * 57, 23, 57);
		    	        		graphics.fill(rectangle);
							});
						}
						if(s == "G") {
							if(((Garbage)e).getStatus()) {
								context.renderFrame(graphics -> {
									graphics.setColor(Color.RED);
				        			rectangle = new Rectangle2D.Float(e.getPosY() * 23, e.getPosX() * 57, 23, 57);
				        			graphics.fill(rectangle);
								});
							}
						}
						if(s == "R") {
							context.renderFrame(graphics -> {
								graphics.setColor(Color.GREEN);
			        			rectangle = new Rectangle2D.Float(e.getPosY() * 23, e.getPosX() * 57, 23, 57);
			        			graphics.fill(rectangle);
							});
						}
					}
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		Level lvl1 = new Level(13, 58);
		String lvlpath = "/home/florian/eclipse-workspace/Wall-J/files/lvl1.txt";
		lvl1.initializelvl(lvlpath);
		System.out.println(lvl1.isValid());
		System.out.println(lvl1);
		Application.run(Color.BLACK, context ->{
			ScreenInfo screenInfo = context.getScreenInfo();
		    float width = screenInfo.getWidth();
		    float height = screenInfo.getHeight();
		    System.out.println("size of the screen (" + width + " x " + height + ")");
		    context.renderFrame(graphics -> {
		        graphics.setColor(Color.DARK_GRAY);
		        graphics.fill(new  Rectangle2D.Float(0, 0, width, height));
		    });
		    if(lvl1.isValid()) {
		    	Area area = new Area();
				area.drawTable(context, lvl1);
		    }
		    else {
		    	System.out.println("Le niveau n'est pas valide.");
		    }
		});
		
	}
}
