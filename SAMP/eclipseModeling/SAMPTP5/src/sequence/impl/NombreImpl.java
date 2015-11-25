/**
 */
package sequence.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sequence.Nombre;
import sequence.SequencePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nombre</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sequence.impl.NombreImpl#getValeur <em>Valeur</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NombreImpl extends ExpressionImpl implements Nombre {
	/**
	 * The default value of the '{@link #getValeur() <em>Valeur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValeur()
	 * @generated
	 * @ordered
	 */
	protected static final double VALEUR_EDEFAULT = 0.0;

	protected double valeur = VALEUR_EDEFAULT;

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
		return SequencePackage.Literals.NOMBRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getValeur() {
		return valeur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValeur(double newValeur) {
		double oldValeur = valeur;
		valeur = newValeur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.NOMBRE__VALEUR, oldValeur, valeur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SequencePackage.NOMBRE__VALEUR:
				return getValeur();
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
			case SequencePackage.NOMBRE__VALEUR:
				setValeur((Double)newValue);
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
			case SequencePackage.NOMBRE__VALEUR:
				setValeur(VALEUR_EDEFAULT);
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
			case SequencePackage.NOMBRE__VALEUR:
				return valeur != VALEUR_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (valeur: ");
		result.append(valeur);
		result.append(')');
		return result.toString();
	}

} //NombreImpl
