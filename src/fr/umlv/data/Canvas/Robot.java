package fr.umlv.data.Canvas;

public class Robot extends Element{
	public Robot(int startPosX, int startPosY) {
		super(startPosX, startPosY);
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	public void moveUp() {
		this.setPosY(this.getPosY() - 1);
	}
	
	public void moveRight() {
		this.setPosX(this.getPosX() + 1);
	}
	
	public void moveLeft() {
		this.setPosX(this.getPosX() - 1);
	}
	
	public void moveDown() {
		this.setPosY(this.getPosY() + 1);
	}
	
	public void hide() {
		
	}
	
	public void dropBomb() {
		//pose la bombe
		//se cache
		//fait bouger les Garbage
	}
	
	public void findPath() {
		
	}
	
	public void moveOnPath() {
		
	}
}