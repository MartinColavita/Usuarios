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
        // Un mapa para almacenar temporalmente los datos de MapasDTO utilizando el id como clave
        Map<Long, MapasDTO> mapasDTOMap = new HashMap<>();

        // Ejecutar la consulta SQL y procesar los resultados
        jdbcTemplate.query(SQL_QUERY_MAPAS, (resultSet) -> {
            Long id = resultSet.getLong("id");

            // Verificar si el id ya está en el mapa
            if (!mapasDTOMap.containsKey(id)) {
                // Si no está presente, crear un nuevo MapasDTO y agregarlo al mapa
                mapasDTOMap.put(id, new MapasDTO(
                        resultSet.getDouble("latitude"),
                        resultSet.getDouble("longitude"),
                        resultSet.getString("name"),
                        id,
                        new ArrayList<>()
                ));
            }

            // Obtener el correo electrónico del resultado y dividirlo en una lista
            String emailsString = resultSet.getString("emails");
            List<String> emailsList = Arrays.asList(emailsString.split(","));

            // Agregar la lista de correos electrónicos al MapasDTO correspondiente en el mapa
            mapasDTOMap.get(id).getEmails().addAll(emailsList);
        });

        // Devolver una lista de los valores del mapa (que son objetos MapasDTO)
        return new ArrayList<>(mapasDTOMap.values());
    }


}
