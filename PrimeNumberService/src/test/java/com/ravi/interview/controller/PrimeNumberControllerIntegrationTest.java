package com.ravi.interview.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ravi.interview.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=9090" })
@DirtiesContext
public class PrimeNumberControllerIntegrationTest {

    @Value("${local.server.port}")
    private int port;


    @Test
    public void test01() throws Exception {
        @SuppressWarnings("rawtypes")
        
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.port + "/primes/10", String.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(entity.getBody()).getAsJsonObject();
        Assert.assertEquals(10, jsonObject.get("initial").getAsInt());
        Assert.assertEquals(4, jsonObject.get("primes").getAsJsonArray().size());
    }

    @Test
    public void test02() throws Exception {
        @SuppressWarnings("rawtypes")
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.port + "/primes/11", String.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(entity.getBody()).getAsJsonObject();
        Assert.assertEquals(11, jsonObject.get("initial").getAsInt());
        Assert.assertEquals(5, jsonObject.get("primes").getAsJsonArray().size());
    }
}
