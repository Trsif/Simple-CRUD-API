package com.qa.crud.service;

import java.util.List;

import com.qa.crud.domain.Hero;

public class HeroServiceList {
	private List<Hero> Heros;
	public HeroServiceList (List<Hero> heros) {
		this.Heros = heros;
	}
	public Hero makeHero(Hero hero) {
		this.Heros.add(hero);
		Hero added = this.Heros.get(this.Heros.size()-1);
		return added;
	}
	public List<Hero> callHeros(){
		return this.Heros;
	}
	public Hero callHero(int id) {
		return this.Heros.get(id);
	}
	public boolean killHero(int id) {
		this.Heros.remove(id);
		return true;
	}
	public Hero updateHero(int id, Hero newHero) {
		this.Heros.set(id, newHero);
		return newHero;
	}
}
