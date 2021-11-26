package com.gasbooking.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gasbooking.entity.Customer;
import com.gasbooking.entity.Cylinder;
import com.gasbooking.entity.SurrenderCylinder;
import com.gasbooking.exception.CylinderNotFoundException;
import com.gasbooking.repository.ICylinderRepository;

@SpringBootTest
	public class CylinderServiceImplTest {
	       
		@Autowired
		private ICylinderService  service;
		
		@MockBean
		private ICylinderRepository  repo ;
		
		
		@Test
		public void testinsertCylinder() {
			Cylinder c1=new Cylinder();
			Customer c=new Customer();
			SurrenderCylinder s=new SurrenderCylinder();
			c1.setCylinderId(3);
			c1.setType("jhg");
			c1.setStrapColor("red");
			c1.setPrice(8756.9);
			c1.setWeight(15);
			c1.setCustomer(c);
			c1.setSurrenderCylinder(s);
			Mockito.when(repo.save(c1)).thenReturn(c1);
			assertThat(service.insertCylinder(c1)).isEqualTo(c1);
		}
		@Test
		void testUpdateCylinder() throws CylinderNotFoundException {
			int id = 1;
			Cylinder c1=new Cylinder();
			Customer c=new Customer();
			SurrenderCylinder s=new SurrenderCylinder();
			c1.setCylinderId(33);
			c1.setCustomer(c);
			c1.setPrice(2345);
			c1.setWeight(16);
			c1.setType("gfhr");
			c1.setSurrenderCylinder(s);
			Optional<Cylinder> c2=Optional.of(c1);
			 Mockito.when(repo.findById(1)).thenReturn(c2);
			 Mockito.when(repo.save(c1)).thenReturn(c1);
			 c1.setCustomer(c);
			 c1.setSurrenderCylinder(s);
			 c1.setWeight(18);
			 c1.setPrice(1150);
			 assertThat(service.updateCylinder(id, c1)).isEqualTo(c1);
		}
		@Test
		void testDeleteCylinder() throws CylinderNotFoundException {
			Cylinder c1=new Cylinder();
			Customer c=new Customer();
			SurrenderCylinder s=new SurrenderCylinder();
			c1.setCylinderId(33);
			c1.setCustomer(c);
			c1.setSurrenderCylinder(s);
			c1.setWeight(16);
			c1.setPrice(1234);
			c1.setType("abc");
			Optional<Cylinder> c2=Optional.of(c1);
			 Mockito.when(repo.findById(33)).thenReturn(c2);
			 assertThat(service.deleteCylinder(33)).isEqualTo(c1);
		}
}