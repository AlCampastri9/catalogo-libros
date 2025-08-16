package com.literalura.dto;

public class LibroDTO {
    private String titulo;
    private String autor;
    private String idioma;
    private int descargas;

    public LibroDTO() {}

    public LibroDTO(String titulo, String autor, String idioma, int descargas) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.descargas = descargas;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIdioma() { return idioma; }
    public int getDescargas() { return descargas; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public void setDescargas(int descargas) { this.descargas = descargas; }
}
