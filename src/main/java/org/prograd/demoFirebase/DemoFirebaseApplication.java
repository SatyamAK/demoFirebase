package org.prograd.demoFirebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class DemoFirebaseApplication {

	public static void main(String[] args) throws IOException {
		FileInputStream serviceAccount = new FileInputStream("src/main/resources/fir-project-7c315-firebase-adminsdk-p8u8f-73f0fbaa03.json");

		FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

		FirebaseApp.initializeApp(options);
		SpringApplication.run(DemoFirebaseApplication.class, args);
	}

}
