package com.dicecity.load;

import java.util.ArrayList;

import com.dicecity.Game;
import com.dicecity.objects.Menu;
import com.dicecity.objects.menus.GameMenu;
import com.dicecity.objects.menus.GamePauseMenu;
import com.dicecity.objects.menus.MainMenu;
import com.dicecity.objects.menus.SplashMenu;



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
		menus.add(new GameMenu());
		menus.add(new GamePauseMenu());
		
		Game.getGlobal().setMenus(menus);
		Game.getGlobal().setCurrentMenu(menus.get(0));
	}
}
