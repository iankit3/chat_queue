## chat_queue  
	- pub/sub using Apache Kafka

#How to RUN  
	Start Zookeeper - bin/zookeeper-server-start.sh config/zookeeper.properties  
	Start Kafka     - bin/kafka-server-start.sh config/server.properties  

	Start Producer - python producer.py  
	Start Consumer - python consumer.py  

