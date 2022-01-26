package com.billennium.vaccinationproject.utilities;

public class CheckObject {

    public static <T> T isNotNull (T newObject, T oldObject) {
        if (newObject != null) {
            return newObject;
        } else {
            return oldObject;
        }
    }
}
