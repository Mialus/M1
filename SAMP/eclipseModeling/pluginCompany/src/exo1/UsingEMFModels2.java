package exo1;

import exo1.*;

import java.util.*;
import java.io.*;

import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class UsingEMFModels2 {
	public static void main(String[] args){
		Exo1Package instance = Exo1Package.eINSTANCE;
		XMIResourceImpl resource = new XMIResourceImpl();
		File source = new File("Company.xmi");
		try {
			resource.load(new FileInputStream(source), new HashMap<Object,Object>());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Company c = (Company)resource.getContents().get(0);
		
		System.out.println(c);
		Iterator<Departement> iterator = c.getDepartements().iterator();
		while(iterator.hasNext()){
			Departement myDept = iterator.next();
			System.out.println("Name : " + myDept.getName());
		}
	}
}
