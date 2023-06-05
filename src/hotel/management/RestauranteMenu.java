package hotel.management;

import hotel.management.Busqueda;
import hotel.management.Menu;
import hotel.management.MenuUsuario;

public class RestauranteMenu {
    
    public void mostrarRestauranteMenu() {
 
        Busqueda busqueda = new Busqueda();
        busqueda.realizarBusqueda();
        
        Menu menu = new Menu();
        menu.mostrarMenu();
        
        MenuUsuario menuUsuario = new MenuUsuario();
        menuUsuario.mostrarMenuUsuario();
        
        Reservas reservas = new Reservas();
        reservas.fechaSalidaSeleccionada();
    }
}
