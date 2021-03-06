package com.hand.entity;

import java.io.Serializable;
import java.util.Date;

public class Film implements Serializable {
	private int film_id;
	private String title;
	private String description;
	private int language_id;
	private String release_year;
	private int original_language_id;
	private int rental_duration;
	private int rental_rate;
	private int length;
	private int replacement_cost;
	private String rating;
	private String special_features;
	private Date last_update;
	private String language;
		
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	public String getRelease_year() {
		return release_year;
	}
	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}
	public int getOriginal_language_id() {
		return original_language_id;
	}
	public void setOriginal_language_id(int original_language_id) {
		this.original_language_id = original_language_id;
	}
	public int getRental_duration() {
		return rental_duration;
	}
	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}
	public int getRental_rate() {
		return rental_rate;
	}
	public void setRental_rate(int rental_rate) {
		this.rental_rate = rental_rate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getReplacement_cost() {
		return replacement_cost;
	}
	public void setReplacement_cost(int replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecial_features() {
		return special_features;
	}
	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	
	
}
