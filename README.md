# Quiz app RESTful Web Services

To run this project, you will need to change the following environment variables to your .env file

`DB_HOST`

`DB_PORT`

`DB_SCHEMA`

`DB_USERNAME`

`DB_PASSWORD`


#### Build & Run Docker containers
`./gradlew clean build`

`docker-compose up --build -d`

#### Start the project in development mode
`./mvnw quarkus:dev`

#### Access Web Services reference on `localhost:8080/swagger`

### Technology Stack 

<a href="https://www.oracle.com/java/" target="_blank" rel="noreferrer"><img src="https://img.shields.io/badge/Code-Java-informational?style=for-the-badge&logo=coffeescript&logoColor=white&color=2bbc8a" alt="Java" /></a>
<a href="https://www.quarkus.io/" target="_blank" rel="noreferrer"><img src="https://img.shields.io/badge/Framework-Quarkus-informational?style=for-the-badge&logo=quarkus&logoColor=white&color=2bbc8a" alt="Quarkus" /></a>
<a href="https://maven.apache.org/" target="_blank" rel="noreferrer"> <img src="https://img.shields.io/badge/Tool-Maven-informational?style=for-the-badge&logo=apachemaven&logoColor=white&color=2bbc8a" alt="Maven" /></a>
<a href="https://www.mysql.com/" target="_blank" rel="noreferrer"><img src="https://img.shields.io/badge/DB-MySQL-informational?style=for-the-badge&logo=mysql&logoColor=white&color=2bbc8a" alt="MySQL" /></a>