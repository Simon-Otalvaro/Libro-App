package GestionLibros;

import java.util.ArrayList;
import java.util.List;

public class LibroRepositoryImpl implements LibroRepository {
    private List<Libro> libros;

    public LibroRepositoryImpl() {
        libros = new ArrayList<>();
    }

    @Override
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro);
    }

    @Override
    public Libro obtenerLibro(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        System.out.println("Libro no encontrado.");
        return null;
    }

    @Override
    public List<Libro> obtenerTodosLosLibros() {
        return libros;
    }

    @Override
    public void actualizarLibro(Libro libro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == libro.getId()) {
                libros.set(i, libro);
                System.out.println("Libro actualizado: " + libro);
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    @Override
    public void eliminarLibro(int id) {
        libros.removeIf(libro -> libro.getId() == id);
        System.out.println("Libro con ID " + id + " eliminado.");
    }
}
