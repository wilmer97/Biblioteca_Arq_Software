package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService{

    @Autowired
    private LibroRepository libroRepository;


    @Override
    public List<Libro> findAllLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro> findLibroById(Long idLibro) {
        return libroRepository.findById(idLibro);
    }

    @Override
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void updateLibro(Long idLibro, Libro libro) {
        Libro libroBd = findLibroById(idLibro).get();
        libroBd.setTitulo(libro.getTitulo());
        libroBd.setAutor(libro.getAutor());
        libroBd.setIsbn(libro.getIsbn());
        libroRepository.save(libro);
    }

    @Override
    public void deleteLibroById(Long idLibro) {
        libroRepository.deleteById(idLibro);
    }
}
