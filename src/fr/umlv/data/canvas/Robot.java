package fr.umlv.data.canvas;

public class Robot extends Element{
	public Robot(int startPosX, int startPosY) {
		super(startPosX, startPosY);
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	public void moveUp(Level lvl) {
		Empty e = new Empty(this.getPosX(), this.getPosY());
		lvl.getLvl()[this.getPosX()][this.getPosY()] = e;
		
		this.setPosX(this.getPosX() - 1);
		lvl.getLvl()[this.getPosX()][this.getPosY()] = this;
	}
	
	public void moveRight() {
		this.setPosY(this.getPosY() + 1);
	}
	
	public void moveLeft() {
		this.setPosY(this.getPosY() - 1);
	}
	
	public void moveDown() {
		this.setPosX(this.getPosX() + 1);
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