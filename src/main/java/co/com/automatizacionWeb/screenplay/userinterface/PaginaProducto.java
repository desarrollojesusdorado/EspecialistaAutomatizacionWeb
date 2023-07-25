package co.com.automatizacionWeb.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaProducto {

    public static final Target SELECCIONAR_PRODUCTO = Target.the("Selecciona producto")
            .locatedBy("//b[contains(text(), '{0}')]");

    public static final Target MODIFICAR_UNIDADES = Target.the("Ingresa unidades a agregar al carro del producto")
            .located(By.id("quantity-selector-increment-input"));
    public static final Target SELECCION_GARANTIA = Target.the("Ingresa unidades a agregar al carro del producto")
            .located(By.xpath("//span[text()='3 años de Garantía Extendida']"));

    public static final Target AGREGAR_AL_CARRO = Target.the("Click botton para aggrear producto al carro")
            .located(By.id("add-to-cart-button"));

    public static final Target SEGUIR_COMPRANDO = Target.the("Click para seguir comprando")
            .located(By.xpath("//*[@id='__next']/div/div/div/div/div/div/div[3]/div[2]/button"));

}
