package com.dicecity.objects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * This class is the main source for everything to be loaded and where resources are pulled out.
 * Call Global.getImgByName(name) to retrieve any image you need, for instance.
 * 
 * This class also contains some basic variables to determine game defaults and setup information
 * 
 * The current variables keep track of what to be currently displaying or playing in the game.
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class Global {

	private ArrayList<Img> imgs;
	private ArrayList<AudioTrack> tracks;
	private ArrayList<Font> fonts;
	private ArrayList<Menu> menus;
	private ArrayList<Sfx> sfx;
	
	private Menu currentMenu;
	private AudioTrack currentTrack;
	private GameInstance game;
	
	private int defaultScreenWidth;
	private int defaultScreenHeight;
	private OrthographicCamera camera;
	private Rectangle viewport;
	private SpriteBatch batch;
	private SpriteBatch menuBatch;
	
	private float stateTime;
	
	public Global(){
		stateTime = 0f;
		batch = new SpriteBatch();
		menuBatch = new SpriteBatch();
	}
	
	public Img getImgByName(String name){
		for(Img img : imgs)
			if (name.equals(img.getName())) return img;
		return null;
	}
	public AudioTrack getTrackByName(String name){
		for(AudioTrack track : tracks)
			if (track.getName().equals(name)) return track;
		return null;
	}
	/*public Font getFontByName(String name){
		for(Font font : fonts)
			if (font.getName().equals(name)) return font;
		return null;
	}*/
	public Menu getMenuByName(String name){
		for(Menu menu : menus)
			if (name.equals(menu.getName())) return menu;
		return null;
	}
	public Sfx getSfxByName(String name){
		for(Sfx s : sfx)
			if (name.equals(s.getName())) return s;
		return null;
	}
	public Sfx getSfxById(long id){
		for(Sfx s : sfx)
			if (s.getId()==id) return s;
		return null;
	}
	public ArrayList<Img> getImgs() {
		return imgs;
	}
	public void setImgs(ArrayList<Img> imgs) {
		this.imgs = imgs;
	}
	public ArrayList<AudioTrack> getTracks() {
		return tracks;
	}
	public void setTracks(ArrayList<AudioTrack> tracks) {
		this.tracks = tracks;
	}
	public ArrayList<Font> getFonts() {
		return fonts;
	}
	public void setFonts(ArrayList<Font> fonts) {
		this.fonts = fonts;
	}
	public ArrayList<Menu> getMenus() {
		return menus;
	}
	public void setMenus(ArrayList<Menu> menus) {
		this.menus = menus;
	}
	public ArrayList<Sfx> getSfx() {
		return sfx;
	}
	public void setSfx(ArrayList<Sfx> sfx) {
		this.sfx = sfx;
	}
	public int getDefaultScreenWidth() {
		return defaultScreenWidth;
	}
	public void setDefaultScreenWidth(int defaultScreenWidth) {
		this.defaultScreenWidth = defaultScreenWidth;
	}
	public int getDefaultScreenHeight() {
		return defaultScreenHeight;
	}
	public void setDefaultScreenHeight(int defaultScreenHeight) {
		this.defaultScreenHeight = defaultScreenHeight;
	}
	public OrthographicCamera getCamera() {
		return camera;
	}
	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}
	public Rectangle getViewport() {
		return viewport;
	}
	public void setViewport(Rectangle viewport) {
		this.viewport = viewport;
	}
	public SpriteBatch getBatch() {
		return batch;
	}
	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}
	public SpriteBatch getMenuBatch() {
		return menuBatch;
	}
	public void setMenuBatch(SpriteBatch menuBatch) {
		this.menuBatch = menuBatch;
	}
	public Menu getCurrentMenu() {
		return currentMenu;
	}
	public void setCurrentMenu(Menu currentMenu) {
		this.currentMenu = currentMenu;
	}
	public AudioTrack getCurrentTrack() {
		return currentTrack;
	}
	public void setCurrentTrack(AudioTrack currentTrack) {
		this.currentTrack = currentTrack;
	}
	public GameInstance getGame(){
		return game;
	}
	public void setGame(GameInstance game){
		this.game=game;
	}
	public float getStateTime() {
		return stateTime;
	}
	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;
	}

}
