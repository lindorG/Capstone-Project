# Project Title

Case Study

## Description

For this project, I have created a Pokémon website. Users can register, login, and begin building their very own Pokémon team using. Their team can be read, updated, or deleted to their liking. Each team has a maximum number of 6, as is standard for Pokémon battling format, and no duplicate entries can be made. 

It includes a PokéDex, which is essentially a large catalog of Pokémon. Although most of the data is being pulled from the MySQL-based database, the images themselves are from PokéApi. By clicking on any one of the images, you are able to add that Pokémon to your team.

The team page includes a search option, which allows users to search for Pokemon by their name. Spring Boot conveniently makes it so that because users are searching for a String, the data gets fetched through a LIKE SQL query.

Users with the administrator role have an additional thing in their navigation bar. A search, which searches for other users by their display name and modify said user's credentials—However the passwords are still encrypted with B-Crypt.

Through the use of HTML, CSS, and JavaScript, and Adobe tools such as Photoshop, After Effects, I made sure that every page on my website is great to look it. And it's not just an eyecatcher—I put so much emphasis on UI/UX which is something I care deeply about. It took trial and error to make sure every corner, button, input, or image was pleasing to look at, properly formatted, and that the animations themselves were tuned perfectly.

I plan on adding a community messge board/forum where users can communicate with each other, strategize, theorycraft, ask questions, and offer/receive feedback from other users. This area is still under construction.

There is so much room for this project to grow in its complexity with all the data that is present in Pokémon, and I am very passionate to continue working on it.

docker run --name project --restart unless-stopped -p 3306:3306 -e MARIADB_ROOT_PASSWORD=root  -d mariadb

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



##  Table of Contents

* [License](#License)
* [Acknowledgements](#Acknowledgments)
* [Tests](#Test)


## License
N/A

## Authors
[me](https://github.com/lindorG)

## Test

Navigate [here](https://github.com/lindorG/Capstone-Project/tree/master/src/test/java/teksystems/casestudy).
