package com.vaccination;

import java.util.List;


public interface CitizenService {
	List<Citizen> getAllCitizen();
	void saveCitizen(Citizen citizen);
	Citizen getCitizenById(long id);
	void deleteCitizenById(long id);
}
