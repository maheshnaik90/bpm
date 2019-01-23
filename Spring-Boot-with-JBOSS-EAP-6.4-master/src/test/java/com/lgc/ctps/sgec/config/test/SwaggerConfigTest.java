package com.lgc.ctps.sgec.config.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.lgc.ctps.sgec.config.SwaggerConfig;

import springfox.documentation.spring.web.plugins.Docket;

@RunWith(MockitoJUnitRunner.class)
public class SwaggerConfigTest {
	
	
	@Test
	public void postsApiTest() {		
		SwaggerConfig swaggerConfig=new SwaggerConfig();
		Docket docket = swaggerConfig.postsApi();
		assertNotNull(docket);
	}
	

}
