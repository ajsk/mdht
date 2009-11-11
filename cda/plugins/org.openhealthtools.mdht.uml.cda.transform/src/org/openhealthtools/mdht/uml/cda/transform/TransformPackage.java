package org.openhealthtools.mdht.uml.cda.transform;

import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.openhealthtools.mdht.uml.cda.resources.util.CDAProfileUtil;
import org.openhealthtools.mdht.uml.cda.resources.util.ICDAProfileConstants;

public class TransformPackage extends TransformAbstract {

	public TransformPackage(EcoreTransformerOptions options) {
		super(options);
	}
	
	@Override
	public Object casePackage(Package umlPackage) {
		Stereotype codegenSupport = CDAProfileUtil.getAppliedCDAStereotype(umlPackage, ICDAProfileConstants.CODEGEN_SUPPORT);
		if (codegenSupport != null) {
			Stereotype ePackage = EcoreTransformUtil.getEcoreStereotype(umlPackage, UMLUtil.STEREOTYPE__E_PACKAGE);
			if (!umlPackage.isStereotypeApplied(ePackage)) {
				UMLUtil.safeApplyStereotype(umlPackage, ePackage);
			}
			
			String basePackage = (String) umlPackage.getValue(codegenSupport, ICDAProfileConstants.CODEGEN_SUPPORT_BASE_PACKAGE);
			String nsPrefix = (String) umlPackage.getValue(codegenSupport, ICDAProfileConstants.CODEGEN_SUPPORT_NS_PREFIX);
			String nsURI = (String) umlPackage.getValue(codegenSupport, ICDAProfileConstants.CODEGEN_SUPPORT_NS_URI);
			String packageName = (String) umlPackage.getValue(codegenSupport, ICDAProfileConstants.CODEGEN_SUPPORT_PACKAGE_NAME);
			String prefix = (String) umlPackage.getValue(codegenSupport, ICDAProfileConstants.CODEGEN_SUPPORT_PREFIX);
			
			if (basePackage != null) {
				umlPackage.setValue(ePackage, UMLUtil.TAG_DEFINITION__BASE_PACKAGE, basePackage);
			}

			if (nsPrefix != null) {
				umlPackage.setValue(ePackage, UMLUtil.TAG_DEFINITION__NS_PREFIX, nsPrefix);
			}
			
			if (nsURI != null) {
				umlPackage.setValue(ePackage, UMLUtil.TAG_DEFINITION__NS_URI, nsURI);
			}
			
			if (packageName != null) {
				umlPackage.setValue(ePackage, UMLUtil.TAG_DEFINITION__PACKAGE_NAME, packageName);
			}
			
			if (prefix != null) {
				umlPackage.setValue(ePackage, UMLUtil.TAG_DEFINITION__PREFIX, prefix);
			}
			
			CDAProfileUtil.unapplyCDAStereotype(umlPackage, ICDAProfileConstants.CODEGEN_SUPPORT);
		}
		return umlPackage;
	}

}
