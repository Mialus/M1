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
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link exo1.impl.ProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link exo1.impl.ProjectImpl#getBudget <em>Budget</em>}</li>
 *   <li>{@link exo1.impl.ProjectImpl#getDepartement <em>Departement</em>}</li>
 *   <li>{@link exo1.impl.ProjectImpl#getEmployees <em>Employees</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectImpl extends MinimalEObjectImpl.Container implements Project {
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
	 * The cached value of the '{@link #getDepartement() <em>Departement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartement()
	 * @generated
	 * @ordered
	 */
	protected Departement departement;

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
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Exo1Package.Literals.PROJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Exo1Package.PROJECT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Exo1Package.PROJECT__BUDGET, oldBudget, budget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Departement getDepartement() {
		if (departement != null && departement.eIsProxy()) {
			InternalEObject oldDepartement = (InternalEObject)departement;
			departement = (Departement)eResolveProxy(oldDepartement);
			if (departement != oldDepartement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Exo1Package.PROJECT__DEPARTEMENT, oldDepartement, departement));
			}
		}
		return departement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Departement basicGetDepartement() {
		return departement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDepartement(Departement newDepartement, NotificationChain msgs) {
		Departement oldDepartement = departement;
		departement = newDepartement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Exo1Package.PROJECT__DEPARTEMENT, oldDepartement, newDepartement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartement(Departement newDepartement) {
		if (newDepartement != departement) {
			NotificationChain msgs = null;
			if (departement != null)
				msgs = ((InternalEObject)departement).eInverseRemove(this, Exo1Package.DEPARTEMENT__PROJECTS, Departement.class, msgs);
			if (newDepartement != null)
				msgs = ((InternalEObject)newDepartement).eInverseAdd(this, Exo1Package.DEPARTEMENT__PROJECTS, Departement.class, msgs);
			msgs = basicSetDepartement(newDepartement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Exo1Package.PROJECT__DEPARTEMENT, newDepartement, newDepartement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Employee> getEmployees() {
		if (employees == null) {
			employees = new EObjectWithInverseResolvingEList.ManyInverse<Employee>(Employee.class, this, Exo1Package.PROJECT__EMPLOYEES, Exo1Package.EMPLOYEE__PROJECTS);
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
			case Exo1Package.PROJECT__DEPARTEMENT:
				if (departement != null)
					msgs = ((InternalEObject)departement).eInverseRemove(this, Exo1Package.DEPARTEMENT__PROJECTS, Departement.class, msgs);
				return basicSetDepartement((Departement)otherEnd, msgs);
			case Exo1Package.PROJECT__EMPLOYEES:
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
			case Exo1Package.PROJECT__DEPARTEMENT:
				return basicSetDepartement(null, msgs);
			case Exo1Package.PROJECT__EMPLOYEES:
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
			case Exo1Package.PROJECT__NAME:
				return getName();
			case Exo1Package.PROJECT__BUDGET:
				return getBudget();
			case Exo1Package.PROJECT__DEPARTEMENT:
				if (resolve) return getDepartement();
				return basicGetDepartement();
			case Exo1Package.PROJECT__EMPLOYEES:
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
			case Exo1Package.PROJECT__NAME:
				setName((String)newValue);
				return;
			case Exo1Package.PROJECT__BUDGET:
				setBudget((Integer)newValue);
				return;
			case Exo1Package.PROJECT__DEPARTEMENT:
				setDepartement((Departement)newValue);
				return;
			case Exo1Package.PROJECT__EMPLOYEES:
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
			case Exo1Package.PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Exo1Package.PROJECT__BUDGET:
				setBudget(BUDGET_EDEFAULT);
				return;
			case Exo1Package.PROJECT__DEPARTEMENT:
				setDepartement((Departement)null);
				return;
			case Exo1Package.PROJECT__EMPLOYEES:
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
			case Exo1Package.PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Exo1Package.PROJECT__BUDGET:
				return budget != BUDGET_EDEFAULT;
			case Exo1Package.PROJECT__DEPARTEMENT:
				return departement != null;
			case Exo1Package.PROJECT__EMPLOYEES:
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
		result.append(", budget: ");
		result.append(budget);
		result.append(')');
		return result.toString();
	}

} //ProjectImpl
