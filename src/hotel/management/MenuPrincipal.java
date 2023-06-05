package hotel.management;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import hotel.management.Login;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {
    private JPanel contentPane;
    private JLabel labelExit;
    int xMouse, yMouse;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MenuPrincipal() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/imagenes/aH-40px.png")));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 910, 537);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.window);
        panel.setBounds(0, 0, 910, 537);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel imagenFondo = new JLabel("");
        imagenFondo.setBounds(-50, 0, 732, 501);
        imagenFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/menu-img.png")));
        panel.add(imagenFondo);

        JLabel logo = new JLabel("");
        logo.setBounds(722, 80, 150, 156);
        logo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/aH-150px.png")));
        panel.add(logo);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 500, 910, 37);
        panel_1.setBackground(new Color(12, 138, 199));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblCopyR = new JLabel("Desarrollado por Fulanita de Tal © 2023");
        lblCopyR.setBounds(315, 11, 284, 19);
        lblCopyR.setForeground(new Color(240, 248, 255));
        lblCopyR.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel_1.add(lblCopyR);

        // Barra para controlar la ventana
        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);

            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        panel.add(header);

        // Botón salir
        JPanel btnExit = new JPanel();
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnExit.setBackground(Color.RED);
                labelExit.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnExit.setBackground(Color.WHITE);
                labelExit.setForeground(Color.BLACK);
            }
        });
        btnExit.setLayout(null);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setBackground(Color.WHITE);
        btnExit.setBounds(857, 0, 53, 36);
        header.add(btnExit);

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnExit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

        // Botón Login
        JPanel btnLogin = new JPanel();
        btnLogin.setBounds(754, 300, 83, 70);
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
        btnLogin.setLayout(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setBackground(SystemColor.window);
        panel.add(btnLogin);

        JLabel imagenLogin = new JLabel("");
        imagenLogin.setBounds(0, 0, 80, 70);
        btnLogin.add(imagenLogin);
        imagenLogin.setHorizontalAlignment(SwingConstants.CENTER);
        imagenLogin.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/login.png")));

        JLabel lblTitulo = new JLabel("LOGIN");
        lblTitulo.setBounds(754, 265, 83, 24);
        lblTitulo.setBackground(SystemColor.window);
        panel.add(lblTitulo);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(SystemColor.textHighlight);
        lblTitulo.setFont(new Font("Roboto Light", Font.PLAIN, 20));

        // Mostrar el menú principal
        mostrarMenuPrincipal(panel);
    }

    // Código que permite mover la ventana por la pantalla siguiendo la posición de
    // "x" y "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

    void mostrarMenuPrincipal(JPanel panel) {
        // Crear un nuevo JPanel para el menú principal
        JPanel panelMenuPrincipal = new JPanel();
        panelMenuPrincipal.setBounds(50, 50, 200, 300);
        panelMenuPrincipal.setBackground(Color.WHITE);
        panel.add(panelMenuPrincipal);

        // Crear y configurar los componentes del menú principal
        JLabel lblMenuPrincipal = new JLabel("Menú Principal");
        lblMenuPrincipal.setBounds(0, 0, 200, 30);
        lblMenuPrincipal.setFont(new Font("Roboto", Font.BOLD, 18));
        panelMenuPrincipal.add(lblMenuPrincipal);

    }
}

