package sampPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import samp.*;


public class Main {
	
	public static void main (String args[]) throws Exception
	{
		SampPackage instance = SampPackage.eINSTANCE;
		
		XMIResourceImpl resource = new XMIResourceImpl();
		File source = new File("../tp5samp/Instruction.xmi");
		resource.load(new FileInputStream(source), new HashMap<Object,Object>());
		Instruction i =(Instruction)resource.getContents().get(0);
		
		System.out.println(i);


	} 

}
