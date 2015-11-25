/**
 */
package exo1;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link exo1.Employee#getSalary <em>Salary</em>}</li>
 *   <li>{@link exo1.Employee#getName <em>Name</em>}</li>
 *   <li>{@link exo1.Employee#getProjects <em>Projects</em>}</li>
 *   <li>{@link exo1.Employee#getDepartements <em>Departements</em>}</li>
 * </ul>
 * </p>
 *
 * @see exo1.Exo1Package#getEmployee()
 * @model
 * @generated
 */
public interface Employee extends EObject {
	/**
	 * Returns the value of the '<em><b>Salary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Salary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Salary</em>' attribute.
	 * @see #setSalary(String)
	 * @see exo1.Exo1Package#getEmployee_Salary()
	 * @model
	 * @generated
	 */
	String getSalary();

	/**
	 * Sets the value of the '{@link exo1.Employee#getSalary <em>Salary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Salary</em>' attribute.
	 * @see #getSalary()
	 * @generated
	 */
	void setSalary(String value);

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
	 * @see exo1.Exo1Package#getEmployee_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link exo1.Employee#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' reference list.
	 * The list contents are of type {@link exo1.Project}.
	 * It is bidirectional and its opposite is '{@link exo1.Project#getEmployees <em>Employees</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' reference list.
	 * @see exo1.Exo1Package#getEmployee_Projects()
	 * @see exo1.Project#getEmployees
	 * @model opposite="employees"
	 * @generated
	 */
	EList<Project> getProjects();

	/**
	 * Returns the value of the '<em><b>Departements</b></em>' reference list.
	 * The list contents are of type {@link exo1.Departement}.
	 * It is bidirectional and its opposite is '{@link exo1.Departement#getEmployees <em>Employees</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Departements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Departements</em>' reference list.
	 * @see exo1.Exo1Package#getEmployee_Departements()
	 * @see exo1.Departement#getEmployees
	 * @model opposite="employees" required="true"
	 * @generated
	 */
	EList<Departement> getDepartements();

} // Employee
