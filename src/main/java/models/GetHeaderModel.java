package models;


import models.headers.HeadersValueModel;

import java.util.HashMap;
import java.util.Map;

public class GetHeaderModel {

    private GetHeaderModel(){}

    private static final Map <String,String> headers = new HashMap<>();

    public static Map <String,String> basicHeaders (){

        headers.put(HeadersValueModel.CONTENT_TYPE.getHeader(), HeadersValueModel.CONTENT_TYPE.getValue());
        headers.put(HeadersValueModel.COOKIE.getHeader(), HeadersValueModel.COOKIE.getValue());

        return headers;
    }
}
