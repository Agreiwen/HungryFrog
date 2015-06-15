package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class BlocLigne extends Bloc{
	
	public BlocLigne(int x ,int y){
		super(x , y, 50, 6);
		texture = new Texture("blanc.jpg");
	}

}
