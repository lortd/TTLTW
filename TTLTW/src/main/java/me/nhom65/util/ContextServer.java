package me.nhom65.util;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ContextServer {
	private static Context context;

    static {
        try {
            context = (Context) new InitialContext()
                    .lookup("java:comp/env");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String name) {
        try {
            return (String) context.lookup(name);
        } catch (Exception e) {
            throw new RuntimeException("Cannot load JNDI: " + name);
        }
    }
}
