/**
 * Copyright (c) 2010 IBM Corporation
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *
 * $Id$
 */
package org.openhealthtools.mdht.uml.cda.ccd.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Entry;
import org.openhealthtools.mdht.uml.cda.ccd.CCDFactory;
import org.openhealthtools.mdht.uml.cda.ccd.FunctionalStatusSection;

/**
 * This class is a JUnit4 test case.
 */
@SuppressWarnings("nls")
public class FunctionalStatusSectionOperationsTest extends CCDValidationTest {

	protected static final String FUNCTIONAL_STATUS_SECTION_TEMPLATE_ID = "2.16.840.1.113883.10.20.1.5";

	protected static final String CODE = "47420-5";
	protected static final String CODE_SYSTEM = "2.16.840.1.113883.6.1";

	private static final CDATestCase TEST_CASE_ARRAY[] = {
		// Template ID
		// -------------------------------------------------------------
		new TemplateIDCCDValidationTest(
				FUNCTIONAL_STATUS_SECTION_TEMPLATE_ID) {

			@Override
			protected boolean validate(final EObject eObjectToTest,
					final BasicDiagnostic diagnostician,
					final Map<Object, Object> map) {
				return FunctionalStatusSectionOperations
				.validateFunctionalStatusSectionTemplateId(
						(FunctionalStatusSection) eObjectToTest,
						diagnostician, map);
			}

		},

		// Title
		// -------------------------------------------------------------
		new TitleCCDValidationTest() {

			@Override
			protected boolean validate(final EObject eObjectToTest,
					final BasicDiagnostic diagnostician,
					final Map<Object, Object> map) {
				return FunctionalStatusSectionOperations
				.validateFunctionalStatusSectionTitle(
						(FunctionalStatusSection) eObjectToTest,
						diagnostician, map);
			}

		},

		// Code
		// -------------------------------------------------------------
		new CodeCCDValidationTest(CODE, CODE_SYSTEM) {
			@Override
			protected boolean validate(final EObject eObjectToTest,
					final BasicDiagnostic diagnostician,
					final Map<Object, Object> map) {
				return FunctionalStatusSectionOperations
				.validateFunctionalStatusSectionCode(
						(FunctionalStatusSection) eObjectToTest,
						diagnostician, map);
			}
		},

		// Entry
		// -------------------------------------------------------------
		new EntryCCDValidationTest() {
			@Override
			protected boolean validate(final EObject eObjectToTest,
					final BasicDiagnostic diagnostician,
					final Map<Object, Object> map) {
				return FunctionalStatusSectionOperations
				.validateFunctionalStatusSectionClinicalStatements(
						(FunctionalStatusSection) eObjectToTest,
						diagnostician, map);
			}

			@Override
			protected Object getValueToSet() {
				final EList<Entry> retValue = new BasicEList<Entry>();
				final Entry entry = CDAFactory.eINSTANCE.createEntry();
				entry.setOrganizer(CCDFactory.eINSTANCE
						.createResultOrganizer());
				retValue.add(entry);

				final Entry entry2 = CDAFactory.eINSTANCE.createEntry();
				entry2.setAct(CCDFactory.eINSTANCE.createProblemAct());
				retValue.add(entry2);

				return retValue;
			}
		}

	}; // TEST_CASE_ARRAY

	@Override
	protected List<CDATestCase> getTestCases() {
		// Return a new List because the one returned by Arrays.asList is
		// unmodifiable so a sub-class can't append their test cases.
		return new ArrayList<CDATestCase>(Arrays.asList(TEST_CASE_ARRAY));
	}

	@Override
	protected EObject getEObjectToValidate() {
		return CCDFactory.eINSTANCE.createFunctionalStatusSection();
	}

	@Override
	protected EObject getEObjectInitToValidate() {
		return CCDFactory.eINSTANCE.createFunctionalStatusSection().init();
	}

} // FunctionalStatusSectionOperationsTest