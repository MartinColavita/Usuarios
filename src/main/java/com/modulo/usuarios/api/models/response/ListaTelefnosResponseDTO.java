package com.modulo.usuarios.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class ListaTelefnosResponseDTO {
    private String descripcion;
    private int numero;

}
