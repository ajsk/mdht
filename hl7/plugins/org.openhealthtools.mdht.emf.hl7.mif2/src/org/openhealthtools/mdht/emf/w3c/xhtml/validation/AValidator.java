/*******************************************************************************
 * Copyright (c) 2006, 2009 David A Carlson
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David A Carlson (XMLmodeling.com) - initial API and implementation
 *******************************************************************************/
package org.openhealthtools.mdht.emf.w3c.xhtml.validation;

import org.openhealthtools.mdht.emf.w3c.xhtml.MifClassType;
import org.openhealthtools.mdht.emf.w3c.xhtml.Shape;
import org.openhealthtools.mdht.emf.w3c.xhtml.StyleSheet;

/**
 * A sample validator interface for {@link org.openhealthtools.mdht.emf.w3c.xhtml.A}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AValidator {
	boolean validate();

	boolean validateClass(MifClassType value);

	boolean validateCoords(String value);

	boolean validateHref(String value);

	boolean validateLang(String value);

	boolean validateName(String value);

	boolean validateShape(Shape value);

	boolean validateStyle(StyleSheet value);

	boolean validateType(Object value);
}
