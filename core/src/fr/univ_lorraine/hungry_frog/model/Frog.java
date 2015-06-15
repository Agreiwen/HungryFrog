package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

public class Frog extends Bloc{
	
	enum direction { LEFT, RIGHT, UP, DOWN,STOP };
	int RAPIDE = 200;
	int LENT = 10;
	int NORMAL = 100;
	protected direction dir = direction.STOP;
	protected int SPEED=RAPIDE;
	protected int life = 5;
	protected float delta;
	
	public Frog(int x ,int y){
		super(x , y, 30, 30);
		texture = new Texture("down-1.png");
	}
	
	public void initDirection(){
		dir = direction.LEFT;
	}
	
	public void setDirection(direction d){
		dir = d;
	}
	
	public void setDirection(String d){
		if(d.equals("Haut")){
			dir = direction.UP;
		}else if(d.equals("Bas")){
			dir = direction.DOWN;
		}else if(d.equals("Gauche")){
			dir = direction.LEFT;
		}else if(d.equals("Droite")){
			dir = direction.RIGHT;
		}else if(d.equals("Stop")){
			dir = direction.STOP;
		}
	}
	public direction getDirection(){
		return dir;
	}
	
	public int getSpeed(){
		return SPEED;
	}
	
	public void setSpeed(int i){
		this.SPEED = i;
	}
	
	public void update(float delta){
		this.delta = delta;
		if(dir==direction.LEFT && getX()>0){
			 x-=delta*SPEED;
		}else if(dir==direction.RIGHT && getX()<720-getLongueur()){
			 x+=delta*SPEED+1;
			
		}else if(dir==direction.UP && getY()<550-getLargeur()){
			 y+=delta*SPEED+1;
		}else if(dir==direction.DOWN && getY()>0){
			y-=delta*SPEED;
		}else if(dir==direction.STOP){
			
		}
		r.setX(x);
		r.setY(y);
	}

	public boolean hasCollision(Fly fly) {
		return fly.getHitbox().overlaps(r);
	}

	public boolean hasCollision(Car car) {
		return car.getHitbox().overlaps(r);
	}

	public void replaceOrigine() {
		this.x=350;
		this.y=495;
	}

	public boolean hasCollision(Arbre arbre) {
		return arbre.getHitbox().overlaps(r);
	}
	
	public int getLife(){
		return life;
	}
	
	public void winLife(){
		if(life < 5)
		life += 1;
	}
	
	public void looseLife(){
		if(life > 0){
			life -= 1;
		}
	}

	public void replaceAnterieur() {
		// TODO Auto-generated method stub
		switch(dir){
			case UP :
				this.y = getY() - ((int) getDelta()*SPEED+20);
				break;
			case DOWN :
				this.y = getY() + ((int) getDelta()*SPEED+20);
				break;
			case LEFT :
				this.x = getX() + ((int) getDelta()*SPEED+20);
				break;
			case RIGHT :
				this.x = getX() - ((int) getDelta()*SPEED+20);
				break;
			default:
				break;
		}
	}
	
	public float getDelta(){
		return delta;
	}
	
	public int getDirectionNumber(){
		if(dir == direction.UP){
			return 1;
		}else if(dir == direction.DOWN){
			return 2;
		}else if(dir == direction.LEFT){
			return 3;
		}else if(dir == direction.RIGHT){
			return 4;
		}
		else return 5;

	}
}
