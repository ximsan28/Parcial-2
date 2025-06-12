package org.ximsan.sql.hibernateimpl;

import org.junit.jupiter.api.Test;
import org.ximsan.model.Artista;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtistaHiberImplTest {

    @Test
    void getInstance()
    {
        assertNotNull( ArtistaHiberImpl.getInstance());
    }

    @Test
    void findAll()
    {
        ArtistaHiberImpl artistaHiber = ArtistaHiberImpl.getInstance();
        List<Artista> list = artistaHiber.findAll();
        assertNotNull( list );
        assertTrue(list.size()>=1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save()
    {
        ArtistaHiberImpl artistaHiber = ArtistaHiberImpl.getInstance();
        Artista artista = new Artista();
        artista.setArtista("Michael Jackson");
        artista.setId(1);
        assertTrue( artistaHiber.save(artista));
    }

    @Test
    void update()
    {
        ArtistaHiberImpl artistaHiber = ArtistaHiberImpl.getInstance();
        Artista artista = new Artista();
        artista.setArtista("Humbe");
        artista.setId(1);
        assertTrue( artistaHiber.update(artista));
    }

    @Test
    void delete()
    {
        ArtistaHiberImpl artistaHiber = ArtistaHiberImpl.getInstance();
        Artista artista = new Artista();
        artista.setId(1);
        assertTrue( artistaHiber.delete(artista));
    }

    @Test
    void findById()
    {
        ArtistaHiberImpl artistaHiber = ArtistaHiberImpl.getInstance();
        Artista artista = null;
        artista = artistaHiber.findById(1);
        assertNotNull(artista);
        assertEquals( "Bruno Mars", artista.getArtista() );
        assertEquals( 1, artista.getId());
    }
}