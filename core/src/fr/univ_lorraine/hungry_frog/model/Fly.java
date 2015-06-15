package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class Fly extends Bloc{

	protected boolean moucheMangee = false;
	protected String horizontal;
	protected String vertical;
	
	public Fly(int x, int y){
		super(x, y, 30, 30);
		texture = new Texture("fly.png");
	}
	
	public boolean getMoucheMangee(){
		return moucheMangee;
	}
	
	public void setMoucheMangee(boolean b){
		moucheMangee = b;
	}
	
	public void suppRectangle(){
		r.setX(800);
		r.setY(800);
	}
	
	public void mouvementsMouche(){
		
		if(getMoucheMangee() == false){
			int aux = (int)(Math.random()*5);
			int h = (int)((Math.random()*5)-aux);
			int v = (int)((Math.random()*5)-aux);
			//x += r;
			//System.out.println(r);
			//System.out.println(x);
			if(getX()>=660){
				horizontal = "gauche";
			}
			else if(getX()<=30){
				horizontal = "droite";
			}
			if(getY()>=490){
				vertical = "bas";
			}
			else if(getY()<=30){
				vertical = "haut";
			}
			
			if(horizontal == "gauche"){
				setX(getX() - h);
				getHitbox().setX(getX());
			}
			else{
				setX(getX() + h);
				getHitbox().setX(getX());
			}
			if(vertical == "haut"){
				setY(getY() + v);
				getHitbox().setY(getY());
			}
			else{
				setY(getY() - v);
				getHitbox().setY(getY());
			}
		}
		
	}
	
	public void replaceOrigine(){
		setX(300);
		setY(0);
		r.setX(getX());
		r.setY(getY());
	}
}
