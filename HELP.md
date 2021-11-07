##Task
(1 star)

 1.CREATE SERVICES: "MICRO-SENDER", "MICRO-RECIPIENT", "MICRO-COLLECTOR"
 
 2.CREATE "DOCKER-COMPOSE.YML", WITH THE FOLLOWING CONFIGURATION:

•	"micro-sender" should be in "sender" network

•	"micro-recipient" should be in "recipient" network

•	"rabbitmq" (you can find it into the docker-repository). This service should be in "sender" and 
"recipient" networks

•	"micro-collector" should be in "recipient"

•	Ports configuration

 3.THE "MICRO-SENDER" MUST BE CONFIGURED WITH THE FOLLOWING REQUIREMENTS:

•	REST endpoint (POST "/notification") receives the following JSON request: 
{ "user": "Name LastName", "message": "String" }

•	POST "/notification" call should add the "message" value from JSON to queue into "rabbitmq" service

•	POST "/notification" call should be logged by any Logger

4.THE "MICRO-RECIPIENT" MUST BE CONFIGURED WITH THE FOLLOWING REQUIREMENTS:

•	Must receive messages from "rabbitmq" service and collect it to List (you can use in-memory DB instead) 
every (N) second(-s) (use Spring Scheduler for it)

•	REST endpoint (GET "/message") returns List (or records from in-memory DB) and cleans it

•	Scheduler should be logged by any Logger

•	GET "/message" call should be logged by any Logger

5.THE "MICRO-COLLECTOR" MUST BE CONFIGURED WITH THE FOLLOWING REQUIREMENTS:

•	Must call GET "/message" from "micro-recipient" and log it every (M > N) second(-s). 
(use Spring Scheduler and ForeignClient)

•	Scheduler should be logged by any Logger

(2 stars)

6.UPDATE THE "DOCKER-COMPOSE.YML" WITH:

•	"prometheus". (u)se the "prom/prometheus" docker image)

•	"grafana" (use the "grafana/grafana" docker image)

7.UPDATE THE MICRO-SENDER, MICRO-RECIPIENT, MICRO-COLLECTOR TO COLLECT ALL METRICS ON "/ACTUATOR/PROMETHEUS"

8.ADD ADDITIONAL METRICS (YOU CAN RANDOMIZE IT) TO ONE OF YOUR SERVICES

9.CONFIGURE A "GRAFANA" SERVICE TO CONNECT AND VISUALIZE DATA FROM "PROMETHEUS"

10.OPEN A "GRAFANA" UI AND CHECK RESULTS (MAKE SCREENSHOT)

(3-4 stars)

11.MIGRATE ALL SERVICES (WITH "GRAFANA" AND "PROMETHEUS") TO KUBERNETES

12.CONFIGURE A "DEPLOYMENT.YAML" FOR YOUR SERVICES. TEST IT

13.ADD A "POSTGRES" SERVICE (USE "POSTGRES:LATEST" DOCKER IMAGE)

14.UPDATE THE "MICRO-COLLECTOR" TO SAVE DATA TO "POSTGRES"

15.ADD A "MICRO-VISUALIZER" SERVICE, WITH THE FOLLOWING CONFIGURATION:

- REST endpoint (GET "/saved-messages") returns data from "postgres" DB

16.RE-DEPLOY A NEW VERSION OF "MICRO-COLLECTOR" WITH ONE OF THE FOLLOWING DEPLOYMENT STRATEGIES (MAKE SCREENSHOT):

- Canary deployments

- A/B testing

- Blue-green deployments

17.CONFIGURE THE "PROMETHEUS" AND THE "MICRO-VISUALIZER" TO READ METRICS FROM THE "MICRO-VISUALIZER"

(5 stars)

18.UPDATE THE "MICRO-RECIPIENT" AND THE "MICRO-COLLECTOR" TO READ ONLY ONE MESSAGE PER CALL. 
CHANGE SCHEDULER'S TIME TO (5*N) FOR THE "MICRO-COLLECTOR"

19.RE-DEPLOY THE "MICRO-RECIPIENT" AND THE "MICRO-COLLECTOR" WITH ONE OF THE FOLLOWING DEPLOYMENT 
STRATEGIES (MAKE SCREENSHOT):

- Canary deployments

- A/B testing

- Blue-green deployments

20.ADD A FEW REPLICATION FOR THE "MICRO-COLLECTOR" SERVICE

21.CONFIGURE THE "PROMETHEUS" SERVICE TO COLLECT "MICRO-COLLECTOR" METRICS (FOR EACH REPLICATION) 
INTO THE SINGLE TASK

Create Pull Request with the solution's source code and screenshots




# Guides
http://localhost:8080/

http://localhost:8080/guests

http://localhost:8080/guests/1

http://localhost:8080/rooms

http://localhost:8080/rooms/1

http://localhost:8080/reservations

http://localhost:9000/

http://localhost:9000/guestservices/default

http://localhost:8800/guests

http://localhost:8801/reservations

http://localhost:8802/rooms

http://localhost:8761/

http://localhost:8080/room-reservations

http://localhost:8080/room-reservations?date=2020-01-01

http://localhost:8762/roomreservationservices/room-reservations?date=2020-01-01

http://localhost:8762/roomreservationservices/properties-from-value

http://localhost:8762/roomreservationservices/properties-from-dynamic