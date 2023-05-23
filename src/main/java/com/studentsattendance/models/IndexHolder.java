package com.studentsattendance.models;

public class IndexHolder {
    private static IndexHolder instance;
    private int currentIndex;

    private IndexHolder() {
        // Private constructor to prevent direct instantiation
    }

    public static IndexHolder getInstance() {
        if (instance == null) {
            instance = new IndexHolder();
        }
        return instance;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int newIndex) {
        currentIndex = newIndex;
    }
}
