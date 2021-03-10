package edu.unipampa.poo1.inventory.management;

import java.util.Scanner;
import java.util.Calendar;
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
                        boolean itemFoiAdicionado = nf.addItem(novoItem);

                        if (itemFoiAdicionado){
                            novoItem.getProduto().setQuantidade(novoItem.getProduto().getQuantidade() - quantidadeDoProduto);
                            System.out.println("Produto " + (i + 1) + " adicionado à nota fiscal :)");
                        }else {
                            System.out.println("O produto não pode ser adicionado a nota fiscal");
                        }
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
                System.out.println("Digite o código da nota fiscal a ser consultada:");
                int codigoDaNotaFiscal = entradas.nextInt();

                NotaFiscal notaFiscalEncontrada = notasFiscais.getNotaFiscal(codigoDaNotaFiscal);

                if (notaFiscalEncontrada != null) {
                    System.out.println("Veja as informações da nota fiscal:");
                    System.out.println("Código: " + notaFiscalEncontrada.getCodigo());
                    System.out.println("Data: " + notaFiscalEncontrada.getCalendar().getTime());
                    System.out.println("Itens: ");

                    List<Item> itensDaNota = notaFiscalEncontrada.getItems();

                    for (int j = 0; j < itensDaNota.size(); j++) {
                        Produto produto = itensDaNota.get(j).getProduto();
                        int quantidade = itensDaNota.get(j).getQuantidade();

                        System.out.println(
                            "Código: " + produto.getCodigo() +
                            " | Nome: " + produto.getNome() +
                            " | Descrição: " + produto.getDescricao() +
                            " | Preço: " + produto.getPreco() +
                            " | Quantidade: " + quantidade
                        );
                    }
                } else {
                    System.out.println(
                        "Nenhuma nota fiscal com o código " +
                        codigoDaNotaFiscal + 
                        " foi encontrada :("
                    );
                }

                exibirMenu(entradas);
                break;

            case 8:
                System.out.println("Digite o código da nota fiscal a ser alterada:");
                int codigoDaNotaAAlterar = entradas.nextInt();

                NotaFiscal notaFiscalAAlterar = notasFiscais.getNotaFiscal(codigoDaNotaAAlterar);
                
                if (notaFiscalAAlterar != null) {
                    System.out.println("Atualmente, essas são as informações da nota fiscal #" + codigoDaNotaAAlterar + ":");
                    System.out.print("\n");

                    System.out.println("Código: " + notaFiscalAAlterar.getCodigo());
                    System.out.println("Data: " + notaFiscalAAlterar.getCalendar().getTime());
                    System.out.println("Itens: ");

                    List<Item> itensDaNota = notaFiscalAAlterar.getItems();

                    for (int j = 0; j < itensDaNota.size(); j++) {
                        Produto produto = itensDaNota.get(j).getProduto();
                        int quantidade = itensDaNota.get(j).getQuantidade();

                        System.out.println(
                            "Código: " + produto.getCodigo() +
                            " | Nome: " + produto.getNome() +
                            " | Descrição: " + produto.getDescricao() +
                            " | Preço: " + produto.getPreco() +
                            " | Quantidade: " + quantidade
                        );
                    }
                    
                    System.out.print("\n");
                    System.out.println("O que você deseja alterar?");
                    System.out.println("    1 - Adicionar um novo item à nota fiscal");
                    System.out.println("    2 - Excluir item da nota fiscal");
                    int infoASerAlterada = entradas.nextInt();

                    switch (infoASerAlterada) {
                        case 1:
                            System.out.println("Digite o código do produto a ser incluído na nota fiscal:");
                            int codigoDoNovoProdutoDaNF = entradas.nextInt();
        
                            Produto produtoASerIncluidoNaNF = produtos.getProduto(codigoDoNovoProdutoDaNF);
        
                            if (produtoASerIncluidoNaNF != null) {
                                System.out.println("Veja as informações deste produto:");
                                System.out.println(
                                    "Código: " + produtoASerIncluidoNaNF.getCodigo() +
                                    " | Nome: " + produtoASerIncluidoNaNF.getNome() +
                                    " | Descrição: " + produtoASerIncluidoNaNF.getDescricao() +
                                    " | Preço: " + produtoASerIncluidoNaNF.getPreco() +
                                    " | Quantidade: " + produtoASerIncluidoNaNF.getQuantidade()
                                );
        
                                System.out.println("Qual quantidade deste produto deve ser incluída na nota fiscal?");
                                int quantidadeDoProduto = entradas.nextInt();
        
                                Item novoItem = new Item(produtoASerIncluidoNaNF, quantidadeDoProduto);
                                boolean itemFoiAdicionado = notaFiscalAAlterar.addItem(novoItem);
        
                                if (itemFoiAdicionado) {
                                    novoItem.getProduto().setQuantidade(novoItem.getProduto().getQuantidade() - quantidadeDoProduto);
                                    System.out.println("Produto adicionado à nota fiscal :)");
                                } else {
                                    System.out.println("O item não pode ser adicionado à nota fiscal :(");
                                }
                            } else {
                                System.out.println(
                                    "Nenhum produto com o código " +
                                    produtoASerIncluidoNaNF + 
                                    " foi encontrado :("
                                );
                            }
                            break;
                            
                        case 2:
                            System.out.println("Digite o codigo do item que você deseja excluir da Nota Fiscal");
                            int codigoProduto = entradas.nextInt();

                            List<Item> listaItens = notasFiscais.getNotaFiscal(codigoDaNotaAAlterar).getItems();

                            boolean deuCerto = false;

                            for (Item item : listaItens) {
                                if (item.getProduto().getCodigo() == codigoProduto) {
                                    deuCerto = notasFiscais.removeItem(codigoDaNotaAAlterar, item);

                                    if (deuCerto){
                                        item.getProduto().setQuantidade(item.getProduto().getQuantidade() + item.getQuantidade());
                                        
                                        System.out.println("O item foi retirado com sucesso da Nota Fiscal :)");
                                    } else{
                                        System.out.println("O item não pode ser retirado da Nota Fiscal :(");
                                    }
                                    break;
                                }
                            }
                            break;
                            
                        default:
                            System.out.print("\n");
                            System.out.println("Entrada inválida :(");

                            System.out.print("\n");
                            System.out.println("O que você deseja alterar?");
                            System.out.println("    1 - Adicionar um novo item à nota fiscal");
                            System.out.println("    2 - Excluir item da nota fiscal");
                            infoASerAlterada = entradas.nextInt();

                            break;
                    }
                } else {
                    System.out.println(
                        "Nenhuma nota fiscal com o código " +
                        codigoDaNotaAAlterar + 
                        " foi encontrada :("
                    );
                }

                exibirMenu(entradas);
                break;

            case 9:
                List<NotaFiscal> arrayNotasFiscais = notasFiscais.getNotasFiscais();
                
                System.out.println("Digite o dia:");
                int dia = entradas.nextInt();
                System.out.println("Digite o mês:");
                int mes = entradas.nextInt();
                System.out.println("Digite o ano:");
                int ano = entradas.nextInt();

                Calendar data;
                int diaData;
                int mesData;
                int anoData;
                double valorVendas = 0f;
                for (NotaFiscal notaF : arrayNotasFiscais){
                    data = notaF.getCalendar();

                    diaData = data.get(Calendar.DAY_OF_MONTH);
                    mesData = data.get(Calendar.MONTH) + 1;
                    anoData = data.get(Calendar.YEAR);
                    
                    if (dia == diaData && mes == mesData && ano == anoData){
                        List<Item> listItens = notaF.getItems();

                        for (Item item : listItens){
                            valorVendas += item.getProduto().getPreco() * item.getQuantidade();
                        }
                    }
                }
                
                System.out.printf("Na data %d/%d/%d foram vendidos R$%.2f em produtos.", dia, mes, ano, valorVendas);

                exibirMenu(entradas);
                break;

            case 10:
                System.exit(0);
                break;

            default:
                System.out.print("\n");
                System.err.println("Entrada inválida :(");
                System.err.println("Por gentileza, escolha uma opção do menu digitando um número inteiro de 1 a 10");
                
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
