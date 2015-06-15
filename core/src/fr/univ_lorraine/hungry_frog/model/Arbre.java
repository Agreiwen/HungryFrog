package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class Arbre extends Bloc{

	public Arbre(int x, int y) {
		super(x, y, 60, 60);
		// TODO Auto-generated constructor stub
		texture = new Texture("arbre.png");
	}

}
