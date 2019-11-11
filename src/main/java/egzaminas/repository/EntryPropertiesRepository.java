package egzaminas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import egzaminas.domain.EntryProperties;

public interface EntryPropertiesRepository extends JpaRepository<EntryProperties, Integer> {
	List<EntryProperties> findByEntryId(int entry_id);
}
