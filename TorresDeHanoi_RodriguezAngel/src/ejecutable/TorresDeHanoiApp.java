package ejecutable;
import interfaz.TorresDeHanoiPanel;
import logicarecursividad.TorresDeHanoi;
import javax.swing.*;
import java.awt.*;
public class TorresDeHanoiApp {
	public static void main(String[] args) {
		TorresDeHanoiPanel panel = new TorresDeHanoiPanel(3);
		JFrame frame=new JFrame("Torres de Hanoi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		JPanel controlPanel = new JPanel();
		JLabel label = new JLabel("Numero de Discos:");
		JTextField numDiscosField = new JTextField(5);
		JButton startButton = new JButton("Iniciar");
		JButton resetButton = new JButton("Reiniciar");
		
		JLabel velocidadLabel = new JLabel("Velocidad:");
		JSlider velocidadSlider = new JSlider(1, 10, 5);
		
		controlPanel.add(label);
		controlPanel.add(numDiscosField);
		controlPanel.add(velocidadLabel);
		controlPanel.add(velocidadSlider);
		controlPanel.add(startButton);
		controlPanel.add(resetButton);
		
		frame.add(controlPanel, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		startButton.addActionListener(e ->{
			try {
				int numDiscos = Integer.parseInt (numDiscosField.getText());
				panel.reiniciar(numDiscos);
				
				TorresDeHanoi hanoi = new TorresDeHanoi(panel);
				int delay= 1000 / velocidadSlider.getValue();
				new Thread(() -> hanoi.resolver(numDiscos, 0, 1, 2, delay)).start();
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(frame, "Por favor ingrese un numero valido de discos.", "Entrada invalida", JOptionPane.ERROR_MESSAGE);
			}
		});
		resetButton.addActionListener (e -> {
			int numDiscos = Integer.parseInt(numDiscosField.getText());
			panel.reiniciar(numDiscos);
		});	
	}
}
