package com.deguzman.DeGuzmanStuffAnywhere.webcam;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sarxos.webcam.Webcam;

@RestController
@RequestMapping("/app/webcam")
@CrossOrigin
public class WebcamController {

	@Autowired
	private WebcamService webcamService;
	
	@GetMapping("/stream")
	public ResponseEntity<String> startWebcam() throws IOException {
		return webcamService.startWebcam(); 
	}
	
	@GetMapping("/record-video-log")
	public ResponseEntity<String> startVideoLogRecording() throws InterruptedException, IOException {
		return webcamService.recordVideoLog();
	}
	
	@GetMapping("/close")
	public ResponseEntity<String> closeWebcam() {
		return webcamService.closeWebcam();
	}
}
