/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package practicaevaluada2.sophiaherrera;

/**
 *
 * @author fapis
 */
public enum TipoProducto {
    Alimentos("Alimentos"),Bebidas("Bebidas"),Higiene("Higiene"),Limpieza("Limpieza");

    private final String descripcion;

    TipoProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * return el nombre del tipo de producto
     */
    public String getDescripcion() {
        return descripcion;
    }
}
