# Pokémon Team Builder E-Commerce Platform
<p align="center">
  <img src="src/main/webapp/pub/images/logo-animated2.gif" alt="Pokémon Team Builder Logo">
</p>
<p align="center">
  <a href="https://poketheory.shop" style="font-size: 24px; font-weight: bold;">🔗 poketheory.shop</a>
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
This method will automatically create the database schema and insert initial data when the application starts, as long as Docker is running.

1. **Clone the repository**:
   ```sh
   git clone https://github.com/lindorG/Pokemon-Team-Builder-E-Commerce-Platform.git
   cd Pokemon-Team-Builder-E-Commerce-Platform
    ```
2. **While Docker is running, start the MySQL container**:
   ```sh
    docker-compose up -d
    ```
3. **Build and run the application:**
    ```
   ./mvnw clean install -DskipTests && docker-compose up --build
    ```
4. **Access the application: Open ``http://localhost:8080`` in your browser.**

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
