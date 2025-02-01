# InPost Technical assignment

### Run using IDE (e.g. IntelliJ)
- API tests runner - `src/test/java/ApiTestRunner.java`
- UI tests runner - `src/test/java/WebTestRunner.java`

*Environment properties:* `src/test/resources`
<br>
*Reports:* `target/cucumber-reports`
<br>
*JSON files from API tests:* `api-tests-output`

---

### Run using Maven (with profiles)
- API - `mvn clean test -Papi`
- WEB - `mvn clean test -Pweb`
- ALL - `mvn clean test -Pall-tests`


- To run on specific environment use (if not specified, dev is default) `-Denv=prod`, `-Denv=uat` or `-Denv=dev`
- To run on Selenium Grid use (if not specified, tests will run on local Chrome) `-DremoteDriverUrl=http://localhost:4444/wd/hub`

*Environment properties:* `src/test/resources`
<br>
*Reports:* `target/cucumber-reports`
<br>
*JSON files from API tests:* `api-tests-output`

---

### Run using Docker (Selenium GRID required)

1. Run Selenium GRID `docker run -d -p 4444:4444 --shm-size="2g" selenium/standalone-chrome:4.28.1-20250123`
2. Build project `docker build -t test-runner .`
3. Run `docker run -v C:\\docker-reports:/app/target/cucumber-reports -v C:\\api-tests-output:/app/api-tests-output -e MAVEN_PROFILE=all-tests -e ENVIRONMENT=dev -e REMOTE_DRIVER_URL=http://host.docker.internal:4444/wd/hub test-runner`

You can specify params:
- MAVEN_PROFILE=[all-tests, api, web]
- ENVIRONMENT=[dev, uat, prod]
- REMOTE_DRIVER_URL={Selenium grid URL}


*Environment properties:* `src/test/resources`
<br>
*Reports:* `C:\\docker-reports`
<br>
*JSON files from API tests:* `C:\\api-tests-output`

---

### Run using Docker Compose
1. Set up parameters in file `docker-compose.yml`
2. `docker-compose up`

or

`MAVEN_PROFILE=all-tests ENVIRONMENT=dev docker-compose up`

You can specify params:
- MAVEN_PROFILE=[all-tests, api, web]
- ENVIRONMENT=[dev, uat, prod]

*Environment properties:* `src/test/resources`
<br>
*Reports:* `docker-reports`
<br>
*JSON files from API tests:* `api-tests-output`
