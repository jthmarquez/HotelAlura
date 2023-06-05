package hotel.management;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class Reservas extends JFrame {
    private JPanel contentPane;
    public static JTextField txtValor;
    public static JDateChooser txtFechaEntrada;
    public static JDateChooser txtFechaSalida;
    public static JDateChooser txtfechaEntradaSeleccionada;
    public static JDateChooser fechaSalidaSeleccionada;
    public static JComboBox<String> txtFormaPago;
    int xMouse, yMouse;
    private JLabel labelExit;
    private JLabel labelAtras;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reservas frame = new Reservas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Reservas() {
        super("Reserva");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Reservas.class.getResource("/imagenes/aH-40px.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 560);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.control);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 910, 560);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
        lblCheckIn.setForeground(SystemColor.textInactiveText);
        lblCheckIn.setBounds(68, 136, 169, 14);
        lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblCheckIn);

        JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
        lblCheckOut.setForeground(SystemColor.textInactiveText);
        lblCheckOut.setBounds(68, 207, 189, 14);
        lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblCheckOut);

        JLabel lblFormaDePago = new JLabel("FORMA DE PAGO");
        lblFormaDePago.setForeground(SystemColor.textInactiveText);
        lblFormaDePago.setBounds(68, 373, 189, 14);
        lblFormaDePago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblFormaDePago);

        txtFechaEntrada = new JDateChooser();
        txtFechaEntrada.setBounds(68, 161, 289, 29);
        txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 14));
        panel.add(txtFechaEntrada);

        txtFechaSalida = new JDateChooser();
        txtFechaSalida.setBounds(68, 232, 289, 29);
        txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 14));
        panel.add(txtFechaSalida);

        txtFormaPago = new JComboBox<String>();
        txtFormaPago.setModel(new DefaultComboBoxModel<String>(new String[] { "Tarjeta de crédito", "Efectivo" }));
        txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 14));
        txtFormaPago.setBounds(68, 398, 289, 29);
        panel.add(txtFormaPago);

        JLabel lblReserva = new JLabel("RESERVACIÓN");
        lblReserva.setForeground(SystemColor.textInactiveText);
        lblReserva.setFont(new Font("Roboto Black", Font.BOLD, 40));
        lblReserva.setBounds(68, 29, 310, 41);
        panel.add(lblReserva);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setForeground(SystemColor.textInactiveText);
        lblPrecio.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblPrecio.setBounds(68, 303, 54, 14);
        panel.add(lblPrecio);

        txtValor = new JTextField();
        txtValor.setBorder(new LineBorder(Color.LIGHT_GRAY));
        txtValor.setEditable(false);
        txtValor.setFont(new Font("Roboto", Font.PLAIN, 14));
        txtValor.setBounds(68, 328, 289, 29);
        panel.add(txtValor);
        txtValor.setColumns(10);

        JLabel lblIconoDinero = new JLabel("");
        lblIconoDinero.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/icons8-us-dollar-40.png")));
        lblIconoDinero.setBounds(23, 328, 46, 29);
        panel.add(lblIconoDinero);

        labelExit = new JLabel("");
        labelExit.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/icons8-delete-25.png")));
        labelExit.setBounds(875, 0, 35, 41);
        panel.add(labelExit);
        labelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });

        labelAtras = new JLabel("");
        labelAtras.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/icons8-chevron-left-25.png")));
        labelAtras.setBounds(0, 0, 35, 41);
        panel.add(labelAtras);
        labelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setVisible(false);
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });

        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/fondoHotel.jpg")));
        lblFondo.setBounds(0, 0, 910, 560);
        panel.add(lblFondo);

        DragListener dragListener = new DragListener();
        panel.addMouseListener(dragListener);
        panel.addMouseMotionListener(dragListener);
        
        
        fechaSalidaSeleccionada();
        
    }
    
    public void fechaSalidaSeleccionada() {
        // Obtener la fecha de entrada y salida seleccionadas
        Date fechaEntradaSeleccionada = txtFechaEntrada.getDate();
        Date fechaSalidaSeleccionada = txtFechaSalida.getDate();

        // Validar que se hayan seleccionado fechas válidas
        if (fechaEntradaSeleccionada == null || fechaSalidaSeleccionada == null || fechaEntradaSeleccionada.after(fechaSalidaSeleccionada)) {
            // Mostrar mensaje de error o realizar alguna acción apropiada
            System.out.println("Fechas de entrada y salida inválidas");
            return;
        }

        // Calcular la duración de la estancia en días
        long duracionEstanciaMillis = fechaSalidaSeleccionada.getTime() - fechaEntradaSeleccionada.getTime();
        int duracionEstanciaDias = (int) (duracionEstanciaMillis / (24 * 60 * 60 * 1000));

        // Realizar cálculos adicionales y lógica de reserva según sea necesario

        // Ejemplo: Calcular el precio de la reserva
        double precioPorDia = 100.0; // Precio por día
        double precioTotal = precioPorDia * duracionEstanciaDias;

        // Establecer el valor en el campo de texto correspondiente
        txtValor.setText(String.valueOf(precioTotal));

        // Ejemplo: Mostrar los menús correspondientes
        AreaJuegosMenu areaJuegosMenu = new AreaJuegosMenu();
        areaJuegosMenu.mostrarAreaJuegos();

        Menu menu = new Menu();
        menu.mostrarMenu();

        PaseoExcursionesMenu paseoExcursionesMenu = new PaseoExcursionesMenu();
        paseoExcursionesMenu.mostrarPaseosExcursiones();

        RestauranteMenu restauranteMenu = new RestauranteMenu();
        restauranteMenu.mostrarRestauranteMenu();

        SpaMenu spaMenu = new SpaMenu();
        spaMenu.mostrarSpaMenu();

        MenuBar menuBar = new MenuBar();
        menuBar.mostrarMenuBar();
    }



}
