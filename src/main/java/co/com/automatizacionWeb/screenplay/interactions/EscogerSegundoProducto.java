package co.com.automatizacionWeb.screenplay.interactions;

import co.com.automatizacionWeb.screenplay.userinterface.PaginaProducto;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import java.util.List;
import java.util.Random;

public class EscogerSegundoProducto implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        Random numeroAleatorio = new Random();

        List<WebElementFacade> listaProductos = PaginaProducto.LISTA_PRODUCTOS.resolveAllFor(actor);

        if (listaProductos == null || listaProductos.isEmpty()){

            List<WebElementFacade> listaProductosDiferente = PaginaProducto.LISTA_PRODUCTOS_DIFERENTE.resolveAllFor(actor);

            int numProductoDiferentes = numeroAleatorio.nextInt(listaProductosDiferente.size());

            actor.attemptsTo(Click.on(PaginaProducto.PRODUCTO_AZAR_DIFERENTE.of(String.valueOf(numProductoDiferentes))));

        }else {
            int numProducto = numeroAleatorio.nextInt(listaProductos.size());
            actor.attemptsTo(Click.on(PaginaProducto.PRODUCTO_AZAR.of(String.valueOf(numProducto))));
        }

    }
    public static EscogerSegundoProducto paraAgregarProducto() {
        return new EscogerSegundoProducto();
    }
}
