package com.dicecity.objects.menus;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.dicecity.Game;
import com.dicecity.objects.Ent;
import com.dicecity.objects.Menu;
import com.dicecity.utils.GameConstants;

public class GamePauseMenu extends Menu{
	
	public GamePauseMenu(){
		load();
	}
	
	public void load(){
		this.setName("gamepause");
		
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		Ent btnBack = new Ent();
		btnBack.setName("btnBack");
		btnBack.setId(1);
		btnBack.setImg(Game.getGlobal().getImgByName("btnBack"));
		btnBack.setPosBox(new Rectangle((int) ((Gdx.graphics.getWidth()/2)-(btnBack.getImg().getTex().getWidth()/2)),
				Gdx.graphics.getHeight()/2 + btnBack.getImg().getTex().getHeight(),
				btnBack.getImg().getTex().getWidth(),
				btnBack.getImg().getTex().getHeight()));
		ents.add(btnBack);
		
		Ent btnExit = new Ent();
		btnExit.setName("btnExit");
		btnExit.setId(2);
		btnExit.setImg(Game.getGlobal().getImgByName("btnExit"));
		btnExit.setPosBox(new Rectangle((int) ((Gdx.graphics.getWidth()/2)-(btnExit.getImg().getTex().getWidth()/2)),
				btnBack.getY()-btnExit.getImg().getTex().getHeight()-3,
				btnExit.getImg().getTex().getWidth(),
				btnExit.getImg().getTex().getHeight()));
		ents.add(btnExit);
		
		this.setEnts(ents);
	}
	
	public void update (float stateTime){
		updateMouseHover();
		updateMouseSelect();
	}

	public void buttonSelect(){
		Ent selected = this.getSelectedEnt();
		
		if (selected.getName().equals("btnBack")) {
			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("game"));
		}
		if (selected.getName().equals("btnExit")){
			Game.getGlobal().setGame(null);
			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("main"));
		}
	}
	
	public void buttonDeselect(){
		
	}
	
	public void resetGame(){
		
	}
}
