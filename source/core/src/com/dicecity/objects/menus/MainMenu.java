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
		
		Ent logoTitle = new Ent();
		logoTitle.setName("logoTitle");
		logoTitle.setImg(Game.getGlobal().getImgByName("logoTitle"));
		logoTitle.setPosBox(new Rectangle((int) ((Gdx.graphics.getWidth()/2)-(logoTitle.getImg().getTex().getWidth()/2)),
				Gdx.graphics.getHeight() - logoTitle.getImg().getTex().getHeight() - 200,
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
		
		Ent btnCredits = new Ent();
		btnCredits.setName("btnCredits");
		btnCredits.setId(2);
		btnCredits.setImg(Game.getGlobal().getImgByName("btnCredits"));
		btnCredits.setPosBox(new Rectangle((int) ((Gdx.graphics.getWidth()/2)-(btnCredits.getImg().getTex().getWidth()/2)),
				btnStart.getY()-btnCredits.getImg().getTex().getHeight()-3,
				btnCredits.getImg().getTex().getWidth(),
				btnCredits.getImg().getTex().getHeight()));
		ents.add(btnCredits);
		
		Ent btnExit = new Ent();
		btnExit.setName("btnExit");
		btnExit.setId(3);
		btnExit.setImg(Game.getGlobal().getImgByName("btnExit"));
		btnExit.setPosBox(new Rectangle((int) ((Gdx.graphics.getWidth()/2)-(btnExit.getImg().getTex().getWidth()/2)),
				btnCredits.getY()-btnExit.getImg().getTex().getHeight()-3,
				btnExit.getImg().getTex().getWidth(),
				btnExit.getImg().getTex().getHeight()));
		ents.add(btnExit);
		
		/*Ent btnLevelEditor = new Ent();
		btnLevelEditor.setName("btnLevelEditor");
		btnLevelEditor.setId(4);
		btnLevelEditor.setImg(Game.getGlobal().getImgByName("btnLevelEditor"));
		btnLevelEditor.setPosBox(new Rectangle((int) ((Gdx.graphics.getWidth()/2)+(btnLevelEditor.getImg().getTex().getWidth()*1.2f)),
				btnExit.getY(),
				btnLevelEditor.getImg().getTex().getWidth(),
				btnLevelEditor.getImg().getTex().getHeight()));
		if (Game.getConfig("loadLevelEdit").equals("true")){
			ents.add(btnLevelEditor);
		}*/
		
		Ent highScore = new Ent();
		highScore.setName("highScore");
		//highScore.setFont(Game.getGlobal().getFontByName("leckerli30"));
		highScore.setText("High Score: ");
		highScore.setPosBox(new Rectangle(100,100,0,0));
		ents.add(highScore);
		
		this.setEnts(ents);
		
		updateHighScore();
	}
	
	public void render(SpriteBatch batch){
		for(Ent e : this.getEnts()){
			if (e.getName().contains("chevron") || e.getName().contains("blackhole"))
				e.render(batch);
		}
		for(Ent e : this.getEnts()){
			if (!e.getName().contains("chevron") && !e.getName().contains("blackhole"))
				e.render(batch);
		}
	}
	
	public void update(float stateTime){
		updateKeyboardNavigation();
		updateKeyboardSelect();
		cycleChevronBg();
	}
	
	public void buttonSelect(){
		Ent selected = this.getSelectedEnt();
		if (selected.getName().equals("btnStart")){
			Game.getGlobal().getSfxByName("papery").play();
			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("game"));
			Game.getGlobal().setGame(null);
		}
		if (selected.getName().equals("btnCredits")){
			Game.getGlobal().getSfxByName("papery").play();
			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("credits"));
		}
		if (selected.getName().equals("btnExit")){
			Gdx.app.exit();
		}
		if (selected.getName().equals("btnLevelEditor")){
			Game.getGlobal().getSfxByName("papery").play();
			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("leveledit"));
			Game.getGlobal().setGame(null);
		}
	}
	
	public void buttonDeselect(){
		if (Gdx.input.isKeyJustPressed(GameConstants.KEY_QUIT)){
			Gdx.app.exit();
		}
	}
	
	public void updateHighScore(){
		String scoresTxt = Gdx.files.local("data/levels/scores.txt").readString();
		String[] scores = scoresTxt.split("\n");
		int highScore = 0;
		for(String score : scores){
			if (Integer.parseInt(score) > highScore){
				highScore = Integer.parseInt(score);
			}
		}
		this.getEntByName("highScore").setText("High Score: "+highScore);
	}
	
	
	public static double angleBetween2Lines(int x11, int y11, int x12, int y12, int x21, int y21, int x22, int y22){
        double angle1 = Math.atan2(y11 - y12,
                                   x11 - x12);
        double angle2 = Math.atan2(y21 - y22,
                                   x21 - x22);
        return angle1-angle2;
    }
}
