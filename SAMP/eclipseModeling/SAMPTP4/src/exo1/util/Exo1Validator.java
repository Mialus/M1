/**
 */
package exo1.util;

import exo1.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see exo1.Exo1Package
 * @generated
 */
public class Exo1Validator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final Exo1Validator INSTANCE = new Exo1Validator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "exo1";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exo1Validator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return Exo1Package.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case Exo1Package.DEPARTEMENT:
				return validateDepartement((Departement)value, diagnostics, context);
			case Exo1Package.PROJECT:
				return validateProject((Project)value, diagnostics, context);
			case Exo1Package.EMPLOYEE:
				return validateEmployee((Employee)value, diagnostics, context);
			case Exo1Package.COMPANY:
				return validateCompany((Company)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDepartement(Departement departement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(departement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(departement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(departement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(departement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(departement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(departement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(departement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(departement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(departement, diagnostics, context);
		if (result || diagnostics != null) result &= validateDepartement_C1(departement, diagnostics, context);
		if (result || diagnostics != null) result &= validateDepartement_C2(departement, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the C1 constraint of '<em>Departement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String DEPARTEMENT__C1__EEXPRESSION = "self.employees->size() >= self.projects->size()";

	/**
	 * Validates the C1 constraint of '<em>Departement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDepartement_C1(Departement departement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Exo1Package.Literals.DEPARTEMENT,
				 departement,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "C1",
				 DEPARTEMENT__C1__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the C2 constraint of '<em>Departement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String DEPARTEMENT__C2__EEXPRESSION = "self.projects->collect(p : Project | p.budget)->sum() <= self.budget";

	/**
	 * Validates the C2 constraint of '<em>Departement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDepartement_C2(Departement departement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Exo1Package.Literals.DEPARTEMENT,
				 departement,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "C2",
				 DEPARTEMENT__C2__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProject(Project project, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(project, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(project, diagnostics, context);
		if (result || diagnostics != null) result &= validateProject_C3(project, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the C3 constraint of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PROJECT__C3__EEXPRESSION = "self.departement.employees->includesAll(self.employees)";

	/**
	 * Validates the C3 constraint of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProject_C3(Project project, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Exo1Package.Literals.PROJECT,
				 project,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "C3",
				 PROJECT__C3__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmployee(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(employee, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompany(Company company, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(company, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //Exo1Validator
