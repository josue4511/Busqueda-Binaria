import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese cantidad de Personas del listado: ");
        int n = sc.nextInt();
        sc.nextLine();

        Persona[] personas = new Persona[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese Persona:");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            int edad;
            do {
                System.out.print("Edad: ");
                edad = sc.nextInt();
                sc.nextLine();
                if (edad < 0) System.out.println("La edad no puede ser negativa.");
            } while (edad < 0);

            personas[i] = new Persona(nombre, edad);
        }

        // Ordenar
        Arrays.sort(personas);

        System.out.print("Valor la persona de la edad: ");
        int edadBuscar = sc.nextInt();

        int pos = busquedaBinariaMostrando(personas, edadBuscar);

        if (pos != -1) {
            System.out.println("La persona con la edad " + edadBuscar + " es " + personas[pos].getNombre());
        } else {
            System.out.println("No existe persona con esa edad.");
        }

        sc.close();
    }

    public static int busquedaBinariaMostrando(Persona[] arr, int edadBuscar) {
        int bajo = 0;
        int alto = arr.length - 1;

        while (bajo <= alto) {

            // Imprimir subarreglo EXACTO como el ejemplo
            for (int i = bajo; i <= alto; i++) {
                System.out.print(arr[i].getEdad() + " | ");
            }
            System.out.println();

            int centro = (bajo + alto) / 2;
            int valorCentro = arr[centro].getEdad();

            System.out.print("bajo=" + bajo + " ");
            System.out.print("alto=" + alto + " ");
            System.out.print("centro=" + centro + " ");
            System.out.print("valorCentro=" + valorCentro);

            if (valorCentro == edadBuscar) {
                System.out.println(" --> ENCONTRADO");
                return centro;
            }

            if (edadBuscar > valorCentro) {
                System.out.println(" --> DERECHA");
                bajo = centro + 1;
            } else {
                System.out.println(" --> IZQUIERDA");
                alto = centro - 1;
            }
        }

        return -1;
    }
}
