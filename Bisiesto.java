import java.util.*;
/* Author: Andres Barragan Salas
** Date: 24/10/2018
** Description: Programa que adquiere un a�o y le dice al usuario si es bisiesto o no */
public class Bisiesto{
	public static void main(String[]args){
	//Variables
	int year = 0;
	Scanner kb = new Scanner(System.in);

	//Adquiere el a�o de parte del usuario.
	System.out.print("Ingresa un a�o: ");
	year = kb.nextInt();

	//Revisa que las condiciones del a�o bisiesto se cumplan.
	if ((year%4 == 0) && !(year%100 == 0))
		System.out.println("El a�o es bisiesto.");
	else if ((year%100 == 0) && (year%400 == 0))
		System.out.println("El a�o es bisiesto.");
	else
		System.out.println("El a�o NO es bisiesto.");

	}//End of main method
}//End of class