package com.mannanlive.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Query<T> {
    String getQuery();
    List<T> translate(ResultSet rowSet) throws SQLException;
}
