package com.mannanlive.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.mannanlive.domain.RequestClass;
import com.mannanlive.domain.SpaceResponseClass;
import com.mannanlive.query.SpaceQuery;
import com.mannanlive.repository.QueryDao;

import java.util.List;

public class SpaceHandler implements RequestHandler<RequestClass, List<SpaceResponseClass>> {
    public List<SpaceResponseClass> handleRequest(RequestClass request, Context context) {
        return new QueryDao<SpaceResponseClass>().execute(new SpaceQuery());
    }
}
