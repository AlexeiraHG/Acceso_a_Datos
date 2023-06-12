package alex.heredia.restaurante_service.Modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Ordenes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int mesa;

    private Date fecha;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Platos> Orden;

}
