/**
 */
package samp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Affectation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link samp.Affectation#getExpression <em>Expression</em>}</li>
 *   <li>{@link samp.Affectation#getIdentitfiant <em>Identitfiant</em>}</li>
 * </ul>
 *
 * @see samp.SampPackage#getAffectation()
 * @model
 * @generated
 */
public interface Affectation extends Sequence {
	/**
	 * Returns the value of the '<em><b>Identitfiant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identitfiant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identitfiant</em>' containment reference.
	 * @see #setIdentitfiant(Identitfiant)
	 * @see samp.SampPackage#getAffectation_Identitfiant()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Identitfiant getIdentitfiant();

	/**
	 * Sets the value of the '{@link samp.Affectation#getIdentitfiant <em>Identitfiant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identitfiant</em>' containment reference.
	 * @see #getIdentitfiant()
	 * @generated
	 */
	void setIdentitfiant(Identitfiant value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see samp.SampPackage#getAffectation_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link samp.Affectation#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

} // Affectation
