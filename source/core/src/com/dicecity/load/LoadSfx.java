package com.slyvronline.game.load;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.slyvronline.game.Game;
import com.slyvronline.game.objects.Sfx;

public class LoadSfx {

	public static void load(){
		ArrayList<Sfx> sfx = new ArrayList<Sfx>();
		
		Sfx paperflip = new Sfx();
		paperflip.setName("paperflip");
		paperflip.setSound(Gdx.audio.newSound(Gdx.files.internal("data/sfx/paperflip.wav")));
		paperflip.setPitch(1.2f);
		paperflip.setPan(1);
		paperflip.setVolume(1.5f);
		paperflip.setLoop(false);
		sfx.add(paperflip);
		
		Sfx paper = new Sfx();
		paper.setName("paper");
		paper.setSound(Gdx.audio.newSound(Gdx.files.internal("data/sfx/paper.wav")));
		paper.setPitch(1.5f);
		paper.setPan(1);
		paper.setVolume(1.0f);
		paper.setLoop(false);
		sfx.add(paper);
		
		Sfx papery = new Sfx();
		papery.setName("papery");
		papery.setSound(Gdx.audio.newSound(Gdx.files.internal("data/sfx/papery.wav")));
		papery.setPitch(1);
		papery.setPan(1);
		papery.setVolume(1.0f);
		papery.setLoop(false);
		sfx.add(papery);
		
		Game.getGlobal().setSfx(sfx);
	}
}
