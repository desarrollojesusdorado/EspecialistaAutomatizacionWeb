package co.com.automatizacionWeb.screenplay.util;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {
    @Before
    public static void prepararEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }
}
