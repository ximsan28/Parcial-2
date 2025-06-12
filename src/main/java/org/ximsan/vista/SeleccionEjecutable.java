package org.ximsan.vista;

import org.ximsan.vista.consola.Consola;
import org.ximsan.vista.ventana.Ventana;

public class SeleccionEjecutable extends LeerAcciones
{
    public static SeleccionEjecutable seleccionEjecutable;

    private SeleccionEjecutable()
    {
    }

    public static SeleccionEjecutable getInstance()
    {
        if(seleccionEjecutable==null)
        {
            seleccionEjecutable = new SeleccionEjecutable();
        }
        return seleccionEjecutable;
    }

    @Override
    public void despliegaMenu()
    {
        System.out.println("\tBienvenido a PixUp");
        System.out.println("Selecciona tu método de acceso:");
        System.out.println("1. Consola");
        System.out.println("2. Ventana");
        System.out.println("3. Salir");
        Menu.seleccionaOpcion();
    }

    @Override
    public int valorMinMenu()
    {
        return 1;
    }
    @Override
    public int valorMaxMenu()
    {
        return 3;
    }

    @Override
    public void procesaOpcion()
    {
        Ejecutable ejecutable = null;
        if(opcion==1)
        {
            ejecutable = Consola.getInstance();
        }
        if(opcion==2)
        {
            ejecutable = Ventana.getInstance();
        }
        ejecutable.setFlag( true );
        ejecutable.run();
    }
}

