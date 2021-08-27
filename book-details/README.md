# GraphQL Book-Details
Sample graphql project from [Getting started with GraphQL Java and Spring Boot](https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/) 

## Try it out
* http://localhost:8080/graphql

Use [GraphQL Playground](https://github.com/prisma/graphql-playground) or [Postman](https://www.postman.com) for testing

```js
{
    bookById(id: "book-1") {
        id
        name
        pageCount
        author {
            firstName
            lastName
        }
    }
}
