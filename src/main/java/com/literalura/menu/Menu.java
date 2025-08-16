package com.literalura.menu;

import com.literalura.model.Libro;
import com.literalura.service.LibroService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Menu {

    private final LibroService libroService;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(LibroService libroService) {
        this.libroService = libroService;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== 📚 Menú Literalura =====");
            System.out.println("1. Agregar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Buscar libros por idioma");
            System.out.println("0. Salir");
            System.out.print("👉 Elige una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarLibro();
                case 2 -> listarLibros();
                case 3 -> buscarPorAutor();
                case 4 -> buscarPorIdioma();
                case 0 -> System.out.println("👋 Saliendo...");
                default -> System.out.println("⚠️ Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void agregarLibro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Idioma: ");
        String idioma = scanner.nextLine();
        System.out.print("Número de descargas: ");
        int descargas = scanner.nextInt();
        scanner.nextLine();

        Libro libro = new Libro(titulo, autor, idioma, descargas);
        libroService.guardar(libro);
        System.out.println("✅ Libro agregado con éxito!");
    }

    private void listarLibros() {
        List<Libro> libros = libroService.listarTodos();
        if (libros.isEmpty()) {
            System.out.println("⚠️ No hay libros cargados.");
        } else {
            libros.forEach(System.out::println);
        }
    }

    private void buscarPorAutor() {
        System.out.print("Ingrese nombre del autor: ");
        String autor = scanner.nextLine();
        List<Libro> libros = libroService.buscarPorAutor(autor);
        libros.forEach(System.out::println);
    }

    private void buscarPorIdioma() {
        System.out.print("Ingrese idioma (ej: es, en, fr): ");
        String idioma = scanner.nextLine();
        List<Libro> libros = libroService.buscarPorIdioma(idioma);
        libros.forEach(System.out::println);
    }
}
