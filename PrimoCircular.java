import java.util.*;
/*Autor: Andrés Barragán Salas
**Fecha: 25/10/2018
**Descripción: ¨Programa que evalue si un numero primo es circular o no.*/
public class PrimoCircular{
	public static void main(String[]args){
		//Variables go here
		int i=0, j=0, e=0, s=0, size = 0, nuevoPrimo = 0;
		boolean primoCirc = true;
		String num= "", newNum = "";
		Scanner kb = new Scanner(System.in);

		//Obtiene el numero por parte del usuario
		System.out.print("Ingresa un numero para evaluar si es un circular primo: ");
		num = kb.next();

		//Obtiene el numero de digitos del numero para futuro uso
		size = num.length();

		/*Se crean 2 "arrays" para iterar sobre los digitos del numero,
		un array para el numero original y otro para sus circulaciones.
		Cada array adquiere el tamaño del numero de dígitos ingresados. */
		int[] numero = new int[size];
		int[][] circ = new int[size][size];

		/*Convierte cada "char" del string utilizado para guardar el numero y lo guarda
		como terminos independientes en un "array."*/
		for (i = 0; i < size; i++){
			numero[i] = Integer.parseInt(Character.toString(num.charAt(i)));
		}

		/*Usando dos "for loops" y una formula matemática, se generan todas las
		circulaciones correspondientes al numero dígitos que hay. */
		for (i = 0; i < size; i++){
			for (j = 0; j < size; j++){
				s = j + i;
				if (s < size)
					circ[i][s] = numero[j];
				else
					circ[i][(s - size)] = numero[j];
			}
		}

		/*Para cada circulación generada, se hace un nuevo "string" con cada
		circulación y despues se convierte a integer ese string.
		Con un segundo "for loop" se evalúa si el número obtenido es un numero
		primo, en caso de que no lo sea se le da valoir de falsedad al que sea
		un numero circular primo, pero si en todos los casos es primo se deja el
		de verdad */
			for (i = 0; i < size; i++){
			newNum = "";
			for (j = 0; j < size; j++){
				newNum+= Integer.toString(circ[i][j]);
				nuevoPrimo = Integer.valueOf(newNum);
			}
			for (e = 2; e < nuevoPrimo; e++){
				if((nuevoPrimo%e) == 0){
					System.out.println(nuevoPrimo + " no es primo.");
					primoCirc = false;
					break;
				}
			}
		}

		/*En caso de que haya resultado que todas las circulaciones sean primas
		se imprime que el numero efectivamente es un circular primo */
		if (primoCirc)
			System.out.println("El numero " + num + " es un circular primo.");
		else
			System.out.println("EL numero " + num + " NO es un circular primo.");

	}//End of main method
}//End of class