package ru.thever4.forms.layouts;

import ru.thever4.forms.Element;
import ru.thever4.forms.Utils;

public class VerticalLayout extends BaseLayout {

    private Element[] children;
    private String value;
    private int width, height;

    public VerticalLayout(Element... children) {
        this.children = children;
        this.children = children;
        this.value = combine(children, getMaxWidth());
        this.width = Utils.getWidth(value);
        this.height = Utils.getHeight(value);
    }

    @Override
    public String toString() {
        return value;
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

    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void calculate() {

    }

    private int getMaxWidth() {
        int maxWidth = 0;
        for(Element element : children)
            if(element.getWidth() > maxWidth)
                maxWidth = element.getWidth();
        return maxWidth;
    }

    private void setWidthToAll(int width) {
        for(Element element : children)
            element.setWidth(width);
    }

    private String combine(Element[] elements, int width) {
        setWidthToAll(width);
        StringBuilder result = new StringBuilder();
        for(Element element : elements) {
            result.append(element.toString() + '\n');
        }
        return result.toString();
    }
}
