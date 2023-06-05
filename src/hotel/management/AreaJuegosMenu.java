package hotel.management;

import hotel.management.Reservas;
import java.util.Scanner;

public class AreaJuegosMenu {

	  private String nombreJuego;
	    private int cantidadJugadores;

	    public void juegoAccion() {
	        System.out.println("Estás jugando al juego de acción.");
	    }

	    public void juegoEstrategia() {
	        System.out.println("Estás jugando al juego de estrategia.");
	    }

	    public void juegoAventura() {
	        System.out.println("Estás jugando al juego de aventura.");
	    }

	    public void mostrarAreaJuegos() {
	        System.out.println("Bienvenido al Área de Juegos");
	        System.out.println("----------------------------");
	        System.out.println("1. Juego de Acción");
	        System.out.println("2. Juego de Estrategia");
	        System.out.println("3. Juego de Aventura");
	        System.out.println("4. Volver al menú principal");
	        System.out.println();

	        Scanner scanner = new Scanner(System.in);
	        int opcion = scanner.nextInt();

	        switch (opcion) {
	            case 1:
	                juegoAccion();
	                break;
	            case 2:
	                juegoEstrategia();
	                break;
	            case 3:
	                juegoAventura();
	                break;
	            case 4:
	                Menu menuPrincipal = new Menu();
	                menuPrincipal.mostrarMenu();
	                break;
	            default:
	                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
	                mostrarAreaJuegos();
	                break;
	        }

	        Reservas reservas = new Reservas();
	        reservas.fechaSalidaSeleccionada();
	    }

	    public void realizarReservas() {
	        System.out.println("Se ha realizado la reserva en el área de juegos.");
	    }
	}

