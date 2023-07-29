package co.com.automatizacionWeb.screenplay.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import java.util.List;
import java.util.Random;

public class EscogerProducto implements Interaction {
    private Target listaProductosPagina;

    public EscogerProducto(Target listaProductosPagina) {
        this.listaProductosPagina = listaProductosPagina;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        Random random = new Random();

        int posicion=0;

        List<WebElementFacade> listaProductos = listaProductosPagina.resolveAllFor(actor);

        int randomInt = random.nextInt(listaProductos.size());

        System.out.println(randomInt);

        for (int i =0; i < listaProductos.size(); i++){
            if (String.valueOf(randomInt).equals(String.valueOf(i))){
                posicion=i;
            }
        }
        listaProductos.get(posicion).click();
    }
    public static EscogerProducto enLaPagina(Target listaProductosPagina) {
        return new EscogerProducto(listaProductosPagina);
    }
}
