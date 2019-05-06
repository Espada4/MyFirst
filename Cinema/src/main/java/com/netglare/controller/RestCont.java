package com.netglare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netglare.DAO.ActorDAO;
import com.netglare.entities.Actor;

@RestController
@RequestMapping("api")
public class RestCont {
	
	@Autowired
	ActorDAO actorImp;
	
	@GetMapping("/actors")
	public List<Actor> getActors() {
		return actorImp.getActors();
	}
}
