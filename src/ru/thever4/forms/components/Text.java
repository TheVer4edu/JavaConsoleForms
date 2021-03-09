package ru.thever4.forms.components;

import ru.thever4.forms.Utils;

public class Text extends BaseComponent {

    private String content;
    private int width, height;

    public Text(String content) {
        this.content = content;
        this.width = Utils.getWidth(content);
        this.height = Utils.getHeight(content);
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void calculate() {
        return;
    }

    @Override
    public String toString() {
        return content;
    }
}
