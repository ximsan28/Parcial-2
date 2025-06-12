package org.ximsan.sql.hibernateimpl;

import org.ximsan.hibernate.HibernateUtil;
import org.ximsan.model.Estado;
import org.ximsan.sql.GenericSql;
import org.hibernate.Session;

import java.util.List;

public class EstadoHiberImpl implements GenericSql<Estado>
{
    private static EstadoHiberImpl estadoHiber;

    private EstadoHiberImpl()
    {
    }

    public static EstadoHiberImpl getInstance()
    {
        if( estadoHiber == null )
        {
            estadoHiber = new EstadoHiberImpl();
        }
        return estadoHiber;
    }


    @Override
    public List<Estado> findAll()
    {
        Session session = HibernateUtil.getSession();
        if(session == null)
        {
            System.out.println("ERROR DE CONEXION");
            return null;
        }
        List<Estado> list = session
                .createQuery("FROM Estado", Estado.class )
                .getResultList();

        session.close();
        return list;
    }

    @Override
    public boolean save(Estado estado)
    {
        Session session = HibernateUtil.getSession();
        session.beginTransaction(); //Crea un conjunto de instrucciones

        session.merge(estado);
        session.getTransaction().commit(); //Crea un commit de todo el conjunto de instrucciones

        session.close();
        return true;
    }

    @Override
    public boolean update(Estado estado)
    {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.merge(estado);
        session.getTransaction().commit();

        session.close();
        return true;
    }

    @Override
    public boolean delete(Estado estado)
    {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.remove(estado);
        session.getTransaction().commit();

        session.close();
        return true;
    }

    @Override
    public Estado findById(Integer id)
    {
        Session session = HibernateUtil.getSession();

        Estado estado = session
                .get( Estado.class, id );

        session.close();
        return estado;
    }
}
