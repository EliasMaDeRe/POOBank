package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_query {
    private static DB_connect dataBase = new DB_connect();

    public DB_query(){}

    ////////////////////  Consultas Globales /////////////////////

    ////// Muestra a todos los clientes
    public void mostrarClientes() throws ClassNotFoundException, SQLException
    { 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Cliente");
            res = ps.executeQuery();
    
            while(res.next())
            {
                System.out.println("Nombre: "+res.getString(0) + ",Apellido: " + res.getString(1)+"CURP: "+res.getInt(2)+"Cuentas: "+res.getInt(2));
            }    

            dataBase.Finish();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    ////// Muestra a todas las cuentas
    public void mostrarCuentas() throws ClassNotFoundException, SQLException
    { 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Cliente");
            res = ps.executeQuery();
    
            while(res.next())
            {
                System.out.println("Numero de Cuenta: "+res.getInt(0) + ",Contraseña: " + res.getInt(1)+"Saldo: "+res.getInt(2));
            }    

            dataBase.Finish();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    ////// Muestra a todas las transferencias
    public void mostrarTransferencias() throws ClassNotFoundException, SQLException
    { 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Transferencia");
            res = ps.executeQuery();
    
            while(res.next())
            {
                System.out.println("Id: "+res.getInt(0) + ",Cuenta Emisora: " + res.getInt(1)+"Cuenta_Destino: "+res.getInt(2)+"Monto: "+res.getInt(3) +"Estado: "+res.getInt(4) +"Comentario: "+res.getInt(5));
            }    

            dataBase.Finish();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    ////// Muestra a todos los depositos
    public void mostrarDepositos() throws ClassNotFoundException, SQLException
    { 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Deposito");
            res = ps.executeQuery();
    
            while(res.next())
            {
                System.out.println("Id: "+res.getInt(0) + ",Cuenta: " + res.getInt(1)+"Monto: "+res.getInt(2)+"Estado: "+res.getInt(3) +"Comentario: "+res.getInt(4));
            }    

            dataBase.Finish();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    ////// Muestra a todos los retiros
    public void mostrarRetiros() throws ClassNotFoundException, SQLException
    { 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Retiro");
            res = ps.executeQuery();
    
            while(res.next())
            {
                System.out.println("Id: "+res.getInt(0) + ",Cuenta: " + res.getInt(1)+"Monto: "+res.getInt(2)+"Estado: "+res.getInt(3) +"Comentario: "+res.getInt(4));
            }    

            dataBase.Finish();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }


    ///////////////////////////////////////////////////////////////
    ////////////////////  CRUD para Clientes  /////////////////////
    ///////////////////////////////////////////////////////////////


    public int NuevoCliente(String nombre, String apellido, String Curp, int cuentas) throws ClassNotFoundException, SQLException
    {
        int id=0;
        PreparedStatement ps;
        ResultSet res;

        String reg = "INSERT INTO Cliente (Nombre, Apellido, CURP, No_cuentas) VALUES(" + nombre + ","+ apellido + ","+ Curp + "," + cuentas + ")";

        try {
            
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            res = ps.executeQuery();
            id = res.getInt(0);
            dataBase.Finish();
            System.out.println("Se a generado el nuevo cliente");
        
        } catch (SQLException e) {
            System.out.println("El registro no funciono correctamente");
            e.printStackTrace();
        }

        return id;
    }

    public void ActualizarCliente (Cliente cliente) throws ClassNotFoundException, SQLException {

        dataBase.Generate_Connection();
        PreparedStatement ps;
        String reg = "UPDATE Cliente SET Nombre = "+cliente.getNombre()+", Apellido = "+cliente.getApellido()+" , CURP = "+cliente.getCURP()+", No_cuentas = "+cliente.NumberOfCuentas()+" WHERE Id = "+cliente.getID();

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println("No se pudieron actualizar los datos");
            e.printStackTrace();
        }
        

    }

    public void MostrarCliente(Cliente cliente) throws ClassNotFoundException, SQLException
    { 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Cliente WHERE Id= "+cliente.getID());
            res = ps.executeQuery();
    
            while(res.next())
            {
                System.out.println("Id: "+res.getInt(0) + ",Nombre: " + res.getString(1)+"Apellido: "+res.getString(2)+"CURP: "+res.getString(3) +"Cuentas: "+res.getInt(4));
            }    

            dataBase.Finish();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void EliminarCliente(String id)
    {
        PreparedStatement ps;
        String reg = "DELETE FROM Cliente WHERE Id = "+id;

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.execute();
            dataBase.Finish();
            System.out.println("Informacion del "+id+" a sido eliminado");
        } catch(Exception e) {
            System.out.println("No se encontro el Id");
        }
    }



    ///////////////////////////////////////////////////////////////
    ////////////////////  CRUD para Cuentas   /////////////////////
    ///////////////////////////////////////////////////////////////

    public void NuevaCuenta(String nombre, String apellido, String Curp, int cuentas) throws ClassNotFoundException, SQLException
    {
        PreparedStatement ps;

        String reg = "INSERT INTO Cliente (Nombre, Apellido, CURP, No_cuentas) VALUES(" + nombre + ","+ apellido + ","+ Curp + "," + cuentas + ")";

        try {
            
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            dataBase.Finish();
            System.out.println("Se a generado el nuevo cliente");
        
        } catch (SQLException e) {
            System.out.println("El registro no funciono correctamente");
            e.printStackTrace();
        }
    }

    public void ActualizarCuenta (Cliente cliente) throws ClassNotFoundException, SQLException {

        dataBase.Generate_Connection();
        PreparedStatement ps;
        String reg = "UPDATE Cliente SET Nombre = "+cliente.getNombre()+", Apellido = "+cliente.getApellido()+" , CURP = "+cliente.getCURP()+", No_cuentas = "+cliente.NumberOfCuentas()+" WHERE Id = "+cliente.getID();

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println("No se pudieron actualizar los datos");
            e.printStackTrace();
        }
        

    }

    public void MostrarCuenta(Cuenta cuenta) throws ClassNotFoundException, SQLException
    { 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Cuenta WHERE No_cuente = "+ cuenta.getNumeroDeCuenta());
            res = ps.executeQuery();
    
            while(res.next())
            {
                System.out.println("Numero de Cuenta: "+res.getInt(0) + ",Contraseña: " + res.getInt(1)+"Saldo: "+res.getInt(2));
            }    

            dataBase.Finish();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void EliminarCuenta(String id)
    {
        PreparedStatement ps;
        String reg = "DELETE FROM Cliente WHERE Id = "+id;

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.execute();
            dataBase.Finish();
            System.out.println("Informacion del "+id+" a sido eliminado");
        } catch(Exception e) {
            System.out.println("No se encontro el Id");
        }
    } 



    ///////////////////////////////////////////////////////////////
    ///////////////////  CRUD para Depositos  /////////////////////
    ///////////////////////////////////////////////////////////////

    public void GenerarDeposito(Transaccion depo) throws ClassNotFoundException, SQLException
    {
        PreparedStatement ps;

        String reg = "INSERT INTO Deposito (Id, Cuenta, Monto) VALUES(" + depo.id + ","+ depo.numeroDeCuenta + ","+ depo.monto +")";

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            dataBase.Finish();
            System.out.println("Se a registrado el deposito");
        
        } catch (SQLException e) {
            System.out.println("El registro no funciono correctamente");
            e.printStackTrace();
        }
    }



    ///////////////////////////////////////////////////////////////
    ////////////////////  CRUD para Retiros  //////////////////////
    ///////////////////////////////////////////////////////////////


    public void GenerarRetiro(Transaccion retiro) throws ClassNotFoundException, SQLException
    {
        PreparedStatement ps;

        String reg = "INSERT INTO Retiro (Id, Cuenta, Monto) VALUES(" + retiro.id + ","+ retiro.numeroDeCuenta + ","+ retiro.monto +")";

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            dataBase.Finish();
            System.out.println("Se a registrado el retiro");
        
        } catch (SQLException e) {
            System.out.println("El registro no funciono correctamente");
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////
    ///////////////// CRUD para Transferencias  ///////////////////
    ///////////////////////////////////////////////////////////////

    public void GenerarTransaccion(Transaccion trans) throws ClassNotFoundException, SQLException
    {
        PreparedStatement ps;

        String reg = "INSERT INTO Transferencia (Id, Cuenta_Emisora,Cuenta_Destino, Monto) VALUES(" + trans.id + ","+ trans.numeroDeCuenta + ","+ trans.monto +")";

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            dataBase.Finish();
            System.out.println("Se a registrado la transaccion");
        
        } catch (SQLException e) {
            System.out.println("El registro no funciono correctamente");
            e.printStackTrace();
        }
    }



}// fin de la clase DB_query
