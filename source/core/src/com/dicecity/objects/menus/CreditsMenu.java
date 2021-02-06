package com.dicecity.objects.menus;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.slyvronline.game.Game;
import com.slyvronline.game.controllers.Xbox360Controller;
import com.slyvronline.game.objects.Ent;
import com.slyvronline.game.objects.Menu;
import com.slyvronline.game.utils.GameConstants;

public class CreditsMenu extends Menu{

	public CreditsMenu(){
		load();
	}
	
	public void load(){
		this.setName("credits");
		
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
		
		Ent btnBack = new Ent();
		btnBack.setName("btnBack");
		btnBack.setId(1);
		btnBack.setImg(Game.getGlobal().getImgByName("btnBack"));
		btnBack.setPosBox(new Rectangle((Gdx.graphics.getWidth()/2)-(btnBack.getImg().getTex().getWidth()/2),
				logo.getPosBox().getY() - btnBack.getImg().getTex().getHeight(),
				btnBack.getImg().getTex().getWidth(),
				btnBack.getImg().getTex().getHeight()));
		btnBack.setSelected(true);
		ents.add(btnBack);
		
		Ent creditsLeft = new Ent();
		creditsLeft.setName("creditsLeft");
		creditsLeft.setFont(Game.getGlobal().getFontByName("roboto20"));
		creditsLeft.setText("Created in libGDX\n"
				+ "libgdx.badlogicgames.com\n\n"
				+ "Thanks to @StlGameJam\n"
				+ "stlgamejam.com");
		creditsLeft.setPosBox(new Rectangle(64,Gdx.graphics.getHeight()-64,0,0));
		ents.add(creditsLeft);

		Ent creditsRight = new Ent();
		creditsRight.setName("creditsRight");
		creditsRight.setFont(Game.getGlobal().getFontByName("roboto20"));
		creditsRight.setText("Music by Teknoaxe\n"
				+ "teknoaxe.com");
		creditsRight.setPosBox(new Rectangle(logo.getX()+logo.getWidth(),Gdx.graphics.getHeight()-64,0,0));
		ents.add(creditsRight);
		
		this.setEnts(ents);
	}
	
	public void update (float stateTime){
		updateKeyboardNavigation();
		updateKeyboardSelect();
		cycleChevronBg();
	}
	
	public void buttonSelect(){
		Ent selected = this.getSelectedEnt();
		if (selected.getName().equals("btnBack")){
			Game.getGlobal().getSfxByName("papery").play();
			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("main"));
		}
	}
	
	public void buttonDeselect(){
		Game.getGlobal().getSfxByName("papery").play();
		Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("main"));
	}
}
