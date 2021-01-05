package com.reobotnet.brewer.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.reobotnet.brewer.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {

}