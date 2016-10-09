package com.mannanlive.query;

import com.mannanlive.domain.TimeResponseClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeQuery implements Query<TimeResponseClass> {
    private int daysToAdd = 0;

    public TimeQuery(int daysToAdd) {
        this.daysToAdd = daysToAdd;
    }

    @Override
    public String getQuery() {
        return String.format("SELECT GETDATE() + %d;", daysToAdd);
    }

    @Override
    public List<TimeResponseClass> translate(ResultSet rowSet) throws SQLException {
        List<TimeResponseClass> result = new ArrayList<>();
        while (rowSet.next()) {
            result.add(new TimeResponseClass(rowSet.getDate(1)));
        }
        return result;
    }
}