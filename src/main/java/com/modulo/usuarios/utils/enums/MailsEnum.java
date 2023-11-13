package com.modulo.usuarios.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MailsEnum {
    ASUNTO("Usuario rumbo a la sede"),
    MENSAJE("El usuario se encuentra en camino a la sede en busca de un DEA, por favor aguardar su llegada y asistirlo.");

    private String value;

}
