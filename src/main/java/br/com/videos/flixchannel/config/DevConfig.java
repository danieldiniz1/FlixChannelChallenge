package br.com.videos.flixchannel.config;

import br.com.videos.flixchannel.config.initialData.DataBaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private DataBaseService dataBaseService;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String dbStrategy;


    @Bean
    public Boolean instantiateDatabase(){
        if (dbStrategy.equals("create")){
            LOGGER.info("Iniciando criação e populando banco de dados: ");
            dataBaseService.initiateDataBase();
        } else {
            LOGGER.info("Banco de dados já foi populado");
        }
        return Boolean.TRUE;
    }
}
