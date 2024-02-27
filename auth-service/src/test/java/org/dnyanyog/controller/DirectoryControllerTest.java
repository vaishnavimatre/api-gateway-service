package org.dnyanyog.controller;

import javax.xml.xpath.XPathExpressionException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.annotations.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;


@SpringBootTest
@AutoConfigureMockMvc
 
public class DirectoryControllerTest extends AbstractTestNGSpringContextTests{

	@Autowired
	MockMvc mockMvc;
	
	@Test
	 public void   addUpdateUser() throws XPathExpressionException,Exception{
		RequestBuilder requestBuilder =MockMvcRequestBuilders.post("auth/user").content("  \"user_id\":1,\r\n"
				+ "    \"mobile_no\":873782,\r\n"
				+ "    \"role\":\"admin\",\r\n"
				+ "    \"username\":\"vaishnavi\",\r\n"
				+ "  \"email\":\"vaishnavimatre8@gmail.com\",\r\n"
				+ "  \"password\":\"pass@123\"").contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);
	
	mockMvc.perform(requestBuilder).andExpect(status().isCreated())
		.andExpect(xpath("//SignUpResponse/status").string("success"))
		.andExpect(xpath("//SignUpResponse/message").string("user added Successfully"))
		.andExpect(xpath("//SignUpResponse/user_id").string("1"))
		.andExpect(xpath("//SignUpResponse/user_name").string("vaishnavi"))
		.andExpect(xpath("//SignUpResponse/password").string("pass@123"))
		.andExpect(xpath("//SignUpResponse/email").string("vaishnavimatre8@gmail.com"))
		.andExpect(xpath("//SignUpResponse/age").string("20")).andReturn();
		
}
	@Test
	 public void   	getSingleUser() throws XPathExpressionException,Exception{
		RequestBuilder requestBuilder =MockMvcRequestBuilders.post("auth/user/{user_id}").contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);
	
	mockMvc.perform(requestBuilder).andExpect(status().isCreated())
		.andExpect(xpath("//SignUpResponse/status").string("success"))
		.andExpect(xpath("//SignUpResponse/message").string("user found"))
		.andExpect(xpath("//SignUpResponse/user_id").string("1"))
		.andExpect(xpath("//SignUpResponse/user_name").string("vaishnavi"))
		.andExpect(xpath("//SignUpResponse/password").string("pass@123"))
		.andExpect(xpath("//SignUpResponse/email").string("vaishnavimatre8@gmail.com"))
		.andExpect(xpath("//SignUpResponse/age").string("20")).andReturn();
		
}

	@Test
	 public void  	UpdateUser() throws XPathExpressionException,Exception{
		RequestBuilder requestBuilder =MockMvcRequestBuilders.post("auth/user").content("  \"username\":\"Omkar matre\",\r\n"
				+ "\"password\":\"pass@123\",\r\n"
				+ "\"age\":20,\r\n"
				+ "\"email\":\"omkaravi8@123\"").contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);
	
	mockMvc.perform(requestBuilder).andExpect(status().isCreated())
		.andExpect(xpath("//SignUpResponse/status").string("success"))
		.andExpect(xpath("//SignUpResponse/message").string("user updated Successfully"))
		.andExpect(xpath("//SignUpResponse/user_id").string("1"))
		.andExpect(xpath("//SignUpResponse/user_name").string("omkar"))
		.andExpect(xpath("//SignUpResponse/password").string("pass@123"))
		.andExpect(xpath("//SignUpResponse/email").string("omkaravi8@123"))
		.andExpect(xpath("//SignUpResponse/age").string("20"))
		.andReturn();
		
}

	@Test
	 public void   deletetSingleUser() throws XPathExpressionException,Exception{
		RequestBuilder requestBuilder =MockMvcRequestBuilders.post("auth/deleteuser/1").contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);
	
	mockMvc.perform(requestBuilder).andExpect(status().isCreated())
		.andExpect(xpath("//SignUpResponse/status").string("success"))
		.andExpect(xpath("//SignUpResponse/message").string("user deleted Successfully"))
		.andExpect(xpath("//SignUpResponse/user_id").string("1")).andReturn();
		
}

	
}