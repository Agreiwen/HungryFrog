package fr.univ_lorraine.hungry_frog.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import fr.univ_lorraine.hungry_frog.model.Joystick;
import fr.univ_lorraine.hungry_frog.model.Level;


public class GameListener implements InputProcessor{
	
	protected Joystick joystick;
	protected Level level;
	// 1 -> gauche // 2 -> droite
	protected int position;
	protected boolean premierTouchDown = true;
	
	public GameListener(Level l){
		this.level=l;
	}
	
	public int getPosition(){
		return position;
	}
	
	public void setPosition(int i){
		position = i;
	}
	
	public boolean getPremierTouchDown(){
		return premierTouchDown;
	}
	
	public void setPremierTouchDown(boolean b){
		premierTouchDown = b;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Input.Keys.LEFT){
			level.getFrog().setDirection("Gauche");
		}
		else if(keycode == Input.Keys.RIGHT){
			level.getFrog().setDirection("Droite");
		}
		else if(keycode == Input.Keys.UP){
			level.getFrog().setDirection("Haut");
		}
		else if(keycode == Input.Keys.DOWN){
			level.getFrog().setDirection("Bas");
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		level.getFrog().setDirection("Stop");
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		//System.out.println("Touch");
		int posX = (Gdx.graphics.getWidth()*100)/(screenX);
		int posY = (Gdx.graphics.getHeight()*100)/(screenY);
		
		System.out.println(posX);
		
		System.out.println(posY);
		
		if(getPremierTouchDown() == true){
			if(posX <200){
				Joystick.getInstance().setPosition(600, 5);
				setPosition(2);
				setPremierTouchDown(false);
				Joystick.getInstance().setVisible();
			}
			else{
				Joystick.getInstance().setPosition(5, 5);
				setPosition(1);
				setPremierTouchDown(false);
				Joystick.getInstance().setVisible();
			}
		}
		else{
			//System.out.println("test bouger");
			touchArrow(posX,posY);
		}
		return false;
	}

	public void touchArrow(int x, int y){
		//System.out.println("TouchArrow");
		System.out.println(x);
		System.out.println(y);
		System.out.println(getPosition());
		if(getPosition()==1 && x<=2529 && x>=718 && y<=105 && y>=98){
			System.out.println("mouvement bas");
			Joystick.getInstance().setTexture(level.getListeTexture(18));
			level.getFrog().setDirection("Bas");
		}
		else if(getPosition()==1 && x<=2529 && x>=718 && y<=131 && y>=122){
			System.out.println("mouvement haut");
			Joystick.getInstance().setTexture(level.getListeTexture(17));
			level.getFrog().setDirection("Haut");
		}
		else if(getPosition()==1 && x<=718 && x>=559 && y<=122 && y>=105){
			System.out.println("mouvement droite");
			Joystick.getInstance().setTexture(level.getListeTexture(20));
			level.getFrog().setDirection("Droite");
		}
		else if(getPosition()==1 && x<=45533 && x>=2529 && y<=122 && y>=105){
			System.out.println("mouvement gauche");
			Joystick.getInstance().setTexture(level.getListeTexture(19));
			level.getFrog().setDirection("Gauche");
		}
		// Joystick droit
		else if(getPosition()==2 && x<=115 && x>=104 && y<=105 && y>=100){
			System.out.println("mouvement bas");
			Joystick.getInstance().setTexture(level.getListeTexture(18));
			level.getFrog().setDirection("Bas");
		}
		else if(getPosition()==2 && x<=115 && x>=104 && y<=130 && y>=122){
			System.out.println("mouvement haut");
			Joystick.getInstance().setTexture(level.getListeTexture(17));
			level.getFrog().setDirection("Haut");
		}
		else if(getPosition()==2 && x<=104 && x>=100 && y<=122 && y>=105){
			System.out.println("mouvement droite");
			Joystick.getInstance().setTexture(level.getListeTexture(20));
			level.getFrog().setDirection("Droite");
		}
		else if(getPosition()==2 && x<=120 && x>=115 && y<=122 && y>=105){
			System.out.println("mouvement gauche");
			Joystick.getInstance().setTexture(level.getListeTexture(19));
			level.getFrog().setDirection("Gauche");
		}
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		//Joystick.getInstance().setInvisible();
		Joystick.getInstance().setTexture(level.getListeTexture(16));
		level.getFrog().setDirection("Stop");
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
