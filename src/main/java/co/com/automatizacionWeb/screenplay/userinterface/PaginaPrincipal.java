package co.com.automatizacionWeb.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;

public class PaginaPrincipal {
    public static final Target NO_GRACIAS = Target.the("Click cerrar ventana popup")
            .located(ByShadow.cssSelector("button[class='airship-btn airship-btn-deny']", "div[class='airship-html-prompt-shadow']"));

    public static final Target MENU = Target.the("Click boton menu")
            .located(By.id("testId-HamburgerBtn-toggle"));

    public static final Target CATEGORIA = Target.the("Escoger categoria")
            .locatedBy("//div[contains(text(), '{0}')]");

    public static final Target SUB_CATEGORIA = Target.the("Escoger sub categoria")
            .locatedBy("(//a[contains(text(), '{0}')])[1]");

}
