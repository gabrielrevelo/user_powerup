<br />
<div align="center">
<h3 align="center">PRAGMA POWER-UP</h3>
  <p align="center">
    In this challenge I am going to design the backend of a system that centralizes the services and orders of a restaurant chain that has different branches in the city.
  </p>
</div>

### Built With

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)


<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these steps.

### Prerequisites

* JDK 17 [https://jdk.java.net/java-se-ri/17](https://jdk.java.net/java-se-ri/17)
* Gradle [https://gradle.org/install/](https://gradle.org/install/)
* MySQL [https://dev.mysql.com/downloads/installer/](https://dev.mysql.com/downloads/installer/)

### Recommended Tools

* IntelliJ Community [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
* Postman [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

### Installation

1. Clone the repository
2. Change directory
   ```sh
   cd user_powerup
   ```
3. Create a new database in MySQL called user_powerup
4. Update the database connection settings
   ```yml
   # src/main/resources/application-dev.yml
   spring:
      datasource:
          url: jdbc:mysql://localhost/user_powerup
          username: root
          password: <your-password>
   ```
5. After the tables are created execute src/main/resources/data.sql content to populate the database
6. Open Swagger UI and try

<!-- USAGE -->
## Usage

1. Right-click the class PowerUpApplication and choose Run
2. Open [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) in your web browser

### Validations

* Currently, it doesn't have any kind of security; the role is not checked in any case. Login is not required.

| Field                   | Requirement                                                                                                                               | Example                         |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------|
| Phone Number            | The phone number should be in Colombian format, with the respective prefix. <br> The "+" sign at the beginning of the number is optional. | +573001234567 <br> 573001234567 |
| Identification Document | The identification document should follow the format of a Colombian national identification card (Cédula de Ciudadanía -  CC).            | 1234567890                      |
| Date of Birth           | The date of birth should comply with the requirement that the user must be of legal age (+18).                                            | 2005-01-01                      |


<!-- ROADMAP -->
## Tests

- Right-click the test folder and choose Run tests with coverage
