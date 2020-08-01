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

    public static int contadorGerentes = 0;
    public static int contadorCajeros = 0;
    public static int contadorAseadores = 0;
    public static int contadorSeguridad = 0;

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

            boolean ascenderRandom = false;

            if (loggedIn) {

                if (contadorGerentes == 0) {
                    if (contadorCajeros != 0) {
                        System.out.println("¡Alerta! Se ascenderá a un cajero a gerente aleatoriamente.");
                        opcion = 1;
                        ascenderRandom = true;
                    } else {
                        System.out.println("¡Alerta! Debe contratar a otro gerente.");
                        opcion = 4;
                    }
                }

                switch (opcion) {
                    //////////////////////////////////////////////////
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

                        System.out.print("\nIngrese el color favorito del nuevo empleado: ");
                        String colorFavorito = sc.next();

                        int tipo;
                        boolean nomas = false;
                        do {
                            System.out.println("\n1. Gerente\n2. Aseador\n3. Cajero\n1. Seguridad");
                            System.out.print("Ingrese el cargo del empleado: ");
                            tipo = sc.nextInt();

                            if (contadorGerentes == 3) {
                                System.out.println("No se puede contratar otro gerente.");
                                nomas = true;
                            }

                        } while (tipo < 1 || tipo > 4 || nomas);

                        String genero = sexo == 1 ? "Masculino" : "Femenino";

                        Empleado empleado = new Empleado(colorFavorito, edad, genero, altura, peso, titulo, tipo, nombre, apellido);

                        emp.add(empleado);

                        break;

                    //////////////////////////////////////////////////
                    case 2:
                        //Despedir empleados
                        listarTodos();
                        System.out.print("Ingrese el número del empleado que se desea despedir: ");
                        int pos = sc.nextInt();

                        if (pos < 1 || pos > emp.size()) {
                            System.out.println("\nNo ha ingresado un empleado válido.");
                        } else {

                            int posreal = recorrerLista(pos);

                            emp.remove(posreal);
                            System.out.println("\n¡Empleado despedido con éxito!");
                        }

                        break;

                    //////////////////////////////////////////////////
                    case 3:
                        System.out.println("Usted ya inició sesión.");
                        break;

                    case 4:
                        //Ascender Cajero

                        if (contadorGerentes<3) {
                            int i = listarCategoria("Cajero", 1);
                            System.out.print("Ingrese el número del cajero que desee ascender a gerente: ");
                            int posicion = sc.nextInt();

                            if (posicion < 1 || posicion > contadorCajeros) {
                                System.out.println("\nNo ha ingresado un empleado válido.");
                            } else {

                                int posreal = recorrerLista(posicion, "Cajero");

                                emp.get(posreal).setCargo("Gerente");

                                System.out.println("\n¡Empleado ascendido con éxito!");
                            }
                        } else {
                            System.out.println("No se puede ascender a un cajero en este momento. Ya hay gerentes suficientes.");
                        }

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
                sc.nextLine();
                String contra = sc.nextLine();

                if (usuario.equals("leobanegas") && contra.equals("99")) {
                    System.out.println("\nSesión iniciada exitosamente.");
                    loggedIn = true;
                } else {
                    System.out.println("\nUsuario o contraseña incorrectos. No se ha iniciado la sesión.");
                }

            } else {
                System.out.println("Aún no has iniciado sesión.");
            }

            //Fin del ciclo principal
        } while (opcion != 0);

    }//Fin main

    public static void listarTodos() {

        int i;
        i = listarCategoria("Gerente", 1);
        i = listarCategoria("Aseador", i);
        i = listarCategoria("Cajero", i);
        i = listarCategoria("Seguridad", i);

    }

    public static int listarCategoria(String tipo, int inicio) {

        System.out.println("Cargo - " + tipo + ":");
        System.out.printf("%19s%15s%17s%n", "Nombre", "Apellido", "Salario");
        for (Empleado empleado : emp) {
            if (empleado.getCargo().equals(tipo)) {
                System.out.printf("%2d. %15s%15sLps. %.2f%n", inicio, (empleado.getNombre()), (empleado.getApellido()), (empleado.getSalario()));
                inicio++;
            }
        }
        System.out.println();

        return inicio;
    }

    public static int recorrerLista(int i) {

        int j = 0;
        for (Empleado e : emp) {
            if (e.getCargo().equals("Gerente")) {
                j++;
            }

            if (j == i) {
                return emp.indexOf(e);
            }

        }
        for (Empleado e : emp) {
            if (e.getCargo().equals("Aseador")) {
                j++;
            }

            if (j == i) {
                return emp.indexOf(e);
            }

        }
        for (Empleado e : emp) {
            if (e.getCargo().equals("Cajero")) {
                j++;
            }

            if (j == i) {
                return emp.indexOf(e);
            }

        }
        for (Empleado e : emp) {
            if (e.getCargo().equals("Seguridad")) {
                j++;
            }

            if (j == i) {
                return emp.indexOf(e);
            }

        }

        return j;
    }

    public static int recorrerLista(int i, String tipo) {

        int j = 0;
        for (Empleado e : emp) {
            if (e.getCargo().equals(tipo)) {
                j++;
            }

            if (j == i) {
                return emp.indexOf(e);
            }

        }

        return j;
    }

}
