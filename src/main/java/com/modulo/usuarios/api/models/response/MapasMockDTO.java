package com.modulo.usuarios.api.models.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapasMockDTO {
    private String descripcion;
    private String latitud;
    private String longitud;
    private int cantDeas;
    private String mail;

}


