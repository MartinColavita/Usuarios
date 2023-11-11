package com.modulo.usuarios.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum TelefonosEnum {
    POLICIA("Policia",101),
    BOMBEROS("Bomberos",100),
    EMERGENCIAS("Emergencias",911);

    private String descripcion;
    private int numero;

}
