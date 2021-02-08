package com.dicecity.load;

import com.dicecity.Game;
import com.dicecity.objects.GameInstance;


public class LoadGame extends Thread{

	GameInstance gameInst;
	private boolean newgame;
	
	public LoadGame() {
		
	}
	
	public LoadGame(boolean newgame) {
		this.newgame=newgame;
	}
	
	public void run(){
		try{
			gameInst = new GameInstance();
			
			
			Game.getGlobal().setGame(gameInst);
		}
		catch(Exception ex){
			System.out.println("Hello I'm the exception clause.");
			/*Game.writeLog("exception", ex);
			ex.printStackTrace();*/
		}
	}

}
