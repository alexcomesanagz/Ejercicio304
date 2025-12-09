package Entidades;

import jakarta.persistence.*;
import lombok.*;

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
    @NonNull
    private String dniAutor;
    @Column(name = "nombreAutor")
    @NonNull
    private String nombreAutor;
    @Column(name = "nacionalidad")
    @NonNull
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

    @Override
    public String toString(){
        return "{DNI: " + dniAutor + ", Nombre: " + nombreAutor + ", Nacionalidad: " + nacionalidad + "}";
    }

}
