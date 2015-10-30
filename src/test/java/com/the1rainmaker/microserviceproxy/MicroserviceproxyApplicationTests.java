package com.the1rainmaker.microserviceproxy;

import groovy.util.logging.Log;
import groovy.util.logging.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroserviceproxyApplication.class)
public class MicroserviceproxyApplicationTests {

	private String targetUrlPrefix = "http://api.ipinfodb.com/v3/ip-city/?key=TEST&ip=74.125.45.100&format=json";

	@Test
	public void contextLoads() {
		/** TODO: This version is TEMPORARY - use groovy version - FIX IT!!! */
		System.out.println("\n\nRunning MicroserviceproxyApplicationTests!");
		String proxyoutput = new PassiveLocatorService(targetUrlPrefix).getData();
		System.out.println("Output:"+proxyoutput+"\n\n");
	}
}
