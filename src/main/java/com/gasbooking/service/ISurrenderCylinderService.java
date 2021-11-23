package com.gasbooking.service;

import com.gasbooking.entity.SurrenderCylinder;

public interface ISurrenderCylinderService {
	
	public SurrenderCylinder insertSurrenderCylinder(SurrenderCylinder sc);
	
	public SurrenderCylinder updateSurrenderCylinder(SurrenderCylinder sc);
	
	public SurrenderCylinder deleteSurrenderCylinder(SurrenderCylinder sc);
	
	public int CountSurrenderCylinders();

}
