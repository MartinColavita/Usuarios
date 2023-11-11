package com.modulo.usuarios.api.models.response;

import lombok.Data;
import java.util.List;

@Data
public class MailResponseDTO {
    private String destinatarios;
    private String asunto;
    private String mensaje;

}
