package org.ximsan.hibernate;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

public final class HibernateUtil
{
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    public static boolean loadRegistry( )
    {
        try
        {
            System.out.println( "HibernateUtil.init()");
            registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml") // se carga la configuracion hibernate
                    .build();
            System.out.println( "HibernateUtil.registry");
            return registry != null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
        return false;
    }

    public static boolean loadSessionFactory( )
    {
        try
        {
            if( registry == null )
            {
                if( !loadRegistry() )
                {
                    return false;
                }
            }
            System.out.println( "HibernateUtil.init.sessionFactory");
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            System.out.println( "HibernateUtil.sessionFactory");
            return sessionFactory != null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
        return false;
    }

    public static StandardServiceRegistry getRegistry( )
    {
        if( registry == null )
        {
            if( !loadRegistry( ) )
            {
                return null;
            }
        }
        return registry;
    }

    public static SessionFactory getSessionFactory( )
    {
        if( sessionFactory == null )
        {
            if( !loadSessionFactory() )
            {
                return null;
            }
        }
        return sessionFactory;
    }

    public static Session getSession()
    {
        if (sessionFactory == null || sessionFactory.isClosed())
        {
            if (!loadSessionFactory())
            {
                throw new IllegalStateException("No se pudo crear el SessionFactory.");
            }
        }
        return sessionFactory.openSession();
    }

}
