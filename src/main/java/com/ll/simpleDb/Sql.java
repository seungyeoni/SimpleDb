package com.ll.simpleDb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Sql {
    private final SimpleDb simpleDb;
    private final StringBuilder sqlBuilder;
    private final List<Object> params;

    public Sql(SimpleDb simpleDb) {
        this.simpleDb = simpleDb;
        this.sqlBuilder = new StringBuilder();
        this.params = new ArrayList<>();
    }

    public Sql append(String sqlPart, Object... args) {
        sqlBuilder.append(sqlPart).append(" ");
        Collections.addAll(params, args);
        return this;
    }

    public long insert() {
        String sql = sqlBuilder.toString();
        return simpleDb.runInsert(sql, params.toArray());
    }

    public long update() {
        String sql = sqlBuilder.toString();
        return simpleDb.runUpdate(sql, params.toArray());
    }

    public long delete() {
        String sql = sqlBuilder.toString();
        return simpleDb.runUpdate(sql, params.toArray());
    }

    public List<Map<String, Object>> selectRows() {
        String sql = sqlBuilder.toString();
        return simpleDb.runSelectRows(sql, params.toArray());
    }
}
