package com.modulo.usuarios.infraestructure.services.impl;

import com.modulo.usuarios.api.models.response.MapasDTO;
import com.modulo.usuarios.infraestructure.services.contracts.MapasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class MapasServiceImpl implements MapasService {

    /**JdbcTemplate es una clase proporcionada por el framework Spring para simplificar la ejecución de consultas SQL
     * y la manipulación de resultados en entornos JDBC (facilita el trabajo con bases de datos relacionales en entornos de Spring).*/
    @Autowired
    private JdbcTemplate jdbcTemplate;


    /** Consulta SQL para obtener los datos de los mapas (nombre, latitud, longitud y la lista con correos electrónicos dependiendo los responsables a cargo)*/
    private static final String SQL_QUERY_MAPAS = "SELECT c.latitude, c.longitude, c.name, c.id,GROUP_CONCAT(ms.email) AS emails  " +
            "FROM campus c " +
            "JOIN sworn_declaration sd ON c.id = sd.campus_id " +
            "JOIN maintenance_staff ms ON sd.id = ms.declaration_id "+
            " GROUP BY c.id";

    @Override
    public List<MapasDTO> getMapasData() {
        // Un mapa para almacenar temporalmente los datos de MapasDTO utilizando el id como clave
        log.info("----> Comienza getMapasData");
        Map<Long, MapasDTO> mapasDTOMap = new HashMap<>();

        // Ejecutar la consulta SQL y procesar los resultados
        log.info("----> Comienza jdbcTemplate.query - LLAMA A DB");
        jdbcTemplate.query(SQL_QUERY_MAPAS, (resultSet) -> {
            Long id = resultSet.getLong("id");
            // Verificar si el id ya está en el mapa
            if (!mapasDTOMap.containsKey(id)) {
                // Si no está presente, crear un nuevo MapasDTO y agregarlo al mapa
                log.info("----> setea los datos en el MapasDTO");
                mapasDTOMap.put(id, new MapasDTO(
                        resultSet.getDouble("latitude"),
                        resultSet.getDouble("longitude"),
                        resultSet.getString("name"),
                        id,
                        new ArrayList<>()
                ));
            }

            // Agregar el correo electrónico al MapasDTO correspondiente en el mapa
            log.info("----> agrega el email al MapasDTO");
            mapasDTOMap.get(id).getEmails().add(resultSet.getString("emails"));

        });

        // Devolver una lista de los valores del mapa (que son objetos MapasDTO)
        log.info("----> termina getMapasData");
        return new ArrayList<>(mapasDTOMap.values());
    }


}
