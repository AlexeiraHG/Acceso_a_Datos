package AccesoADatos.Modelo.BDPersonal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_emp;
    String apellido;
    String oficio;
    Date fecha_alta;
    Float salario;
    Float comision;

    @ManyToOne
    departamento departamento;

    @Override
    public String toString() {
        return "empleado{" +
                "id_emp=" + id_emp +
                ", apellido='" + apellido + '\'' +
                ", oficio='" + oficio + '\'' +
                ", fecha_alta=" + fecha_alta +
                ", salario=" + salario +
                ", comision=" + comision +
                ", departamento=" + departamento.nombre +
                '}';
    }
}
