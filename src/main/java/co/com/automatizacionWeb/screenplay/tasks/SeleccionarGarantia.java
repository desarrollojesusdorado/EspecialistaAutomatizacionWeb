package co.com.automatizacionWeb.screenplay.tasks;

import co.com.automatizacionWeb.screenplay.userinterface.PaginaProducto;
import co.com.automatizacionWeb.screenplay.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarGarantia implements Task{

    public static SeleccionarGarantia paraElPrimerProducto() {
        return Tasks.instrumented(SeleccionarGarantia.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(WaitUntil.the(PaginaProducto.SEGUIR_COMPRANDO, isVisible()).forNoMoreThan(5).seconds());

        if (!PaginaProducto.GARANTIA_TRES_A.isVisibleFor(actor)){
            actor.attemptsTo(Click.on(PaginaProducto.SEGUIR_COMPRANDO));
        }else {
            actor.attemptsTo(
                    Click.on(PaginaProducto.GARANTIA_TRES_A)
            );
            actor.remember(Constantes.PRECIO_GARANTIA_PRODUCTO_UNO,
                    PaginaProducto.PRECIO_GARANTIA.resolveFor(actor).getText().replaceAll("[$ .]", ""));
            actor.attemptsTo(Click.on(PaginaProducto.SEGUIR_COMPRANDO));
        }
    }
}
