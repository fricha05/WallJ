package fr.umlv.data.canvas;

public class Wall extends Element{
	public Wall(int posX, int posY) {
		super(posX, posY);
	}
	
	@Override
	public String toString() {
		return "W";
	}
}
