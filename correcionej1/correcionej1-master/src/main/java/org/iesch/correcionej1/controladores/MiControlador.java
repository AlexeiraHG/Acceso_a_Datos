package org.iesch.correcionej1.controladores;

import org.iesch.correcionej1.modelos.Coche;
import org.iesch.correcionej1.modelos.Moto;
import org.iesch.correcionej1.servicios.MiServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MiControlador {
    @GetMapping("/saluda")
    public Map Saluda() {
        Map<String, String> contenido = new HashMap<>();
        contenido.put("Contenido", "Bienvenido al servicio de caluclo de ITMV");
        return contenido;
    }

    @PostMapping("/calculoPFcoche")
    public ResponseEntity<?> calculaCoche(@RequestBody Coche coche){
        Map<String,String> calculo = MiServicio.calculaPFcoche(coche);
        return ResponseEntity.ok(calculo);
    }

    @PostMapping("/calculoPFmote")
    public ResponseEntity<?> calculaMoto(@RequestBody Moto moto){
        Map<String,String> calculo = MiServicio.calculaPFmoto(moto);
        return ResponseEntity.ok(calculo);
    }
}
