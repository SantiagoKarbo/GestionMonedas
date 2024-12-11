import java.util.ArrayList;
import java.util.Scanner;

class Moneda {
    //Declaración de los atributos en privado para acceder a ellos mediante getters
    private String pais;
    private String denominacion;
    private int anoEmision;
    //Creción del objeto moneda con los parametros declarados anteriormente
    public Moneda(String pais, String denominacion, int anoEmision) {
        this.pais = pais;
        this.denominacion = denominacion;
        this.anoEmision = anoEmision;
    }
    //
    public String getPais() {
        return pais;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public int getAnoEmision() {
        return anoEmision;
    }

    @Override
    public String toString() {
        return "País: " + pais + ", Denominación: " + denominacion + ", Año de emisión: " + anoEmision;
    }
}

public class GestionMonedas {
    private ArrayList<Moneda> monedas;

    public GestionMonedas() {
        monedas = new ArrayList<>();
    }

    public void agregarMoneda(String pais, String denominacion, int anoEmision) {
        Moneda nuevaMoneda = new Moneda(pais, denominacion, anoEmision);
        monedas.add(nuevaMoneda);
        System.out.println("Moneda agregada: " + nuevaMoneda);
    }

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

    public void eliminarMoneda(String pais) {
        boolean encontrado = false;
        for (Moneda moneda : monedas) {
            if (moneda.getPais().equalsIgnoreCase(pais)) {
                monedas.remove(moneda);
                System.out.println("Moneda eliminada: " + moneda);
                encontrado = true;
                break;
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
                    System.out.print("Ingrese el país de la moneda a eliminar: ");
                    String paisEliminar = scanner.nextLine();
                    gestionMonedas.eliminarMoneda(paisEliminar);
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