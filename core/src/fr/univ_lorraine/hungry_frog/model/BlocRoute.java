package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class BlocRoute extends Bloc{
	
	public BlocRoute(int x ,int y){
		super(x , y, 50, 50);
		texture = new Texture("route.jpg");
	}

}
