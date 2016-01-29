/**
 */
package samp.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import samp.Affectation;
import samp.Expression;
import samp.Identitfiant;
import samp.SampPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Affectation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link samp.impl.AffectationImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link samp.impl.AffectationImpl#getIdentitfiant <em>Identitfiant</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AffectationImpl extends SequenceImpl implements Affectation {
	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression expression;

	/**
	 * The cached value of the '{@link #getIdentitfiant() <em>Identitfiant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentitfiant()
	 * @generated
	 * @ordered
	 */
	protected Identitfiant identitfiant;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AffectationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SampPackage.Literals.AFFECTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identitfiant getIdentitfiant() {
		return identitfiant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentitfiant(Identitfiant newIdentitfiant, NotificationChain msgs) {
		Identitfiant oldIdentitfiant = identitfiant;
		identitfiant = newIdentitfiant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SampPackage.AFFECTATION__IDENTITFIANT, oldIdentitfiant, newIdentitfiant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentitfiant(Identitfiant newIdentitfiant) {
		if (newIdentitfiant != identitfiant) {
			NotificationChain msgs = null;
			if (identitfiant != null)
				msgs = ((InternalEObject)identitfiant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SampPackage.AFFECTATION__IDENTITFIANT, null, msgs);
			if (newIdentitfiant != null)
				msgs = ((InternalEObject)newIdentitfiant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SampPackage.AFFECTATION__IDENTITFIANT, null, msgs);
			msgs = basicSetIdentitfiant(newIdentitfiant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SampPackage.AFFECTATION__IDENTITFIANT, newIdentitfiant, newIdentitfiant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
		Expression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SampPackage.AFFECTATION__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SampPackage.AFFECTATION__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SampPackage.AFFECTATION__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SampPackage.AFFECTATION__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SampPackage.AFFECTATION__EXPRESSION:
				return basicSetExpression(null, msgs);
			case SampPackage.AFFECTATION__IDENTITFIANT:
				return basicSetIdentitfiant(null, msgs);
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
			case SampPackage.AFFECTATION__EXPRESSION:
				return getExpression();
			case SampPackage.AFFECTATION__IDENTITFIANT:
				return getIdentitfiant();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SampPackage.AFFECTATION__EXPRESSION:
				setExpression((Expression)newValue);
				return;
			case SampPackage.AFFECTATION__IDENTITFIANT:
				setIdentitfiant((Identitfiant)newValue);
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
			case SampPackage.AFFECTATION__EXPRESSION:
				setExpression((Expression)null);
				return;
			case SampPackage.AFFECTATION__IDENTITFIANT:
				setIdentitfiant((Identitfiant)null);
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
			case SampPackage.AFFECTATION__EXPRESSION:
				return expression != null;
			case SampPackage.AFFECTATION__IDENTITFIANT:
				return identitfiant != null;
		}
		return super.eIsSet(featureID);
	}
	
	public String toString(){	
		return identitfiant.toString()+ " = " +expression.toString();
	}

} //AffectationImpl
