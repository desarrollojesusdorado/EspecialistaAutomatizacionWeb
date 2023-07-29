package co.com.automatizacionWeb.screenplay.tasks;

import co.com.automatizacionWeb.screenplay.interactions.EscogerProducto;
import co.com.automatizacionWeb.screenplay.interactions.IngresarNumeroProductos;
import co.com.automatizacionWeb.screenplay.userinterface.PaginaProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import static co.com.automatizacionWeb.screenplay.userinterface.PaginaProducto.*;
import static co.com.automatizacionWeb.screenplay.util.Constantes.NUMERO_UNIDADES_PRODUCTO_UNO;
import static co.com.automatizacionWeb.screenplay.util.Constantes.PRECIO_PRIMER_PRODUCTO_AGREGADO;

public class SeleccionarPrimerProducto implements Task{
    public static SeleccionarPrimerProducto paraAgregar() {
        return Tasks.instrumented(SeleccionarPrimerProducto.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EscogerProducto.enLaPagina(LISTA_PORTATILES),
                IngresarNumeroProductos.porDisponibilidad(PRODUCTOS_DISPONIBLES,  INGRESAR_UNIDADES)
                );

        if (!PaginaProducto.PRECIO_PRODUCTO.isVisibleFor(actor)){
            actor.remember(PRECIO_PRIMER_PRODUCTO_AGREGADO,
                    PRECIO_PRODUCTO_ALTERNO.resolveFor(actor).getText().replaceAll("[$ .]", ""));
            actor.remember(NUMERO_UNIDADES_PRODUCTO_UNO,
                    CANTIDAD_PRODUCTOS.resolveFor(actor).getTextValue());
            actor.attemptsTo(Click.on(PaginaProducto.AGREGAR_AL_CARRO));
        }else{
            actor.remember(PRECIO_PRIMER_PRODUCTO_AGREGADO,
                    PaginaProducto.PRECIO_PRODUCTO.resolveFor(actor).getText().replaceAll("[$ .]", ""));

            actor.remember(NUMERO_UNIDADES_PRODUCTO_UNO,
                    CANTIDAD_PRODUCTOS.resolveFor(actor).getTextValue());

            actor.attemptsTo(Click.on(PaginaProducto.AGREGAR_AL_CARRO));
        }
    }
}
