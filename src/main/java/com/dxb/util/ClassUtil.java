package com.dxb.util;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


/**
 * <p>class工具类</p>
 *
 * @author dongxiaobin-0751
 * @version 2016年8月17日
 * @see ClassUtil
 */
public class ClassUtil
{
    public ClassUtil()
    {}

    public static String getClassNameFromFileName(String fileName)
    {
        String class_name = null;
        if (fileName.endsWith(".class"))
        {
            String tmp_class_name = fileName.substring(0, fileName.length() - 6).replace('\\', '.');
            class_name = tmp_class_name.replace('/', '.');
        }
        return class_name;
    }

    public static Set getClassNamesFromDir(File dir)
    {
        Set tmp_set = getFileListDeep(dir);
        Set result = new TreeSet();
        Iterator iterator = tmp_set.iterator();
        do
        {
            if (!iterator.hasNext()) break;
            String elem = (String)iterator.next();
            String class_name = getClassNameFromFileName(elem);
            if (class_name != null) result.add(class_name);
        }
        while (true);
        return result;
    }

    public static Set getClassNamesFromJar(File jarFile)
        throws IOException
    {
        Set result = new TreeSet();
        JarFile jar = new JarFile(jarFile);
        Enumeration jar_entries = jar.entries();
        do
        {
            if (!jar_entries.hasMoreElements()) break;
            JarEntry jar_entry = (JarEntry)jar_entries.nextElement();
            String class_name = getClassNameFromFileName(jar_entry.getName());
            if (class_name != null) result.add(class_name);
        }
        while (true);
        return result;
    }

    public static Set getClassesFromClassPath()
        throws IOException, ClassNotFoundException
    {
        Set classes_set = new TreeSet(new ClassComparator());
        String classpath = System.getProperty("java.class.path");
        StringTokenizer stok = new StringTokenizer(classpath, File.pathSeparator, false);
        do
        {
            if (!stok.hasMoreTokens()) break;
            String path = stok.nextToken();
            File file = new File(path);
            if (file.exists())
            {
                if (file.isDirectory())
                {
                    Set class_names = getClassNamesFromDir(file);
                    classes_set.addAll(getClassesFromNames(class_names));
                }
                if (file.isFile())
                {
                    Set class_names = getClassNamesFromJar(file);
                    classes_set.addAll(getClassesFromNames(class_names));
                }
            }
        }
        while (true);
        return classes_set;
    }

    public static Set getClassesFromNames(Set names)
        throws ClassNotFoundException
    {
        Set classes = new TreeSet(new ClassComparator());
        Iterator iterator = names.iterator();
        do
        {
            if (!iterator.hasNext()) break;
            String name = (String)iterator.next();
            try
            {
                boolean skip_class = false;
                String as[] = SKIP_CONTAINS;
                int i = as.length;
                int k = 0;
                do
                {
                    if (k >= i) break;
                    String test_str = as[k];
                    skip_class = name.contains(test_str);
                    if (skip_class) break;
                    k++ ;
                }
                while (true);
                if (!skip_class)
                {
                    String as1[] = SKIP_STARTS;
                    int j = as1.length;
                    int l = 0;
                    do
                    {
                        if (l >= j) break;
                        String test_str = as1[l];
                        skip_class = name.startsWith(test_str);
                        if (skip_class) break;
                        l++ ;
                    }
                    while (true);
                }
                if (!skip_class)
                {
                    Class cls = Class.forName(name, false, ClassLoader.getSystemClassLoader());
                    classes.add(cls);
                }
            }
            catch (SecurityException securityexception)
            {}
            catch (NoClassDefFoundError noclassdeffounderror)
            {}
            catch (UnsatisfiedLinkError unsatisfiedlinkerror)
            {}
            catch (Throwable e)
            {
                Throwable cause = e.getCause();
                System.out.println((new StringBuilder()).append("Class name: ").append(name).toString());
                e.printStackTrace();
                if (cause != null) cause.printStackTrace();
            }
        }
        while (true);
        return classes;
    }

    public static Set getClassesImplementing(Collection classes, Class cls)
    {
        Set classes_set = new TreeSet(new ClassComparator());
        Iterator iterator = classes.iterator();
        do
        {
            if (!iterator.hasNext()) break;
            Class c = (Class)iterator.next();
            if (cls.isAssignableFrom(c))
            {
                int mod = c.getModifiers();
                if (!Modifier.isAbstract(mod) && !Modifier.isInterface(mod)) classes_set.add(c);
            }
        }
        while (true);
        return classes_set;
    }

    public static Set getClassesImplementing(Class cls)
        throws IOException, ClassNotFoundException
    {
        return getClassesImplementing(((Collection)(getClassesFromClassPath())), cls);
    }

    public static Set getFileListDeep(File path)
    {
        Set set = new TreeSet();
        if (path.isDirectory())
        {
            String files[] = path.list();
            String as[] = files;
            int i = as.length;
            for (int j = 0; j < i; j++ )
            {
                String file = as[j];
                walkInDirForFiles(path, file, set);
            }
        }
        else
        {
            set.add(path.toString());
        }
        return set;
    }

    public static Set getImplementations(Class obj)
        throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        Set result = new TreeSet(new ObjectComparator());
        Class cls;
        for (Iterator iterator = getClassesImplementing(obj).iterator(); iterator.hasNext(); result.add(cls.newInstance()))
            cls = (Class)iterator.next();
        return result;
    }

    public static void walkInDirForFiles(File base_dir, String path, Set set)
    {
        File tmp_file = new File(base_dir, path);
        if (tmp_file.isDirectory())
        {
            String files[] = tmp_file.list();
            String as[] = files;
            int i = as.length;
            for (int j = 0; j < i; j++ )
            {
                String file = as[j];
                walkInDirForFiles(base_dir, (new File(path, file)).toString(), set);
            }
        }
        else
        {
            set.add(path);
        }
    }

    private static final String SKIP_CONTAINS[] = {".ui.", ".swing", ".awt", ".sql.", ".xml.",
        ".terracotta."};

    private static final String SKIP_STARTS[] = {"com.mysql", "tigase.pubsub.Utils",
        "org.apache.derby", "org.apache.xml", "org.postgresql", "com.sun", "groovy",
        "org.codehaus.groovy", "org.netbeans", "org.python"};
}
