package com.dicecity.objects.tiles;

import java.util.ArrayList;

import com.slyvronline.game.objects.Ent;

public class Tile extends Ent {

	private boolean walkable;
	private boolean wallLeft;
	private boolean wallRight;
	private boolean wallUp;
	private boolean wallDown;
	private ArrayList<Ent> contents;
	
	public boolean isWalkable() {
		return walkable;
	}
	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}
	public boolean isWallLeft() {
		return wallLeft;
	}
	public void setWallLeft(boolean wallLeft) {
		this.wallLeft = wallLeft;
	}
	public boolean isWallRight() {
		return wallRight;
	}
	public void setWallRight(boolean wallRight) {
		this.wallRight = wallRight;
	}
	public boolean isWallUp() {
		return wallUp;
	}
	public void setWallUp(boolean wallUp) {
		this.wallUp = wallUp;
	}
	public boolean isWallDown() {
		return wallDown;
	}
	public void setWallDown(boolean wallDown) {
		this.wallDown = wallDown;
	}
	public ArrayList<Ent> getContents() {
		return contents;
	}
	public void setContents(ArrayList<Ent> contents) {
		this.contents = contents;
	}
	
}
