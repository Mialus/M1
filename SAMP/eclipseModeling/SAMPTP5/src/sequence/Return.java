/**
 */
package sequence;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Return</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sequence.Return#getReturn <em>Return</em>}</li>
 *   <li>{@link sequence.Return#getFinOperation <em>Fin Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see sequence.SequencePackage#getReturn()
 * @model
 * @generated
 */
public interface Return extends Instruction {
	/**
	 * Returns the value of the '<em><b>Return</b></em>' attribute.
	 * The default value is <code>"return"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return</em>' attribute.
	 * @see #setReturn(String)
	 * @see sequence.SequencePackage#getReturn_Return()
	 * @model default="return"
	 * @generated
	 */
	String getReturn();

	/**
	 * Sets the value of the '{@link sequence.Return#getReturn <em>Return</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return</em>' attribute.
	 * @see #getReturn()
	 * @generated
	 */
	void setReturn(String value);

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
	 * @see sequence.SequencePackage#getReturn_FinOperation()
	 * @model default=";"
	 * @generated
	 */
	String getFinOperation();

	/**
	 * Sets the value of the '{@link sequence.Return#getFinOperation <em>Fin Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fin Operation</em>' attribute.
	 * @see #getFinOperation()
	 * @generated
	 */
	void setFinOperation(String value);

} // Return
