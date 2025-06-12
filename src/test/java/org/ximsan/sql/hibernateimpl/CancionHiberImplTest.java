package org.ximsan.sql.hibernateimpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ximsan.model.*;
import org.ximsan.sql.GenericSql;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class CancionHiberImplTest {

    @Test
    void getInstance()
    {
        GenericSql<Cancion> cancionHiber = CancionHiberImpl.getInstance();
        assertNotNull( cancionHiber );
    }

    @Test
    void findAll()
    {
        GenericSql<Cancion> cancionHiber = CancionHiberImpl.getInstance();
        List<Cancion> list = cancionHiber.findAll();

        assertNotNull(list);
        list.forEach(System.out::println);
    }

    @Test
    public void save() {
        GenericSql<Cancion> cancionHiber = CancionHiberImpl.getInstance();
        GenericSql<Disco> discoHiber = DiscoHiberImpl.getInstance();

        Disco disco = discoHiber.findById(1);

        Cancion cancion = new Cancion();
        cancion.setId(2);
        cancion.setTituloCancion( " Cancion de prueba "+1);
        cancion.setDuracion(LocalTime.parse("00:03:53"));
        cancion.setDisco(disco);

        assertNotNull(cancionHiber);
        cancionHiber.save(cancion);
    }


    @Test
    void update()
    {
        GenericSql<Cancion> cancionHiber = CancionHiberImpl.getInstance();
        List<Cancion> canciones = cancionHiber.findAll();
        Assertions.assertFalse(canciones.isEmpty());

        Cancion cancion = canciones.get(1);
        String nuevoTitulo = "Canción actualizada";
        cancion.setTituloCancion(nuevoTitulo);
        cancionHiber.update(cancion);

        Cancion actualizada = cancionHiber.findById(cancion.getId());
        Assertions.assertEquals(nuevoTitulo, actualizada.getTituloCancion());
    }

    @Test
    void delete()
    {
        GenericSql<Cancion> cancionHiber = CancionHiberImpl.getInstance();

        Cancion cancion = cancionHiber.findById(1);

        assertNotNull(cancion);
        cancionHiber.delete(cancion);
    }

    @Test
    void findById()
    {
        GenericSql<Cancion> cancionHiber = CancionHiberImpl.getInstance();
        List<Cancion> canciones = cancionHiber.findAll();
        Assertions.assertFalse(canciones.isEmpty());

        Cancion existente = canciones.get(0);
        Cancion encontrada = cancionHiber.findById(existente.getId());
        Assertions.assertNotNull(encontrada);
        Assertions.assertEquals(existente.getTituloCancion(), encontrada.getTituloCancion());
    }
}