/**
 */
package sequence.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sequence.Affectation;
import sequence.Identifiant;
import sequence.SequencePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifiant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sequence.impl.IdentifiantImpl#getIdentifiant <em>Identifiant</em>}</li>
 *   <li>{@link sequence.impl.IdentifiantImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdentifiantImpl extends ExpressionImpl implements Identifiant {
	/**
	 * The cached value of the '{@link #getIdentifiant() <em>Identifiant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiant()
	 * @generated
	 * @ordered
	 */
	protected Affectation identifiant;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifiantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SequencePackage.Literals.IDENTIFIANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Affectation getIdentifiant() {
		return identifiant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifiant(Affectation newIdentifiant, NotificationChain msgs) {
		Affectation oldIdentifiant = identifiant;
		identifiant = newIdentifiant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencePackage.IDENTIFIANT__IDENTIFIANT, oldIdentifiant, newIdentifiant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifiant(Affectation newIdentifiant) {
		if (newIdentifiant != identifiant) {
			NotificationChain msgs = null;
			if (identifiant != null)
				msgs = ((InternalEObject)identifiant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencePackage.IDENTIFIANT__IDENTIFIANT, null, msgs);
			if (newIdentifiant != null)
				msgs = ((InternalEObject)newIdentifiant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencePackage.IDENTIFIANT__IDENTIFIANT, null, msgs);
			msgs = basicSetIdentifiant(newIdentifiant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.IDENTIFIANT__IDENTIFIANT, newIdentifiant, newIdentifiant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.IDENTIFIANT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SequencePackage.IDENTIFIANT__IDENTIFIANT:
				return basicSetIdentifiant(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SequencePackage.IDENTIFIANT__IDENTIFIANT:
				return getIdentifiant();
			case SequencePackage.IDENTIFIANT__NAME:
				return getName();
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
			case SequencePackage.IDENTIFIANT__IDENTIFIANT:
				setIdentifiant((Affectation)newValue);
				return;
			case SequencePackage.IDENTIFIANT__NAME:
				setName((String)newValue);
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
			case SequencePackage.IDENTIFIANT__IDENTIFIANT:
				setIdentifiant((Affectation)null);
				return;
			case SequencePackage.IDENTIFIANT__NAME:
				setName(NAME_EDEFAULT);
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
			case SequencePackage.IDENTIFIANT__IDENTIFIANT:
				return identifiant != null;
			case SequencePackage.IDENTIFIANT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //IdentifiantImpl
