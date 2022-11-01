package br.com.videos.flixchannel.config;

import br.com.videos.flixchannel.config.initialData.DataBaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private DataBaseService dataBaseService;

    @Bean
    public Boolean initiateDataBase(){
        dataBaseService.initiateDataBase();
        LOGGER.info("O Banco de dados foi populado com sucesso!");
        return Boolean.TRUE;
    }
}
