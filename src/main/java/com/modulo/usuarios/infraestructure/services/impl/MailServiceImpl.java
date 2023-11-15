package com.modulo.usuarios.infraestructure.services.impl;

import com.modulo.usuarios.api.models.request.MailRequestDTO;
import com.modulo.usuarios.infraestructure.services.contracts.MailService;
import com.modulo.usuarios.utils.enums.MailsEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@Slf4j
@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;
    private final String envioMailgun;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender, @Value("${spring.mail.username}") String envioMailgun) {
        this.javaMailSender = javaMailSender;
        this.envioMailgun = envioMailgun;
    }

    @CrossOrigin(value = "*")
    @Override
    public void enviarMail(MailRequestDTO mailRequestDTO) {
        log.info("----> Comienza seteo de mail");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(envioMailgun);

        // Verificar si hay correos electrónicos en el DTO
        var emails = mailRequestDTO.getDestinatarios();
        log.info("Destinatarios: {}", emails);
        if (emails != null) {
            message.setTo(mailRequestDTO.getDestinatarios());
        } else {
            throw new RuntimeException("La lista de correos electrónicos está vacía en el DTO.");
        }
        message.setSubject(MailsEnum.ASUNTO.getValue());
        message.setText(MailsEnum.MENSAJE.getValue());

        log.info("----> llamado a javaMailSender");
        javaMailSender.send(message);
    }

}












