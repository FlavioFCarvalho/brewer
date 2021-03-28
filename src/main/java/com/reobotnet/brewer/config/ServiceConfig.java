package com.reobotnet.brewer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.reobotnet.brewer.service.CadastroCervejaService;
import com.reobotnet.brewer.storage.FotoStorage;

@Configuration
@ComponentScan(basePackageClasses = { CadastroCervejaService.class, FotoStorage.class})
public class ServiceConfig {

	
}