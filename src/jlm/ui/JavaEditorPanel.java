package jlm.ui;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

import jlm.lesson.SourceFile;

public class JavaEditorPanel extends JScrollPane implements IEditorPanel {
	private static final long serialVersionUID = 1L;
	SourceFile srcFile;
	SourceFileDocumentSynchronizer sync ;
	JEditorPane codeEditor;
	
	public JavaEditorPanel(SourceFile srcFile) {
		super();
		this.srcFile = srcFile;

		codeEditor = new JEditorPane();
		setViewportView(codeEditor);
		codeEditor.setContentType("text/java");
		
		/* Create a synchronization element, and connect it to the editor */
		sync = new SourceFileDocumentSynchronizer(codeEditor.getEditorKit());
		sync.setDocument(codeEditor.getDocument());
		codeEditor.getDocument().addDocumentListener(sync);
		
		/* Connect the synchronization element to the source file */
		srcFile.setListener(sync);
		sync.setSourceFile(srcFile);
		
		codeEditor.setText(srcFile.getBody());
	}
	@Override
	public void clear() {
		sync.clear();
		srcFile = null;
		sync=null;
		codeEditor=null;
	}
}
