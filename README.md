
## Documentation

Building real time Rest APIS for Blogging Application using 
Spring Boot , Spring Security , JWT , Spring Data JPA ,
MySql

- Creating Rest Endpoints
- Complex DB structure (JPA Entities)
- Role Based Authentication
- Exception Handling
- Using DTO for Data Transfer
- Swagger Implementation
- Add profiles for different Env
- Deploy in production

* ER DIAGRAM
![ER-diagram](https://github.com/OliGanguly/Spring-Boot-blogApplication/assets/82031303/122564e8-701a-4d10-b689-bb3761736472)

- USER 
- POST FK-{ userid } - one user many post
- COMMENT FK-{ userid,postid} -one user many comment | one post many comment
- CATEGORY FK-{ postid } - one category many post 

## What I build

Client wants blogging application where he/she can write blogs and articles.


- User should create , update , delete , show List of posts 
- User Should add , update , delete comments on post.
- Categories the posts according to Categories.
- New User should be registered on our application
- Existing user should be able to login

## Architecture
 client -req-> Controller[ Api layer ] ->services [ Business Lyer ] ->Repository[Dao layer] -> Db
               




