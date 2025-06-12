package org.ximsan.vista.consola.usuario;

import org.ximsan.sql.GenericSql;
import org.ximsan.sql.hibernateimpl.ColoniaHiberImpl;
import org.ximsan.sql.hibernateimpl.MunicipioHiberImpl;
import org.ximsan.model.Colonia;
import org.ximsan.model.Municipio;
import org.ximsan.util.ReadUtil;
import org.ximsan.vista.consola.GestorCatalogos;

import java.util.List;

public class ColoniaCatalogo extends GestorCatalogos<Colonia>
{
    private static ColoniaCatalogo coloniaCatalogo;
    private static final GenericSql<Colonia> coloniaSql = ColoniaHiberImpl.getInstance();

    public static ColoniaCatalogo getInstance( )
    {
        if(coloniaCatalogo==null)
        {
            coloniaCatalogo = new ColoniaCatalogo();
        }
        return coloniaCatalogo;
    }

    private ColoniaCatalogo( )
    {
        super(ColoniaHiberImpl.getInstance());
    }

    @Override
    public Colonia newT()
    {
        return new Colonia();
    }

    @Override
    public boolean processNewT(Colonia colonia)
    {
        System.out.print("Nombre de la colonia: ");
        colonia.setColonia( ReadUtil.read() );
        System.out.print(">Código postal de la colonia: ");
        colonia.setCp( ReadUtil.read() );

        MunicipioHiberImpl municipioJdbc = MunicipioHiberImpl.getInstance();
        List<Municipio> list = municipioJdbc.findAll();
        list.forEach(System.out::println);
        System.out.print("ID del municipio al que pertenece: ");

        Municipio municipio = MunicipioHiberImpl.getInstance().findById(ReadUtil.readInt());
        if(municipio==null)
        {
            System.out.println("❌ No encontrado.");
            return false;
        }
        colonia.setMunicipio(municipio);

        coloniaSql.save(colonia);
        return true;
    }

    @Override
    public boolean processEditT(Colonia colonia)
    {
        System.out.print("Nuevo nombre de la colonia: ");
        colonia.setColonia( ReadUtil.read() );
        System.out.print("Nuevo código postal de la colonia: ");
        colonia.setCp( ReadUtil.read() );

        coloniaSql.update(colonia);
        return true;
    }
}

