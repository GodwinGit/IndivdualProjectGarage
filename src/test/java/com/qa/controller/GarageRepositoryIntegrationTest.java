package com.qa.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qa.model.Garage;
import com.qa.repository.GarageRepository;
import com.qa.App;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class GarageRepositoryIntegrationTest {

	@Autowired
	private GarageRepository garageRepository;

	@Test
	public void testFindAll() {
		List<Garage> vehicle = garageRepository.findAll();
		assertThat(vehicle.size(), is(greaterThanOrEqualTo(0)));
	}
	
}
