package com.demo.kafkademo.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kafkademo.Service.ProducerSevice;
import com.demo.kafkademo.beans.Customar;

@RestController
@RequestMapping("/producer-app")
public class ClientController {
	@Autowired
	ProducerSevice publisher;;

	@GetMapping("/publish")
	public ResponseEntity<Object> publishMessage(@RequestParam("message") String message)
			throws InterruptedException, ExecutionException {

		publisher.sendMsgToTopic(getJsonFileContent());

		return new ResponseEntity<Object>("ok", HttpStatus.OK);
	}

	
	public String getJsonFileContent() {

		try {
			
			return	StreamUtils.copyToString(new FileInputStream(new File("D:\\producer\\publish.json")), StandardCharsets.UTF_8);
		
			
			
	
		} catch (Exception e) { // TODO Auto-generated catch block
			return null;

		}
	}
}


