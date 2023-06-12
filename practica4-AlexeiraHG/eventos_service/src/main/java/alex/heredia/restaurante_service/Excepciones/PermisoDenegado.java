package alex.heredia.restaurante_service.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class PermisoDenegado extends RuntimeException {

    public PermisoDenegado() {
        super("Error: método no permitido para este usuario");

    }

}
