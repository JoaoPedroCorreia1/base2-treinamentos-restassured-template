package com.javarestassuredtemplate.tests;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.jsonObjects.Category;
import com.javarestassuredtemplate.jsonObjects.Tag;
import com.javarestassuredtemplate.requests.PutPetRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class PutPetTests extends TestBase {
    PutPetRequest putPetRequest;

    @Test
    public void atualizarDadosDePetExistente() {
        //Parâmetros
        int idPet = 1;
        int idCategoryEditado = 1;
        String nameCategoryEditado = "category editada";
        String nameEditado = "name editado";
        String photoUrlEditado = "url editada";
        int idTagEditado = 2;
        String nameTagEditado = "tag editada";
        String statusEditado = "pending";

        int statusCodeEsperado = HttpStatus.SC_OK;
        //Fluxo
        putPetRequest = new PutPetRequest();
        putPetRequest.setJsonBodyUsingJsonFile(idPet, idCategoryEditado, nameCategoryEditado,
                nameEditado, photoUrlEditado, idTagEditado, nameTagEditado, statusEditado);
        ValidatableResponse response = putPetRequest.executeRequest();

        //Asserções
        response.statusCode(statusCodeEsperado);
        response.body("id", equalTo(idPet),
                "category.id", equalTo(idCategoryEditado),
                "category.name", equalTo(nameCategoryEditado),
                "name", equalTo(nameEditado),
                "photoUrls[0]", equalTo(photoUrlEditado),
                "tags[0].id", equalTo(idTagEditado),
                "tags[0].name", equalTo(nameTagEditado),
                "status", equalTo(statusEditado));
    }

    @Test
    public void atualizarDadosDePetComIdComFormatoInvalido() {
        //Parâmetros
        String idPet = "string";
        String idCategoryEditado = "1";
        String nameCategoryEditado = "category editada";
        String nameEditado = "name editado";
        String photoUrlEditado = "url editada";
        String idTagEditado = "2";
        String nameTagEditado = "tag editada";
        String statusEditado = "pending";

        int statusCodeEsperado = HttpStatus.SC_BAD_REQUEST;

        //Fluxo
        putPetRequest = new PutPetRequest();
        putPetRequest.setJsonBodyUsingJsonFileNoTypeCheck(idPet, idCategoryEditado, nameCategoryEditado,
                nameEditado, photoUrlEditado, idTagEditado, nameTagEditado, statusEditado);
        ValidatableResponse response = putPetRequest.executeRequest();

        //Asserções
        response.statusCode(statusCodeEsperado);
    }
}
