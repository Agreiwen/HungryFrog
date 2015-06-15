package fr.univ_lorraine.hungry_frog.model;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.graphics.Texture;


@SuppressWarnings("rawtypes")
public class Level implements Iterable {
	
	protected Frog frog;
	protected Fly fly;
	protected ArrayList<Car> car = new ArrayList<Car>();
	protected ArrayList<Arbre> arbre = new ArrayList<Arbre>();
	protected ArrayList<Texture> texture = new ArrayList<Texture>();
	protected Vie vie;
	protected int niveau = 1;
	protected Texture fond;
	protected boolean winGame = false;
	
	/*protected int [][] tableau  = { {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				  					{2,2,2,2,2,2,2,2,2,2,2,2,2,2},//herbe
									{1,1,1,1,1,1,1,1,1,1,1,1,1,1}, //route
									{2,2,3,2,2,3,2,2,3,2,2,3,2,2}, //ligne blanche
									{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
									{2,2,2,2,2,2,2,2,2,2,2,2,2,2},
									{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									{2,2,2,2,2,2,2,2,2,2,2,2,2,2},
									{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
									{2,2,3,2,2,3,2,2,3,2,2,3,2,2},
									{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
									{2,2,2,2,2,2,2,2,2,2,2,2,2,2},
									{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									
								  };*/

	public Level(Frog g){
		
		this.frog=g;
		
		this.vie = new Vie(670,510);
		
		this.texture.add(new Texture("down-1.png"));
		this.texture.add(new Texture("down-2.png"));
		this.texture.add(new Texture("down-3.png"));
		this.texture.add(new Texture("down-4.png"));
		
		this.texture.add(new Texture("up-1.png"));
		this.texture.add(new Texture("up-2.png"));
		this.texture.add(new Texture("up-3.png"));
		this.texture.add(new Texture("up-4.png"));
		
		this.texture.add(new Texture("left-1.png"));
		this.texture.add(new Texture("left-2.png"));
		this.texture.add(new Texture("left-3.png"));
		this.texture.add(new Texture("left-4.png"));
		
		this.texture.add(new Texture("right-1.png"));
		this.texture.add(new Texture("right-2.png"));
		this.texture.add(new Texture("right-3.png"));
		this.texture.add(new Texture("right-4.png"));
		
		this.texture.add(new Texture("joystick.png"));
		this.texture.add(new Texture("joystick-haut.png"));
		this.texture.add(new Texture("joystick-bas.png"));
		this.texture.add(new Texture("joystick-gauche.png"));
		this.texture.add(new Texture("joystick-droite.png"));
		
		
		
		/*for(int i = 0 ; i < tableau.length ; i++){
			for(int j = 0 ; j < tableau[0].length ; j++){
				if(tableau[i][j]==0){
					bloc.add(new BlocHerbe(0,0));
				}else if(tableau[i][j]==1){
					bloc.add(new BlocRoute(0,0));
				}else if(tableau[i][j]==2){
					bloc.add(new BlocLigne(0,0));
				}else if(tableau[i][j]==3){
					bloc.add(new BlocEntreLigne(0,0));
				}
			}
		}*/
	}
	
	public Frog getFrog(){
		return frog;
	}
	
	public Car getListeCar(int i){
		return car.get(i);
	}
	
	public int tailleListeCar(){
		return car.size();
	}
	
	public Arbre getListeArbre(int i){
		return arbre.get(i);
	}
	
	public int tailleListeArbre(){
		return arbre.size();
	}
	
	public Vie getVie(){
		return vie;
	}
	
	public void mouvementVoiture(){
		for(int i=0; i < tailleListeCar(); i++){
			if(getListeCar(i).getY()==80){
				if(getListeCar(i).getX()>-100){
					
				}
				else{
					getListeCar(i).setX(+750);
				}
				getListeCar(i).setX(getListeCar(i).getX()-10);
				getListeCar(i).getHitbox().setX(getListeCar(i).getX());
			}
			else if(getListeCar(i).getY() == 170){
				if(getListeCar(i).getX()>-100){
					
				}
				else{
					getListeCar(i).setX(+750);
				}
				getListeCar(i).setX(getListeCar(i).getX()-5);
				getListeCar(i).getHitbox().setX(getListeCar(i).getX());
			}
			else if(getListeCar(i).getY() == 320){
				if(getListeCar(i).getX()<750){
					
				}
				else{
					getListeCar(i).setX(-150);
				}
				getListeCar(i).setX(getListeCar(i).getX()+5);
				getListeCar(i).getHitbox().setX(getListeCar(i).getX());
			}
			else{
				if(getListeCar(i).getX()<750){
					
				}
				else{
					getListeCar(i).setX(-150);
				}
				getListeCar(i).setX(getListeCar(i).getX()+10);
				getListeCar(i).getHitbox().setX(getListeCar(i).getX());
			}
			
		}
	}
	
	public Texture getListeTexture(int i){
		return texture.get(i);
	}
	
	public Texture getFond(){
		return fond;
	}
	
	public void niveau1(){
		
		fond = new Texture("road-1.jpg");
		
		this.car.add(new CarBasiqueHaut(-150,415));
		
		this.car.add(new CarBusHaut(-400,320));
		
		this.car.add(new CarBusBas(900,170));
		
		this.car.add(new CarSportBas(1000,80));
		
		this.arbre.add(new Arbre(225,495));
		this.arbre.add(new Arbre(550,245));
		this.arbre.add(new Arbre(200,245));
		
	}
	
	public void niveau2(){
		
		fond = new Texture("road-2.jpg");
		
		this.car.add(new CarBasiqueBas(car.get(2).getX()+600,170));
		
	}
	
	public void niveau3(){
		
		fond = new Texture("road-3.jpg");
		
		this.car.add(new CarSportHaut(car.get(1).getX()-400, 320));
		
	}
	
	public void niveau4(){
		
		fond = new Texture("road-4.jpg");
		
		this.car.add(new CarBasiqueBas(car.get(3).getX()+300,80));
		
	}
	
	public void niveau5(){
		
		fond = new Texture("road-5.jpg");
	}
	
	public void niveau6(){
		
		fond = new Texture("road-6.jpg");
		this.car.add(new CarSportHaut(car.get(0).getX()-450,415));
	}
	
	public void niveau7(){
		
		fond = new Texture("road-7.jpg");
	}
	
	public void niveau8(){
		
		fond = new Texture("road-8.jpg");
		
		//this.car.add(new CarBusHaut(car.get(0).getX()-150,415));
		this.car.add(new CarSportBas(car.get(2).getX()+200,170));
	}
	
	public void niveau9(){
		
		fond = new Texture("road-9.jpg");
		
		//this.car.add(new CarBusHaut(car.get(0).getX()-250,320));
	}
	
	public void niveau10(){
		
		fond = new Texture("road-10.jpg");
		
		this.car.add(new CarBasiqueHaut(car.get(1).getX()+150, 320));
		
	}
	
	public void addNiveau(){
		setNiveau(getNiveau()+1);
	}
	
	private void setNiveau(int i) {
		// TODO Auto-generated method stub
		niveau += 1;
	}

	public int getNiveau(){
		return niveau;
	}
	
	public boolean getWinGame(){
		return winGame;
	}
	
	public void setWinGame(boolean b){
		winGame = b;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
