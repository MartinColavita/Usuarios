package com.modulo.usuarios.api.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;


@AllArgsConstructor @NoArgsConstructor
@Builder
@Data
public class MailRequestDTO implements Serializable {
    private List<String> destinatarios;

}
