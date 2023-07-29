package co.com.automatizacionWeb.screenplay.userinterface;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaCarroCompras {
    public static final Target NUMERO_PRODUCTOS_PAGINA = Target.the("# total productos en carro compras")
            .located(By.xpath("//*[@id='pricing']/div[1]/div[1]/p"));
    public static final Target PRECIO_TOTAL_PAGINA = Target.the("Precio total pagina")
            .located(By.xpath("//*[@id='pricing']/div[2]/div/p"));

    public static final Target LISTADO_PRECIOS_CARRO = Target.the("Listado precios mostrados en carro")
            .located(By.xpath("//*[@id='__next']/div/div[2]/div/section[1]/div/div[3]/div/div/div[2]/div[1]/div/div/div[2]/div/div[2]/div/div/div/div/span"));
}

