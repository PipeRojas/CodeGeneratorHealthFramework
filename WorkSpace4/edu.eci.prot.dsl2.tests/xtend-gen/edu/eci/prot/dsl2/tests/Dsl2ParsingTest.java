/**
 * generated by Xtext 2.11.0
 */
package edu.eci.prot.dsl2.tests;

import com.google.inject.Inject;
import edu.eci.prot.dsl2.dsl2.Domainmodel;
import edu.eci.prot.dsl2.tests.Dsl2InjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(Dsl2InjectorProvider.class)
@SuppressWarnings("all")
public class Dsl2ParsingTest {
  @Inject
  private ParseHelper<Domainmodel> parseHelper;
  
  @Test
  public void loadModel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Hello Xtext!");
      _builder.newLine();
      final Domainmodel result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      Assert.assertTrue(result.eResource().getErrors().isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
