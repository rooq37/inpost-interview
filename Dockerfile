# Official Maven image with Java 11
FROM maven:3.8.1-openjdk-11

# Copy the source code into the container
WORKDIR /app
COPY . /app

# Download the dependencies
RUN mvn install -DskipTests

# Default profile and environment, if not provided at runtime
ARG MAVEN_PROFILE=all-tests
ARG ENVIRONMENT=dev
ARG REMOTE_DRIVER_URL=http://host.docker.internal:4444/wd/hub

# Run the tests
CMD mvn test -P${MAVEN_PROFILE} -Denv=${ENVIRONMENT} -DremoteDriverUrl=${REMOTE_DRIVER_URL}
