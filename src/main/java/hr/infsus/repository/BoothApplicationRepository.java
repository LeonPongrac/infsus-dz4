package hr.infsus.repository;

import hr.infsus.model.BoothApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoothApplicationRepository extends JpaRepository<BoothApplication, Long> {
}
