#Autor: Jesus Dorado
#language:es
  @PruebaGeneral
  Característica: prueba

    Esquema del escenario: Agregar productos al carro de compras

      Dado que el usuario requiere ingresar a falabella
      Y el escoge una categoria '<categoriaUno>' y subcategoria '<subCategoriaUno>'
      Cuando el escoge un portatil al azar para agregar varias unidades
      Y el selecciona garantia de tres años para el primer producto
      Y el escoge otra categoria '<categoriaDos>' y subcategoria '<subCategoriaDos>'
      Y el escoge un segundo producto para agregar al carro de compras
      Entonces el verifica el numero de productos agregados al carro de compras
      Y el verifica el precio total de los productos agregados
      Y el verifica el precio de cada producto individual agregado
      Ejemplos:
        | categoriaUno | subCategoriaUno | categoriaDos           | subCategoriaDos |  |
        | Tecnología   | Portátiles      | Celulares y accesorios | Smartphones     |  |

