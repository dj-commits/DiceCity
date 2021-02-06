package com.dicecity.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * This class maintains all the basic information for an image
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class Img {

	private String name;
	private int id;
	private String type;
	private Texture tex;
	private TextureRegion currentFrame;
	private TextureRegion[] texRegs;
	private Animation anim;
	
	public Img(Texture tex, String name){
		this.tex=tex;
		this.name=name;
		this.anim=null;
		this.texRegs = null;
	}
	public Img(Texture tex, String name, TextureRegion[] texRegs, float animSpeed){
		this.tex=tex;
		this.name=name;
		TextureRegion[] newRegs = new TextureRegion[12];
		for(int i=0; i<texRegs.length;i++){
			newRegs[i] = new TextureRegion(
					tex, 
					texRegs[i].getRegionX(),
					texRegs[i].getRegionY(),
					texRegs[i].getRegionWidth(),
					texRegs[i].getRegionHeight());
		}
		this.anim = new Animation(animSpeed,texRegs);
		this.texRegs=newRegs;
	}
	public Img(Img img){
		this.name = img.getName();
		this.id = img.getId();
		this.type = img.getType();
		this.tex = img.getTex();
		this.currentFrame = img.getCurrentFrame();
		this.texRegs = img.getTexRegs();
		this.anim = img.getAnim();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Texture getTex() {
		return tex;
	}
	public void setTex(Texture tex) {
		this.tex = tex;
	}
	public TextureRegion[] getTexRegs() {
		return texRegs;
	}
	public void setTexRegs(TextureRegion[] texRegs) {
		this.texRegs = texRegs;
	}
	public TextureRegion getCurrentFrame() {
		return currentFrame;
	}
	public void setCurrentFrame(TextureRegion currentFrame) {
		this.currentFrame = currentFrame;
	}
	public Animation getAnim() {
		return anim;
	}
	public void setAnim(Animation anim) {
		this.anim = anim;
	}
	
	
}
