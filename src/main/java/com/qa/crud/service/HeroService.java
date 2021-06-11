package com.qa.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.crud.domain.Hero;
import com.qa.crud.repo.HeroRepo;
@Service
public class HeroService {
	private HeroRepo repo;
	public HeroService(HeroRepo repo) {
		super();
		this.repo = repo;
	}
	public Hero createHero(Hero hero ) {
		return this.repo.save(hero);
	}
	public List<Hero> readallHero(){
		return this.repo.findAll();
	}
	public Hero getHero(Long id) {
		Optional<Hero> r = this.repo.findById(id);
		if(r != null) {
			return r.get();
		}else {
			return null;
		}
	}
	
	public boolean removeHero(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	public Hero updateHero(Long id, Hero newHero) {
		Hero existing = this.getHero(id);
		existing.setRealName(newHero.getRealName());
		existing.setHeroName(newHero.getRealName());
		existing.setUniverse(newHero.getUniverse());
		Hero updated = this.repo.save(existing);
		return updated;
	}
}
