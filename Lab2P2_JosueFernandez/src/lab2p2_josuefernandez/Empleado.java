/*
 * Clase para el Objeto Empleado (Laboratorio 2, P2)
 */
package lab2p2_josuefernandez;

/**
 *
 * @author Josué Fernández
 */
public class Empleado {
    
    //Atributos
    private static String nombre;
    private static String apellido;
    private static String colorFavorito;
    private int edad;
    private String genero;
    private float altura;
    private float peso;
    private String titulo;
    private String cargo;
    private float salario;

    public Empleado(String colorFavorito, int edad, String genero, float altura, float peso, String titulo, int tipo, String nombre, String apellido) {
        this.colorFavorito = colorFavorito;
        this.edad = edad;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.titulo = titulo;
        this.nombre = nombre;
        this.apellido = apellido;
        
        switch(tipo){
            case 1:
                this.cargo = "Gerente";
                this.salario = 50000f;
                LabP2_JosueFernandez.contadorGerentes++;
                break;
            case 2:
                this.cargo = "Aseador";
                this.salario = 30000f;
                LabP2_JosueFernandez.contadorCajeros++;
                break;
            case 3:
                this.cargo = "Cajero";
                this.salario = 40000f;
                break;
            case 4:
                this.cargo = "Seguridad";
                this.salario = 38000f;
                break;
            default:
                System.out.println("BUG");
        }
        
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Empleado.nombre = nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static void setApellido(String apellido) {
        Empleado.apellido = apellido;
    }

    public String getColorFavorito() {
        return colorFavorito;
    }

    public void setColorFavorito(String colorFavorito) {
        this.colorFavorito = colorFavorito;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Color favorito: " + colorFavorito + ", Edad: " + edad + ", Genero: " + genero + ", Altura: " + altura + " m, Peso: " + peso + " lb, Titulo: " + titulo + ", Cargo: " + cargo + ", Salario: " + salario;
    }
    
}