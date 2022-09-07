package com.javarestassuredtemplate.tests;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.GetPetByStatusRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GetPetByStatusTests extends TestBase {
    GetPetByStatusRequest getPetByStatusRequest;

    @Test
    public void pesquisarPorPetsComStatusPending() {
        //Parâmetros
        String status = "pending";

        int statusCodeEsperado = HttpStatus.SC_OK;

        //Fluxo
        getPetByStatusRequest = new GetPetByStatusRequest();
        getPetByStatusRequest.setStatus(status);
        ValidatableResponse response = getPetByStatusRequest.executeRequest();

        //Asserções
        response.statusCode(statusCodeEsperado);
        response.body("'status'", hasItems(status));
    }
}
