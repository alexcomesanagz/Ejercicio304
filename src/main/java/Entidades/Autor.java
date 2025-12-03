package Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Autores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Autor {
    @Id
    @Column(name = "dniAutor")
    private String dniAutor;
    @Column(name = "nombreAutor")
    private String nombreAutor;
    @Column(name = "nacionalidad")
    private String nacionalidad;

    @OneToOne(mappedBy = "autor")
    private Telefono telefono;

    public void setTelefono(Telefono telefono){
        this.telefono = telefono;
        telefono.setAutor(this);
    }

    public void addLibro(Libro libro){
        this.listaLibros.add(libro);
    }

    @ManyToMany(mappedBy = "listaAutores")
    private List<Libro> listaLibros;

}
