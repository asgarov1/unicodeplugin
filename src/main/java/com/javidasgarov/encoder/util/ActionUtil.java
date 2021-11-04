package com.javidasgarov.encoder.util;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

import static com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR;

public class ActionUtil {
    public static Optional<String> getSelectedText(@NotNull AnActionEvent event) {
        Editor editor = event.getData(EDITOR);
        return Optional.ofNullable(editor.getSelectionModel().getSelectedText());
    }

}
