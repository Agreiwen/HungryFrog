package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class BlocEntreLigne extends Bloc{
	
	public BlocEntreLigne(int x, int y){
		super(x , y, 50, 8);
		texture = new Texture("route.jpg");
	}

}
