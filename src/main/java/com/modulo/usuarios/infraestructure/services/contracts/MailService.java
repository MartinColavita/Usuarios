package com.modulo.usuarios.infraestructure.services.contracts;


import com.modulo.usuarios.api.models.request.MailRequestDTO;

public interface MailService {
   void enviarMail(MailRequestDTO mailRequestDTO);

}
