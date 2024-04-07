# TrainBookAPI
Creating a train ticket booking api

### Problem Statement
1. Code must be published in Github with a link we can access (use public repo).
2. Code must compile with some effort on unit tests, doesn't have to be 100%, but it shouldn't be 0%.
3. Please code this using Java
4. Adding a persistence layer will be cumbersome, so just store the data in your current session/in memory.
5. If a requirement is ambiguous or unclear, use your best judgment to interpret it and make what you believe are reasonable assumptions
6. When the assignment is ready, send the console output from your app-server and app-client. You can also include your reasonable assumptions and known limitations.

### Introduction

Created train ticket api to purchase, modify, remove and get the receipt details. Email id is unique and assign to respective user.

### Technology Used

1. Spring boot 3.1.0
2. JDK 17
3. Maven
4. Junit
5. H2 DB
6. Apache tomcat

### Pre-requisite
1. Clone the code in the folder
   git clone -b main https://github.com/mpsivagnanam/TrainBookAPI.git
2. Import the project in eclipse or IntelliJ
3. To run the test cases, execute SpringBootJpaH2ApplicationTests.java by running Junit
4. To run the application, execute SpringBootJpaH2Application.Java
5. It will enable H2 embedded DB and execute data.sql. It will add user details, travel details and seat details
6. To view the H2 DB console, use the below URL
	http://localhost:8080/h2-ui/login.jsp
	JDBC URL : jdbc:h2:file:./testdb
	User Name : sa
	Password : 
**Junit test **

### API Details

#### 1. Purchase api
**Description **
Pass the email id, from and to location. Application will book a ticket and send the receipt details
**API URL : http://localhost:8080/ticket/purchase**
**Method : POST**
**Request :** 

{
    "emailId":"albinthomas@gmail.com",
    "from":"London",
    "to":"France"

} 

**Response :**
{
    "from": "London",
    "to": "France",
    "pricePaid": 5.0,
    "user": {
        "emailId": "albinthomas@gmail.com",
        "firstName": "Albin",
        "lastName": "Thomas"
    }
}

#### 2. Get Receipt
**Description **
Pass the email id in path variable and get the receipt details
**API URL : http://localhost:8080/ticket/receipt/albinthomas@gmail.com**
**Method : GET**
**Request :** 
**Path Variable : albinthomas@gmail.com** 

**Response :**
{
    "from": "London",
    "to": "France",
    "pricePaid": 5.0,
    "user": {
        "emailId": "albinthomas@gmail.com",
        "firstName": "Albin",
        "lastName": "Thomas"
    }
}

#### 3. Get Seat Details
**Description **
Pass the email id in path variable and get the seat details
**API URL : http://localhost:8080/ticket/seat/albinthomas@gmail.com**
**Method : GET**
**Request :** 
**Path Variable : albinthomas@gmail.com** 

**Response :**
{
    "seat": 3,
    "section": "B",
    "user": {
        "emailId": "albinthomas@gmail.com",
        "firstName": "Albin",
        "lastName": "Thomas"
    }
}

#### 4. Modify Seat Details
**Description **
Pass the email id and update the seat and section details
**API URL : http://localhost:8080/ticket/modify**
**Method : PUT**
**Request :** 
{
    "emailId":"albinthomas@gmail.com",
    "section":"B",
    "seat":"1"
}

**Response :**
{
    "info": "Ticket updated successfully"
}

#### 5. Remove ticket details
**Description **
Pass the email id and update the seat and section details
**API URL :http://localhost:8080/ticket/remove/albinthomas@gmail.com**
**Method : DELETE**
**Request :** 
**Path Variable : albinthomas@gmail.com**

**Response :**
{
    "info": "Ticket removed successfully"
}


### Build

TO build the project use below command

**mvn clean install**

To run the application use below command

**java -jar <JAR_NAME>.jar**

