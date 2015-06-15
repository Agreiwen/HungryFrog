package fr.univ_lorraine.hungry_frog.screen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.univ_lorraine.hungry_frog.controller.GameListener;
import fr.univ_lorraine.hungry_frog.model.Fly;
import fr.univ_lorraine.hungry_frog.model.Frog;
import fr.univ_lorraine.hungry_frog.model.Joystick;
import fr.univ_lorraine.hungry_frog.model.Level;

public class GameScreen extends ApplicationAdapter implements Screen{

	private OrthographicCamera camera; 
	protected Level l;
	protected Viewport viewport;
	protected float compteur = 0;
	protected int confirmeNiveau = 0;
	protected boolean gameOver = false;
	protected boolean gameWin = false;
	protected HungryFrogGame hfg;
	protected SpriteBatch batch;
	protected Texture fond;
	protected Texture imgArbre;
	protected Frog frog;
	protected Fly fly;
	protected Texture imgBarriere;
	protected FPSLogger fps;
	protected Joystick joystick;
	protected GameListener gl;
	protected Music soundFly;
	protected Music soundCar;
	protected Music levelUp;
	
	public GameScreen(HungryFrogGame g){

		Joystick.initJoystick(0,0);
		this.hfg=g;
		camera=new OrthographicCamera();
		fps = new FPSLogger();
		
	}
	
	@Override
	public void show(){

		batch = new SpriteBatch();// TODO Auto-generated method stub
		fly = new Fly(300,0);
		frog = new Frog(350,495);
		l = new Level(frog);
		gl = new GameListener(l);
		Gdx.input.setInputProcessor(gl);
		viewport = new StretchViewport(723,550,camera);
		viewport.apply();
		camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2,0);
	}
	
	@Override
	public void render(float delta) {
		
		camera.update();
		batch.setProjectionMatrix(camera.combined); 
		
		/* Affichage du niveau */
		switch(l.getNiveau()){
		case 1: 
			if(confirmeNiveau != 1){
				l.niveau1();
				confirmeNiveau ++;
			}
			break;
		case 2:
			if(confirmeNiveau != 2){
				l.niveau2();
				confirmeNiveau ++;
			}
			break;
		case 3:
			if(confirmeNiveau != 3){
				l.niveau3();
				confirmeNiveau ++;
			}
			break;
		case 4:
			if(confirmeNiveau != 4){
				l.niveau4();
				confirmeNiveau ++;
			}
			break;
		case 5:
			if(confirmeNiveau != 5){
				l.niveau5();
				confirmeNiveau ++;
			}
			break;
		case 6:
			if(confirmeNiveau != 6){
				l.niveau6();
				confirmeNiveau ++;
			}
			break;
		case 7:
			if(confirmeNiveau != 7){
				l.niveau7();
				confirmeNiveau ++;
			}
			break;
		case 8:
			if(confirmeNiveau != 8){
				l.niveau8();
				confirmeNiveau ++;
			}
			break;
		case 9:
			if(confirmeNiveau != 9){
				l.niveau9();
				confirmeNiveau ++;
			}
			break;
		case 10:
			if(confirmeNiveau != 10){
				l.niveau10();
				confirmeNiveau ++;
			}
			break;
		}
		compteur +=  delta*20;
		
		//fps.log();
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		/* Mouvement de la grenouille */
		frog.update(delta);
		
		
		/* Affichage du fond */
		batch.draw(l.getFond(),0,0);
		
		/* Affichage des arbres */
		for(int i=0; i<l.tailleListeArbre(); i++){
			batch.draw(l.getListeArbre(i).getTexture(), l.getListeArbre(i).getX(), l.getListeArbre(i).getY(), l.getListeArbre(i).getLargeur(), l.getListeArbre(i).getLongueur());
		}
		
		/* Mettre en mouvement les voitures */
		l.mouvementVoiture();
		
		/* Affichage des voitures */
		for(int i=0; i < l.tailleListeCar(); i++){
			batch.draw(l.getListeCar(i).getTexture(), l.getListeCar(i).getX(), l.getListeCar(i).getY(), l.getListeCar(i).getLargeur(), l.getListeCar(i).getLongueur());
		}
		
		/* Affichage de la vie de la grenouille */
		drawLife(frog.getLife());
		
		for(int i=0; i< l.tailleListeArbre(); i++){
			if(frog.hasCollision(l.getListeArbre(i))){
				frog.replaceAnterieur();
			}
		}
		/* Gestion collision de la grenouille avec la mouche */
		if(frog.hasCollision(fly)){
			System.out.println("collision");
			if(hfg.getSonActif()==true){
				soundFly = Gdx.audio.newMusic(Gdx.files.internal("fly.mp3"));
				soundFly.play();
				soundFly.setVolume(0.3f);
			}
			fly.setMoucheMangee(true);
			fly.suppRectangle();
			frog.winLife();
		}
		
		/* Gestion collision de la grenouille avec les voitures */
		for(int i=0; i < l.tailleListeCar(); i++){
			if(frog.hasCollision(l.getListeCar(i))){
				if(frog.getLife() >= 1 && hfg.getSonActif()==true){
					soundCar = Gdx.audio.newMusic(Gdx.files.internal("rire.mp3"));
					soundCar.play();
					soundCar.setVolume(0.3f);
				}
				frog.replaceOrigine();
				l.getFrog().setDirection("Stop");
				frog.looseLife();
			}
		}
		
		/* Affichage de la mouche */
		if(fly.getMoucheMangee() == false && (l.getNiveau()==1 || l.getNiveau()==2 || l.getNiveau()==3 || l.getNiveau()==4 || l.getNiveau()==6 || l.getNiveau()==8)){
			batch.draw(fly.getTexture(), fly.getX(), fly.getY(),fly.getLargeur(),fly.getLongueur());
		}
		
		/* Affichage de la grenouille */
		batch.draw(frog.getTexture(),frog.getX(),frog.getY(),frog.getLargeur(),frog.getLongueur());

		/* Mouvements de la mouche */
		fly.mouvementsMouche();
		
		switch(l.getFrog().getDirectionNumber()){
			case 1 :
				if(compteur < 1){
					l.getFrog().setTexture(l.getListeTexture(4));
				}
				else if(compteur < 2){
					l.getFrog().setTexture(l.getListeTexture(5));
				}
				else if(compteur <3){
					l.getFrog().setTexture(l.getListeTexture(6));
				}
				else{
					l.getFrog().setTexture(l.getListeTexture(7));
					compteur = 0;
				}
				break;
			case 2 :
				if(compteur < 1){
					l.getFrog().setTexture(l.getListeTexture(0));
				}
				else if(compteur < 2){
					l.getFrog().setTexture(l.getListeTexture(1));
				}
				else if(compteur <3){
					l.getFrog().setTexture(l.getListeTexture(2));
				}
				else{
					l.getFrog().setTexture(l.getListeTexture(3));
					compteur = 0;
				}
				break;
			case 3 :
				if(compteur < 1){
					l.getFrog().setTexture(l.getListeTexture(8));
				}
				else if(compteur < 2){
					l.getFrog().setTexture(l.getListeTexture(9));
				}
				else if(compteur <3){
					l.getFrog().setTexture(l.getListeTexture(10));
				}
				else{
					l.getFrog().setTexture(l.getListeTexture(11));
					compteur = 0;
				}
				break;
			case 4 :
				if(compteur < 1){
					l.getFrog().setTexture(l.getListeTexture(12));
				}
				else if(compteur < 2){
					l.getFrog().setTexture(l.getListeTexture(13));
				}
				else if(compteur <3){
					l.getFrog().setTexture(l.getListeTexture(14));
				}
				else{
					l.getFrog().setTexture(l.getListeTexture(15));
					compteur = 0;
				}
				break;
			default:
				break;
		}
		
		if(l.getFrog().getY() <= 1){
			l.getFrog().replaceOrigine();
			l.getFrog().setDirection("Stop");
			fly.setMoucheMangee(false);
			fly.replaceOrigine();
			if(l.getNiveau()<10){
				if(hfg.getSonActif()){
					levelUp = Gdx.audio.newMusic(Gdx.files.internal("levelUp.mp3"));
					levelUp.play();
					levelUp.setVolume(0.5f);
				}
				l.addNiveau();
			}
			else{
				setGameWin(true);
			}
			//System.out.println(l.getNiveau());
		}
		if(Joystick.getInstance().isVisible())
		batch.draw(Joystick.getInstance().getTexture(), Joystick.getInstance().getX(), Joystick.getInstance().getY(), Joystick.getInstance().getLargeur(), Joystick.getInstance().getLongueur());
		
		if(frog.getLife()<=0){
			setGameOver(true);
			System.out.println("Game over");
		}
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		//_camera.setToOrtho(false, width, height); _camera.position.set (_camera.viewportWidth / 2, _camera.viewportHeight / 2, 0);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public void drawLife(int life){
		for(int i=0; i < life; i++){
			batch.draw(l.getVie().getTexture(), l.getVie().getX()-(30*i), l.getVie().getY(), l.getVie().getLargeur(), l.getVie().getLongueur());
		}
	}
	
	public boolean getGameOver(){
		return gameOver;
	}
	
	public void setGameOver(boolean b){
		gameOver = b;
	}
	
	public boolean getGameWin(){
		return gameWin;
	}
	
	public void setGameWin(boolean b){
		gameWin = b;
	}

}
