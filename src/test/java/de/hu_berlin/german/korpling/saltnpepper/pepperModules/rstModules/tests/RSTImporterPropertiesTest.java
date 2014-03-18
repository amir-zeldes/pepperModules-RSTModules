/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.pepperModules.rstModules.tests;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import de.hu_berlin.german.korpling.saltnpepper.pepperModules.rstModules.RSTImporterProperties;

public class RSTImporterPropertiesTest {

	protected RSTImporterProperties fixture= null;

	public RSTImporterProperties getFixture() {
		return fixture;
	}

	public void setFixture(RSTImporterProperties fixture) {
		this.fixture = fixture;
	}
	
	@Before
	public void setUp()
	{
		this.setFixture(new RSTImporterProperties());
	}
	
	/**
	 * Tests the special parameters.
	 */
	@Test
	public void testProperties()
	{
		Properties props= new Properties();
		this.getFixture().setPropertyValues(props);
		
		assertTrue(this.getFixture().isToTokenize());
		
		this.setFixture(new RSTImporterProperties());
		String toTokenize= "no";
		
		props.setProperty(RSTImporterProperties.PROP_TOKENIZE, toTokenize);
		this.getFixture().setPropertyValues(props);
		
		assertEquals(Boolean.FALSE, this.getFixture().isToTokenize());
	}
	
	@Test
	public void test_PROP_SEGMENT_SEPARATOR()
	{
		assertEquals(" ", this.getFixture().getSegementSeparator());
		
		String sep="##";
		Properties props= new Properties();
		props.put(RSTImporterProperties.PROP_SEGMENT_SEPARATOR, sep);
		this.getFixture().setPropertyValues(props);
		assertEquals(sep, this.getFixture().getSegementSeparator());
	}
}
