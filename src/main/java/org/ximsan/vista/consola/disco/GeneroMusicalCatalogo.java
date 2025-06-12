package org.ximsan.vista.consola.disco;
import org.ximsan.sql.GenericSql;
import org.ximsan.model.Genero_Musical;
import org.ximsan.sql.hibernateimpl.GeneroMusicalHiberImpl;
import org.ximsan.util.ReadUtil;
import org.ximsan.vista.consola.GestorCatalogos;

public class GeneroMusicalCatalogo extends GestorCatalogos<Genero_Musical>
{
    private static GeneroMusicalCatalogo generoMusicalCatalogo;
    private static final GenericSql<Genero_Musical> genero_MusicalSql = GeneroMusicalHiberImpl.getInstance();

    private GeneroMusicalCatalogo()
    {
        super(GeneroMusicalHiberImpl.getInstance());
    }

    public static GeneroMusicalCatalogo getInstance()
    {
        if(generoMusicalCatalogo==null)
        {
            generoMusicalCatalogo = new GeneroMusicalCatalogo();
        }
        return generoMusicalCatalogo;
    }

    @Override
    public Genero_Musical newT() {
        return new Genero_Musical();
    }

    @Override
    public boolean processNewT(Genero_Musical generoMusical)
    {
        System.out.print("Género musical: ");
        generoMusical.setGenero( ReadUtil.read() );
        genero_MusicalSql.save(generoMusical);
        return true;
    }

    @Override
    public boolean processEditT(Genero_Musical generoMusical)
    {
        System.out.print("Nuevo nombre del género musical: ");
        generoMusical.setGenero( ReadUtil.read() );

        genero_MusicalSql.update(generoMusical);
        return true;
    }
}
