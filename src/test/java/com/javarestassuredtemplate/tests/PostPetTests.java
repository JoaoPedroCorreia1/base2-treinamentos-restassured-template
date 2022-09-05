package com.javarestassuredtemplate.tests;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.jsonObjects.Category;
import com.javarestassuredtemplate.jsonObjects.Pet;
import com.javarestassuredtemplate.jsonObjects.Tag;
import com.javarestassuredtemplate.requests.PostPetRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class PostPetTests extends TestBase {
    PostPetRequest postPetRequest;
}
