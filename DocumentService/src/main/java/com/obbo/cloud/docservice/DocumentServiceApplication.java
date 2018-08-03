package com.obbo.cloud.docservice;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obbo.cloud.docservice.model.Document;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/documents")
public class DocumentServiceApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DocumentServiceApplication.class, args);
	}

	private List<Document> documents = Arrays.asList(new Document(UUID.randomUUID(), "Document 1", "France"),
			new Document(UUID.randomUUID(), "Document 2", "China"));
	
	@GetMapping
	public List<Document> findAllDocuments() {
		LOGGER.info("GET DOCUMENTS : \n {}", documents);
		return documents;
	}
	
	@GetMapping("/{docId}")
	public Document findDocument(@PathVariable UUID docId) {
		return documents.stream().filter(d -> d.getId().equals(docId)).findFirst().orElse(null);
	}
}
