package pathfinding;

import fr.umlv.data.canvas.Element;

public class Node {
	private final Element current;
	private Node parent;
	private final float costStart;
	private final float costDest;
	private final float quality;
	
	public Node(Element current, Element start, Element end, Node parent) {
		this.current = current;
		this.costStart = Math.abs(current.getPosX() - start.getPosX()) + Math.abs(current.getPosY() - start.getPosY());
		this.costDest = Math.abs(end.getPosX() - current.getPosX()) + Math.abs(end.getPosY() - current.getPosY());
		this.quality = costStart + costDest;
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return "Parent : " + this.parent + "; Current : " + this.current + "; Cost to Start : " + this.costStart + "; Cost to dest : " + this.costDest + "; Quality : " + this.quality;
	}
}