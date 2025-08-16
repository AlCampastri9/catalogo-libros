package com.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String idioma;
    private int descargas;

    public Libro() {}

    public Libro(String titulo, String autor, String idioma, int descargas) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.descargas = descargas;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIdioma() { return idioma; }
    public int getDescargas() { return descargas; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public void setDescargas(int descargas) { this.descargas = descargas; }

    @Override
    public String toString() {
        return "📖 " + titulo + " | Autor: " + autor + " | Idioma: " + idioma + " | Descargas: " + descargas;
    }
}
