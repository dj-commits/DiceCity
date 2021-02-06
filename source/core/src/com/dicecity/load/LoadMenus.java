package com.slyvronline.game.load;

import java.util.ArrayList;

import com.slyvronline.game.Game;
import com.slyvronline.game.objects.Menu;
import com.slyvronline.game.objects.menus.CreditsMenu;
import com.slyvronline.game.objects.menus.GameMenu;
import com.slyvronline.game.objects.menus.GameSelectMenu;
import com.slyvronline.game.objects.menus.LevelEditMenu;
import com.slyvronline.game.objects.menus.MainMenu;
import com.slyvronline.game.objects.menus.SplashMenu;

/**
 * This class loads the in game menu screens and populates them with 
 * all the entities and where they're lcoated
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class LoadMenus {

	public static void load(){
		ArrayList<Menu> menus = new ArrayList<Menu>();
		
		menus.add(new SplashMenu());
		menus.add(new MainMenu());
		menus.add(new CreditsMenu());
		menus.add(new GameSelectMenu());
		menus.add(new GameMenu());
		menus.add(new LevelEditMenu());
		
		Game.getGlobal().setMenus(menus);
		Game.getGlobal().setCurrentMenu(menus.get(0));
	}
}
