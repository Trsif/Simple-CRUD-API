package com.qa.crud.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.crud.domain.Hero;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HeroControllerTest {
	private MockMvc mock;
	
	private ObjectMapper mapper;
	
	@Test 
	void testCreate() throws Exception{
		Hero testMan = new Hero("Normal1","Hero1","Dc");
		String testManAsJson = this.mapper.writeValueAsString(testMan);
		RequestBuilder mockRequest =  post("create")
		.contentType(MediaType.APPLICATION_JSON)
		.content(testManAsJson);
		
		Hero savedHero = new Hero(1L,"Normal","Hero1","Dc");
		
		String savedHeroAsJson = this.mapper.writeValueAsString(savedHero);
		
		ResultMatcher matchStatus = status().isCreated();
		ResultMatcher matchBody = content().json(savedHeroAsJson);
		
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}
	
}
