package com.javidasgarov.encoder.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.javidasgarov.encoder.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

import static com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR;
import static com.intellij.openapi.actionSystem.CommonDataKeys.PSI_FILE;

public class EncodeAction extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent event) {
        Optional<PsiFile> file = Optional.ofNullable(event.getData(PSI_FILE));
        event.getPresentation().setEnabled(file.isPresent());
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor = event.getData(EDITOR);
        Optional<String> selectedText = Optional.ofNullable(editor.getSelectionModel().getSelectedText());

        selectedText.ifPresentOrElse(
                text -> normalizeSelectedText(event.getProject(), editor, text),
                () -> normalizeWholeFile(event.getProject(), event.getData(PSI_FILE))
        );
    }

    private void normalizeSelectedText(@NotNull Project project, Editor editor, String selectedText) {
        String normalized = StringUtil.replaceNonUnicode(selectedText);
        final Document document = editor.getDocument();
        Caret primaryCaret = editor.getCaretModel().getPrimaryCaret();
        int start = primaryCaret.getSelectionStart();
        int end = primaryCaret.getSelectionEnd();
        WriteCommandAction.runWriteCommandAction(project, () ->
                document.replaceString(start, end, normalized)
        );
        primaryCaret.removeSelection();
    }

    private void normalizeWholeFile(@NotNull Project project, PsiFile psiFile) {
        String text = psiFile.getViewProvider().getDocument().getText();
        String normalizedText = StringUtil.replaceNonUnicode(text);

        WriteCommandAction.runWriteCommandAction(project,
                () -> psiFile.getViewProvider().getDocument().setText(normalizedText));
    }

    @Override
    public boolean isDumbAware() {
        return true;
    }
}
