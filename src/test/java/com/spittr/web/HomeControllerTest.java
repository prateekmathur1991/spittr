package com.spittr.web;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.Test;

public class HomeControllerTest {
	
	@Test
	public void testHomePage()	{
		HomeController controller = new HomeController();
		// assertEquals("home", controller.home());
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
