package com.dicecity.objects;

import com.badlogic.gdx.audio.Music;

/**
 * This object is used to contain music track information
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class AudioTrack {

	private String name;
	private Music music;
	private String trackName;
	private String artistName;
	private String contactText;
	private float pitch;
	private float volume;
	private boolean loop;
	private float pan;
	private float position;
	
	public AudioTrack(Music music, String name){
		this.music=music;
		this.name=name;
	}
	public AudioTrack(Music music, String name, String trackName, String artistName, String contactText){
		this.music=music;
		this.name=name;
		this.trackName=trackName;
		this.artistName=artistName;
		this.contactText=contactText;
	}
	
	public void play(){
		music.play();
		music.setVolume(volume);
		music.setPan(pan, volume);
		music.setLooping(loop);
		music.setPosition(position);
	}
	
	public void stop(){
		music.stop();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Music getMusic() {
		return music;
	}
	public void setMusic(Music music) {
		this.music = music;
	}
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getContactText() {
		return contactText;
	}
	public void setContactText(String contactText) {
		this.contactText = contactText;
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
	public float getPosition() {
		return position;
	}
	public void setPosition(float position) {
		this.position = position;
	}
	
	
}
