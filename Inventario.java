/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaevaluada2.sophiaherrera;

import javax.swing.JOptionPane;


/**
 *
 * @author fapis
 */
public class Inventario {
    private String nombreSuper;
    private String codigoSuper;
    private String nombreEmpleado;
    private String cedulaEmpleado;
    private Producto[] productos;

    /**
     * Flujo principal del sistema
     */
    public void iniciar() {
        solicitarDatosGenerales();
        String lectura = JOptionPane.showInputDialog("¿Cuántos productos distintos desea ingresar?");
        int cantidadProductos = Integer.parseInt(lectura);
        productos = new Producto[cantidadProductos];
        solicitarProductos();
        mostrarProductos();
        mostrarGananciaTotal();
    }

    /**
     * Solicita los datos del super y del empleado
     */
    public void solicitarDatosGenerales() {
        nombreSuper = JOptionPane.showInputDialog("Nombre del super:");
        codigoSuper = JOptionPane.showInputDialog("Código del super:");
        nombreEmpleado = JOptionPane.showInputDialog("Nombre del empleado que realiza la carga:");
        cedulaEmpleado = JOptionPane.showInputDialog("Cédula del empleado:");
    }

    /**
     * Solicita el tipo de producto con un menú numérico
     * @return tipo de producto elegido
     */
    public TipoProducto solicitarTipo() {
        TipoProducto tipo = null;
        do {
            String lectura = JOptionPane.showInputDialog("Tipo de producto:\n1. Alimentos\n2. Bebidas\n3. Higiene\n4. Limpieza");
            int opcion = Integer.parseInt(lectura);
            if (opcion == 1) {
                tipo = TipoProducto.Alimentos;
            } else if (opcion == 2) {
                tipo = TipoProducto.Bebidas;
            } else if (opcion == 3) {
                tipo = TipoProducto.Higiene;
            } else if (opcion == 4) {
                tipo = TipoProducto.Limpieza;
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida, intente de nuevo");
            }
        } while (tipo == null);
        return tipo;
    }

    /**
     * Recorre el arreglo solicitando los datos de cada producto
     */
    public void solicitarProductos() {
        for (int i = 0; i < productos.length; i++) {
            JOptionPane.showMessageDialog(null, "Se solicitarán los datos del producto " + (i + 1));
            String codigo = JOptionPane.showInputDialog("Código del producto:");
            String nombre = JOptionPane.showInputDialog("Nombre del producto:");
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos a ingresar:"));
            double precioBase = Double.parseDouble(JOptionPane.showInputDialog("Precio base del producto:"));
            TipoProducto tipo = solicitarTipo();
            productos[i] = new Producto(codigo, nombre, cantidad, precioBase, tipo);
        }
    }

    /**
     * Muestra todos los productos agregados
     */
    public void mostrarProductos() {
        JOptionPane.showMessageDialog(null, "Super: " + nombreSuper + " (" + codigoSuper + ")"
                + "\nEmpleado: " + nombreEmpleado + " - Cédula: " + cedulaEmpleado);
        for (int i = 0; i < productos.length; i++) {
            JOptionPane.showMessageDialog(null, "Producto " + (i + 1) + "\n" + productos[i].mostrarInformacion());
        }
    }

    /**
     * Suma las ganancias esperadas de todos los productos
     * @return ganancia total esperada
     */
    public double calcularGananciaTotal() {
        double total = 0;
        for (int i = 0; i < productos.length; i++) {
            total = total + productos[i].calcularGananciaEsperada();
        }
        return total;
    }

    /**
     * Muestra la ganancia total esperada
     */
    public void mostrarGananciaTotal() {
        JOptionPane.showMessageDialog(null, "Ganancia total esperada: " + calcularGananciaTotal());
    }
}
