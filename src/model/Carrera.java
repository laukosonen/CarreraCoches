package model;

import java.sql.SQLOutput;

public class Carrera {
    /*A continuación se detallan los atributos de la clase Carrera*/
    private Coche ganador;
    private Coche [] coches;  /*Hemos creado un array con el objeto Coche con la idea de recoger los dos coches para reducir código*/
    private boolean hayGanador;/*Nos ayudamos de un booleano para poder comprobar si hay ganador en el transcurso de la carrera*/
    private int kmCircuito, numeroVueltas;

    /*Creamos el constructor vacío*/
    public Carrera() {
    }

    /*Creamos un constructor con los elementos básicos de la carrera: los coches, los kilómetros del circuito y el número de vueltas del
    * circuito*/
    public Carrera(Coche[] coches, int kmCircuito, int numeroVueltas) {

        this.coches = coches;
        this.kmCircuito = kmCircuito;
        this.numeroVueltas = numeroVueltas;
    }

    /*Generamos los getter y setter de todos los atributos*/
    public Coche[] getCoches() {
        return coches;
    }

    public void setCoches(Coche[] coches) {
        this.coches = coches;
    }

    public Coche getGanador() {
        return ganador;
    }

    public void setGanador(Coche ganador) {
        this.ganador = ganador;
    }

    public int getKmCircuito() {
        return kmCircuito;
    }

    public void setKmCircuito(int kmCircuito) {
        this.kmCircuito = kmCircuito;
    }

    public int getNumeroVueltas() {
        return numeroVueltas;
    }

    public void setNumeroVueltas(int numeroVueltas) {
        this.numeroVueltas = numeroVueltas;
    }

    /*Creamos el método "iniciar carrera" que precisa de los datos del array de cocches y de la velocidad intriducida
    * por el usuario para funcionar. Además incluirá el resto de métodos creados en la clase Coche (acelerar, mostrarDatosCoches,
    * mostrarVelocidadYKilometros y el método evaluarGanador en esta clase que explicamos más adelante*/
    /*En este método primero se muestran los datos de cada coche, a continuación ambos aceleran tantas veces como número de vueltas
    * tiene el circuito (en este caso 2).Se evalúa si después de esas vueltas tenemos ganador, si no lo hay, acelararán ambos tantas veces
    * como sean necesarias hasta que alguno complete el número total de kilómetros a recorrer;se evaluará después de cada una de esas
    * aceleraciones si tenemos ganador. Una vez que tenemos ganador se indicará a qué coche corresponde. */
    public void iniciarCarrera(Coche [] coches,int velocidadASumar){

        for (int i = 0; i < coches.length; i++)
        {
            coches[i].mostrarDatosCoche();
            System.out.println();
        }

        System.out.println("¡Comienza la carrera!");
        System.out.println();

        for (int i = 0; i <this.numeroVueltas ; i++)
        {
            for (int j = 0; j < coches.length; j++)
            {
               coches[j].acelerar(velocidadASumar);
            }
        }
        evaluarGanador(coches);

        if (hayGanador)
        {
            System.out.println("¡La carrera ha finalizado!");
        }
        else
        {
            System.out.println("De momento no hay ganador. Así van los participantes:");
            for (int i = 0; i < coches.length; i++)
            {
                coches[i].mostrarVelocidadYKilometros();
                System.out.println("Kilómetros para completar el circuito: "+((kmCircuito*numeroVueltas)-coches[i].getKm())+"km");
                System.out.println();
            }
            System.out.println("Continúa la carrera...");
            System.out.println();

            do{
            for (int i = 0; i < coches.length; i++)
            {
                    coches[i].acelerar(velocidadASumar);
                    evaluarGanador(coches);
            }
            }while (coches[0].getKm()<this.kmCircuito*this.numeroVueltas && coches[1].getKm()<this.kmCircuito*this.numeroVueltas);

            System.out.println("¡La carrera ha finalizado!");

        }
        System.out.println("El ganador ha sido el coche con matrícula: "+ganador.getMatricula()+". "+"¡El "+ganador.getMarca()+" "+ganador.getModelo()+"!");
    }

    /*Hemos añadido este método "evaluarGanador" que nos devuele un booleano para ir controlando en diferentes momentos de la carrera
    * si tenemos o no ganador. Una vez que nos devuelva un "true" finalizará la carrera*/
    public boolean evaluarGanador (Coche [] coches){

        for (int i = 0; i < coches.length; i++)
        {
            if (coches[i].getKm()>=this.kmCircuito*this.numeroVueltas)
            {
                hayGanador=true;
                this.ganador=coches[i];
            }
        }
        return hayGanador;
    }
}
