package edu.unipampa.poo1.inventory.management;

import java.util.Scanner;
import java.util.List;

public class Interacao {
    private static Produtos produtos = new Produtos();
    private static NotasFiscais notasFiscais = new NotasFiscais();

    public static void main(String[] args) {
        Scanner entradas = new Scanner(System.in);

        System.out.print("\n");
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.print("\n");
        System.out.println("   Sistema de Gerenciamento de Estoque   ");
        System.out.println("          Grupo 2 de POO 2020.2          ");

        exibirMenu(entradas);
    }

    private static void exibirMenu(Scanner entradas) {
        System.out.print("\n");
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.print("\n");
        System.out.println("1 - Cadastrar um novo produto");
        System.out.println("2 - Consultar produtos cadastrados");
        System.out.println("3 - Consultar um produto cadastrado");
        System.out.println("4 - Alterar o cadastro de um produto");
        System.out.println("5 - Excluir o cadastro de um produto");
        System.out.println("6 - Criar nota fiscal");
        System.out.println("7 - Consultar uma nota fiscal");
        System.out.println("8 - Alterar uma nota fiscal");
        System.out.println("9 - Consultar o valor de vendas em um dia");
        System.out.println("10 - Encerrar o sistema");
        System.out.print("\n");
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");

        int entrada = entradas.nextInt();

        switch (entrada) {
            case 1:
                System.out.println("Digite o nome do produto:");
                String provisionalFix = entradas.nextLine();
                String nomeDoProduto = entradas.nextLine();

                System.out.println("Digite uma descrição para o produto:");
                String descricaoDoProduto = entradas.nextLine();

                System.out.println("Digite o preço do produto:");
                double precoDoProduto = entradas.nextDouble();
                
                System.out.println("Selecione o tipo de venda do produto (digitando 1 ou 2):");
                System.out.println("   1 - Venda por unidade");
                System.out.println("   2 - Venda por quilo");
                int entradaTipoDeVenda = entradas.nextInt();

                switch (entradaTipoDeVenda) {
                    case 1:
                        System.out.println("Digite a quantidade do produto (em unidades):");
                        double quantidadeEmUnidades = entradas.nextDouble();

                        ProdutoUnidade produtoUnidade = new ProdutoUnidade(
                            nomeDoProduto,
                            descricaoDoProduto,
                            precoDoProduto,
                            quantidadeEmUnidades
                        );

                        produtos.addProduto(produtoUnidade);
                        
                        confirmarCadastroDeProduto("Por unidade", produtoUnidade);
                        break;

                    case 2:
                        System.out.println("Digite a quantidade do produto (em quilos):");
                        double quantidadeEmQuilos = entradas.nextDouble();

                        ProdutoQuilo produtoQuilo = new ProdutoQuilo(
                            nomeDoProduto,
                            descricaoDoProduto,
                            precoDoProduto,
                            quantidadeEmQuilos
                        );

                        produtos.addProduto(produtoQuilo);
                        
                        confirmarCadastroDeProduto("Por quilo", produtoQuilo);
                        break;
                
                    default:
                        System.out.println("Selecione o tipo de venda do produto (digitando 1 ou 2):");
                        System.out.println("    1 - Venda por unidade");
                        System.out.println("    2 - Venda por quilo");
                        entradaTipoDeVenda = entradas.nextInt();
                        break;
                }

                exibirMenu(entradas);

                break;

            case 2:
                List<Produto> estoque = produtos.getEstoque();

                System.out.print("\n");

                if (estoque.size() > 0) {
                    System.out.println("Veja a lista de produtos cadastrados:");
                    System.out.print("\n");

                    for (int i = 0; i < estoque.size(); i++) {
                        System.out.println(
                            "Código: " + estoque.get(i).getCodigo() +
                            " | Nome: " + estoque.get(i).getNome() +
                            " | Descrição: " + estoque.get(i).getDescricao() +
                            " | Preço: " + estoque.get(i).getPreco() +
                            " | Quantidade: " + estoque.get(i).getQuantidade()
                        );
                    }
                } else {
                    System.out.println("Nenhum produto cadastrado :(");
                }

                exibirMenu(entradas);
                break;

            case 3:
                System.out.println("Digite o código do produto a ser consultado:");
                int codigoDoProdutoAConsultar = entradas.nextInt();

                Produto produtoEncontrado = produtos.getProduto(codigoDoProdutoAConsultar);
                
                if (produtoEncontrado != null) {
                    System.out.println(
                        "Código: " + produtoEncontrado.getCodigo() +
                        " | Nome: " + produtoEncontrado.getNome() +
                        " | Descrição: " + produtoEncontrado.getDescricao() +
                        " | Preço: " + produtoEncontrado.getPreco() +
                        " | Quantidade: " + produtoEncontrado.getQuantidade()
                    );
                } else {
                    System.out.println(
                        "Nenhum produto com o código " +
                        codigoDoProdutoAConsultar + 
                        " foi encontrado :("
                    );
                }

                exibirMenu(entradas);
                break;

            case 4:
                System.out.println("Digite o código do produto a ser alterado:");
                int codigoDoProdutoAAlterar = entradas.nextInt();

                Produto produtoASerAlterado = produtos.getProduto(codigoDoProdutoAAlterar);
                
                if (produtoASerAlterado != null) {
                    System.out.println("Atualmente, essas são as informações do produto #" + codigoDoProdutoAAlterar + ":");
                    System.out.print("\n");

                    System.out.println(
                        "Código: " + produtoASerAlterado.getCodigo() +
                        " | Nome: " + produtoASerAlterado.getNome() +
                        " | Descrição: " + produtoASerAlterado.getDescricao() +
                        " | Preço: " + produtoASerAlterado.getPreco() +
                        " | Quantidade: " + produtoASerAlterado.getQuantidade()
                    );
                    
                    System.out.print("\n");
                    System.out.println("Selecione qual informação você deseja alterar:");
                    System.out.println("    1 - Nome");
                    System.out.println("    2 - Descrição");
                    System.out.println("    3 - Preço");
                    System.out.println("    4 - Quantidade");
                    int entradaInfoASerAlterada = entradas.nextInt();

                    switch (entradaInfoASerAlterada) {
                        case 1:
                            System.out.println("Digite um novo nome para o produto:");
                            provisionalFix = entradas.nextLine();
                            String novoNomeDoProduto = entradas.nextLine();
                            produtoASerAlterado.setNome(novoNomeDoProduto);

                            System.out.print("\n");
                            System.out.println("Nome alterado com sucesso :)");
                            break;

                        case 2:
                            System.out.println("Digite uma nova descrição para o produto:");
                            provisionalFix = entradas.nextLine();
                            String novaDescDoProduto = entradas.nextLine();
                            produtoASerAlterado.setDescricao(novaDescDoProduto);

                            System.out.print("\n");
                            System.out.println("Descrição alterada com sucesso :)");
                            break;

                        case 3:
                            System.out.println("Digite um novo preço para o produto:");
                            double novoPrecoDoProduto = entradas.nextDouble();
                            produtoASerAlterado.setPreco(novoPrecoDoProduto);

                            System.out.print("\n");
                            System.out.println("Preço alterado com sucesso :)");
                            break;

                        case 4:
                            System.out.println("Digite uma nova quantidade para o produto:");
                            double novaQuantidadeDoProduto = entradas.nextDouble();
                            produtoASerAlterado.setQuantidade(novaQuantidadeDoProduto);

                            System.out.print("\n");
                            System.out.println("Quantidade alterada com sucesso :)");
                            break;
                    
                        default:
                            System.out.print("\n");
                            System.out.println("Entrada inválida :(");

                            System.out.print("\n");
                            System.out.println("Selecione qual informação você deseja alterar:");
                            System.out.println("    1 - Nome");
                            System.out.println("    2 - Descrição");
                            System.out.println("    3 - Preço");
                            System.out.println("    4 - Quantidade");
                            entradaInfoASerAlterada = entradas.nextInt();

                            break;
                    }
                } else {
                    System.out.println(
                        "Nenhum produto com o código " +
                        codigoDoProdutoAAlterar + 
                        " foi encontrado :("
                    );
                }

                exibirMenu(entradas);
                break;

            case 5:
                System.out.println("Digite o código do produto a ser excluído:");
                int codigoDoProdutoAExcluir = entradas.nextInt();

                boolean produtoFoiExcluido = produtos.removeProduto(codigoDoProdutoAExcluir);
                
                if (produtoFoiExcluido) {
                    System.out.println(
                        "Produto #" + codigoDoProdutoAExcluir + " excluído com sucesso :)"
                    );
                } else {
                    System.out.println(
                        "Nenhum produto com o código " +
                        codigoDoProdutoAExcluir + 
                        " foi encontrado :("
                    );
                }

                exibirMenu(entradas);
                break;

            case 6:
                System.out.println("Quantos produtos você deseja incluir na nota fiscal?");
                int quantidadeDeProdutos = entradas.nextInt();

                NotaFiscal nf = new NotaFiscal();
                
                for (int i = 0; i < quantidadeDeProdutos; i++) {
                    System.out.println("Digite o código do " + (i + 1) + "º produto a ser incluído na nota fiscal:");
                    int codigoDoProdutoASerIncluido = entradas.nextInt();

                    Produto produtoASerIncluido = produtos.getProduto(codigoDoProdutoASerIncluido);

                    if (produtoASerIncluido != null) {
                        System.out.println("Veja as informações deste produto:");
                        System.out.println(
                            "Código: " + produtoASerIncluido.getCodigo() +
                            " | Nome: " + produtoASerIncluido.getNome() +
                            " | Descrição: " + produtoASerIncluido.getDescricao() +
                            " | Preço: " + produtoASerIncluido.getPreco() +
                            " | Quantidade: " + produtoASerIncluido.getQuantidade()
                        );

                        System.out.println("Qual quantidade deste produto deve ser incluída na nota fiscal?");
                        int quantidadeDoProduto = entradas.nextInt();

                        Item novoItem = new Item(produtoASerIncluido, quantidadeDoProduto);
                        nf.addItem(novoItem);
                    } else {
                        System.out.println(
                            "Nenhum produto com o código " +
                            codigoDoProdutoASerIncluido + 
                            " foi encontrado :("
                        );
                    }
                }

                if (nf.getItems().size() > 0) {
                    notasFiscais.addNotaFiscal(nf);

                    System.out.println("Nota fiscal #" + nf.getCodigo() + " criada com sucesso :)");
                } else {
                    System.out.println("Não foi possível criar a nota fiscal :(");
                }

                exibirMenu(entradas);
                break;

            case 7:
                break;

            case 8:
                break;

            case 9:
                break;

            case 10:
                System.exit(0);
                break;

            default:
                System.out.print("\n");
                System.err.println("Entrada inválida :(");
                System.err.println("Por gentileza, escolha uma opção do menu digitando um número inteiro de 0 a 10");
                
                exibirMenu(entradas);
        }
    }

    private static void confirmarCadastroDeProduto(String tipoDeVenda, Produto produto) {
        System.out.print("\n");
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.print("\n");
        System.out.println("     Produto cadastrado com sucesso!     ");
        System.out.print("\n");
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.print("\n");
        
        System.out.println("Código: " + produto.getCodigo());
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Descrição: " + produto.getDescricao());
        System.out.println("Preço: " + produto.getPreco());
        System.out.println("Venda: " + tipoDeVenda);
        System.out.println("Quantidade: " + produto.getQuantidade());
    }
}
