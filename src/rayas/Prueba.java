package rayas;

import java.io.IOException;

public class Prueba {

	public static void main(String[] args) throws NumberFormatException, IOException {
		TresEnRayas juego = new TresEnRayas('x', '0', true);
		char[][] tablero = new char [3][3];
		
		juego.llenarMatriz(tablero);
		do {
			juego.respuestaMatriz(tablero, juego.respuestaFila(), juego.respuestaColumna());
			juego.imprimir(tablero);
			juego.comprobarJ1(tablero);
			juego.comprobarJ2(tablero);
		} while (TresEnRayas.contador!=tablero.length*3 && !juego.comprobarJ1(tablero) && !juego.comprobarJ2(tablero));
		
		if(juego.comprobarJ1(tablero)) {
			System.out.println("¡ENHORABUENA! ha ganado el jugador 1");
		}else if (juego.comprobarJ2(tablero)) {
			System.out.println("¡ENHORABUENA! ha ganado el jugador 2");
		}else {
			System.out.println("¡EMPATE! Hay que mejorar ;)");
		}
	}

}
