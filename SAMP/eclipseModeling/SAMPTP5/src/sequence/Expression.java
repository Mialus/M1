/**
 */
package sequence;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sequence.Expression#getExpression <em>Expression</em>}</li>
 *   <li>{@link sequence.Expression#getReturn <em>Return</em>}</li>
 *   <li>{@link sequence.Expression#getNombre <em>Nombre</em>}</li>
 *   <li>{@link sequence.Expression#getIdentifiants <em>Identifiants</em>}</li>
 *   <li>{@link sequence.Expression#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see sequence.SequencePackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Affectation)
	 * @see sequence.SequencePackage#getExpression_Expression()
	 * @model containment="true"
	 * @generated
	 */
	Affectation getExpression();

	/**
	 * Sets the value of the '{@link sequence.Expression#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Affectation value);

	/**
	 * Returns the value of the '<em><b>Return</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return</em>' containment reference.
	 * @see #setReturn(Return)
	 * @see sequence.SequencePackage#getExpression_Return()
	 * @model containment="true"
	 * @generated
	 */
	Return getReturn();

	/**
	 * Sets the value of the '{@link sequence.Expression#getReturn <em>Return</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return</em>' containment reference.
	 * @see #getReturn()
	 * @generated
	 */
	void setReturn(Return value);

	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' containment reference list.
	 * The list contents are of type {@link sequence.Nombre}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nombre</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' containment reference list.
	 * @see sequence.SequencePackage#getExpression_Nombre()
	 * @model containment="true"
	 * @generated
	 */
	EList<Nombre> getNombre();

	/**
	 * Returns the value of the '<em><b>Identifiants</b></em>' containment reference list.
	 * The list contents are of type {@link sequence.Identifiant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifiants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifiants</em>' containment reference list.
	 * @see sequence.SequencePackage#getExpression_Identifiants()
	 * @model containment="true"
	 * @generated
	 */
	EList<Identifiant> getIdentifiants();

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link sequence.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see sequence.SequencePackage#getExpression_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Operation> getOperations();

} // Expression
