package org.ifi.com.muzikKloud.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.ifi.com.muzikKloud.dao.UserDao;
import org.ifi.com.muzikKloud.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addUser(User u) {
		// TODO Auto-generated method stub
		this.entityManager.persist(u);

	}

	@Override
	public void updateUser(String login, String newPass) {
		// TODO Auto-generated method stub
		String req = "update table user set password = ? where login = ? ";
		Query query = this.entityManager.createQuery(req);
		query.setParameter(1, newPass);
		query.setParameter(2, login);
		query.executeUpdate();
	}

	@Override
	public User getUser(String login) {
		// TODO Auto-generated method stub
		String req = "select u from user where u.id = ?";
		Query query = this.entityManager.createQuery(req);
		query.setParameter(1, login);
		return (User) query.getSingleResult();
	}

}
