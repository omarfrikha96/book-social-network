package com.frikha.book.email;

import lombok.Getter;
import lombok.Setter;

@Getter

public enum EmailTemplateName {

    ACTIVATE_ACCOUNT("activate-account");
    private final String name;
    EmailTemplateName(String name) {
        this.name = name;
    }

}
