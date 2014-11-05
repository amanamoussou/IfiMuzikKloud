package org.ifi.com.muzikKloud.dao;



import org.ifi.com.muzikKloud.entity.Album;
import org.springframework.dao.DataAccessException;

public interface AlbumDao {
	public void addAlbum(Album a) throws DataAccessException;
	public Album getAlbum(int id) throws DataAccessException;
	public void updateAlbum(int id, String titre) throws DataAccessException;
	public void deleteAlbum(int id) throws DataAccessException;
}
