package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class HapiApplicationController {

	@GetMapping(value = UriConstants.URI_RUN_HAPI_APP)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<String> runPythonScript() throws IOException {
		
		String command = "java -jar ./src/main/resources/HAPI-application/HAPI2.2.0.jar";
		
		Process p = Runtime.getRuntime().exec(command);
		String result;
		
		
		if (p.isAlive()) {
			result = "HAPI Applicatiopn has ran...";
		} else {
			result = "Failed to start HAPI application...";
		}
		return ResponseEntity.ok().body(result);
	}
}
