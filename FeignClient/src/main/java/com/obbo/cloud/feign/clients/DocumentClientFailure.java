package com.obbo.cloud.feign.clients;

import org.springframework.stereotype.Component;

@Component
public class DocumentClientFailure implements DocumentClient {

	@Override
	public String getDocuments() {
		return "Document service is not avaiable";
	}
	
	
}
