package com.lgc.ctps.sgec.service.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.lgc.ctps.sgec.service.KieServerConfiguration;

@RunWith(MockitoJUnitRunner.class)
public class KieServerConfigurationTest {

	@Spy
	KieServerConfiguration kieServerConfiguration = new KieServerConfiguration();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void configureKieServices() {
		KieServicesConfiguration KieServicesConfigurationMock = Mockito.mock(KieServicesConfiguration.class);
		Mockito.doReturn(KieServicesConfigurationMock).when(kieServerConfiguration).getKieServicesConfiguration();		
		KieServicesConfiguration kieServicesConfigurationReturned = kieServerConfiguration.configureKieServices();
		assertNotNull(kieServicesConfigurationReturned);

	}
	
	@Test
	public void getKieClientTest() {
		KieServicesConfiguration KieServicesConfigurationMock = Mockito.mock(KieServicesConfiguration.class);
		KieServicesClient kieServicesClientMock = Mockito.mock(KieServicesClient.class);
		Mockito.doReturn(KieServicesConfigurationMock).when(kieServerConfiguration).getKieServicesConfiguration();		
		Mockito.when(kieServerConfiguration.configureKieServices()).thenReturn(KieServicesConfigurationMock);
		Mockito.doReturn(kieServicesClientMock).when(kieServerConfiguration).getKieServicesClient(KieServicesConfigurationMock);
		KieServicesClient kieServicesClientReturned = kieServerConfiguration.getKieClient();
		assertNotNull(kieServicesClientReturned);
		
	}

}
