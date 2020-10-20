package br.com.zup.estrelas.main;

import java.util.Scanner;

import br.com.zup.estrelas.dao.CarroDAO;
import br.com.zup.estrelas.pojo.Carro;
import br.com.zup.estrelas.pojo.Categoria;

public class ProgramaPrincipal {

	public static CarroDAO carroDAO = new CarroDAO();

	public static void menu() {
		System.out.println("1 - inserir carro");
		System.out.println("2 - listar carros");
		System.out.println("3 - deletar carro");
		System.out.println("4 - pesquisa por chassi");
		System.out.println("5 - pesquisa por categoria");
		System.out.println("6 - pesquisa por montadora");
		System.out.println("0 - sair");
	}

	public static void inserirCarro(Scanner sc) {
		Carro carro = new Carro();
		System.out.println("Digite o número do chassi ");
		carro.setChassi(sc.nextLine());
		System.out.println("Digite o nome do fabricante");
		carro.setFabricante(sc.nextLine());
		System.out.println("Digite o modelo do carro");
		carro.setModelo(sc.nextLine());
		System.out.println("Digite o ano de fabricação");
		carro.setAno(sc.nextInt());
		sc.nextLine();
		System.out.println("Digite a cor");
		carro.setCor(sc.nextLine());
		System.out.println("Escolha a categoria do carro");
		carro.setCategoria(whileCategoria(sc));

		carroDAO.insereCarro(carro);

	}

//	(inserir, listar, deletar e trazer um
//	carro).
	public static void listarCarros() {
		System.out.println("Todos os carros armazenados no banco de dados:");
		for (Carro carro : carroDAO.listaCarros()) {
			System.out.println(carro);
		}
	}

	public static void pesquisarVeiculo(Scanner sc) {
		System.out.println("Digite o número do chassi");
		String chassi = sc.nextLine();

		System.out.println(carroDAO.carroPesquisado(chassi));
	}

	public static void removerCarro(Scanner sc) {
		System.out.println("Digite o número do chassi do carro");
		String chassi = sc.nextLine();

		carroDAO.removeCarro(chassi);
	}

	public static void carrosPorCategoria(Scanner sc) {
		System.out.println("Escolha a categoria que deseja consultar");

		for (Carro carro : carroDAO.listaCarrosCategoria(whileCategoria(sc))) {
			System.out.println(carro);
		}
	}

	public static void carrosPorMontadora(Scanner sc) {
		System.out.println("Digite o nome da montadora");
		String fabricanteLido = sc.nextLine();
		
		for (Carro carro :carroDAO.listaCarrosMontadora(fabricanteLido)) {
			System.out.println(carro);
		}
	}
	
	public static String whileCategoria(Scanner sc) {
		String categoria = null;
		boolean opcaoCategoria = false;

		do {

			System.out.println("1 - Esportivo");
			System.out.println("2 - SUV");
			System.out.println("3 - Picape");
			System.out.println("4 - Familiar");
			int opcaoLida = sc.nextInt();

			switch (opcaoLida) {
			case 1:
				categoria = Categoria.ESPORTIVO.toString();
				opcaoCategoria = true;
				break;
			case 2:
				categoria = Categoria.SUV.toString();
				opcaoCategoria = true;
				break;
			case 3:
				categoria = Categoria.PICAPE.toString();
				opcaoCategoria = true;
				break;
			case 4:
				categoria = Categoria.FAMILIAR.toString();
				opcaoCategoria = true;
				break;

			default:
				System.out.println("Opção inválida");
				break;
			}

		} while (opcaoCategoria != true);

		return categoria;
	}

	public static void separador() {
		System.out.println("\n----------------------------------------------------------------------------------------\n");
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int opcao;

		do {
			menu();
			opcao = sc.nextInt();
			sc.nextLine();
			separador();
			switch (opcao) {
			case 1:
				inserirCarro(sc);
				separador();
				break;
			case 2:
				listarCarros();
				separador();
				break;
			case 3:
				removerCarro(sc);
				separador();
				break;
			case 4:
				pesquisarVeiculo(sc);
				separador();
				break;
			case 5:
				carrosPorCategoria(sc);
				separador();
				break;
			case 6:
				carrosPorMontadora(sc);
				separador();
				break;
			case 0:
				System.out.println("Volte sempre!");
				separador();
				break;
			default:
				System.out.println("Opção inválida!");
				separador();
				break;
			}

		} while (opcao != 0);

		sc.close();
	}

}
