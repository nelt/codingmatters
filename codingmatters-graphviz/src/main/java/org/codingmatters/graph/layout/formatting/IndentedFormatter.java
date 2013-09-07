package org.codingmatters.graph.layout.formatting;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 09/08/13
 * Time: 23:34
 */
public class IndentedFormatter {
    
    private final StringBuilder builded = new StringBuilder();
    private boolean started = false;
    private int level = 0;
    
    public String formatted() {
        return builded.toString();
    }

    public IndentedFormatter line(String expected) {
        this.newLine();
        this.startLine();
        this.applyIndentation();
        this.builded.append(expected);
        return this;
    }

    public IndentedFormatter line(String format, Object ... args) {
        return this.line(String.format(format, args));
    }

    private boolean appending = false;
    
    public IndentedFormatter append(String text) {
        if(! appending) {
            this.startLine();
            this.applyIndentation();
            this.appending = true;
        }
        this.builded.append(text);
        return this;
    }


    public IndentedFormatter newLine() {
        if(this.appending) {
            this.appending = false;
        }
        return this;
    }

    private void startLine() {
        if(this.started) {
            this.builded.append("\n");
        } else {
            this.started = true;
        }
    }

    private void applyIndentation() {
        for(int i = 0; i < this.level; i++) {
            this.builded.append("\t");
        }
    }

    public IndentedFormatter indent() {
        this.level++;
        return this;
    }

    public IndentedFormatter unindent() {
        this.level--;
        return this;
    }

}
