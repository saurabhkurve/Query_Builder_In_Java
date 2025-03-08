
public class Main {
    public static void main(String[] args) {
        String query = QueryBuilder.getBuilder()
                .select("name", "age")
                .from("users")
                .where("age > 30")
                .orderBy("name")
                .build()
                .toString();

        System.out.println(query);
    }
}