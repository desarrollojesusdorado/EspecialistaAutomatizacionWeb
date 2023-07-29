package co.com.automatizacionWeb.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.automatizacionWeb.screenplay.userinterface.PaginaPrincipal.NO_GRACIAS;

public class AbrirPagina {
    public static Performable falabella() {
        return Task.where("{0} Abre la pagina de compras Falabella",
                Open.browserOn().thePageNamed("url.pagina.web"),
                Click.on(NO_GRACIAS));
    }
}
