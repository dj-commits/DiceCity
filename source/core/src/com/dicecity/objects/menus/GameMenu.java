package com.dicecity.objects.menus;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Rectangle;
import com.dicecity.Game;
import com.dicecity.objects.Ent;
import com.dicecity.objects.Menu;
import com.dicecity.utils.GameConstants;

public class GameMenu extends Menu{

	
	public GameMenu(){
		load();
	}
	
	public void load(){
		this.setName("game");
		
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		this.setEnts(ents);
	}
	
	public void update (float stateTime){
		if (Gdx.input.isKeyJustPressed(GameConstants.KEY_QUIT)) {
			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("main"));
		}
	}

	public void buttonSelect(){
		Ent selected = this.getSelectedEnt();
		if (selected.getName().equals("btnReplay")){
			
		}
	}
	
	public void buttonDeselect(){
		
	}
	
	public void resetGame(){
		
	}
}
