from kafka import KafkaProducer
producer = KafkaProducer(bootstrap_servers='localhost:9092')

print("Keep entering your message")
while(True):
    user_input = raw_input("USER : ")
    producer.send("emo",user_input)



