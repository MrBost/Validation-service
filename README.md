# Validation-service
A validation service for items listing on ebay

The service was developed using Reactive Spring and validation annotations for validating items.
The service has an .env file where config variables are stored. Kindly create a .env file and provide the values for the below properties:

APP_VERSION=v1
SERVER_PORT=9090
EBAY_HOST=
EBAY_PORT=
EBAY_CONTEXT_PATH=

Run the service by issuing the following command:
mvn spring-boot:run

once the service is started, you can access the endpoint via a POST request:
http://localhost:9090/api/v1/validate 
