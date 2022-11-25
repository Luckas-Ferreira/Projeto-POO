package Base;

import java.util.Scanner;

import PRODUTO.Produtos;
import TelaInicial.UI;

public abstract class Base{
    public abstract void adicionarProduto();
    public abstract void removerComprar();
    public abstract void telaCliente();
    public abstract void telaFuncionario();

    public void verTodosProduto(){
        Produtos produto = new Produtos();
        produto.ProdutosCadastrados();
        produto.VerProdutos();
    }
    public void pesquisarProtuto(){
        Produtos produto = new Produtos();
        produto.ProdutosCadastrados();
        produto.pesquisarProduto(null);
    }
    public void voltar(){
        UI ui = new UI();
        ui.telaInicial();
    }
    public void sair(){
        System.out.println("\nDeseja sair do programa? \nDigite [3] novamente para sair!");
        
    }
    
    
    public void opcao(){
        Scanner input = new Scanner(System.in);

        Boolean condicao = true;
        while(condicao){
            System.out.println("\n==========================================\n");
            System.out.print("Escolha o que deseja: ");
            String decisao = input.nextLine().toUpperCase();
            System.out.println("\n==========================================\n");
            if (decisao.equals("1")){
                telaCliente();
            }else if (decisao.equals("2")){
                telaFuncionario();
            }else if (decisao.equals("C")){
                removerComprar();
            }else if (decisao.equals("R")){
                removerComprar();
            }else if (decisao.equals("A")){
                adicionarProduto();
            }else if (decisao.equals("T")){
                verTodosProduto();
            }else if (decisao.equals("P")){
                pesquisarProtuto();
            } else if (decisao.equals("V")){
                voltar();
            } else if(decisao.equals("3")){
                sair();
                break;
            }
        }
        
    }
}
