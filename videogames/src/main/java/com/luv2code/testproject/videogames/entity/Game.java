package com.luv2code.testproject.videogames.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "juego")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String name;

	@Column(name = "game_year")
	private int gameYear;

	@Column(name = "esrb")
	private String esrb;

	@Column(name = "company")
	private String company;

	@Column(name = "enable")
	private boolean enable;
	
	@ManyToMany( fetch = FetchType.LAZY ,
			cascade = { CascadeType.PERSIST, CascadeType.MERGE,
				CascadeType.DETACH, CascadeType.REFRESH} )
	@JoinTable(
			name = "juego_genero",
			joinColumns = @JoinColumn(name = "juego_id"),
			inverseJoinColumns = @JoinColumn(name = "genero_id")
			)
	private List<Genre> genres;
	
	@ManyToMany( fetch = FetchType.LAZY ,
			cascade = { CascadeType.PERSIST, CascadeType.MERGE,
				CascadeType.DETACH, CascadeType.REFRESH} )
	@JoinTable(
			name = "juego_plataforma",
			joinColumns = @JoinColumn(name = "juego_id"),
			inverseJoinColumns = @JoinColumn(name = "plataforma_id")
			)
	private List<Platform> platforms;

	public Game() {

	}

	public Game(String name, int gameYear, String esrb, String company) {
		this.name = name;
		this.gameYear = gameYear;
		this.esrb = esrb;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGameYear() {
		return gameYear;
	}

	public void setGameYear(int gameYear) {
		this.gameYear = gameYear;
	}

	public String getEsrb() {
		return esrb;
	}

	public void setEsrb(String esrb) {
		this.esrb = esrb;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public boolean getEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	

	public List<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<Platform> platforms) {
		this.platforms = platforms;
	}

	public void addGenre(Genre theGenre) {
		
		if(genres == null) {
			genres = new ArrayList<>();	
		}
		
		genres.add(theGenre);
	}
	
	public void addPlatform(Platform thePlatform) {
		
		if(platforms == null) {
			platforms = new ArrayList<>();	
		}
		
		platforms.add(thePlatform);
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", gameYear=" + gameYear + ", esrb=" + esrb + ", company="
				+ company + ", enable=" + enable + "]";
	}
	
	

}
