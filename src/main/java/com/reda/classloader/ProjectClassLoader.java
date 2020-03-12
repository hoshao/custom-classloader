package com.reda.classloader;

import java.io.IOException;
import java.io.InputStream;

public class ProjectClassLoader extends ClassLoader {

    @Override
    public Class findClass(String name) {
        try(InputStream is = this.getClass().getResourceAsStream(name)) {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            //name 必须为全限定名
            return defineClass(null, bytes,0,bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
