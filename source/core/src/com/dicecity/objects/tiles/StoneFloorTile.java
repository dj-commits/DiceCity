package com.slyvronline.game.objects.tiles;

import com.badlogic.gdx.math.Rectangle;
import com.slyvronline.game.Game;

public class StoneFloorTile extends Tile{

	public StoneFloorTile(){
		this.setWalkable(true);
		this.setWallDown(false);
		this.setWallLeft(false);
		this.setWallRight(false);
		this.setWallUp(false);
		this.setName("tile_stonefloor");
		this.setImg(Game.getGlobal().getImgByName("basictiles"));
		this.getImg().setCurrentFrame(this.getImg().getTexRegs()[1]);
		this.setPosBox(new Rectangle());
		this.setWidth(16);
		this.setHeight(16);
	}
}
