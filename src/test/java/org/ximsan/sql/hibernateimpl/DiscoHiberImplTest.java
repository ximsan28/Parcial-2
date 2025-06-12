package org.ximsan.sql.hibernateimpl;

import org.junit.jupiter.api.Test;
import org.ximsan.model.*;
import org.ximsan.sql.GenericSql;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DiscoHiberImplTest {

    @Test
    void getInstance()
    {
        GenericSql<Disco> discoHiber = DiscoHiberImpl.getInstance();
        assertNotNull(discoHiber);
    }

    @Test
    void findAll()
    {
        GenericSql<Disco> discoHiber = DiscoHiberImpl.getInstance();
        List<Disco> list = discoHiber.findAll();

        assertNotNull(list);
        list.forEach(System.out::println);
    }

    @Test
    void save()
    {
        GenericSql<Disco> discoHiber = DiscoHiberImpl.getInstance();
        GenericSql<Artista> artistaHiber = ArtistaHiberImpl.getInstance();
        GenericSql<Disquera> disqueraHiber = DisqueraHiberImpl.getInstance();
        GenericSql<Genero_Musical> generoMusicalHiber = GeneroMusicalHiberImpl.getInstance();

        Artista artista = artistaHiber.findById(1);
        Disquera disquera = disqueraHiber.findById(1);
        Genero_Musical generoMusical = generoMusicalHiber.findById(1);

        Disco disco = new Disco();
        disco.setId(1);
        disco.setTituloDisco( " Disco Prueba " + 1);
        disco.setDescuento(10);
        disco.setExistencias(1);
        disco.setPrecio(100);
        disco.setFechaLanzamiento(LocalDate.ofEpochDay(2025-8-26));
        disco.setImagen("imagen.png");
        disco.setArtista(artista);
        disco.setDisquera(disquera);
        disco.setGeneroMusical(generoMusical);

        assertNotNull(discoHiber);
        discoHiber.save(disco);

    }

    @Test
    void update()
    {
        GenericSql<Disco> discoHiber = DiscoHiberImpl.getInstance();
        GenericSql<Artista> artistaHiber = ArtistaHiberImpl.getInstance();
        GenericSql<Disquera> disqueraHiber = DisqueraHiberImpl.getInstance();
        GenericSql<Genero_Musical> generoMusicalHiber = GeneroMusicalHiberImpl.getInstance();

        Artista artista = artistaHiber.findById(1);
        Disquera disquera = disqueraHiber.findById(1);
        Genero_Musical generoMusical = generoMusicalHiber.findById(2);

        Disco disco = new Disco();
        disco.setId(1);
        disco.setTituloDisco( " Disco Prueba " + disco.getId() + 1);
        disco.setDescuento(10);
        disco.setExistencias(1);
        disco.setPrecio(100);
        disco.setFechaLanzamiento(LocalDate.ofEpochDay(2025-8-26));
        disco.setImagen("imagen.png");
        disco.setArtista(artista);
        disco.setDisquera(disquera);
        disco.setGeneroMusical(generoMusical);

        assertNotNull( disco );
        discoHiber.update( disco );
    }

    @Test
    void delete()
    {
        GenericSql<Disco> discoHiber = DiscoHiberImpl.getInstance();

        Disco disco = discoHiber.findById(2);

        assertNotNull(disco);
        discoHiber.delete(disco);
    }

    @Test
    void findById()
    {
        GenericSql<Disco> discoHiber = DiscoHiberImpl.getInstance();
        Disco disco = discoHiber.findById(1);

        assertNotNull( disco );
        System.out.println(disco);
    }
}