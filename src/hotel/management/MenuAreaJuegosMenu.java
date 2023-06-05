package hotel.management;

import java.util.Scanner;

public class MenuAreaJuegosMenu {

	public void mostrarMenu() {
        System.out.println("Bienvenido al Menú Principal");
        System.out.println("---------------------------");
        System.out.println("1. Mostrar Área de Juegos");
        System.out.println("2. Realizar Reserva");
        System.out.println("3. Salir");
        System.out.println();

        int opcion = obtenerOpcion();

        switch (opcion) {
            case 1:
                AreaJuegosMenu areaJuegosMenu = new AreaJuegosMenu();
                areaJuegosMenu.mostrarAreaJuegos();
                break;
            case 2:
                Reservas reservas = new Reservas();
                reservas.fechaSalidaSeleccionada();
                break;
            case 3:
                System.out.println("Gracias por visitarnos. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                mostrarMenu();
                break;
        }
    }

    public int obtenerOpcion() {
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        return opcion;
    }
}
