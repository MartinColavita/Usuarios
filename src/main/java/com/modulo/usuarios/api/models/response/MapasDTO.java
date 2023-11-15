package com.modulo.usuarios.api.models.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapasDTO {
    private Double latitude;
    private Double longitude;
    private String name;
    private Long id;
    private String emails;

}


