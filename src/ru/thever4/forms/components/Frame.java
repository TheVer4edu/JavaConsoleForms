package ru.thever4.forms.components;

import ru.thever4.forms.Utils;
import ru.thever4.forms.Element;

public class Frame extends BaseComponent {

    private Element child;
    private String legend;
    private String value;
    private int width, height;
    private String sprite = "╔═╗╚║╝";

    public Frame(String legend, Element child) {
        this.child = child;
        this.legend = legend;
        this.value = makeLegend(Utils.createDecorations(child, sprite), legend);
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
        this.value = makeLegend(Utils.createDecorations(child, sprite, width, getHeight()), legend);
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.value = makeLegend(Utils.createDecorations(child, sprite, getWidth(), height), legend);
        this.height = height;
    }

    @Override
    public void calculate() {
        this.child.calculate();
        int w = this.width > child.getWidth() ? this.width : child.getWidth() + Utils.getPadding()*2 + 2;
        int h = this.height > child.getHeight() ? this.height : child.getHeight() + Utils.getPadding()*2;
        this.value = makeLegend(Utils.createDecorations(child, sprite, w, h), legend);
        this.width = Utils.getWidth(value);
        this.height = Utils.getHeight(value);
    }

    private String makeLegend(String box, String legend) {
        int lastIndex = box.indexOf(sprite.charAt(2));
        StringBuilder builder = new StringBuilder(box);
        int offset = Utils.getPadding() + 1;
        if(legend.length() + offset < lastIndex) {
            for(int i = 0; i < legend.length(); i++) {
                builder.setCharAt(offset + i, legend.charAt(i));
            }
        }
        return builder.toString();
    }

}
