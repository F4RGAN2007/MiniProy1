import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class App {
    static ArrayList <Cliente> lista_clientes = new ArrayList<Cliente>();
    
    public static void delete_client() {
        System.out.println("Eliminar un cliente");
        System.out.println("Ingrese el número de cédula del cliente para eliminar: ");
        Scanner data = new Scanner(System.in);
        String cedula_buscar = data.next();

        boolean clientnotfound = true;//se determina que el cliente no existe por defecto
        for(Cliente clientebuscar : lista_clientes){
            if(cedula_buscar.equals(clientebuscar.getCedula())){
                lista_clientes.remove(clientebuscar);
                System.out.println("Cliente eliminado con éxito");
                clientnotfound = false;//cuando lo encuentra cambia su valor
                break;
            }
        }
        if(clientnotfound){
            System.out.println("Cliente no encontrado");
        }
    }

//metodo para buscar clientes por cedula
    public static void search_cliente() {
        System.out.println("Buscar un cliente");
        System.out.println("Ingrese el número de cédula del cliente para ver su ahorro: ");
        Scanner data = new Scanner(System.in);
        String cedula_buscar = data.next();

        boolean clientnotfound = true;//se determina que el cliente no existe por defecto
        for(Cliente clientebuscar : lista_clientes){
            if(cedula_buscar.equals(clientebuscar.getCedula())){
                System.out.println("El cliente " + clientebuscar.getNombre() + " tiene un ahorro de " + clientebuscar.getAhorro());
                clientnotfound = false;//cuando lo encuentra cambia su valor
                break;
            }
        }
        if(clientnotfound){
            System.out.println("Cliente no encontrado");
        }
    }


    public static void list_clients(){
        System.out.println("Lista de clientes");

        //cantidad de clientes en la lista 
        byte x = 1;
        for (Cliente cliente : lista_clientes){
            System.out.println("Cliente " + x++ + " : " + cliente.getNombre() + " - " + cliente.getCedula());
        }
    }

    //Metodo para crear clientes y guardarlos en una lista de clientes
    public static void create_client(){
        Scanner data = new Scanner(System.in);
        Cliente cliente = new Cliente(null, null,0 ,0, null);
        
        System.out.println("Bienvenido nuevo cliente\nIngrese sus datos: ");
        System.out.println("Nombre: ");
        cliente.setNombre(data.next());
        
         //Condicional/bucle que determina si un cliente ya fue creado con ese numero de cedula
         Boolean repetido;
         while(true){
             repetido = false;
             System.out.println("Cédula: ");
             String nuevacedula = data.next();//se crea la nueva cedula para comparar
             for (Cliente cliente2 : lista_clientes){
                 if (nuevacedula.equals(cliente2.getCedula())){
                     repetido = true;//se encuentra similitud y mantiene el bucle
                     break;
                 }
         }
             if(repetido){
                 System.out.println("Ese número de cédula ya está en uso");
             }else{
                 cliente.setCedula(nuevacedula);
                 break;
             }
         }
 
        System.out.println("Nivel de ingresos (mensual): ");
        cliente.setIngresos(data.nextInt());
       
        System.out.println("Fecha de creación: ");
       
        cliente.setFecha();
        System.out.println(cliente.getFecha());
       
        lista_clientes.add(cliente);
        System.out.println("Cliente creado con ¡Éxito! Ingrese sus ahorros en el submenú");
    }

    //Metodo para agregar dinero ahorrado
    public static void agregarDinero(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cédula del cliente: ");
        String cedula = scanner.nextLine();
        System.out.println("Ingrese el monto a insertar: ");
        long monto = scanner.nextLong();
        scanner.nextLine();
        boolean clienteEncontrado = false;
        for (Cliente cliente : lista_clientes) {
            if (cliente.getCedula().equals(cedula)){
                cliente.setAhorro(monto + cliente.getAhorro());
                System.out.println("Monto agregado correctamente.\n Nuevo saldo: "+ cliente.getAhorro());
                clienteEncontrado = true;
                break;
            }
        }
        if (!clienteEncontrado){
            System.out.println("El cliente no existe :(");
        }
    }

    //Metodo para quitar dinero ahorrado
    public static void quitarDinero(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cédula del cliente: ");
        String cedula = scanner.nextLine();
        System.out.println("Ingrese el monto a retirar: ");
        long monto = scanner.nextLong();
        scanner.nextLine();
        boolean clienteEncontrado = false;
        for (Cliente cliente : lista_clientes){
            if (cliente.getCedula().equals(cedula)){
                if (monto <= cliente.getAhorro()){
                    cliente.setAhorro(cliente.getAhorro() - monto);
                    System.out.println("Monto retirado exitosamente.\n Nuevo saldo: "+cliente.getAhorro());
                } else {
                    System.out.println("El dinero que quiere retirar excede su saldo hermano, intente de nuevo");
                }
                clienteEncontrado = true;
                break;
            }
        }
        if (!clienteEncontrado){
            System.out.println("El cliente no existe :(");
        }
    }

    //Metodo para actualizar ahorros
    public static void actualizarAhorros(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cédula del cliente: ");
        String cedula = scanner.nextLine();
        System.out.println("Ingrese el nuevo monto: ");
        long monto = scanner.nextLong();
        scanner.nextLine();
        boolean clienteEncontrado = false;
        for(Cliente cliente : lista_clientes){
            if(cliente.getCedula().equals(cedula)){
                cliente.setAhorro(monto);
                System.out.println("Monto actualizado correctamente :D");
                clienteEncontrado = true;
                break;
            }
        }
        if (!clienteEncontrado) {
            System.out.println("El cliente no existe :(");
        }
    }

    //Metodo para pedir prestamo
    public static void prestamo(){

    }

    //Metodo para pedir CDT
    public static void pedirCDT(){
        System.out.println("CDT's Digitales banco HOGAR SIN FAMILIA");
        System.out.println("(1) -> CDT: CON HOGAR PERO SIN FAMILIA (3 MESES)\n(2) -> CDT: CON HOGAR Y CON FAMILIA (6 MESES)");
        System.out.println("Digita el número del CDT para ver más información");
        Scanner scanner = new Scanner(System.in);
        byte opc = scanner.nextByte();
        switch (opc) {
            case 1:
                System.out.println("\nCDT: CON HOGAR PERO SIN FAMILIA\nPLAZO: 3 Meses\nINTERÉS: 3% E.A");
                System.out.println("SALDO ACTUAL:"); //Falta el método agregarDinero para continuar
                System.out.println("SALDO DESPUÉS DEL CDT -> "); //Falta el método agregarDinero para continuar
                System.out.println("¿Deseas este producto? Contacta a un asesor: 602 227 777\n\n");
                break;
            case 2:
                System.out.println("\nCDT: CON HOGAR Y CON FAMILIA\nPLAZO: 6 Meses\nINTERÉS: 5% E.A");
                System.out.println("SALDO ACTUAL:"); //Falta el método agregarDinero para continuar
                System.out.println("SALDO DESPUÉS DEL CDT -> "); //Falta el método agregarDinero para continuar
                System.out.println("¿Deseas este producto? Contacta a un asesor: 602 227 777\n\n");
                break;

            default: System.out.println("Digita una opción válida");
                break;
        }
    }

    //Metodo submenú encargado de las operaciones con el dinero
    public static void submenu(){
        Boolean x = true;
        while(x){
            System.out.println("Submenú ahorros y prestamos HOGAR SIN FAMILIA\n1. Para agregar dinero ahorrado\n2. Para quitar dinero ahorrado\n3. Para actualizar el dinero ahorrado\n4. Para pedir un prestamo \n5. Para pedir CDT \n6. Volver");
            Scanner scanner = new Scanner(System.in);
            byte opc = scanner.nextByte();
            switch (opc) {
                case 1: agregarDinero(); break;
                case 2: quitarDinero(); break;
                case 3: actualizarAhorros(); break;
                case 4: prestamo(); break;
                case 5: pedirCDT(); break;
                case 6: x = false;  break;
                default:System.out.println("Ingrese un valor válido");break;
            }
        }
    }

    //Metodo menu para moverse entre otras funciones
    public static void menu(){
        Boolean x = true;
        while(x){
            System.out.println("Bienvenido al banco HOGAR SIN FAMILIA\n1. Para crear nuevo cliente\n2. Listar clientes\n3. Buscar cliente y ver su ahorro\n4. Ingresar al Submenú de ahorros y prestamos\n5. Eliminar cliente del banco\n6. Salir");
            Scanner scanner = new Scanner(System.in);
            byte opc = scanner.nextByte();
            switch (opc) {
                case 1: create_client(); break;
                case 2:  list_clients(); break;
                case 3:search_cliente(); break;
                case 4:       submenu(); break;
                case 5: delete_client(); break;
                case 6: x = false; break;
                default:System.out.println("Ingrese un valor valido");break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        menu();
    }
}
