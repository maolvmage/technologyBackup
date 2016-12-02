/*
 * 文件名：ObjectComparator.java 版权：北京明朝万达科技股份有限公司 描述： 修改人：dongxiaobin-0751 修改时间：2016年12月2日
 */

package com.dxb.util;


import java.io.Serializable;
import java.util.Comparator;


public class ObjectComparator implements Comparator<Object>, Serializable
{

    public ObjectComparator()
    {}

    public int compare(Object o1, Object o2)
    {
        return o1.getClass().getName().compareTo(o2.getClass().getName());
    }

    private static final long serialVersionUID = 1L;
}
