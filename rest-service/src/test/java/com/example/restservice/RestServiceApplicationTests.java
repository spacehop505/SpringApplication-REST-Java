package com.example.restservice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import database.FruitList;
import run.rest.RestServiceApplication;

//@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = { RestServiceApplication.class })
public class RestServiceApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private FruitList userService;

	//GET
	@Test
	public void testGet() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/fruit")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	// GET ID
	@Test
	public void testGetId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/fruit/1")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	// PUT
	@Test
	public void testPut() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.put("/create/fruit/1").contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
						.param("id", "1").param("name", "orange").param("price", "33").param("quantity", "33"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	//POST
	@Test
	public void testPost() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/update/fruit/1").contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
						.param("id", "1").param("name", "orange").param("price", "33").param("quantity", "33"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	//DELETE
	@Test
	public void testDelete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/delete/fruit/1")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE).param("id", "1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
