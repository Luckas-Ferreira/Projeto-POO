package Base;

import PRODUTO.ComprarProduto;
import PRODUTO.Produtos;

public class TelaCliente extends Base{
    Produtos produto = new Produtos();
    
    @Override
    public void adicionarProduto() {
    }

    @Override
    public void removerComprar() {
        produto.ProdutosCadastrados();
        produto.VerProdutos();
        produto.comprarProduto(new ComprarProduto("açuca", 1));   
    }
}
    
    

