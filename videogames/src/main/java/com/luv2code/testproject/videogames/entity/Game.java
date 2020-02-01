package com.luv2code.testproject.videogames.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Boolean enable;

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

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", gameYear=" + gameYear + ", esrb=" + esrb + ", company="
				+ company + ", enable=" + enable + "]";
	}

}
