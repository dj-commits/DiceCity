package com.dicecity.objects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * This class specifies a font to be used with renderable text.
 * 
 * New fonts can be created using the BMFont tool or Hiero.
 * I prefer BMFont as Hiero can be buggy
 * 
 * BMFont: http://www.angelcode.com/products/bmfont/
 * Hiero: https://code.google.com/p/libgdx/wiki/Hiero
 * 
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class Font {

	private String name;
	private BitmapFont font;
	private int size;
	
	public Font(String name, int size, BitmapFont font){
		this.name=name;
		this.font=font;
		this.size=size;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BitmapFont getFont() {
		return font;
	}
	public void setFont(BitmapFont font) {
		this.font = font;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
