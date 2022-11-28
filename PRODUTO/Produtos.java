package PRODUTO;

import java.util.ArrayList;
import java.util.Scanner;

import SobreCLiente.CadastroCliente;
import SobreCLiente.Cliente;

public class Produtos{
    ArrayList<Produto> produtos = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    
    Cliente cliente = new Cliente();
    Produto produto = new Produto();

    public Produtos(){
        produtos.add(new Produto("Arroz", 2.5f, 3));
        produtos.add(new Produto("Feijao", 2.5f, 5));
        produtos.add(new Produto("Cafe", 2.5f, 7));
        produtos.add(new Produto("Macarrao", 2.5f, 7));
        produtos.add(new Produto("Cuscuz", 2.5f, 7));
        produtos.add(new Produto("Tomate", 2.5f, 87));
        produtos.add(new Produto("Caviar fds", 10.000f, 87));
    }
    
    // Padrão de projeto Singleton pattern
    private static Produtos istance = null;
    static public Produtos getInstance(){
        if (istance == null){
            istance = new Produtos();
        }
        return istance;
    }

    public void adicionarProduto(){
        System.out.println("\n\n==========================================");
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Qual sera o valor do produto? ");
        int valor = input.nextInt();
        System.out.print("Tera quantos diponiveis? ");
        int quantidade = input.nextInt();
        produtos.add(new Produto(nome, valor, quantidade));
    }

    public void comprarProduto(ComprarProduto comprarProduto){
        for(int i = 0; i < produtos.size(); i++){
            Produto produto = produtos.get(i);

        if(produto.mostrarNome().toLowerCase().equals(comprarProduto.mostrarNome()) && produto.mostrarQuantidade() > 0){
            if(produto.mostrarQuantidade() >= comprarProduto.pegarQuantidade()){
                // Fazer o desconto das compras no dinheiro do cliente
                    //Criado uma variavel que ira receber o valor dinheiro do cliente atual que está na lista
                Float dinheiro = CadastroCliente.getInstance().trazerListaClientes().get(CadastroCliente.getInstance().Index()).mostrarDinheiro();
                    //Criado a variavel que recebera o custo do produto
                Float custoProduto = produto.valor * comprarProduto.pegarQuantidade();
                
                // Verificando se o cliente tem dinheiro suficiente para realizar a compra
                if (dinheiro >= custoProduto){
                    
                    //Realizando o calculo para o desconto no dinheiro atual do cliente
                    Float descontoDinheiro = dinheiro - custoProduto;

                // Fazendo atualização no dinheiro do cliente atual, após as compras realizadas
                    CadastroCliente.getInstance().trazerListaClientes().get(CadastroCliente.getInstance().Index()).alterarDinheiro(descontoDinheiro);
                
                  // Registando o gasto do Cliente
                    // Criado a variavel gasto, que ira pegar o quanto o cliente atual já gastou
                    Float gasto = CadastroCliente.getInstance().trazerListaClientes().get(CadastroCliente.getInstance().Index()).valorGasto();
                    // Criado variavel aumentGasto para facilitar na leitura do codigo
                     Float aumentoGasto = gasto;
                    // Fazendo os calculos do gasto atual
                    aumentoGasto += (produto.valor * comprarProduto.pegarQuantidade());
                // Atualizando os gastos do cliente atual
                    CadastroCliente.getInstance().trazerListaClientes().get(CadastroCliente.getInstance().Index()).alterarGasto(aumentoGasto);
                
                    // Mostrando os Status do cliente
                    System.out.println(CadastroCliente.getInstance().umCliente());

                //Realizando atualização nos produtos do mercado
                    produto.alterarQuantidade(produto.mostrarQuantidade() - comprarProduto.pegarQuantidade());
                    if (produto.mostrarQuantidade() == 0){
                        produtos.remove(produto);
                        break;
                    }
                }else{
                    System.out.println("\n------------------------------------------\nDinheiro insuficiente para realizar a compra.");
                    break;
                }
                
            }else{
                System.out.println("\n------------------------------------------\nQuantidade invalida");
                break;
            }
            break;
        }
        }
    }
    public void removerProduto(RemoverProduto removerProduto){
        for(int i = 0; i < produtos.size(); i++){
            Produto produto = produtos.get(i);
    
            if(produto.mostrarNome().toLowerCase().equals(removerProduto.mostrarNomeR())){
                
                produtos.remove(produto);
                // Sai do loop.
                break;
            }
        }
    }
    public void pesquisarProduto(PesquisarProduto pesquisarProduto){
        for (Produto produto: produtos){ //Chamada Enhanced for-loop para percorrer toda a lista.
            if(produto.mostrarNome().toLowerCase().equals(pesquisarProduto.mostrarNomeP().toLowerCase())){
                System.out.println(produto);
            }
        }
            
    }
    public void VerProdutos(){
        for (Produto produto: produtos){ //Chamada Enhanced for-loop para percorrer toda a lista.
            System.out.println(produto);
        }
    }

}
