package com.reobotnet.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reobotnet.brewer.model.Venda;
import com.reobotnet.brewer.repository.helper.venda.VendasQueries;



public interface Vendas extends JpaRepository<Venda, Long>, VendasQueries {

}