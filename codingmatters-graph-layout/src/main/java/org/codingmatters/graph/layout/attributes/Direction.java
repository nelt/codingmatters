package org.codingmatters.graph.layout.attributes;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 07:39
 */
public class Direction {

    static public Direction major(Dir major) {
        return new Direction(major);
    }
    
    static public enum Dir {
        TOP("T"), BOTTOM("B"), LEFT("L"), RIGHT("R");

        private final String formatted;

        private Dir(String formatted) {
            this.formatted = formatted;
        }
    }

    private final Dir major;
    private Dir minor;

    public Direction(Dir major) {
        this.major = major;
        this.minor = Dir.LEFT;
    }
    
    public Direction minor(Dir minor) {
        this.minor = minor;
        return this;
    }
    
    public String formatted() {
        return this.major.formatted + this.minor.formatted;
    }
}
