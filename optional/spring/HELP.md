# Read Me First
The following was discovered as part of building this project:

* Spring Cloud Gateway requires Spring WebFlux, your choice of Spring Web has been replaced accordingly.
* The original package name 'com.spring-tutorial.spring' is invalid and this project uses 'com.springtutorial.spring' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/#build-image)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/docs/3.1.4/reference/html/native-image.html#native-image)
* [Azure MySQL support](https://aka.ms/spring/msdocs/mysql)
* [Azure PostgreSQL support](https://aka.ms/spring/msdocs/postgresql)
* [Spring Integration JMS Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/jms.html)
* [Spring Integration AMQP Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/amqp.html)
* [Spring Integration JDBC Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/jdbc.html)
* [Spring Integration JPA Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/jpa.html)
* [Spring Integration R2DBC Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/r2dbc.html)
* [Spring Integration Redis Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/redis.html)
* [Spring Integration Test Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/testing.html)
* [Spring Integration Apache Kafka Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/kafka.html)
* [Spring Integration RSocket Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/rsocket.html)
* [Spring Integration Security Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/security.html)
* [Spring Integration WebFlux Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/webflux.html)
* [Spring Integration STOMP Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/stomp.html)
* [Spring Integration WebSocket Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/web-sockets.html)
* [Spring Integration Web Services Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/ws.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#using.devtools)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#appendix.configuration-metadata.annotation-processor)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#features.docker-compose)
* [Spring Modulith](https://docs.spring.io/spring-modulith/docs/current/reference/html/)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.reactive)
* [Spring for GraphQL](https://docs.spring.io/spring-boot/docs/$3.1.4/reference/htmlsingle/index.html#web.graphql)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [Spring HATEOAS](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.spring-hateoas)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#io.webservices)
* [Jersey](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.servlet.jersey)
* [Vaadin](https://vaadin.com/docs)
* [Hilla](https://hilla.dev/)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Apache Freemarker](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Mustache](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Groovy Templates](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.security)
* [OAuth2 Client](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.security.oauth2.client)
* [OAuth2 Authorization Server](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.security.oauth2.authorization-server)
* [OAuth2 Resource Server](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.security.oauth2.server)
* [Spring LDAP](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#data.nosql.ldap)
* [Okta Spring Boot documentation](https://github.com/okta/okta-spring-boot#readme)
* [JDBC API](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#data.sql)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#data.sql.jdbc)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#data.sql.r2dbc)
* [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
* [Liquibase Migration](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#howto.data-initialization.migration-tool.liquibase)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#howto.data-initialization.migration-tool.flyway)
* [JOOQ Access Layer](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#data.sql.jooq)
* [Spring Integration](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#messaging.spring-integration)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#messaging.amqp)
* [Spring for Apache ActiveMQ 5](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#messaging.jms.activemq)
* [GCP Support](https://googlecloudplatform.github.io/spring-cloud-gcp/reference/html/index.html)
* [GCP Storage](https://googlecloudplatform.github.io/spring-cloud-gcp/reference/html/index.html#cloud-storage)
* [GCP Messaging](https://googlecloudplatform.github.io/spring-cloud-gcp/reference/html/index.html#cloud-pubsub)
* [Spring Cloud Azure developer guide](https://aka.ms/spring/msdocs/developer-guide)
* [Gateway](https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/)
* [WebSocket](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#messaging.websockets)
* [Apache Kafka Streams Support](https://docs.spring.io/spring-kafka/docs/current/reference/html/#streams-kafka-streams)
* [Apache Kafka Streams Binding Capabilities of Spring Cloud Stream](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/index.html#_kafka_streams_binding_capabilities_of_spring_cloud_stream)
* [Spring for Apache Pulsar](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#messaging.pulsar)
* [Cloud Bootstrap](https://docs.spring.io/spring-cloud-commons/docs/current/reference/html/)
* [Config Client Quick Start](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_client_side_usage)
* [Eureka Discovery Client](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#service-discovery-eureka-clients)
* [Cloud Stream](https://docs.spring.io/spring-cloud-stream/docs/current/reference/html/spring-cloud-stream.html#spring-cloud-stream-overview-introducing)
* [Task](https://docs.spring.io/spring-cloud-task/docs/current/reference/html/)
* [Cloud LoadBalancer](https://docs.spring.io/spring-cloud-commons/docs/current/reference/html/#spring-cloud-loadbalancer)
* [Spring Data Redis (Access+Driver)](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#data.nosql.redis)
* [Spring Data Reactive Redis](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#data.nosql.redis)
* [Resilience4J](https://docs.spring.io/spring-cloud-circuitbreaker/docs/current/reference/html/#configuring-resilience4j-circuit-breakers)
* [Cloud Bus](https://docs.spring.io/spring-cloud-bus/docs/current/reference/html/)
* [Function](https://docs.spring.io/spring-cloud-function/docs/current/reference/html/spring-cloud-function.html)
* [Config Server](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_spring_cloud_config_server)
* [Vault Client Quick Start](https://docs.spring.io/spring-cloud-vault/docs/current/reference/html/#client-side-usage)
* [Apache Zookeeper Quick Start](https://docs.spring.io/spring-cloud-zookeeper/docs/current/reference/html/#distributed-configuration-usage)
* [Spring Cloud Consul Quick Start](https://docs.spring.io/spring-cloud-consul/docs/current/reference/html/#distributed-configuration-usage)
* [Eureka Server](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#spring-cloud-eureka-server)
* [Apache Zookeeper Discovery](https://docs.spring.io/spring-cloud-zookeeper/docs/current/reference/html/#spring-cloud-zookeeper-discovery)
* [Consul Discovery](https://docs.spring.io/spring-cloud-consul/docs/current/reference/html/#spring-cloud-consul-discovery)
* [OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
* [Contract Verifier](https://cloud.spring.io/spring-cloud-contract/reference/htmlsingle/)
* [Contract Stub Runner](https://cloud.spring.io/spring-cloud-contract/reference/htmlsingle/index.html#features-stub-runner)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#messaging.kafka)
* [Getting started with Solace and Spring](https://www.solace.dev/start-spring-io-help/)
* [Solace Developer Portal](https://solace.dev)
* [Spring for Apache Pulsar (Reactive)](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#messaging.pulsar)
* [RSocket](https://rsocket.io/)
* [Spring for Apache ActiveMQ Artemis](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#messaging.jms.artemis)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Building a GraphQL service](https://spring.io/guides/gs/graphql-server/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Creating CRUD UI with Vaadin](https://spring.io/guides/gs/crud-with-vaadin/)
* [Next Steps with Hilla](https://hilla.dev/docs/react/start/quick/#coming-from-spring-initializr)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Okta-Hosted Login Page Example](https://github.com/okta/samples-java-spring/tree/master/okta-hosted-login)
* [Custom Login Page Example](https://github.com/okta/samples-java-spring/tree/master/custom-login)
* [Okta Spring Security Resource Server Example](https://github.com/okta/samples-java-spring/tree/master/resource-server)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Accessing data with R2DBC](https://spring.io/guides/gs/accessing-data-r2dbc/)
* [MyBatis Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Integrating Data](https://spring.io/guides/gs/integration/)
* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
* [Java Message Service API via Apache ActiveMQ Classic.](https://spring.io/guides/gs/messaging-jms/)
* [GCP Samples](https://github.com/GoogleCloudPlatform/spring-cloud-gcp/tree/main/spring-cloud-gcp-samples)
* [GCP Storage](https://github.com/GoogleCloudPlatform/spring-cloud-gcp/tree/main/spring-cloud-gcp-samples/spring-cloud-gcp-storage-resource-sample)
* [GCP Pub/Sub Sample](https://github.com/GoogleCloudPlatform/spring-cloud-gcp/tree/main/spring-cloud-gcp-samples/spring-cloud-gcp-pubsub-sample)
* [Deploying a Spring Boot app to Azure](https://spring.io/guides/gs/spring-boot-for-azure/)
* [Using Spring Cloud Gateway](https://github.com/spring-cloud-samples/spring-cloud-gateway-sample)
* [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)
* [Samples for using Apache Kafka Streams with Spring Cloud stream](https://github.com/spring-cloud/spring-cloud-stream-samples/tree/master/kafka-streams-samples)
* [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)
* [Client-side load-balancing with Spring Cloud LoadBalancer](https://spring.io/guides/gs/spring-cloud-loadbalancer/)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)
* [Centralized Configuration](https://spring.io/guides/gs/centralized-configuration/)
* [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)
* [Messaging with JMS](https://spring.io/guides/gs/messaging-jms/)
* [Using Apache Camel with Spring Boot](https://camel.apache.org/camel-spring-boot/latest/spring-boot.html)

### Additional Links
These additional references should also help you:

* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/htmlsingle/#aot)
* [R2DBC Homepage](https://r2dbc.io)
* [Azure Samples](https://aka.ms/spring/samples)
* [Various sample apps using Spring Cloud Function](https://github.com/spring-cloud/spring-cloud-function/tree/main/spring-cloud-function-samples)
* [Declarative REST calls with Spring Cloud OpenFeign sample](https://github.com/spring-cloud-samples/feign-eureka)

## OAuth 2.0 and OIDC with Okta

If you don't have a free Okta developer account, you can create one with [the Okta CLI](https://cli.okta.com):

```bash
$ okta register
```

Then, register your Spring Boot app on Okta using:

```bash
$ okta apps create
```

Select **Web** > **Okta Spring Boot Starter** and accept the default redirect URIs.

### Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* mariadb: [`mariadb:latest`](https://hub.docker.com/_/mariadb)
* mysql: [`mysql:latest`](https://hub.docker.com/_/mysql)
* oracle: [`gvenzl/oracle-xe:latest`](https://hub.docker.com/r/gvenzl/oracle-xe)
* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)
* rabbitmq: [`rabbitmq:latest`](https://hub.docker.com/_/rabbitmq)
* redis: [`redis:latest`](https://hub.docker.com/_/redis)
* sqlserver: [`mcr.microsoft.com/mssql/server:latest`](https://mcr.microsoft.com/en-us/product/mssql/server/about/)

Please review the tags of the used images and set them to the same as you're running in production.

## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks
If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image -Pnative
```

Then, you can run the app like any other container:

```
$ docker run --rm -p 8080:8080 spring:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools
Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./mvnw native:compile -Pnative
```

Then, you can run the app as follows:
```
$ target/spring
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
$ ./mvnw test -PnativeTest
```

