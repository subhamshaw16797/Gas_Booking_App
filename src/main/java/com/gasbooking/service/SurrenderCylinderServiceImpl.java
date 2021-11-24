package com.gasbooking.service;

import java.util.function.Supplier;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.entity.SurrenderCylinder;
import com.gasbooking.repository.ISurrenderCylinderRepository;

@Service
public class SurrenderCylinderServiceImpl implements ISurrenderCylinderService {

	@Autowired
	ISurrenderCylinderRepository surrendercylinderrepository;

	@Override
	public SurrenderCylinder insertSurrenderCylinder(SurrenderCylinder sc) {

		return surrendercylinderrepository.save(sc);
	}

	@Override
	public SurrenderCylinder updateSurrenderCylinder(SurrenderCylinder sc) {
		int surrendercylinderid = sc.getSurrenderId();
		Supplier s1 = () -> new ServiceException("Given Id is not found in the Database");
		SurrenderCylinder g1 = null;
		try {
			g1 = surrendercylinderrepository.findById(surrendercylinderid).orElseThrow(s1);
//			g1.setCustomer(sc.getCustomer());
//			g1.setCylinder(sc.getCylinder());
			g1.setSurrenderDate(sc.getSurrenderDate());
			g1.setSurrenderId(sc.getSurrenderId());

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return g1;
	}

	@Override
	public SurrenderCylinder deleteSurrenderCylinder(SurrenderCylinder sc) {
		int surrendercylinderid=sc.getSurrenderId();
		SurrenderCylinder entity = surrendercylinderrepository.getOne(surrendercylinderid);
		surrendercylinderrepository.delete(entity);
		return entity;
	}

	@Override
	public int CountSurrenderCylinders() {

		return (int) this.surrendercylinderrepository.count();
	}
}