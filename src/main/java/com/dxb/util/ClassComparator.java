/*
 * 文件名：ClassComparator.java 版权：北京明朝万达科技股份有限公司 描述： 修改人：dongxiaobin-0751 修改时间：2016年12月2日
 */

package com.dxb.util;


import java.io.Serializable;
import java.util.Comparator;


public class ClassComparator implements Comparator<Object>, Serializable
{

    public ClassComparator()
    {}

    public int compare(Class<?> c1, Class<?> c2)
    {
        return c1.getName().compareTo(c2.getName());
    }

    public int compare(Object obj, Object obj1)
    {
        return compare((Class<?>)obj, (Class<?>)obj1);
    }

    private static final long serialVersionUID = 1L;
}
