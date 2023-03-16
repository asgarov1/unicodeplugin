package com.javidasgarov.encoder.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

import static com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR;
import static com.intellij.openapi.command.WriteCommandAction.runWriteCommandAction;
import static com.javidasgarov.encoder.util.ActionUtil.getSelectedText;

public abstract class EncodingAction extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent event) {
        event.getPresentation().setEnabled(getSelectedText(event).isPresent());
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Optional<String> selectedText = getSelectedText(event);

        selectedText.ifPresent(text -> normalizeSelectedText(event.getProject(), event.getData(EDITOR), text));
    }

    private void normalizeSelectedText(@NotNull Project project, Editor editor, String selectedText) {
        Caret primaryCaret = editor.getCaretModel().getPrimaryCaret();
        runWriteCommandAction(project, () -> editor.getDocument()
                .replaceString(primaryCaret.getSelectionStart(), primaryCaret.getSelectionEnd(), processSelectedText(selectedText))
        );

        primaryCaret.removeSelection();
    }

    @Override
    public boolean isDumbAware() {
        return true;
    }

    public abstract String processSelectedText(String text);
}
