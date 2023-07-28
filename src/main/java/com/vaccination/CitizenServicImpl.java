package com.vaccination;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class CitizenServicImpl implements CitizenService {

	@Autowired
	private CitizenRepository citizenrepository;
	@Override
	public List<Citizen> getAllCitizen() {
		return citizenrepository.findAll();
	}
	@Override
	public void saveCitizen(Citizen citizen) {
		this.citizenrepository.save(citizen);
		
	}
	@Override
	public Citizen getCitizenById(long id) {
	    Optional<Citizen> optional = citizenrepository.findById(id);
	    Citizen citizen = null;
	    if (optional.isPresent()) {
	        citizen = optional.get();
	    } else {
	        throw new RuntimeException("Citizen not found for id: " + id);
	    }
	    return citizen;
	}
	@Override
	public void deleteCitizenById(long id) {
		this.citizenrepository.deleteById(id);
		
	}

}
