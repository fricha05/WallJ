package fr.umlv.data.Canvas;

public class Garbage extends Element{
	private boolean isAlive;
	
	public Garbage(int posX, int posY) {
		super(posX, posY);
		this.isAlive = true;
	}
	
	public void delete() {
		//si dans une Trashcan
		this.isAlive = false;
	}
	
	public boolean getStatus() {
		return this.isAlive;
	}
	
	@Override
	public String toString() {
		return "G";
	}
	
	public void move() {
		
	}
	
	public Wall isNearWall() {
		return new Wall(0, 0);//provisoire
	}
	
	public Garbage isNearGarbage() {
		return new Garbage(0, 0);//provisoire
	}
}
