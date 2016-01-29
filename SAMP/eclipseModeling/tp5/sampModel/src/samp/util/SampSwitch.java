/**
 */
package samp.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import samp.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see samp.SampPackage
 * @generated
 */
public class SampSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SampPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SampSwitch() {
		if (modelPackage == null) {
			modelPackage = SampPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SampPackage.AFFECTATION: {
				Affectation affectation = (Affectation)theEObject;
				T result = caseAffectation(affectation);
				if (result == null) result = caseSequence(affectation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.RETURN: {
				Return return_ = (Return)theEObject;
				T result = caseReturn(return_);
				if (result == null) result = caseSequence(return_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.OPERATION_BINAIRE: {
				OperationBinaire operationBinaire = (OperationBinaire)theEObject;
				T result = caseOperationBinaire(operationBinaire);
				if (result == null) result = caseExpression(operationBinaire);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.NOMBRE: {
				Nombre nombre = (Nombre)theEObject;
				T result = caseNombre(nombre);
				if (result == null) result = caseExpression(nombre);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.IDENTITFIANT: {
				Identitfiant identitfiant = (Identitfiant)theEObject;
				T result = caseIdentitfiant(identitfiant);
				if (result == null) result = caseExpression(identitfiant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.SEQUENCE: {
				Sequence sequence = (Sequence)theEObject;
				T result = caseSequence(sequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.OPERATION_UNAIRE: {
				OperationUnaire operationUnaire = (OperationUnaire)theEObject;
				T result = caseOperationUnaire(operationUnaire);
				if (result == null) result = caseExpression(operationUnaire);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.INSTRUCTION: {
				Instruction instruction = (Instruction)theEObject;
				T result = caseInstruction(instruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.MULTIPLICATION: {
				Multiplication multiplication = (Multiplication)theEObject;
				T result = caseMultiplication(multiplication);
				if (result == null) result = caseOperationBinaire(multiplication);
				if (result == null) result = caseExpression(multiplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.BIN: {
				Bin bin = (Bin)theEObject;
				T result = caseBin(bin);
				if (result == null) result = caseOperationUnaire(bin);
				if (result == null) result = caseExpression(bin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.ADDITION: {
				Addition addition = (Addition)theEObject;
				T result = caseAddition(addition);
				if (result == null) result = caseOperationBinaire(addition);
				if (result == null) result = caseExpression(addition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.SOUSTRACTION: {
				Soustraction soustraction = (Soustraction)theEObject;
				T result = caseSoustraction(soustraction);
				if (result == null) result = caseOperationBinaire(soustraction);
				if (result == null) result = caseExpression(soustraction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SampPackage.DIVISION: {
				Division division = (Division)theEObject;
				T result = caseDivision(division);
				if (result == null) result = caseOperationBinaire(division);
				if (result == null) result = caseExpression(division);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Affectation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Affectation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAffectation(Affectation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturn(Return object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nombre</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nombre</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNombre(Nombre object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identitfiant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identitfiant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentitfiant(Identitfiant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequence(Sequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Unaire</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Unaire</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationUnaire(OperationUnaire object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Binaire</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Binaire</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationBinaire(OperationBinaire object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstruction(Instruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplication</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplication</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplication(Multiplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBin(Bin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Addition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Addition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddition(Addition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Soustraction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Soustraction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSoustraction(Soustraction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Division</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Division</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDivision(Division object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SampSwitch
