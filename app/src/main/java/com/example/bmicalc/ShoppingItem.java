package com.example.bmicalc;

/**
 * Model pojedynczego elementu listy zakupów.
 */
public class ShoppingItem {
    private String name;
    private boolean isChecked;

    /**
     * Tworzy nowy element listy zakupów.
     *
     * @param name Nazwa produktu.
     */
    public ShoppingItem(String name) {
        this.name = name;
        this.isChecked = false;
    }

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
