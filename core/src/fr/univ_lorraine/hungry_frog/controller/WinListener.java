package fr.univ_lorraine.hungry_frog.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import fr.univ_lorraine.hungry_frog.screen.HungryFrogGame;


public class WinListener implements InputProcessor{
	
	protected HungryFrogGame hungryfrog;
	protected boolean sonActive = true;
	
	public WinListener(HungryFrogGame hungryfrog){
		this.hungryfrog = hungryfrog;
	}
	
	public boolean getSonActive(){
		return sonActive;
	}
	
	public void setSonActive(boolean b){
		sonActive = b;
	}
	
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		System.out.println("touch");
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		int posX = (Gdx.graphics.getWidth()*100)/(screenX);
		int posY = (Gdx.graphics.getHeight()*100)/(screenY);
		System.out.println(posX);
		System.out.println(posY);
		
		if(posX<=217 && posX>=143 && posY<=130 && posY>=118){
			System.out.println("jouer !");
			hungryfrog.replayGame();
		}
		else if(hungryfrog.getSonActif() && posX<=133 && posX>=120 && posY<=134 && posY>=116){
			System.out.println("mute-son");
			hungryfrog.getMusicWin().pause();
			hungryfrog.setSonActif(false);
			setSonActive(false);
		}
		else if(!hungryfrog.getSonActif() && posX<=133 && posX>=120 && posY<=134 && posY>=116){
			System.out.println("son-active");
			hungryfrog.getMusicWin().play();
			hungryfrog.setSonActif(true);
			setSonActive(true);
		}
		else if(posX<=610 && posX>=247 && posY<=130 && posY>=118){
			System.out.println("quitter");
			hungryfrog.getMusicWin().stop();
			System.exit(0);
		}
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


	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

}
