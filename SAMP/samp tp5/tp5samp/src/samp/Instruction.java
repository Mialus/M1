/**
 */
package samp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link samp.Instruction#getSegmentation <em>Segmentation</em>}</li>
 * </ul>
 *
 * @see samp.SampPackage#getInstruction()
 * @model
 * @generated
 */
public interface Instruction extends EObject {
	/**
	 * Returns the value of the '<em><b>Segmentation</b></em>' containment reference list.
	 * The list contents are of type {@link samp.Sequence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segmentation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segmentation</em>' containment reference list.
	 * @see samp.SampPackage#getInstruction_Segmentation()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sequence> getSegmentation();

} // Instruction
