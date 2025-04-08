package sistemaventasteatromoro;

import java.util.Scanner;

/**
 *
 * @author Carolina Delgado
 */
public class Exp2_S4_Carolina_Delgado {

    public static void main(String[] args) {
        
        // Inicializar scanner
        Scanner scn = new Scanner(System.in);
        
        // Declaracion de variables
        int opcion;
        int edad;
        int asiento;
        double precioEntrada;
        double precioEntradaZonaA = 17000;
        double precioEntradaZonaB = 10000;
        double precioEntradaZonaC = 5000;
        double precioTotal;
        double descuentoEstudiante = 0.90;
        double descuentoTerceraEdad = 0.85;
        char zona;
        boolean comprando = true;
        boolean asientoOcupado = true;
        
        // Declarar arrays de asientos donde 0 es vacio y 1 es ocupado
        int[] asientosA = new int[10];
        int[] asientosB = new int[10];
        int[] asientosC = new int[10];
        
        // Inicializar arrays de asientos como vacios
        for(int i=0; i<10; i++) {
            asientosA[i] = 0;
            asientosB[i] = 0;
            asientosC[i] = 0;
        }
        
        // Dejar algunos asientos ocupados
        asientosA[4] = 1;
        asientosA[7] = 1;
        asientosB[2] = 1;
        asientosC[0] = 1;
 
        // Declarar opciones del menu principal
        String[] opciones = new String[2];
        opciones[0] = "Comprar entrada.";
        opciones[1] = "Salir.";
        
        System.out.println("Sistema de ventas del Teatro Moro: ");
        System.out.println("Bienvenido al Teatro Moro. Que accion desea realizar?");
        
        do {
            do {
                // Imprimir en pantalla el menu principal
                System.out.println("Menu Principal:");
                for (int i=0; i<2; i++) {
                    System.out.println(String.valueOf(i+1) + ". " + opciones[i]);
                }

                System.out.println("Elija una opcion: ");
                opcion = scn.nextInt();

            } while (!(opcion == 1 || opcion == 2));

            if (opcion == 1) {
                
                asientoOcupado = true;
                do {
                    // Imprimir plano de los asientos
                    System.out.println("Seleccion de asientos: \n");
                    System.out.println("Plano de las ubicaciones disponibles del Teatro Moro: ");
                    System.out.println("Tenga en cuenta que: 0 esta disponible, 1 esta ocupado");
                    System.out.print("Numero Asiento: ");
                    for (int i=1; i<=10; i++) {
                        System.out.print(String.valueOf(i) + "  ");
                    }
                    System.out.println("");
                    System.out.print("Zona A:        ");
                    for (int i=0; i<10; i++) {
                        System.out.print("[" + String.valueOf(asientosA[i]) + "]");
                    }
                    System.out.println("");
                    System.out.print("Zona B:        ");
                    for (int i=0; i<10; i++) {
                        System.out.print("[" + String.valueOf(asientosB[i]) + "]");
                    }
                    System.out.println("");
                    System.out.print("Zona C:        ");
                    for (int i=0; i<10; i++) {
                        System.out.print("[" + String.valueOf(asientosC[i]) + "]");
                    }
                    System.out.println("");
                    
                    // Obtener y validar zona 
                    do {
                        System.out.println("Elija zona:");
                        zona = scn.next().toUpperCase().charAt(0);
                        //     Arbol -> ARBOL -> A. toUpperCase = Ingresa entrada en mayúsculas
                        //     zona = A
                        
                        // Usar switch case para ingresar valor a cada zona
                        switch (zona) {
                            case 'A':
                                precioEntrada = precioEntradaZonaA;
                                break;
                            case 'B':
                                precioEntrada = precioEntradaZonaB;
                                break;
                            case 'C':
                                precioEntrada = precioEntradaZonaC;
                                break;
                            default:
                                precioEntrada = 0;
                                System.out.println("Opcion invalida");
                                break;
                        }

                    } while (precioEntrada == 0);

                    // Obtener y validar asiento
                    do {
                        System.out.println("Elija asiento: (1-10)");
                        asiento = scn.nextInt();
                    }while(asiento < 1 || asiento > 10);
                    System.out.println("Usted eligío: " + zona + String.valueOf(asiento));
                    
                    
                    // Verificar que el asiento este disponible
                    switch (zona) {
                        case 'A':
                            if (asientosA[asiento-1] == 0) {
                                asientoOcupado = false;
                                asientosA[asiento-1] = 1;
                            }
                            break;
                        case 'B':
                            if (asientosB[asiento-1] == 0) {
                                asientoOcupado = false;
                                asientosB[asiento-1] = 1;
                            }
                            break;
                        case 'C':
                            if (asientosC[asiento-1] == 0) {
                                asientoOcupado = false;
                                asientosC[asiento-1] = 1;
                            }
                            break;
                    }
                    
                    if (asientoOcupado) {
                        System.out.println("El asiento esta ocupado!");
                    }
                    

                }while(asientoOcupado);
                    
                //Validar edad 
                do {
                    System.out.println("Ingrese su edad");
                    edad = scn.nextInt();
                }while(edad < 0);

                //Imprimir precio de entrada segun descuento aplicado
                if (edad <= 18) {
                    precioTotal = precioEntrada * descuentoEstudiante;
                    System.out.println(String.format("Su entrada de estudiante es: $%.0f\n", (precioTotal)));
                }
                else if (edad >= 60) {
                    precioTotal = precioEntrada * descuentoTerceraEdad;
                    System.out.println(String.format("Su entrada de tercera edad es: $%.0f\n" , (precioTotal)));
                }
                else {
                    precioTotal = precioEntrada;
                    System.out.println("");
                }
                
                //Imprimir resumen de compra de entrada
                System.out.println("Resumen de su compra");
                System.out.println("Su asiento es: " + zona + String.valueOf(asiento));
                System.out.println(String.format("El precio de su entrada es: $%.0f", precioEntrada));
                if(edad <= 18) {
                    System.out.println("Su descuento aplicado es del 10%");
                }
                else if (edad >=60){
                    System.out.println("Su descuento aplicado es del 15%");
                }
                System.out.println(String.format("El precio total de su entrada: $%.0f", precioTotal));
                System.out.print("Presione enter para continuar...");
                scn.nextLine(); // Vaciamos buffer
                scn.nextLine(); // Pedir nueva linea
            }
            else {
                comprando = false;
                System.out.println("Gracias por comprar en el Teatro Moro.");
            }
        } while(comprando == true);

        // Cerrar scanner
        scn.close();
    }
    
}
