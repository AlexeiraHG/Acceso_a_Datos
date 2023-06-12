package alex.heredia.restaurante_service.Modelo;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Menus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Titulo;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Platos> Platos;

}
