package org.ximsan.vista.consola;
import org.ximsan.vista.*;

public class Consola extends LeerAcciones
{
    private static Consola consola;

    private Consola()
    {
    }

    public static Consola getInstance( )
    {
        if(consola==null)
        {
            consola = new Consola();
        }
        return consola;
    }

    @Override
    public void despliegaMenu()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t Menú principal");
        System.out.println(" Selecciona una opción:");
        System.out.println("1. Catalogo");
        System.out.println("2. Pendiente");
        System.out.println("3. Salir");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
            ejecutable = ListaCatalogos.getInstance();
            ejecutable.setFlag( true );
            ejecutable.run( );
        }
        if(opcion==2)
        {
            System.out.println("## No implementado ##");
        }
    }
}

