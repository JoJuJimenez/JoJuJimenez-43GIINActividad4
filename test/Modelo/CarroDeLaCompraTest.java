package Modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CarroDeLaCompraTest {
    
    static Producto producto1, producto2, producto3;
    static CarroDeLaCompra carro;
    
    @BeforeClass
    public static void setUpClass() {
        producto1 = new Producto("Sauce Labs Backpack", 30, "backpack");
        producto2 = new Producto("Sauce Labs Bike Light", 10, "bike-light");
        producto3 = new Producto("Sauce Labs Bolt T-Shirt", 16, "bolt-shirt");
    }
    
    @Before
    public void setUp() {
        carro = new CarroDeLaCompra();
    }
    
    // Prueba #1: Verificar que se pueden añadir productos (HU-4)
    @Test
    public void testAnadirProductoAlCarro() {
        assertEquals(CarroDeLaCompra.ESTADO.VACIO, carro.getEstado());
        assertEquals(0, carro.getTotal());
        
        carro.addProductCarro(producto1);
        assertEquals(30, carro.getTotal());
        assertEquals(CarroDeLaCompra.ESTADO.PREPARADO, carro.getEstado());
    }
    
    // Prueba #2: Verificar múltiples productos
    @Test
    public void testAnadirMultiplesProductos() {
        carro.addProductCarro(producto1);
        carro.addProductCarro(producto2);
        carro.addProductCarro(producto3);
        
        int totalEsperado = 30 + 10 + 16; // 56
        assertEquals(totalEsperado, carro.getTotal());
    }
    
    // Prueba #3: Verificar compra de carrito
    @Test
    public void testComprarCarrito() {
        carro.addProductCarro(producto1);
        carro.comprarCarrito();
        assertEquals(CarroDeLaCompra.ESTADO.COMPRADO, carro.getEstado());
    }
    
    // Prueba #4: Verificar quitar producto
    @Test
    public void testquitarProductCarro() {
        carro.addProductCarro(producto1);
        carro.addProductCarro(producto2);
        assertEquals(2, carro.getNumeroProductos());
        
        carro.quitarProductCarro(0, 30);
        assertEquals(1, carro.getNumeroProductos());
        assertEquals(10, carro.getTotal());
    }
    
    // Prueba #5: Estado del carro
    @Test
    public void testEstadoCarro() {
        assertEquals(CarroDeLaCompra.ESTADO.VACIO, carro.getEstado());
        carro.addProductCarro(producto1);
        assertEquals(CarroDeLaCompra.ESTADO.PREPARADO, carro.getEstado());
    }
}