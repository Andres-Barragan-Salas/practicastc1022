import java.util.*;
/* Author: Andres Barragan Salas
** Date: 24/10/2018
** Description: Programa que adquiere un año y le dice al usuario si es bisiesto o no */
public class NumerosNaturales{
	public static void main(String[]args){
	//Variables
	int num = 0, count = 0, sum = 0;
	Scanner kb = new Scanner(System.in);

	//Adquiere el numero del usuario.
	System.out.print("Ingresa un numero: ");
	num = kb.nextInt();

	for (count = 1; count < num; count++){
		if (num%count == 0)
			sum+= count;
	}//End of for loop

	if (sum == num)
		System.out.println("El numero es un natural perfecto.");
	else
		System.out.println("El numero NO es un natural perfecto.");

	}//End of main method
}//End of class