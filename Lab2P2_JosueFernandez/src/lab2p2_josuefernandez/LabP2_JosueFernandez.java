/* Laboratorio #2, Programación 2
 */
package lab2p2_josuefernandez;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Josué Fernández
 */
public class LabP2_JosueFernandez {

    private static ArrayList<Empleado> emp;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion = 0;
        boolean loggedIn = false;

        emp = new ArrayList();

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n---------MENU DE OPCIONES---------\n");
            System.out.println("0. Salir");
            System.out.println("1. Registro de Empleados");
            System.out.println("2. Despedir Empleados");
            System.out.println("3. Log In");
            System.out.println("4. Ascender Cajero");
            System.out.println("5. Listar Empleados");
            System.out.println("6. Modificar Empleado");
            System.out.println("7. RANDOM");
            System.out.print("\nIngrese la opción que desee: ");
            opcion = sc.nextInt();
            System.out.println();

            if (loggedIn) {

                switch (opcion) {
                    case 1:
                        //Registrar empleados

                        System.out.print("Ingrese el nombre del nuevo empleado: ");
                        String nombre = sc.next();
                        System.out.print("\nIngrese el apellido del nuevo empleado: ");
                        String apellido = sc.next();
                        System.out.print("\nIngrese la edad del nuevo empleado: ");
                        int edad = sc.nextInt();

                        int sexo;
                        do {
                            System.out.println("\n1. Masculino\n2. Femenino");
                            System.out.print("Ingrese el género del nuevo empleado: ");
                            sexo = sc.nextInt();
                        } while (sexo != 1 && sexo != 2);

                        float altura;
                        do {
                            System.out.print("\nIngrese la altura del nuevo empleado (en m): ");
                            altura = sc.nextFloat();
                        } while (altura <= 0);

                        float peso;
                        do {
                            System.out.print("\nIngrese el peso del nuevo empleado (en lb): ");
                            peso = sc.nextFloat();
                        } while (peso <= 0);

                        System.out.print("\nIngrese el título del nuevo empleado: ");
                        String titulo = sc.next();

                        System.out.print("\nIngrese el color favorito del empleado (en inglés): ");
                        String colorFavorito = sc.next();

                        int tipo;
                        do {
                            System.out.println("1. Gerente\n2. Aseador\n3. Cajero\n1. Seguridad\n");
                            System.out.print("Ingrese el cargo del empleado: ");
                            tipo = sc.nextInt();
                        } while(tipo<1 || tipo>4);
                        
                        String genero = sexo==1 ? "Masculino" : "Femenino";
                        
                        Empleado empleado = new Empleado(colorFavorito, edad, genero, altura, peso, titulo, tipo);
                        
                        emp.add(empleado);

                        break;
                    case 2:
                        //Despedir empleados
                        break;
                    //////////////////////////////////////////////////
                    case 3:
                        System.out.println("Usted ya inició sesión.");
                        break;

                    case 4:
                        //Ascender Cajero

                        break;

                    //////////////////////////////////////////////////
                    case 5:
                        //Listar empleados
                        listarTodos();
                        break;

                    case 6:
                        //Modificar empleado
                        break;
                    case 7:
                        //RANDOM
                        break;
                    default:
                        System.out.println("Ingresó una opción inválida.");
                    case 0:

                }

                //Opción para el login
            } else if (opcion == 3) {
                System.out.print("Ingrese su usuario: ");
                String usuario = sc.next();

                System.out.print("\nIngrese su contraseña: ");
                String contra = sc.nextLine();

                if (usuario.equals("leobanegas") && contra.equals("99")) {
                    System.out.println("Sesión iniciada exitosamente.");
                    loggedIn = true;
                } else {
                    System.out.println("Usuario o contraseña incorrectos. No se ha iniciado la sesión.");
                }

            }

            //Fin del ciclo principal
        } while (opcion != 0);

    }//Fin main

    public static void listarTodos() {

        int i = 1;
        i = listarCategoria("Gerente", i);
        i = listarCategoria("Aseador", i);
        i = listarCategoria("Cajero", i);
        i = listarCategoria("Seguridad", i);

    }

    public static int listarCategoria(String tipo, int inicio) {

        System.out.println("Cargo - " + tipo + ":");
        for (Empleado empleado : emp) {
            if (empleado.getCargo().equals(tipo)) {
                System.out.println(inicio + ". " + empleado.toString());
                inicio++;
            }
        }
        System.out.println();

        return inicio;
    }

}
