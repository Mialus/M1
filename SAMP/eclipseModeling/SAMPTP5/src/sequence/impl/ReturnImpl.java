/**
 */
package sequence.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sequence.Return;
import sequence.SequencePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Return</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sequence.impl.ReturnImpl#getReturn <em>Return</em>}</li>
 *   <li>{@link sequence.impl.ReturnImpl#getFinOperation <em>Fin Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReturnImpl extends InstructionImpl implements Return {
	/**
	 * The default value of the '{@link #getReturn() <em>Return</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturn()
	 * @generated
	 * @ordered
	 */
	protected static final String RETURN_EDEFAULT = "return";

	/**
	 * The cached value of the '{@link #getReturn() <em>Return</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturn()
	 * @generated
	 * @ordered
	 */
	protected String return_ = RETURN_EDEFAULT;

	/**
	 * The default value of the '{@link #getFinOperation() <em>Fin Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinOperation()
	 * @generated
	 * @ordered
	 */
	protected static final String FIN_OPERATION_EDEFAULT = ";";

	/**
	 * The cached value of the '{@link #getFinOperation() <em>Fin Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinOperation()
	 * @generated
	 * @ordered
	 */
	protected String finOperation = FIN_OPERATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReturnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SequencePackage.Literals.RETURN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReturn() {
		return return_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturn(String newReturn) {
		String oldReturn = return_;
		return_ = newReturn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.RETURN__RETURN, oldReturn, return_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFinOperation() {
		return finOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinOperation(String newFinOperation) {
		String oldFinOperation = finOperation;
		finOperation = newFinOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.RETURN__FIN_OPERATION, oldFinOperation, finOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SequencePackage.RETURN__RETURN:
				return getReturn();
			case SequencePackage.RETURN__FIN_OPERATION:
				return getFinOperation();
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
			case SequencePackage.RETURN__RETURN:
				setReturn((String)newValue);
				return;
			case SequencePackage.RETURN__FIN_OPERATION:
				setFinOperation((String)newValue);
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
			case SequencePackage.RETURN__RETURN:
				setReturn(RETURN_EDEFAULT);
				return;
			case SequencePackage.RETURN__FIN_OPERATION:
				setFinOperation(FIN_OPERATION_EDEFAULT);
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
			case SequencePackage.RETURN__RETURN:
				return RETURN_EDEFAULT == null ? return_ != null : !RETURN_EDEFAULT.equals(return_);
			case SequencePackage.RETURN__FIN_OPERATION:
				return FIN_OPERATION_EDEFAULT == null ? finOperation != null : !FIN_OPERATION_EDEFAULT.equals(finOperation);
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
		result.append(" (return: ");
		result.append(return_);
		result.append(", FinOperation: ");
		result.append(finOperation);
		result.append(')');
		return result.toString();
	}

} //ReturnImpl
