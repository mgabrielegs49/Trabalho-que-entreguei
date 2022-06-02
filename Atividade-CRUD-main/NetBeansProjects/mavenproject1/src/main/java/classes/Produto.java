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

public class Produto {

    protected int id;
    protected int quantidade;
    protected String modelo;
    protected String marca;
    protected double preco;

    public Produto(int id){
        if(id > 0){
            String sql = "SELECT * FROM produto WHERE id = ?";
            
            try{
                Connection con = DB.conexao();
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet registro = stmt.executeQuery();
            
                while(registro.next()){
                    this.setId(registro.getInt("id"));
                    this.setQuantidade(registro.getInt("quantidade"));
                    this.setMarca(registro.getString("marca"));
                    this.setModelo(registro.getString("modelo"));
                    this.setPreco(registro.getDouble("preco"));
                }
            }catch(SQLException e){
            System.out.print("Erro na consulta de Produto: "+e.toString());
            }
        }
    }
    
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }

    public void setQuantidade(int quantidade){
        this.quantidade=quantidade;
    }
    public int getQuantidade(){
        return this.quantidade;
    }

    public void setModelo(String modelo){
        this.modelo=modelo;
    }
    public String getModelo(){
        return this.modelo;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }
    public String getMarca(){
        return this.marca;
    }

    public void setPreco(double preco){
        this.preco=preco;
    }
    public double getPreco(){
        return this.preco;
    }

    public void adicionar( ){
        String sql = "INSERT INTO produto (marca, preco, id, quantidade, modelo) VALUES (?,?,?,?,?)";

            try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, this.getMarca());
            stmt.setDouble(2, this.getPreco());
            stmt.setInt(3, this.getId());
            stmt.setInt(4, this.getQuantidade());
            stmt.setString(5, this.getModelo());
            stmt.execute();
            }catch(SQLException e){
                System.out.print("Erro no adicionar Produto:"+e.toString());
            }
    }
    
    public static ArrayList<Produto> listar(){
        String sql = "SELECT * FROM produto";
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try{
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet registros = stmt.executeQuery();
            
            while(registros.next()){
            Produto temp = new Produto(0);
            temp.setMarca(registros.getString("marca"));
            temp.setPreco(registros.getDouble("preco"));
            temp.setId(registros.getInt("id"));
            temp.setQuantidade(registros.getInt("quantidade"));
            temp.setModelo(registros.getString("modelo"));
            
            produtos.add(temp);
            }
        }catch(SQLException e){
            System.out.print("Erro no Listar Produto: " + e.toString());
        }
        return produtos;
    }
    
    public void atualizar( ){
        String sql = "UPDATE produto SET marca = ?, preco = ?, id =?, quantidade = ? WHERE modelo = ?";
    
        try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, this.getMarca());
            stmt.setDouble(2, this.getPreco());
            stmt.setInt(3, this.getId());
            stmt.setInt(4, this.getQuantidade());
            stmt.setString(5, this.getModelo());
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
        System.out.print("Erro no atualizar: "+e.toString());
        }
    }
    
    public void excluir(){
        String sql = "DELETE FROM produto WHERE id = ?";
        
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

