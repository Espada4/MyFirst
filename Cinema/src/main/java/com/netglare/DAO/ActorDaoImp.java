package com.netglare.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.netglare.entities.Actor;

@Service
public class ActorDaoImp implements ActorDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ActorDaoImp() {
		
	}

	@Override
	@Transactional
	public Actor getActorById(int id) {
		return sessionFactory.getCurrentSession().get(Actor.class, id);
	}
	

	@Override
	@Transactional
	public List<Actor> getActors() {
		return sessionFactory.getCurrentSession().createQuery("from Actor",Actor.class).getResultList();
	}

}
