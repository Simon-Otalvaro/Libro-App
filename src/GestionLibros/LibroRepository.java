package GestionLibros;

import java.util.List;

public interface LibroRepository {
    void agregarLibro(Libro libro);
    Libro obtenerLibro(int id);
    List<Libro> obtenerTodosLosLibros();
    void actualizarLibro(Libro libro);
    void eliminarLibro(int id);
}
