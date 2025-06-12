package org.ximsan.sql.hibernateimpl;

import org.junit.jupiter.api.Test;
import org.ximsan.model.Colonia;
import org.ximsan.model.Municipio;
import org.ximsan.sql.GenericSql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColoniaHiberImplTest {

    @Test
    void getInstance()
    {
        GenericSql<Colonia> coloniaHiberImpl = ColoniaHiberImpl.getInstance();
        assertNotNull( coloniaHiberImpl );
    }

    @Test
    void findAll()
    {
        GenericSql<Colonia> coloniaHiberImpl = ColoniaHiberImpl.getInstance();
        List<Colonia> list = coloniaHiberImpl.findAll();

        assertNotNull(list);
        list.forEach(System.out::println);
    }

    @Test
    void save()
    {
        GenericSql<Colonia> coloniaHiberImpl = ColoniaHiberImpl.getInstance();
        GenericSql<Municipio> municipioHiber = MunicipioHiberImpl.getInstance();

            Municipio municipio = municipioHiber.findById(2);

            Colonia colonia = new Colonia();
            colonia.setColonia( " Colonia de Prueba ");
            colonia.setCp("0000");
            colonia.setMunicipio( municipio );

            assertNotNull( coloniaHiberImpl );
            coloniaHiberImpl.save(colonia);

    }

    @Test
    void update()
    {
        GenericSql<Colonia> coloniaHiberImpl = ColoniaHiberImpl.getInstance();
        GenericSql<Municipio> municipioHiber = MunicipioHiberImpl.getInstance();

        Municipio municipio = municipioHiber.findById(2);

        Colonia colonia = new Colonia();
        colonia.setId(1);
        colonia.setColonia( "Colonia " + colonia.getId() + " nueva");
        colonia.setCp("0000");
        colonia.setMunicipio(municipio);

        assertNotNull( colonia );
        coloniaHiberImpl.update( colonia );
    }

    @Test
    void delete()
    {
        GenericSql<Colonia> coloniaHiberImpl = ColoniaHiberImpl.getInstance();
        Colonia colonia = coloniaHiberImpl.findById(1);

        assertNotNull( colonia );
        coloniaHiberImpl.delete( colonia );
    }

    @Test
    void findById()
    {
        GenericSql<Colonia> coloniaHiberImpl = ColoniaHiberImpl.getInstance();
        Colonia colonia = coloniaHiberImpl.findById(2);

        assertNotNull( colonia );
        System.out.println( colonia );
    }
}