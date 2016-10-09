package com.mannanlive.query;

import com.mannanlive.domain.SpaceResponseClass;
import com.mannanlive.domain.TimeResponseClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpaceQuery implements Query<SpaceResponseClass> {

    @Override
    public String getQuery() {
        return "SELECT DB_NAME() AS DbName, " +
                "name AS FileName, " +
                "size/128.0 AS CurrentSizeMB, " +
                "size/128.0 - CAST(FILEPROPERTY(name, 'SpaceUsed') AS INT)/128.0 AS FreeSpaceMB " +
                "FROM sys.database_files;";
    }

    @Override
    public List<SpaceResponseClass> translate(ResultSet rowSet) throws SQLException {
        List<SpaceResponseClass> result = new ArrayList<>();
        while (rowSet.next()) {
            result.add(new SpaceResponseClass(
                    rowSet.getString(1), rowSet.getString(2), rowSet.getDouble(3), rowSet.getDouble(4)));
        }
        return result;
    }
}