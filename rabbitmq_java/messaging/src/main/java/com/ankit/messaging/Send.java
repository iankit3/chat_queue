package com.ankit.messaging;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.ankit.models.Message;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Send {

	private final static String QUEUE_NAME = "hello";

	@GetMapping("/send")
	public Message sendMessage(@RequestParam(value="msg", defaultValue="hi") String message) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
			System.out.println(" [x] Sent '" + message + "'");
		}
		return new Message(message);
	}

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = argv[0];
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
			System.out.println(" [x] Sent '" + message + "'");
		}
	}
}
