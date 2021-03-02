package com.dicecity.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.dicecity.Game;
import com.dicecity.utils.GameConstants;
import com.dicecity.utils.GameUtils;

public class DiceCityGameInstance extends GameInstance{
	
	private ArrayList<Ent> ents;
	
	public DiceCityGameInstance(){
		loadNewGame();
	}

	public void render(SpriteBatch batch){
		for(Ent e : ents) {
			e.render(batch);
		}
	}
	
	public void update(){
		cycleChevronBg();
	}
	
	public void loadNewGame() {
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		ents.addAll(GameUtils.buildChevronBG());
		
		int x=100;
		int y=100;
		
		for(Img i : Game.getGlobal().getImgs()) {
			if (i.getName().contains("card_")) {
				Ent newCard = new Ent();
				newCard.setName(i.getName());
				newCard.setImg(i);
				newCard.setPosBox(new Rectangle(x,
							y,
							i.getTex().getWidth(),
							i.getTex().getHeight()));
				newCard.setCollisionBox(new Rectangle(x,
							y,
							GameConstants.CARD_WIDTH,
							GameConstants.CARD_HEIGHT));
				newCard.setScale(0.4f);
				ents.add(newCard);
				
				x += newCard.getWidth()*newCard.getScale();
				
				if (x > Gdx.graphics.getWidth()-newCard.getWidth()*newCard.getScale()) {
					x = 100;
					y += newCard.getHeight()*newCard.getScale();
				}
			}
		}
		
		this.ents = ents;
	}
	
	public void cycleChevronBg(){
		for(Ent e : ents){
			if (e.getName().contains("chevron")){
				e.setX(e.getX() + 1);
				e.setY(e.getY() + 1);
			if (e.getX() >= e.getWidth()*4){
					e.setX(-e.getPosBox().getWidth());
				}
				if (e.getY() >= e.getHeight()*3){
					e.setY(-e.getPosBox().getHeight());
				}
			}
		}
	}
}
