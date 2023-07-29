package co.com.automatizacionWeb.screenplay.questions;

import co.com.automatizacionWeb.screenplay.userinterface.PaginaCarroCompras;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.util.List;
import static co.com.automatizacionWeb.screenplay.util.Constantes.PRECIO_PRIMER_PRODUCTO_AGREGADO;
import static co.com.automatizacionWeb.screenplay.util.Constantes.PRECIO_SEGUNDO_PRODUCTO_AGREGADO;

public class VerificarPrecioIndividual implements Question<Boolean> {
    public static VerificarPrecioIndividual paraProductosAgregados() {
        return new VerificarPrecioIndividual();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String precioProductoUno = actor.recall(PRECIO_PRIMER_PRODUCTO_AGREGADO);
        String precioProductoDos = actor.recall(PRECIO_SEGUNDO_PRODUCTO_AGREGADO);

        List<WebElementFacade> listaPreciosPagina = PaginaCarroCompras.LISTADO_PRECIOS_CARRO.resolveAllFor(actor);

        return compararElementosEnLista(listaPreciosPagina, precioProductoUno, precioProductoDos);


    }

    public boolean compararElementosEnLista(List<WebElementFacade> listaPreciosPagina, String precioProductoUno, String precioProductoDos) {

        boolean precioProdUnoEncontrado = false;
        boolean precioProdDosEncontrado = false;

        for (WebElementFacade elemento : listaPreciosPagina) {
            String textoPrecio = elemento.getText().replaceAll("[$ .]", "");

            if (textoPrecio.contains(precioProductoUno)) {
                precioProdUnoEncontrado = true;
            }

            if (textoPrecio.contains(precioProductoDos)) {
                precioProdDosEncontrado = true;
            }

            if (precioProdUnoEncontrado && precioProdDosEncontrado) {
                break;
            }
        }
        return precioProdUnoEncontrado && precioProdDosEncontrado;
    }

}
