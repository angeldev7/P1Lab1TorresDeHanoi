package logicarecursividad;
import interfaz.TorresDeHanoiPanel;
public class TorresDeHanoi {
private TorresDeHanoiPanel panel;

public TorresDeHanoi(TorresDeHanoiPanel panel) {
	this.panel=panel;}
public void resolver(int numDiscos, int origen, int auxiliar,int destino, int delay) {
	if(numDiscos>0) {
		//Paso 1: Mover todos los discos menos el ultimo del origen al auxiliar
		resolver (numDiscos-1, origen, destino, auxiliar, delay);
		//Paso 2: Mover el disco mas grande del origen al destino
		panel.moverDisco(origen, destino);
		try {
			Thread.sleep (delay);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		//Paso 3: Mover los discos en auxiliar al destino
		resolver (numDiscos-1, auxiliar, origen, destino, delay);
	}
}
}
