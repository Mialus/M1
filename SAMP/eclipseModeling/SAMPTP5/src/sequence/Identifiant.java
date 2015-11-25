/**
 */
package sequence;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifiant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sequence.Identifiant#getIdentifiant <em>Identifiant</em>}</li>
 *   <li>{@link sequence.Identifiant#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see sequence.SequencePackage#getIdentifiant()
 * @model
 * @generated
 */
public interface Identifiant extends Expression {
	/**
	 * Returns the value of the '<em><b>Identifiant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifiant</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifiant</em>' containment reference.
	 * @see #setIdentifiant(Affectation)
	 * @see sequence.SequencePackage#getIdentifiant_Identifiant()
	 * @model containment="true"
	 * @generated
	 */
	Affectation getIdentifiant();

	/**
	 * Sets the value of the '{@link sequence.Identifiant#getIdentifiant <em>Identifiant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifiant</em>' containment reference.
	 * @see #getIdentifiant()
	 * @generated
	 */
	void setIdentifiant(Affectation value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see sequence.SequencePackage#getIdentifiant_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link sequence.Identifiant#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Identifiant
