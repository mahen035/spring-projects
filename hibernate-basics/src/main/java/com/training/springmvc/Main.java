package com.training.springmvc;

import com.training.springmvc.entity.Employee;
import com.training.springmvc.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Employee emp1 = new Employee();
        emp1.setEmpName("Test123");
        emp1.setRole("Analyst");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //save the employee entity
        session.save(emp1);
        //session.
        //commit transaction
        session.getTransaction().commit();

        //terminate session
        HibernateUtil.getSessionFactory().close();


    }
}

// Create an Employee table in postres with fields
// emp_id, pk
// emp_name, not null
// emp_role, not null

// Create the model class for Employee
// When to use load and when to use persist in hibernate