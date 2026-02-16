.

📓 Journal App – Spring Boot CRUD API

This is a basic CRUD REST API built using Spring Boot and MongoDB.
The purpose of this project is to understand Controller – Service – Repository architecture, ResponseEntity, and CRUD operations using MongoDB.

This project is suitable for Spring Boot beginners who want to learn how backend APIs work.

__________________________________________________________________________________
🚀 Tech Stack Used
1. Java
2. Spring Boot
3. Spring Web
4. Spring Data MongoDB
5. MongoDB
6. Postman (for API testing)
_________________________________________________________________________________

📂 Project Structure
The project follows a clean layered architecture:
  ~Controller → Handles HTTP requests and responses
  ~Service → Contains business logic
  ~Repository → Communicates with MongoDB
  ~Model (POJO) → Represents database entity
_________________________________________________________________________________

🗄️ Database Details
  ~Database Name: journaldb
  ~Collection Name: journal_entries
  ~Database Used: MongoDB
_________________________________________________________________________________

🌐 Base API Mapping

   All APIs are mapped under:
   /journal
_________________________________________________________________________________
🔧 Available APIs (CRUD)
1️⃣ Get All Journal Entries

Returns all journal entries as a list.

Method: GET
URL: /journal
Response:
200 OK → List of journal entries
204 NO_CONTENT → If database is empty
_________________________________________________
2️⃣ Add New Journal Entry

Adds a new journal entry to the database.

Method: POST
URL: /journal
Request Body (JSON): {
  "title": "My First Journal",
  "content": "This is my first journal entry"
}

Response:
200 OK → Entry added successfully
_________________________________________________

3️⃣ Get Journal Entry By ID

Fetches a single journal entry using its ID.

Method: GET
URL: /journal/id/{id}

Response:
200 OK → Journal entry found
404 NOT_FOUND → Entry not found
_________________________________________________
4️⃣ Delete Journal Entry By ID

Deletes a journal entry using its ID.

Method: DELETE
URL: /journal/id/{id}

Response:
200 OK → Entry deleted
404 NOT_FOUND → Entry not found
_________________________________________________
5️⃣ Update Journal Entry By ID

Updates an existing journal entry using its ID.

Method: PUT
URL: /journal/id/{id}

Request Body (JSON): {
  "title": "Updated Title",
  "content": "Updated content"
}

Response:
200 OK → Entry updated successfully
404 NOT_FOUND → Entry not found
______________________________________________________________________________
🧪 API Testing

All APIs have been tested using Postman.

Steps to test:
   1.Run the Spring Boot application
   2.Open Postman
   3.Use the above endpoints with proper HTTP methods
   4.Send JSON request body for POST and PUT APIs
______________________________________________________________________________
🎯 Purpose of This Project

  ~To understand CRUD operations in Spring Boot
  ~To learn how to use MongoDB with Spring Data
  ~To practice ResponseEntity and HTTP status codes
  ~To build confidence in backend API development
_______________________________________________________________________________
📌 Note

This project is created for learning and practice purposes.
It can be extended further by adding:

  ~Validation
  ~Exception handling
  ~Spring Security
  ~DTO
   etc etc.......
________________________________________________________________________________
________________________________________________________________________________
<h1 align="center"> -LAKSHYA SONI </h1>


