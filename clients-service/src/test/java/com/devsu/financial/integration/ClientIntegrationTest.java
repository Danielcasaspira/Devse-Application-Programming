package com.devsu.financial.integration;

import com.intuit.karate.junit5.*;
public class ClientIntegrationTest {

    @Karate.Test
    Karate testCreateClient() {
        return Karate.run("classpath:karate/clients/create-client.feature").relativeTo(getClass());
    }
}
