package hotel.management;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Exito extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static final int DIALOG_WIDTH = 394;
	private static final int DIALOG_HEIGHT = 226;
	private static final String DIALOG_TITLE = "Éxito";

	public static void main(String[] args) {
		try {
			Exito dialog = new Exito();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Exito() {
		setBounds(100, 100, DIALOG_WIDTH, DIALOG_HEIGHT);
		setTitle(DIALOG_TITLE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel successIcon = new JLabel("");
		successIcon.setIcon(new ImageIcon(Exito.class.getResource("/imagenes/Ha-100px.png")));
		successIcon.setBounds(123, 11, 100, 100);
		contentPanel.add(successIcon);

		JLabel successLabel = new JLabel("Datos guardados satisfactoriamente");
		successLabel.setFont(new Font("Arial", Font.BOLD, 18));
		successLabel.setBounds(27, 122, 322, 21);
		contentPanel.add(successLabel);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
}
