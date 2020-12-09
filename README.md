# AmerisaveCodeAssignment

List of things to do to make this application production ready.

1. Introduce resource metadata into ContactView (links and location) to make these rest endpoints RESTful. 
   This metadata should be filled at AppService level.

2. Think more about exception handling strategy.

3. Add tests for all levels of application.

4. Introduce security checks and validation.

5. Document rest apis using tools like Swagger.

6. Dockerize the application.

7. Write Kubernetes orchestrastration files.

8. Think about rest api versioning strategy.

SET UP:

1. Install maven.

2. Go into repository root and run: mvn clean spring-boot:run

EXAMPLES OF USAGE:

// create contact with id 1
curl -X POST -H "Content-Type:application/json" -d '{"firstName": "John", "lastName": "Smith", "email":"jsmith@gmail.com"}' http://localhost:8080/contacts

curl -X PUT -H "Content-Type:application/json" -d '{"firstName": "John1", "lastName": "Smith", "email":"jsmith@gmail.com"}' http://localhost:8080/contacts/1

curl -X GET -H "Content-Type:application/json" http://localhost:8080/contacts/1

curl -X DELETE -H "Content-Type:application/json"  http://localhost:8080/contacts/1







