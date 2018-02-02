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
	
	public float getCostStart() {
		return this.costStart;
	}
	
	public Element getCurrent() {
		return this.current;
	}
	
	public float getCostDest() {
		return this.costDest;
	}
	
	public float getQuality() {
		return this.quality;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return "Parent : " + this.parent + "; Current : " + this.current + "; Cost to Start : " + this.costStart + "; Cost to dest : " + this.costDest + "; Quality : " + this.quality;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() == this.getClass()) {
			Node n = (Node)o;
			if(n.current.getPosX() == this.current.getPosX() && n.current.getPosY() == this.current.getPosY()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.hashCode() ^ this.current.hashCode();
	}
}
