package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsScreen extends PageObject {

    //Localizadores de elementos
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.view.ViewGroup")
    private WebElement productosContenedor;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement carritoCompras;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement botonAgregar;



    public ProductsScreen() {
        super();
    }

    //Método para verificar si la galería está cargada
    public boolean galeriaCargada() {
        waitFor(ExpectedConditions.visibilityOf(productosContenedor));
        return productosContenedor.isDisplayed();
    }

    //Método para agregar un producto al carrito
    public void seleccionarProducto(String nombreProducto){
        String xpathDinamico = "//android.widget.ImageView[@content-desc=\\\"\" + nombreProducto + \"\\\"]";
        WebElement producto = getDriver().findElement(By.xpath(xpathDinamico));
        producto.click();
    }

}
