package alex.heredia.restaurante_service.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DatoInexistente extends RuntimeException {

    public DatoInexistente(Long id) {
        super("Error 404: No se ha encontrado el dato con id: " + id);
    }

}
