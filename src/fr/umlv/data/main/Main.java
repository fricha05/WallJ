package fr.umlv.data.main;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fr.umlv.data.canvas.Level;
import fr.umlv.data.canvas.Robot;
import fr.umlv.data.graphics.Display;
import fr.umlv.data.pathfinding.Node;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.ScreenInfo;

public class Main {
	
	public static Node[][] initNodeMap(Level lvl, Node start, Node end) {
		Node[][] nodeTab = new Node[lvl.nbLine][lvl.nbCol];
		for (int i = 0; i < lvl.nbLine ; i++) {
			for (int j = 0; j < lvl.nbCol; j++) {
				final String s = lvl.getLvl()[i][j].toString();
				if(s == " "){
					nodeTab[i][j] = new Node(lvl.getLvl()[i][j], start.getCurrent(), end.getCurrent(), null);
				}
				else if(s == " " && lvl.getLvl()[i][j].equals(end.getCurrent())) {
					nodeTab[i][j] = end;
				}
				else if(s == "R") {
					nodeTab[i][j] = start;
				}
				else {
					nodeTab[i][j] = null;
				}
			}
		}
		return nodeTab;
	}
	
	public static Node getLowest(ArrayList<Node> list) {
		Node lowest = list.get(0);
		for(int i = 0; i < list.size() - 1; i++) {
			if(list.get(i).getCostStart() > list.get(i+1).getCostStart()) {
				lowest = list.get(i+1);
			}
		}
		return lowest;
	}
	
	public static List<Node> calcPath(Node start, Node goal){
		LinkedList<Node> path = new LinkedList<Node>();
		
		Node curr = goal;
		boolean done = false;
		while(!done) {
			path.addFirst(curr);
			if(curr.getParent() == start) {
				done = true;
			}
			curr = curr.getParent();
		}
		return path;
		
	}
	
	public static ArrayList<Node> getNeighbors(Node[][] nodeMap, Node current){
		ArrayList<Node> neighbors = new ArrayList<Node>();
		if(nodeMap[current.getCurrent().getPosX() +1][current.getCurrent().getPosY()]!=null) {
			neighbors.add(nodeMap[current.getCurrent().getPosX() +1][current.getCurrent().getPosY()]);
		}
		if(nodeMap[current.getCurrent().getPosX()][current.getCurrent().getPosY() +1]!=null) {
			neighbors.add(nodeMap[current.getCurrent().getPosX()][current.getCurrent().getPosY() +1]);
		}
		if(nodeMap[current.getCurrent().getPosX() -1][current.getCurrent().getPosY()]!=null) {
			neighbors.add(nodeMap[current.getCurrent().getPosX() -1][current.getCurrent().getPosY()]);
		}
		if(nodeMap[current.getCurrent().getPosX()][current.getCurrent().getPosY() -1]!=null) {
			neighbors.add(nodeMap[current.getCurrent().getPosX()][current.getCurrent().getPosY() -1]);
		}
		
		return neighbors;
	}
	
	public static void printNodeMap(Node[][] nodeMap) {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 58; j++) {
				if(nodeMap[i][j] == null) {
					System.out.print("N");
				}
				else if(nodeMap[i][j].getCurrent().toString() == " ") {
					System.out.print(" ");
				}
				else if(nodeMap[i][j].getCurrent().toString() == "R") {
					System.out.print("R");
				}
			}
			System.out.println();
		}
	}
	
	public final static List<Node> findPath(Node start, Node goal, Level lvl) {
		Node[][] nodeMap = initNodeMap(lvl, start, goal);
		printNodeMap(nodeMap);
		ArrayList<Node> openList = new ArrayList<Node>();
		ArrayList<Node> closedList = new ArrayList<Node>();
		openList.add(start);
		
		boolean done = false;
		Node current;
		while(!done) {
			current = getLowest(openList);
			closedList.add(current);
			openList.remove(current);
			if((current.equals(goal))) {
				System.out.println(current.getParent().getParent().getParent().getParent());
				return calcPath(start, current);
			}
			
			ArrayList<Node> neighbors = getNeighbors(nodeMap, current);
			for(int i = 0; i < neighbors.size(); i++) {
				Node currNeighbor = neighbors.get(i);
				if(!openList.contains(currNeighbor)) {
					currNeighbor.setParent(current);
					currNeighbor.setCostStart(current.getCostStart() + 1);
					openList.add(currNeighbor);
				}
				else {
					if(currNeighbor.getCostStart() > current.getCostStart() + 1) {
						currNeighbor.setParent(current);
						currNeighbor.setCostStart(current);	
					}
				}
			}
			if(openList.isEmpty()) {
				return new LinkedList<Node>();
			}
		}
		System.out.println("Point non accessible");
		return null; //non accessible
		
		
		
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		Level lvl1 = new Level(13, 58);
		String lvlpath = "files/lvl1.txt";
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
				area.drawTable(context, lvl1, heightElem, widthElem);
		    	
		    }
		    else {
		    	System.out.println("Le niveau n'est pas valide.");
		    }
		});
//		Node start = new Node(lvl1.findRobot(), lvl1.findRobot(), lvl1.getLvl()[2][10], null);
//		Node end = new Node(lvl1.getLvl()[2][10], lvl1.findRobot(), lvl1.getLvl()[2][10], null);
//		List<Node> path = findPath(start, end, lvl1);
//		System.out.println(path);
	}
}
