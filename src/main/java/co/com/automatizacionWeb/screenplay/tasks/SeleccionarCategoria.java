package co.com.automatizacionWeb.screenplay.tasks;

import co.com.automatizacionWeb.screenplay.userinterface.PaginaPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarCategoria implements Task{

    private final String categoria;
    private final String subCategoria;

    public SeleccionarCategoria(String categoria, String subCategoria) {
        this.categoria = categoria;
        this.subCategoria = subCategoria;
    }

    public static SeleccionarCategoria paraLosProductos(String categoria, String subCategoria) {
        return Tasks.instrumented(SeleccionarCategoria.class,categoria,subCategoria);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaPrincipal.MENU),
                Click.on(PaginaPrincipal.CATEGORIA.of(categoria)),
                Click.on(PaginaPrincipal.SUB_CATEGORIA.of(subCategoria)
        ));

    }
}
