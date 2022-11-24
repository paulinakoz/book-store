# Digital Book Journal
This is a Java Full Stack Application built using React & Spring Boot. I was inspired to do this project as reading books is 
one of my hobbies and I wanted to create a digital book journal where I could keep track of all the books I have read.
It was also an opportunity for me to learn new technologies such as SpringBoot and MongoDB which I have not used previously.

[Here](https://github.com/paulinakoz/book-store-client) is a link to the frontend application for this project, it is still a work 
in progress as at the moment it only displays a list of books and you are able to search the books by title however it does not have 
adding, updating or deleting funtionality just yet. 

[Here](Log.md) is a link to a log of my work which I updated while working on the project, where I wrote an update of what I did each 
day, any blockers I encountered and how I solved them.

## Built With 
* [![Java][Java.com]][Java-url]
* [![SpringBoot][spring.io/projects/spring-boot.com]][springboot-url]
* [![Mongodb][Mongodb.com]][Mongodb-url]

## User Stories
````
As a user,
To keep track of the books I read,
I want to be able to add them to the book journal

As a user, 
To check what books are in my book journal,
I want to be able to fetch all books

As a user,
To check if a specific book is already in the book journal,
I want to be able to search for the book by its title

As a user,
So that I have more information about the book, 
I want to see the author, description and release year

As a user,
To edit books already in the journal, 
I want to be able to update book details like the title, description or author

As a user, 
If I no longer want a book to be in the journal,
I want to be able to delete it from the list
````

## Application Architecture
* Spring boot on the backend
* React on the frontend
* MongoDB for the database
* Continuous integration using Travis CI

### Server Architecture
<img alt="app-architecture" src="./images/app-architecture.png" style="display: block;" />

## Review and Roadmap
Overall this project was realy interesting and I learned a lot of new things like building a SpringBoot application, using MongoDB and 
using continous integration with Travis CI. 
In the future I am planning to add more functionality to the server like keeping track of more information like a review of the book and
what I liked/disliked about it. 