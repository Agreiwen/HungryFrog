package fr.univ_lorraine.hungry_frog.screen;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.FPSLogger;


public class HungryFrogGame extends Game {

	protected FPSLogger fps;
	protected GameScreen animScreen;
	protected SplashScreen splashScreen;
	protected ReplayScreen replayScreen;
	protected WinScreen winScreen;
	protected boolean confirmeReplayScreen = false;
	protected boolean sonActif = true;
	protected Music music;
	protected Music win;
	protected Music perdu;
	protected Music intro;
	
	@Override
	public void create () {	
		fps = new FPSLogger();
		animScreen = new GameScreen(this);	
		splashScreen = new SplashScreen(this);
		replayScreen = new ReplayScreen(this);
		winScreen = new WinScreen(this);
		setSplashScreen();
		
		
		
		music = Gdx.audio.newMusic(Gdx.files.internal("musique.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		
		perdu = Gdx.audio.newMusic(Gdx.files.internal("perdu.mp3"));
		perdu.setVolume(0.1f);
		
		win = Gdx.audio.newMusic(Gdx.files.internal("win.MP3"));
		win.setVolume(0.1f);
		
		intro = Gdx.audio.newMusic(Gdx.files.internal("intro.MP3"));
		intro.play();
		intro.setVolume(0.1f);
	}


	@Override
	public void render (){
		super.render();
		this.fps.log();
		if(animScreen.getGameOver() && getConfirmeReplayScreen() == false){
			setReplayScreen();
			setConfirmeReplayScreen(true);
		}
		if(animScreen.getGameWin() && getConfirmeReplayScreen() == false){
			setWinScreen();
			setConfirmeReplayScreen(true);
		}
	}

	private void setWinScreen() {
		// TODO Auto-generated method stub
		if(getSonActif()==true){
			music.stop();
		}
		setScreen(winScreen);
		if(getSonActif()==true){
			win.play();
		}
	}


	public void setSplashScreen(){
		setScreen(splashScreen);
	}
	
	public void setReplayScreen(){
		music.pause();
		if(getSonActif()==true){
			perdu.play();
		}
		setScreen(replayScreen);
		if(getSonActif()==true){
			music.play();
		}
	}
	
	public void setGame() {
		// TODO Auto-generated method stub
		if(getSonActif()==true){
			intro.stop();
			music.play();
		}
		setScreen(animScreen);
	}
	
	public void replayGame(){
		animScreen = new GameScreen(this);
		setGame();
		setConfirmeReplayScreen(false);
	}
	
	public boolean getConfirmeReplayScreen(){
		return confirmeReplayScreen;
	}
	
	public void setConfirmeReplayScreen(boolean b){
		confirmeReplayScreen = b;
	}
	
	public Music getMusicFond(){
		return music;
	}
	
	public Music getMusicWin(){
		return win;
	}


	public Music getMusicIntro() {
		// TODO Auto-generated method stub
		return intro;
	}


	public boolean getSonActif() {
		return sonActif;
	}


	public void setSonActif(boolean b) {
		this.sonActif = b;
	}
	
	
}