package com.javarestassuredtemplate.requests;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.jsonObjects.Category;
import com.javarestassuredtemplate.jsonObjects.Pet;
import com.javarestassuredtemplate.jsonObjects.Tag;
import com.javarestassuredtemplate.utils.GeneralUtils;
import io.restassured.http.Method;

import java.util.HashMap;

public class GetPetByStatusRequest extends RequestRestBase {

    public GetPetByStatusRequest(){
        requestService = "/pet/findByStatus";
        method = Method.GET;
    }

    public void setStatus(String status){
        queryParameters.put("status", status);
    }
}
