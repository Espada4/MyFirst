package com.netglare.DAO;

import java.util.List;

import com.netglare.entities.Actor;

public interface ActorDAO {
	
	public Actor getActorById(int id);
	public List<Actor> getActors();

}
