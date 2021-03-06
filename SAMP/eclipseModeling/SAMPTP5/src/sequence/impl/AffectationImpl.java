/**
 */
package sequence.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sequence.Affectation;
import sequence.SequencePackage;

public class AffectationImpl extends InstructionImpl implements Affectation {

	protected static final String OPERATION_EDEFAULT = "=";

	protected String operation = OPERATION_EDEFAULT;

	protected static final String FIN_OPERATION_EDEFAULT = ";";

	protected String finOperation = FIN_OPERATION_EDEFAULT;

	protected AffectationImpl() {
		super();
	}
	
	@Override
	protected EClass eStaticClass() {
		return SequencePackage.Literals.AFFECTATION;
	}

	public String getOperation() {
		return operation;
	}

	public String getFinOperation() {
		return finOperation;
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SequencePackage.AFFECTATION__OPERATION:
				return getOperation();
			case SequencePackage.AFFECTATION__FIN_OPERATION:
				return getFinOperation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SequencePackage.AFFECTATION__OPERATION:
				setOperation((String)newValue);
				return;
			case SequencePackage.AFFECTATION__FIN_OPERATION:
				setFinOperation((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SequencePackage.AFFECTATION__OPERATION:
				setOperation(OPERATION_EDEFAULT);
				return;
			case SequencePackage.AFFECTATION__FIN_OPERATION:
				setFinOperation(FIN_OPERATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SequencePackage.AFFECTATION__OPERATION:
				return OPERATION_EDEFAULT == null ? operation != null : !OPERATION_EDEFAULT.equals(operation);
			case SequencePackage.AFFECTATION__FIN_OPERATION:
				return FIN_OPERATION_EDEFAULT == null ? finOperation != null : !FIN_OPERATION_EDEFAULT.equals(finOperation);
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append("");
		result.append(" (operation: ");
		result.append(operation);
		result.append(", FinOperation: ");
		result.append(finOperation);
		result.append(')');
		return result.toString();
	}

	@Override
	public void setOperation(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFinOperation(String value) {
		// TODO Auto-generated method stub
		
	}

} //AffectationImpl
