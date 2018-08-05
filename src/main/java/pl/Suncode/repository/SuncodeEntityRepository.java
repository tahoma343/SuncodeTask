package pl.Suncode.repository;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;

import pl.Suncode.model.SuncodeEntity;

@Transactional
public interface SuncodeEntityRepository {
	<T> List<SuncodeEntity> getSingleValue(String column);
	<T> List<SuncodeEntity> getMultipleValues(String column);
	<T> List<SuncodeEntity> findByValue(String column, T value);
}
