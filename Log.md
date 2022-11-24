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
repository which will add and fetch data from the db. 

## 9/11/22
Today I worked on implementing the service layer, which fetches books from the repository layer and converts the book model to book dto. 
I also implemented the controller, which fetches the book list from the service layer and displays it in the controller(localhost).

## 11/11/22
Today I added Material UI to the frontend application which allows you to create responsive UI components and add styling to them. I then created the
Layout and Header components in order to start building out the UI of the application. 

## 14/11/22
Today I implemented the Book Container, which will display the list of books, and the Book Filter which will let you filter books by title. I also added 
Redux to the application which manages and centralises application state. 

## 15/11/22
Today I implemeted bookSelector, bookAction, bookService and bookReducer in the frontend which work together to fetch book data from the server and then 
display it in the book container. I also created Book List and Book List Item components which display the individual book data inside the book container.
Additionally, wrote tests for all the functionality and components which I created. I also started implementing the search book by title functionality in 
the backend so that it can be used in the Book Filter component. 

## 16/11/22
Today I changed the H2, and SQL databases that I was originally using to a MongoDB database so I worked on creating and connecting the new database to the server. 

## 17/11/22
Today I decided to continue working on the backend server and I added functionality to the service and controller layers for creating a new book, updating 
a book and deleting a book, I then tested this using Postman and all the requests work. 

## 18/11/22
Today I continued I added controller tests to all of the requests in the book controller and all of the tests pass. 