
public class Main {
    public static void main(String[] args) {
        String query = QueryBuilder.getBuilder()
                    .select("name", "class", "location")
                    .from("student")
                    .where("name = Saurabh")
                    .orderBy("location")
                    .groupBy("age")
                    .build()
                    .toString();

        System.out.println(query);
    }
}