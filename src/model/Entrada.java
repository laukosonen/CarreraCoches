package model;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        /*Creamos los coches*/
        Coche coche1 =new Coche ("Opel","Corsa","4578 HTR",100,1.2);
        Coche coche2=new Coche ("Seat", "Leon", "2024 SKL",150,1.5);

        /*Creamos al array de coches de tipo Coche, ya que todas los métodos se aplican para ambos coches. De esta
        * manera reducimos código*/
        Coche [] coches=new Coche[2];
        coches[0]=coche1;
        coches[1]=coche2;
        /*Creamos la carrera*/
        Carrera carrera=new Carrera(coches,50,2);



        System.out.println("La carrera consiste en dar "+carrera.getNumeroVueltas()+" "+"vueltas a un circuito de "
                        +carrera.getKmCircuito()+"km, es decir, un total de "+carrera.getNumeroVueltas()* carrera.getKmCircuito()+" "+"km.");
        System.out.println();

        /*Le pedimos al usuario por teclado que introduzca un valor de velocidad que será el que se usará para sacar
         * una velocidad random que tomará como máximo ese valor introducido y como mínimo 10km/h*/
        System.out.println("Introduce número para calcular la aceleración aleatoria");
        Scanner scanner=new Scanner(System.in);
        int velocidadASumar=scanner.nextInt();


        System.out.println("Éstos son los datos de los participantes:");
        carrera.iniciarCarrera(coches,velocidadASumar);

        System.out.println("Éstos han sido los resultados al completar el circuito:");
        System.out.println();

        for (int i = 0; i < coches.length; i++)
        {
            coches[i].mostrarVelocidadYKilometros();
            System.out.println();
        }
    }
}
