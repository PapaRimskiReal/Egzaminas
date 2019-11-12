package egzaminas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import egzaminas.domain.EntryProperties;

@Repository
public interface EntryPropertiesRepository extends JpaRepository<EntryProperties, Integer> {
	List<EntryProperties> findByEntryId(int entry_id);
}
