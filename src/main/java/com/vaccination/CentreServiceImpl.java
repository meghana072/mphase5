package com.vaccination;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CentreServiceImpl implements CentreService {

	
	@Autowired
	private CentreRepository centrerepository;
	
	@Override
	public List<VaccinationCentre> getAllVaccinationCentre() 
	{
		return centrerepository.findAll();
		
	}

	@Override
	public void saveVaccinationCentre(VaccinationCentre vacinationcentre) {
		this.centrerepository.save(vacinationcentre);
	}

	@Override
	public VaccinationCentre getVaccinationCentreById(long id) {
		Optional<VaccinationCentre> optional = centrerepository.findById(id);
	    VaccinationCentre vaccinationcentre = null;
	    if (optional.isPresent()) {
	    	vaccinationcentre = optional.get();
	    } else {
	        throw new RuntimeException("Centre not found for id: " + id);
	    }
	    return vaccinationcentre;
	}

	@Override
	public void deleteVaccinationCentreById(long id) {
		this.centrerepository.deleteById(id);
		
	}

}
