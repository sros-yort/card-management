# Card Management

## Introduction
A RESTful web-service for managing debit / credit cards. 

Technologies Used
- Spring boot 2.4.4
- Java 1.8
- spring-boot-starter-web: for building REST services with Spring
- spring-boot-starter-data-jpa: for accessing Data with JPA
- com.h2database: from creating in-memory database


## Application Setup

Test App Service
```maven
./mvnw -Dtest=CardServiceTest test
```

Start App
```maven
./mvnw spring-boot:run
```

As app start up it will insert predefine data to User and Card.
Please check on class [CardManagementApplication](src/main/java/com/sros/cardmanagement/CardManagementApplication.java) for predefine data.

## REST API Docs

### Cards
All card service request use the same endpoint.

```http
POST /api/cards
```

All services request depend on ```serviceType``` :
- get-user-cards
- get-card-detail
- update-card-status
- change-card-daily-limit

#### Get User's Cards

Request ```raw (json)```:

```json
{
    "serviceType": "get-user-cards",
    "userId": 1
}
```

Responses:

```json
{
    "message": "Success",
    "data": [
        {
            "id": 5,
            "cardNumber": "0000000000000003",
            "type": "credit",
            "dailyLimit": 20.0,
            "balance": 20.0,
            "expDate": "2023-09-04",
            "status": "Activate",
            "user": {
                "id": 2,
                "firstName": "Pong",
                "lastName": "Ping",
                "address": "Phnom Penh"
            }
        },
        ...
    ]
}
```

#### Get Card Detail

Request ```raw (json)```:

```json
{
    "serviceType": "get-card-detail",
    "cardId": 3
}
```

Responses:

```json
{
    "message": "Success",
    "data": {
        "id": 3,
        "cardNumber": "0000000000000001",
        "type": "credit",
        "dailyLimit": 20.0,
        "balance": 20.0,
        "expDate": "2023-09-04",
        "status": "Activate",
        "user": {
            "id": 1,
            "firstName": "Sros",
            "lastName": "Yort",
            "address": "Phnom Penh"
        }
    }
}
```

#### Update Card Status
   Acceptable status: 
   - ACTIVATE
   - DEACTIVATE,
   - PADDING,
   - CLOSE
   
   Request ```raw (json)```:
   
   ```json
   {
       "serviceType": "update-card-status",
       "cardId": 3,
       "cardStatus": "Deactivate"
   }
   ```
   
   Responses:
   
   ```json
   {
       "message": "Success",
       "data": {
           "id": 3,
           "cardNumber": "0000000000000001",
           "type": "credit",
           "dailyLimit": 20.0,
           "balance": 20.0,
           "expDate": "2023-09-04",
           "status": "Deactivate",
           "user": {
               "id": 1,
               "firstName": "Sros",
               "lastName": "Yort",
               "address": "Phnom Penh"
           }
       }
   }
   ```

#### Change Card Daily Limit

Request ```raw (json)```:

```json
{
    "serviceType": "change-card-daily-limit",
    "cardId": 3,
    "cardDailyLimit": 12
}
```

Responses:

```json
{
    "message": "Success",
    "data": {
        "id": 3,
        "cardNumber": "0000000000000001",
        "type": "credit",
        "dailyLimit": 12.0,
        "balance": 20.0,
        "expDate": "2023-09-04",
        "status": "Deactivate",
        "user": {
            "id": 1,
            "firstName": "Sros",
            "lastName": "Yort",
            "address": "Phnom Penh"
        }
    }
}
```
