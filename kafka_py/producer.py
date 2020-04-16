import json
from kafka import KafkaProducer
producer = KafkaProducer(bootstrap_servers='localhost:9092',value_serializer=lambda v: json.dumps(v).encode('utf-8'))

print("Keep entering your message")
while(True):
    user_input = raw_input("USER : ")
    producer.send("emo",{"ques" : user_input})



