/**
 */
package sequence;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Affectation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sequence.Affectation#getOperation <em>Operation</em>}</li>
 *   <li>{@link sequence.Affectation#getFinOperation <em>Fin Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see sequence.SequencePackage#getAffectation()
 * @model
 * @generated
 */
public interface Affectation extends Instruction {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The default value is <code>"="</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see #setOperation(String)
	 * @see sequence.SequencePackage#getAffectation_Operation()
	 * @model default="="
	 * @generated
	 */
	String getOperation();

	/**
	 * Sets the value of the '{@link sequence.Affectation#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(String value);

	/**
	 * Returns the value of the '<em><b>Fin Operation</b></em>' attribute.
	 * The default value is <code>";"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fin Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fin Operation</em>' attribute.
	 * @see #setFinOperation(String)
	 * @see sequence.SequencePackage#getAffectation_FinOperation()
	 * @model default=";"
	 * @generated
	 */
	String getFinOperation();

	/**
	 * Sets the value of the '{@link sequence.Affectation#getFinOperation <em>Fin Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fin Operation</em>' attribute.
	 * @see #getFinOperation()
	 * @generated
	 */
	void setFinOperation(String value);

} // Affectation
