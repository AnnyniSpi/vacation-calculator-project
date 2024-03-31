***
## Test task.

- Rest API for counting the amount of vacation pay.
- Based on Spring Boot ecosystem technology.
- Created for learning purposes.

## Setup and Running

- Use `JDK 11`.
- Use `Apache Maven`.
- Use `Spring Boot 3.2.4`.

## Usage
### HTTP GET .../api/v1/calculator

**Summary:**  
Returns 200 OK and a line with the calculation results.

**Request Example:**

GET .../calculate

```
  {
    "salary": "150000",
    "vacation": "15",
    "startVacation": "2024-06-01",
    "endVacation": "2024-06-15"
}
```

### Responses:

```
  Vacation pay amount: 46075
```

**200 OK**

***
