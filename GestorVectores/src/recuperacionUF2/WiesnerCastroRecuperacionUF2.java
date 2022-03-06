package recuperacionUF2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//Leonardo Wiesner Recu UF2
public class WiesnerCastroRecuperacionUF2 {

	public static void main(String[] args) {
		// INICIALIZACION DE LAS VARIABLES
		Scanner reader = new Scanner(System.in);
		Boolean seguir = true;
		Boolean vectorgenerado = false;
		int[] vectoraleatorio = new int[1000];
		int eleccion = 0;
		int tamaño = 0;

		System.out.println("GESTOR DE VECTORES");
		while (seguir) {
			System.out.println();
			do {
				try {
					mostrarMenu();// Funcion mostrar menu (1)
					eleccion = Integer.parseInt(reader.next());
				} catch (Exception e) {
					System.out.println("Parametro No valido escoja una opcion de 1 a 6");
				}
			} while (eleccion < 1 || eleccion > 6);

			System.out.println("Has escogido la opcion " + eleccion);

			switch (eleccion) {
			case 1:
				vectorgenerado = true;

				do {
					try {
						System.out.println("Ingresa el tamaño del vector aleatorio que quieres generar");
						tamaño = Integer.parseInt(reader.next());
					} catch (Exception e) {
						System.out.println("Un vector no puede tener un tamaño menor a 1, Ingresalo nuevamente");
					}
				} while (tamaño < 1);

				vectoraleatorio = generarVectorAleatorio(tamaño); // Funcion generar Vector Aleatorio (2)
				imprimirArray(vectoraleatorio);// Funcion para imprimir el Array
				break;
			case 2:
				if (vectorgenerado) {
					System.out.println("Calculando la suma del array ...");
					System.out.println("La suma de los elementos del vector es:");
					System.out.println(calcularSuma(vectoraleatorio));
				} else {
					System.out.println("El vector aun no ha sido generado");
				}
				break;
			case 3:
				if (vectorgenerado) {
					System.out.println("Calculando la multiplicacion del array ...");
					System.out.println("La multiplicacion de los elementos del vector es:");
					System.out.println(calcularMultiplicacion(vectoraleatorio));

				} else {
					System.out.println("El vector aun no ha sido generado");
				}

			case 4:
				if (vectorgenerado) {
					System.out.println("Comprobando si la mas de la mitad son primos");
					primos(vectoraleatorio);
				} else {
					System.out.println("El vector aun no ha sido generado");
				}
				break;
			case 5:
				if (vectorgenerado) {
					System.out.println("Ordenar vector");
				} else {
					System.out.println("El vector aun no ha sido generado");
				}
				break;
			case 6:
				System.out.printf("Saliendo... %n Gracias por usar nuestro programa");
				seguir = false;
				break;
			}

		}
	}// FIN DEL MAIN

	public static void mostrarMenu() {
		System.out.println("----------//------//-------------//----------//");
		System.out.printf(
				"Escoge una opcion:%n 1.Generar vector aleatorio %n 2.Calcular suma vector %n 3.Calcular multiplicación vector %n 4.Comprobar primos %n 5.Ordenar vector. %n 6.Salir ");
		System.out.println();

	}

	public static int[] generarVectorAleatorio(int tamaño) {

		Random aleatorio = new Random();
		int[] vectoraleatorio = new int[tamaño];
		for (int i = 0; i < vectoraleatorio.length; i++) {
			vectoraleatorio[i] = aleatorio.nextInt(100 - 1 + 1) + 1;
		}
		return vectoraleatorio;
	}

	public static int[] imprimirArray(int[] lista) {
		System.out.println("Mostrando vector aleatorio.....");
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + " ");
		}
		return lista;
	}

	public static int calcularSuma(int[] vectoraleatorio) {
		int suma = 0;
		for (int i = 0; i < vectoraleatorio.length; i++) {
			suma += vectoraleatorio[i];
		}
		return suma;
	}

	public static int calcularMultiplicacion(int[] vectoraleatorio) {
		int multiplicacion = 1;
		for (int i = 0; i < vectoraleatorio.length; i++) {
			multiplicacion = multiplicacion * vectoraleatorio[i];
		}
		return multiplicacion;
	}

	public static String primos(int[] vectoraleatorio) {
		String frasecita = "";
		int contadorprimos = 0;
		int mitadlength = 0;
		for (int i = 0; i < vectoraleatorio.length; i++) {
			if (esPrimo(vectoraleatorio[i])) {
				System.out.println("Número primo: " + vectoraleatorio[i]);
				contadorprimos++;
			}
		}
		System.out.printf("%nTotal números primos: %d", contadorprimos);
		System.out.println("");
		mitadlength = vectoraleatorio.length / 2;
		if (contadorprimos <= mitadlength) {
			System.out.println("La cantidad de primos no supera la cantidad de elementos");
			return frasecita;
		} else {
			System.out.println("Numero de primos: " + contadorprimos);
			frasecita = "Mas de la mitad son primos";
			return frasecita;
		}
	}

	public static boolean esPrimo(int num) {
		boolean primo = (num == 1) ? false : true;
		int divisor = 2;
		while (primo && divisor <= Math.sqrt(num)) {
			if (num % divisor == 0) {
				primo = false;
			}
			divisor++;
		}
		return primo;
	}


}
