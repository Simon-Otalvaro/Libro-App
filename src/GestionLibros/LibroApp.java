package GestionLibros;

import java.util.Scanner;

public class LibroApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibroRepository libroRepository = new LibroRepositoryImpl();

        boolean salir = false;

        while (!salir) {
            System.out.println("\n---- Menú de Gestión de Libros ----");
            System.out.println("1. Agregar libro");
            System.out.println("2. Obtener libro por ID");
            System.out.println("3. Mostrar todos los libros");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Agregar libro
                    System.out.print("Ingrese el ID del libro: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación: ");
                    int anioPublicacion = scanner.nextInt();
                    libroRepository.agregarLibro(new Libro(id, titulo, autor, anioPublicacion));
                    break;

                case 2:
                    // Obtener libro por ID
                    System.out.print("Ingrese el ID del libro que desea buscar: ");
                    int idBuscar = scanner.nextInt();
                    Libro libroEncontrado = libroRepository.obtenerLibro(idBuscar);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado: " + libroEncontrado);
                    }
                    break;

                case 3:
                    // Mostrar todos los libros
                    System.out.println("Lista de libros:");
                    for (Libro libro : libroRepository.obtenerTodosLosLibros()) {
                        System.out.println(libro);
                    }
                    break;

                case 4:
                    // Actualizar libro
                    System.out.print("Ingrese el ID del libro que desea actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingrese el nuevo título: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("Ingrese el nuevo autor: ");
                    String nuevoAutor = scanner.nextLine();
                    System.out.print("Ingrese el nuevo año de publicación: ");
                    int nuevoAnio = scanner.nextInt();
                    Libro libroActualizado = new Libro(idActualizar, nuevoTitulo, nuevoAutor, nuevoAnio);
                    libroRepository.actualizarLibro(libroActualizado);
                    break;

                case 5:
                    // Eliminar libro
                    System.out.print("Ingrese el ID del libro que desea eliminar: ");
                    int idEliminar = scanner.nextInt();
                    libroRepository.eliminarLibro(idEliminar);
                    break;

                case 6:
                    // Salir
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}

