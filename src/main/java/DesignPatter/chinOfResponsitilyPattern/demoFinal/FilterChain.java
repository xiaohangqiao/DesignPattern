package main.java.DesignPatter.chinOfResponsitilyPattern.demoFinal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2019/11/29 9:49
 * @Version 1.0
 * @date 2019-11-29 09:54
 */
public class FilterChain implements Filter {

    List<Filter> filters = new ArrayList<>();

    int index =0;

    public FilterChain addFilter(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        if (index == filters.size() ) return ;
        Filter f = filters.get(index);
        index++;
        f.doFilter(request,response,filterChain);
    }
}
