package io.gmailClone;


import io.gmailClone.folders.FoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@SpringBootApplication
@RestController
public class InboxApp {

	@Autowired
	FoldersRepository foldersRepository;
	public static void main(String[] args) {
		SpringApplication.run(InboxApp.class, args);
	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer( DataStaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		CqlSessionBuilderCustomizer cqlSessionBuilderCustomizer = builder -> builder.withCloudSecureConnectBundle(bundle);
		return cqlSessionBuilderCustomizer;
	}

//	@PostConstruct
//	public void init(){
//		foldersRepository.save(new Folders("aauradkar","Inbox","blue"));
//		foldersRepository.save(new Folders("aauradkar","Sent Items","green"));
//		foldersRepository.save(new Folders("aauradkar","Important","red"));
//	}
}
