package com.accenture.lkm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.accenture.lkm.businessbean.EmployeeBean;
import com.accenture.lkm.entity.EmployeeEntity;
import com.accenture.lkm.utility.JPAUtility;

public class EmployeeDAOIMPL implements EmployeeDAO {

	public Integer addEmployee(EmployeeBean employee) throws Exception {
		// TODO Auto-generated method stub
		Integer employeeID = 0;
		EntityManager entityManager = null;
		try {
			EntityManagerFactory entityManagerFactory = JPAUtility.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			
			EmployeeEntity employeeEntity1 = new EmployeeEntity();
			employeeEntity1.setEmployeeName(employee.getEmployeeName());
			employeeEntity1.setSalary(employee.getSalary());
			employeeEntity1.setEmployeeId(employee.getEmployeeId());
			
			System.out.println(employeeEntity1);  //employeeEntity1 is in a transient state 
													//(not managed by JPA)
			
			entityManager.getTransaction().begin();
			entityManager.merge(employeeEntity1); //duplicate copy of entity is managed
			employeeEntity1.setEmployeeName("dummy"); //failed update
			entityManager.getTransaction().commit();
			
			employeeID = employeeEntity1.getEmployeeId();
			
			
		} catch (Exception exception) {
			throw exception;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

		return employeeID;
	}

	public static void peristEmployee(EmployeeBean employee) {

	}

}



//
//merge() creates a managed copy of the entity
//This creates two instances:
//
//-The original employeeEntity1
//-A new managed copy in the persistence context
//
//
//The setEmployeeName("dummy") call will NOT update the database
//This is because the original employeeEntity1 remains detached
//The managed copy created by merge() is not affected by this change
//
//

