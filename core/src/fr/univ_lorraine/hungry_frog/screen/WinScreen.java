package fr.univ_lorraine.hungry_frog.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.univ_lorraine.hungry_frog.controller.WinListener;

public class WinScreen implements Screen{
	private OrthographicCamera camera;
	protected Viewport viewport;
	HungryFrogGame hungryfrog;
	SpriteBatch batch;
	Texture menuWinSonActifRejouer;
	Texture menuWinSonMuteRejouer;
	WinListener wl;
	
	public WinScreen(HungryFrogGame hungryfrog){
		camera = new OrthographicCamera();
		this.hungryfrog = hungryfrog;
		batch = new SpriteBatch();
		menuWinSonActifRejouer = new Texture("menuWinSonActifRejouer.png");
		menuWinSonMuteRejouer = new Texture("menuWinSonMuteRejouer.png");
	}

	public void render(float delta){
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		//System.out.println(wl.getSonActive());
		if(hungryfrog.getSonActif()){
			batch.draw(menuWinSonActifRejouer,0,0);
		}
		else{
			batch.draw(menuWinSonMuteRejouer, 0, 0);
		}
		batch.end();
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		wl = new WinListener(hungryfrog);
		Gdx.input.setInputProcessor(wl);
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
