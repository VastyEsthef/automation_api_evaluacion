package com.nttdata.glue;

import com.nttdata.steps.CrearOrdenPetStore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CrearOrdenStepsDef {
    @Steps
    CrearOrdenPetStore crearOrden;

    @When("crea una orden con el pet {int}, la cantidad {int}, el estado {string}")
    public void crearOrden(int petId, int  quantity, String status) {
        crearOrden.crearOrden(petId, quantity, status);
        String orderId = crearOrden.obtenerOrderId(); // Obtener el ID de la orden creada
        //orderId.setOrderId(orderId); // Guardarlo en el Singleton
        System.out.println("Se guardó el Order ID: " + orderId);
    }

    @Then("el codigo respuesta es {int}")
    public void CodigoRespuesta(int statusCode) {
        crearOrden.validarCodigoDeRespuesta(statusCode);
    }

    @And("el id del pet en la respuesta es {int}")
    public void respuestaPetId(int petId) {
        crearOrden.validarRespuestaPetId(petId);
    }
    @And("la cantidad en la respuesta es {int}")
    public void respuestaCantidad(int quantity) {
        crearOrden.validarRespuestaCantidad(quantity);
    }

    @And("el estado en la respuesta es {string}")
    public void respuestaStatus(String status) {
        crearOrden.validarRespuestaStatusOrden(status);
    }

}
