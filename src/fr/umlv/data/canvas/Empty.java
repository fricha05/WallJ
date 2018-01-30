package fr.umlv.data.canvas;

public class Empty extends Element{
	public Empty(int posX, int posY) {
		super(posX, posY);
	}
	
	@Override
	public String toString() {
		return " ";
	}
}
