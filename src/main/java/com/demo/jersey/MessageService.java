package com.demo.jersey;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface MessageService {
	String getHello();
}
