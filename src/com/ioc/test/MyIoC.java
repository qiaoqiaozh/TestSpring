package com.ioc.test;

/**
 * Created by mouse on 15/1/23.
 */
public class MyIoC {
    private XMLParser xp;

    public MyIoC(String xmlFileName)
    {
        xp = new XMLParser(xmlFileName);
    }

    /*
     * 其他的功能
     */

    public Object getBean(String beanName)
    {
        Object o = null;
        
        try
        {
            o = xp.getBean(beanName).newInstance();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return o;
    }
}
