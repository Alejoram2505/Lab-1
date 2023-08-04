import java.util.Random;
import java.util.Scanner;

public class pig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int puntajeObjetivo = 100;
        int puntajeJugador1 = 0;
        int puntajeJugador2 = 0;

        while (puntajeJugador1 < puntajeObjetivo && puntajeJugador2 < puntajeObjetivo) {
            System.out.println("Puntaje del Jugador 1: " + puntajeJugador1);
            System.out.println("Puntaje del Jugador 2: " + puntajeJugador2);

            System.out.println("Turno del Jugador 1:");
            int puntajeRonda1 = turnoJugador(puntajeJugador1, puntajeObjetivo);
            puntajeJugador1 += puntajeRonda1;

            if (puntajeJugador1 >= puntajeObjetivo) {
                System.out.println("¡El Jugador 1 gana!");
                break;
            }

            System.out.println("Turno del Jugador 2:");
            int puntajeRonda2 = turnojugador2(puntajeJugador2, puntajeObjetivo);
            puntajeJugador2 += puntajeRonda2;

            if (puntajeJugador2 >= puntajeObjetivo) {
                System.out.println("¡El Jugador 2 gana!");
                break;
            }
        }
    }

    public static int lanzarDado() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static int turnoJugador(int puntajeActual, int puntajeObjetivo) {
        Scanner scanner = new Scanner(System.in);
        int puntajeRonda = 0;
        
        while (puntajeRonda < 20) {
            System.out.println("Presiona Enter para lanzar el dado...");
            scanner.nextLine();
            
            int dado1 = lanzarDado();
            int dado2 = lanzarDado();
            int total = dado1 + dado2;

            if (dado1 == 1 || dado2 == 1) {
                System.out.println("Sacaste un 1 y perdiste todos los puntos de esta ronda.");
                return 0;
            }

            puntajeRonda += total;
            System.out.println("Sacaste " + dado1 + " y " + dado2 + ". Puntaje de la ronda: " + puntajeRonda);

            if (puntajeActual + puntajeRonda >= puntajeObjetivo) {
                return puntajeRonda;
            }

            System.out.println("¿Deseas lanzar nuevamente? (s/n):");
            String respuesta = scanner.nextLine().toLowerCase();
            if (!respuesta.equals("s")) {
                break;
            }
        }

        return puntajeRonda;
    }

    public static int turnojugador2(int puntajeActual, int puntajeObjetivo) {
        int puntajeRonda = 0;
        while (puntajeRonda < 20) {
            int dado1 = lanzarDado();
            int dado2 = lanzarDado();
            int total = dado1 + dado2;

            if (dado1 == 1 || dado2 == 1) {
                System.out.println("El jugador 2 sacó un 1 y perdió todos los puntos de esta ronda.");
                return 0;
            }

            puntajeRonda += total;
            System.out.println("El jugador 2 sacó " + dado1 + " y " + dado2 + ". Puntaje de la ronda: " + puntajeRonda);

            if (puntajeActual + puntajeRonda >= puntajeObjetivo) {
                return puntajeRonda;
            }
            
        }

        System.out.println("El jugador 2 decidió dejar de lanzar.");
        return puntajeRonda;
    }
}

