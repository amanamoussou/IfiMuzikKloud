package org.ifi.com.muzikKloud.daoImpl;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.ifi.com.muzikKloud.dao.SongDao;
import org.ifi.com.muzikKloud.entity.Song;
import org.springframework.stereotype.Repository;

@Repository
public class SongDaoImpl implements SongDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addSong(Song s) {
		// TODO Auto-generated method stub
		this.entityManager.persist(s);

	}

	@Override
	public Song getSong(int id) {
		String req = "select s from song where s.id = ?";
		Query query = this.entityManager.createQuery(req);
		query.setParameter(1, id);
		return (Song) query.getSingleResult();
	}

	@Override
	public void updateSong(int id, String titre) {
		// TODO Auto-generated method stub
		String req = "update table song set titre = ? where id = ? ";
		Query query = this.entityManager.createQuery(req);
		query.setParameter(1, titre);
		query.setParameter(2, id);
		query.executeUpdate();
	}

	@Override
	public void updateSong(int id, Date date_parution) {
		// TODO Auto-generated method stub
		String req = "update table song set date_parution = ? where id = ? ";
		Query query = this.entityManager.createQuery(req);
		query.setParameter(1, date_parution);
		query.setParameter(2, id);
		query.executeUpdate();
	}

	@Override
	public void updateSong(int id, String titre, Date date_parution) {
		// TODO Auto-generated method stub
		this.updateSong(id, date_parution);
		this.updateSong(id, titre);
	}

	@Override
	public void deleteSong(int id) {
		// TODO Auto-generated method stub
		String req = "delete from song where id = ? ";
		Query query = this.entityManager.createQuery(req);
		query.setParameter(1, id);
		query.executeUpdate();
	}

	@Override
	public List<Song> getLastSongsAdded(int limit) {
		// TODO Auto-generated method stub
		System.out.println("DAO");
		String req = "select s from song";
		Query query = this.entityManager.createQuery(req);
		query.setParameter(1, limit);
		return (List<Song>) query.getResultList();
	}

}