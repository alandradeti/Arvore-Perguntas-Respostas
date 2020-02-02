package PerguntasRespostas;
/**
 *
 * @author Ailton Lima de Andrade
 *
 */
import javax.swing.JOptionPane;

public class Executar {
    // Instancia da classe GameHandle como variável global
    public static GameHandle jogo = new GameHandle();
    // Constante que indica que o sistema realmente deve ser finalizado
    public static int TERMINA_SISTEMA = 4;
    // Constante que indica que o sistema não deve ser finalizado
    public static int NAO_TERMINA_SISTEMA = 0;

    //Método com os nodos da arvore de altura 2
    public static void game1() {
        String[] vetor = {"O animal come carne?", //Raiz - Nivel 1
            "O animal tem listras?", "O animal tem listras?", // Nivel 2
            "É um TIGRE.", "É um LEOPARDO.", "É uma ZEBRA.", "É um CAVALO." //Folhas - Nivel 3
        };
        jogo.gamePlay(vetor);
    }

    //Método com os nodos da arvore de altura 3
    public static void game2() {
        String[] vetor = {"O anime é curto?", //Raiz - Nivel 1
            "O anime é de menos de 25 episódios?", "O anime é de mais de 100 episódios?", // Nivel 2
            "É de terror?", "É de comédia?", "É de shonen?", "É de Ficção?", // Nivel 3
            "É o Another.", "É o Goblin Slayer.", "É o Konosuba.", "É o Kimetsu.", //Folhas - Nivel 4
            "É o Naruto.", "É o Doraemon.", "É o Fullmetal Alchemist.", "É o Pokemon." //Folhas - Nivel 4
        };

        jogo.gamePlay(vetor);
    }
    
    //Método com os nodos da arvore de altura 4
    public static void game3() {
        String[] vetor = {"O filme é longo?", //Raiz - Nivel 1
            "O genêro principal é de terror?","O genêro principal é de ação?", // Nivel 2
            "O genêro secundário é de suspense?","O genêro secundário é de ação?", // Nivel 3
            "O genêro secundário é de ficção?","O genêro secundário é de Comédia?", // Nivel 3
            "Começa com a letra I?","Começa com a letra N?", // Nivel 4
            "Começa com a letra J","Começa com a letra V?", // Nivel 4
            "Começa com a letra J","Começa com a letra C?", // Nivel 4
            "Começa com a letra Z","Começa com a letra P?", // Nivel 4
            "É o It: A Coisa.", "É a Freira.", "É o Nós.", "É o Chamado.", // Folhas - Nivel 5
            "É o John Wick.", "É o Em Ritmo de Fuga.", "É o Vingadores.", "É o Alita.", // Folhas - Nivel 5
            "É o Jogador Número 1.", "É o Blade Runner.", "É o Coringa.", "É o Rambo.",  // Folhas - Nivel 5
            "É o Zombieland.", "É o Deadpool.", "É o Planeta dos Macacos.", "É o Maze Runner." // Folhas - Nivel 5
        };

        jogo.gamePlay(vetor);
    }
    
    // Apresentação do menu
    public static int menuOpcoes() {
        int opcao = 0;  // opção selecionada pelo usuário do menu de opções
        // String que monta o conteúdo para o menu de opções
        String menu = "Menu de Opções do Perguntas e Respostas Simplificado\n\n"
                + " 1 - Animais\n"
                + " 2 - Animes\n"
                + " 3 - Filmes\n"
                + " 4 - Terminar Sistema\n\n"
                + "Informe a opcao desejada:";
        // Obtém a opção selecionada do menu pelo usuário, caso sejá String apresenta uma mensagem e retorna para o menu.
        try{
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
        }catch(NumberFormatException erro){
            JOptionPane.showMessageDialog(null, "Não é permitido inserir letras, informe uma opção válida!\n" + erro,"ERRO", JOptionPane.WARNING_MESSAGE);
            menuPrincipal();
        }

        // Caso a opção selecionada não seja válida informa mensagem,  
        // apresenta menu novamente e solicita nova opção
        while (opcao < 1 || opcao > 4) {
            JOptionPane.showMessageDialog(null, "Opção inválida!","ERRO", JOptionPane.WARNING_MESSAGE);
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
        }
        
        return opcao;
    }

    // recebe a opção do menu selecionada pelo usuário
    public static void menuPrincipal() {
        int opcao;
        // Inicia opção com NAO_TERMINA_SISTEMA
        opcao = NAO_TERMINA_SISTEMA;
        // Verifica se o usuário realmente deseja terminar de executar o sistema
        while (opcao != TERMINA_SISTEMA) {

            switch (menuOpcoes()) {
                case 1:
                    game1();
                    break;
                case 2:
                    game2();
                    break;
                case 3:
                    game3();
                    break;

                // 4 - verifica se o usuário deseja realmente finalizar o sistema.
                //      Se sim, retorna a constante TERMINA_SISTEMA, caso contrário,
                //      retorna a constante NAO_TERMINA_SISTEMA. (Implementado)
                case 4:
                    opcao = verificarTerminoDoSistema();
                    break;
            }
        }
        JOptionPane.showMessageDialog(null,
                "Obrigado por utilizar o Perguntas e Respostas Simplificado!\n\n"
                + "Desenvolvedor:\n"
                + "Ailton Lima de Andrade\n");
        System.exit(0);
    }
    
    public static int verificarTerminoDoSistema(){
	  int resposta = 
			  JOptionPane.showConfirmDialog(null, "Deseja realmente finalizar o sistema?",
					  "Finalizar Sistema",
					  JOptionPane.YES_NO_OPTION);

	  // Se resposta fornecida for igual a YES
	  if (resposta == JOptionPane.YES_OPTION){
		  return TERMINA_SISTEMA;
	  } else return NAO_TERMINA_SISTEMA;
    }

    public static void main(String[] args) {
        menuPrincipal();
    }
}
