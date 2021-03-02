package com.dicecity.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.dicecity.Game;
import com.dicecity.utils.GameConstants;


/**
 * This class maintains all the data and entities required in a menu
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class Menu {

	private String name;
	private int id;
	private String type;
	private ArrayList<Ent> ents;
	private ArrayList<Menu> subMenus;
	private Menu currentSubMenu;
	private int controllerAxisTimer;
	
	public Menu(){
		
	}
	
	public void render(SpriteBatch batch){
		for(Ent e : ents){
			e.render(batch);
		}
	}
	
	public void update(float stateTime){
		
	}
	
	public static void updateButtonHover(){
		
	}
	
	public void updateKeyboardNavigation(){
		if (Gdx.input.isKeyJustPressed(GameConstants.FIRST_KEY_DOWN) || Gdx.input.isKeyJustPressed(GameConstants.SEC_KEY_DOWN)){
			downButton();
		}
		if (Gdx.input.isKeyJustPressed(GameConstants.FIRST_KEY_UP) || Gdx.input.isKeyJustPressed(GameConstants.SEC_KEY_UP)){
			upButton();
		}
	}
	
	public void updateKeyboardSelect(){
		if (Gdx.input.isKeyJustPressed(GameConstants.FIRST_KEY_A) || Gdx.input.isKeyJustPressed(GameConstants.SEC_KEY_A)){
			buttonSelect();
		}
		if (Gdx.input.isKeyJustPressed(GameConstants.FIRST_KEY_B) || Gdx.input.isKeyJustPressed(GameConstants.SEC_KEY_B) || Gdx.input.isKeyJustPressed(GameConstants.KEY_QUIT)){
			buttonDeselect();
		}
	}
	
	public void updateMouseHover() {
		Rectangle mousePos = new Rectangle(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY(),1,1);
		for (Ent e : ents) {
			if (mousePos.overlaps(e.getPosBox())) {
				e.setSelected(true);
			}
			else {
				e.setSelected(false);
			}
		}
	}
	
	public void updateMouseSelect() {
		if (Gdx.input.isButtonJustPressed(0)) {
			Rectangle mousePos = new Rectangle(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY(),1,1);
			for(Ent e : ents) {
				if (mousePos.overlaps(e.getPosBox())) {
					buttonSelect();
				}
			}
		}
	}
	
	public void buttonSelect(){
		
	}
	
	public void buttonDeselect(){
		
	}
	
	public void downButton(){
		//Navigate btn to next one down
		Ent selected = this.getSelectedEnt();
		if (selected != null){
			int nextId = selected.getId() + 1;
			if (selected.getId() == this.getMaxBtnId()){
				nextId = 1;
			}
			else{
				if (this.getEntById(nextId) == null){
					nextId = 1;
				}
			}
			if (this.getEntById(nextId) != null && !this.getEntById(nextId).isSelected()){
				Game.getGlobal().getSfxByName("paperflip").play();
			}
			selected.setSelected(false);
			if (this.getEntById(nextId) != null) this.getEntById(nextId).setSelected(true);
		}
	}
	
	public void upButton(){
		//Navigate btn to next one up
		Ent selected = this.getSelectedEnt();
		if (selected != null){
			int nextId = selected.getId() - 1;
			if (selected.getId() <= 1){
				nextId = this.getMaxBtnId();
			}
			else{
				if (this.getEntById(nextId) == null){
					nextId = 1;
				}
			}
			if (this.getEntById(nextId) != null && !this.getEntById(nextId).isSelected()){
				Game.getGlobal().getSfxByName("paperflip").play();
			}
			selected.setSelected(false);
			if (this.getEntById(nextId) != null) this.getEntById(nextId).setSelected(true);
		}
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
	public ArrayList<Ent> getEnts() {
		return ents;
	}
	public void setEnts(ArrayList<Ent> ents) {
		this.ents = ents;
	}
	public ArrayList<Menu> getSubMenus(){
		return subMenus;
	}
	public void setSubMenus(ArrayList<Menu> subMenus){
		this.subMenus=subMenus;
	}
	public Menu getCurrentSubMenu(){
		return currentSubMenu;
	}
	public void setCurrentSubMenu(Menu currentSubMenu){
		this.currentSubMenu=currentSubMenu;
	}
	public void setCurrentSubMenuByName(String menuName){
		for(Menu subMenu : subMenus){
			if (menuName.equals(subMenu.getName())){
				this.currentSubMenu = subMenu;
				break;
			}
		}
	}
	public Ent getEntByName(String name){
		for(Ent e : ents)
			if (e.getName().equals(name)) return e;
		return null;
	}
	public Menu getSubMenuByName(String name){
		for(Menu m : subMenus)
			if (m.getName().equals(name)) return m;
		return null;
	}
	public int getMaxBtnId(){
		int maxId = 1;
		for(Ent e : this.getEnts()){
			if (maxId < e.getId()) maxId = e.getId();
		}
		return maxId;
	}
	public Ent getEntById(int id){
		for(Ent e : this.getEnts())
			if (e.getId() == id) return e;
		return null;
	}
	public int getControllerAxisTimer() {
		return controllerAxisTimer;
	}
	public void setControllerAxisTimer(int controllerAxisTimer) {
		this.controllerAxisTimer = controllerAxisTimer;
	}
	public Ent getSelectedEnt(){
		for(Ent e : this.getEnts())
			if (e.isSelected() && e.getName().contains("btn")) return e;
		return null;
	}
}
