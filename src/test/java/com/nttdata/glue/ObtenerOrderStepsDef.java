package com.nttdata.glue;

import com.nttdata.steps.CrearOrdenPetStore;
import com.nttdata.steps.ObtenerOrdenPetStore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ObtenerOrderStepsDef {

    ObtenerOrdenPetStore obtenerOrdenPetStore;


    @When("consulto la orden creada")
    public void obtenerOrden() {

        obtenerOrdenPetStore.obtenerOrden();
        //System.out.println("El Order ID: " + orderID);

    }
    @Then("el codigo de respuesta es {int}")
    public void CodigoRespuestaa(int statusCode) {
        obtenerOrdenPetStore.validarCodigoDeRespuesta(statusCode);
    }

    @And("el id del pet en la orden es {int}")
    public void respuestaPetIdd(int petId) {
        obtenerOrdenPetStore.validarRespuestaPetId(petId);
    }

    @And("la cantidad en la orden es {int}")
    public void respuesta_Cantidad(int quantity) {
        obtenerOrdenPetStore.validarRespuestaCantidad(quantity);
    }

    @And("el estado en la orden es {string}")
    public void respuesta_Status(String status) {
        obtenerOrdenPetStore.validarRespuestaStatusOrden(status);
    }

}
