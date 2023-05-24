package producto;

import java.util.Scanner;
import java.util.TreeSet;

public class PrincipalProducto {

    public static void main(String[] args) {

        //Declaramos la colección, en este caso un TreeSet de objetos Producto y le asignamos el valor devuelto por el método leerFichero()
        TreeSet<Producto> productos = FicheroProducto.leerFichero();

        //Declaramos el resto de variables que vamos a necesitar
        Producto p;     //Variable donde almacenaremos el producto
        int opc;        //Variable donde almacenaremos la opción que elija el usuario
        String nombre;  //Variable donde almacenaremos el nombre del producto
        double precio;  //Variable donde almacenaremos el precio del producto

        //Creamos el objeto Scanner para leer por teclado
        Scanner sc = new Scanner(System.in);

        //Mientras que la opción elegida sea diferente de 0 (salir)
        do {
            //Mostramos el menú y leemos la opción elegida por el usuario
            menu();
            opc = sc.nextInt();
            sc.nextLine();

            //Según la opción elegida por el usuario
            switch (opc) {
                case 1 -> {// Dar de alta el producto
                    //Le pedimos al usuario los datos del producto
                    System.out.println("Introduzca el nombre del producto:");
                    nombre = sc.nextLine();
                    System.out.println("Introduzca el precio del producto:");
                    precio = sc.nextDouble();
                    sc.nextLine();
                    //Creamos el objeto Producto con los datos introducidos por el usuario
                    p = new Producto(nombre, precio);

                    //Si el producto no existe en la colección lo añadimos, en caso contrario mostramos un mensaje de error
                    if (productos.add(p)) {
                        System.out.println("Añadido correctamente");
                    } else {
                        System.out.println("El producto ya existe");
                    }
                }
                case 2 -> {// Baja de producto
                    //Le pedimos al usuario el nombre del producto
                    System.out.println("Introduzca el nombre del producto:");
                    nombre = sc.nextLine();
                    //Creamos el objeto Producto con el nombre introducido por el usuario
                    p = new Producto(nombre);
                    //Si el producto existe en la colección lo eliminamos, en caso contrario mostramos un mensaje de error
                    if (productos.remove(p)) {
                        System.out.println("Eliminado exitosamente");
                    } else {
                        System.out.println("El producto no existe");
                    }
                }
                case 3 -> { // Listar
                    //Recorremos la colección y mostramos los productos
                    for (Producto prod : productos) {
                        System.out.println(prod);
                        System.out.println();
                    }
                }
                case 4 -> { // Guardar
                    //Llamamos al método escribirFichero() para guardar los productos en el fichero
                    FicheroProducto.escribirFichero(productos);
                }
                case 0 -> // Salir
                        System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida");
            }

        } while (opc != 0);

        //Cerramos el objeto Scanner
        sc.close();
    }

    /**
     * Método que muestra el menú por pantalla
     */
    private static void menu() {
        System.out.println("Seleccione una opción");
        System.out.println("1. Alta producto");
        System.out.println("2. Baja producto");
        System.out.println("3. Listar existencias");
        System.out.println("4. Guardar");
        System.out.println("0. Salir");
    }
}