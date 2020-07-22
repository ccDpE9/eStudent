package com.eStudent.filters;

import com.eStudent.http.Request;

public abstract class Filter {
    private Filter next;

    public Filter linkWith(Filter next) {
        this.next = next;
        return next;
    }

    public abstract boolean doFilter(Request request);

    protected boolean checkNext(Request request) {
        if (next == null) {
            return true;
        }

        return next.doFilter(request);
    }
}