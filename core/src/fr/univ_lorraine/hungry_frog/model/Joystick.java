package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class Joystick extends Bloc{
	
	protected static Joystick instance;
	
	public static Joystick getInstance(){
		return instance;
	}
	
	public static void initJoystick(int x, int y){
		instance = new Joystick(x, y);
	}
	
	public void setPosition(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	protected boolean visible = false;

	private Joystick(int x, int y) {
		super(x, y, 120, 120);
		texture = new Texture("joystick.png");
		// TODO Auto-generated constructor stub
	}

	public void setVisible() {
		// TODO Auto-generated method stub
		visible = true;
	}

	public void setInvisible() {
		// TODO Auto-generated method stub
		visible = false;
	}
	
	public boolean isVisible(){
		return visible;
	}

}
