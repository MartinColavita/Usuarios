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


    @Override
    public void enviarMail(MailRequestDTO mailRequestDTO) {
        log.info("----> Comienza seteo de mail");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(envioMailgun);

        // Verificar si hay correos electrónicos en el DTO
        List<String> emails = mailRequestDTO.getDestinatarios();
        log.info("Destinatarios: {}", emails);
        if (emails != null && !emails.isEmpty()) {
            // Si hay más de un correo electrónico
            if (emails.size() > 1) {
                // Convertir la lista de correos electrónicos a un array de Strings
                String[] emailsArray = emails.toArray(new String[0]);
                message.setTo(emailsArray);
            } else {
                // Si solo hay un correo electrónico
                message.setTo(emails.get(0));
            }
        } else {
            // Si no hay correos electrónicos
            throw new RuntimeException("La lista de correos electrónicos está vacía en el DTO.");
        }
        message.setSubject(MailsEnum.ASUNTO.getValue());
        message.setText(MailsEnum.MENSAJE.getValue());

        log.info("----> llamado a javaMailSender");
        javaMailSender.send(message);
    }

}












