package com.kevin.jvm.simples.classloader;

/**
 * 类加载器分类
 *
 * @author kevin
 */
public class ClassLoaderSimple {




  public static void main(String[] args) {

    ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();

    ClassLoader extClassLoader = appClassLoader.getParent();

    ClassLoader bootstrapClassLoader = extClassLoader.getParent();

    System.out.println(appClassLoader);
    System.out.println(extClassLoader);
    System.out.println(bootstrapClassLoader);

  }

}
