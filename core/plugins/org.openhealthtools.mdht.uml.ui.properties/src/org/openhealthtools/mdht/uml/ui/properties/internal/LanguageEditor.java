package org.openhealthtools.mdht.uml.ui.properties.internal;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Text;
import org.openhealthtools.mdht.uml.ui.properties.internal.sections.ConstraintEditor;

public class LanguageEditor implements ConstraintEditor {

	Text text;

	public LanguageEditor() {
		// TODO Auto-generated constructor stub
	}

	public void setText(Text text) {
		this.text = text;
		this.text.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			public void focusLost(FocusEvent e) {
				Text t = (Text) e.widget;
				System.out.println("LE: " + t.getText() + " check for valid ");

			}
		});
		this.text.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				System.out.println("LE: We modified the analysis Text" + e.toString());

			}
		});

	}

}
