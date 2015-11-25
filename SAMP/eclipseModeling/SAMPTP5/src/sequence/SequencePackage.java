/**
 */
package sequence;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see sequence.SequenceFactory
 * @model kind="package"
 * @generated
 */
public interface SequencePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sequence";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sequence";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sequence";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SequencePackage eINSTANCE = sequence.impl.SequencePackageImpl.init();

	/**
	 * The meta object id for the '{@link sequence.impl.InstructionImpl <em>Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sequence.impl.InstructionImpl
	 * @see sequence.impl.SequencePackageImpl#getInstruction()
	 * @generated
	 */
	int INSTRUCTION = 0;

	/**
	 * The number of structural features of the '<em>Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link sequence.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sequence.impl.ExpressionImpl
	 * @see sequence.impl.SequencePackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Return</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__RETURN = 1;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__NOMBRE = 2;

	/**
	 * The feature id for the '<em><b>Identifiants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__IDENTIFIANTS = 3;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__OPERATIONS = 4;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link sequence.impl.IdentifiantImpl <em>Identifiant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sequence.impl.IdentifiantImpl
	 * @see sequence.impl.SequencePackageImpl#getIdentifiant()
	 * @generated
	 */
	int IDENTIFIANT = 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIANT__EXPRESSION = EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Return</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIANT__RETURN = EXPRESSION__RETURN;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIANT__NOMBRE = EXPRESSION__NOMBRE;

	/**
	 * The feature id for the '<em><b>Identifiants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIANT__IDENTIFIANTS = EXPRESSION__IDENTIFIANTS;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIANT__OPERATIONS = EXPRESSION__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Identifiant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIANT__IDENTIFIANT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIANT__NAME = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Identifiant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIANT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Identifiant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIANT_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link sequence.impl.NombreImpl <em>Nombre</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sequence.impl.NombreImpl
	 * @see sequence.impl.SequencePackageImpl#getNombre()
	 * @generated
	 */
	int NOMBRE = 3;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMBRE__EXPRESSION = EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Return</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMBRE__RETURN = EXPRESSION__RETURN;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMBRE__NOMBRE = EXPRESSION__NOMBRE;

	/**
	 * The feature id for the '<em><b>Identifiants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMBRE__IDENTIFIANTS = EXPRESSION__IDENTIFIANTS;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMBRE__OPERATIONS = EXPRESSION__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Valeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMBRE__VALEUR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Nombre</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMBRE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Nombre</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMBRE_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link sequence.impl.AffectationImpl <em>Affectation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sequence.impl.AffectationImpl
	 * @see sequence.impl.SequencePackageImpl#getAffectation()
	 * @generated
	 */
	int AFFECTATION = 4;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFECTATION__OPERATION = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fin Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFECTATION__FIN_OPERATION = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Affectation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFECTATION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Affectation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFECTATION_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link sequence.impl.ReturnImpl <em>Return</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sequence.impl.ReturnImpl
	 * @see sequence.impl.SequencePackageImpl#getReturn()
	 * @generated
	 */
	int RETURN = 5;

	/**
	 * The feature id for the '<em><b>Return</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__RETURN = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fin Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__FIN_OPERATION = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link sequence.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sequence.impl.OperationImpl
	 * @see sequence.impl.SequencePackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 11;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__EXPRESSIONS = 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link sequence.impl.AdditionImpl <em>Addition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sequence.impl.AdditionImpl
	 * @see sequence.impl.SequencePackageImpl#getAddition()
	 * @generated
	 */
	int ADDITION = 6;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION__EXPRESSIONS = OPERATION__EXPRESSIONS;

	/**
	 * The number of structural features of the '<em>Addition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Addition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link sequence.impl.SoustractionImpl <em>Soustraction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sequence.impl.SoustractionImpl
	 * @see sequence.impl.SequencePackageImpl#getSoustraction()
	 * @generated
	 */
	int SOUSTRACTION = 7;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUSTRACTION__EXPRESSIONS = OPERATION__EXPRESSIONS;

	/**
	 * The number of structural features of the '<em>Soustraction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUSTRACTION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Soustraction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUSTRACTION_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link sequence.impl.DivisionImpl <em>Division</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sequence.impl.DivisionImpl
	 * @see sequence.impl.SequencePackageImpl#getDivision()
	 * @generated
	 */
	int DIVISION = 8;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION__EXPRESSIONS = OPERATION__EXPRESSIONS;

	/**
	 * The number of structural features of the '<em>Division</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Division</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link sequence.impl.MultiplicationImpl <em>Multiplication</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sequence.impl.MultiplicationImpl
	 * @see sequence.impl.SequencePackageImpl#getMultiplication()
	 * @generated
	 */
	int MULTIPLICATION = 9;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATION__EXPRESSIONS = OPERATION__EXPRESSIONS;

	/**
	 * The number of structural features of the '<em>Multiplication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Multiplication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATION_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link sequence.impl.sequenceInstructionsImpl <em>sequence Instructions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sequence.impl.sequenceInstructionsImpl
	 * @see sequence.impl.SequencePackageImpl#getsequenceInstructions()
	 * @generated
	 */
	int SEQUENCE_INSTRUCTIONS = 10;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_INSTRUCTIONS__INSTRUCTIONS = 0;

	/**
	 * The number of structural features of the '<em>sequence Instructions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_INSTRUCTIONS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>sequence Instructions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_INSTRUCTIONS_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link sequence.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction</em>'.
	 * @see sequence.Instruction
	 * @generated
	 */
	EClass getInstruction();

	/**
	 * Returns the meta object for class '{@link sequence.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see sequence.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the containment reference '{@link sequence.Expression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see sequence.Expression#getExpression()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link sequence.Expression#getReturn <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return</em>'.
	 * @see sequence.Expression#getReturn()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Return();

	/**
	 * Returns the meta object for the containment reference list '{@link sequence.Expression#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nombre</em>'.
	 * @see sequence.Expression#getNombre()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Nombre();

	/**
	 * Returns the meta object for the containment reference list '{@link sequence.Expression#getIdentifiants <em>Identifiants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Identifiants</em>'.
	 * @see sequence.Expression#getIdentifiants()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Identifiants();

	/**
	 * Returns the meta object for the containment reference list '{@link sequence.Expression#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see sequence.Expression#getOperations()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Operations();

	/**
	 * Returns the meta object for class '{@link sequence.Identifiant <em>Identifiant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiant</em>'.
	 * @see sequence.Identifiant
	 * @generated
	 */
	EClass getIdentifiant();

	/**
	 * Returns the meta object for the containment reference '{@link sequence.Identifiant#getIdentifiant <em>Identifiant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifiant</em>'.
	 * @see sequence.Identifiant#getIdentifiant()
	 * @see #getIdentifiant()
	 * @generated
	 */
	EReference getIdentifiant_Identifiant();

	/**
	 * Returns the meta object for the attribute '{@link sequence.Identifiant#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see sequence.Identifiant#getName()
	 * @see #getIdentifiant()
	 * @generated
	 */
	EAttribute getIdentifiant_Name();

	/**
	 * Returns the meta object for class '{@link sequence.Nombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nombre</em>'.
	 * @see sequence.Nombre
	 * @generated
	 */
	EClass getNombre();

	/**
	 * Returns the meta object for the attribute '{@link sequence.Nombre#getValeur <em>Valeur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valeur</em>'.
	 * @see sequence.Nombre#getValeur()
	 * @see #getNombre()
	 * @generated
	 */
	EAttribute getNombre_Valeur();

	/**
	 * Returns the meta object for class '{@link sequence.Affectation <em>Affectation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Affectation</em>'.
	 * @see sequence.Affectation
	 * @generated
	 */
	EClass getAffectation();

	/**
	 * Returns the meta object for the attribute '{@link sequence.Affectation#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see sequence.Affectation#getOperation()
	 * @see #getAffectation()
	 * @generated
	 */
	EAttribute getAffectation_Operation();

	/**
	 * Returns the meta object for the attribute '{@link sequence.Affectation#getFinOperation <em>Fin Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fin Operation</em>'.
	 * @see sequence.Affectation#getFinOperation()
	 * @see #getAffectation()
	 * @generated
	 */
	EAttribute getAffectation_FinOperation();

	/**
	 * Returns the meta object for class '{@link sequence.Return <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return</em>'.
	 * @see sequence.Return
	 * @generated
	 */
	EClass getReturn();

	/**
	 * Returns the meta object for the attribute '{@link sequence.Return#getReturn <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return</em>'.
	 * @see sequence.Return#getReturn()
	 * @see #getReturn()
	 * @generated
	 */
	EAttribute getReturn_Return();

	/**
	 * Returns the meta object for the attribute '{@link sequence.Return#getFinOperation <em>Fin Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fin Operation</em>'.
	 * @see sequence.Return#getFinOperation()
	 * @see #getReturn()
	 * @generated
	 */
	EAttribute getReturn_FinOperation();

	/**
	 * Returns the meta object for class '{@link sequence.Addition <em>Addition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Addition</em>'.
	 * @see sequence.Addition
	 * @generated
	 */
	EClass getAddition();

	/**
	 * Returns the meta object for class '{@link sequence.Soustraction <em>Soustraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Soustraction</em>'.
	 * @see sequence.Soustraction
	 * @generated
	 */
	EClass getSoustraction();

	/**
	 * Returns the meta object for class '{@link sequence.Division <em>Division</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Division</em>'.
	 * @see sequence.Division
	 * @generated
	 */
	EClass getDivision();

	/**
	 * Returns the meta object for class '{@link sequence.Multiplication <em>Multiplication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplication</em>'.
	 * @see sequence.Multiplication
	 * @generated
	 */
	EClass getMultiplication();

	/**
	 * Returns the meta object for class '{@link sequence.sequenceInstructions <em>sequence Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>sequence Instructions</em>'.
	 * @see sequence.sequenceInstructions
	 * @generated
	 */
	EClass getsequenceInstructions();

	/**
	 * Returns the meta object for the containment reference list '{@link sequence.sequenceInstructions#getInstructions <em>Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instructions</em>'.
	 * @see sequence.sequenceInstructions#getInstructions()
	 * @see #getsequenceInstructions()
	 * @generated
	 */
	EReference getsequenceInstructions_Instructions();

	/**
	 * Returns the meta object for class '{@link sequence.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see sequence.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link sequence.Operation#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see sequence.Operation#getExpressions()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Expressions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SequenceFactory getSequenceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link sequence.impl.InstructionImpl <em>Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sequence.impl.InstructionImpl
		 * @see sequence.impl.SequencePackageImpl#getInstruction()
		 * @generated
		 */
		EClass INSTRUCTION = eINSTANCE.getInstruction();

		/**
		 * The meta object literal for the '{@link sequence.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sequence.impl.ExpressionImpl
		 * @see sequence.impl.SequencePackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__EXPRESSION = eINSTANCE.getExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Return</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__RETURN = eINSTANCE.getExpression_Return();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__NOMBRE = eINSTANCE.getExpression_Nombre();

		/**
		 * The meta object literal for the '<em><b>Identifiants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__IDENTIFIANTS = eINSTANCE.getExpression_Identifiants();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__OPERATIONS = eINSTANCE.getExpression_Operations();

		/**
		 * The meta object literal for the '{@link sequence.impl.IdentifiantImpl <em>Identifiant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sequence.impl.IdentifiantImpl
		 * @see sequence.impl.SequencePackageImpl#getIdentifiant()
		 * @generated
		 */
		EClass IDENTIFIANT = eINSTANCE.getIdentifiant();

		/**
		 * The meta object literal for the '<em><b>Identifiant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIANT__IDENTIFIANT = eINSTANCE.getIdentifiant_Identifiant();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIANT__NAME = eINSTANCE.getIdentifiant_Name();

		/**
		 * The meta object literal for the '{@link sequence.impl.NombreImpl <em>Nombre</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sequence.impl.NombreImpl
		 * @see sequence.impl.SequencePackageImpl#getNombre()
		 * @generated
		 */
		EClass NOMBRE = eINSTANCE.getNombre();

		/**
		 * The meta object literal for the '<em><b>Valeur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOMBRE__VALEUR = eINSTANCE.getNombre_Valeur();

		/**
		 * The meta object literal for the '{@link sequence.impl.AffectationImpl <em>Affectation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sequence.impl.AffectationImpl
		 * @see sequence.impl.SequencePackageImpl#getAffectation()
		 * @generated
		 */
		EClass AFFECTATION = eINSTANCE.getAffectation();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AFFECTATION__OPERATION = eINSTANCE.getAffectation_Operation();

		/**
		 * The meta object literal for the '<em><b>Fin Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AFFECTATION__FIN_OPERATION = eINSTANCE.getAffectation_FinOperation();

		/**
		 * The meta object literal for the '{@link sequence.impl.ReturnImpl <em>Return</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sequence.impl.ReturnImpl
		 * @see sequence.impl.SequencePackageImpl#getReturn()
		 * @generated
		 */
		EClass RETURN = eINSTANCE.getReturn();

		/**
		 * The meta object literal for the '<em><b>Return</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RETURN__RETURN = eINSTANCE.getReturn_Return();

		/**
		 * The meta object literal for the '<em><b>Fin Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RETURN__FIN_OPERATION = eINSTANCE.getReturn_FinOperation();

		/**
		 * The meta object literal for the '{@link sequence.impl.AdditionImpl <em>Addition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sequence.impl.AdditionImpl
		 * @see sequence.impl.SequencePackageImpl#getAddition()
		 * @generated
		 */
		EClass ADDITION = eINSTANCE.getAddition();

		/**
		 * The meta object literal for the '{@link sequence.impl.SoustractionImpl <em>Soustraction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sequence.impl.SoustractionImpl
		 * @see sequence.impl.SequencePackageImpl#getSoustraction()
		 * @generated
		 */
		EClass SOUSTRACTION = eINSTANCE.getSoustraction();

		/**
		 * The meta object literal for the '{@link sequence.impl.DivisionImpl <em>Division</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sequence.impl.DivisionImpl
		 * @see sequence.impl.SequencePackageImpl#getDivision()
		 * @generated
		 */
		EClass DIVISION = eINSTANCE.getDivision();

		/**
		 * The meta object literal for the '{@link sequence.impl.MultiplicationImpl <em>Multiplication</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sequence.impl.MultiplicationImpl
		 * @see sequence.impl.SequencePackageImpl#getMultiplication()
		 * @generated
		 */
		EClass MULTIPLICATION = eINSTANCE.getMultiplication();

		/**
		 * The meta object literal for the '{@link sequence.impl.sequenceInstructionsImpl <em>sequence Instructions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sequence.impl.sequenceInstructionsImpl
		 * @see sequence.impl.SequencePackageImpl#getsequenceInstructions()
		 * @generated
		 */
		EClass SEQUENCE_INSTRUCTIONS = eINSTANCE.getsequenceInstructions();

		/**
		 * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_INSTRUCTIONS__INSTRUCTIONS = eINSTANCE.getsequenceInstructions_Instructions();

		/**
		 * The meta object literal for the '{@link sequence.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sequence.impl.OperationImpl
		 * @see sequence.impl.SequencePackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__EXPRESSIONS = eINSTANCE.getOperation_Expressions();

	}

} //SequencePackage
