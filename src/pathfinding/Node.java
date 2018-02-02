package pathfinding;

import fr.umlv.data.canvas.Element;

public class Node {
	private final Element current;
	private Node parent;
	private float costStart;
	private float costDest;
	private float quality;
	
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
	
	public void setCostStart(Element start) {
		this.costStart = Math.abs(current.getPosX() - start.getPosX()) + Math.abs(current.getPosY() - start.getPosY());
	}
	
	public Element getCurrent() {
		return this.current;
	}
	
	public float getCostDest() {
		return this.costDest;
	}
	
	public void setCostDest(Element end) {
		this.costDest = Math.abs(end.getPosX() - current.getPosX()) + Math.abs(end.getPosY() - current.getPosY());
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
//		return "Parent : " + this.parent + "; Current : " + this.current + "; Cost to Start : " + this.costStart + "; Cost to dest : " + this.costDest + "; Quality : " + this.quality;
		return "{" + this.current.getPosX() + "," + this.current.getPosY() + "}";
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
