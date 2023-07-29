package co.com.automatizacionWeb.screenplay.questions;

import co.com.automatizacionWeb.screenplay.userinterface.PaginaCarroCompras;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import static co.com.automatizacionWeb.screenplay.util.Constantes.*;

public class VerificarPrecioTotal implements Question<Boolean> {
    public static VerificarPrecioTotal deLosProductos() {
        return new VerificarPrecioTotal();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        boolean condicion = false;

        int precioTotalPagina = Integer.parseInt(Text.of(PaginaCarroCompras.PRECIO_TOTAL_PAGINA).answeredBy(actor).replaceAll("[$ .]", ""));

        String datoGarantia = actor.recall(PRECIO_GARANTIA_PRODUCTO_UNO);

        if (datoGarantia==null){

            int precioProductoUno = Integer.parseInt(actor.recall(PRECIO_PRIMER_PRODUCTO_AGREGADO));
            int precioProductoDos = Integer.parseInt(actor.recall(PRECIO_SEGUNDO_PRODUCTO_AGREGADO));
            int unidadesProductoUno = Integer.parseInt(actor.recall(NUMERO_UNIDADES_PRODUCTO_UNO));
            int unidadesProductoDos = Integer.parseInt(actor.recall(NUMERO_UNIDADES_PRODUCTO_DOS));

            int totalProductos = (precioProductoUno*unidadesProductoUno)+(precioProductoDos*unidadesProductoDos);

            Serenity.recordReportData().withTitle("Precios Comparados")
                    .andContents("Precio total robot: "+convertirADinero(totalProductos)+"\n"+
                            "Precio Total en pagina: "+convertirADinero(precioTotalPagina));

            condicion= totalProductos==precioTotalPagina;

        }else {

            int precioProductoUno = Integer.parseInt(actor.recall(PRECIO_PRIMER_PRODUCTO_AGREGADO));
            int precioProductoDos = Integer.parseInt(actor.recall(PRECIO_SEGUNDO_PRODUCTO_AGREGADO));
            int unidadesProductoUno = Integer.parseInt(actor.recall(NUMERO_UNIDADES_PRODUCTO_UNO));
            int unidadesProductoDos = Integer.parseInt(actor.recall(NUMERO_UNIDADES_PRODUCTO_DOS));
            int valorGarantiaProdUno = Integer.parseInt(actor.recall(PRECIO_GARANTIA_PRODUCTO_UNO));

            int totalProductos = (precioProductoUno*unidadesProductoUno)+(precioProductoDos*unidadesProductoDos)+(valorGarantiaProdUno*unidadesProductoUno);

            Serenity.recordReportData().withTitle("Precios Comparados")
                    .andContents("Precio total robot: "+convertirADinero(totalProductos)+"\n"+
                            "Precio Total en pagina: "+convertirADinero(precioTotalPagina));

            condicion= totalProductos==precioTotalPagina;

        }
        return condicion;
    }
}
