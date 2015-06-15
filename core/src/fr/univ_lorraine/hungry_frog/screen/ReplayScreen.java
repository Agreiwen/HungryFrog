package fr.univ_lorraine.hungry_frog.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.univ_lorraine.hungry_frog.controller.ReplayListener;

public class ReplayScreen implements Screen{
	private OrthographicCamera camera;
	protected Viewport viewport;
	HungryFrogGame hungryfrog;
	SpriteBatch batch;
	Texture menuSonActifRejouer;
	Texture menuSonMuteRejouer;
	ReplayListener rl;
	
	public ReplayScreen(HungryFrogGame hungryfrog){
		camera = new OrthographicCamera();
		this.hungryfrog = hungryfrog;
		batch = new SpriteBatch();
		menuSonActifRejouer = new Texture("menuSonActifRejouer.png");
		menuSonMuteRejouer = new Texture("menuSonMuteRejouer.png");
	}

	public void render(float delta){
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		//if(rl.getSonActive()){
		if(hungryfrog.getSonActif()){
			batch.draw(menuSonActifRejouer,0,0);
		}
		else{
			batch.draw(menuSonMuteRejouer, 0, 0);
		}
		batch.end();
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		rl = new ReplayListener(hungryfrog);
		Gdx.input.setInputProcessor(rl);
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
