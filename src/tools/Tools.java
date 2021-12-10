package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tools {

	// metodo que controla los numeros enteros
	public int controlarEntero() throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		int numero = 0;
		boolean control;
		do {
			control = false;
			try {
				numero = Integer.parseInt(teclado.readLine());
				control = true;
			} catch (NumberFormatException e) {
				System.out.println("Valor invalido " + e.getMessage()+", introduce un nuevo valor");
				control = false;
			}

		} while (!control);

		return numero;
	}

	// metodo que controla los float
	public float controlarFloat() throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		Float numero = 0F;
		boolean control;
		do {
			control = false;
			try {
				numero = Float.parseFloat(teclado.readLine());
				control = true;
			} catch (NumberFormatException e) {
				System.out.println("Valor invalido " + e.getMessage()+", introduce un nuevo valor");
				control = false;
			}

		} while (!control);

		return numero;
	}
	
	//metodo para leer String
	public String LeerString() throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String caracter = teclado.readLine();
		return caracter;
	}

}
