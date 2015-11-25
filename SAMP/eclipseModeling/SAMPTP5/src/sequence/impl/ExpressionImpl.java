/**
 */
package sequence.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import sequence.Affectation;
import sequence.Expression;
import sequence.Identifiant;
import sequence.Nombre;
import sequence.Operation;
import sequence.Return;
import sequence.SequencePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sequence.impl.ExpressionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link sequence.impl.ExpressionImpl#getReturn <em>Return</em>}</li>
 *   <li>{@link sequence.impl.ExpressionImpl#getNombre <em>Nombre</em>}</li>
 *   <li>{@link sequence.impl.ExpressionImpl#getIdentifiants <em>Identifiants</em>}</li>
 *   <li>{@link sequence.impl.ExpressionImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionImpl extends MinimalEObjectImpl.Container implements Expression {
	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected Affectation expression;

	/**
	 * The cached value of the '{@link #getReturn() <em>Return</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturn()
	 * @generated
	 * @ordered
	 */
	protected Return return_;

	/**
	 * The cached value of the '{@link #getNombre() <em>Nombre</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNombre()
	 * @generated
	 * @ordered
	 */
	protected EList<Nombre> nombre;

	/**
	 * The cached value of the '{@link #getIdentifiants() <em>Identifiants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiants()
	 * @generated
	 * @ordered
	 */
	protected EList<Identifiant> identifiants;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> operations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SequencePackage.Literals.EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Affectation getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(Affectation newExpression, NotificationChain msgs) {
		Affectation oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencePackage.EXPRESSION__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Affectation newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencePackage.EXPRESSION__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencePackage.EXPRESSION__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.EXPRESSION__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Return getReturn() {
		return return_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturn(Return newReturn, NotificationChain msgs) {
		Return oldReturn = return_;
		return_ = newReturn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencePackage.EXPRESSION__RETURN, oldReturn, newReturn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturn(Return newReturn) {
		if (newReturn != return_) {
			NotificationChain msgs = null;
			if (return_ != null)
				msgs = ((InternalEObject)return_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencePackage.EXPRESSION__RETURN, null, msgs);
			if (newReturn != null)
				msgs = ((InternalEObject)newReturn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencePackage.EXPRESSION__RETURN, null, msgs);
			msgs = basicSetReturn(newReturn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.EXPRESSION__RETURN, newReturn, newReturn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Nombre> getNombre() {
		if (nombre == null) {
			nombre = new EObjectContainmentEList<Nombre>(Nombre.class, this, SequencePackage.EXPRESSION__NOMBRE);
		}
		return nombre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Identifiant> getIdentifiants() {
		if (identifiants == null) {
			identifiants = new EObjectContainmentEList<Identifiant>(Identifiant.class, this, SequencePackage.EXPRESSION__IDENTIFIANTS);
		}
		return identifiants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList<Operation>(Operation.class, this, SequencePackage.EXPRESSION__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SequencePackage.EXPRESSION__EXPRESSION:
				return basicSetExpression(null, msgs);
			case SequencePackage.EXPRESSION__RETURN:
				return basicSetReturn(null, msgs);
			case SequencePackage.EXPRESSION__NOMBRE:
				return ((InternalEList<?>)getNombre()).basicRemove(otherEnd, msgs);
			case SequencePackage.EXPRESSION__IDENTIFIANTS:
				return ((InternalEList<?>)getIdentifiants()).basicRemove(otherEnd, msgs);
			case SequencePackage.EXPRESSION__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
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
			case SequencePackage.EXPRESSION__EXPRESSION:
				return getExpression();
			case SequencePackage.EXPRESSION__RETURN:
				return getReturn();
			case SequencePackage.EXPRESSION__NOMBRE:
				return getNombre();
			case SequencePackage.EXPRESSION__IDENTIFIANTS:
				return getIdentifiants();
			case SequencePackage.EXPRESSION__OPERATIONS:
				return getOperations();
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
			case SequencePackage.EXPRESSION__EXPRESSION:
				setExpression((Affectation)newValue);
				return;
			case SequencePackage.EXPRESSION__RETURN:
				setReturn((Return)newValue);
				return;
			case SequencePackage.EXPRESSION__NOMBRE:
				getNombre().clear();
				getNombre().addAll((Collection<? extends Nombre>)newValue);
				return;
			case SequencePackage.EXPRESSION__IDENTIFIANTS:
				getIdentifiants().clear();
				getIdentifiants().addAll((Collection<? extends Identifiant>)newValue);
				return;
			case SequencePackage.EXPRESSION__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends Operation>)newValue);
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
			case SequencePackage.EXPRESSION__EXPRESSION:
				setExpression((Affectation)null);
				return;
			case SequencePackage.EXPRESSION__RETURN:
				setReturn((Return)null);
				return;
			case SequencePackage.EXPRESSION__NOMBRE:
				getNombre().clear();
				return;
			case SequencePackage.EXPRESSION__IDENTIFIANTS:
				getIdentifiants().clear();
				return;
			case SequencePackage.EXPRESSION__OPERATIONS:
				getOperations().clear();
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
			case SequencePackage.EXPRESSION__EXPRESSION:
				return expression != null;
			case SequencePackage.EXPRESSION__RETURN:
				return return_ != null;
			case SequencePackage.EXPRESSION__NOMBRE:
				return nombre != null && !nombre.isEmpty();
			case SequencePackage.EXPRESSION__IDENTIFIANTS:
				return identifiants != null && !identifiants.isEmpty();
			case SequencePackage.EXPRESSION__OPERATIONS:
				return operations != null && !operations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExpressionImpl
