package com.mannanlive.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.mannanlive.domain.RequestClass;
import com.mannanlive.domain.TimeResponseClass;
import com.mannanlive.query.TimeQuery;
import com.mannanlive.repository.QueryDao;

public class TimeHandler implements RequestHandler<RequestClass, TimeResponseClass> {
    public TimeResponseClass handleRequest(RequestClass request, Context context) {
        TimeQuery query = new TimeQuery(request.getValue());
        return new QueryDao<TimeResponseClass>().executeSingleton(query);
    }
}
