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
 * An implementation of the model object '<em><b>Departement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link exo1.impl.DepartementImpl#getName <em>Name</em>}</li>
 *   <li>{@link exo1.impl.DepartementImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link exo1.impl.DepartementImpl#getBudget <em>Budget</em>}</li>
 *   <li>{@link exo1.impl.DepartementImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link exo1.impl.DepartementImpl#getEmployees <em>Employees</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DepartementImpl extends MinimalEObjectImpl.Container implements Departement {
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
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getBudget() <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBudget()
	 * @generated
	 * @ordered
	 */
	protected static final int BUDGET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBudget() <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBudget()
	 * @generated
	 * @ordered
	 */
	protected int budget = BUDGET_EDEFAULT;

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
	 * The cached value of the '{@link #getEmployees() <em>Employees</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployees()
	 * @generated
	 * @ordered
	 */
	protected EList<Employee> employees;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DepartementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Exo1Package.Literals.DEPARTEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Exo1Package.DEPARTEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Exo1Package.DEPARTEMENT__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBudget() {
		return budget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBudget(int newBudget) {
		int oldBudget = budget;
		budget = newBudget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Exo1Package.DEPARTEMENT__BUDGET, oldBudget, budget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Project> getProjects() {
		if (projects == null) {
			projects = new EObjectWithInverseResolvingEList<Project>(Project.class, this, Exo1Package.DEPARTEMENT__PROJECTS, Exo1Package.PROJECT__DEPARTEMENT);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Employee> getEmployees() {
		if (employees == null) {
			employees = new EObjectWithInverseResolvingEList.ManyInverse<Employee>(Employee.class, this, Exo1Package.DEPARTEMENT__EMPLOYEES, Exo1Package.EMPLOYEE__DEPARTEMENTS);
		}
		return employees;
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
			case Exo1Package.DEPARTEMENT__PROJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProjects()).basicAdd(otherEnd, msgs);
			case Exo1Package.DEPARTEMENT__EMPLOYEES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEmployees()).basicAdd(otherEnd, msgs);
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
			case Exo1Package.DEPARTEMENT__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
			case Exo1Package.DEPARTEMENT__EMPLOYEES:
				return ((InternalEList<?>)getEmployees()).basicRemove(otherEnd, msgs);
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
			case Exo1Package.DEPARTEMENT__NAME:
				return getName();
			case Exo1Package.DEPARTEMENT__LOCATION:
				return getLocation();
			case Exo1Package.DEPARTEMENT__BUDGET:
				return getBudget();
			case Exo1Package.DEPARTEMENT__PROJECTS:
				return getProjects();
			case Exo1Package.DEPARTEMENT__EMPLOYEES:
				return getEmployees();
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
			case Exo1Package.DEPARTEMENT__NAME:
				setName((String)newValue);
				return;
			case Exo1Package.DEPARTEMENT__LOCATION:
				setLocation((String)newValue);
				return;
			case Exo1Package.DEPARTEMENT__BUDGET:
				setBudget((Integer)newValue);
				return;
			case Exo1Package.DEPARTEMENT__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends Project>)newValue);
				return;
			case Exo1Package.DEPARTEMENT__EMPLOYEES:
				getEmployees().clear();
				getEmployees().addAll((Collection<? extends Employee>)newValue);
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
			case Exo1Package.DEPARTEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Exo1Package.DEPARTEMENT__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case Exo1Package.DEPARTEMENT__BUDGET:
				setBudget(BUDGET_EDEFAULT);
				return;
			case Exo1Package.DEPARTEMENT__PROJECTS:
				getProjects().clear();
				return;
			case Exo1Package.DEPARTEMENT__EMPLOYEES:
				getEmployees().clear();
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
			case Exo1Package.DEPARTEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Exo1Package.DEPARTEMENT__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case Exo1Package.DEPARTEMENT__BUDGET:
				return budget != BUDGET_EDEFAULT;
			case Exo1Package.DEPARTEMENT__PROJECTS:
				return projects != null && !projects.isEmpty();
			case Exo1Package.DEPARTEMENT__EMPLOYEES:
				return employees != null && !employees.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", location: ");
		result.append(location);
		result.append(", budget: ");
		result.append(budget);
		result.append(')');
		return result.toString();
	}

} //DepartementImpl
