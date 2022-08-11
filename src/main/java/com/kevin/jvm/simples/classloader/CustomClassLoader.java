package com.kevin.jvm.simples.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/**
 * 自定义类加载器
 *
 * @author kevin
 */
public class CustomClassLoader extends ClassLoader {


  private String classPath;

  public CustomClassLoader(String classPath) {
    this.classPath = classPath;
  }


  private byte[] loadClassBytes(String className) throws IOException {
    if (StringUtils.isEmpty(className)) {
      throw new RuntimeException("类名为空");
    }

    File file = new File(classPath + "/" + className);
    if (!file.exists()) {
      throw new RuntimeException("类文件不存在");
    }
    FileInputStream fis = new FileInputStream(file);
    int length = fis.available();
    byte[] classByteArray = new byte[length];
    fis.read(classByteArray);
    fis.close();
    return classByteArray;
  }


  @Override
  public Class<?> loadClass(String className) throws ClassNotFoundException {
    try {
      byte[] classByteArray = loadClassBytes(className);
      return defineClass(className, classByteArray, 0, classByteArray.length);
    } catch (Exception e) {
      throw new ClassNotFoundException();
    }

  }
}
