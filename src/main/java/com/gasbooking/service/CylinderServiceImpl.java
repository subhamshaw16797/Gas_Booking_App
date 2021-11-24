package com.gasbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gasbooking.entity.Cylinder;
import com.gasbooking.exception.CylinderNotFoundException;
import com.gasbooking.repository.ICylinderRepository;

@Service
public  class CylinderServiceImpl implements ICylinderService{
	
	@Autowired
	ICylinderRepository cylinderrepository;

	@Override
	@Transactional
	public Cylinder insertCylinder(Cylinder cylinder) {
		
		return cylinderrepository.save(cylinder);
	}

	@Override
	@Transactional
	public Cylinder updateCylinder(Cylinder cylinder) throws CylinderNotFoundException  {
		
        int CylinderId=cylinder.getcylinderId();
		
		Optional<Cylinder> optional = cylinderrepository.findById(CylinderId);
		if(optional.isPresent()) {
			Cylinder c1=optional.get();
			c1.setType(cylinder.getType());
			c1.setWeight(cylinder.getWeight());
			c1.setStrapColor(cylinder.getStrapColor());
			c1.setPrice(cylinder.getPrice());
			return cylinder;
		}
		else {
			throw new CylinderNotFoundException("Cylinder details not found");
		}
	}

	@Override
	@Transactional
	public Cylinder deleteCylinder(int cylinderId) throws CylinderNotFoundException {
		Optional<Cylinder> optional=cylinderrepository.findById(cylinderId);
		if(optional.isPresent()) {
			Cylinder deletedCylinder=optional.get();
			cylinderrepository.deleteById(cylinderId);
			return deletedCylinder;
		}
		else {
			throw new CylinderNotFoundException(" Cylinder details not found");
		}
	}

	@Override
	@Transactional
	public List<Cylinder> viewCylinderByType(String type) throws CylinderNotFoundException {
		Optional<Cylinder> optional=cylinderrepository.findByType(type);
		if(optional.isPresent()) {
			return viewCylinderByType(null);
	}
       else {
	     throw new CylinderNotFoundException("Cylinder detalis not found");
      }
	}
}
