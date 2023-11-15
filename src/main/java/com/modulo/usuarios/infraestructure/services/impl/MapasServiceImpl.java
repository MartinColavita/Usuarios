package com.modulo.usuarios.infraestructure.services.impl;

import com.modulo.usuarios.api.models.response.MapasDTO;
import com.modulo.usuarios.infraestructure.services.contracts.MapasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@Service
public class MapasServiceImpl implements MapasService {

    /**JdbcTemplate es una clase proporcionada por el framework Spring para simplificar la ejecución de consultas SQL
     * y la manipulación de resultados en entornos JDBC (facilita el trabajo con bases de datos relacionales en entornos de Spring).*/
    @Autowired
    private JdbcTemplate jdbcTemplate;


    /** Consulta SQL para obtener los datos de los mapas (nombre, latitud, longitud y la lista con correos electrónicos dependiendo los responsables a cargo)*/
    private static final String SQL_QUERY_MAPAS = "SELECT c.latitude, c.longitude, c.name, c.id, ms.email AS emails " +
            "FROM campus c " +
            "JOIN sworn_declaration sd ON c.id = sd.campus_id " +
            "JOIN maintenance_staff ms ON sd.id = ms.declaration_id";

    @Override
    public List<MapasDTO> getMapasData() {
        List<MapasDTO> mapasDTOList = new ArrayList<>();

        jdbcTemplate.query(SQL_QUERY_MAPAS, (resultSet) -> {

            MapasDTO mapasDTO = new MapasDTO(
                    resultSet.getDouble("latitude"),
                    resultSet.getDouble("longitude"),
                    resultSet.getString("name"),
                    resultSet.getLong("id"),
                    resultSet.getString("emails")
            );

            mapasDTOList.add(mapasDTO);
        });

        return mapasDTOList;
    }


}
