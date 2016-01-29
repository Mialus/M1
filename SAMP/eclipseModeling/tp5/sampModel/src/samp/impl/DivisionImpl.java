/**
 */
package samp.impl;

import org.eclipse.emf.ecore.EClass;

import samp.Division;
import samp.SampPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Division</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class DivisionImpl extends OperationBinaireImpl implements Division {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DivisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SampPackage.Literals.DIVISION;
	}
	
	public String toString(){	
		return expression1.toString() +" / "+expression2.toString();
	}

} //DivisionImpl
