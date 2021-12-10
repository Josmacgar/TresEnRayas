package rayas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import tools.Tools;

public class TresEnRayas {
	Tools tools = new Tools();
	//atributos
	private char j1;
	private char j2;
	private final char vacio='-';
	private boolean turno;
	public static int contador=0;
	
	//constructor
	public TresEnRayas(char j1, char j2, boolean turno) {
		this.j1 = j1;
		this.j2 = j2;
		this.turno = turno;
	}
	
	//getters and setters

	public char getJ1() {
		return j1;
	}

	public void setJ1(char j1) {
		this.j1 = j1;
	}

	public char getJ2() {
		return j2;
	}

	public void setJ2(char j2) {
		this.j2 = j2;
	}

	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	//toString
	@Override
	public String toString() {
		return "TresEnRayas [j1=" + j1 + ", j2=" + j2 + ", turno=" + turno + "]";
	}
	
	//metodo que rellena la matriz
	public void llenarMatriz(char[][] matriz) {
		 for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j]=vacio;
			}
		}
	}
	
	//metodo para imprimir la matriz
	public void imprimir(char[][] matriz) {
		 for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
	}
	
	//metodo para pedir respuesta al usuario
	public char respuestaFila() throws NumberFormatException, IOException {
		int respuesta=0;	
		
		if(turno) {
			System.out.println("Le toca al J1");
		}else {
			System.out.println("Le toca al J2");
		}
		System.out.println();
		do {
			System.out.println("Introduzca la fila");
			 respuesta =tools.controlarEntero();
		} while (respuesta<1 || respuesta>3);

		
		//esto se hace para que sea 1, 2 0 3 en vez de 0 ,1 o 2
		respuesta--;
		return (char)respuesta;
	}
	
	//metodo para pedir respuesta al usuario
	public char respuestaColumna() throws NumberFormatException, IOException {
		int respuesta=0;
		do {
			System.out.println("Introduzca la columna");
			 respuesta =tools.controlarEntero();
		} while (respuesta<1 || respuesta>3);
		
		//esto se hace para que sea 1, 2 0 3 en vez de 0 ,1 o 2
		respuesta--;
		return (char)respuesta;
	}
	
	//metodo para poner en la matriz la respuesta del jugador
	public void respuestaMatriz(char[][] matriz,char respuestaFila,char RespuestaColumna) throws NumberFormatException, IOException {
		//se controla que la posicion no se repita
		boolean control=false;
		do {
			control=false;
			if(esVacio(matriz, respuestaFila, RespuestaColumna)) {
				if(turno) {
					matriz[respuestaFila][RespuestaColumna]=j1;
				}else {
					matriz[respuestaFila][RespuestaColumna]=j2;
				}

				if(turno) {
					turno=false;
				}else {
					turno=true;
				}
				contador++;
				control=true;
			}else {
				System.out.println("Posicion ocupada");
				respuestaFila=respuestaFila();
				RespuestaColumna=respuestaColumna();
				control=false;
			}
		} while (!control);

	}
	
	//comprueba si la posicion esta vacia
	public boolean esVacio(char[][] matriz,char respuestaFila,char RespuestaColumna) {
		boolean esvacio=false;
		if(matriz[respuestaFila][RespuestaColumna]==vacio) {
			esvacio=true;
		}
		return esvacio;
	}
	
	//se comprueba si hay ganador j1
	public boolean comprobarJ1(char[][] matriz) {
		boolean ganador=false;
		//se comprueban las filas
		if (matriz[0][0]==j1 && matriz[0][1]==j1 && matriz[0][2]==j1) {
			ganador=true;
		}else if(matriz[1][0]==j1 && matriz[1][1]==j1 && matriz[1][2]==j1) {
			ganador=true;
		}else if(matriz[2][0]==j1 && matriz[2][1]==j1 && matriz[2][2]==j1) {
			ganador=true;
		}
		
		//se comprueban las columnas
		if (matriz[0][0]==j1 && matriz[1][0]==j1 && matriz[2][0]==j1) {
			ganador=true;
		}else if(matriz[0][1]==j1 && matriz[1][1]==j1 && matriz[2][1]==j1) {
			ganador=true;
		}else if(matriz[0][2]==j1 && matriz[1][2]==j1 && matriz[2][2]==j1) {
			ganador=true;
		}
		
		//comprobar diagonales
		if (matriz[0][0]==j1 && matriz[1][1]==j1 && matriz[2][2]==j1) {
			ganador=true;
		}else if(matriz[0][2]==j1 && matriz[1][1]==j1 && matriz[2][0]==j1) {
			ganador=true;
		}
		return ganador;
	}
	
	//se comprueba si hay ganador j2
	public boolean comprobarJ2(char[][] matriz) {
		boolean ganador=false;
		//se comprueban las filas
		if (matriz[0][0]==j2 && matriz[0][1]==j2 && matriz[0][2]==j2) {
			ganador=true;
		}else if(matriz[1][0]==j2 && matriz[1][1]==j2 && matriz[1][2]==j2) {
			ganador=true;
		}else if(matriz[2][0]==j2 && matriz[2][1]==j2 && matriz[2][2]==j2) {
			ganador=true;
		}
		
		//se comprueban las columnas
		if (matriz[0][0]==j2 && matriz[1][0]==j2 && matriz[2][0]==j2) {
			ganador=true;
		}else if(matriz[0][1]==j2 && matriz[1][1]==j2 && matriz[2][1]==j2) {
			ganador=true;
		}else if(matriz[0][2]==j2 && matriz[1][2]==j2 && matriz[2][2]==j2) {
			ganador=true;
		}
		
		//comprobar diagonales
		if (matriz[0][0]==j2 && matriz[1][1]==j2 && matriz[2][2]==j2) {
			ganador=true;
		}else if(matriz[0][2]==j2 && matriz[1][1]==j2 && matriz[2][0]==j2) {
			ganador=true;
		}
		return ganador;
	}
	
	
}
