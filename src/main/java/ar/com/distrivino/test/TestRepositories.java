package ar.com.distrivino.test;

import ar.com.distrivino.entities.Vino;
import ar.com.distrivino.repositories.interfaces.I_VinoRepository;
import ar.com.distrivino.repositories.jdbc.VinoRepository;
import ar.com.distrivino.connectors.Connector;
import ar.com.distrivino.entities.Cliente;
import ar.com.distrivino.entities.Compra;
import ar.com.distrivino.entities.Proveedor;

import ar.com.distrivino.entities.Venta;
import ar.com.distrivino.repositories.interfaces.I_ClienteRepository;
import ar.com.distrivino.repositories.interfaces.I_CompraRepository;
import ar.com.distrivino.repositories.interfaces.I_ProveedorRepository;

import ar.com.distrivino.repositories.interfaces.I_VentaRepository;
import ar.com.distrivino.repositories.jdbc.ClienteRepository;
import ar.com.distrivino.repositories.jdbc.CompraRepository;
import ar.com.distrivino.repositories.jdbc.ProveedorRepository;

import ar.com.distrivino.repositories.jdbc.VentaRepository;

public class TestRepositories {
    public static void main(String[] args) {
//        Stock stock = new Stock(0,0,0);
//        System.out.println(stock);
//        System.out.println("*********");
//        stock.comprar(100);
//        System.out.println(stock);
//        System.out.println("Las existencias totales son: " + stock.totalStock(0));
//        System.out.println("***********");
//        stock.vender(100);
//        System.out.println(stock);
//        System.out.println("Las existencias totales son:" + stock.totalStock(0));
//        System.out.println("********");
//        stock.comprar(150);
//        System.out.println(stock);
//        stock.vender(80);
//        System.out.println(stock);
//        System.out.println("Las existencias totales son: " + stock.totalStock(0));
//        System.out.println(stock.totalStock(0));

          I_VinoRepository vr = new VinoRepository(Connector.getConnection());
          Vino vino = new Vino("Lopez", "Lopez", "Malbec", 2016, 0);
//          vr.save(vino);
          System.out.println(vino);
          
          I_ClienteRepository cr = new ClienteRepository(Connector.getConnection());
          Cliente cliente = new Cliente("Sigali Catalina", "11-7843-7741", "sigalicatalina@gmail.com", "EF");
//          cr.save(cliente);
          System.out.println(cliente);
          
          I_ProveedorRepository pr = new ProveedorRepository(Connector.getConnection());
          Proveedor proveedor = new Proveedor("Bodegas Lopez", "distribucion@bodegaslopez.com");
//          pr.save(proveedor);
          System.out.println(proveedor);
          
          I_CompraRepository co = new CompraRepository(Connector.getConnection());
          Compra compra = new Compra(4, 2, 68, 450, "26/01/2021",0);
//          co.save(compra);
          System.out.println(compra);
//          co.sum(compra);
//          System.out.println(compra);
          
          I_VentaRepository ve = new VentaRepository  (Connector.getConnection());
          Venta venta = new Venta(4, 1, 8, 870, "28/01/2021",0);
//          ve.save(venta);
          System.out.println(venta);
//          ve.remove(ve.getByFactura(1));
//          co.remove(co.getByFactura(2));
//          co.remove(co.getByFactura(3));

          
    }
}
    
