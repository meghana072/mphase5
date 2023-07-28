package com.vaccination;

import java.util.List;

public interface CentreService {

	
	List<VaccinationCentre> getAllVaccinationCentre();
	void saveVaccinationCentre(VaccinationCentre vacinationcentre);
	VaccinationCentre getVaccinationCentreById(long id);
	void deleteVaccinationCentreById(long id);
}
