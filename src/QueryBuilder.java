

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    private final String select;
    private final String from;
    private final String where;
    private final String join;
    private final String orderBy;
    private final String groupBy;

    private QueryBuilder(Builder builder) {
        this.select = builder.select;
        this.from = builder.from;
        this.where = builder.where;
        this.join = builder.join;
        this.orderBy = builder.orderBy;
        this.groupBy = builder.groupBy;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String select;
        private String from;
        private String where;
        private String join;
        private String orderBy;
        private String groupBy;

//        private Builder() {
//        }

        public QueryBuilder build() {
            if (select == null || from == null) {
                throw new IllegalStateException("SELECT and FROM clauses are mandatory");
            }
            return new QueryBuilder(this);
        }

        public Builder select(String... columns) {
            this.select = String.join(", ", columns);
            return this;
        }

        public Builder from(String table) {
            this.from = table;
            return this;
        }

        public Builder where(String condition) {
            this.where = condition;
            return this;
        }

        public Builder join(String joinType, String table, String condition) {
            this.join = joinType + " JOIN " + table + " ON " + condition;
            return this;
        }

        public Builder orderBy(String... columns) {
            this.orderBy = String.join(", ", columns);
            return this;
        }

        public Builder groupBy(String... columns) {
            this.groupBy = String.join(", ", columns);
            return this;
        }
    }

    @Override
    public String toString() {
        List<String> queryParts = new ArrayList<>();
        queryParts.add("SELECT " + select);
        queryParts.add("FROM " + from);
        if (join != null) queryParts.add(join);
        if (where != null) queryParts.add("WHERE " + where);
        if (groupBy != null) queryParts.add("GROUP BY " + groupBy);
        if (orderBy != null) queryParts.add("ORDER BY " + orderBy);

        return String.join(" ", queryParts);
    }
}