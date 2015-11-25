/**
 */
package exo1;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link exo1.Project#getName <em>Name</em>}</li>
 *   <li>{@link exo1.Project#getBudget <em>Budget</em>}</li>
 *   <li>{@link exo1.Project#getDepartement <em>Departement</em>}</li>
 *   <li>{@link exo1.Project#getEmployees <em>Employees</em>}</li>
 * </ul>
 * </p>
 *
 * @see exo1.Exo1Package#getProject()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='C3'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot C3='self.departement.employees->includesAll(self.employees)'"
 * @generated
 */
public interface Project extends EObject {
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
	 * @see exo1.Exo1Package#getProject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link exo1.Project#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see exo1.Exo1Package#getProject_Budget()
	 * @model required="true"
	 * @generated
	 */
	int getBudget();

	/**
	 * Sets the value of the '{@link exo1.Project#getBudget <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Budget</em>' attribute.
	 * @see #getBudget()
	 * @generated
	 */
	void setBudget(int value);

	/**
	 * Returns the value of the '<em><b>Departement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link exo1.Departement#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Departement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Departement</em>' reference.
	 * @see #setDepartement(Departement)
	 * @see exo1.Exo1Package#getProject_Departement()
	 * @see exo1.Departement#getProjects
	 * @model opposite="projects" required="true"
	 * @generated
	 */
	Departement getDepartement();

	/**
	 * Sets the value of the '{@link exo1.Project#getDepartement <em>Departement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Departement</em>' reference.
	 * @see #getDepartement()
	 * @generated
	 */
	void setDepartement(Departement value);

	/**
	 * Returns the value of the '<em><b>Employees</b></em>' reference list.
	 * The list contents are of type {@link exo1.Employee}.
	 * It is bidirectional and its opposite is '{@link exo1.Employee#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employees</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employees</em>' reference list.
	 * @see exo1.Exo1Package#getProject_Employees()
	 * @see exo1.Employee#getProjects
	 * @model opposite="projects"
	 * @generated
	 */
	EList<Employee> getEmployees();

} // Project
