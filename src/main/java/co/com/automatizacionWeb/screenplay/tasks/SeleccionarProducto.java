package co.com.automatizacionWeb.screenplay.tasks;

import co.com.automatizacionWeb.screenplay.userinterface.PaginaProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class SeleccionarProducto {
    public static Performable paraAgregar(String nombreProducto, Integer unidades) {
        return Task.where("{0} Escoge el producto ",
                Click.on(PaginaProducto.SELECCIONAR_PRODUCTO.of(nombreProducto)),
                Clear.field(PaginaProducto.MODIFICAR_UNIDADES),
                        Enter.theValue(String.valueOf(unidades)).into(PaginaProducto.MODIFICAR_UNIDADES),
                Click.on(PaginaProducto.AGREGAR_AL_CARRO),
                Click.on(PaginaProducto.SELECCION_GARANTIA),
                Click.on(PaginaProducto.SEGUIR_COMPRANDO));
    }
}
