package com.demo.jersey;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

public class RestClient {

	private static final String REST_URI = "http://localhost:8080/hello";

	private Client client = ClientBuilder.newClient();

	public String getHello() {
		return client
				.target(REST_URI)
				//.path(String.valueOf(id))
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
	}
}