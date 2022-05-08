//package com.nnk.springboot.controllers;
//
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.nnk.springboot.domain.BidList;
//import com.nnk.springboot.repositories.BidListRepository;
//import com.nnk.springboot.service.BidListService;
//
////@WithMockUser(username = "user1", password = "pwd", roles = "ADMIN")
////@WebMvcTest(BidListController.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class BidListControllerTest {
//
//    //@MockBean
//   // AuthenticationService authenticationService;
//
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@MockBean
//	private BidListService bidListService;
//	
//	@MockBean
//	private BidListRepository bidListRepository;
//	
//	
//	
//	 @Test
//	    void validateTest() throws Exception {
//	        //Given
//	        BidList bidList = new BidList("account","type",10.0);
//	        //When
//	        Mockito.when(bidListService.save(bidList)).thenReturn(bidList);
//	        //Then
//	        mockMvc.perform(post("/bidList/validate")
//	        		.contentType(MediaType.APPLICATION_FORM_URLENCODED)
//	        		.content(String.valueOf(bidList)).with(csrf()));
//	                 //.andExpect(redirectedUrl("/bidList/list"));
//	    }
//	 
//	 @Test
//	    void validateTest2() throws Exception {
//	        //Given
//	        BidList bidList = new BidList("account2","type2",20.0);
//	        //When
//	        Mockito.when(bidListService.save(bidList)).thenReturn(bidList);
//	        //Then
//	        mockMvc.perform(post("/bidList/validate")
//	        		.contentType(MediaType.APPLICATION_FORM_URLENCODED)
//	        		.content(String.valueOf(bidList)).with(csrf()));
//	                 //.andExpect(redirectedUrl("/bidList/list"));
//	    }
//	 
//	 @Test
//	    void homeTest() throws Exception {
//	        //Given
//	        List<BidList> findAll = new ArrayList<>(Arrays.asList(new BidList("account","type",10.0),new BidList("account2","type2",20.0)));
//	        //WHEN
//	        Mockito.when(bidListService.findAll()).thenReturn(findAll);
//	        //THEN
//	        mockMvc.perform(get("/bidList/list"))
//	        .andDo(print())
//	                .andExpect(status().isOk())
//	                .andExpect(MockMvcResultMatchers.model().attributeExists("bidList"))
//	               .andExpect(MockMvcResultMatchers.model().attribute("bidList", findAll))
//	                .andExpect(view().name("bidList/list"))
//	      .andExpect(redirectedUrl("/bidList/list"));
//	    }
//
//
//}
