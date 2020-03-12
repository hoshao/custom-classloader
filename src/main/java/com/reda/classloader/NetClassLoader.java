package com.reda.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class NetClassLoader extends ClassLoader{

    @Override
    public Class findClass(String name) {
        try {
            URL url = new URL(name);
            InputStream is = url.openStream();
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            //name 必须为全限定名
            return defineClass(null,bytes,0,bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
