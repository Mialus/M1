/**
 */
package samp.impl;

import java.util.Scanner;

import org.eclipse.emf.ecore.EClass;

import samp.Addition;
import samp.SampPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Addition</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AdditionImpl extends OperationBinaireImpl implements Addition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SampPackage.Literals.ADDITION;
	}
	
	public String toString(){	
		return expression1.toString() +" + "+expression2.toString();
	}
	
	public static void main (String args[])
	{
	  Scanner input = new Scanner( System.in );

	  int number1;
	  int number2; 
	  
	  System.out.print( "a : " ); 
	  number1 = input.nextInt(); 

	  System.out.print( "b : " ); 
	  number2 = input.nextInt(); 



	} 

} //AdditionImpl
