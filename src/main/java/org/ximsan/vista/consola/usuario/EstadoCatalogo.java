package org.ximsan.vista.consola.usuario;

import org.ximsan.sql.GenericSql;
import org.ximsan.sql.hibernateimpl.EstadoHiberImpl;
import org.ximsan.model.Estado;
import org.ximsan.util.ReadUtil;
import org.ximsan.vista.consola.GestorCatalogos;

public class EstadoCatalogo extends GestorCatalogos<Estado>
{
    private static EstadoCatalogo estadoCatalogo;
    private static final GenericSql<Estado> estadoSql = EstadoHiberImpl.getInstance();

    public static EstadoCatalogo getInstance( )
    {
        if(estadoCatalogo==null)
        {
            estadoCatalogo = new EstadoCatalogo();
        }
        return estadoCatalogo;
    }

    private EstadoCatalogo( )
    {
        super(EstadoHiberImpl.getInstance());
    }

    @Override
    public Estado newT()
    {
        return new Estado();
    }

    @Override
    public boolean processNewT(Estado estado)
    {
        System.out.print("Nombre del estado: ");
        estado.setEstado( ReadUtil.read() );
        estadoSql.save(estado);
        return true;
    }

    @Override
    public boolean processEditT(Estado estado)
    {
        System.out.print("Nuevo nombre del estado: ");
        estado.setEstado( ReadUtil.read() );

        estadoSql.update(estado);
        return true;
    }
}


