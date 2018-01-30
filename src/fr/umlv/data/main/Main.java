package fr.umlv.data.main;

import java.awt.Color;
//import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.*;
import fr.umlv.data.canvas.*;
import fr.umlv.data.graphics.Display;
import fr.umlv.zen5.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Level lvl1 = new Level(13, 58);
		String lvlpath = "/home/florian/eclipse-workspace/WallJ/files/lvl1.txt";
		lvl1.initializelvl(lvlpath);
		System.out.println(lvl1.isValid());
		System.out.println(lvl1);
		Application.run(Color.BLACK, context ->{
			ScreenInfo screenInfo = context.getScreenInfo();
		    float width = screenInfo.getWidth();
		    float height = screenInfo.getHeight();
		    System.out.println("size of the screen (" + width + " x " + height + ")");
		    context.renderFrame(graphics -> {
		        graphics.setColor(Color.YELLOW);
		        graphics.fill(new  Rectangle2D.Float(0, 0, width, height));
		    });
		    if(lvl1.isValid()) {
		    	Display area = new Display();
		    	int heightElem = (int)(height/13);
		    	int widthElem = (int)(width/58);
		    	((Robot) lvl1.getLvl()[2][1]).moveUp(lvl1);
		    	lvl1.refreshLvl();
		    	System.out.println(lvl1);
				area.drawTable(context, lvl1, heightElem, widthElem);
		    }
		    else {
		    	System.out.println("Le niveau n'est pas valide.");
		    }
		});
		
		
	}
}
