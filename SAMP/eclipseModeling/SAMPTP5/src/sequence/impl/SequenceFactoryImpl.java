/**
 */
package sequence.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import sequence.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SequenceFactoryImpl extends EFactoryImpl implements SequenceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SequenceFactory init() {
		try {
			SequenceFactory theSequenceFactory = (SequenceFactory)EPackage.Registry.INSTANCE.getEFactory(SequencePackage.eNS_URI);
			if (theSequenceFactory != null) {
				return theSequenceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SequenceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SequencePackage.EXPRESSION: return createExpression();
			case SequencePackage.IDENTIFIANT: return createIdentifiant();
			case SequencePackage.NOMBRE: return createNombre();
			case SequencePackage.AFFECTATION: return createAffectation();
			case SequencePackage.RETURN: return createReturn();
			case SequencePackage.ADDITION: return createAddition();
			case SequencePackage.SOUSTRACTION: return createSoustraction();
			case SequencePackage.DIVISION: return createDivision();
			case SequencePackage.MULTIPLICATION: return createMultiplication();
			case SequencePackage.SEQUENCE_INSTRUCTIONS: return createsequenceInstructions();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiant createIdentifiant() {
		IdentifiantImpl identifiant = new IdentifiantImpl();
		return identifiant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Nombre createNombre() {
		NombreImpl nombre = new NombreImpl();
		return nombre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Affectation createAffectation() {
		AffectationImpl affectation = new AffectationImpl();
		return affectation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Return createReturn() {
		ReturnImpl return_ = new ReturnImpl();
		return return_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Addition createAddition() {
		AdditionImpl addition = new AdditionImpl();
		return addition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Soustraction createSoustraction() {
		SoustractionImpl soustraction = new SoustractionImpl();
		return soustraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Division createDivision() {
		DivisionImpl division = new DivisionImpl();
		return division;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Multiplication createMultiplication() {
		MultiplicationImpl multiplication = new MultiplicationImpl();
		return multiplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public sequenceInstructions createsequenceInstructions() {
		sequenceInstructionsImpl sequenceInstructions = new sequenceInstructionsImpl();
		return sequenceInstructions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequencePackage getSequencePackage() {
		return (SequencePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SequencePackage getPackage() {
		return SequencePackage.eINSTANCE;
	}

} //SequenceFactoryImpl
