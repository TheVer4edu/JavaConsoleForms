package ru.thever4.forms.components;

import ru.thever4.forms.Utils;
import ru.thever4.forms.Element;

public class Rectangle extends BaseComponent {

    private Element child;
    private String value;
    private int width, height;
    private String sprite = "┌─┐└│┘";

    public Rectangle(Element child) {
        this.child = child;
        this.value = Utils.createDecorations(child, sprite);
        this.width = Utils.getWidth(value);
        this.height = Utils.getHeight(value);
    }

    @Override
    public String toString() {
        return value;
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
        this.value = Utils.createDecorations(child, sprite, width, getHeight());
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.value = Utils.createDecorations(child, sprite, getWidth(), height);
        this.height = height;
    }

    @Override
    public void calculate() {
        this.child.calculate();
        int w = this.width > child.getWidth() ? this.width : child.getWidth() + Utils.getPadding()*2 + 2;
        int h = this.height > child.getHeight() ? this.height : child.getHeight() + Utils.getPadding()*2;
        this.value = Utils.createDecorations(child, sprite, w, h);
        this.width = Utils.getWidth(value);
        this.height = Utils.getHeight(value);
    }


}
