package exo1;

import exo1.*;

public class UsingEMFModels {
	public void main(String[] args){
		Exo1Package instance = Exo1Package.eINSTANCE;
		Exo1Factory factory = Exo1Factory.eINSTANCE;
		
		Departement myDpt = factory.createDepartement();
		myDpt.setName("DISC");
		myDpt.setLocation("Franche-Comte");
		Employee my = factory.createEmployee();
		my.setName("Bruno");
		myDpt.getEmployees().add(my);
		System.out.println(myDpt);
	}
}
