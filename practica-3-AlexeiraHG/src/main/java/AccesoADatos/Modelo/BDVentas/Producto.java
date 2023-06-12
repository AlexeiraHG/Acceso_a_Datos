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
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String decripcion;
    int stockactual;
    int stockminimo;
    Float precio;

    @ManyToMany
    @JoinColumn (name = "id_venta")
    List<Venta> ventas;

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", decripcion='" + decripcion + '\'' +
                ", stockactual=" + stockactual +
                ", stockminimo=" + stockminimo +
                ", precio=" + precio +
                '}';
    }
}
