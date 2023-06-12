package AccesoADatos.Modelo.BDVentas;

import AccesoADatos.Modelo.BDPersonal.departamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nombre;
    String direccion;
    String poblacion;
    String telef;
    @Column(unique = true)
    String nif;

    @OneToMany
    @JoinColumn (name = "id_venta")
    List<Venta> ventas;

}
