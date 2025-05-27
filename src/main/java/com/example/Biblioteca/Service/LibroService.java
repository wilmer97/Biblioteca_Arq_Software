package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Libro;
import java.util.List;
import java.util.Optional;

public interface LibroService {

    List<Libro> findAllLibros();

    Optional<Libro> findLibroById(Long idLibro);

    Libro saveLibro(Libro libro);

    void updateLibro(Long idLibro, Libro libro);

    void deleteLibroById(Long idLibro);

}
