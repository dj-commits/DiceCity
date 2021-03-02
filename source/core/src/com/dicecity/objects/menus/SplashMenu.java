package com.dicecity.objects.menus;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.dicecity.Game;
import com.dicecity.objects.Ent;
import com.dicecity.objects.Menu;
import com.dicecity.utils.GameConstants;
import com.dicecity.utils.GameUtils;


public class SplashMenu extends Menu{

	
	public SplashMenu(){
		load();
	}
	
	public void load(){
		this.setName("splash");
		
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		ents.addAll(GameUtils.buildChevronBG());
		
		Ent logo = new Ent();
		logo.setName("logo");
		logo.setImg(Game.getGlobal().getImgByName("logoSplash"));
		logo.setPosBox(new Rectangle((Gdx.graphics.getWidth()/2)-(logo.getImg().getTex().getWidth()/2),
				(Gdx.graphics.getHeight()/2)-(logo.getImg().getTex().getHeight()/2),
				logo.getImg().getTex().getWidth(),
				logo.getImg().getTex().getHeight()));
		ents.add(logo);
		
		this.setEnts(ents);
	}
	
	private static long startMillis;
	
	public void update(float stateTime){
		
		cycleChevronBg();
		
		if (startMillis==0) startMillis = System.currentTimeMillis();
		else{
			if (startMillis+GameConstants.SPLASH_MENU_WAIT<=System.currentTimeMillis()){
				Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("main"));
			}
		}
	}
}
