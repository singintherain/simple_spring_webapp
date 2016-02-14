package com.lvsong.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//import javax.servlet.Filter;

/**
 * Created by lvsong on 2/3/16.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration({"classpath:/conf/applicationContext.xml", "file:src/main/webapp/WEB-INF/web.xml" })
//@ContextConfiguration("file:src/main/webapp/WEB-INF/web.xml")
public class WebConfigTest {
//    @Autowired
//    private WebApplicationContext wac;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//
//    }
//
//    @Test
//    public void webConfigTest() throws Exception{
////        Filter filter = wac.getBean("springSessionRepositoryFilter", Filter.class);
////
////        Assert.assertNotNull(filter);
////        mockMvc.perform(get("/user/register.html")).andExpect(status().isOk());
////        Filter filter = wac.getBean("springSessionRepositoryFilter", Filter.class);
////
////        Assert.assertNotNull(filter);
//    }
}
