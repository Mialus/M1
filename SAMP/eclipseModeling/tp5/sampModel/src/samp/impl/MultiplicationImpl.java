/**
 */
package samp.impl;

import org.eclipse.emf.ecore.EClass;

import samp.Multiplication;
import samp.SampPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplication</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MultiplicationImpl extends OperationBinaireImpl implements Multiplication {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SampPackage.Literals.MULTIPLICATION;
	}
	
	public String toString(){	
		return expression1.toString() +" * "+expression2.toString();
	}

} //MultiplicationImpl
