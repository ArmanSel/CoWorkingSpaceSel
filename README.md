# coworkingspacesel

A coworking space application offering services such as registration, member management, record management and much more.
Made via Springboot.
## How to setup this project?
You either
 * Extract the zip file and run the CoWorkingSpaceApplication.

or
* Clone the project via https://github.com/ArmanSel/coworkingspacesel.git

## Useful links:
### Swagger/OpenApi
* API documentation: <http://localhost:8080/swagger-ui/index.html>
### Console/Database
* H2 console: <http://localhost:8080/h2-console>

### How to register a new user via Swagger?
* auth/register
* edit the column in the console via SQL:
  ```
  UPDATE table_name
  SET column1 = value1, column2 = value2, ...
  WHERE condition;
  ```
  * auth/token "get new token"
  * paste the new access token in coworkingspacesel/http-requests/http-client.env.json

### How to use coworkingspacesel?
* Self explanatory, read the comments via coworkingspacesel/http-requests/client-requests.rest

