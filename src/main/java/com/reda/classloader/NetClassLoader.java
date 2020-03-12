package com.reda.classloader;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class NetClassLoader extends ClassLoader{

    @Override
    public Class findClass(String name) {
        try {
            URL url = new URL(name);
            InputStream is = url.openStream();
            byte[] dest = IOUtils.toByteArray(is);
            return defineClass(null,dest,0,dest.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
