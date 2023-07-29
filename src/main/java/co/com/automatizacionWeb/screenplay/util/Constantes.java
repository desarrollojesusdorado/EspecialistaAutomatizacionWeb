package co.com.automatizacionWeb.screenplay.util;

import java.text.NumberFormat;
import java.util.Locale;

public class Constantes {
    public static final String PRECIO_PRIMER_PRODUCTO_AGREGADO="PRECIO_PRIMER_PRODUCTO_AGREGADO";
    public static final String PRECIO_SEGUNDO_PRODUCTO_AGREGADO="PRECIO_SEGUNDO_PRODUCTO_AGREGADO";
    public static final String NUMERO_UNIDADES_PRODUCTO_UNO= "NUMERO_UNIDADES_PRODUCTO_UNO";
    public static final String NUMERO_UNIDADES_PRODUCTO_DOS="NUMERO_UNIDADES_PRODUCTO_DOS";
    public static final String PRECIO_GARANTIA_PRODUCTO_UNO="PRECIO_GARANTIA_PRODUCTO_UNO";

    public static String convertirADinero(int numero) {
        NumberFormat formatoDinero = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        return formatoDinero.format(numero);
    }
}
