package org.codingmatters.code.analysis.model.from.code.internal;

import net.sourceforge.pmd.dcd.graph.UsageGraphBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 24/09/13
 * Time: 08:38
 * To change this template use File | Settings | File Templates.
 */
public class SourcePathAdder {
    public static final String PACKAGE_PATTERN = "package (.*);";
    
    private final ArrayList<String> sourcePath = new ArrayList<>();

    public SourcePathAdder(File directory) throws IOException {
        this.buildSourcePath(directory);
    }
    
    public void add(SourcePathIndexer usageGraphBuilder) throws IOException {
        for (String className : this.sourcePath) {
            usageGraphBuilder.index(className);
        }
    }

    private void buildSourcePath(File file) throws IOException {
        if(this.isJava(file)) {
            this.addJavaSourceFile(file);
        } else if(file.isDirectory()) {
            for (File content : file.listFiles()) {
                this.buildSourcePath(content);
            }
        }
    }

    private void addJavaSourceFile(File file) throws IOException {
        this.sourcePath.add(this.classNameFromFile(file));
    }

    private boolean isJava(File file) {
        return file.getName().endsWith(".java");
    }

    private String classNameFromFile(File file) throws IOException {
        String result = file.getName();
        result = this.dropExtension(result);
        result = this.trimSeparators(result);
        String packageName = extractPackage(file);
        if(packageName != null && ! packageName.trim().equals("")) {
            return packageName + "." + result;
        } else {
            return result;
        }
    }


    private String trimSeparators(String result) {
        result = result.replace('\\', '.');
        result = result.replace('/', '.');
        return result;
    }

    private String dropExtension(String result) {
        return result.replaceAll("\\.java$", "");
    }

    static public String extractPackage(File file) throws IOException {
        Pattern packagePattern = Pattern.compile(PACKAGE_PATTERN);
        Scanner fileScanner = new Scanner(file);
        try{
            while(fileScanner.hasNextLine()) {
                Matcher matcher = packagePattern.matcher(fileScanner.nextLine());
                if(matcher.matches()) {
                    return matcher.group(1);    
                }
            }
            return null;
        } finally {
            fileScanner.close();
        }
    }
}
