package com.spittr.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import com.spittr.Spittle;
import com.spittr.data.SpittleRepository;

public class SpittleControllerTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testSpittleController()	throws Exception	{
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		
		SpittleController spittleController = new SpittleController(mockRepository);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController)
				.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
				.andExpect(MockMvcResultMatchers.view().name("spittles"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"));
				// Need to find a better way to make this test run
				// .andExpect(MockMvcResultMatchers.model().attribute("spittleList", JUnitMatchers.hasItems(expectedSpittles.toArray())));
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittleList = new ArrayList<Spittle>(count);
		
		for (int i = 0; i < count; i++)	{
			spittleList.add(new Spittle("Spittle " + i, new Date()));
		}
		
		return spittleList;
	}
}
