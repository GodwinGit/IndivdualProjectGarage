package com.qa.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import com.qa.controller.GarageController;
import com.qa.model.Garage;
import com.qa.repository.GarageRepository;

public class GarageControllerTest {
	@InjectMocks
	private GarageController gc;

	@Mock
	private GarageRepository garageRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testGarageGet() {
    	Garage g = new Garage();
    	g.setId(1l);
		when(garageRepository.findOne(1l)).thenReturn(g);

		Garage vehicle = gc.get(1L);

		verify(garageRepository).findOne(1l);		

//		assertEquals(1l, vehicle.getId().longValue());	
		assertThat(vehicle.getId(), is(1l));
	}

}
