
import java.util.Scanner;
import negocio.Persona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edgar
 */
public class Aplicacion {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresa los siguientes datos.");
        
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        
        System.out.print("Edad: ");
        int edad = teclado.nextInt();
        
        System.out.print("Sexo(H/M): ");
        char sexo = teclado.next().toUpperCase().charAt(0);
        
        System.out.print("Peso(Kg): ");
        float peso = teclado.nextFloat();
        
        System.out.print("Altura(m): ");
        float altura = teclado.nextFloat();
        
        Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona();
        
        persona3.setNombre(nombre);
        persona3.setEdad(edad);
        persona3.setSexo(sexo);
        persona3.setPeso(peso);
        persona3.setAltura(altura);
        
        System.out.println("\nDatos de las personas.\n");
        
        System.out.println(persona1);
        comprobarPeso(persona1);
        mayorDeEdad(persona1);
        
        System.out.println();
        System.out.println(persona2);
        comprobarPeso(persona2);
        mayorDeEdad(persona2);
        
        System.out.println();
        System.out.println(persona3);
        comprobarPeso(persona3);
        mayorDeEdad(persona3);
        
    }
    
    public static void comprobarPeso(Persona persona){
        switch (persona.calcularIMC()) {
            case Persona.PESO_BAJO:
                System.out.println("peso bajo");
                break;
            case Persona.PESO_IDEAL:
                System.out.println("peso ideal");
                break;
            case Persona.PESO_ALTO:
                System.out.println("sobrepeso");
                break;
            default:
                System.out.println("No se cuenta con la estatura de la persona");
                break;
        }
    }
    
    public static void mayorDeEdad(Persona persona){
        System.out.println(persona.esMayorDeEdad() ? "mayor de edad" : "menor de edad");
    }
    
}
