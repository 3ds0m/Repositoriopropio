import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final ArrayList<Cliente> listaClientes = new ArrayList<>();
        final HashMap<Integer, Cliente> mapaClientes = new HashMap<>();
        final ArrayList<Venta> listaVentas = new ArrayList<>();
        final HashMap<Venta, Integer> mapaVentas = new HashMap<>();
        Libros[] libros = new Libros[3];
        // Inicializar cada elemento del array con un nuevo objeto Libros
        libros[0] = new Libros(100, "libro2", "autor1", 1);
        libros[1] = new Libros(200, "libro1", "autor2", 2);
        libros[2] = new Libros(300, "libro3", "autor3", 3);
        boolean salir = false;

        while (!salir) {
            System.out.println("""
                    1. Para crear un nuevo cliente
                    2. Para buscar un cliente
                    3. Para actualizar un cliente
                    4. Para eliminar un cliente
                    5. Para guardar ventas de un cliente
                    6. Para calcular el precio total de compras de un cliente
                    7. Para buscar una venta especifica
                    25. Para salir.""");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> Tienda.CrearCliente(listaClientes, mapaClientes, sc);
                case 2 -> Tienda.BuscarCliente(sc,listaClientes,mapaClientes);
                case 3 -> Tienda.ActualizarCliente(sc,mapaClientes);
                case 4 -> Tienda.EliminarCliente(sc,listaClientes,mapaClientes);
                case 5 -> Tienda.GuardarVenta(sc,listaVentas, mapaClientes, mapaVentas);
                case 6 -> Tienda.ObtenertotaldePrecioVentas(sc, mapaClientes,mapaVentas);
                case 7 -> ClienteOnline.seguimientoEnvio(sc, mapaClientes,mapaVentas);
                case 25 -> {
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                }

                case 15 ->{
                    //Parametro precio ficticio obtenido del grupo libros.
                    int precio = 50;
                    ClienteVIP.aplicarDescuentoVIP(precio);
                    ClienteVIP.accesoServicioPersonalizado();
                }
                default -> System.out.println("Opcion no valida");
            }
        }
    }
}
