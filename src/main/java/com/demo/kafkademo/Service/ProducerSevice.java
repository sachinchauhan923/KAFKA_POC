package com.demo.kafkademo.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.demo.kafkademo.beans.Customar;

@Service
public class ProducerSevice {

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;

//this metod send message to topic 
	public void sendMsgToTopic(String message) throws InterruptedException, ExecutionException {
		try {
			CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("topic_1",0,"key1",message);
			System.out.println("PUBLISH ---"+future.get());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
