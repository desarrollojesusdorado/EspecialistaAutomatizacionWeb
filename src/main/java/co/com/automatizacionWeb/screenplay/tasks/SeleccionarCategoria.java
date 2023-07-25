package co.com.automatizacionWeb.screenplay.tasks;

import co.com.automatizacionWeb.screenplay.userinterface.PaginaPrincipal;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;

public class SeleccionarCategoria {

    public static Performable paraLosProductos(String categoria, String subCategoria) {
        return Task.where("{0} Selecciona categoria y sub categoria",
                Click.on(PaginaPrincipal.MENU),
                MoveMouse.to(PaginaPrincipal.CATEGORIA.of(categoria)),
                Click.on(PaginaPrincipal.SUB_CATEGORIA.of(subCategoria)));
    }
}
