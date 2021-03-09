package ru.thever4.forms;

public class Utils {
    private static final int PADDING = 1;

    public static String createDecorations(Element element, String decorations) {
        String defaultDecor = "┌─┐└│┘";
        if(decorations == null || decorations.length() < defaultDecor.length()) decorations = defaultDecor;
        StringBuilder result = new StringBuilder();
        String[] lines = getAllLines(element.toString());
        int lineWidth = getWidth(element.toString()) + PADDING*2;
        int blockHeight = lines.length;
        result.append(decorations.charAt(0) + createRepetitive(decorations.charAt(1), lineWidth) + decorations.charAt(2) + '\n');
        for(int i = 0; i < blockHeight; i++) {
            String line = lines[i];
            result.append(decorations.charAt(4) + createRepetitive(' ', PADDING) + line + createRepetitive(' ', lineWidth - PADDING - line.length()) + decorations.charAt(4) + '\n');
        }
        result.append(decorations.charAt(3) + createRepetitive(decorations.charAt(1), lineWidth) + decorations.charAt(5));
        return result.toString();
    }

    public static String createDecorations(Element element, String decorations, int width, int height) {
        String defaultDecor = "┌─┐└│┘";
        if(decorations == null || decorations.length() < defaultDecor.length()) decorations = defaultDecor;
        StringBuilder result = new StringBuilder();
        String[] lines = getAllLines(element.toString());
        int lineWidth = width - 2;
        int blockHeight = height - 2;
        result.append(decorations.charAt(0) + createRepetitive(decorations.charAt(1), lineWidth) + decorations.charAt(2) + '\n');
        String line;
        for(int i = 0; i < blockHeight; i++) {
            if(i < lines.length)
                line = lines[i];
            else line = "";
            result.append(decorations.charAt(4) + createRepetitive(' ', PADDING) + line + createRepetitive(' ', lineWidth - PADDING - line.length()) + decorations.charAt(4) + '\n');
        }
        result.append(decorations.charAt(3) + createRepetitive(decorations.charAt(1), lineWidth) + decorations.charAt(5));
        return result.toString();
    }

    public static String[] getAllLines(String text) {
        String[] content = text.split("\n");
        return content;
    }

    public static int getWidth(String text) {
        int maxWidth = 0;
        for(String line : getAllLines(text)) {
            if(line.length() > maxWidth) maxWidth = line.length();
        }
        return maxWidth;
    }

    public static int getHeight(String text) {
        return getAllLines(text).length;
    }

    public static String createRepetitive(char symbol, int count) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < count; i++)
            result.append(symbol);
        return result.toString();
    }

    public static int getPadding() {
        return PADDING;
    }
}
