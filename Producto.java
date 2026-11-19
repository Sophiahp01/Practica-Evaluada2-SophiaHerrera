/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaevaluada2.sophiaherrera;

/**
 *
 * @author fapis
 */
public class Producto {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precioBase;
    private TipoProducto tipo;
    private double precioBruto;

    
    public Producto(String codigo, String nombre, int cantidad, double precioBase, TipoProducto tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioBase = precioBase;
        this.tipo = tipo;
        this.precioBruto = calcularPrecioBruto();
    }

    /**
     * Calcula el precio bruto según el tipo de producto
     * @return precio bruto
     */
    public double calcularPrecioBruto() {
        double bruto = 0;
        if (tipo == TipoProducto.Alimentos) {
            bruto = precioBase * 0.20 + precioBase;
        } else if (tipo == TipoProducto.Bebidas) {
            bruto = precioBase * 0.30 + precioBase;
        } else if (tipo == TipoProducto.Higiene) {
            bruto = precioBase * 0.25 + precioBase + 500;
        } else if (tipo == TipoProducto.Limpieza) {
            bruto = precioBase * 0.19 + precioBase * 0.04 + 1000 + precioBase;
        }
        return bruto;
    }

    /**
     * Calcula la ganancia esperada: (PrecioBruto - PrecioBase) * Cantidad
     * @return ganancia esperada
     */
    public double calcularGananciaEsperada() {
        return (precioBruto - precioBase) * cantidad;
    }

    /**
     * @return texto con la información del producto
     */
    public String mostrarInformacion() {
        return "Código: " + codigo
                + "\nNombre: " + nombre
                + "\nTipo: " + tipo
                + "\nCantidad: " + cantidad
                + "\nPrecio base: " + precioBase
                + "\nPrecio bruto: " + precioBruto
                + "\nGanancia esperada: " + calcularGananciaEsperada();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public double getPrecioBruto() {
        return precioBruto;
    }

}
