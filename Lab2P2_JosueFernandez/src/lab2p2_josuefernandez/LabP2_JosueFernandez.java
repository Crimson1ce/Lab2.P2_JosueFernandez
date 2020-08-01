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

                if (contadorGerentes == 0 && opcion != 0) {
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

                        int edad;
                        do {
                            System.out.print("\nIngrese la edad del nuevo empleado: ");
                            edad = sc.nextInt();
                        } while (edad < 0);

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

                        if (contadorGerentes < 3) {
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

                        listarTodos();

                        System.out.print("Qué empleado desea modificar?: ");
                        int numeroEmpleado = sc.nextInt();

                        if (numeroEmpleado < 1 || numeroEmpleado > emp.size()) {
                            System.out.println("No ha escogido un empleado válido.");
                        } else {

                            int posreal = recorrerLista(numeroEmpleado);

                            System.out.println();
                            System.out.println("1. Nombre");
                            System.out.println("2. Apellido");
                            System.out.println("3. Edad");
                            System.out.println("4. Género");
                            System.out.println("5. Altura");
                            System.out.println("6. Peso");
                            System.out.println("7. Título");
                            System.out.println("8. Color Favorito");
                            System.out.println("9. Cargo\n");
                            System.out.print("¿Qué característica desea modificar?: ");
                            int carac = sc.nextInt();

                            switch (carac) {
                                case 1:

                                    System.out.print("Ingrese el nombre del empleado: ");
                                    emp.get(posreal).setNombre(sc.next());
                                    break;
                                case 2:
                                    System.out.print("\nIngrese el apellido del empleado: ");
                                    emp.get(posreal).setApellido(sc.next());
                                    break;
                                case 3:
                                    int ed;
                                    do {
                                        System.out.print("\nIngrese la edad del empleado: ");
                                        ed = sc.nextInt();
                                    } while (ed < 0);
                                    emp.get(posreal).setEdad(ed);
                                    break;
                                case 4:
                                    int sex;
                                    do {
                                        System.out.println("\n1. Masculino\n2. Femenino");
                                        System.out.print("Ingrese el género del empleado: ");
                                        sex = sc.nextInt();
                                    } while (sex != 1 && sex != 2);

                                    String gen = sex == 1 ? "Masculino" : "Femenino";

                                    emp.get(posreal).setGenero(gen);

                                    break;
                                case 5:

                                    float alt;
                                    do {
                                        System.out.print("\nIngrese la altura del empleado (en m): ");
                                        alt = sc.nextFloat();
                                    } while (alt <= 0);
                                    emp.get(posreal).setAltura(alt);
                                    break;

                                case 6:
                                    float pes;
                                    do {
                                        System.out.print("\nIngrese el peso del empleado (en lb): ");
                                        pes = sc.nextFloat();
                                    } while (pes <= 0);
                                    emp.get(posreal).setPeso(pes);
                                    break;
                                case 7:
                                    System.out.print("\nIngrese el título del empleado: ");
                                    emp.get(posreal).setTitulo(sc.next());
                                    break;
                                case 8:
                                    System.out.print("\nIngrese el color favorito del empleado: ");
                                    emp.get(posreal).setColorFavorito(sc.next());
                                    break;
                                case 9:
                                    int tip;
                                    boolean yanomas = false;
                                    do {
                                        System.out.println("\n1. Gerente\n2. Aseador\n3. Cajero\n1. Seguridad");
                                        System.out.print("Ingrese el cargo del empleado: ");
                                        tipo = sc.nextInt();

                                        if (contadorGerentes == 3) {
                                            System.out.println("No se puede contratar otro gerente.");
                                            yanomas = true;
                                        }

                                    } while (tipo < 1 || tipo > 4 || yanomas);

                                    //emp.get(posreal).set(sc.next());
                                    

                                    break;
                                default:
                            }

                        }

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
