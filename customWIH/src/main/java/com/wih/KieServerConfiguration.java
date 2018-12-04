package com.wih;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;

public class KieServerConfiguration {
	
	protected String serverURL="http://localhost:8080/kie-server/services/rest/server";   
	protected String kieUser="rhpamAdmin";    
    protected String password="rhpamAdmin@1";
    
    private KieServicesConfiguration configureKieServices(){        
    	KieServicesConfiguration kieConfiguration = null;
        kieConfiguration = KieServicesFactory.newRestConfiguration(serverURL,kieUser,password);
        kieConfiguration.setMarshallingFormat(MarshallingFormat.XSTREAM);
        return kieConfiguration;
    }

    public KieServicesClient getKieClient() {
        KieServicesClient kieServicesClient = null;        
        KieServicesConfiguration configuration = configureKieServices();
        kieServicesClient =  KieServicesFactory.newKieServicesClient(configuration);
        return kieServicesClient;

    }

}
