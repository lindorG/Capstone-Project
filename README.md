# Pokémon Team Builder E-Commerce Platform
<p align="center">
  <img src="src/main/webapp/pub/images/logo-animated2.gif" alt="Pokémon Team Builder Logo">
</p>

## Overview
Pokémon Team Builder is a full-stack web application that functions similarly to an e-commerce platform. Instead of adding products to a cart, users can build their ideal Pokémon team with up to six Pokémon. The app features a search bar for easy navigation and a modern UI built with Java, Spring Boot, MySQL, JavaScript, HTML/CSS, and JSP.

## Features
- Add up to six Pokémon to your team
- Search for Pokémon using the built-in search bar
- Modern, user-friendly design

## Tech Stack
- **Backend**: Java, Spring Boot
- **Frontend**: JavaScript, HTML, CSS, JSP
- **Database**: MySQL
- **Containerization**: Docker

## Installation & Setup

### Option 1: Fully Automated Database Setup (Recommended)
With this method, the database schema and initial data will be created automatically when the application starts, provided that Docker is running.

1. **Clone the repository**:
   ```sh
   git clone https://github.com/lindorG/Capstone-Project.git
   cd Capstone-Project
   ```

2. **Ensure Docker is running**, then start the MySQL container:
   ```sh
   docker-compose up -d
   ```
   This will launch a MySQL container with the necessary configurations.

3. **Run the application**:
   ```sh
   ./mvnw spring-boot:run
   ```
    - On startup, Spring Boot will check for the database, create the schema if necessary, and insert initial data.

4. **Access the application**: Open `http://localhost:8080` in your browser.

### Option 2: Semi-Automated Database Setup
With this method, the schema is created automatically, but you must run a script to insert initial data.

1. **Follow steps 1-3 from Option 1** to set up the database and start the application.
2. **Run the provided SQL script** to insert data:
   ```sh
   docker exec -i capstone-mysql mysql -u root -pYOUR_PASSWORD capstone_db < database_backup.sql
   ```
3. **Access the application**: Open `http://localhost:8080` in your browser.

##  Screenshots

![Teambuilder](https://user-images.githubusercontent.com/97411880/165364251-9bd3ae0e-42c6-4071-be0b-b3fc5f8dca3c.png)
![Home-Landing-Index](https://user-images.githubusercontent.com/97411880/165364191-7ebadd62-a9e7-498b-ae02-63df51be552d.png)
![PokeDex](https://user-images.githubusercontent.com/97411880/165364345-4af40abf-b427-411e-b800-84d93156d9c7.png)
![Search](https://user-images.githubusercontent.com/97411880/165364360-b965a7d7-63a5-4678-b182-c2c5b8b95111.png)
![500](https://user-images.githubusercontent.com/97411880/165364536-67bd9a43-7362-4499-9d4e-15f970424ee7.png)
![404](https://user-images.githubusercontent.com/97411880/165364549-66586c8b-a3ea-49a3-9b6f-d517b407e256.png)
![News](https://user-images.githubusercontent.com/97411880/165364614-d73ef148-735f-4c19-88a5-0a0ac26b88d0.png)
![About](https://user-images.githubusercontent.com/97411880/165364621-f58771e3-1589-43db-8e94-c895f3d76fe5.png)
![Register](https://user-images.githubusercontent.com/97411880/165364632-6524217b-d950-4ab5-acbc-985f29a328ad.png)

## Contribution
Feel free to submit issues or pull requests to improve the project!

## License
MIT License.

## Test

Navigate [here](https://github.com/lindorG/Capstone-Project/tree/master/src/test/java/teksystems/casestudy).
