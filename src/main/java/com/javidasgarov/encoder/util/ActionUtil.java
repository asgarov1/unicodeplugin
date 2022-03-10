package com.javidasgarov.encoder.util;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

import static com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR;

public class ActionUtil {
    public static Optional<String> getSelectedText(@NotNull AnActionEvent event) {
        return Optional.ofNullable(event.getData(EDITOR))
                .map(Editor::getSelectionModel)
                .map(SelectionModel::getSelectedText);
    }

}
