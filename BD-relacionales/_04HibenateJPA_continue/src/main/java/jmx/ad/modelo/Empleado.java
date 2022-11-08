package jmx.ad.modelo;

import lombok.*;

//import javax.persistence.*; peta por que no funciona en hibernate 6
import jakarta.persistence.*; /*Trabaja con hibernate 6*/

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(
        name = "empleado",
        uniqueConstraints = @UniqueConstraint(
                name = "dni_unico",
                columnNames = {"dni"}
        )
)
@NamedQuery(name = "Empleado.porDepartamentoNombre", query = "select e from empleado Where e.departamento.nombre = ?1")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;

    @ManyToOne
    private Departamento departamento;


}
