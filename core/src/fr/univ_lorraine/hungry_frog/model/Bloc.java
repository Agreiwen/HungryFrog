package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Bloc {

	protected int largeur , hauteur ;
	protected Texture texture ;
	protected int x , y ;
	protected Rectangle r;

	
	public Bloc(int x, int y, int l, int h){
		this.x = x ;
		this.y = y ;
		this.largeur = l;
		this.hauteur = h;
		r = new Rectangle(x,y,l,h);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getLongueur() {
		return hauteur;
	}
	public void setLongeur(int longeur) {
		this.hauteur = longeur;
	}
	public Texture getTexture() {
		return texture;
	}
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	public Rectangle getHitbox(){
		return r;
	}
	
}