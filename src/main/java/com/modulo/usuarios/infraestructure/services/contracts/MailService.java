package com.modulo.usuarios.infraestructure.services.contracts;


import com.modulo.usuarios.api.models.response.MailResponseDTO;

public interface MailService {
    void enviarMail(MailResponseDTO mailResponseDTO);

}
