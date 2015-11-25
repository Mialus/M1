/**
 */
package exo1.impl;

import exo1.Company;
import exo1.Departement;
import exo1.Employee;
import exo1.Exo1Package;
import exo1.Project;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link exo1.impl.CompanyImpl#getEmployees <em>Employees</em>}</li>
 *   <li>{@link exo1.impl.CompanyImpl#getProjets <em>Projets</em>}</li>
 *   <li>{@link exo1.impl.CompanyImpl#getDepartements <em>Departements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompanyImpl extends MinimalEObjectImpl.Container implements Company {
	/**
	 * The cached value of the '{@link #getEmployees() <em>Employees</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployees()
	 * @generated
	 * @ordered
	 */
	protected EList<Employee> employees;

	/**
	 * The cached value of the '{@link #getProjets() <em>Projets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjets()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> projets;

	/**
	 * The cached value of the '{@link #getDepartements() <em>Departements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartements()
	 * @generated
	 * @ordered
	 */
	protected EList<Departement> departements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompanyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Exo1Package.Literals.COMPANY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Employee> getEmployees() {
		if (employees == null) {
			employees = new EObjectContainmentEList<Employee>(Employee.class, this, Exo1Package.COMPANY__EMPLOYEES);
		}
		return employees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Project> getProjets() {
		if (projets == null) {
			projets = new EObjectContainmentEList<Project>(Project.class, this, Exo1Package.COMPANY__PROJETS);
		}
		return projets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Departement> getDepartements() {
		if (departements == null) {
			departements = new EObjectContainmentEList<Departement>(Departement.class, this, Exo1Package.COMPANY__DEPARTEMENTS);
		}
		return departements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Exo1Package.COMPANY__EMPLOYEES:
				return ((InternalEList<?>)getEmployees()).basicRemove(otherEnd, msgs);
			case Exo1Package.COMPANY__PROJETS:
				return ((InternalEList<?>)getProjets()).basicRemove(otherEnd, msgs);
			case Exo1Package.COMPANY__DEPARTEMENTS:
				return ((InternalEList<?>)getDepartements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Exo1Package.COMPANY__EMPLOYEES:
				return getEmployees();
			case Exo1Package.COMPANY__PROJETS:
				return getProjets();
			case Exo1Package.COMPANY__DEPARTEMENTS:
				return getDepartements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Exo1Package.COMPANY__EMPLOYEES:
				getEmployees().clear();
				getEmployees().addAll((Collection<? extends Employee>)newValue);
				return;
			case Exo1Package.COMPANY__PROJETS:
				getProjets().clear();
				getProjets().addAll((Collection<? extends Project>)newValue);
				return;
			case Exo1Package.COMPANY__DEPARTEMENTS:
				getDepartements().clear();
				getDepartements().addAll((Collection<? extends Departement>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Exo1Package.COMPANY__EMPLOYEES:
				getEmployees().clear();
				return;
			case Exo1Package.COMPANY__PROJETS:
				getProjets().clear();
				return;
			case Exo1Package.COMPANY__DEPARTEMENTS:
				getDepartements().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Exo1Package.COMPANY__EMPLOYEES:
				return employees != null && !employees.isEmpty();
			case Exo1Package.COMPANY__PROJETS:
				return projets != null && !projets.isEmpty();
			case Exo1Package.COMPANY__DEPARTEMENTS:
				return departements != null && !departements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompanyImpl
