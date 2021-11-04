package com.javidasgarov.encoder.action;

import static com.javidasgarov.encoder.util.StringUtil.replaceNonUnicode;

public class EncodeAction extends EncodingAction {

    @Override
    public String processSelectedText(String text) {
        return replaceNonUnicode(text);
    }
}
