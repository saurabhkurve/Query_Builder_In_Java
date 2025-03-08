# Custom Query Builder

### Background

In many applications, especially those involving databases, constructing complex queries dynamically is a common requirement. This project implements a Query Builder class for a SQL-like database using the Builder pattern. The Query Builder is flexible enough to handle various types of queries with different selections, conditions, joins, and other SQL features.

### Requirements

1. **Basic Query Structure**:
    - The Query Builder supports `SELECT`, `FROM`, `WHERE`, `JOIN` (INNER and LEFT), `ORDER BY`, and `GROUP BY` clauses.
    - It allows chaining methods in any order to build the query.

2. **Type Safety and Validation**:
    - Includes validation to ensure that essential parts of the query (like `SELECT` and `FROM`) are present.
    - If a part of the query is missing or invalid (e.g., ordering by a column not in select), the builder throws an error or handles it gracefully.

3. **Flexibility**:
    - The builder is flexible enough to allow for different kinds of inputs (e.g., multiple columns in select, various conditions in where).

4. **Immutability**:
    - Ensures that once a query is built, it cannot be modified.

5. **Test Cases**:
    - Includes test cases demonstrating the use of the Query Builder for different scenarios (e.g., a simple query, a complex query with joins and aggregations).

6. **Documentation**:
    - Documents the usage of the Query Builder with examples.

7. **Bonus - Fluent API**:
    - Implements the builder with a fluent API style, allowing calls to be chained in a readable manner.

### Example Usage

```java
String query = new QueryBuilder()
    .select("name", "age")
    .from("users")
    .where("age > 30")
    .orderBy("name")
    .build()
```

## Files
#### QueryBuilder.java
This file contains the implementation of the Query Builder class using the Builder pattern.

#### Main.java
This file contains the main method to demonstrate the usage of the Query Builder.

#### QueryBuilderTest.java
This file contains test cases to validate the functionality of the Query Builder.

Running the Project
#### Compile the Java files:
``` javac com/example/*.java ```

#### Run the Main class:
``` java com.example.Main ```

#### Run the QueryBuilderTest class:
``` java com.example.QueryBuilderTest ```

## Conclusion 
This project demonstrates the implementation of a Custom Query Builder using the Builder pattern and a fluent API style. It ensures flexibility, readability, and maintainability while constructing complex SQL queries dynamically.
