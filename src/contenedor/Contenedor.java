package contenedor;

public class Contenedor <Objeto>{
    private Objeto objeto;

    // Constructor
    public Contenedor() {
    }

    //Metodo guardar
    void guardar(Objeto nuevo) {
        objeto = nuevo;
    }

    //Metodo extraer
    Objeto extraer() {
        Objeto res = objeto;
        objeto = null; // el contenedor vuelve a estar vacío
        return res;
    }

    //Metodo toString
    @Override
    public String toString() {
        return objeto.toString();
    }
}
