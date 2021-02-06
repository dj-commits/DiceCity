package com.dicecity.objects;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.slyvronline.game.Game;
import com.slyvronline.game.utils.GameConstants;

/**
 * This is the most basic entity class.
 * This class represents anything that might be rendered to the screen, from menu items to
 * space ships, to the blocks that make up a space ship.
 * 
 * The posBox determines an entity's position on the screen as well as their rectangular dimensions
 * that are used in rendering.
 * The collisionBox determines the rectangular area that can collide with other Ents.
 * 
 * Color determines the shade that an entity may be rendered with.  Setting the color to white
 * makes it render in its normal colors.
 * 
 * Font and text determine whether this entity contains text data to be displayed on the screen.
 * Text is rendered through specified fonts and does not require a width or height, but should be managed
 * through new line characters (/n) when necessary
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class Ent {

	private String name;
	private int id;
	private String type;
	private String desc;
	private int hp;
	private int mp;
	private Rectangle collisionBox;
	private Rectangle posBox;
	private int centerX;
	private int centerY;
	private Font font;
	private String text;
	private Img img;
	private Color color;
	private float rotation;
	private boolean rotate;
	private int scaleX;
	private int scaleY;
	private boolean flipX;
	private boolean flipY;
	private float animSpeed;
	private boolean display;
	private int sleepTimer;
	private State state;
	private enum State {
		HOVER, CLICKED, JUMP, STAND, INJURED, DEAD
	}
	private boolean selected;
	
	public Ent(){
		color = Color.WHITE;
		scaleX=1;
		scaleY=1;
		animSpeed=1;
		this.posBox = new Rectangle();
		this.collisionBox = new Rectangle();
		this.display = true;
		this.flipX = false;
		this.flipY = false;
	}
	
	public Ent(Ent ent){
		this.name = ent.getName();
		this.id = ent.getId();
		this.type = ent.getType();
		this.collisionBox = new Rectangle(ent.getCollisionBox());
		this.posBox = new Rectangle(ent.getPosBox());
		this.centerX = ent.getCenterX();
		this.centerY = ent.getCenterY();
		this.font = ent.getFont();
		this.text = ent.getText();
		this.img = new Img(ent.getImg());
		this.color = ent.getColor();
		this.rotation = ent.getRotation();
		this.scaleX = ent.getScaleX();
		this.scaleY = ent.getScaleY();
		this.animSpeed = ent.getAnimSpeed();
		this.display = ent.isDisplay();
		this.state = ent.getState();
		this.flipX = ent.isFlipX();
		this.flipY = ent.isFlipY();
		this.selected = ent.isSelected();
	}
	
	public void render(SpriteBatch batch){
		if (this.isDisplay()){
			if (this.getColor() != null)
				batch.setColor(this.getColor());
			if (this.getImg() != null){
				
				if (this.getImg().getCurrentFrame() != null){
					batch.draw(this.getImg().getCurrentFrame(),
							this.getX(),
							this.getY(),
							this.getWidth(),
							this.getHeight());
				}
				else{
				
					if (this.isSelected()){
						Img hoverImg = Game.getGlobal().getImgByName(this.getImg().getName()+"_hover");
						if (hoverImg != null){
							this.setImg(hoverImg);
						}
					}
					else{
						if (this.getImg().getName().contains("_hover")){
							Img oldImg = Game.getGlobal().getImgByName(this.getImg().getName().replace("_hover", ""));
							if (oldImg != null){
								this.setImg(oldImg);
							}
						}
					}
					int srcX=0;
					int srcY=0;
					int srcWidth=this.getImg().getTex().getWidth();
					int srcHeight=this.getImg().getTex().getHeight();

					batch.draw(this.getImg().getTex(),
							this.getX(),
							this.getY(),
							this.getCenterX(),
							this.getCenterY(),
							this.getWidth(),
							this.getHeight(),
							this.getScaleX(),
							this.getScaleY(),
							this.getRotation(),
							srcX,
							srcY,
							srcWidth,
							srcHeight,
							this.isFlipX(),
							this.isFlipY());
				}
			}
			if (this.getFont() != null){
				this.getFont().getFont().setColor(this.getColor());
				//this.getFont().getFont().drawMultiLine(batch, this.getText(), this.getX(), this.getY());
				this.getFont().getFont().draw(batch, this.getText(), this.getX(), this.getY());
				this.getFont().getFont().setColor(Color.WHITE);
			}
			batch.setColor(Color.WHITE);
		}
	}
	
	public void setX(float x){
		this.posBox.setX(x);
		this.collisionBox.setX(x + (this.collisionBox.width/2));
	}
	
	public float getX(){
		return this.getPosBox().getX();
	}
	
	public void setY(float y){
		this.posBox.setY(y);
		this.collisionBox.setY(y + (this.collisionBox.height/2));
	}
	
	public float getY(){
		return this.getPosBox().getY();
	}
	
	public void setWidth(float width){
		this.posBox.setWidth(width);
	}
	
	public float getWidth(){
		return this.posBox.getWidth();
	}
	
	public void setHeight(float height){
		this.posBox.setHeight(height);
	}
	
	public float getHeight(){
		return this.posBox.getHeight();
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public Rectangle getCollisionBox() {
		return collisionBox;
	}
	public void setCollisionBox(Rectangle collisionBox) {
		this.collisionBox = collisionBox;
	}
	public Rectangle getPosBox() {
		return posBox;
	}
	public void setPosBox(Rectangle posBox) {
		this.posBox = posBox;
		this.collisionBox.x = this.posBox.x;
		this.collisionBox.y = this.posBox.y;
		this.centerX = (int) (this.posBox.getWidth()/2);
		this.centerY = (int) (this.posBox.getHeight()/2);
	}
	public int getCenterX() {
		return centerX;
	}
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	public int getCenterY() {
		return centerY;
	}
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Img getImg() {
		return img;
	}
	public void setImg(Img img) {
		this.img = img;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public float getRotation() {
		return rotation;
	}
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	public int getScaleX() {
		return scaleX;
	}
	public void setScaleX(int scaleX) {
		this.scaleX = scaleX;
	}
	public int getScaleY() {
		return scaleY;
	}
	public void setScaleY(int scaleY) {
		this.scaleY = scaleY;
	}
	public float getAnimSpeed() {
		return animSpeed;
	}
	public void setAnimSpeed(float animSpeed) {
		this.animSpeed = animSpeed;
	}
	public boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public boolean isFlipX() {
		return flipX;
	}
	public void setFlipX(boolean flipX) {
		this.flipX = flipX;
	}
	public boolean isFlipY() {
		return flipY;
	}
	public void setFlipY(boolean flipY) {
		this.flipY = flipY;
	}
	public int getSleepTimer() {
		return sleepTimer;
	}
	public void setSleepTimer(int sleepTimer) {
		this.sleepTimer = sleepTimer;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean isRotate() {
		return rotate;
	}
	public void setRotate(boolean rotate) {
		this.rotate = rotate;
	}
}
