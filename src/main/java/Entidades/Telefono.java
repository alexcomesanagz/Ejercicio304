package Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Telefonos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Telefono {

    @Id
    @OneToOne
    @JoinColumn(name = "dniAutor")
    private Autor autor;

    @Column(name = "numeroTf")
    private int numeroTf;

}
