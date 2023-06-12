package alex.heredia.restaurante_service.Modelo;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Platos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Nombre;

    private String Descripcion;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ingredientes> Ingredientes;

}