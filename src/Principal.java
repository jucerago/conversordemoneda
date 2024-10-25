import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        double valor = 0;
        double resultado = 0;
        System.out.println("**************************************");
        System.out.println("Bienvenido al conversor de moneda \n");
        while (true){

            System.out.println("""
                *************************** \n
                1) Dolar =>> Peso Argentino
                2) Peso Argentino =>> Dolar
                3) Dolar =>> Real Brasileño
                4) Real Brasileño =>> Dolar
                5) Dolar => Peso Colombiano
                6) Peso Colombiano => Dolar
                7) Salir
                Elija una opcion valida:
                *********************************************""");

            OpcionCambio opcionCambio = new OpcionCambio();
            Scanner seleccion = new Scanner(System.in);

            try {
                var opcion = seleccion.nextInt();

                if (opcion == 7){
                    System.out.println("Aplicacion cerrada por el usuario");
                    break;
                }

                System.out.println("Elija el monto a convertir por favor");
                valor = seleccion.nextDouble();

                Cambio cambio = opcionCambio.buscaCambio(opcion);
                resultado = valor * cambio.conversion_rate();



                System.out.println("El valor de " + valor + " " + cambio.base_code() +
                        " es igual a " + resultado + " " + cambio.target_code() + "\n");
            }catch (InputMismatchException e){
                System.out.println("Error en la seleccion");

            }catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }

        }


    }
}
