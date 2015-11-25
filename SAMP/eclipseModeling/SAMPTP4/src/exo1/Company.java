/**
 */
package exo1;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link exo1.Company#getEmployees <em>Employees</em>}</li>
 *   <li>{@link exo1.Company#getProjets <em>Projets</em>}</li>
 *   <li>{@link exo1.Company#getDepartements <em>Departements</em>}</li>
 * </ul>
 * </p>
 *
 * @see exo1.Exo1Package#getCompany()
 * @model
 * @generated
 */
public interface Company extends EObject {
	/**
	 * Returns the value of the '<em><b>Employees</b></em>' containment reference list.
	 * The list contents are of type {@link exo1.Employee}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employees</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employees</em>' containment reference list.
	 * @see exo1.Exo1Package#getCompany_Employees()
	 * @model containment="true"
	 * @generated
	 */
	EList<Employee> getEmployees();

	/**
	 * Returns the value of the '<em><b>Projets</b></em>' containment reference list.
	 * The list contents are of type {@link exo1.Project}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projets</em>' containment reference list.
	 * @see exo1.Exo1Package#getCompany_Projets()
	 * @model containment="true"
	 * @generated
	 */
	EList<Project> getProjets();

	/**
	 * Returns the value of the '<em><b>Departements</b></em>' containment reference list.
	 * The list contents are of type {@link exo1.Departement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Departements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Departements</em>' containment reference list.
	 * @see exo1.Exo1Package#getCompany_Departements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Departement> getDepartements();

} // Company
