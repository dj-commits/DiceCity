package com.dicecity;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.dicecity.objects.Global;
import com.dicecity.load.LoadFonts;
import com.dicecity.load.LoadGame;
import com.dicecity.load.LoadImgs;
import com.dicecity.load.LoadMenus;
import com.dicecity.load.LoadMusic;
import com.dicecity.load.LoadSfx;



public class Game extends ApplicationAdapter {
	private static Global global;
	
	
	@Override
	public void create () {
		global = new Global();
		LoadImgs.load();
		LoadFonts.load();
		LoadMenus.load();
		LoadMusic.load();
		LoadSfx.load();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		
		SpriteBatch batch = global.getBatch();
		SpriteBatch menuBatch = global.getMenuBatch();
		
		//UPDATES
		global.getCurrentMenu().update(global.getStateTime());
		if (global.getGame() != null){
			global.getGame().update();
		}
		
		//RENDERS
		//batch.setProjectionMatrix(global.getCamera().combined);
		batch.begin();
		if (global.getGame() != null){
			global.getGame().render(batch);
		}
		batch.end();
		
		menuBatch.begin();
		global.getCurrentMenu().render(menuBatch);
		menuBatch.end();
		
	}
	
	@Override
	public void dispose () {
	}
	
	public static Global getGlobal() {
		return global;
		
	}
}
