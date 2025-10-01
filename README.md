#### Key Learnings from This Structure

###### MVC approach

Model → Student.java (data object)

DAO → StudentDAO.java (data access logic)

Controller → StudentController.java (user interaction + business logic)

DBConnection.java (utility for reusing connections)

MainApp.java (entry point)

#### Benefits:

Easy to extend

Code is cleaner & modular

Real-world project-like feel

### 🔄 Complete Flow Example (Insert Student)

User runs program → MainApp.main() starts.

StudentController.run() shows menu.

User presses 1 → controller calls insertStudent().

Controller asks for input (name, age, course).

Controller creates Student object with that input.

Controller calls dao.insert(student).

DAO calls DBConnection.getConnection() to get MySQL connection.

DAO prepares SQL query:

INSERT INTO students (name, age, course) VALUES (?, ?, ?)

DAO binds student values → executes query.

Data gets saved in MySQL DB.

Success message printed → control returns to Controller.

Menu appears again → flow continues.

#### Key Concepts Learned

MainApp → Starting point.

Controller → Handles user input & decides what to do.

Model → Holds data (Student object).

DAO → Does database operations (CRUD).

DBConnection → Manages database connection.