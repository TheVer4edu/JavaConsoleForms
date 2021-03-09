package ru.thever4.forms.layouts;

import ru.thever4.forms.Element;
import ru.thever4.forms.Utils;

public class HorizontalLayout extends BaseLayout {

    private Element[] children;
    private String value;
    private int width, height;

    public HorizontalLayout(Element... children) {
        this.children = children;
        this.value = combine(children, getMaxHeight());
        this.width = Utils.getWidth(value);
        this.height = Utils.getHeight(value);
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.value = combine(children, height);
        this.height = height;
    }

    @Override
    public void calculate() {
        this.value = combine(children, getMaxHeight());
    }

    private int getMaxHeight() {
        int maxHeight = 0;
        for(Element element : children)
            if(element.getHeight() > maxHeight)
                maxHeight = element.getHeight();
        return maxHeight;
    }

    private void setHeightToAll(int height) {
        for(Element element : children)
            element.setHeight(height);
    }

    private String combine(Element[] elements, int height) {
        setHeightToAll(height);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < height; i++) {
            for(Element element : elements) {
                result.append(Utils.getAllLines(element.toString())[i]);
            }
            result.append('\n');
        }
        return result.toString();
    }

}