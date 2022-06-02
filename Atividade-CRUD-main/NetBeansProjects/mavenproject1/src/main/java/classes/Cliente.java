/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cliente {
    protected int id;
    protected String nome;
    protected String email;
    protected int idade;
    protected String username;
    
    public Cliente(int id){
        if(id > 0){
            String sql = "SELECT * FROM cliente WHERE id = ?";
            
            try{
                Connection con = DB.conexao();
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet registro = stmt.executeQuery();
            
                while(registro.next()){
                    this.setId(registro.getInt("id"));
                    this.setNome(registro.getString("nome"));
                    this.setEmail(registro.getString("email"));
                    this.setIdade(registro.getInt("idade"));
                    this.setUsername(registro.getString("username"));
                }
            }catch(SQLException e){
            System.out.print("Erro na consulta de Cliente: "+e.toString());
            }
        }
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return this.idade;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    
    public void adicionar () {
        String sql = "INSERT INTO cliente (id, nome, email, idade, username) VALUES (?, ?, ?, ?, ?)";
        
        try{
    Connection con = DB.conexao();
    PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, this.getId());
        stmt.setString(2, this.getNome());
        stmt.setString(3, this.getEmail());
        stmt.setInt(4, this.getIdade());
        stmt.setString(5, this.getUsername());
        stmt.execute();
        }catch(SQLException e){
            System.out.print("Erro no adicionar Cliente: "+e.toString());
        }
    }
    
    public static ArrayList<Cliente> listar (){
        String sql = "SELECT * FROM cliente";
        ArrayList<Cliente>cliente = new ArrayList<>();
        
        try{
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet registros = stmt.executeQuery();
            
            while(registros.next()){
            Cliente temp = new Cliente(0);
            temp.setId(registros.getInt("id"));
            temp.setNome(registros.getString("nome"));
            temp.setEmail(registros.getString("email"));
            temp.setIdade(registros.getInt("idade"));
            temp.setUsername(registros.getString("username"));
            
            cliente.add(temp);
            }
        }catch(SQLException e){
        System.out.print("Erro no Listar Cliente: "+e.toString());
        }
        return cliente;
    }
    
    public void atualizar (){
    String sql = "UPDATE cliente SET nome = ?, email = ?, idade = ?, username = ? WHERE id = ?";
        try{
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, this.getNome());
            stmt.setString(2, this.getEmail());
            stmt.setInt(3, this.getIdade());
            stmt.setString(4, this.getUsername());
            stmt.setInt(5, this.getId());
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            System.out.print("Erro no Atualizar: "+e.toString());
        }
    }
    
    public void excluir (){
    String sql = "DELETE FROM cliente WHERE id = ?";
        
            try{
                Connection con = DB.conexao();
                PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setInt(1, this.getId());
                    stmt.executeUpdate();
                
        
            }catch(SQLException e){
            System.out.print("Erro no excluir: "+e.toString());
            }    
    }
    
    
}
