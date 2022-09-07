package com.javarestassuredtemplate.requests;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class InvalidPatchPetRequest extends RequestRestBase {

    public InvalidPatchPetRequest(){
        requestService = "/pet";
        method = Method.PATCH;
    }
}
