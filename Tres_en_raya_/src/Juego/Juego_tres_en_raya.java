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
                    tablero[i][j] = " "; // Todas las casillas inician vacías
                }
            }
	        
            // Pidimos los nombres de los jugadores
            System.out.print("Ingrese el nombre del jugador 1: ");
            String jugador1 = s.nextLine();
            System.out.print("Ingrese el nombre del jugador 2: ");
            String jugador2 = s.nextLine();

            // Determinar quién comienza
            String turno;
            if (random.nextInt(2) == 0) {
                turno = jugador1;
            } else {
                turno = jugador2;
            }
            System.out.println(turno + " empieza.");
            
            // Variables para controlar el juego
            boolean juegoTerminado = false;
            int movimientos = 0;

            while (!juegoTerminado) {
                // Mostrar el tablero
                System.out.println("-------------");
                for (int i = 0; i < 3; i++) {
                    System.out.print("| ");
                    for (int j = 0; j < 3; j++) {
                        System.out.print(tablero[i][j] + " | ");
                    }
                    System.out.println();
                    if (i < 2) System.out.println("-------------");
                }
                System.out.println("-------------");
                

                // Solicitar movimiento
                System.out.println(turno + ", es tu turno.");
                System.out.print("Elige fila (1-3): ");
                int fila = s.nextInt() - 1;
                System.out.print("Elige columna (1-3): ");
                int columna = s.nextInt() - 1;
                
                // Verificar si el movimiento es válido
                if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3 || !tablero[fila][columna].equals(" ")) {
                    System.out.println("Movimiento inválido, intenta de nuevo.");
                    continue; // Si el movimiento no es válido, se repite el turno
                }
                
                // Colocar ficha en el tablero
                if (turno.equals(jugador1)) {
                    tablero[fila][columna] = "X"; // Si es el turno de jugador1, coloca "X"
                } else {
                    tablero[fila][columna] = "O"; // Si no, coloca "O" para el jugador2
                }
                movimientos++;
                
                // Verificar si hay un ganador (filas, columnas, diagonales)
                boolean ganador = false;
                for (int i = 0; i < 3; i++) {
                    // Verificar filas
                    if (!tablero[i][0].equals(" ") && tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2])) {
                        ganador = true;
                    }
                    // Verificar columnas
                    if (!tablero[0][i].equals(" ") && tablero[0][i].equals(tablero[1][i]) && tablero[1][i].equals(tablero[2][i])) {
                        ganador = true;
                    }
                } 
                
                // Verificar diagonales
                if (!tablero[0][0].equals(" ") && tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2])) {
                    ganador = true;
                }
                if (!tablero[0][2].equals(" ") && tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0])) {
                    ganador = true;
                }

                if (ganador) {
                    System.out.println(turno + " ha ganado");
                    juegoTerminado = true;
                }
                
                // Verificar si hay empate
                if (movimientos == 9 && !ganador) {
                    System.out.println("Empate");
                    juegoTerminado = true;
                }                

                // Cambiar de turno
                if (!juegoTerminado) {
                    if (turno.equals(jugador1)) {
                        turno = jugador2; // Si es el turno de jugador1, cambia al jugador2
                    } else {
                        turno = jugador1; // Si es el turno de jugador2, cambia al jugador1
                    }
                }
            }                
                
	}

}

		
	}
