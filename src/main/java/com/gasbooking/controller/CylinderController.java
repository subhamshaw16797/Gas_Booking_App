//package com.gasbooking.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.gasbooking.entity.Cylinder;
//import com.gasbooking.exception.CylinderControllerException;
//import com.gasbooking.exception.CylinderNotFoundException;
//import com.gasbooking.service.ICylinderService;
//
//@RestController
//@RequestMapping("/cylinder")
//@CrossOrigin
//public class CylinderController {
//
//	@Autowired
//	private ICylinderService cylinderservice;
//	
//	@PostMapping("/insert")
//	public ResponseEntity<?> insertCylinder(@RequestBody Cylinder cylinder) {
//
//		try {
//			Cylinder c = cylinderservice.insertCylinder(cylinder);
//			return new ResponseEntity<Cylinder>(c, HttpStatus.OK);
//		} catch (Exception e) {
//			CylinderControllerException ce = new CylinderControllerException("Sothing went wrong");
//			return new ResponseEntity<CylinderControllerException>(ce, HttpStatus.BAD_REQUEST);
//		}
//
//	}
//
//	@GetMapping("/view")
//	public ResponseEntity<?> viewCylinder() {
//
//		List<Cylinder> listcylinder = cylinderservice.viewCylinder();
//		return new ResponseEntity<List<Cylinder>>(listcylinder, HttpStatus.OK);
//	}
//
//	@PutMapping("/update")
//	public ResponseEntity<?> updateCylinder(@RequestBody Cylinder cylinder) {
//		// logger.info("Update Cylinder Details");
//		try {
//			Cylinder updatecylinder = cylinderservice.updateCylinder(cylinder);
//			return new ResponseEntity<Cylinder>(updatecylinder, HttpStatus.OK);
//		} catch (CylinderNotFoundException e) {
//
//			CylinderControllerException ce = new CylinderControllerException(e.getErrormessage());
//			return new ResponseEntity<CylinderControllerException>(ce, HttpStatus.BAD_REQUEST);
//		} catch (Exception e) {
//			CylinderControllerException ce = new CylinderControllerException("Something went wrong");
//			return new ResponseEntity<CylinderControllerException>(ce, HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	// @RequestMapping(value = "/{type}", method = RequestMethod.GET)
//	@GetMapping("/getCylinder/{type}")
//	@ResponseBody
//	public Optional<Cylinder> getCylinder(@PathVariable String type) {
//
//		// logger.info("Get Cylinder Details By Cylinder Type");
//		Optional<Cylinder> cylinderlist = cylinderservice.viewCylinderByType(type);
//		return cylinderlist;
//
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<?> deleteById(@PathVariable int id) {
//
//		// logger.info("Delete Cylinder Details By Id");
//		try {
//			cylinderservice.deleteById(id);
//			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
//		} catch (Exception e) {
//			CylinderControllerException ce = new CylinderControllerException("invalid CylinderId");
//			return new ResponseEntity<CylinderControllerException>(ce, HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	@GetMapping("/viewid/{id}")
//	public ResponseEntity<Cylinder> getCylinder(@PathVariable int id) {
//		Cylinder cylinder1 = cylinderservice.getCylinder(id);
//		return new ResponseEntity<Cylinder>(cylinder1, HttpStatus.OK);
//
//	}
//
//}