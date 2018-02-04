package fr.umlv.data.pathfinding;

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
	
	public void setCostStart(float costStart) {
		this.costStart = costStart;
	}
	
	public void setCostStart(Node current) {
		this.costStart = current.getCostStart() + 1;
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
	
	public void setQuality() {
		this.quality = costStart + costDest;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public float calcDistCost(Node n) {
		return Math.abs(current.getPosX() - n.getCurrent().getPosX()) + Math.abs(current.getPosY() - n.getCurrent().getPosY()) + n.getCostStart();
	}
	
	@Override
	public String toString() {
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
