package com.obbo.cloud.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "document-service", fallback = DocumentClientFailure.class)
public interface DocumentClient {
	
	@RequestMapping("/documents")
	public String getDocuments();
}
