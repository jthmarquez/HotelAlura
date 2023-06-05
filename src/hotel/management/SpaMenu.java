package hotel.management;

public class SpaMenu {
    
    public void mostrarSpaMenu() {
  
        Menu menu = new Menu();
        menu.mostrarMenu();
        
        Reservas reservas = new Reservas();
        reservas.fechaSalidaSeleccionada();
    }
}
