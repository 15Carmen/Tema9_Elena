package producto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;
import java.util.TreeSet;

public class FicheroProducto {

    /**
     * Método que lee el fichero productos.txt y almacena en un TreeSet los datos que ha leído
     * @return TreeSet con los datos leídos del fichero
     */
    public static TreeSet<Producto> leerFichero() {

        //Declaramos la colección donde almacenaremos los productos
        TreeSet<Producto> productosLeidos = new TreeSet<>();

        //Declaramos el resto de variables que vamos a necesitar
        Producto p;     //Variable donde almacenaremos el producto
        String nombre;  //Variable donde almacenaremos el nombre del producto
        double precio;  //Variable donde almacenaremos el precio del producto
        String[] datos; //Array donde almacenaremos los datos de cada línea del fichero

        //Declaramos el objeto BufferedReader para leer el fichero
        BufferedReader br = null;
        try {
            //Inicializamos el objeto BufferedReader con el fichero productos.txt
            br = new BufferedReader(new FileReader("src/producto/productos.txt"));
            //Leemos la primera línea del fichero
            String linea = br.readLine();

            //Mientras que la línea no sea nula
            while (linea != null) {
                //Separamos los datos de la línea por el espacio en blanco
                datos = linea.split(" ");

                //Asignamos los datos a las variables
                nombre = datos[0];
                precio = Double.parseDouble(datos[1]); // Devuelve double, tipo primitivo

                //Creamos el objeto Producto con los datos leídos del fichero
                p = new Producto(nombre, precio);
                //Añadimos el producto a la colección
                productosLeidos.add(p);

                //Leemos la siguiente línea del fichero
                linea = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR al abrir el fichero");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR al leer el fichero");
            System.out.println(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("ERROR al cerrar el búfer");
                    System.out.println(e.getMessage());
                }
            }
        }

        return productosLeidos;

    }

    /**
     * Método que escribe en el fichero productos.txt los datos que le pasamos por parámetro
     * @param productosEscritos TreeSet con los datos que queremos escribir en el fichero
     */
    public static void escribirFichero(TreeSet<Producto> productosEscritos) {
        //Declaramos las variables que vamos a necesitar
        String nombre;  //Variable donde almacenaremos el nombre del producto
        double precio;  //Variable donde almacenaremos el precio del producto

        //Declaramos el objeto BufferedWriter para escribir en el fichero
        BufferedWriter bw = null;
        try {
            //Inicializamos el objeto BufferedWriter con el fichero productos.txt
            bw = new BufferedWriter(new FileWriter("src/producto/productos.txt"));

            //Recorremos el TreeSet con los productos que queremos escribir en el fichero
            for(Producto p : productosEscritos) {
                //Asignamos los datos de cada producto a las variables
                nombre = p.getNombre();
                precio = p.getPrecio();

                //Escribimos en el fichero los datos del producto
                bw.write(nombre + " " + precio);
                //Escribimos un salto de línea
                bw.newLine();
            }
            //Limpiamos el búfer
            bw.flush();

        } catch (IOException e) {
            System.out.println("Error al abrir el fichero");
            System.out.println(e.getMessage());
        } finally {
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el búfer");
                    System.out.println(e.getMessage());
                }
            }
        }
    }


}
