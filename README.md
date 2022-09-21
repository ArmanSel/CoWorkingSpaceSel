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

### How to create a new User via Swagger?
* auth/register

Done!

### How to register a new admin via Swagger?
* auth/register
* edit the column in the console via SQL:
  ```
  UPDATE MEMBER
  SET IS_ADMIN = TRUE
  WHERE IS_ADMIN = FALSE
  ```
  * auth/token "get new token"
  * paste the new access token in coworkingspacesel/http-requests/http-client.env.json

Done!

### How to use coworkingspacesel?
* Self explanatory, read the comments via coworkingspacesel/http-requests/client-requests.rest

