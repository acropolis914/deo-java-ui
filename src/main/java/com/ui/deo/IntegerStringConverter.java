package com.ui.deo;

import javafx.util.StringConverter;

public class IntegerStringConverter extends StringConverter<Integer> {

    @Override
    public String toString(Integer object) {
        return object.toString();
    }

    @Override
    public Integer fromString(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return 0; // Return a default value or handle the exception as needed
        }
    }
}
