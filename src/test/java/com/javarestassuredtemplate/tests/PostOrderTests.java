package com.javarestassuredtemplate.tests;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.jsonObjects.Order;
import com.javarestassuredtemplate.requests.PostOrderRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class PostOrderTests extends TestBase {
    PostOrderRequest postOrderRequest;

    @Test
    public void cadastrarNovoPedidoDePetComSucesso() {
        //Parâmetros
        int id = 0;
        int petId = 10;
        int quantity = 0;
        String shipDate = "2022-08-23T21:18:49.448Z";
        String shipDateParaTestar = shipDate.replace("Z", "+0000");
        String status = "placed";
        boolean complete = true;

        int statusCodeEsperado = 200;

        //Fluxo
        postOrderRequest = new PostOrderRequest();
        postOrderRequest.setJsonBodyUsingJsonFile(id,petId, quantity, shipDate, status, complete);
        ValidatableResponse response = postOrderRequest.executeRequest();

        //Asserções
        response.statusCode(statusCodeEsperado);
        response.body("petId", equalTo(petId),
                "quantity", equalTo(quantity),
                "shipDate", equalTo(shipDateParaTestar),
                "status", equalTo(status),
                "complete", equalTo(complete));;
    }
}
