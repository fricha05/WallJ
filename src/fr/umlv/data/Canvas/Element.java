package fr.umlv.data.Canvas;

public abstract class Element {
	private int posX;
	private int posY;
	//mail : katiaaresti@gmail.com karesti
	public Element(int posX, int posY) {
		this.setPosX(posX);
		this.setPosY(posY);
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}
}
