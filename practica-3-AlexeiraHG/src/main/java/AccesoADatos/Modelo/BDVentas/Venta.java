package AccesoADatos.Modelo.BDVentas;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_venta;
    Date fecha;
    int cantidad;


    @OneToOne
    @JoinColumn(name = "id_cliente")
    @NonNull
            Cliente cliente;
    @OneToMany
    @JoinColumn(name = "id_producto")
    @NonNull
            List<Producto> productos;
}
