package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class CarBasiqueHaut extends Car{
	
	public CarBasiqueHaut(int x ,int y){
		super(x , y);
		texture = new Texture("voiture-1.png");
	}
}
