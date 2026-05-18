package Modelo;

public class Producto {
    private String nombre;
    private int precio;
    private String version;
    private int numUdsAlma;

    public Producto(String nombre, int precio, String version) {
        this.nombre = nombre;
        this.precio = precio;
        this.version = version;
        this.numUdsAlma = 0;
    }

    public String getNombre() { return nombre; }
    public int getPrecio() { return precio; }
    public String getVersion() { return version; }
    public int getNumUdsAlm() { return numUdsAlma; }

    public void addUdAlma() {
        this.numUdsAlma++;
    }

    public void quitarUdAlm() {
        if (this.numUdsAlma > 0) {
            this.numUdsAlma--;
        }
    }
}