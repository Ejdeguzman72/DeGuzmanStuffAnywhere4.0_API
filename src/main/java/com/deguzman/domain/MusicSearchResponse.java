package com.deguzman.domain;

import com.deguzman.DeGuzmanStuffAnywhere.model.Song;

public class MusicSearchResponse {

	public Song song;
	
	String message;
	
	String statusCode;
	
	String description;

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
