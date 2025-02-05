package com.nttdata.glue;

import com.nttdata.steps.CrearOrdenPetStore;
import com.nttdata.steps.ObtenerOrdenPetStore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ObtenerOrderStepsDef {

    ObtenerOrdenPetStore obtenerOrdenPetStore;

    @When("consulto la orden creada")
    public void obtenerOrden(int orderId) {
        obtenerOrdenPetStore.obtenerOrden(orderId);
    }

    //@Then("el codigo respuesta es {int}")

    //@And("el id del pet en la orden es {int}")

   //@And("la cantidad en la orden es {int}")

    //@And("el estado en la orden es {string}")
}
