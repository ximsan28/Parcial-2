package org.ximsan.sql.hibernateimpl;

import org.junit.jupiter.api.Test;
import org.ximsan.model.Genero_Musical;
import org.ximsan.sql.GenericSql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class GeneroMusicalHiberImplTest {

    @Test
    void getInstance()
    {
        GenericSql<Genero_Musical> generoMusicalHiber = GeneroMusicalHiberImpl.getInstance();
        assertNotNull(generoMusicalHiber);
    }

    @Test
    void findAll()
    {
        GenericSql<Genero_Musical> generoMusicalHiber = GeneroMusicalHiberImpl.getInstance();
        List<Genero_Musical> list = generoMusicalHiber.findAll();

        assertNotNull(list);
        list.forEach(System.out::println);
    }

    @Test
    void save()
    {
        GenericSql<Genero_Musical> discoHiber = GeneroMusicalHiberImpl.getInstance();

        Genero_Musical generoMusical = new Genero_Musical();
        generoMusical.setId(1);
        generoMusical.setGenero( " Disco Prueba " + 1);

        assertNotNull(discoHiber);
        discoHiber.save(generoMusical);

    }

    @Test
    void update()
    {
        GenericSql<Genero_Musical> discoHiber = GeneroMusicalHiberImpl.getInstance();

        Genero_Musical generoMusical = new Genero_Musical();
        generoMusical.setId(1);
        generoMusical.setGenero( " Disco Prueba " + 1);

        assertNotNull( generoMusical );
        discoHiber.update( generoMusical );
    }

    @Test
    void delete()
    {
        GenericSql<Genero_Musical> generoMusicalHiber = GeneroMusicalHiberImpl.getInstance();

        Genero_Musical generoMusical = generoMusicalHiber.findById(1);

        assertNotNull(generoMusical);
        generoMusicalHiber.delete(generoMusical);
    }

    @Test
    void findById()
    {
        GenericSql<Genero_Musical> generoMusicalHiber = GeneroMusicalHiberImpl.getInstance();
        Genero_Musical generoMusical = generoMusicalHiber.findById(1);

        assertNotNull(generoMusical);
        System.out.println(generoMusical);
    }
}