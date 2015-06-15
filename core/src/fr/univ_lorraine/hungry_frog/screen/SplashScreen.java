package fr.univ_lorraine.hungry_frog.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.univ_lorraine.hungry_frog.controller.SplashListener;

public class SplashScreen implements Screen{
	private OrthographicCamera camera;
	protected Viewport viewport;
	HungryFrogGame hungryfrog;
	SpriteBatch batch;
	Texture menuSonActif;
	Texture menuSonMute;
	SplashListener sl;
	
	public SplashScreen(HungryFrogGame hungryfrog){
		camera = new OrthographicCamera();
		this.hungryfrog = hungryfrog;
		batch = new SpriteBatch();
		menuSonActif = new Texture("menuSonActif.png");
		menuSonMute = new Texture("menuSonMute.png");
	}
	
	public void render(float delta){
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		
		//if(sl.getSonActive()){
		if(hungryfrog.getSonActif()){
			batch.draw(menuSonActif,0,0);
		}
		else{
			batch.draw(menuSonMute, 0, 0);
		}
		batch.end();
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		sl = new SplashListener(hungryfrog);
		Gdx.input.setInputProcessor(sl);
		viewport = new StretchViewport(723,550,camera);
		viewport.apply();
		camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2,0);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		viewport.update(width, height);
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
	
}
