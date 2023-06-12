package AccesoADatos.Modelo.BDPersonal;

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
public class departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_dep;
    String nombre;
    String localidad;

    @OneToMany()
    @JoinColumn(name = "id_emp")
    List<empleado> empleados;

    @Override
    public String toString() {
        return "departamento{" +
                "id_dep=" + id_dep +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}
