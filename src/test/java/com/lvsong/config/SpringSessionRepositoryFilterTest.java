package com.lvsong.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.Filter;

/**
 * Created by lvsong on 2/4/16.
 */
public class SpringSessionRepositoryFilterTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() {
//        applicationContext = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/session.xml");
    }

    @Test
    public void sessionBeanTest() {
//        Filter filter = applicationContext.getBean("springSessionRepositoryFilter", Filter.class);
//        Assert.assertNotNull(filter);
    }


}
