package com.modulo.usuarios.api.controllers;


import com.modulo.usuarios.api.models.request.MailRequestDTO;
import com.modulo.usuarios.infraestructure.services.contracts.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/mails")
public class MailController {

    @Autowired
    MailService mailService;

    @PostMapping("/enviar-mail")
    public ResponseEntity<MailRequestDTO> envioMail(@RequestBody MailRequestDTO mailRequestDTO) {
        log.info("#### Comienza endpoint: /enviar-mail ####");
        mailService.enviarMail(mailRequestDTO);
        log.info("----> termina envio de mail");
        return new ResponseEntity<>(mailRequestDTO, HttpStatus.OK);
    }

}
