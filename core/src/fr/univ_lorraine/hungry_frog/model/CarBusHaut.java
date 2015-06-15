package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class CarBusHaut extends Car{
	public CarBusHaut(int x ,int y){
		super(x , y);
		texture = new Texture("bus.png");
	}
}
