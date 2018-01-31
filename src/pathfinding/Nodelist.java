package pathfinding;

import java.util.ArrayList;

public class Nodelist {
	private ArrayList<Node> list;
	
	public Nodelist(Node first) {
		this.list = new ArrayList<Node>();
		this.list.add(first);
	}
	
	@Override
	public String toString() {
		return "" + this.list;
	}
}
