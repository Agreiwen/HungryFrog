package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class BlocHerbe extends Bloc{
	
	
	public BlocHerbe(int x ,int y){
		super(x , y, 50, 50);
		texture = new Texture("herbe.png");
	}

}
