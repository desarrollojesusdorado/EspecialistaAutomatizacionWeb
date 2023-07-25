#Autor: Jesus Dorado
#language:es
  @PruebaGeneral
  Característica: prueba

    Escenario: Agregar productos al carro de compras

      Dado que el usuario requiere ingresar a falabella
      Cuando el escoge una categoria "Tecnología" y subcategoria "Portátiles"
      Y el selecciona el producto "Portátil Hp AMD RYZEN R5 12GB 256GB Windows 11 Home 14 pulgadas 14-fq1012la" para agregar 5 unidades
      Y el selecciona la garantia "garantia" para el producto
      Entonces el verifica el numero de productos agregados al carro de compras
      Y el verifica el precio total de los productos agregados
      Y el verifica el precio de cada producto individual agregado
