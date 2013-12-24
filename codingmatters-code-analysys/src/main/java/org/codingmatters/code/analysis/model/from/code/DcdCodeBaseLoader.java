package org.codingmatters.code.analysis.model.from.code;

import net.sourceforge.pmd.dcd.graph.UsageGraph;
import net.sourceforge.pmd.dcd.graph.UsageGraphBuilder;
import net.sourceforge.pmd.util.filter.Filter;
import net.sourceforge.pmd.util.filter.Filters;
import org.codingmatters.code.analysis.model.CodeBaseModel;
import org.codingmatters.code.analysis.model.from.code.internal.DcdAnalysisContext;
import org.codingmatters.code.analysis.model.from.code.internal.DcdAnalysisVisitor;
import org.codingmatters.code.analysis.model.from.code.internal.SourcePathAdder;
import org.codingmatters.code.analysis.model.from.code.internal.SourcePathIndexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/09/13
 * Time: 06:15
 * To change this template use File | Settings | File Templates.
 */
public class DcdCodeBaseLoader implements CodeBaseLoader, SourcePathIndexer {

    private final UsageGraphBuilder usageGraphBuilder;

    public DcdCodeBaseLoader() {
        List<String> includeRegexes = Arrays.asList(new String[]{"*"});
        List<String> excludeRegexes = Arrays.asList(new String[] { "java\\..*", "javax\\..*", ".*\\.twa\\..*" });
        Filter<String> classFilter = Filters.buildRegexFilterExcludeOverInclude(includeRegexes, excludeRegexes);
        
        this.usageGraphBuilder = new UsageGraphBuilder(classFilter);
    }

    @Override
    public CodeBaseLoader addSourcePath(File directory) throws IOException {
        new SourcePathAdder(directory).add(this);
        return this;
    }

    @Override
    public CodeBaseModel load() throws IOException {
        UsageGraph usageGraph = this.usageGraphBuilder.getUsageGraph();
        CodeBaseModel result = new CodeBaseModel();
        this.analyze(usageGraph, result);
        return result;
    }

    private void analyze(UsageGraph usageGraph, CodeBaseModel result) {
        DcdAnalysisContext context = new DcdAnalysisContext(result);
        DcdAnalysisVisitor visitor = new DcdAnalysisVisitor(context);
        usageGraph.accept(visitor, null);
    }

    @Override
    public void index(String name) {
        this.usageGraphBuilder.index(name);
    }
}
