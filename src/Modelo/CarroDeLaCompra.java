package Modelo;

import java.util.ArrayList;
import java.util.List;

public class CarroDeLaCompra {
    private List<Producto> listProduct = new ArrayList<Producto>();
    private int total = 0;

    public enum ESTADO {
        VACIO, 
        PREPARADO, 
        COMPRADO, 
        ENVIADO, 
        ANULADO
    }

    private ESTADO estado = ESTADO.VACIO;

    public ESTADO getEstado() { return estado; }
    public int getTotal() { return total; }

    public CarroDeLaCompra() {}

    public void addProductCarro(Producto producto) {
        listProduct.add(producto);
        total = total + producto.getPrecio();
        estado = ESTADO.PREPARADO;
    }

    public void quitarProductCarro(int posicion, int precio) {
        if (posicion >= 0 && posicion < listProduct.size()) {
            listProduct.remove(posicion);
            total = total - precio;
            estado = ESTADO.PREPARADO;
        }
    }

    public void comprarCarrito() {
        estado = ESTADO.COMPRADO;
    }

    public int getNumeroProductos() {
        return listProduct.size();
    }
}