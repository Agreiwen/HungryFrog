package fr.univ_lorraine.hungry_frog.model;

public class DirectionDeplacement {
	
	enum direction {LEFT, RIGHT, UP, DOWN};
	direction dir;
	public DirectionDeplacement(String sens){
		if(sens.equals("gauche")){
			dir = direction.LEFT;
		}else if(sens.equals("droite")){
			dir = direction.RIGHT;
		}else if(sens.equals("haut")){
			dir = direction.UP;
		}else if(sens.equals("bas")){
			dir = direction.DOWN;
		}
	}
	
	public direction getDirection(){
		return dir;
	}
}