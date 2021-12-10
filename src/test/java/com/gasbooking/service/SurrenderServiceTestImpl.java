package com.gasbooking.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gasbooking.entity.Cylinder;
import com.gasbooking.entity.SurrenderCylinder;
import com.gasbooking.repository.ISurrenderCylinderRepository;

@SpringBootTest
public class SurrenderServiceTestImpl {

	@Autowired
	SurrenderCylinderServiceImpl surrenderCylinderServiceImplement;

	@MockBean
	ISurrenderCylinderRepository surrenderRepository;

	@Test

	public void testinsertingsurrendercylinder() {
		SurrenderCylinder sc = new SurrenderCylinder();//creating the object 
               
		sc.setSurrenderId(2);
		sc.setSurrenderDate(LocalDate.now());

		Mockito.when(surrenderRepository.save(sc)).thenReturn(sc);
		assertThat(surrenderCylinderServiceImplement.insertSurrenderCylinder(sc)).isEqualTo(sc);
	}

	@Test

	public void testupdatesurrendercylinder() {

		Cylinder c1 = new Cylinder(1, "LPG", 14.2f, "blue", 141.0f);
		SurrenderCylinder s2 = new SurrenderCylinder(2, LocalDate.now(), c1);
		when(surrenderRepository.existsById(s2.getSurrenderId())).thenReturn(true);
		when(surrenderRepository.save(s2)).thenReturn(s2);
		assertEquals(s2.getSurrenderId(),surrenderCylinderServiceImplement.insertSurrenderCylinder(s2).getSurrenderId());
		assertEquals(s2.getSurrenderDate(),
				surrenderCylinderServiceImplement.insertSurrenderCylinder(s2).getSurrenderDate());
		assertEquals(s2.getCylinder(), surrenderCylinderServiceImplement.insertSurrenderCylinder(s2).getCylinder());
	}

	@Test
	public void testDeletesurrendercylinder() {
		Cylinder c1 = new Cylinder(1, "LPG", 14.2f, "blue", 141.0f);
		SurrenderCylinder s1 = new SurrenderCylinder(1, LocalDate.now(), c1);

		when(surrenderRepository.existsById(s1.getSurrenderId())).thenReturn(true);
		surrenderRepository.delete(s1);
		verify(surrenderRepository, times(1)).delete(s1);
	}

	@Test
	public void testCountsurrendercylinder() {
		Cylinder c1 = new Cylinder(1, "LPG", 14.2f, "blue", 141.0f);
		SurrenderCylinder s1 = new SurrenderCylinder(1, LocalDate.now(), c1);
		when(surrenderRepository.existsById(s1.getSurrenderId())).thenReturn(true);
		surrenderRepository.count();
		verify(surrenderRepository, times(1)).count();
	}
}
