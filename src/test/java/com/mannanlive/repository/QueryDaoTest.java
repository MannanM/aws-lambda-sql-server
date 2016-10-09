package com.mannanlive.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mannanlive.domain.SpaceResponseClass;
import com.mannanlive.domain.TimeResponseClass;
import com.mannanlive.query.SpaceQuery;
import com.mannanlive.query.TimeQuery;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class QueryDaoTest {
    @Test
    public void testSingleQueries() throws Exception {
        TimeResponseClass test = new QueryDao<TimeResponseClass>().executeSingleton(new TimeQuery(1));
        assertEquals("{\"currentTime\":\"2016-10-09\"}", new ObjectMapper().writeValueAsString(test));
    }

    @Test
    public void testSpaceQuery() throws Exception {
        List<SpaceResponseClass> test = new QueryDao<SpaceResponseClass>().execute(new SpaceQuery());
        assertEquals("[{\"dbName\":\"ml\",\"fileName\":\"ml\",\"currentSizeMb\":559.125,\"freeSpaceMb\":44.3125}," +
                "{\"dbName\":\"ml\",\"fileName\":\"ml_log\",\"currentSizeMb\":555.5625,\"freeSpaceMb\":541.210938}]", 
                new ObjectMapper().writeValueAsString(test));
    }
}