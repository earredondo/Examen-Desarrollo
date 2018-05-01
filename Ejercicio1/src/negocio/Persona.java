/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Random;

/**
 *
 * @author edgar
 */
public class Persona {
    
    private String nombre;
    private int edad;
    private String NSS;
    private char sexo = HOMBRE;
    private float peso;
    private float altura;
    
    public static final char HOMBRE     = 'H';
    public static final char MUJER      = 'M';
    public static final int PESO_BAJO   = -1;
    public static final int PESO_IDEAL  = 0;
    public static final int PESO_ALTO   = 1;

    public Persona(){
        this.NSS = generarNSS();
    }
    
    public Persona(String nombre, int edad, char sexo){
        this();
        this.nombre = nombre;
        this.edad   = edad;
        this.sexo   = sexo;
    }
    
    public Persona(String nombre, int edad, char sexo, float peso, float altura){
        this(nombre, edad, sexo);
        this.peso   = peso;
        this.altura = altura;
    }
    
    public int calcularIMC(){
        double IMC;
        IMC = this.peso / (Math.pow(this.altura, 2));
        
        if(!comprobarSexo(this.sexo)){ return -2; }
        if(this.altura == 0){ return -2; }
        
        switch(this.sexo){
            case HOMBRE:
                if(IMC < 20)     { return PESO_BAJO;}
                else if(IMC > 25){ return PESO_ALTO;}
                else             { return PESO_IDEAL;}
            case MUJER:
                if(IMC < 19)     { return PESO_BAJO;}
                else if(IMC > 24){ return PESO_ALTO;}
                else             { return PESO_IDEAL;}
            default:
                return -2;
        }
    }
    
    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }
    
    private boolean comprobarSexo(char sexo){
        return sexo == HOMBRE || sexo == MUJER;
    }
    
    public String toString(){
        return "Nombre: "   + this.nombre   + "\n" +
                "Edad: "    + this.edad     + "\n" +
                "NSS: "     + this.NSS      + "\n" +
                "Sexo: "    + this.sexo     + "\n" +
                "Peso: "    + this.peso     + "\n" +
                "Altura: "  + this.altura;
    }
    
    private String generarNSS(){
        String caracteresValidos = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String NSS = "";
        Random r = new Random();
        
        for(int i = 0; i < 8; i++){
            NSS = NSS + caracteresValidos.charAt(r.nextInt(caracteresValidos.length()));
        }
        return NSS;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the NSS
     */
    public String getNSS() {
        return NSS;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the peso
     */
    public float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * @return the altura
     */
    public float getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    
}
