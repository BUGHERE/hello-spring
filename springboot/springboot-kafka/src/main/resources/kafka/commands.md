- 运行以下命令即可完成环境搭建(会自动下载并运行一个 zookeeper 和 kafka )
```
docker-compose -f zk-single-kafka-single.yml up
```
- 如果需要停止Kafka相关容器的话，运行以下命令即可
```
docker-compose -f zk-single-kafka-single.yml down
```