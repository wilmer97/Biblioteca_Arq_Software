package com.example.Biblioteca.Controller;

import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/")
    public String listarTodosLosLibros(Model model) {
        model.addAttribute("libros", libroService.findAllLibros());
        return "/listaLibros";
    }

    @GetMapping("/nuevoLibro")
    public String registrarNuevoLibro() {
        return "/registrarLibro";
    }

    @PostMapping("/guardarLibro")
    public String guardarLibro(Libro libro){
        libroService.saveLibro(libro);
        return "redirect:/";
    }

    @GetMapping("/editarLibro/{id}")
    public String editarLibro(@PathVariable Long id, Model model) {
        Libro libro = libroService.findLibroById(id).get();
        model.addAttribute("libro",libro);
        return "/editarLibro";
    }

    @PostMapping("/actualizarLibro")
    public String actualizarLibro(@RequestParam("idLibro") Long id, Libro libro) {
        libroService.updateLibro(id, libro);
        return "redirect:/";
    }

    @GetMapping("/eliminarLibro/{id}")
    public String eliminarLibro (@PathVariable Long id) {
        libroService.deleteLibroById(id);
        return "redirect:/";
    }
}
