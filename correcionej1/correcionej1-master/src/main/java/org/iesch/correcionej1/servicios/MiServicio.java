package org.iesch.correcionej1.servicios;

import org.iesch.correcionej1.modelos.Coche;
import org.iesch.correcionej1.modelos.Moto;

import java.util.HashMap;
import java.util.Map;

public class MiServicio {
    public static Map<String, String> calculaPFcoche(Coche coche) {
        double pf = Math.pow(((double) coche.getCilindrada() / (double) coche.getClindros()), 0.06d) * 0.08 * coche.getClindros();
        Map<String, String> calculo = new HashMap<>();
        calculo.put("Potencia Fiscal: ", pf + "");
        return calculo;
    }

    public static Map<String, String> calculaPFmoto(Moto moto) {
        double pf;
        if ((int) moto.getTiempo() == 2) {
            pf = 0.08 * Math.pow(moto.getCilindrada() / moto.getCilindros(), 0.6d) * moto.getCilindros();
        } else {
            pf = 0.11 * Math.pow(moto.getCilindrada() / moto.getCilindros(), 0.6d) * moto.getCilindros();
        }
        Map<String, String> calculo = new HashMap<>();
        calculo.put("Potencia Fiscal: ", pf + "");
        return calculo;
    }
}
