/**
 * generated by Xtext 2.11.0
 */
package edu.eci.prot.dsl2.validation;

import com.google.common.collect.Iterables;
import edu.eci.prot.dsl2.dsl2.DataType;
import edu.eci.prot.dsl2.dsl2.Dsl2Package;
import edu.eci.prot.dsl2.dsl2.Entity;
import edu.eci.prot.dsl2.dsl2.Feature;
import edu.eci.prot.dsl2.dsl2.PackageDeclaration;
import edu.eci.prot.dsl2.validation.AbstractDsl2Validator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class Dsl2Validator extends AbstractDsl2Validator {
  @Check
  public void checkOnlyOnePrincipal(final Entity en) {
    int counter = 0;
    Iterable<Entity> _filter = Iterables.<Entity>filter(IteratorExtensions.<EObject>toIterable(en.eResource().getAllContents()), Entity.class);
    for (final Entity e : _filter) {
      boolean _isPrincipal = e.isPrincipal();
      if (_isPrincipal) {
        counter++;
      }
    }
    if ((counter > 1)) {
      this.error("Just one principal Entity must be present", Dsl2Package.Literals.ENTITY__PRINCIPAL);
    } else {
      if ((counter < 1)) {
        this.error("At least one principal Entity must be present", Dsl2Package.Literals.ENTITY__PRINCIPAL);
      }
    }
  }
  
  @Check
  public void checkRightPackageName(final PackageDeclaration p) {
    boolean _endsWith = p.getName().endsWith(".model");
    boolean _not = (!_endsWith);
    if (_not) {
      this.error("Package name must end with \".model\".", Dsl2Package.Literals.PACKAGE_DECLARATION__ELEMENTS);
    }
  }
  
  @Check
  public void checkManyCannotBeTransient(final Feature f) {
    if ((f.isMany() && f.isTransient())) {
      this.error("Feature with \"many\" property cannot have \"transient\" property", Dsl2Package.Literals.ENTITY__FEATURES);
    }
  }
  
  @Check
  public void checkValidDataType(final DataType d) {
    boolean _not = (!(((((((((d.getName().equals("Byte") || d.getName().equals("Short")) || d.getName().equals("Integer")) || d.getName().equals("Long")) || d.getName().equals("Float")) || d.getName().equals("Double")) || d.getName().equals("Char")) || d.getName().equals("String")) || d.getName().equals("Boolean")) || d.getName().equals("Date")));
    if (_not) {
      this.error("datatype must be a primitive type like: Byte or Short or Integer or Long or Float or Double or Character or String or Boolean or Date", Dsl2Package.Literals.ABSTRACT_ELEMENT__NAME);
    }
  }
  
  @Check
  public void checkNameRolePasswordAndIdForPrincipalEntity(final Entity e) {
    boolean flagName = false;
    boolean flagId = false;
    boolean flagPass = false;
    boolean flagRole = false;
    boolean _isPrincipal = e.isPrincipal();
    if (_isPrincipal) {
      for (int i = 0; ((i < e.getFeatures().size()) && (!(((flagName && flagId) && flagPass) && flagRole))); i++) {
        if ((e.getFeatures().get(i).getName().equals("id") && e.getFeatures().get(i).getType().getName().equals("Integer"))) {
          flagId = true;
        } else {
          if ((e.getFeatures().get(i).getName().equals("name") && e.getFeatures().get(i).getType().getName().equals("String"))) {
            flagName = true;
          } else {
            if ((e.getFeatures().get(i).getName().equals("password") && e.getFeatures().get(i).getType().getName().equals("String"))) {
              flagPass = true;
            } else {
              if ((e.getFeatures().get(i).getName().equals("role") && e.getFeatures().get(i).getType().getName().equals("String"))) {
                flagRole = true;
              }
            }
          }
        }
      }
      if (((((!flagId) || (!flagName)) || (!flagPass)) || (!flagRole))) {
        String _name = e.getName();
        String _plus = ("If " + _name);
        String _plus_1 = (_plus + " entity is principal, must have id of type Integer, password of type String, role of type String and name of type String features");
        this.error(_plus_1, Dsl2Package.Literals.ENTITY__FEATURES);
      }
    }
  }
  
  public void checkDiagnosticMustHaveDate(final Feature f) {
    boolean ans = false;
    boolean _isDiagnostic = f.isDiagnostic();
    if (_isDiagnostic) {
      Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(f.getType().eAllContents());
      for (final EObject inFea : _iterable) {
        {
          Feature feature = ((Feature) inFea);
          if ((feature.getName().equals("date") && feature.getType().getName().equals("Date"))) {
            ans = true;
          }
        }
      }
      if ((!ans)) {
        String _name = f.getName();
        String _plus = (_name + " feature is a diagnostic, so its entity must have an feature called \'date\' of type \'Date\'");
        this.error(_plus, Dsl2Package.Literals.FEATURE__TYPE);
      }
    }
  }
  
  @Check
  public void checkDiagnosticCannotBeDatatype(final Feature d) {
    if ((d.isDiagnostic() && (((((((((d.getType().getName().equals("Byte") || d.getType().getName().equals("Short")) || d.getType().getName().equals("Integer")) || d.getType().getName().equals("Long")) || d.getType().getName().equals("Float")) || d.getType().getName().equals("Double")) || d.getType().getName().equals("Char")) || d.getType().getName().equals("String")) || d.getType().getName().equals("Boolean")) || d.getType().getName().equals("Date")))) {
      this.error("Diagnostic feature must reference an entity and not an datatype", Dsl2Package.Literals.FEATURE__TYPE);
    } else {
      boolean _isDiagnostic = d.isDiagnostic();
      if (_isDiagnostic) {
        this.checkDiagnosticMustHaveDate(d);
      }
    }
  }
  
  @Check
  public void checkPrincipalIdCannotBeTransient(final Entity e) {
    boolean _isPrincipal = e.isPrincipal();
    if (_isPrincipal) {
      EList<Feature> _features = e.getFeatures();
      for (final Feature f : _features) {
        if ((f.getName().equals("id") && f.isTransient())) {
          this.error("Principal entity id cannot be transient", Dsl2Package.Literals.ENTITY__FEATURES);
        }
      }
    }
  }
  
  @Check
  public void checkComposedFeaturesCannotHaveComposedFeatures(final Feature f) {
    if (((!f.isMany()) && (IterableExtensions.size(IteratorExtensions.<EObject>toIterable(f.getType().eAllContents())) > 0))) {
      Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(f.getType().eAllContents());
      for (final EObject dat : _iterable) {
        {
          Feature feature = ((Feature) dat);
          if ((feature.isMany() || (IterableExtensions.size(IteratorExtensions.<EObject>toIterable(feature.getType().eAllContents())) > 0))) {
            this.error("Features with attributes cannot have features with attributes in their attributes", Dsl2Package.Literals.FEATURE__TYPE);
          }
        }
      }
    }
  }
  
  @Check
  public void checkDiagnosticMustBeMany(final Feature f) {
    if ((f.isDiagnostic() && (!f.isMany()))) {
      this.error("Every Diagnostic feature must be Many", Dsl2Package.Literals.FEATURE__MANY);
    }
  }
  
  @Check
  public void checkFeatureNameCannotBeSeriesOrLabels(final Feature f) {
    if ((f.getName().equals("series") || f.getName().equals("labels"))) {
      this.error("Feature name cannot be \'series\' or \'labels\'", Dsl2Package.Literals.FEATURE__NAME);
    }
  }
  
  @Check
  public void checkCommentFeaturePrimitiveFeatures(final Feature f) {
    boolean ans = true;
    boolean hasDate = false;
    boolean hasTitle = false;
    if ((f.isMany() && (!f.isDiagnostic()))) {
      Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(f.getType().eAllContents());
      for (final EObject dat : _iterable) {
        {
          Feature feature = ((Feature) dat);
          if (((((!feature.getType().getName().equals("String")) && (!feature.getType().getName().equals("Integer"))) && (!feature.getType().getName().equals("Date"))) && (!feature.getType().getName().equals("Boolean")))) {
            ans = false;
          } else {
            if ((feature.getType().getName().equals("Date") && feature.getName().equals("date"))) {
              hasDate = true;
            } else {
              if ((feature.getType().getName().equals("String") && feature.getName().equals("title"))) {
                hasTitle = true;
              }
            }
          }
        }
      }
      if ((!hasDate)) {
        this.error("At least one feature of comment feature must be called \'date\' and have \'Date\' type", Dsl2Package.Literals.FEATURE__TYPE);
      } else {
        if ((!hasTitle)) {
          this.error("At least one feature of comment feature must be called \'title and have \'String\' type", Dsl2Package.Literals.FEATURE__TYPE);
        }
      }
    }
    if ((!ans)) {
      String _name = f.getName();
      String _plus = (_name + " feature is a comment feature and must have features of types String, Integer or Date only");
      this.error(_plus, Dsl2Package.Literals.FEATURE__TYPE);
    }
  }
  
  @Check
  public void checkDiagnosticFeaturePrimitiveFeatures(final Feature f) {
    boolean ans = true;
    boolean hasDate = false;
    if ((f.isMany() && f.isDiagnostic())) {
      Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(f.getType().eAllContents());
      for (final EObject dat : _iterable) {
        {
          Feature feature = ((Feature) dat);
          if (((((((((!feature.getType().getName().equals("String")) && (!feature.getType().getName().equals("Integer"))) && (!feature.getType().getName().equals("Date"))) && (!feature.getType().getName().equals("Float"))) && (!feature.getType().getName().equals("Short"))) && (!feature.getType().getName().equals("Byte"))) && (!feature.getType().getName().equals("Long"))) && (!feature.getType().getName().equals("Double")))) {
            ans = false;
          } else {
            if ((feature.getType().getName().equals("Date") && feature.getName().equals("date"))) {
              hasDate = true;
            }
          }
        }
      }
      if ((!hasDate)) {
        this.error("At least one feature of diagnostic feature must be called \'date\' and have \'Date\' type", Dsl2Package.Literals.FEATURE__TYPE);
      }
    }
    if ((!ans)) {
      String _name = f.getName();
      String _plus = (_name + " feature is a diagnostic feature and must have features of types String, Integer or Date only");
      this.error(_plus, Dsl2Package.Literals.FEATURE__TYPE);
    }
  }
  
  @Check
  public void checkManyFeatureCannotBePrimitive(final Feature d) {
    boolean _isMany = d.isMany();
    if (_isMany) {
      if ((((((((((d.getType().getName().equals("Byte") || d.getType().getName().equals("Short")) || d.getType().getName().equals("Integer")) || d.getType().getName().equals("Long")) || d.getType().getName().equals("Float")) || d.getType().getName().equals("Double")) || d.getType().getName().equals("Char")) || d.getType().getName().equals("String")) || d.getType().getName().equals("Boolean")) || d.getType().getName().equals("Date"))) {
        this.error("Features with \'many\' token cannot be primitive types", Dsl2Package.Literals.FEATURE__TYPE);
      }
    }
  }
  
  @Check
  public void checkOnlyAtomicFeaturesCanBeTransient(final Feature f) {
    boolean _isTransient = f.isTransient();
    if (_isTransient) {
      int _size = IterableExtensions.size(IteratorExtensions.<EObject>toIterable(f.getType().eAllContents()));
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        this.error("Only atomic features (of primitive types) can be transient", Dsl2Package.Literals.FEATURE__TRANSIENT);
      }
    }
  }
  
  @Check
  public void checkEntityFeatureCanHaveTransientFeaturesIfIsNotMany(final Feature f) {
    boolean _isMany = f.isMany();
    if (_isMany) {
      Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(f.getType().eAllContents());
      for (final EObject dat : _iterable) {
        {
          Feature feature = ((Feature) dat);
          boolean _isTransient = feature.isTransient();
          if (_isTransient) {
            this.error("An entity feature can have transient features only if is not many", Dsl2Package.Literals.FEATURE__MANY);
          }
        }
      }
    }
  }
  
  @Check
  public void checkEntityNameStartsWithCapital(final Entity entity) {
    boolean _isUpperCase = Character.isUpperCase(entity.getName().charAt(0));
    boolean _not = (!_isUpperCase);
    if (_not) {
      this.error("Name should start with a capital", Dsl2Package.Literals.ABSTRACT_ELEMENT__NAME);
    }
  }
  
  @Check
  public void checkFeatureNameStartsWithLower(final Feature feature) {
    boolean _isUpperCase = Character.isUpperCase(feature.getName().charAt(0));
    if (_isUpperCase) {
      this.error("Name should start with a lower case", Dsl2Package.Literals.FEATURE__NAME);
    }
  }
  
  @Check
  public void checkRoleFeatureCannotBeTransient(final Feature feature) {
    if ((feature.getName().equals("role") && feature.isTransient())) {
      this.error("Role feature cannot be transient", Dsl2Package.Literals.FEATURE__TRANSIENT);
    }
  }
}
