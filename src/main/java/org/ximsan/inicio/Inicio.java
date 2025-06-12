package org.ximsan.inicio;

import org.ximsan.vista.SeleccionEjecutable;

public class Inicio
{
    public static void main(String[] args)
    {
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        System.out.println("\t ~~~~~~~ PixUp ~~~~~~~ ");
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        SeleccionEjecutable.getInstance().run();
        System.out.println("\tHasta luego :))");
    }
}