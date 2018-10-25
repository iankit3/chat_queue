from kafka import KafkaConsumer
consumer = KafkaConsumer()
consumer.subscribe(['message','emo'])

print("Below are the messages from the queue 'message'")
for msg in consumer:
    print (str(msg.key) +" : "+msg.value)
