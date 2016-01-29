/**
 */
package samp;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see samp.SampPackage
 * @generated
 */
public interface SampFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SampFactory eINSTANCE = samp.impl.SampFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Affectation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Affectation</em>'.
	 * @generated
	 */
	Affectation createAffectation();

	/**
	 * Returns a new object of class '<em>Return</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Return</em>'.
	 * @generated
	 */
	Return createReturn();

	/**
	 * Returns a new object of class '<em>Nombre</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nombre</em>'.
	 * @generated
	 */
	Nombre createNombre();

	/**
	 * Returns a new object of class '<em>Identitfiant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identitfiant</em>'.
	 * @generated
	 */
	Identitfiant createIdentitfiant();

	/**
	 * Returns a new object of class '<em>Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instruction</em>'.
	 * @generated
	 */
	Instruction createInstruction();

	/**
	 * Returns a new object of class '<em>Multiplication</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplication</em>'.
	 * @generated
	 */
	Multiplication createMultiplication();

	/**
	 * Returns a new object of class '<em>Bin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bin</em>'.
	 * @generated
	 */
	Bin createBin();

	/**
	 * Returns a new object of class '<em>Addition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Addition</em>'.
	 * @generated
	 */
	Addition createAddition();

	/**
	 * Returns a new object of class '<em>Soustraction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Soustraction</em>'.
	 * @generated
	 */
	Soustraction createSoustraction();

	/**
	 * Returns a new object of class '<em>Division</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Division</em>'.
	 * @generated
	 */
	Division createDivision();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SampPackage getSampPackage();

} //SampFactory
