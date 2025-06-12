package org.ximsan.vista.consola.disco;
import org.ximsan.sql.GenericSql;
import org.ximsan.model.Disquera;
import org.ximsan.sql.hibernateimpl.DisqueraHiberImpl;
import org.ximsan.util.ReadUtil;
import org.ximsan.vista.consola.GestorCatalogos;

public class DisqueraCatalogo extends GestorCatalogos<Disquera>
{
    private static DisqueraCatalogo disqueraCatalogo;
    private static final GenericSql<Disquera> disqueraSql = DisqueraHiberImpl.getInstance();

    private DisqueraCatalogo()
    {
        super(DisqueraHiberImpl.getInstance());
    }

    public static DisqueraCatalogo getInstance()
    {
        if(disqueraCatalogo==null)
        {
            disqueraCatalogo = new DisqueraCatalogo();
        }
        return disqueraCatalogo;
    }

    @Override
    public Disquera newT() {
        return new Disquera();
    }

    @Override
    public boolean processNewT(Disquera disquera)
    {
        System.out.print("Nombre de la disquera: ");
        disquera.setDisquera( ReadUtil.read() );
        disqueraSql.save(disquera);
        return true;
    }

    @Override
    public boolean processEditT(Disquera disquera)
    {
        System.out.print("Nuevo nombre de la disquera: ");
        disquera.setDisquera( ReadUtil.read() );

        disqueraSql.update(disquera);
        return true;
    }
}
