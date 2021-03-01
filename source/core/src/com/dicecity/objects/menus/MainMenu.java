package com.dicecity.objects.menus;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.dicecity.Game;
import com.dicecity.objects.Ent;
import com.dicecity.objects.Menu;
import com.dicecity.utils.GameConstants;
import com.dicecity.utils.GameUtils;

public class MainMenu extends Menu{
	
	public MainMenu(){
		load();
	}
	
	public void load(){
		this.setName("main");
		
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		ents.addAll(buildChevronBG());
		
		Ent logoTitle = new Ent();
		logoTitle.setName("logoTitle");
		logoTitle.setImg(Game.getGlobal().getImgByName("logoTitle"));
		logoTitle.setPosBox(new Rectangle((int) ((Gdx.graphics.getWidth()/2)-(logoTitle.getImg().getTex().getWidth()/2)),
				Gdx.graphics.getHeight() - logoTitle.getImg().getTex().getHeight()-64,
				logoTitle.getImg().getTex().getWidth(),
				logoTitle.getImg().getTex().getHeight()));
		ents.add(logoTitle);
		
		Ent btnStart = new Ent();
		btnStart.setName("btnStart");
		btnStart.setId(1);
		btnStart.setImg(Game.getGlobal().getImgByName("btnStart"));
		btnStart.setPosBox(new Rectangle((int) ((Gdx.graphics.getWidth()/2)-(btnStart.getImg().getTex().getWidth()/2)),
				logoTitle.getY()-btnStart.getImg().getTex().getHeight()-3,
				btnStart.getImg().getTex().getWidth(),
				btnStart.getImg().getTex().getHeight()));
		btnStart.setSelected(true);
		ents.add(btnStart);
		
		Ent btnExit = new Ent();
		btnExit.setName("btnExit");
		btnExit.setId(2);
		btnExit.setImg(Game.getGlobal().getImgByName("btnExit"));
		btnExit.setPosBox(new Rectangle((int) ((Gdx.graphics.getWidth()/2)-(btnExit.getImg().getTex().getWidth()/2)),
				btnStart.getY()-btnExit.getImg().getTex().getHeight()-3,
				btnExit.getImg().getTex().getWidth(),
				btnExit.getImg().getTex().getHeight()));
		ents.add(btnExit);
		
		this.setEnts(ents);
	}
	
	public void render(SpriteBatch batch){
		for(Ent e : this.getEnts()){
			e.render(batch);
		}
	}
	
	public void update(float stateTime){
		//updateKeyboardNavigation();
		//updateKeyboardSelect();
		updateMouseHover();
		updateMouseSelect();
		cycleChevronBg();
	}
	
	public void buttonSelect(){
		Ent selected = this.getSelectedEnt();
		if (selected != null) {
			if (selected.getName().equals("btnStart")){
				Game.getGlobal().getSfxByName("paperflip").play();
				Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("game"));
				Game.getGlobal().setGame(null);
			}
			if (selected.getName().equals("btnExit")){
				Gdx.app.exit();
			}
		}
	}
	
	public void buttonDeselect(){
		if (Gdx.input.isKeyJustPressed(GameConstants.KEY_QUIT)){
			Gdx.app.exit();
		}
	}
	
	
	public static double angleBetween2Lines(int x11, int y11, int x12, int y12, int x21, int y21, int x22, int y22){
        double angle1 = Math.atan2(y11 - y12,
                                   x11 - x12);
        double angle2 = Math.atan2(y21 - y22,
                                   x21 - x22);
        return angle1-angle2;
    }
}
