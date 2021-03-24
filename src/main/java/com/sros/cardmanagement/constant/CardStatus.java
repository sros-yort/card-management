package com.sros.cardmanagement.constant;

import java.util.HashSet;
import java.util.Set;

public enum CardStatus {
    ACTIVATE,
    DEACTIVATE,
    PADDING,
    CLOSE;

    private static Set<String> _values = new HashSet<>();

    static {
        for (CardStatus choice : CardStatus.values()) {
            _values.add(choice.name());
        }
    }

    public static boolean contains(String value) {
        return _values.contains(value);
    }
}
