package com.dicecity.objects.menus;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.slyvronline.game.Game;
import com.slyvronline.game.objects.Ent;
import com.slyvronline.game.objects.Menu;
import com.slyvronline.game.utils.GameConstants;

public class SplashMenu extends Menu{

	
	public SplashMenu(){
		load();
	}
	
	public void load(){
		this.setName("splash");
		
		ArrayList<Ent> ents = new ArrayList<Ent>();

		/*
		Ent bg07_1 = new Ent();
		bg07_1.setName("bg07_1");
		bg07_1.setImg(Game.getGlobal().getImgByName("bg07"));
		bg07_1.setPosBox(new Rectangle(0,
				-100,
				bg07_1.getImg().getTex().getWidth(),
				bg07_1.getImg().getTex().getHeight()));
		ents.add(bg07_1);
		*/
		
		ents.addAll(buildChevronBG());
		
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
