package com.modulo.usuarios.infraestructure.services.contracts;

import com.modulo.usuarios.api.models.response.MapasDTO;
import java.util.List;

public interface MapasService {
    List<MapasDTO> getMapasData();

}
