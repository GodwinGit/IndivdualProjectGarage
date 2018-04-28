package com.qa.controller;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.qa.controller.HomeController;

public class AppTest {

	@Test
    public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.home();
        assertEquals( result, "Godwin's Garage up and running : D" );
	}
}
