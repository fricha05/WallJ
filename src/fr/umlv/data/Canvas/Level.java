package fr.umlv.data.Canvas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


// LevelDAO dao = new FileLevelDAO();
// create read Game
public class Level {
	public final int nbLine;
	public final int nbCol;
	private Element lvl[][];
	
	public Level(int nbLine, int nbCol) {
		this.nbLine = nbLine;
		this.nbCol = nbCol;
		lvl = new Element[nbLine][nbCol];
	}
	
	public Element[][] getLvl() {
		return this.lvl;
	}//classe d'accès aux données, il faut penser ça comme une couche avec accès aux données, une partie métiers, une partie interface
	
	public void initializelvl(String lvlpath) throws IOException {
		int Line = 0;
		int Col = 0;
		BufferedReader br = null;
		try {//initialisation du br avec Java 8 pour close
			br = new BufferedReader(new FileReader(lvlpath));
			int currentChar;
			while((currentChar = br.read()) != -1) {
				char c = (char)currentChar;
				if(c == '\n') {
					Col = 0;
					Line++;
				}
				else if(c == 'W'){
					this.lvl[Line][Col] = new Wall(Line, Col);
					Col++;
				}
				else if(c == 'T') {
					this.lvl[Line][Col] = new Trashcan(Line, Col);
					Col++;
				}
				else if(c == 'G') {
					this.lvl[Line][Col] = new Garbage(Line, Col);
					Col++;
				}
				else if(c == 'R') {
					this.lvl[Line][Col] = new Robot(Line, Col);
					Col++;
				}
				else if(c == ' ') {
					Col++;
				}
				else {
					throw new IOException("Niveau invalide");
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			br.close();
		}
	}
	
	public boolean isValid() {
		for (int i = 0; i < this.nbLine; i++) {
			for (int j = 0; j < this.nbCol; j++) {
				Element e = this.lvl[i][j];
				if(e != null) {
					String s = e.toString();
					if (s != "W" && s != "G" && s != "T" && s != "R") {
						return false;
					}
				}
			}
		}
		
		for (int i = 0; i < this.nbCol; i++) {
			Element e = this.lvl[0][i];
			if(e != null) {
				if((this.lvl[0][i].toString() != "W" && this.lvl[0][i].toString() != "T") || (this.lvl[this.nbLine-1][i].toString() != "W" && this.lvl[this.nbLine-1][i].toString() != "T")) {
					return false;
				}
			}
			else {
				return false;
			}
		}
		for(int i = 0; i < this.nbLine; i++) {
			Element e = this.lvl[i][nbCol-1];
			if(e != null) {
				if((this.lvl[i][0].toString() != "W" && this.lvl[i][0].toString() != "T") || (this.lvl[i][nbCol-1].toString() != "W" && this.lvl[i][nbCol-1].toString() != "T")) {
					return false;
				}
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < this.nbLine; i++) {
			for(int j = 0; j < this.nbCol; j++) {
				if(this.lvl[i][j] != null) {
					str = str + this.lvl[i][j];
				}
				else {
					str = str + " ";
				}
			}
			str = str + "\n";
		}
		return str;
	}
}
