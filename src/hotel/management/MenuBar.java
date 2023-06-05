package hotel.management;

import javax.swing.JPanel;

import hotel.management.MenuPrincipal;
import hotel.management.RegistroHuesped;
import hotel.management.Reservas;

public class MenuBar {
        
        public void mostrarMenuBar() {
              
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.mostrarMenuPrincipal(null);
            
            RegistroHuesped registroHuesped = new RegistroHuesped();
            registroHuesped.registrarHuesped();
        }
}
