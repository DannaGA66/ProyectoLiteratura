package com.alura.literalura.model;


import jakarta.persistence.*;

import java.util.List;



@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private Integer fecha_nacimiento;
    private Integer fecha_fallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libro;

    public Autor(){}

    public Autor(DatosAutor datosAutor){
        this.nombre=datosAutor.nombre();
        this.fecha_nacimiento = datosAutor.fechaNacimiento();
        this.fecha_fallecimiento = datosAutor.fechaFallecimiento();
    }

    @Override
    public String toString() {
        StringBuilder libros = new StringBuilder();
        libros.append("Libros : ");

        for(int i = 0; i < libro.size() ; i++) {
            libros.append(libro.get(i).getTitulo());
            if (i < libro.size() - 1 ){
                libros.append(", ");
            }
        }
        return String.format("********** Autor **********%nNombre:" +
                " %s%n%s%nFecha de nacimiento: %s%nFecha de fallecimiento:" +
                " %s%n*************************%n",nombre,libros.toString(),fecha_nacimiento,fecha_fallecimiento);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Integer fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getFecha_fallecimiento() {
        return fecha_fallecimiento;
    }

    public void setFecha_fallecimiento(Integer fecha_fallecimiento) {
        this.fecha_fallecimiento= fecha_fallecimiento;
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }
}
