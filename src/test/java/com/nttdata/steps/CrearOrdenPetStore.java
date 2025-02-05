package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearOrdenPetStore {

    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";
    private static String orderId;  // Variable para almacenar el orderId

    public void crearOrden(int petId, int  quantity, String status) {

        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"petId\": "+petId+",\n" +
                        "  \"quantity\": "+quantity+",\n" +
                        "  \"shipDate\": \"2025-02-04T21:11:46.610Z\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post(CREATE_ORDER)
                .then()
                .log().all()
        ;

        //Extraer el orderId de la respuesta y guardarlo en la variable
        orderId = SerenityRest.lastResponse().body().path("id").toString();
        System.out.println("Orden creada con ID: " + orderId);
    }



    public void validarCodigoDeRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public void validarRespuestaPetId(int petId) {
        restAssuredThat(response -> response.body("'petId'", equalTo(petId)));
        System.out.println("PetId: " + SerenityRest.lastResponse().body().path("petId").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    public void validarRespuestaCantidad(int  quantity) {
        restAssuredThat(response -> response.body("'quantity'", equalTo(quantity)));
        System.out.println("Quantity: " + SerenityRest.lastResponse().body().path("quantity").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }


    public void validarRespuestaStatusOrden(String status) {
        restAssuredThat(response -> response.body("'status'", equalTo(status)));
        System.out.println("Status: " + SerenityRest.lastResponse().body().path("status").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

}
