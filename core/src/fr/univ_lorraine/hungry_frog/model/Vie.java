package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class Vie extends Bloc{

	public Vie(int x, int y) {
		super(x, y, 30, 30);
		// TODO Auto-generated constructor stub
		texture = new Texture("life.png");
	}

}
