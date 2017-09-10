/*
 * generated by Xtext 2.11.0
 */
package edu.eci.prot.dsl2.tests

import com.google.inject.Inject
import edu.eci.prot.dsl2.dsl2.Domainmodel
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(Dsl2InjectorProvider)
class Dsl2ParsingTest {
	@Inject
	ParseHelper<Domainmodel> parseHelper
	
	@Test
	def void loadModel() {
		val result = parseHelper.parse('''
			Hello Xtext!
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
	}
}