import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase que representa una moneda con atributos como el país de origen,
 * su denominación y el año de emisión.
 */
class Moneda {
    // Declaración de los atributos privados para asegurar la encapsulación
    private String pais;
    private String denominacion;
    private int anoEmision;
     /**
     * Constructor para crear una instancia del objeto Moneda.
     *
     * @param pais el país de origen de la moneda.
     * @param denominacion la denominación de la moneda (por ejemplo, "1 peso", "1 dólar").
     * @param anoEmision el año en que fue emitida la moneda.
     */
    public Moneda(String pais, String denominacion, int anoEmision) {
        this.pais = pais;
        this.denominacion = denominacion;
        this.anoEmision = anoEmision;
    }
     /**
     * Obtiene el país de origen de la moneda.
     *
     * @return el país de origen como una cadena de texto.
     */
    public String getPais() {
        return pais;
    }
    /**
     * Obtiene la denominación de la moneda.
     *
     * @return la denominación de la moneda como una cadena de texto.
     */
    public String getDenominacion() {
        return denominacion;
    }
    /**
     * Obtiene el año de emisión de la moneda.
     *
     * @return el año de emisión como un entero.
     */
    public int getAnoEmision() {
        return anoEmision;
    }

    @Override
    public String toString() {
        return "País: " + pais + ", Denominación: " + denominacion + ", Año de emisión: " + anoEmision;
    }
}
/**
 * Clase que gestiona una colección de monedas. Permite agregar, mostrar y eliminar monedas.
 */
public class GestionMonedas {
    private ArrayList<Moneda> monedas;
     /**
     * Constructor que inicializa la lista de monedas.
     */
    public GestionMonedas() {
        monedas = new ArrayList<>();
    }

    public void agregarMoneda(String pais, String denominacion, int anoEmision) {
        Moneda nuevaMoneda = new Moneda(pais, denominacion, anoEmision);
        monedas.add(nuevaMoneda);
        System.out.println("Moneda agregada: " + nuevaMoneda);
    }
    /**
     * Muestra todas las monedas en la colección.
     * Si la lista está vacía, informa al usuario.
     */
    public void mostrarMonedas() {
        if (monedas.isEmpty()) {
            System.out.println("La lista de monedas está vacía.");
        } else {
            System.out.println("Lista de monedas:");
            for (Moneda moneda : monedas) {
                System.out.println(moneda);
            }
        }
    }

    public void eliminarMoneda(String pais, String denominacion, int anoEmision) {
        boolean encontrado = false;
        for (Moneda moneda : monedas) {
            if (moneda.getPais().equalsIgnoreCase(pais)&&moneda.getDenominacion().equalsIgnoreCase(denominacion)&& moneda.getAnoEmision()==anoEmision) {
                monedas.remove(moneda);
                System.out.println("Moneda eliminada: " + moneda);
                encontrado = true;
                //break; (El break ya no hace falta al pedir los tres parámetros para eliminar la moneda, antes servía para no eliminar todas las monedas y salir del bucle for
            }
        }
        if (!encontrado) {
            System.out.println("Moneda no encontrada.");
        }
    }
    
    public static void main(String[] args) {
        GestionMonedas gestionMonedas = new GestionMonedas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar moneda");
            System.out.println("2. Mostrar monedas");
            System.out.println("3. Eliminar moneda");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1: 
                    // parametros para añadir la moneda
                    System.out.print("Ingrese el país de la moneda: ");
                    String pais = scanner.nextLine();
                    System.out.print("Ingrese la denominación de la moneda: ");
                    String denominacion = scanner.nextLine();
                    System.out.print("Ingrese el año de emisión de la moneda: ");
                    int ano = scanner.nextInt();
                    gestionMonedas.agregarMoneda(pais, denominacion, ano);
                    break;
                case 2:
                    gestionMonedas.mostrarMonedas();
                    break;
                case 3:
                    //pedir los parametros para eliminar la moneda
                    System.out.print("Ingrese el país de la moneda a eliminar: ");
                    String paisEliminar = scanner.nextLine();
                    System.out.print("Ingrese la denominacion de la moneda a eliminar: ");
                    String denoEliminar = scanner.nextLine();
                    System.out.print("Ingrese el año de la moneda a eliminar: ");
                    int anoEliminar = scanner.nextInt();
                    gestionMonedas.eliminarMoneda(paisEliminar,denoEliminar,anoEliminar);
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}