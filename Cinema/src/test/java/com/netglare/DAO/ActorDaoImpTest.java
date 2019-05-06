package com.netglare.DAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.netglare.conf.AppConf;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={AppConf.class})
public class ActorDaoImpTest {
	
	@Autowired
	ActorDAO ad; 

	@Test
	public void testGetActors() {
		System.out.println(ad);
	}

}
