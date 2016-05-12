package com.kd.platform.minidao.spring.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * <b>Application name:</b> MiniDaoLinkedMap.java <br>
 * <b>Application describing:提供默认小写作为Key的Map </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MiniDaoLinkedMap extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    private final Locale locale;

    public MiniDaoLinkedMap() {
        this(null);
    }

    public MiniDaoLinkedMap(int initialCapacity) {
        this(initialCapacity, null);
    }

    public MiniDaoLinkedMap(int initialCapacity, Locale locale) {
        super(initialCapacity);
        this.locale = (locale == null ? Locale.getDefault() : locale);
    }

    public MiniDaoLinkedMap(Locale locale) {
        this.locale = (locale == null ? Locale.getDefault() : locale);
    }

    public void clear() {
        super.clear();
    }

    public boolean containsKey(Object key) {
        return ((key instanceof String)) && (super.containsKey(convertKey((String) key)));
    }

    protected String convertKey(String key) {
        return key.toLowerCase(this.locale);
    }

    public Object get(Object key) {
        if ((key instanceof String)) {
            return super.get(convertKey((String) key));
        }
        return null;
    }

    public Object put(String key, Object value) {
        return super.put(convertKey(key), value);
    }

    public void putAll(Map map) {
        if (map.isEmpty()) return;
        Map.Entry entry;
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); put(convertKey((String) entry.getKey()), entry.getValue())) {
            entry = (Map.Entry) iterator.next();
        }
    }

    public Object remove(Object key) {
        if ((key instanceof String)) {
            return super.remove(convertKey((String) key));
        }
        return null;
    }
}
