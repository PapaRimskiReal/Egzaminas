package egzaminas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import egzaminas.domain.Entry;
@Repository
public interface EntryRepository extends JpaRepository<Entry, Integer>{

}
