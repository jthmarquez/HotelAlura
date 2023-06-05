package hotel.management;

public class PaseoExcursionesMenu {
  
    public void mostrarPaseosExcursiones() {
 
        Menu menu = new Menu();
        menu.mostrarMenu();
        
        Reservas reservas = new Reservas();
        reservas.fechaSalidaSeleccionada();
    }
}
