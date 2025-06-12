package org.ximsan.vista.consola.disco;

import org.ximsan.sql.GenericSql;
import org.ximsan.sql.hibernateimpl.ArtistaHiberImpl;
import org.ximsan.sql.hibernateimpl.DiscoHiberImpl;
import org.ximsan.model.*;
import org.ximsan.sql.hibernateimpl.DisqueraHiberImpl;
import org.ximsan.sql.hibernateimpl.GeneroMusicalHiberImpl;
import org.ximsan.util.ReadUtil;
import org.ximsan.vista.consola.GestorCatalogos;
import java.time.LocalDate;
import java.util.List;

public class DiscoCatalogo extends GestorCatalogos<Disco>
{
    private static DiscoCatalogo discoCatalogo;
    private static final GenericSql<Disco> discoSql = DiscoHiberImpl.getInstance();

    private DiscoCatalogo()
    {
        super(DiscoHiberImpl.getInstance());
    }

    public static DiscoCatalogo getInstance()
    {
        if(discoCatalogo==null)
        {
            discoCatalogo = new DiscoCatalogo();
        }
        return discoCatalogo;
    }

    @Override
    public Disco newT() {
        return new Disco();
    }

    @Override
    public boolean processNewT(Disco disco) {
        System.out.print("Título del disco: ");
        disco.setTituloDisco( ReadUtil.read() );
        System.out.print("Precio de venta: ");
        disco.setPrecio( ReadUtil.readDouble() );
        System.out.print("Número de copias en inventario: ");
        disco.setExistencias( ReadUtil.readInt() );
        System.out.print("Descuento actual (si tiene): ");
        disco.setDescuento( ReadUtil.readDouble() );

        System.out.print("Fecha de lanzamiento (YYYY-MM-DD) : ");
        String fechaStr = ReadUtil.read();
        LocalDate fecha = LocalDate.parse(fechaStr);
        disco.setFechaLanzamiento( fecha );

        System.out.print(" Ingrese la imagen: ");
        disco.setImagen( ReadUtil.read() );

        DisqueraHiberImpl disqueraSql = DisqueraHiberImpl.getInstance();
        List<Disquera> disqueraList = disqueraSql.findAll();
        disqueraList.forEach(System.out::println);

        System.out.print("ID de la disquera de su distribución: ");
        Disquera disquera = disqueraSql.findById( ReadUtil.readInt() );
        if(disquera==null)
        {
            System.out.println("❌ No encontrado.");
            return false;
        }
        else
        {
            disco.setDisquera( disquera );
        }

        ArtistaHiberImpl artistaSql = ArtistaHiberImpl.getInstance();
        List<Artista> artistaList = artistaSql.findAll();
        artistaList.forEach(System.out::println);

        System.out.print("ID del artista al que pertenece: ");
        Artista artista = artistaSql.findById( ReadUtil.readInt() );
        if(artista==null)
        {
            System.out.println("❌ No encontrado.");
            return false;
        }
        else
        {
            disco.setArtista(artista);
        }

        GeneroMusicalHiberImpl generoMusicalSql = GeneroMusicalHiberImpl.getInstance();
        List<Genero_Musical> generoMusicalList = generoMusicalSql.findAll();
        generoMusicalList.forEach(System.out::println);

        System.out.print("ID del género musical al que pertenece: ");
        Genero_Musical generoMusical = generoMusicalSql.findById( ReadUtil.readInt() );
        if(generoMusical==null)
        {
            System.out.println("❌ No encontrado.");
            return false;
        }
        else
        {
            disco.setGeneroMusical( generoMusical );
        }

        discoSql.save(disco);
        return true;
    }

    @Override
    public boolean processEditT(Disco disco)
    {
        System.out.print("Nuevo título del disco: ");
        disco.setTituloDisco( ReadUtil.read() );
        System.out.print("Nuevo precio de venta: ");
        disco.setPrecio( ReadUtil.readDouble() );
        System.out.print("Nuevo número de copias en inventario: ");
        disco.setExistencias( ReadUtil.readInt() );
        System.out.print("Nuevo descuento actual (si tiene): ");
        disco.setDescuento( ReadUtil.readDouble() );

        discoSql.update(disco);
        return true;
    }
}

