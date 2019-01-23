package com.lgc.ctps.sgec.service;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;

public class KieServerConfiguration {
	
	protected String serverURL="http://localhost:8080/kie-server/services/rest/server";   
	protected String kieUser="rhpamAdmin";    
    protected String password="rhpamAdmin@1";
    
    public KieServicesConfiguration configureKieServices(){        
    	KieServicesConfiguration kieConfiguration = null;
        kieConfiguration = getKieServicesConfiguration();
        kieConfiguration.setMarshallingFormat(MarshallingFormat.JSON);
        return kieConfiguration;
    }

    public KieServicesClient getKieClient() {
        KieServicesClient kieServicesClient = null;        
        KieServicesConfiguration configuration = configureKieServices();
        kieServicesClient =  getKieServicesClient(configuration);
        return kieServicesClient;

    }
    
    public KieServicesConfiguration getKieServicesConfiguration() {
    	return KieServicesFactory.newRestConfiguration(serverURL,kieUser,password);
    }
    
    public KieServicesClient getKieServicesClient(KieServicesConfiguration configuration) {
    	return KieServicesFactory.newKieServicesClient(configuration);
    }
    
    

}
