package hotel.management;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class RegistroHuesped extends JFrame {
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNreserva;
	private JDateChooser txtFechaN;
	private JComboBox<String> txtNacionalidad;
	private JLabel labelExit;
	private JLabel labelAtras;
	int xMouse, yMouse;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHuesped frame = new RegistroHuesped();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RegistroHuesped() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);

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
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reservas reservas = new Reservas();
				reservas.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(new Color(12, 138, 199));
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setForeground(Color.WHITE);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JLabel lblRegistroDeHuesped = new JLabel("Registro de Huesped");
		lblRegistroDeHuesped.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeHuesped.setForeground(new Color(46, 139, 87));
		lblRegistroDeHuesped.setFont(new Font("Roboto", Font.BOLD, 30));
		lblRegistroDeHuesped.setBounds(0, 0, 910, 59);
		contentPane.add(lblRegistroDeHuesped);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNombre.setBounds(104, 111, 99, 25);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblApellido.setBounds(104, 165, 99, 25);
		contentPane.add(lblApellido);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblFechaDeNacimiento.setBounds(104, 219, 209, 25);
		contentPane.add(lblFechaDeNacimiento);

		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNacionalidad.setBounds(104, 273, 130, 25);
		contentPane.add(lblNacionalidad);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblTelefono.setBounds(104, 327, 99, 25);
		contentPane.add(lblTelefono);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtNombre.setBounds(314, 111, 350, 29);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtApellido.setColumns(10);
		txtApellido.setBounds(314, 165, 350, 29);
		contentPane.add(txtApellido);

		txtFechaN = new JDateChooser();
		txtFechaN.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtFechaN.setBounds(314, 219, 350, 29);
		contentPane.add(txtFechaN);

		txtNacionalidad = new JComboBox<String>();
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtNacionalidad.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Argentina", "Brasil", "Chile", "Colombia", "Peru", "Uruguay" }));
		txtNacionalidad.setBounds(314, 273, 350, 29);
		contentPane.add(txtNacionalidad);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(314, 327, 350, 29);
		contentPane.add(txtTelefono);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(64, 64, 64));
		separator.setBounds(104, 456, 799, 12);
		contentPane.add(separator);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText().trim();
				String apellido = txtApellido.getText().trim();
				String telefono = txtTelefono.getText().trim();
				String nacionalidad = txtNacionalidad.getSelectedItem().toString();
				Format formatter = new SimpleDateFormat("yyyy-MM-dd");
				String fechaNacimiento = formatter.format(txtFechaN.getDate());

				if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || fechaNacimiento.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
				} else {
					// Aquí va el código para guardar los datos del huésped en la base de datos
					JOptionPane.showMessageDialog(null, "Huésped registrado exitosamente");
					limpiarCampos();
				}
			}
		});
		btnGuardar.setFont(new Font("Roboto", Font.BOLD, 18));
		btnGuardar.setBackground(new Color(46, 139, 87));
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBounds(314, 502, 130, 36);
		contentPane.add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnCancelar.setFont(new Font("Roboto", Font.BOLD, 18));
		btnCancelar.setBackground(new Color(255, 99, 71));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBounds(534, 502, 130, 36);
		contentPane.add(btnCancelar);

		JLabel lblNreserva = new JLabel("N° Reserva:");
		lblNreserva.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNreserva.setBounds(104, 70, 130, 25);
		contentPane.add(lblNreserva);

		txtNreserva = new JTextField();
		txtNreserva.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtNreserva.setBounds(314, 70, 350, 29);
		contentPane.add(txtNreserva);
		txtNreserva.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeroReserva = txtNreserva.getText().trim();

				if (numeroReserva.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el número de reserva");
				} else {
					// Aquí va el código para buscar la reserva en la base de datos
					// y completar los campos con los datos del huésped

					// Ejemplo:
					txtNombre.setText("Juan");
					txtApellido.setText("Perez");
					txtTelefono.setText("123456789");
					txtNacionalidad.setSelectedItem("Argentina");

					// Establecer la fecha de nacimiento usando un objeto Date
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date fecha = null;
					try {
						fecha = formatter.parse("1990-01-01");
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
					txtFechaN.setDate(fecha);
				}
			}
		});
		btnBuscar.setFont(new Font("Roboto", Font.BOLD, 18));
		btnBuscar.setBackground(new Color(0, 123, 255));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBounds(674, 70, 130, 29);
		contentPane.add(btnBuscar);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelExit.setBounds(874, 0, 36, 36);
		header.add(labelExit);
	}

	private void limpiarCampos() {
		txtNreserva.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtNacionalidad.setSelectedIndex(0);
		txtFechaN.setDate(null);
	}

	private void headerMouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

	private void headerMousePressed(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
	}
	
	void registrarHuesped() {
	    String nombre = txtNombre.getText().trim();
	    String apellido = txtApellido.getText().trim();
	    String telefono = txtTelefono.getText().trim();
	    String nacionalidad = txtNacionalidad.getSelectedItem().toString();
	    Format formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String fechaNacimiento = formatter.format(txtFechaN.getDate());

	    if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || fechaNacimiento.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
	    } else {
	        
	        JOptionPane.showMessageDialog(null, "Huésped registrado exitosamente");
	        limpiarCampos();
	    }
	}
}
