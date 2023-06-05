package hotel.management;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Menu extends JFrame {

    public static void main(String[] args) {
        Menu frame = new Menu();
        frame.setVisible(true);
    }

    public Menu() {
        super("Menú");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 450, 300);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblMenu = new JLabel("MENÚ");
        lblMenu.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
        lblMenu.setBounds(152, 46, 146, 29);
        panel.add(lblMenu);

        JButton btnReservas = new JButton("Reservas");
        btnReservas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Reservas reservas = new Reservas();
                reservas.setVisible(true);
            }
        });
        btnReservas.setFont(new Font("Roboto", Font.PLAIN, 14));
        btnReservas.setBounds(152, 98, 146, 41);
        panel.add(btnReservas);

        JButton btnHabitaciones = new JButton("Habitaciones");
        btnHabitaciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnHabitaciones.setFont(new Font("Roboto", Font.PLAIN, 14));
        btnHabitaciones.setBounds(152, 150, 146, 41);
        panel.add(btnHabitaciones);

        JButton btnClientes = new JButton("Clientes");
        btnClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnClientes.setFont(new Font("Roboto", Font.PLAIN, 14));
        btnClientes.setBounds(152, 202, 146, 41);
        panel.add(btnClientes);

        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/aH-150px.png")));
        lblLogo.setBounds(35, 46, 107, 150);
        panel.add(lblLogo);
    }
    
    public void mostrarMenu() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

