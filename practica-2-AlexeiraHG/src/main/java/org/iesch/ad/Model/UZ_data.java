package org.iesch.ad.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UZ_data implements Comparable<UZ_data>{

    private String TIPO_ESTUDIO;
    private String ESTUDIO;
    private String LOCALIDAD;
    private String ASIGNATURA;
    private String CLASE_ASIGNATURA;
    private String CENTRO;
    private Double TASA_EXITO;
    private Integer ALUMNOS_PRESENTADOS;


    @Override
    public int compareTo(UZ_data o) {
        return 0;
    }
}
