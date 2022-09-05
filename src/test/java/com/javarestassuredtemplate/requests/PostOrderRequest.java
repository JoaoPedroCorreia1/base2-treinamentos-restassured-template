package com.javarestassuredtemplate.requests;

import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.jsonObjects.Category;
import com.javarestassuredtemplate.jsonObjects.Order;
import com.javarestassuredtemplate.jsonObjects.Pet;
import com.javarestassuredtemplate.jsonObjects.Tag;
import com.javarestassuredtemplate.utils.GeneralUtils;
import io.restassured.http.Method;

public class PostOrderRequest extends RequestRestBase {
    public PostOrderRequest(){
        requestService = "/store/order";
        method = Method.POST;
    }

    public void setJsonBodyUsingJsonFile(int id,
                                         int petId,
                                         int quantity,
                                         String shipDate,
                                         String status,
                                         boolean complete){
        jsonBody = GeneralUtils.readFileToAString("src/test/java/com/javarestassuredtemplate/jsons/PostOrderJson.json")
                .replace("$id", String.valueOf(id))
                .replace("$petId", String.valueOf(petId))
                .replace("$quantity", String.valueOf(quantity))
                .replace("$shipDate", shipDate)
                .replace("$status", status)
                .replace("$complete", String.valueOf(complete));
    }

    public void setJsonBodyUsingJavaObject(int id,
                                           int petId,
                                           int quantity,
                                           String shipDate,
                                           String status,
                                           boolean complete){
        jsonBody = new Order(id,
                petId,
                quantity,
                shipDate,
                status,
                complete);
    }

    public void setJsonBodyUsingJavaObject(Object jsonObject){
        jsonBody = jsonObject;
    }
}
