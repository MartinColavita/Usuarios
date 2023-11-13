package com.modulo.usuarios.api.controllers;


import com.modulo.usuarios.api.models.response.MapasDTO;
import com.modulo.usuarios.infraestructure.services.contracts.MapasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/mapas")
public class MapasController {

    @Autowired
    private MapasService mapasService;

    @GetMapping("/")
    public List<MapasDTO> mapaDeas() {
        log.info("#### Comienza endpoint: /mapas ####");
        return mapasService.getMapasData();
    }


}
