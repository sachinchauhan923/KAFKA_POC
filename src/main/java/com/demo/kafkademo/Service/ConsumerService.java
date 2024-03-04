package com.demo.kafkademo.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class ConsumerService {
	
	  private static final Logger log =
	 LoggerFactory.getLogger(ConsumerService.class);
	 
	/*
	 * private static final Logger log =
	 * LoggerFactory.getLogger(ConsumerService.class);
	 * 
	 * @KafkaListener(topics = "topic_1", groupId = "g_2", topicPartitions =
	 * { @TopicPartition(topic = "topic_1", partitionOffsets
	 * = @PartitionOffset(partition = "1", initialOffset = "0")) }) public void
	 * consume(String receivedMessage) {
	 * log.info("message acknowleged by listener 1 - {}", receivedMessage); }
	 * 
	 * 
	 * 
	 * @KafkaListener(topics = "topic_1", groupId = "g_2", topicPartitions =
	 * { @TopicPartition(topic = "topic_1", partitionOffsets
	 * = @PartitionOffset(partition = "0", initialOffset = "0")) }) public void
	 * consumeEvents(String receivedMessage) {
	 * log.info("message acknowleged by listener 2 - {}", receivedMessage); }
	 */
	
	
	
	@KafkaListener(topics = "topic_1", groupId = "g_2")
	public void consumeEvents(String receivedMessage) {
		log.info("message acknowleged by listener 2 - {}", receivedMessage);
		
		WriteToDir(receivedMessage);
		
	


	}
	
	
	private void WriteToDir(String message) {
        String outputFile = "D:\\consumer\\message.json"; // Path to output file
        // Sample JSON string

        // Gson instance
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(outputFile)) {
            // Convert the JSON string to JSON object
            gson.toJson(message, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
}
}

	
	

