/**
 */
package exo1.impl;

import exo1.Departement;
import exo1.Employee;
import exo1.Exo1Package;
import exo1.Project;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link exo1.impl.EmployeeImpl#getSalary <em>Salary</em>}</li>
 *   <li>{@link exo1.impl.EmployeeImpl#getName <em>Name</em>}</li>
 *   <li>{@link exo1.impl.EmployeeImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link exo1.impl.EmployeeImpl#getDepartements <em>Departements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmployeeImpl extends MinimalEObjectImpl.Container implements Employee {
	/**
	 * The default value of the '{@link #getSalary() <em>Salary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalary()
	 * @generated
	 * @ordered
	 */
	protected static final String SALARY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSalary() <em>Salary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalary()
	 * @generated
	 * @ordered
	 */
	protected String salary = SALARY_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> projects;

	/**
	 * The cached value of the '{@link #getDepartements() <em>Departements</em>}' reference list.
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
	protected EmployeeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Exo1Package.Literals.EMPLOYEE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSalary(String newSalary) {
		String oldSalary = salary;
		salary = newSalary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Exo1Package.EMPLOYEE__SALARY, oldSalary, salary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Exo1Package.EMPLOYEE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Project> getProjects() {
		if (projects == null) {
			projects = new EObjectWithInverseResolvingEList.ManyInverse<Project>(Project.class, this, Exo1Package.EMPLOYEE__PROJECTS, Exo1Package.PROJECT__EMPLOYEES);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Departement> getDepartements() {
		if (departements == null) {
			departements = new EObjectWithInverseResolvingEList.ManyInverse<Departement>(Departement.class, this, Exo1Package.EMPLOYEE__DEPARTEMENTS, Exo1Package.DEPARTEMENT__EMPLOYEES);
		}
		return departements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Exo1Package.EMPLOYEE__PROJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProjects()).basicAdd(otherEnd, msgs);
			case Exo1Package.EMPLOYEE__DEPARTEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDepartements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Exo1Package.EMPLOYEE__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
			case Exo1Package.EMPLOYEE__DEPARTEMENTS:
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
			case Exo1Package.EMPLOYEE__SALARY:
				return getSalary();
			case Exo1Package.EMPLOYEE__NAME:
				return getName();
			case Exo1Package.EMPLOYEE__PROJECTS:
				return getProjects();
			case Exo1Package.EMPLOYEE__DEPARTEMENTS:
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
			case Exo1Package.EMPLOYEE__SALARY:
				setSalary((String)newValue);
				return;
			case Exo1Package.EMPLOYEE__NAME:
				setName((String)newValue);
				return;
			case Exo1Package.EMPLOYEE__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends Project>)newValue);
				return;
			case Exo1Package.EMPLOYEE__DEPARTEMENTS:
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
			case Exo1Package.EMPLOYEE__SALARY:
				setSalary(SALARY_EDEFAULT);
				return;
			case Exo1Package.EMPLOYEE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Exo1Package.EMPLOYEE__PROJECTS:
				getProjects().clear();
				return;
			case Exo1Package.EMPLOYEE__DEPARTEMENTS:
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
			case Exo1Package.EMPLOYEE__SALARY:
				return SALARY_EDEFAULT == null ? salary != null : !SALARY_EDEFAULT.equals(salary);
			case Exo1Package.EMPLOYEE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Exo1Package.EMPLOYEE__PROJECTS:
				return projects != null && !projects.isEmpty();
			case Exo1Package.EMPLOYEE__DEPARTEMENTS:
				return departements != null && !departements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (salary: ");
		result.append(salary);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EmployeeImpl
