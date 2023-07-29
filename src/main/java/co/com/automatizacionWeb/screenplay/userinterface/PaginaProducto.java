package co.com.automatizacionWeb.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaProducto {

    public static final Target INGRESAR_UNIDADES = Target.the("Ingresa unidades a agregar al carro del producto")
            .located(By.id("quantity-selector-increment-input"));
    public static final Target GARANTIA_TRES_A = Target.the("Ingresa unidades a agregar al carro del producto")
            .locatedBy("//span[text()='3 años de Garantía Extendida']");

    public static final Target AGREGAR_AL_CARRO = Target.the("Click botton para aggrear producto al carro")
            .located(By.id("add-to-cart-button"));

    public static final Target SEGUIR_COMPRANDO = Target.the("Click para seguir comprando")
            .located(By.xpath("//*[@id='__next']/div/div/div/div/div/div/div[3]/div[2]/button"));

    public static final Target LISTA_PORTATILES = Target.the("lista portatiles")
            .located(By.xpath("//*[@id='testId-searchResults-products']/div/div/div[2]/a/div[1]/div[1]//*[contains(text(), 'Portátil')]"));

    public static final Target PRECIO_PRODUCTO = Target.the("Guardar precio producto aggregado")
                .locatedBy("(//*[@data-variant='PDP_MAIN'])[2]");
    public static final Target PRECIO_PRODUCTO_ALTERNO = Target.the("Guardar precio producto cuando no tiene descuento el producto")
            .locatedBy("(//*[@data-variant='PDP_MAIN'])[1]");

    public static final Target PRODUCTOS_DISPONIBLES = Target.the("# maximo productos disponibles")
            .locatedBy("//*[@id='product-b2c-ui']/descendant::p[2]");

    public  static final Target     PRECIO_GARANTIA = Target.the("Guardar precio garantia primer producto")
            .located(By.xpath("//*[@id='__next']/descendant::td[5]"));

    public  static final Target LISTA_PRODUCTOS = Target.the("Lista productos")
            .locatedBy("//*[@id='testId-searchResults-products']/div/div/div[2]/a/div[1]/div[1]/span[1]/b");

    public  static final Target LISTA_PRODUCTOS_DIFERENTE = Target.the("Lista productos diferente")
            .locatedBy("//*[@id='testId-searchResults-products']/div/div/div[2]/a/span[1]/b[1]");
    public  static final Target PRODUCTO_AZAR = Target.the("Click cualquier producto")
            .locatedBy("(//*[@id='testId-searchResults-products']/div/div/div[2]/a/div[1]/div[1]/span[1]/b[1])[{0}]");

    public  static final Target PRODUCTO_AZAR_DIFERENTE = Target.the("Click cualquier producto")
            .locatedBy("(//*[@id='testId-searchResults-products']/div/div/div[2]/a/span[1]/b[1])[{0}]");

    public  static final Target CANTIDAD_PRODUCTOS = Target.the("Cantidad productos agregados")
            .locatedBy("//*[@id='quantity-selector-increment-input']");

    public  static final Target IR_AL_CARRO = Target.the("Ir al carro de compras")
            .located(By.id("linkButton"));

}
