# Ticket Management API - GraphQL Documentation

This project provides a RESTful API and GraphQL support for managing tickets.

## Features

1. Create, update, delete, and retrieve tickets.
2. Support for pagination.
3. Expose API via REST and GraphQL.
4. Dockerized MySQL database for local development.

## Prerequisites

1. Java 17 or higher.
2. Maven installed.
3. Docker installed.

## Running the Application

1. Start the database using Docker Compose:
   ```bash
   docker-compose up -d
   ```

2. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will be available at `http://localhost:9192`.

## GraphQL Endpoint

The GraphQL API is accessible at:
```
http://localhost:9192/graphql
```

You can use tools like Postman, Altair GraphQL Client, or GraphiQL to interact with the API.

## Example Queries and Mutations

### Query: Get All Tickets with Pagination
```graphql
query {
  getAllTickets(page: 0, size: 5) {
    id
    usuario
    fechaCreacion
    estatus
  }
}
```

### Query: Get Ticket by ID
```graphql
query {
  getTicketById(id: 1) {
    id
    usuario
    fechaCreacion
    estatus
  }
}
```

### Mutation: Create a Ticket
```graphql
mutation {
  createTicket(usuario: "John Doe", estatus: "ABIERTO") {
    id
    usuario
    fechaCreacion
    estatus
  }
}
```

### Mutation: Update a Ticket
```graphql
mutation {
  updateTicket(id: 1, usuario: "Jane Doe", estatus: "CERRADO") {
    id
    usuario
    fechaCreacion
    fechaActualizacion
    estatus
  }
}
```

### Mutation: Delete a Ticket
```graphql
mutation {
  deleteTicket(id: 1)
}
```

## Testing the API

You can use [Postman](https://www.postman.com/) or [Altair GraphQL Client](https://altairgraphql.dev/) for testing the GraphQL API. Simply paste the example queries and mutations into the respective client.

## Additional Notes

1. The database credentials can be configured in `application.properties`.
2. Use the following default credentials for local MySQL:
   - Username: `root`
   - Password: `Shan.26camilo`
   - Database: `test_doubleV`

For any issues, ensure that the Docker container for the database is running and accessible.


## REST Endpoints
The RESTful API is available at `http://localhost:9192/api/tickets`. You can use standard HTTP methods:
- `POST /api/tickets`: Create a new ticket.
- `GET /api/tickets`: Retrieve all tickets (supports pagination).
- `GET /api/tickets/{id}`: Retrieve a ticket by ID.
- `PUT /api/tickets/{id}`: Update an existing ticket.
- `DELETE /api/tickets/{id}`: Delete a ticket by ID.
