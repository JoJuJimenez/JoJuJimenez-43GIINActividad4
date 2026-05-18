package Modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductoTest {
    
    static Producto producto;
    
    @BeforeClass
    public static void setUpClass() {
        // prodcuto copiado en texto de la web original
        producto = new Producto("Sauce Labs Backpack", 30, "backpack");
    }
    
    @Before
    public void setUp() {
        // poner a 0 antes de todo
        while(producto.getNumUdsAlm() > 0) {
            producto.quitarUdAlm();
        }
    }
    
    @Test
    public void testCrearProducto() {
        assertEquals("Sauce Labs Backpack", producto.getNombre());
        assertEquals(30, producto.getPrecio());
        assertEquals("backpack", producto.getVersion());
        assertEquals(0, producto.getNumUdsAlm());  // Ahora si es0
    }
    
    @Test
    public void testAnadirUnidadAlAlmacen() {
        producto.addUdAlma();
        assertEquals(1, producto.getNumUdsAlm());
    }
    
    @Test
    public void testquitarUdAlm() {
        producto.addUdAlma();  
        producto.addUdAlma();  
        assertEquals(2, producto.getNumUdsAlm());
        
        producto.quitarUdAlm();
        assertEquals(1, producto.getNumUdsAlm());
    }
    
    @Test
    public void testNoQuitarUnidadSiNoHay() {
        // Aseguramos que está en 0
        while(producto.getNumUdsAlm() > 0) {
            producto.quitarUdAlm();
        }
        producto.quitarUdAlm();
        assertEquals(0, producto.getNumUdsAlm());
    }
}