package com.slyvronline.game.load;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.slyvronline.game.Game;
import com.slyvronline.game.objects.Font;

/**
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class LoadFonts {

	public static void load(){
		ArrayList<Font> fonts = new ArrayList<Font>();
		
		fonts.add(new Font("AgencyFbGlow32",32,new BitmapFont(Gdx.files.internal("data/fonts/AgencyFbGlow32.fnt"),false)));
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("data/fonts/Roboto-Regular.ttf"));
	    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
	    parameter.size = 60;
	    parameter.color = Color.WHITE;
	    parameter.borderWidth = 2;
	    BitmapFont fntRoboto60 = generator.generateFont(parameter);
	    
	    parameter.size = 30;
	    BitmapFont fntRoboto30 = generator.generateFont(parameter);
	    
	    parameter.size = 20;
	    BitmapFont fntRoboto20 = generator.generateFont(parameter);
	    
	    generator.dispose();
	    
	    
		
	    generator = new FreeTypeFontGenerator(Gdx.files.internal("data/fonts/LeckerliOne-Regular.ttf"));
	    parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
	    parameter.size = 60;
	    parameter.color = Color.WHITE;
	    parameter.borderWidth = 2;
	    BitmapFont fntLeckerliOne60 = generator.generateFont(parameter);
	    
	    parameter.size = 30;
	    BitmapFont fntLeckerliOne30 = generator.generateFont(parameter);
	    
	    parameter.size = 24;
	    BitmapFont fntLeckerliOne24 = generator.generateFont(parameter);
	    
	    generator.dispose();
	    
	    fonts.add(new Font("roboto60", 60, fntRoboto60));
	    fonts.add(new Font("leckerli60", 60, fntLeckerliOne60));
	    fonts.add(new Font("roboto30", 30, fntRoboto30));
	    fonts.add(new Font("leckerli30", 30, fntLeckerliOne30));
	    fonts.add(new Font("leckerli24", 24, fntLeckerliOne24));
	    fonts.add(new Font("roboto20", 20, fntRoboto20));
	    
		Game.getGlobal().setFonts(fonts);
	}
}
