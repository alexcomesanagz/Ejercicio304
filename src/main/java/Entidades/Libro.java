package Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Libros", uniqueConstraints = @UniqueConstraint(columnNames = "titulo", name = "tituloUniqueConstraint"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor //NonNull
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLibro")
    private int idLibro;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "precio")
    private Double precio;

    @ManyToMany
    @JoinTable(
            name = "Libro_Autor",
            joinColumns = @JoinColumn(name = "idLibro"),
            inverseJoinColumns = @JoinColumn(name = "idAutor" )
    )
    private List<Autor> listaAutores;

    public void addListaAutores(Autor autor){
        this.listaAutores.add(autor);
        autor.addLibro(this);
    }

}
