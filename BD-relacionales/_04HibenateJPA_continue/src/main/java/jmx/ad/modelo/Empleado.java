package jmx.ad.modelo;

import lombok.*;

import javax.persistence.*; //para la versión 5 de hibernate
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(
        name = "produc_serial_group_mask",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "dni"),
        }
)
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;


}
