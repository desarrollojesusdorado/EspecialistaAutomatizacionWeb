package co.com.automatizacionWeb.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import java.util.Random;

public class IngresarNumeroProductos implements Interaction {

    private final Target numeroProductos;
    private final Target objModificarUnidades;

    public IngresarNumeroProductos(Target numeroProductos, Target objModificarUnidades) {
        this.numeroProductos = numeroProductos;
        this.objModificarUnidades = objModificarUnidades;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        Random random = new Random();

        int numeroProductosDisponibles = Integer.parseInt(numeroProductos.resolveFor(actor).getText().substring(7,9));

        int randomInt = random.nextInt(numeroProductosDisponibles)+1;

        actor.attemptsTo(
                Clear.field(objModificarUnidades),
                Enter.theValue(String.valueOf(randomInt)).into(objModificarUnidades));
    }

    public static IngresarNumeroProductos porDisponibilidad(Target numeroProductos, Target objModificarUnidades) {
        return new IngresarNumeroProductos(numeroProductos, objModificarUnidades);
    }
}
