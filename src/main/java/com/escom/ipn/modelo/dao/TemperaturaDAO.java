/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.modelo.dao;

import com.escom.ipn.modelo.dto.TemperaturaDTO;
import com.escom.ipn.modelo.entidades.Temperatura;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TemperaturaDAO {
//    private static final String SQL_INSERT="{call spInsertarTemperatura(?,?)}";
//    private static final String SQL_UPDATE="{call spActualizarTemperatura(?,?,?)}";
//    private static final String SQL_DELETE="{call spEliminarTemperatura(?)}";
//    private static final String SQL_READ="{call spSeleccionarTemperatura(?)}";
//    private static final String SQL_READ_ALL="{call spSeleccionarTodo()}";
    
    private static final String SQL_INSERT="insert into Temperatura (valorTemperatura, tiempoTemperatura) values(?,?)";
    private static final String SQL_UPDATE="update Temperatura set valorTemperatura = ?, tiempoTemperatura = ? where idTemperatura = ?";
    private static final String SQL_DELETE="delete from Temperatura where idTemperatura = ?";
    private static final String SQL_READ="select * from Temperatura where idTemperatura = ?";
    private static final String SQL_READ_ALL="select * from Temperatura";
//private static final String SQL_UPDATE = "update Evento set nombreEvento = ?, sede = ?, duracion= ?, fechaInicio = ?, fechaTermino = ? where  IdEvento = ?";
//    private static final String SQL_DELETE = "delete from Evento where idEvento = ?";
//    private static final String SQL_SELECT_ALL = "select * from Evento";
//    private static final String SQL_SELECT = "select * from Evento where idEvento = ?";
    private Connection con;
    public Connection ObtenerConexion(){
       String usr = "postgres";
       String pwd = "root";
       String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        
//         String usr = "ecearivvtixipv";
//        String pwd = "76a9b556592cf93833352d30ca2a94228441d0f80f76a08736a66db72c397f28";
//        String driver = "org.postgresql.Driver";
//        String url = "jdbc:postgresql://ec2-3-220-98-137.compute-1.amazonaws.com:5432/dfdfl4fv7smte5";
        //?sslmode=required
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,usr,pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TemperaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void create(TemperaturaDTO dto) throws SQLException{
        ObtenerConexion();
        PreparedStatement cs = null;
        try {
            cs = con.prepareStatement(SQL_INSERT);
            cs.setFloat(1, dto.getEntidad().getValorTemperatura());
            cs.setTimestamp(2, dto.getEntidad().getTiempoTemperatura());
            cs.executeUpdate();
        } finally {
            if(cs != null){
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    
    public void update(TemperaturaDTO dto) throws SQLException{
        ObtenerConexion();
        PreparedStatement cs = null; //Callablestatement es para stock procedures
        try {
            cs = con.prepareStatement(SQL_UPDATE);
            cs.setFloat(1, dto.getEntidad().getValorTemperatura());
            cs.setTimestamp(2, dto.getEntidad().getTiempoTemperatura());
            cs.setInt(3, dto.getEntidad().getIdTemperatura());
            cs.executeUpdate();
        } finally {
            if(cs != null){
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public void delete(TemperaturaDTO dto) throws SQLException{
        ObtenerConexion();
        PreparedStatement cs = null;
        try {
            cs = con.prepareStatement(SQL_DELETE);
            cs.setInt(1, dto.getEntidad().getIdTemperatura());
            cs.executeUpdate();
        } finally {
            if(cs != null){
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public TemperaturaDTO read(TemperaturaDTO dto) throws SQLException{
        ObtenerConexion();
        PreparedStatement cs = null;
        ResultSet rs =null;
        try {
            cs = con.prepareStatement(SQL_READ);
            cs.setInt(1, dto.getEntidad().getIdTemperatura());
            rs = cs.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (TemperaturaDTO) resultados.get(0);
            }else{
                return null;
            }
        } finally {
            if(rs != null){
                rs.close();
            }
            if(cs != null){
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public List readAll() throws SQLException{
        ObtenerConexion();
        PreparedStatement cs = null;
        ResultSet rs =null;
        try {
            cs = con.prepareStatement(SQL_READ_ALL);
            rs = cs.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            }else{
                return null;
            }
        } finally {
            if(rs != null){
                rs.close();
            }
            if(cs != null){
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException{
        List resultados = new ArrayList();
        while (rs.next()) {            
            TemperaturaDTO dto = new TemperaturaDTO();
            dto.getEntidad().setIdTemperatura(rs.getInt("idTemperatura"));
            dto.getEntidad().setValorTemperatura(rs.getFloat("valorTemperatura"));
            dto.getEntidad().setTiempoTemperatura(rs.getTimestamp("tiempoTemperatura"));
            resultados.add(dto);
        }
        return resultados;
    }
    
    public static void main(String[] args) {
        TemperaturaDAO dao = new TemperaturaDAO();
        TemperaturaDTO dto = new TemperaturaDTO();
        Temperatura entidad = new Temperatura();
        entidad.setIdTemperatura(1);
        entidad.setValorTemperatura((float) 30.5);
        //timestamp YYYY-MM-DD HH:MI:SS.NNNNNN
        Timestamp ts = Timestamp.valueOf("2021-05-26 00:00:01.12345678");
        entidad.setTiempoTemperatura(ts);
        dto.setEntidad(entidad);
        
        try {
            dao.create(dto);
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(TemperaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
