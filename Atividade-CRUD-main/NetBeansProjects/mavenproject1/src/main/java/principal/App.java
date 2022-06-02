/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;
import classes.Cliente;
import classes.Produto;
import java.util.ArrayList;

public class App {
   public static void main(String[] args){
        
       Produto produto = new Produto(0);
       Produto p = new Produto(0);
        p.setMarca("Post-it");
        p.setPreco(3.00);
        p.setQuantidade(5);
        p.setModelo("Bloco de Notas");
        p.adicionar();
        
        ArrayList<Produto> produtos = Produto.listar();
        for(Produto produto1: produtos){
        String marca = produto1.getMarca();
        double preco = produto1.getPreco();
        int id = produto1.getId();
        int quantidade = produto1.getQuantidade();
        String modelo = produto1.getModelo();
        System.out.print(marca + preco + id + quantidade + modelo);
        }

        Produto p1 = new Produto(0);
        p1.setMarca("Post-it");
        p1.setPreco(3.00);
        p1.setQuantidade(5);
        p1.setModelo("Bloco de Notas");
        p1.atualizar();
        
        
        Produto p2 = new Produto(0);
        p2.excluir();
        
        
        Cliente c = new Cliente(0);
        c.setNome("Marinalva");
        c.setEmail("marimari@bol.com");
        c.setIdade(34);
        c.setUsername("MariahTodaLindah");
        c.adicionar();
        
        ArrayList<Cliente>clientes = Cliente.listar();
        for(Cliente cliente1: clientes){
            int id = cliente1.getId();
            String nome = cliente1.getNome();
            String email = cliente1.getEmail();
            int idade = cliente1.getIdade();
            String username = cliente1.getUsername();
            System.out.print(id + nome + email + idade + username);
        }
        
        Cliente c1 = new Cliente(0);
        c1.setNome("Marinalva");
        c1.setEmail("marimari@ifap.edu.br");
        c1.setIdade(34);
        c1.setUsername("MariahTodaLindah");
        c1.atualizar();
        
        Cliente c2 = new Cliente(0);
        c2.excluir();
        
    }
}
