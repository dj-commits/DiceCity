package com.dicecity.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * This class stores the data of a particular game instance, whether new or saved.
 * The galaxy can be used to dig down and find specific locations to travel to.
 * All other location variables are used to store which places the player in this
 * instance is currently located in.
 * 
 * The currentCollection determines the specific place that should currently be rendered
 * to the screen.
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class GameInstance {

	private boolean paused;
	
	public GameInstance(){
		
	}

	public void render(SpriteBatch batch){
		
	}
	
	int count=0;
	
	public void update(){
		
	}

	public boolean isPaused() {
		return paused;
	}
	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
