package com.javarestassuredtemplate.tests;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.InvalidPatchPetRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class InvalidMethodPetTests extends TestBase {
    InvalidPatchPetRequest invalidPatchPetRequest;

    @Test
    public void realizarRequisicaoComMetodoInvalido() {
        //Parâmetros
        int statusCodeEsperado = HttpStatus.SC_METHOD_NOT_ALLOWED;

        //Fluxo
        invalidPatchPetRequest = new InvalidPatchPetRequest();
        ValidatableResponse response = invalidPatchPetRequest.executeRequest();

        //Asserções
        response.statusCode(statusCodeEsperado);
    }
}
