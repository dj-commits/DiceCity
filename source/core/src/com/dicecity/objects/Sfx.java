package com.dicecity.objects;

import com.badlogic.gdx.audio.Sound;

public class Sfx {

	private long id;
	private String name;
	private Sound sound;
	private float pitch;
	private float volume;
	private boolean loop;
	private float pan;
	
	public Sfx(){
		
	}
	
	public void play(){
		id = sound.play(volume);
		sound.setPitch(id, pitch);
		sound.setPan(id, pan, volume);
		sound.setLooping(id, loop);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sound getSound() {
		return sound;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public float getPan() {
		return pan;
	}

	public void setPan(float pan) {
		this.pan = pan;
	}
	
	
}
