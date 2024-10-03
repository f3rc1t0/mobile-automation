package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProdSelScreen {

    //Localizadores de elementos
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement carritoCantidad;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement btnAgregarCarrito;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Decrease item quantity\"]")
    private WebElement btnMenos;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    private WebElement btnMas;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]")
    private WebElement cantidad;

    public ProdSelScreen() {
        super();
    }

    //Método para ajustar la cantidad

    public void ajustarCantidad(int unidades) {
        int cantidadActual = Integer.parseInt(cantidad.getText());

        if (unidades < cantidadActual) {
            // Decrementar si unidades son menores que la cantidad actual
            for (int i = 0; i < (cantidadActual - unidades); i++) {
                btnMenos.click();
            }
        } else if (unidades > cantidadActual) {
            // Incrementar si unidades son mayores que la cantidad actual
            for (int i = 0; i < (unidades - cantidadActual); i++) {
                btnMas.click();
            }
        }
    }

    public void agregarAlCarrito() {
        btnAgregarCarrito.click();
    }

    public int obtenerCantidadActual() {
        return Integer.parseInt(cantidad.getText());
    }

    public int obtenerCantidadCarrito() {
        String carritoTexto = carritoCantidad.getText();
        if(carritoTexto.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(carritoTexto);
    }

}
