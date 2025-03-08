

public class QueryBuilderTest {

    public static void main(String[] args) {
        testSimpleQuery();
        testComplexQuery();
        testMissingSelect();
        testMissingFrom();
    }

    public static void testSimpleQuery() {
        String query = QueryBuilder.getBuilder()
                .select("name", "age")
                .from("users")
                .where("age > 30")
                .orderBy("name")
                .build()
                .toString();

        assert "SELECT name, age FROM users WHERE age > 30 ORDER BY name".equals(query) : "Test failed: testSimpleQuery";
        System.out.println("Test passed: testSimpleQuery");
    }

    public static void testComplexQuery() {
        String query = QueryBuilder.getBuilder()
                .select("name", "age", "salary")
                .from("employees")
                .join("INNER", "departments", "employees.dept_id = departments.id")
                .where("salary > 50000")
                .groupBy("dept_id")
                .orderBy("salary DESC")
                .build()
                .toString();

        assert "SELECT name, age, salary FROM employees INNER JOIN departments ON employees.dept_id = departments.id WHERE salary > 50000 GROUP BY dept_id ORDER BY salary DESC".equals(query) : "Test failed: testComplexQuery";
        System.out.println("Test passed: testComplexQuery");
    }

    public static void testMissingSelect() {
        try {
            QueryBuilder.getBuilder()
                    .from("users")
                    .build();
        } catch (IllegalStateException e) {
            assert "SELECT and FROM clauses are mandatory".equals(e.getMessage()) : "Test failed: testMissingSelect";
            System.out.println("Test passed: testMissingSelect");
            return;
        }
        assert false : "Test failed: testMissingSelect";
    }

    public static void testMissingFrom() {
        try {
            QueryBuilder.getBuilder()
                    .select("name")
                    .build();
        } catch (IllegalStateException e) {
            assert "SELECT and FROM clauses are mandatory".equals(e.getMessage()) : "Test failed: testMissingFrom";
            System.out.println("Test passed: testMissingFrom");
            return;
        }
        assert false : "Test failed: testMissingFrom";
    }
}