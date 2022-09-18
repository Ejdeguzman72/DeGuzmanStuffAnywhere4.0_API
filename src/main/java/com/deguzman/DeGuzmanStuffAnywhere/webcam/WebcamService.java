package com.deguzman.DeGuzmanStuffAnywhere.webcam;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IVideoPicture;
import com.xuggle.xuggler.video.ConverterFactory;
import com.xuggle.xuggler.video.IConverter;
import com.xuggle.xuggler.IPixelFormat;

@Service
public class WebcamService {

	public ResponseEntity<String> startWebcam() throws IOException {
		
		String message = null;
		Webcam webcam = Webcam.getDefault();
		
		try {
			new WebcamListener();
			webcam.setViewSize(WebcamResolution.VGA.getSize());
			webcam.open();
			
			BufferedImage image = webcam.getImage();
			
			ImageIO.write(webcam.getImage(), "PNG", new File("./src/main/resources/webcam/pictures/hello-world.png"));
			
			if (ImageIO.write(webcam.getImage(), "PNG", new File("./src/main/resources/webcam/pictures/hello-world.png"))) {
				message = "Image has been saved: " + webcam.getImage().toString();
			} else {
				message = "Image had issues saving";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			webcam.close();
		}
		
		return ResponseEntity.ok().body(message);
		
	}
	
	public ResponseEntity<String> recordVideoLog() throws InterruptedException, IOException {
		Webcam webcam = Webcam.getDefault();
		File file = new File("./src/main/resources/videos/output.mp4");
		
		try {
			
			// file.mkdirs();

			IMediaWriter writer = ToolFactory.makeWriter(file.getName());
			Dimension size = WebcamResolution.VGA.getSize();

			writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_H264, size.width, size.height);

			webcam.setViewSize(size);
			webcam.open(true);

			long start = System.currentTimeMillis();

			for (int i = 0; i < 50; i++) {

				System.out.println("Capture frame " + i);

				BufferedImage image = ConverterFactory.convertToType(webcam.getImage(), BufferedImage.TYPE_3BYTE_BGR);
				IConverter converter = ConverterFactory.createConverter(image, IPixelFormat.Type.YUV420P);

				IVideoPicture frame = converter.toPicture(image, (System.currentTimeMillis() - start) * 1000);
				frame.setKeyFrame(i == 0);
				frame.setQuality(0);

				writer.encodeVideo(0, frame);

				// 10 FPS
				Thread.sleep(100);
			}

			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			webcam.close();
		}
		
		String message = null;

		if (file.exists()) {
			message  = "Video recorded in file: " + file.getAbsolutePath();
		} else {
			message = "Error in creating file";
		}
		
		return ResponseEntity.ok().body(message);
		
	}
	
	public ResponseEntity<String> closeWebcam() {
		String message = null;
		Webcam webcam = Webcam.getDefault();
		webcam.close();
		
		if (webcam.close()) {
			message = "Closing Webcam...";
		} 
		
		return ResponseEntity.ok().body(message);
	}
	
}
