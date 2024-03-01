package model;

import java.util.Scanner;

public class Coche {
/*A continuación se detallan los atributos de la clase Coche*/
    private String marca, modelo,matricula;
    private int cv,velocidad,km, velocidadASumar;
    private double cc;

    /*Creamos el constructor vacío*/
    public Coche() {
    }

    /*Creamos un constructor con todos los atributos definidos anteriormente a excepción de la velocidad y los kilómeotrs,
    pues queremos que éstos se inicien en 0 y ese es su valor por defecto*/
    public Coche(String marca, String modelo, String matricula, int cv, double cc) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cv = cv;
        this.cc = cc;
    }

    /*Generamos los getter y setter de todos los atributos*/
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public double getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getVelocidadASumar() {
        return velocidadASumar;
    }

    public void setVelocidadASumar(int velocidadASumar) {
        this.velocidadASumar = velocidadASumar;
    }

    public int velocidadSumar ()
    {
        return velocidadASumar;
    }


    /*Creamos el método "acelerar" en el que el usuario tendrá que introducir un valor de velocidad que será el que se usará para sacar
    * una velocidad random que tomará como máximo ese valor introducido y como mínimo 10km/h*/
    public void acelerar (int velocidadASumar)
    {
        int velocidadAuxiliar=0;
        if(this.cv<=100)
        {
            velocidadAuxiliar=(int)(Math.random()*velocidadASumar);
            if (velocidadAuxiliar<10)
            {
                velocidadAuxiliar=10;
            }
        }
        else
        {
             velocidadAuxiliar=(int)(Math.random()*velocidadASumar)+10;
        }

         this.velocidad+=velocidadAuxiliar;

         this.km+=0.5*(this.velocidad);
    }

    /*Creamos el método "mostrarDatosCoche" con todos los atributos que contiene la clase Coche*/
    public void mostrarDatosCoche (){

        System.out.println("Marca y modelo: "+getMarca()+" "+getModelo());
        System.out.println("Matrícula: "+getMatricula());
        System.out.println("cv: "+getCv());
        System.out.println("cc: "+getCc());
        System.out.println("Velocidad: "+getVelocidad()+"km/h");
        System.out.println("Kilómetros recorridos: "+getKm()+"km");
    }

    /*Adicionalmente, creamos el método "mostrarVelocidadYKilometros" que nos indicará el estado en el que están
    * los coches en cuanto a velocidad y kilómetros que llevan después de completar el número de aceleraciones igual
    * al número de vueltas del circuito (2)*/
    public void mostrarVelocidadYKilometros () {

        System.out.println(getMarca()+" "+getModelo()+":");
        System.out.println("Velocidad: "+getVelocidad()+"km/h");
        System.out.println("Kilómetros recorridos: "+getKm()+"km");

    }
}

