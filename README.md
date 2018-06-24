Log tracker
==============================================
## Prerequisites
You need the following tools to build the project:
  * JDK 8 (**not 10**): http://www.oracle.com/technetwork/java/javase/downloads/index.html
  * Maven (3.5+ recommended): https://maven.apache.org/download.cgi
  
When everything is installed and `PATH` is configured, run `mvn -version` to make sure that it is using JDK 8.

## Building
Run the following command to build the project:
```
mvn clean package
```

## Running
Run the following command:
```
mvn exec:java
```

Open your web browser and visit http://localhost:8070/logs/{label} (it's endpoint for getting entries data by log label).
If you want put some entries in to log you must send json body on the  localhost:8070/logs/{label}/entries , such as

```
[
  {"data":"First data body"},	
  {"data":"Second data body"},	
  {"data":"Third data body"}
] 
```
