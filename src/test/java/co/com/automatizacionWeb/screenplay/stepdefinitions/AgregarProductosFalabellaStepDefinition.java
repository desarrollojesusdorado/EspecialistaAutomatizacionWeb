package co.com.automatizacionWeb.screenplay.stepdefinitions;

import co.com.automatizacionWeb.screenplay.questions.VerificarNumeroProducto;
import co.com.automatizacionWeb.screenplay.questions.VerificarPrecioIndividual;
import co.com.automatizacionWeb.screenplay.questions.VerificarPrecioTotal;
import co.com.automatizacionWeb.screenplay.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AgregarProductosFalabellaStepDefinition {

    @Dado("que el {actor} requiere ingresar a falabella")
    public void queElUsuarioRequiereIngresarAFalabella(Actor actor) {
        theActorCalled(String.valueOf(actor)).wasAbleTo(AbrirPagina.falabella());
    }

    @Y("el escoge una categoria {string} y subcategoria {string}")
    public void elEscogeUnaCategoriaYSubcategoria(String categoria, String subCategoria) {
        theActorInTheSpotlight().attemptsTo(SeleccionarCategoria.paraLosProductos(categoria, subCategoria));
    }
    @Cuando("el escoge un portatil al azar para agregar varias unidades")
    public void elEscogeUnProductoAlAzarParaAgregarVariasUnidades() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPrimerProducto.paraAgregar());
    }
    @Cuando("el selecciona garantia de tres años para el primer producto")
    public void elSeleccionaLaGarantiaParaElProducto() {
        theActorInTheSpotlight().attemptsTo(SeleccionarGarantia.paraElPrimerProducto());
    }

    @Y("el escoge otra categoria {string} y subcategoria {string}")
    public void elEscogeOtraCategoriaYSubcategoria(String categoriaDos, String subCategoriaDos) {
        theActorInTheSpotlight().attemptsTo(SeleccionarCategoria.paraLosProductos(categoriaDos, subCategoriaDos));
    }

    @Y("el escoge un segundo producto para agregar al carro de compras")
    public void elEscogeUnSegundoProductoParaAgregarAlCarroDeCompras() {
        theActorInTheSpotlight().attemptsTo(SeleccionarSegundoProducto.paraAgregarAlCarro());
    }
    @Entonces("el verifica el numero de productos agregados al carro de compras")
    public void elVerificaElNumeroDeProductosAgregadosAlCarroDeCompras() {
        theActorInTheSpotlight().should(seeThat(VerificarNumeroProducto.agregadosAlCarro()));

    }
    @Entonces("el verifica el precio total de los productos agregados")
    public void elVerificaElPrecioTotalDeLosProductosAgregados() {
        theActorInTheSpotlight().should(seeThat(VerificarPrecioTotal.deLosProductos()));

    }
    @Entonces("el verifica el precio de cada producto individual agregado")
    public void elVerificaElPrecioDeCadaProductoIndividualAgregado() {
        theActorInTheSpotlight().should(seeThat(VerificarPrecioIndividual.paraProductosAgregados()));
    }



}
