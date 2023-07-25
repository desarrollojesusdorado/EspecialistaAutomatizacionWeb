package co.com.automatizacionWeb.screenplay.stepdefinitions;

import co.com.automatizacionWeb.screenplay.tasks.AbrirPagina;
import co.com.automatizacionWeb.screenplay.tasks.SeleccionarCategoria;
import co.com.automatizacionWeb.screenplay.tasks.SeleccionarProducto;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AgregarProductosFalabellaStepDefinition {

    @Dado("que el {actor} requiere ingresar a falabella")
    public void queElUsuarioRequiereIngresarAFalabella(Actor actor) {
        theActorCalled(String.valueOf(actor)).wasAbleTo(AbrirPagina.falabella());
    }

    @Cuando("el escoge una categoria {string} y subcategoria {string}")
    public void elEscogeUnaCategoriaYSubcategoria(String categoria, String subCategoria) {
        theActorInTheSpotlight().attemptsTo(SeleccionarCategoria.paraLosProductos(categoria, subCategoria));
    }
    @Cuando("el selecciona el producto {string} para agregar {int} unidades")
    public void elSeleccionaElProductoParaAgregarAlCarroDeCompras(String nombreProducto, Integer unidades) {
        theActorInTheSpotlight().attemptsTo(SeleccionarProducto.paraAgregar(nombreProducto, unidades));

    }
    @Cuando("el selecciona la garantia {string} para el producto")
    public void elSeleccionaLaGarantiaParaElProducto(String string) {

    }
    @Entonces("el verifica el numero de productos agregados al carro de compras")
    public void elVerificaElNumeroDeProductosAgregadosAlCarroDeCompras() {

    }
    @Entonces("el verifica el precio total de los productos agregados")
    public void elVerificaElPrecioTotalDeLosProductosAgregados() {

    }
    @Entonces("el verifica el precio de cada producto individual agregado")
    public void elVerificaElPrecioDeCadaProductoIndividualAgregado() {

    }

}
