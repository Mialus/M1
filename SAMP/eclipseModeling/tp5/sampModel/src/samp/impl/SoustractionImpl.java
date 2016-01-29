/**
 */
package samp.impl;

import org.eclipse.emf.ecore.EClass;

import samp.SampPackage;
import samp.Soustraction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Soustraction</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SoustractionImpl extends OperationBinaireImpl implements Soustraction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoustractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SampPackage.Literals.SOUSTRACTION;
	}
	
	public String toString(){	
		return expression1.toString() +" - "+expression2.toString();
	}

} //SoustractionImpl
