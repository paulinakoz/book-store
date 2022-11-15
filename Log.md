# Log
## 3/11/22
Started the project by installing all the dependencies using Spring Boot.

Dependencies added:
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Lombok
- H2 Database

Created the first rest controller which for now just displays a list of books.
Added CI using Travis CI.
Experienced a bug when trying to push the project to github as I was getting an authentication error
but I resolved it by googling the error and implementing the recommended fix. 

## 4/11/22
Today I worked on deploying the project to Heroku using Travis CI. Spent most of the day 
trying to fix a bug as the deployment to Heroku wasn't working and I was getting an application error 
when launching the app. Turns out I had the wrong jar file name in the Procfile, and it started working 
when I changed it to the correct one. After I fixed this issue I created the frontend react app, installed
all the dependancies and added it to github. 

## 7/11/22
Today I deployed the frontend app to Travis CI. I exprienced some of the similar issues when deploying as 
I did previously so I already knew how to fix them. I then worked on creating a simple calculator app in Java 
so that I could practice TDD. I added this to a repo which can be seen [here](https://github.com/paulinakoz/TDD-in-Java).

## 8/11/22
Today I worked on implementing the repository layer and the database in the application. I created the data model for Book and data 
repository which will add and fetch data from the db. I also implemented Flyway for database migration and version control. I created
a sql table corresponding to the book model, and added some configuration to connect the database with Flyway. I then 
added some book data to the database. 

## 9/11/22
Today I worked on implementing the service layer, which fetches books from the repository layer and converts the book model to book dto, 
in a test driven way by first writing the tests and then implementing the code. I also implemented the controller using TDD, which fetches the
book list from the service layer and displays it in the controller(localhost). I also added an integration test to test if the application works 
as intended. 

## 10/11/22
Today I implemented Swagger UI. Swagger is an open source set of rules, specifications and tools which help users build, document, test and consume 
RESTful web services. I also created a production envionment and connected a postgresql database hosted on heroku so now when the application is run on 
local machine it connects with H2 database and when it's run on heroku (production) then it connects with postgresql database.

## 11/11/22


## 14/11/22
Book Container, Book Filter UI components. Implement Redux, 

## 15/11/22
bookAction, bookService, bookReducer. Book List, book list item and tests. 