/**
 */
package samp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nombre</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link samp.Nombre#getNb <em>Nb</em>}</li>
 * </ul>
 *
 * @see samp.SampPackage#getNombre()
 * @model
 * @generated
 */
public interface Nombre extends Expression {
	/**
	 * Returns the value of the '<em><b>Nb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb</em>' attribute.
	 * @see #setNb(double)
	 * @see samp.SampPackage#getNombre_Nb()
	 * @model
	 * @generated
	 */
	double getNb();

	/**
	 * Sets the value of the '{@link samp.Nombre#getNb <em>Nb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb</em>' attribute.
	 * @see #getNb()
	 * @generated
	 */
	void setNb(double value);

} // Nombre
