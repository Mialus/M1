/**
 */
package samp.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import samp.Nombre;
import samp.SampPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nombre</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link samp.impl.NombreImpl#getNb <em>Nb</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NombreImpl extends ExpressionImpl implements Nombre {
	/**
	 * The default value of the '{@link #getNb() <em>Nb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNb()
	 * @generated
	 * @ordered
	 */
	protected static final double NB_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNb() <em>Nb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNb()
	 * @generated
	 * @ordered
	 */
	protected double nb = NB_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NombreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SampPackage.Literals.NOMBRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNb() {
		return nb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNb(double newNb) {
		double oldNb = nb;
		nb = newNb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SampPackage.NOMBRE__NB, oldNb, nb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SampPackage.NOMBRE__NB:
				return getNb();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SampPackage.NOMBRE__NB:
				setNb((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SampPackage.NOMBRE__NB:
				setNb(NB_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SampPackage.NOMBRE__NB:
				return nb != NB_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
	
	public String toString(){	
		return Double.toString(nb);
	}
	
} //NombreImpl
