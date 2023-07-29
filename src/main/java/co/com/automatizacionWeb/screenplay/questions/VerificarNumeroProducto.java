package co.com.automatizacionWeb.screenplay.questions;

import co.com.automatizacionWeb.screenplay.userinterface.PaginaCarroCompras;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.automatizacionWeb.screenplay.util.Constantes.*;

public class VerificarNumeroProducto implements Question<Boolean> {
    public static VerificarNumeroProducto agregadosAlCarro() {
        return new VerificarNumeroProducto();
    }
    @Override
    public Boolean answeredBy(Actor actor) {

        boolean condicion;

        String datoGarantia = actor.recall(PRECIO_GARANTIA_PRODUCTO_UNO);

        if (datoGarantia == null){

            int numeroProductosPagina = Integer.parseInt(Text.of(PaginaCarroCompras.NUMERO_PRODUCTOS_PAGINA).answeredBy(actor).replaceAll("[^0-9]", ""));
            int numeroProductosUno = Integer.parseInt(actor.recall(NUMERO_UNIDADES_PRODUCTO_UNO));
            int numeroProductosDos = Integer.parseInt(actor.recall(NUMERO_UNIDADES_PRODUCTO_DOS));

            int numeroProductosTotal = numeroProductosUno+numeroProductosDos;

            condicion=numeroProductosTotal==numeroProductosPagina;

        }else{
            int numeroProductosPagina = Integer.parseInt(Text.of(PaginaCarroCompras.NUMERO_PRODUCTOS_PAGINA).answeredBy(actor).replaceAll("[^0-9]", ""));
            int numeroProductosUno = Integer.parseInt(actor.recall(NUMERO_UNIDADES_PRODUCTO_UNO));
            int numeroProductosDos = Integer.parseInt(actor.recall(NUMERO_UNIDADES_PRODUCTO_DOS));
            int numeroGarantiasProductoUno = Integer.parseInt(actor.recall(NUMERO_UNIDADES_PRODUCTO_UNO));

            int numeroProductosTotal = numeroProductosUno+numeroProductosDos+numeroGarantiasProductoUno;

            condicion=numeroProductosTotal==numeroProductosPagina;

        }
        return condicion;
    }
}
