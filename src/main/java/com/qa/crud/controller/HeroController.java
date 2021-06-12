package com.qa.crud.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.crud.domain.Hero;
import com.qa.crud.service.HeroService;

@RestController
public class HeroController {
	private HeroService service;

	
	@Autowired
	public HeroController(HeroService services) {
		this.service = services;
	}
	@PostMapping("/create")
	public ResponseEntity<Hero> createHero(@RequestBody Hero hero){
		return new ResponseEntity<Hero>(
				this.service.createHero(hero),
				HttpStatus.CREATED);
	}
	@PostMapping("/allHeros")
	public ResponseEntity<List<Hero>> readAllHero(){
		return ResponseEntity.ok(this.service.readallHero());
	}
	@GetMapping("/Hero/{id}")
	public ResponseEntity<Hero> callHero(@PathVariable Long id){
		return ResponseEntity.ok(this.service.getHero(id));
	}
	@DeleteMapping("/snap/{id}")
	public ResponseEntity<Hero> removeHero(@PathVariable Long id){
		return this.service.removeHero(id) ? 
				new ResponseEntity<>
					(HttpStatus.NO_CONTENT) 
					: new ResponseEntity<>
						(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	public ResponseEntity<Hero> updateHero(
			@PathParam("realName") String realName, 
			@PathParam("heroName") String heroName, 
			@PathParam("universe") String universe, 
			@PathVariable int id)
		{
			return null;
	}
	
}
