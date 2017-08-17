package org.library.rest.api.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SafeSimpleDateFormat {

    private static final ThreadLocal<Map<String, SimpleDateFormat>> factory = ThreadLocal.withInitial(HashMap::new);

    private final String pattern;

    public SafeSimpleDateFormat(String pattern) {
        this.pattern = pattern;
    }

    private SimpleDateFormat getSimpleDateFormat() {
        Map<String, SimpleDateFormat> container = factory.get();
        SimpleDateFormat dateFormat;
        if (container.containsKey(pattern)) {
            dateFormat = container.get(pattern);
        } else {
            dateFormat = new SimpleDateFormat(pattern);
            container.put(pattern, dateFormat);
        }
        return dateFormat;
    }

    public String format(Date date) {
        return getSimpleDateFormat().format(date);
    }

    public Date parse(String source) throws ParseException {
        return getSimpleDateFormat().parse(source);
    }

}
