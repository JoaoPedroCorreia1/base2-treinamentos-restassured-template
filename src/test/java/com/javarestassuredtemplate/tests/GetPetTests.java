package com.javarestassuredtemplate.tests;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.GetPetRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class GetPetTests extends TestBase {
    GetPetRequest getPetRequest;

    @Test
    public void buscarPetInexistente(){
        //Parâmetros
        long petId = 99999812313L;

        int statusCodeEsperado = HttpStatus.SC_NOT_FOUND;
        //Fluxo
        getPetRequest = new GetPetRequest(petId);
        ValidatableResponse response = getPetRequest.executeRequest();

        //Asserções
        response.statusCode(statusCodeEsperado);
        response.body("message", equalTo("Pet not found"));
    }
}
