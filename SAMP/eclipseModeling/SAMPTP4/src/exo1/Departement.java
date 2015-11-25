/**
 */
package exo1;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Departement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link exo1.Departement#getName <em>Name</em>}</li>
 *   <li>{@link exo1.Departement#getLocation <em>Location</em>}</li>
 *   <li>{@link exo1.Departement#getBudget <em>Budget</em>}</li>
 *   <li>{@link exo1.Departement#getProjects <em>Projects</em>}</li>
 *   <li>{@link exo1.Departement#getEmployees <em>Employees</em>}</li>
 * </ul>
 * </p>
 *
 * @see exo1.Exo1Package#getDepartement()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='C1 C2'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot C1='self.employees->size() >= self.projects->size()' C2='self.projects->collect(p : Project | p.budget)->sum() <= self.budget'"
 * @generated
 */
public interface Departement extends EObject {
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
	 * @see exo1.Exo1Package#getDepartement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link exo1.Departement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see exo1.Exo1Package#getDepartement_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link exo1.Departement#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Budget</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Budget</em>' attribute.
	 * @see #setBudget(int)
	 * @see exo1.Exo1Package#getDepartement_Budget()
	 * @model required="true"
	 * @generated
	 */
	int getBudget();

	/**
	 * Sets the value of the '{@link exo1.Departement#getBudget <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Budget</em>' attribute.
	 * @see #getBudget()
	 * @generated
	 */
	void setBudget(int value);

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' reference list.
	 * The list contents are of type {@link exo1.Project}.
	 * It is bidirectional and its opposite is '{@link exo1.Project#getDepartement <em>Departement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' reference list.
	 * @see exo1.Exo1Package#getDepartement_Projects()
	 * @see exo1.Project#getDepartement
	 * @model opposite="departement"
	 * @generated
	 */
	EList<Project> getProjects();

	/**
	 * Returns the value of the '<em><b>Employees</b></em>' reference list.
	 * The list contents are of type {@link exo1.Employee}.
	 * It is bidirectional and its opposite is '{@link exo1.Employee#getDepartements <em>Departements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employees</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employees</em>' reference list.
	 * @see exo1.Exo1Package#getDepartement_Employees()
	 * @see exo1.Employee#getDepartements
	 * @model opposite="departements"
	 * @generated
	 */
	EList<Employee> getEmployees();

} // Departement
