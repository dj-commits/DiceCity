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
		
		//ents.addAll(buildChevronBG());
		
		Ent timer = new Ent();
		timer.setName("timer");
		//timer.setFont(Game.getGlobal().getFontByName("leckerli24"));
		timer.setText("Timer: "+GameConstants.MAX_TIMER);
		timer.setPosBox(new Rectangle(100,Gdx.graphics.getHeight() - 100,0,0));
		ents.add(timer);
		
		Ent score = new Ent();
		score.setName("score");
		//score.setFont(Game.getGlobal().getFontByName("leckerli24"));
		score.setText("Score: 0");
		score.setPosBox(new Rectangle(100,Gdx.graphics.getHeight() - 150,0,0));
		ents.add(score);
		
		Ent timeup = new Ent();
		timeup.setName("timeup");
		timeup.setImg(Game.getGlobal().getImgByName("logoTimeUp"));
		timeup.setPosBox(new Rectangle((int) ((Gdx.graphics.getWidth()/2)-(timeup.getImg().getTex().getWidth()/2)),
				Gdx.graphics.getHeight() - timeup.getImg().getTex().getHeight() - 200,
				timeup.getImg().getTex().getWidth(),
				timeup.getImg().getTex().getHeight()));
		timeup.setDisplay(false);
		ents.add(timeup);
		
		Ent scaleup = new Ent();
		scaleup.setName("scaleup");
		scaleup.setImg(Game.getGlobal().getImgByName("logoScaledUp"));
		scaleup.setPosBox(new Rectangle((int) ((Gdx.graphics.getWidth()/2)-(scaleup.getImg().getTex().getWidth()/2)),
				Gdx.graphics.getHeight() - scaleup.getImg().getTex().getHeight() - 200,
				scaleup.getImg().getTex().getWidth(),
				scaleup.getImg().getTex().getHeight()));
		scaleup.setDisplay(false);
		ents.add(scaleup);
		
		Ent btnReplay = new Ent();
		btnReplay.setName("btnReplay");
		btnReplay.setId(1);
		btnReplay.setImg(Game.getGlobal().getImgByName("btnReplay"));
		btnReplay.setPosBox(new Rectangle(
				(Gdx.graphics.getWidth()/2)-(btnReplay.getImg().getTex().getWidth()/2),
				(Gdx.graphics.getHeight()/2)-(btnReplay.getImg().getTex().getHeight()/2),
				btnReplay.getImg().getTex().getWidth(),
				btnReplay.getImg().getTex().getHeight()));
		btnReplay.setDisplay(false);
		btnReplay.setSelected(true);
		ents.add(btnReplay);
		
		Ent btnBack = new Ent();
		btnBack.setName("btnBack");
		btnBack.setId(2);
		btnBack.setImg(Game.getGlobal().getImgByName("btnBack"));
		btnBack.setPosBox(new Rectangle(
				(Gdx.graphics.getWidth()/2)-(btnBack.getImg().getTex().getWidth()/2),
				btnReplay.getY() - btnBack.getImg().getTex().getHeight() - 3,
				btnBack.getImg().getTex().getWidth(),
				btnBack.getImg().getTex().getHeight()));
		btnBack.setDisplay(false);
		ents.add(btnBack);
		
		Ent greatScore = new Ent();
		greatScore.setName("greatScore");
		//greatScore.setFont(Game.getGlobal().getFontByName("leckerli30"));
		greatScore.setText("Great Score!");
		greatScore.setPosBox(new Rectangle(btnReplay.getX(),
				timeup.getY()+100,0,0));
		greatScore.setDisplay(false);
		ents.add(greatScore);
		
		this.setEnts(ents);
	}
	
	public void update (float stateTime){
		
	}

	public void buttonSelect(){
		Ent selected = this.getSelectedEnt();
		if (selected.getName().equals("btnReplay")){
			resetGame();
			Game.getGlobal().getSfxByName("papery").play();
		}
		if (selected.getName().equals("btnBack")){
			resetGame();
			Game.getGlobal().getSfxByName("papery").play();
			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("main"));
		}
	}
	
	public void buttonDeselect(){
		if (Gdx.input.isKeyJustPressed(GameConstants.KEY_QUIT)){
			resetGame();
			Game.getGlobal().getSfxByName("papery").play();
			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("main"));
		}
	}
	
	public void resetGame(){
		
	}
}
