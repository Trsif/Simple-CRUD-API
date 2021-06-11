package com.qa.crud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String realName;
	private String heroName;
	private String universe;
	
	public Hero() {
		
	}
	
	public Hero(Long id, String realName, String heroName, String universe) {
		this.id = id;
		this.heroName = heroName;
		this.realName = realName;
		this.universe = universe;
	}
	public Hero(String realName, String heroName, String universe) {
		super();
		this.heroName = heroName;
		this.realName = realName;
		this.universe = universe;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public String getUniverse() {
		return universe;
	}
	public void setUniverse(String universe) {
		this.universe = universe;
	}
	
	
}
