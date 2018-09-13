package com.indigo.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.indigo.dao.entity.CustomerEntity;
import com.indigo.dao.entity.LoginEntity;

@Repository("CustomerOrmDaoImpl")
public class CustomerOrmDaoImpl extends HibernateDaoSupport  implements AuthDao {
	

	@Autowired
	@Qualifier("customerSessionFactory")
	public void setcSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	

	@Override
	public LoginEntity authUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveCustomer(CustomerEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerEntity> findCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerEntity> findCustomerByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerEntity findCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerEntity> searchCustomerByCriteria(String searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCustomer(CustomerEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public String saveCustomerWithImage(CustomerEntity entity) {
		boolean okj=TransactionSynchronizationManager.isActualTransactionActive();
		System.out.println("))@(@*@&@&@&@^@%^ okj = "+okj);
		entity.setDoe(new Timestamp(new Date().getTime()));
		super.getHibernateTemplate().save(entity);
		return "success";
	}

	@Override
	public List<CustomerEntity> findCustomerWithImage() {
		return (List<CustomerEntity>)super.getHibernateTemplate().find("from CustomerEntity");
	}

	@Override
	public byte[] loadImageByUsername(String username) {
		CustomerEntity entity=super.getHibernateTemplate().get(CustomerEntity.class, username);
		return entity.getImage();
	}

}
