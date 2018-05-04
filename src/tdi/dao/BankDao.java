package tdi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tdi.model.Adress;
import tdi.model.Bank;
import tdi.model.Perpustakaan;
import tdi.model.Person;

@Repository
public class BankDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate nameJdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public List<Bank> findAllHibernate() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Bank");
		return query.list();
	}

	@Transactional(readOnly = false)
	public void simpanHibernate(Person person) {
		
		sessionFactory.getCurrentSession().save(person);
	}
	
	@Transactional(readOnly = false)
	public void simpanPerpusHibernate(Perpustakaan perpus) { 
		sessionFactory.getCurrentSession().save(perpus);
	}
	
	@Transactional(readOnly = false)
	public void hapusPerpusHibernate(Perpustakaan perpus) { 
		sessionFactory.getCurrentSession()
		.createQuery("delete from Book a where a.perpustakaan.idPerpustakaan = :id ")
		.setParameter("id", perpus.getIdPerpustakaan())
		.executeUpdate();
		sessionFactory.getCurrentSession().delete(perpus); 
	}
	
	
	@Transactional(readOnly = false)
	public void simpanHibernateAlamat(Adress alamat) {
		sessionFactory.getCurrentSession().save( alamat);
	}
	
	@Transactional(readOnly = false)
	public void simpanHibernate(Bank bank) {
		sessionFactory.getCurrentSession().saveOrUpdate(bank);
	}

	@Transactional(readOnly = true)
	public Bank findByIdHibernate(int id, String nama) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Bank b where b.id = :id ")
				.setParameter("id",
				id);
		return (Bank) query.list().get(0);
	}

	public List<Bank> findAll() {
		List<Bank> listBank = jdbcTemplate.query(" SELECT ID as id,BankName as namaBank  FROM  Banks ",
				new BeanPropertyRowMapper(Bank.class));
		return listBank;
	}

	public Bank findById(int id, String nama) {
		return (Bank) jdbcTemplate.queryForObject(
				" SELECT ID as id,BankName as namaBank  " + "FROM  Banks where id = ? and upper(BankName)"
						+ " like concat('%',upper(?),'%')  ",
				new Object[] { id, nama }, new BeanPropertyRowMapper(Bank.class));
	}

	public List<Map<String, Object>> findByMap(String nama) {
		return jdbcTemplate.queryForList(
				" SELECT * " + " FROM  Banks where  upper(BankName)" + " like concat('%',upper(?),'%')",
				new Object[] { nama });

	}

	public Bank findByIdNameParam(int id, String nama) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id1", id);
		param.put("name", nama);
		return (Bank) nameJdbcTemplate.queryForObject(" SELECT ID as id,BankName as namaBank  "
				+ "FROM  Banks where id = :id1 and upper(BankName)" + " like concat('%',upper(:name),'%')  ", param,
				new BeanPropertyRowMapper(Bank.class));
	}

	public Number simpan(String nama) {
		String sql = " INSERT INTO  Banks( BankName )   VALUES  ( :nama ) ";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("nama", nama);
		KeyHolder keyHOlder = new GeneratedKeyHolder();
		nameJdbcTemplate.update(sql, paramMap, keyHOlder);
		return keyHOlder.getKey();
	}

	public int simpanUpdate(Bank bank) {
		String sql = " UPDATE  Banks  SET  BankName  =  :nama where ID = :id ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("nama", bank.getNamaBank());
		paramMap.put("id", bank.getId());
		return nameJdbcTemplate.update(sql, paramMap);
	}
}
