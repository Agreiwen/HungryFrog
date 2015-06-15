package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class CarBasiqueBas extends Car{
	
	public CarBasiqueBas(int x ,int y){
		super(x , y);
		texture = new Texture("voiture-3.png");
	}
}
