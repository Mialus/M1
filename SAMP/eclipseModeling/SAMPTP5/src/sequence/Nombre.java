/**
 */
package sequence;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nombre</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sequence.Nombre#getValeur <em>Valeur</em>}</li>
 * </ul>
 * </p>
 *
 * @see sequence.SequencePackage#getNombre()
 * @model
 * @generated
 */
public interface Nombre extends Expression {
	/**
	 * Returns the value of the '<em><b>Valeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valeur</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valeur</em>' attribute.
	 * @see #setValeur(double)
	 * @see sequence.SequencePackage#getNombre_Valeur()
	 * @model
	 * @generated
	 */
	double getValeur();

	/**
	 * Sets the value of the '{@link sequence.Nombre#getValeur <em>Valeur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valeur</em>' attribute.
	 * @see #getValeur()
	 * @generated
	 */
	void setValeur(double value);

} // Nombre
