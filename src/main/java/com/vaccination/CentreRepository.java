package com.vaccination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRepository  extends JpaRepository<VaccinationCentre, Long>{

}
