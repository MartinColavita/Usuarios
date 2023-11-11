package com.modulo.usuarios.api.controllers;


import com.modulo.usuarios.api.models.response.MapasMockDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/mapas")
public class MapasController {


    @GetMapping("/")
    public List<MapasMockDTO> mapaDeas(){
        return setData();
    }

    private List<MapasMockDTO> setData() {
        List<MapasMockDTO> dataL = List.of(
                // casa curuchet : -34.91113847812809, -57.94185454750093
                new MapasMockDTO(    "Casa Curuchet", "-34.91113847812809", "-57.94185454750093", 1,"martincolavita@gmail.com"),
                // ruta mas cerca Cerveceria modelo - -34.91473870508644, -57.94480554519492
                new MapasMockDTO("Cerveceria modelo", "-34.91473870508644", "-57.94480554519492", 3,"martincolavita@gmail.com"),
                // facultad de arquitectura: -34.904616823033216, -57.94249395281996
                new MapasMockDTO("Facultad de Arquitectura", "-34.904616823033216", "-57.94249395281996", 5,"martincolavita@gmail.com"),
                // ingenieria: -34.90735060788455, -57.944713758526575
                new MapasMockDTO("Facultad de Ingenieria", "-34.90735060788455,", "-57.944713758526575", 2,"martincolavita@gmail.com"),
                // odontologia: -34.90880520640244, -57.94262508736259
                new MapasMockDTO("Facultad de Odontologia", "-34.90880520640244", "-57.94262508736259", 7,"martincolavita@gmail.com"),
                // ruta mas lejos los hornos -34.959884782196184, -57.97218895430318
                new MapasMockDTO("Los Hornos", "-34.959884782196184", "-57.97218895430318", 4,"martincolavita@gmail.com"),
                // otra provincia - peña balderrama salta: -24.792749538540107, -65.41893884545162
                 new MapasMockDTO("Peña Balderrama", "-24.792749538540107", "-65.41893884545162", 6,"martincolavita@gmail.com")
        );
        return dataL;
    }


/*    *//**devuelve una lista de direcciones de correo electrónico para utilizar en el envio de mails *//*
    @GetMapping("/destinatarios")
    public List<String> obtenerDestinatarios() {
        return setData().stream()
                .map(MapasMockDTO::getMail)
                .collect(Collectors.toList());
    }*/


}
