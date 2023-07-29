package co.com.automatizacionWeb.screenplay.tasks;

import co.com.automatizacionWeb.screenplay.interactions.EscogerSegundoProducto;
import co.com.automatizacionWeb.screenplay.userinterface.PaginaProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import static co.com.automatizacionWeb.screenplay.userinterface.PaginaProducto.CANTIDAD_PRODUCTOS;
import static co.com.automatizacionWeb.screenplay.util.Constantes.*;

public class SeleccionarSegundoProducto implements Task {
    public static SeleccionarSegundoProducto paraAgregarAlCarro() {
        return Tasks.instrumented(SeleccionarSegundoProducto.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EscogerSegundoProducto.paraAgregarProducto()
        );

        if (!PaginaProducto.PRECIO_PRODUCTO.resolveFor(actor).isVisible()){
            actor.remember(PRECIO_SEGUNDO_PRODUCTO_AGREGADO,
                    PaginaProducto.PRECIO_PRODUCTO_ALTERNO.resolveFor(actor).getText().replaceAll("[$ .]", ""));
        }else {
            actor.remember(PRECIO_SEGUNDO_PRODUCTO_AGREGADO,
                    PaginaProducto.PRECIO_PRODUCTO.resolveFor(actor).getText().replaceAll("[$ .]", ""));
        }

        actor.remember(NUMERO_UNIDADES_PRODUCTO_DOS,
                CANTIDAD_PRODUCTOS.resolveFor(actor).getTextValue());

        actor.attemptsTo(Click.on(PaginaProducto.AGREGAR_AL_CARRO),
                Click.on(PaginaProducto.IR_AL_CARRO));


    }
}
