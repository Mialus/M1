/**
 */
package samp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Simple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link samp.OperationSimple#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see samp.SampPackage#getOperationSimple()
 * @model abstract="true"
 * @generated
 */
public interface OperationSimple extends Expression {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
	 * The list contents are of type {@link samp.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference list.
	 * @see samp.SampPackage#getOperationSimple_Expression()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExpression();

} // OperationSimple
