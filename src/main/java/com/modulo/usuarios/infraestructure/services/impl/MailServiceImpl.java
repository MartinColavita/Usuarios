package com.modulo.usuarios.infraestructure.services.impl;

import com.modulo.usuarios.api.models.response.MailResponseDTO;
import com.modulo.usuarios.infraestructure.services.contracts.MailService;
import com.modulo.usuarios.utils.enums.MailsEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    // TODO -> todo esto es mockiado conun solo mail, habria q hacer luego par una lista de mails
    @Override
    public void enviarMail(MailResponseDTO mailResponseDTO) {
        enviarCorreo(mailResponseDTO);
    }

    private void enviarCorreo(MailResponseDTO mailResponseDTO) {
        log.info("comienza el DTO");
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom("postmaster@sandbox4d1de417bd0348f3896185ff80da0369.mailgun.org");
        mensaje.setTo(mailResponseDTO.getDestinatarios());
        mensaje.setSubject(MailsEnum.ASUNTO.getValue());
        mensaje.setText(MailsEnum.MENSAJE.getValue());

        javaMailSender.send(mensaje);
    }

/*    private final RestTemplate restTemplate;  // RestTemplate para hacer solicitudes HTTP
    private final String apiExternaUrl;  // URL de la API externa

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender, RestTemplate restTemplate, @Value("${api.externa.url}") String apiExternaUrl) {
        this.javaMailSender = javaMailSender;
        this.restTemplate = restTemplate;
        this.apiExternaUrl = apiExternaUrl;
    }

    @Override
    public void enviarMail(MailResponseDTO mailResponseDTO) {
        List<String> destinatarios = obtenerDestinatariosDesdeApiExterna();
        mailResponseDTO.setDestinatarios(destinatarios);
        enviarCorreo(mailResponseDTO);
    }

    private List<String> obtenerDestinatariosDesdeApiExterna() {
        ResponseEntity<List<String>> response = restTemplate.exchange(
                apiExternaUrl + "/destinatarios",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                });

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            // Manejar el error o lanzar una excepción según tu necesidad
            return Collections.emptyList();
        }
    }

    private void enviarCorreo(MailResponseDTO mailResponseDTO) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom("postmaster@sandbox4d1de417bd0348f3896185ff80da0369.mailgun.org");
        mensaje.setTo(mailResponseDTO.getDestinatarios().toArray(new String[0]));
        mensaje.setTo(mailResponseDTO.getDestinatarios().toArray(new String[0]));
        mensaje.setSubject(MailsEnum.ASUNTO.getValue());
        mensaje.setText(MailsEnum.MENSAJE.getValue());

        javaMailSender.send(mensaje);
    }*/



}
