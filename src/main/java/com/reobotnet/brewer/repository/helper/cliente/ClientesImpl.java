package com.reobotnet.brewer.repository.helper.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.reobotnet.brewer.model.Cliente;
import com.reobotnet.brewer.repository.filter.ClienteFilter;
import com.reobotnet.brewer.repository.paginacao.PaginacaoUtil;

public class ClientesImpl implements ClientesQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> filtrar(ClienteFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cliente.class);
		
		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);
				
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
	
	private Long total(ClienteFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cliente.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(ClienteFilter filtro, Criteria criteria) {
		if (filtro != null) {
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getCpfOuCnpj())) {
				criteria.add(Restrictions.eq("cpfOuCnpj", filtro.getCpfOuCnpjSemFormatacao()));
			}
		}
	}

}
