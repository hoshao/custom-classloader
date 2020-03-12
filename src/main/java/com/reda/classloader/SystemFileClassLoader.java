package com.reda.classloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SystemFileClassLoader extends ClassLoader {

    @Override
    public Class findClass(String name) {
        try(InputStream is = new FileInputStream(name)) {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            //name 必须为全限定名
            return defineClass("com.reda.business.BussService",bytes,0,bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
