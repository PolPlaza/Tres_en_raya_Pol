package Juego;

import java.util.Random;
import java.util.Scanner;

public class Juego_tres_en_raya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	     Scanner s = new Scanner(System.in);
	     Random random = new Random();
	        
            // Normas
            System.out.println("Bienvenidos al juego del tres en raya");
            System.out.println("Normas:");
            System.out.println("1. Dos jugadores tomarán turnos para colocar sus fichas en un tablero de 3x3.");
            System.out.println("2. El primer jugador en colocar tres fichas en línea (horizontal, vertical o diagonal) gana.");
            System.out.println("3. Si el tablero se llena sin ganador, será un empate.");
            System.out.println("Cuando termine el juego, podrás elegir si deseas jugar otra vez.");

            // Inicializar tablero vacío
            String[][] tablero = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tablero[i][j] = " "; // Todas las casillas inician vacias
                }
            }
	        
            // Pidimos los nombres de los jugadores
            System.out.print("Ingrese el nombre del jugador1: ");
            String jugador1 = s.nextLine();
            System.out.print("Ingrese el nombre del jugador2: ");
            String jugador2 = s.nextLine();

            // Determinar quién comienza
            String turno;
            if (random.nextInt(2) == 0) {
                turno = jugador1;
            } else {
                turno = jugador2;
            }
            System.out.println(turno + " empieza");
            
            
	}

}
