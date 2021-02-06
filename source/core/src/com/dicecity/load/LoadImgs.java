package com.slyvronline.game.load;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.slyvronline.game.Game;
import com.slyvronline.game.objects.Img;
import com.slyvronline.game.utils.GameConstants;

/**
 * This class creates new Img classes to an arraylist containing a searchable name and the image data
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class LoadImgs {

	static ArrayList<Img> imgs;
	
	public static void load(){
		imgs = new ArrayList<Img>();
		
		//Set working directory to core/assets
		FileHandle fh = Gdx.files.local("data/");
		if (!fh.isDirectory()){
			System.out.println("Error with data directory!");
		}
		loadImgs(fh);
		
		Game.getGlobal().setImgs(imgs);
	}
	
	public static void loadImgs(FileHandle fh){
		for(FileHandle f : fh.list()){
			if (!f.isDirectory()){
				if (f.name().contains("png")){
					imgs.add(new Img(new Texture(Gdx.files.internal(f.path())),f.name().replace(".png", "")));
				}
			}
			else{
				loadImgs(f);
			}
		}
	}
}
