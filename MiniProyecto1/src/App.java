import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class App {
    static ArrayList <Cliente> lista_clientes = new ArrayList<Cliente>();
    

    public static void list_clients(){
        System.out.println("Lista de clientes");

        //cantidad de clientes en la lista 
        byte x = 1;
        for (Cliente cliente : lista_clientes){
            System.out.println("Cliente " + x++ + " : " + cliente.getNombre() + " - " + cliente.getCedula());
        }
    }


    //Metodo para crear clientes y guardarlos en una lista de cliantes
    public static void create_client(){
        Scanner data = new Scanner(System.in);
        Cliente cliente = new Cliente(null, null, 0, null);
        
        System.out.println("Bienvenido nuevo cliente\nIngrese sus datos:");
        System.out.println("Nombre:");
        cliente.setNombre(data.next());
        
        System.out.println("Cedula:");
        cliente.setCedula(data.next());
        
        System.out.println("Ingresos iniciales:");
        cliente.setIngresos(data.nextLong());
       
        System.out.println("Fecha de creacion");
        /*EDITAR LUEGO SI ES NECCESARIO*/
       
        cliente.setFecha();
        System.out.println(cliente.getFecha());
       
        lista_clientes.add(cliente);
    }




    //Metodo menu para moverse entre otras funciones
    public static void menu(){
        Boolean x = true;
        while(x){
            System.out.println("Bienvenido al banco HOGAR SIN FAMILIA\n1. Para crear nuevo cliante\n2. Listar clientes\n3. Buscar cliente y ver su ahorro\n4. Ingresar al sub menu de cliente\n5. Salir");
            Scanner scanner = new Scanner(System.in);
            byte opc = scanner.nextByte();
            switch (opc) {
                case 1: create_client();  break;
                case 2:  list_clients();  break;
                case 3:             break;
                case 4:             break;
                case 5: x = false;  break;
                default:System.out.println("Ingrese un valor valido");break;
            }
        }
    }



    public static void main(String[] args) throws Exception {
        menu();
    
    
    }
}
