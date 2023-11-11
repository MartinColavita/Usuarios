package com.modulo.usuarios.api.controllers;


import com.modulo.usuarios.api.models.response.ListaTelefnosResponseDTO;
import com.modulo.usuarios.utils.enums.TelefonosEnum;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/telefonos")
public class TelefnosUtilesController {


    @GetMapping("/")
    public List<ListaTelefnosResponseDTO> telefonosUtiles(){
        return setData();
    }

    private List<ListaTelefnosResponseDTO> setData() {
        var dataL = List.of(
                new ListaTelefnosResponseDTO(TelefonosEnum.POLICIA.getDescripcion(), TelefonosEnum.POLICIA.getNumero()),
                new ListaTelefnosResponseDTO(TelefonosEnum.BOMBEROS.getDescripcion(), TelefonosEnum.BOMBEROS.getNumero()),
                new ListaTelefnosResponseDTO(TelefonosEnum.EMERGENCIAS.getDescripcion(), TelefonosEnum.EMERGENCIAS.getNumero()) );
        return dataL;
    }




}
