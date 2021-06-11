package com.qa.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.crud.domain.Hero;

@Repository
public interface  HeroRepo extends JpaRepository<Hero,Long> {
	
}
