package com.kevin.jvm.simples;

/**
 * 类加载器
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
