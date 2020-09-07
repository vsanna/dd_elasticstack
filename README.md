This project is sandbox for ElasticStack.
It also includes one java application and kafka stack as log generator.



## how to start
```bash
# 1. start kafka and ElasticStack
$ docker-compose up -d

# 2. start java application

# 3. open kibana
$ open http://localhost:5601
```

## system components

- java application(sample_app)
    - port: 8080
    - send logs to Kafka via Log4j2
- Kafka
    - port: 9092, 29092
    - receives logs and pass them to LogStash
    - topic is: applicationlog
- LogStash
    - port: 5044, 9600
    - receives logs and pass them to ElasticSearch
    - it does log-rotation
        - ex. applicationlog-2020-01-01
- ElasticSarch
    - port: 9200, 9300
- Kibana
    - port: 5601


## commands
※ make sure that your docker process can allocate at least 8GM memory for docker containers

```bash
# confirm initialization
curl localhost:9200
curl localhost:9200/_cluster/health

# create index as test
curl -X POST localhost:9200/first_idx/_doc -d '{"name": "tom", "age": 100}' -H "Content-Type: application/json"
GET /_cat/indices

# create logs
curl localhost:9000/hello
curl localhost:9000/world
curl -X POST localhost:9000/hello
curl -X POST localhost:9000/world
```