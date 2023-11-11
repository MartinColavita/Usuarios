package com.modulo.usuarios.api.controllers;


import com.modulo.usuarios.api.models.response.MailResponseDTO;
import com.modulo.usuarios.infraestructure.services.contracts.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/mails")
public class MailController {

    @Autowired
    MailService mailService;

    @PostMapping("/enviar-mail")
    public void envioMail(@RequestBody MailResponseDTO mailResponseDTO) {
        log.info("comienza envio de mail");
        mailService.enviarMail(mailResponseDTO);
        log.info("termina envio de mail");
    }


}
