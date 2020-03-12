package com.reda;

import com.reda.classloader.NetClassLoader;
import com.reda.classloader.ProjectClassLoader;
import com.reda.classloader.SystemFileClassLoader;

public class Client {
    public static void main(String[] args) throws ClassNotFoundException {
        SystemFileClassLoader systemClassLoader = new SystemFileClassLoader();
//        Class clazz = systemClassLoader.loadClass("D:/Project/IDEA/custom-classloader/src/main/resources/BussService.class");
        Class clazz = systemClassLoader.loadClass("src/main/resources/BussService.class");
        // print result 是由自定义类加载器加载
        //com.reda.classloader.SystemClassLoader@75b84c92
        System.out.println(clazz);
        System.out.println("\t" + clazz.getClassLoader());

        ProjectClassLoader projectClassLoader = new ProjectClassLoader();
        Class clazz1 = projectClassLoader.loadClass("NetClassLoader.class");
        System.out.println(clazz1);
        System.out.println("\t" + clazz1.getClassLoader());

        Class clazz2 = projectClassLoader.loadClass("/BussService.class");
        System.out.println(clazz2);
        System.out.println("\t" + clazz2.getClassLoader());

        //由AppClassLoader加载
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(NetClassLoader.class);
        System.out.println("\t" + NetClassLoader.class.getClassLoader());

        //clazz1和NetClassLoader是同一个类，但是他们并不相同,因为不是同一个类加载器加载的
        System.out.println(clazz1.equals(NetClassLoader.class));
        System.out.println(clazz.equals(clazz2));
        //由Ext加载器加载
        //sun.misc.Launcher$ExtClassLoader@1b6d3586
        Class clazz3 = Class.forName("jdk.nashorn.api.scripting.ClassFilter");
        System.out.println(clazz3);
        System.out.println("\t" + clazz3.getClassLoader());

        //null 表明由Bootstrap构造器加载
        System.out.println(String.class);
        System.out.println("\t" + String.class.getClassLoader());

    }
}
