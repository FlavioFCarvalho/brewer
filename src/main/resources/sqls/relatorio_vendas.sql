select v.data_criacao AS data_criacao
       ,v.valor_total AS valor_total
       ,c.nome AS nome_cliente
       ,u.nome As nome_vendedor
       ,v.codigo AS codigo
FROM venda v inner join cliente c ON v.codigo_cliente = c.codigo
		inner join usuario u on v.codigo_usuario = u.codigo
where v.status = 'EMITIDA'
       AND v.data_criacao between '2016-02-01 00:00:00' and '2021-05-14'
order by v.data_criacao ASC 