package com.nttdata.stepsdefinitions;

import com.nttdata.screens.ProdSelScreen;
import com.nttdata.screens.ProductsScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CarritoStepsDefinitions extends UIInteractionSteps {

    @Steps
    ProductsScreen productsScreen;
    ProdSelScreen prodSelScreen;

    int cantidadEsperada = 0;

    @Given("estoy en la aplicación MyDemoApp")
    public void estoyEnLaAplicaciónMyDemoApp() {
        productsScreen.open();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        assertThat(productsScreen.galeriaCargada()).isTrue();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoUNIDADESDelSiguienteProducto(int unidades, String producto) {
        productsScreen.seleccionarProducto(producto);

        prodSelScreen.ajustarCantidad(unidades);

        prodSelScreen.agregarAlCarrito();

        cantidadEsperada += unidades;
    }

    @Then("valido que el carrito de compra actualice correctamente")
    public void validoQueElCarritoDeCompraActualiceCorrectamente() {

        assertThat(prodSelScreen.obtenerCantidadCarrito()).isEqualTo(cantidadEsperada);
    }
}
