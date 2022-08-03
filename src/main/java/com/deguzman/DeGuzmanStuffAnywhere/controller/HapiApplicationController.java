package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/hapi-app")
@CrossOrigin
public class HapiApplicationController {

	@GetMapping("/run-application")
	public ResponseEntity<String> runPythonScript() throws IOException {
		
		String command = "java -jar ./src/main/resources/HAPI-application/HAPI2.2.0.jar";
		
		Process p = Runtime.getRuntime().exec(command);
		String result;
		
		
		if (p.isAlive()) {
			result = "Python script has ran...";
		} else {
			result = "Python script was not able to run";
		}
		
		
		return ResponseEntity.ok().body(result);
	}
}
