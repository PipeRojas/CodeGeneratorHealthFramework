/*
 * generated by Xtext 2.11.0
 */
package edu.eci.prot.dsl2.serializer;

import com.google.inject.Inject;
import edu.eci.prot.dsl2.dsl2.DataType;
import edu.eci.prot.dsl2.dsl2.Domainmodel;
import edu.eci.prot.dsl2.dsl2.Dsl2Package;
import edu.eci.prot.dsl2.dsl2.Entity;
import edu.eci.prot.dsl2.dsl2.Feature;
import edu.eci.prot.dsl2.dsl2.Import;
import edu.eci.prot.dsl2.dsl2.PackageDeclaration;
import edu.eci.prot.dsl2.services.Dsl2GrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class Dsl2SemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private Dsl2GrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Dsl2Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Dsl2Package.DATA_TYPE:
				sequence_DataType(context, (DataType) semanticObject); 
				return; 
			case Dsl2Package.DOMAINMODEL:
				sequence_Domainmodel(context, (Domainmodel) semanticObject); 
				return; 
			case Dsl2Package.ENTITY:
				sequence_Entity(context, (Entity) semanticObject); 
				return; 
			case Dsl2Package.FEATURE:
				sequence_Feature(context, (Feature) semanticObject); 
				return; 
			case Dsl2Package.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case Dsl2Package.PACKAGE_DECLARATION:
				sequence_PackageDeclaration(context, (PackageDeclaration) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     AbstractElement returns DataType
	 *     Type returns DataType
	 *     DataType returns DataType
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_DataType(ISerializationContext context, DataType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Dsl2Package.Literals.ABSTRACT_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Dsl2Package.Literals.ABSTRACT_ELEMENT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Domainmodel returns Domainmodel
	 *
	 * Constraint:
	 *     elements+=AbstractElement+
	 */
	protected void sequence_Domainmodel(ISerializationContext context, Domainmodel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AbstractElement returns Entity
	 *     Type returns Entity
	 *     Entity returns Entity
	 *
	 * Constraint:
	 *     (name=ID superType=[Entity|QualifiedName]? service?='service'? imports+=Import* features+=Feature*)
	 */
	protected void sequence_Entity(ISerializationContext context, Entity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns Feature
	 *
	 * Constraint:
	 *     (name=ID many?='many'? type=[Type|QualifiedName])
	 */
	protected void sequence_Feature(ISerializationContext context, Feature semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Import returns Import
	 *
	 * Constraint:
	 *     importedNamespace=QualifiedNameWithWildcard
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Dsl2Package.Literals.IMPORT__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Dsl2Package.Literals.IMPORT__IMPORTED_NAMESPACE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PackageDeclaration returns PackageDeclaration
	 *     AbstractElement returns PackageDeclaration
	 *
	 * Constraint:
	 *     (name=QualifiedName elements+=AbstractElement*)
	 */
	protected void sequence_PackageDeclaration(ISerializationContext context, PackageDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
