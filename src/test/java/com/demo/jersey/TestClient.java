package com.demo.jersey;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClient {
	private static HttpServer httpServer;
	private static WebTarget target;

	@BeforeAll
	public static void beforeAllTests() {
		httpServer = MainApp.startServer();
		Client c = ClientBuilder.newClient();
		target = c.target(MainApp.BASE_URI);
	}

	@AfterAll
	public static void afterAllTests() {
		httpServer.stop();
	}

	@Test
	public void testHello() {
		String response = target.path("hello").request().get(String.class);
		assertEquals("Hello!!", response);
	}
}