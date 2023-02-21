FROM maven:alpine as build
COPY . $HOME

RUN mvn dependency:resolve
RUN mvn package install

# Run the application
ENTRYPOINT mvn exec:java
