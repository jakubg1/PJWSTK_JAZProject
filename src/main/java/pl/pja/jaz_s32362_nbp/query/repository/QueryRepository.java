package pl.pja.jaz_s32362_nbp.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pja.jaz_s32362_nbp.query.model.Query;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {

}
