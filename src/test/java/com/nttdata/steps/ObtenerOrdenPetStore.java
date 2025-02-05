package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ObtenerOrdenPetStore {

    private static String GET_ORDER = "https://petstore.swagger.io/v2/store/order/{orderId}";
    private static String orderId;

    public void obtenerOrden() {
        SerenityRest.given()
                .relaxedHTTPSValidation()
                .log().all()
                .get(GET_ORDER, orderId)
                .then()
                .log().all();

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

    public void validarRespuestaCantidad(int quantity) {
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
