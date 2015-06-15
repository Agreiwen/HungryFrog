package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class CarBusBas extends Car{
	public CarBusBas(int x ,int y){
		super(x , y);
		texture = new Texture("bus-1.png");
	}
}
