package alex.heredia.restaurante_service.Modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Ingredientes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Nombre;
    private String Cantidad;

}