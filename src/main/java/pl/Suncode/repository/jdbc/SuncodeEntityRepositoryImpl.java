package pl.Suncode.repository.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.Suncode.model.SuncodeEntity;
import pl.Suncode.repository.SuncodeEntityRepository;

@Repository
public class SuncodeEntityRepositoryImpl implements SuncodeEntityRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public <T> List<SuncodeEntity> getSingleValue(String column) {
		String queryString = "SELECT " + column + " FROM SuncodeEntity GROUP BY " + column + " HAVING COUNT(*)=1";
		List<SuncodeEntity> finalValues = new ArrayList();
		List<T> values = getSession().createQuery(queryString).getResultList();
		
		values.forEach(value -> finalValues.addAll(findByValue(column, value)));
		return finalValues;
	}

	public <T> List<SuncodeEntity> getMultipleValues(String column) {
		String queryString = "SELECT " + column + " FROM SuncodeEntity GROUP BY " + column + " HAVING COUNT(*)>1";
		List<SuncodeEntity> finalValues = new ArrayList();
		List<T> values = getSession().createQuery(queryString).getResultList();

		values.forEach(value -> finalValues.addAll(findByValue(column, value)));
		return finalValues;
	}

	public <T> List<SuncodeEntity> findByValue(String column, T value) {
		String queryString = "FROM SuncodeEntity WHERE " + column + "=" + "'" + value + "'";
		return getSession().createQuery(queryString).getResultList();
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}