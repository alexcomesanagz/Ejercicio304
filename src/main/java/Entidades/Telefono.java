package Entidades;

import jakarta.persistence.*;
import lombok.*;

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
    @NonNull
    private int numeroTf;

}
