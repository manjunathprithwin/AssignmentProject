package com.assignment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.assignment.model.Response;
import com.assignment.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
class AssignmentJavaProjectApplicationTests {

private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Before
	public void setUp()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@org.junit.Test
	public void addUserTest() throws Exception {
	User user = new User();
	user.setName("xadmin");
	user.setRole("Admin");
	
	String JsonRequest = objectMapper.writeValueAsString(user);
	
	MvcResult result = mockMvc.perform(post("/user/addUser").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk()).andReturn();
	
	String resultContext = result.getResponse().getContentAsString();
	
	Response response = objectMapper.readValue(resultContext, Response.class);
	
	Assert.assertTrue(response.isStatus() == Boolean.TRUE);
		
	}
	
	@org.junit.Test
	public void getUserTest() throws Exception {
	
	MvcResult result = mockMvc.perform(get("/user/getUsers").contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk()).andReturn();
	
	String resultContext = result.getResponse().getContentAsString();
	
	Response response = objectMapper.readValue(resultContext, Response.class);
	
	Assert.assertTrue(response.isStatus() == Boolean.TRUE);

}}
