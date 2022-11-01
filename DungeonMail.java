import java.util.*; //Importações usadas: ArrayList, List, Scanner, Random
import java.io.IOException;
public class DungeonMail
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Scanner read = new Scanner(System.in);
        Random sort = new Random();
        List<String> inv = new ArrayList<>();
        
        int opcao, chance, velocidadeTexto = 70;
        boolean rodandoJogo = true, rodandoMenu = true, rodandoConfig = true, rodandoCriarJogador = true, rodandoParte1 = true, rodandoParte2 = true, rodandoParte3 = true, rodandoCompra = true, rodandoTrilha = true, rodandoDescanso = true, rodandoCombate = true;
        String resposta, velocidadeTextoConfig = "Lento";
        
        while(rodandoJogo)
        {
            rodandoMenu = true; rodandoConfig = true; rodandoCriarJogador = true; rodandoParte1 = true; rodandoParte2 = true; rodandoParte3 = true; rodandoCompra = true; rodandoTrilha = true;
            limpaTela();
        
        while(rodandoMenu)
        {
            chance = aleatorio(100);
            
            System.out.println("DUNGEON MAIL");
            System.out.println("\nMENU");
            System.out.println("\n1 - Jogar \n2 - Instruções \n3 - Créditos \n4 - Opções \n\n5 - Sair \n");
            opcao = read.nextInt();
            switch(opcao)
            {
                case 1:
                    if(chance >= 80)
                    {
                        System.out.println("\nDeseja realmente jogar? Sim ou Não?");
                        read.nextLine();
                        resposta = read.nextLine().toUpperCase();
                        while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                        {
                            System.out.println("\nVamos de novo. Sim ou Não?");
                            resposta = read.nextLine().toUpperCase();
                        }
                        if(resposta.equals("SIM") || resposta.equals("S"))
                            rodandoMenu = false;
                        else
                        {
                            System.out.println("\nParabéns! Você já desistiu antes mesmo de começar! \n\nFinal 6 de 6");
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                            resposta = read.nextLine();
                            
                            rodandoMenu = false;
                            rodandoCriarJogador = false;
                            rodandoParte1 = false;
                            rodandoParte2 = false;
                            rodandoParte3 = false;
                        }
                    }
                    else
                    {
                        read.nextLine();
                        rodandoMenu = false;
                    }
                break;
                
                case 2:
                    limpaTela();
                    System.out.println("INSTRUÇÕES");
                    System.out.println("\nIMPORTANTE");
                    System.out.println("\nEste jogo foi fortemente baseado em D&D, Dungeons and Dragons, só que de forma mais limitada e simplificada.");
                    System.out.println("\nAcentos e cedilhas não serão lidos como respostas válidas, portanto não os utilize.");
                    System.out.println("\nDICAS");
                    System.out.println("\nHá segredos espalhados pelo jogo, será que consegue descobrir todos eles?");
                    System.out.println("\nO Bônus de Força irá te auxiliar para obter mais vida, assim como o Bônus de Destreza irá ajudar o Ladino e o Mago a terem mais Armadura.");
                    System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU. \n");
                    read.nextLine();
                    resposta = read.nextLine();
                    limpaTela();
                break;
                
                case 3:
                    limpaTela();
                    System.out.println("CRÉDITOS");
                    System.out.println("\nJogo feito por Rafael Yu e João Henrique Viana.");
                    System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                    read.nextLine();
                    resposta = read.nextLine();
                    limpaTela();
                break;
                
                case 4:
                    while(rodandoConfig)
                    {
                        limpaTela();
                        System.out.println("OPÇÕES");
                        System.out.println("\nValor Padrão de Velocidade de Texto: Lento");
                        System.out.println("Valor Atual de Velocidade de Texto: "+velocidadeTextoConfig);
                        System.out.println("\n1 - Modo de Texto Lento \n2 - Modo de Texto Rápido \n3 - Modo de Texto Customizado \n\n4 - Voltar \n");
                        opcao = read.nextInt();
                    
                        while(opcao < 1 || opcao > 4)
                        {
                            System.out.println("\nApenas isso de configuração.");
                            System.out.println("\n1 - Modo de Texto Lento \n2 - Modo de Texto Rápido \n3 - Modo de Texto Customizado \n\n4 - Voltar \n");
                            opcao = read.nextInt();
                        }
                    
                        if(opcao == 1)
                            velocidadeTexto = 70;
                        else if(opcao == 2)
                        {
                            velocidadeTexto = 30;
                            velocidadeTextoConfig = "Rápido";
                        }
                        else if(opcao == 3)
                        {
                            System.out.println("\nQual velocidade deseja colocar?");
                            System.out.println("Lembrando que a unidade utilizada é em milissegundos.");
                            System.out.print("\nVelocidade do Texto: ");
                            velocidadeTexto = read.nextInt();
                        
                            velocidadeTextoConfig = "Customizada";
                        }
                        else
                        {
                            rodandoConfig = false;
                            limpaTela();
                        }
                    }
                break;
                
                case 5:
                    System.out.println("\nVocê saiu do jogo.");
                    read.nextLine();
                    resposta = read.nextLine();
                    rodandoMenu = false;
                    rodandoCriarJogador = false;
                    rodandoParte1 = false;
                    rodandoParte2 = false;
                    rodandoParte3 = false;
                    rodandoJogo = false;
                break;
                
                default:
                        System.out.println("\nCalma lá, tá cedo demais para tentar achar erros.");
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                        read.nextLine();
                        resposta = read.nextLine();
                        limpaTela();
            }
        }
        
        limpaTela();
        
        int idade = 0, str = 0, dex = 0, inte = 0, vidaMaxJogador = 0, vidaJogador = 0, ataqueJogador = 0, danoJogador = 0, indicieDanoJogador = 0, bonusDanoJogador = 0, bonusStr = 0, bonusDex = 0, bonusInte = 0, CA = 0, moedas = 0, percepcaoPassiva = 10;
        String nome = null, Nome = null, classe = null, raca = null, antecedente = null;
        boolean rodandoNome, rodandoValidarNome, validar = true;
        
        while(rodandoCriarJogador)
        {
            inv.clear();
            rodandoNome = true;
            System.out.println("CRIAÇÃO DE PERSONAGEM");
            
            //Nome do personagem
            do{
                rodandoValidarNome = true;
                validar = true;
                
                System.out.println("\nQual será o nome de seu personagem?");
                nome = read.nextLine().toLowerCase();
                for(int i = 0; i < nome.length(); i++)
                {
                    if(Character.isDigit(nome.charAt(i)))
                        validar = false;
                }
                if(nome.length() <= 2 || validar == false)
                {
                    while(rodandoValidarNome)
                    {
                        if(nome.length() <= 2)
                            System.out.println("\nNome curto demais.");
                        else
                            System.out.println("\nNome inadequado.");
                        
                        System.out.println("\nTem certeza que quer esse nome? Sim ou Não?");        
                        resposta = read.nextLine().toUpperCase();
                        while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                        {
                            System.out.println("\nVamos de novo. Sim ou Não?");
                            resposta = read.nextLine().toUpperCase();
                        }
                        if(resposta.equals("SIM") || resposta.equals("S"))
                        {
                            rodandoNome = false;
                            rodandoValidarNome = false;
                        }
                        else
                            rodandoValidarNome = false;
                    }
                }
                else
                {
                    rodandoNome = false;
                    rodandoValidarNome = false;
                }
            }while(rodandoNome);
            
            //Idade do personagem
            System.out.println("\nQual será a idade de seu personagem?");
            idade = read.nextInt();
            while(idade < 15 || idade >= 60)
            {
                if(idade < 0)
                    System.out.println("\nSeu personagem tem idade negativa.");
                else if(idade >= 0 && idade < 15)
                    System.out.println("\nSeu personagem é novo demais para uma aventura.");
                else
                    System.out.println("\nSeu personagem é muito velho para uma aventura.");
                
                System.out.println("\nQual será a idade de seu personagem?");
                idade = read.nextInt();
            }
            
            //Distribuição de atributos
            System.out.println("\nEstá na hora de distribuir pontos nos seus 3 atributos, que consistem em: \n\n\tFORÇA      DESTREZA      INTELIGÊNCIA");
            System.out.println("\nA soma dos valores destes atributos precisam dar 10! \n");
            System.out.print("Força: ");
            str = read.nextInt();
            System.out.print("Destreza: ");
            dex = read.nextInt();
            System.out.print("Inteligência: ");
            inte = read.nextInt();
            while(str <= 0 || dex <= 0 || inte <= 0)
            {
                System.out.println("\nNão será aceito números negativos e nulos em prol de obter vantagem. \n");
                System.out.print("Força: ");
                str = read.nextInt();
                System.out.print("Destreza: ");
                dex = read.nextInt();
                System.out.print("Inteligência: ");
                inte = read.nextInt();
            }
            while(str+dex+inte < 10 || str+dex+inte > 10)
            {
                System.out.println("\nTudo bem, erros de cálculo acontecem. Preencha novamente. \n");
                System.out.print("Força: ");
                str = read.nextInt();
                System.out.print("Destreza: ");
                dex = read.nextInt();
                System.out.print("Inteligência: ");
                inte = read.nextInt();
            }
            
            //Classe do personagem
            System.out.println("\nQual será a classe de seu personagem?");
            System.out.println("\n1 - Guerreiro [+2 Força | +1 Destreza] \n2 - Ladino [+2 Destreza | +1 Inteligência] \n3 - Mago [+3 Inteligência] \n");
            opcao = read.nextInt();
            
            while(opcao < 1 || opcao > 3)
            {
                System.out.println("\nSim, só essas 3 classes básicas.");
                System.out.println("\n1 - Guerreiro [+2 Força | +1 Destreza] \n2 - Ladino [+2 Destreza | +1 Inteligência] \n3 - Mago [+3 Inteligência] \n");
                opcao = read.nextInt();
            }
            
            switch(opcao)
            {
                case 1: classe = "Guerreiro"; break;
                case 2: classe = "Ladino"; break;
                default: classe = "Mago";     
            }
            switch(classe)
            {
                case "Guerreiro":
                    str += 2;
                    dex++;
                    indicieDanoJogador = 8;
                    inv.add("Espada Longa"); inv.add("Escudo"); inv.add("Cota de Malha"); inv.add("Poção de Cura");
                    CA = 18;
                    moedas = (aleatorio(4)+aleatorio(4)+aleatorio(4)+aleatorio(4)+aleatorio(4))*10;
                break;
                
                case "Ladino":
                    dex += 2;
                    inte++;
                    indicieDanoJogador = 10;
                    inv.add("Rapieira"); inv.add("Ferramentas de Ladrão"); inv.add("Armadura de Couro"); inv.add("Poção de Cura");
                    CA = 11;
                    moedas = (aleatorio(4)+aleatorio(4)+aleatorio(4)+aleatorio(4))*10;
                break;
                
                default:
                    inte += 3;
                    indicieDanoJogador = 6;
                    inv.add("Cajado"); inv.add("Grimório"); inv.add("Poção de Cura");
                    CA = 10;
                    moedas = (aleatorio(4)+aleatorio(4)+aleatorio(4)+aleatorio(4))*10;
            }
            
            //Raça do personagem
            System.out.println("\nQual será a raça de seu personagem?");
            System.out.println("\n1 - Humano [+1 Inteligência] \n2 - Elfo [+1 Destreza] \n3 - Anão [+1 Força] \n");
            opcao = read.nextInt();
            
            while(opcao < 1 || opcao > 3)
            {
                System.out.println("\nInfelizmente só há essas 3 opções.");
                System.out.println("\n1 - Humano [+1 Inteligência] \n2 - Elfo [+1 Destreza] \n3 - Anão [+1 Força] \n");    
                opcao = read.nextInt();
            }
            
            switch(opcao)
            {
                case 1: raca = "Humano"; break;
                case 2: raca = "Elfo"; break;
                default: raca = "Anão";
            }
            switch(raca)
            {
                case "Humano": inte++; break;
                case "Elfo": dex++; break;
                default: str++;
            }
            
            //Antecedente do personagem
            System.out.println("\nQual será o antecedente de seu personagem?");
            System.out.println("\n1 - Cidadão [+2 Inteligência] \n2 - Viajante [+2 Destreza] \n3 - Mercenário [+2 Força] \n4 - Nobre [+250 de Ouro no começo] \n");
            opcao = read.nextInt();
            
            while(opcao < 1 || opcao > 4)
            {
                System.out.println("\nPor enquanto só há essas opções.");
                System.out.println("\n1 - Cidadão [+2 Inteligência] \n2 - Viajante [+2 Destreza] \n3 - Mercenário [+2 Força] \n4 - Nobre [+250 de Ouro no começo] \n");
                opcao = read.nextInt();
            }
            
            switch(opcao)
            {
                case 1: antecedente = "Cidadão"; break;
                case 2: antecedente = "Viajante"; break;
                case 3: antecedente = "Mercenário"; break;
                default: antecedente = "Nobre";
            }
            switch(antecedente)
            {
                case "Cidadão": inte += 2; break;
                case "Viajante": dex += 2; break;
                case "Mercenário": str += 2; break;
                default: moedas += 250;
            }
            
            bonusStr = str/2; bonusDex = dex/2; bonusInte = inte/2; percepcaoPassiva += bonusInte;
            
            //Opção de vida fixa
            System.out.println("\nDeseja pegar vida fixa? Sim ou Não?");
            read.nextLine();
            resposta = read.nextLine().toUpperCase();
            
            while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
            {
                System.out.println("\nSim ou Não? \n");
                resposta = read.nextLine().toUpperCase();
            }
            
            if(resposta.equals("SIM") || resposta.equals("S"))
            {
                switch(classe)
                {
                    case "Guerreiro": vidaMaxJogador = (10+bonusStr)+(6+bonusStr)+(6+bonusStr); break;
                    case "Ladino": vidaMaxJogador = (8+bonusStr)+(5+bonusStr)+(5+bonusStr); break;
                    default: vidaMaxJogador = (6+bonusStr)+(4+bonusStr)+(4+bonusStr);
                }
            }
            else
            {
                switch(classe)
                {
                    case "Guerreiro": vidaMaxJogador = (10+bonusStr)+(aleatorio(10)+bonusStr)+(aleatorio(10)+bonusStr); break;
                    case "Ladino": vidaMaxJogador = (8+bonusStr)+(aleatorio(8)+bonusStr)+(aleatorio(8)+bonusStr); break;
                    default: vidaMaxJogador = (6+bonusStr)+(aleatorio(6)+bonusStr)+(aleatorio(6)+bonusStr);
                }
            }
            
            vidaJogador = vidaMaxJogador;
            
            //CA das classes adicionando a destreza, exceto o guerreiro
            if(!classe.equals("Guerreiro"))
                CA += bonusDex;
            
            //Ataque e dano das classes
            if(classe.equals("Guerreiro"))
            {
                ataqueJogador += bonusStr;
                bonusDanoJogador = bonusStr;
            }
            else if(classe.equals("Ladino"))
            {
                ataqueJogador += bonusDex;
                bonusDanoJogador = bonusDex;
            }
            else
            {
                ataqueJogador += bonusInte;
                bonusDanoJogador = bonusInte;
            }
            
            //Nomes com a primeira letra maiúscula
            String nomeSeparado[] = nome.split(" ");
            
            char letraMaiuscula[];
            
            for (int i = 0; i < nomeSeparado.length; i++)
            {
                letraMaiuscula = nomeSeparado[i].toCharArray();
                letraMaiuscula[0] = Character.toUpperCase(letraMaiuscula[0]);
                Nome = new String(letraMaiuscula);
                nomeSeparado[i] = Nome;
            }
            
            limpaTela();
            
            //Ficha do personagem
            ficha(inv, nomeSeparado, idade, classe, raca, antecedente, vidaMaxJogador, CA, str, bonusStr, dex, bonusDex, inte, bonusInte, moedas);
            System.out.println("\nDeseja continuar com esse personagem? Sim ou Não?");
            resposta = read.nextLine().toUpperCase();
            
            while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
            {
                System.out.println("\nConfirme novamente. Sim ou Não?");
                resposta = read.nextLine().toUpperCase();
            }
            
            if(resposta.equals("SIM") || resposta.equals("S"))
            {
                rodandoCriarJogador = false;
                limpaTela();
            }
            else
            {
                limpaTela();
                
                switch(classe)
                {
                    case "Guerreiro": inv.remove("Espada Longa"); inv.remove("Escudo"); inv.remove("Poção de Cura"); break;
                    case "Ladino": inv.remove("Rapieira"); inv.remove("Ferramentas de Ladrão"); inv.remove("Poção de Cura"); break;
                    default: inv.remove("Cajado"); inv.remove("Grimório"); inv.remove("Poção de Cura");
                }
            }
        }
        
        int dado;
        String texto;
        
        while(rodandoParte1)
        {
            String nomeSeparado[] = nome.split(" ");
            
            char letraMaiuscula[];
            
            for (int i = 0; i < nomeSeparado.length; i++)
            {
                letraMaiuscula = nomeSeparado[i].toCharArray();
                letraMaiuscula[0] = Character.toUpperCase(letraMaiuscula[0]);
                Nome = new String(letraMaiuscula);
                nomeSeparado[i] = Nome;
            }
            
            Nome = nomeSeparado[0];
            
            System.out.println("PARTE 1 \n");
                texto = "Manhã. Taverna do Dragão Prateado. \n\n"
                        + "Você, aventureiro, se encontra nesta taverna tomando seu café da manhã após chegar de viagem na cidade de Queda de Ferro. \n"
                        + "Seu objetivo é desconhecido.";
                typeWriter(texto, velocidadeTexto);
                    
                System.out.println("\n\nO que deseja fazer?");
                System.out.println("\n1 - Terminar refeição \n2 - Buscar informação \n");
                opcao = read.nextInt();
                
                while(opcao < 1 || opcao > 2)
                {
                    System.out.println("\nÉ, as opções não são muitas.");
                    System.out.println("\nO que deseja fazer?");
                    System.out.println("\n1 - Terminar refeição \n2 - Buscar informação \n");
                    opcao = read.nextInt();
                }
                
                switch(opcao)
                {
                    case 1:
                        System.out.println("\nVocê termina sua refeição e nada mudou.");
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                        read.nextLine();
                        resposta = read.nextLine();        
                        
                        texto = "\nApós terminar sua refeição, você é abordado pelo próprio tarveneiro que cuida deste lugar. \n"
                                + "'Bom dia, estava bom o prato que pediu?'";
                        typeWriter(texto, velocidadeTexto);
                                    
                        System.out.println("\n\n1 - Bom \n2 - Satisfatório \n3 - [Droga, a comida estava tão boa que não dá para falar mal] \n4 - Qual seu nome? \n");
                        opcao = read.nextInt();
                        
                        while(opcao < 1 || opcao > 4)
                        {
                                System.out.println("\nOpção inválida.");
                                System.out.println("\n1 - Bom \n2 - Satisfatório \n3 - [Droga, a comida estava tão boa que não dá para falar mal] \n4 - Qual seu nome? \n");
                                opcao = read.nextInt();
                        }
                        
                        switch(opcao)
                        {
                            case 1:
                                texto = "\n'Que bom. Mas que tal um trabalho para um aventureiro como você?' \n"
                                        + "O tarveneiro puxa uma carta e te dá em mãos. \n";
                                typeWriter(texto, velocidadeTexto);
                                    
                                System.out.println("\nVocê obteve Carta.");
                                inv.add("Carta");
                            break;
                                
                            case 2:
                                texto = "\n'Só satisfeito? Creio que contentará-se com isso daqui.' \n"
                                        + "Uma carta é puxada de dentro do uniforme de barman e ele lhe entrega.";
                                typeWriter(texto, velocidadeTexto);
                                    
                                System.out.println("\n\nVocê obteve Carta.");
                                inv.add("Carta");
                            break;
                                
                            case 3:
                                texto = "\nEle percebe seu silêncio e prossegue com o que precisa dizer. \n"
                                        + "'Acho que isso é um sim pois não tem como a nossa comida de casa ser ruim.' \n\n"
                                        + "Com isso, você acha que é a hora de pagar pelo café da manhã e já pega algumas moedas de sua algibeira. \n"
                                        + "'Você já pagou... mas eu tenho um ótimo serviço de aventureiro pra ti.' \n\n"
                                        + "É um tanto surpreendente, mas era esperado num ambiente inicial clichê como esse para os mais habituados. \n"
                                        + "Ele pega uma carta e entrega a você.";
                                typeWriter(texto, velocidadeTexto);
                                    
                                System.out.println("\n\nVocê obteve Carta.");
                                inv.add("Carta");
                            break;
                                
                            default:
                                texto = "\n'Meu nome é Louis, mas isso é o de menos. Tenho um serviço para você, aventureiro.' \n"
                                        + "Parece que esse tarveneiro é experiente quando o assunto são aventureiros. \n\n"
                                        + "Ele te passa uma carta.";
                                typeWriter(texto, velocidadeTexto);
                                     
                                System.out.println("\n\nVocê obteve Carta.");
                                inv.add("Carta");
                        }
                            
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                        read.nextLine();
                        resposta = read.nextLine();
                            
                        texto = "\nVisualmente, esta carta possui um selo tão ornamentado que parece até mágico. \n"
                                + "O tarveneiro sai de perto da sua mesa e volta ao serviço na movimentada taverna. \n\n"
                                + "Estando sozinho, você abre o pergaminho retirando o laço verde. \n"
                                + "E você se depara com essa mensagem: \n";
                        typeWriter(texto, velocidadeTexto);
                        carta();
                            
                        System.out.println("Pressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 2.");
                        resposta = read.nextLine();
                            
                        rodandoParte1 = false;
                    break;
                        
                    default:
                        System.out.println("\nCom quem você deseja buscar informação?");
                        System.out.println("\n1 - Tarveneiro \n2 - Cliente \n3 - Garçonete \n");
                        opcao = read.nextInt();
                        
                        while(opcao < 1 || opcao > 3)
                        {
                            System.out.println("\nOpção inválida.");
                            System.out.println("\nCom quem você deseja buscar informação?");
                            System.out.println("\n1 - Tarveneiro \n2 - Cliente \n3 - Garçonete \n");
                            opcao = read.nextInt();
                        }
                        
                        switch(opcao)
                        {
                            case 1:
                                texto = "\nVocê se aproxima do balcão do tarveneiro e ele está passando pano nos copos. \n"
                                        + "'Você ainda não terminou seu café da manhã.' \n\n"
                                        + "Sendo a primeira coisa que ele nota em você, mas não é algo preocupante. \n"
                                        + "Você pede por informação pra ele. \n\n"
                                        + "Enquanto continua limpando os copos, ele te responde. \n"
                                        + "'Hmm, tenho exatamente o que você precisa.' \n\n"
                                        + "Terminando de limpar todos os copos, ele pega uma carta numa gaveta e te passa. \n"
                                        + "'Pegue. Esta carta trará bastante informação.'";
                                typeWriter(texto, velocidadeTexto);
                                    
                                System.out.println("\n\nVocê obteve Carta.");
                                inv.add("Carta");
                                
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                read.nextLine();
                                resposta = read.nextLine();
                                
                                texto = "\nLogo em seguida, você já começa abrindo a carta. \n"
                                        + "Mas o tarveneiro exclama para não fazer isso. \n"
                                        + "'Não é para abrir!' \n\n"
                                        + "Ele indica para ler o pergaminho, que acompanha a carta, primeiro. \n"
                                        + "E o conteúdo do recado se encontra assim: \n";
                                typeWriter(texto, velocidadeTexto);
                                carta();
                                
                                System.out.println("Pressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 2.");
                                resposta = read.nextLine();
                            
                                rodandoParte1 = false;
                            break;
                                
                            case 2:
                                dado = aleatorio(2);
                                chance = aleatorio(100);
                                    
                                if(dado == 1 && chance < 90)
                                {
                                    texto = "\nVocê vai até a mesa de um aventureiro que nem você. \n\n"
                                            + "As marcas de garras pela armadura metálica caracterizam um guerreiro, deve ter lutado com alguma besta. \n"
                                            + "Ele está tomando um calmante e você dispõe-se ocupando a cadeira que fica de frente para ele. \n\n"
                                            + "'Pois não?'";
                                    typeWriter(texto, velocidadeTexto);
                                       
                                    System.out.println("\n\n1 - Tem alguma informação? \n2 - Quer se juntar a mim? \n3 - Conte-me sobre você \n");
                                    opcao = read.nextInt();
                                    
                                    while(opcao < 1 || opcao > 3)
                                    {
                                            System.out.println("\nSem diálogos secretos.");
                                            System.out.println("\n1 - Tem alguma informação? \n2 - Quer se juntar a mim? \n3 - Conte-me sobre você \n");
                                            opcao = read.nextInt();
                                    }
                                      
                                    switch(opcao)
                                    {
                                        case 1:
                                            texto = "\n'Que tipo de informação?' \n"
                                                    + "Você informa apropriadamente. \n\n"
                                                    + "'Só de trabalho após o Eclipse, você vai achar vários contratos de extermínio de monstros. \n"
                                                    + "Você pergunta de forma aprofundada sobre algum trabalho que enquadre com seu caso. \n\n"
                                                    + "'Cara, ainda tem algumas criaturas das trevas que rondam o Norte, mesmo após a queda dos Ambrosia.' \n"
                                                    + "Institivamente, você levanta da mesa pois achou seu objetivo. \n\n"
                                                    + "Você agradece pela cooperação, já o guerreiro continua tomando seu café da manhã.";
                                            typeWriter(texto, velocidadeTexto);
                                        break;
                                            
                                        case 2:
                                            texto = "\n'Prefiro fazer tudo sozinho, nada vai me convencer do contrário.' \n"
                                                    + "De qualquer modo, você nem ao menos tem algum objetivo em mente para sair convidando as pessoas pra uma aventura. \n\n"
                                                    + "Portanto, você pergunta sobre trabalhos que possam ser feitos sem companhia. \n"
                                                    + "'Seguindo a estrada que leva ao Norte, encontrará aldeões que pagam uma boa grana por eliminar os mortos-vivos.' \n\n"
                                                    + "Conseguindo o que queria, você agradece o guerreiro e despede-se dele.";
                                            typeWriter(texto, velocidadeTexto);
                                        break;
                                            
                                        default:
                                            texto = "\nO exaurido guerreiro do rosto marcado toma mais um gole e começa a falar mais sobre si. \n"
                                                    + "'Vim de Feist e venho sendo treinado para me tornar um Caçador...' \n\n"
                                                    + "Ele nota que esqueceu das apresentações e logo faz. \n"
                                                    + "'Ah, e prazer te conhecer. Meu nome é Johann.' \n"
                                                    + "'Qual o seu nome?' \n\n"
                                                    + "Você responde devidamente. \n"
                                                    + "'"+Nome+ "... vou guardar esse nome.' \n\n"
                                                    + "Johann olha pro relógio da taverna e demonstra estar atrasado, logo termina com sua bebida e se preparar pra sair. \n"
                                                    + "'Perdão, mas tenho que partir. Se queria alguma informação relevante, tente procurar pela estrada que leva ao Norte.' \n"
                                                    + "Certamente ele conseguiu sentir que sua intenção foi de obter algum objetivo. \n\n"
                                                    + "Você faz uma última pergunta pra saber para onde ele estará indo. \n"
                                                    + "'Estou indo ao Velho Mundo, faz parte do treinamento.' \n\n"
                                                    + "Com isso, você agora está sozinho. \n"
                                                    + "Mas você nota algo sobre a mesa, um punhado de moedas deixado para você.";
                                            typeWriter(texto, velocidadeTexto);
                                                
                                            System.out.println("\n\nVocê obteve 50 moedas.");
                                            moedas += 50;
                                    }
                                }
                                else if(dado == 2 && chance < 90)
                                {
                                    texto = "\nVocê vai até a mesa de um grupo de aventureiros. \n\n"
                                            + "Chegando, com ou sem ansiedade, o café da manhã do grupo é interrompido por você. \n"
                                            + "Você observa a composição da equipe de 4 membros, e são, respectativamente, um paladino, um monge, uma maga e uma druida. \n\n"
                                            + "De tanto tempo calado encarando pra eles, você sente na necessidade de interagir.";
                                    typeWriter(texto, velocidadeTexto);
                                        
                                    System.out.println("\n\n1 - Pedir informação \n2 - Pedir para participar do grupo \n");
                                    opcao = read.nextInt();
                                    
                                    while(opcao < 1 || opcao > 2)
                                    {
                                            System.out.println("\nAparentemente, seu personagem não é muito sociável para só ter 2 opções.");
                                            System.out.println("\n1 - Pedir informação \n2 - Pedir para participar do grupo \n");
                                            opcao = read.nextInt();
                                    }  
                                        
                                    switch(opcao)
                                    {
                                        case 1:
                                            texto = "\nDispostos a ajudar, o paladino, aparentemente líder da equipe, repassa o que sabem. \n"
                                                    + "'Muitos mortos-vivos ainda estão a solta por conta do foragido necromante, ex-servo do arruinado Lorde Ambrosia.' \n"
                                                    + "'Sabe-se que ele deve estar escondido em algum lugar do subterrâneo.' \n\n"
                                                    + "Havendo essa pequena pausa, você anda percebendo o leve desconforto gerado por sua chegada. \n"
                                                    + "Mas que está sendo camuflada com a simpatia do porta-voz do grupo.\n\n"
                                                    + "'E NÓS iremos achá-lo...'\n"
                                                    + "'Portanto, isso é um trabalho de um grupo que nem a gente.' \n\n"
                                                    + "Com isso, já bastou para você. Somente agradecendo por terem ao menos falado contigo. \n"
                                                    + "Provavelmente aquele grupo não está interessado num novo membro, e muito menos concorrentes. \n";
                                            typeWriter(texto, velocidadeTexto);
                                        break;
                                                
                                        default:
                                            texto = "\nTodos do grupo entram no consenso de te rejeitarem de forma inconsciente. \n"
                                                    + "Porém, o paladino começa com sua explicação para abafar essa sensação. \n\n"
                                                    + "'Éééé... sinto muito por isso, mas nem te conhecemos direito.' \n"
                                                    + "'Claro que ajuda é sempre bem-vinda, mas não estamos aceitando novos membros no momento.' \n\n"
                                                    + "Chateado, revoltado, ou seja lá o que esteja sentindo com isso, você dá as costas para sair dali. \n"
                                                    + "Mas antes, o senso de bondade de um paladino fala mais alto. \n\n"
                                                    + "'Espere. Talvez a missão de encontrar um necromante fugitivo lhe interesse.' \n"
                                                    + "Você volta a eles, mas agora sem interesse em participar do grupo, somente querendo a informação. \n\n"
                                                    + "'Dizem que ele está rondando a estrada que leva ao Norte e...' \n"
                                                    + "Antes que ele pudesse terminar de falar, você bate a porta da taverna partindo em busca desse objetivo. \n";
                                            typeWriter(texto, velocidadeTexto);  
                                    }
                                }
                                else
                                {
                                    texto = "\nVocê confere os clientes presentes e decide abordar um isolado encapuzado. \n\n"
                                            + "Nada está servido na mesa dele e tudo parece tão tenso ao aproximar-se. \n"
                                            + "Você fita ele de cima a baixo mas nenhum suave movimento de cabeça como reação, parecendo te ignorar. \n\n"
                                            + "Antes de você dar as costas, um sibilante sussurro incompreensível lhe chama de volta. \n"
                                            + "O rosto dele está emparelhado com o seu, porém, você apenas enxerga a si mesmo. \n"
                                            + "Sendo, então, uma máscara de espelho. \n\n"
                                            + "Este misterioso ente apenas dá um aceno de cabeça para você ir em direção ao balcão. \n"
                                            + "A expressão do tarveneiro é neutra, como se estivesse acostumado com esse tipo de bizarrice. \n\n"
                                            + "Você vai até o balcão, seguindo a sugestão daquele enigmático estranho.";
                                    typeWriter(texto, velocidadeTexto);
                                     
                                    System.out.println("\n\n1 - Tem alguma coisa para mim? \n2 - Quem é ele? \n");
                                    opcao = read.nextInt();
                                    
                                    while(opcao < 1 || opcao > 2)
                                    {
                                        System.out.println("\nSim, coloquei while em todas as vezes para validar opções.");
                                        System.out.println("\n1 - Tem alguma coisa para mim? \n2 - Quem é ele? \n");
                                        opcao = read.nextInt();
                                    }
                                      
                                    switch(opcao)
                                    {
                                        case 1:
                                            texto = "\n'Tenho.' \n"
                                                    + "Ele puxa uma gaveta e lhe entrega uma carta. \n\n"
                                                    + "'Não quero falar muito agora, aquele cara ali está nos encarando.' \n"
                                                    + "Você olha para trás e vê o rosto espelhado refletindo para onde mostra, e nem ligando se está sendo esquisito. \n\n"
                                                    + "Entendendo a situação, você apenas sai com a carta.";
                                            typeWriter(texto, velocidadeTexto);
                                                
                                            System.out.println("\n\nVocê obteve Carta.");
                                            inv.add("Carta");
                                                
                                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                            read.nextLine();
                                            resposta = read.nextLine();
                                        break;
                                            
                                        default:
                                            texto = "\n'Não tenho ideia.' \n"
                                                    + "'Nunca vi ele na cidade, deve ser um viajante como você.' \n\n"
                                                    + "Você indaga o jeito estranho e egocêntrico do cara de espelho. \n"
                                                    + "'Seja lá o que ou quem ele seja, ele parece saber bastante...' \n\n"
                                                    + "O tarveneiro puxa uma gaveta e traz consigo uma carta, que é dada a você. \n"
                                                    + "'Tome. Essa carta já não está mais segura nessa taverna.' \n\n"
                                                    + "Então, você sai da taverna com a carta.";
                                            typeWriter(texto, velocidadeTexto);
                                               
                                            System.out.println("\n\nVocê obteve Carta.");
                                            inv.add("Carta");
                                                
                                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                            read.nextLine();
                                            resposta = read.nextLine();
                                    }
                                }
                                    
                                if(inv.contains("Carta"))
                                {
                                    texto = "\nA carta traz junto um papel enrolado num laço verde. \n"
                                            + "Você retira o laço e o pergaminho se trata de uma mensagem: \n";
                                    typeWriter(texto, velocidadeTexto);
                                    carta();
                                        
                                    System.out.println("Pressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 2.");
                                    resposta = read.nextLine();
                                        
                                    rodandoParte1 = false;
                                }
                                else
                                {
                                    System.out.println("\nPressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 2.");
                                    read.nextLine();
                                    resposta = read.nextLine();
                                        
                                    rodandoParte1 = false;
                                }
                            break;
                                
                            default:
                                texto = "\nVocê levanta a mão para a garçonete ir na sua mesa. \n"
                                        + "Inicialmente, você já tinha a pergunta na ponta da sua língua. \n"
                                        + "Mas a beleza estonteante da moça causa um branco em você.";
                                typeWriter(texto, velocidadeTexto);
                                
                                System.out.println("\n\nO que deseja fazer?");
                                System.out.println("\n1 - Tentar lembrar \n2 - Puxar conversa \n");
                                opcao = read.nextInt();
                                
                                while(opcao < 1 || opcao > 2)
                                {
                                    System.out.println("\nRelaxa, você consegue.");
                                    System.out.println("\n1 - Tentar lembrar \n2 - Puxar conversa \n");
                                    opcao = read.nextInt();
                                }
                                
                                switch(opcao)
                                {
                                    case 1:
                                        dado = aleatorio(20)+bonusInte;
                                        
                                        if(dado >= 12)
                                            texto = "\nVocê consegue lembrar com sucesso. \n\n"
                                                    + "Recompondo-se, você pergunta sobre as novidades naturalmente. \n"
                                                    + "Ela está se mostrando uma ótima ouvinte e então começa a dizer. \n\n"
                                                    + "'Não há muito tempo atrás, um lorde vampiro morreu.' \n"
                                                    + "'Logo, seus servos estão espalhados por aí nessa região.' \n\n"
                                                    + "Mesmo conseguindo ter agido de forma explêndida, você não consegue desviar o olhar. \n"
                                                    + "Parecendo até que ela saiu de um conto de fadas. \n"
                                                    + "'... siga a estrada que leva ao Norte.' \n\n"
                                                    + "Você ficou perdido nas suas observações e escutou apenas essa última parte. \n"
                                                    + "Como seria demais pedir para repetir, você acena que entendeu como se não tivesse dúvida. \n\n"
                                                    + "'Tenho que ir, boa sorte na aventura!' \n"
                                                    + "A moça despede-se para continuar seu trabalho. \n\n"
                                                    + "Enquanto isso, você se sente mais inspirado e motivado.";
                                        else
                                            texto = "\nVocê não consegue lembrar. \n\n"
                                                    + "Um silêncio constrangedor invade a pequena interação entre vocês. \n"
                                                    + "Mas não obstante, ela toma a iniciativa. \n"
                                                    + "'Vai querer mais alguma coisa?' \n\n"
                                                    + "Você vê a oportunidade para pedir por informações. \n"
                                                    + "E inesperadamente, a jovem consegue lhe dizer as notícias mais frescas. \n\n"
                                                    + "'Você pode procurar por trabalho indo para Feist, no Norte.' \n"
                                                    + "'Muitos mortos-vivos continuam na espreita e estão começando a migrar para cá.' \n\n"
                                                    + "Você já cria interesse e anota isso para mais tarde. \n"
                                                    + "Visto isso, ela volta ao serviço e você termina sua refeição.";
                                        
                                        typeWriter(texto, velocidadeTexto);
                                        
                                        System.out.println("\n\nPressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 2.");
                                        read.nextLine();
                                        resposta = read.nextLine();
                                        
                                        rodandoParte1 = false;
                                    break;
                                    
                                    default:
                                        texto = "\nVocê inicia uma conversa. \n\n"
                                                + "Por onde começa?";
                                        typeWriter(texto, velocidadeTexto);
                                        
                                        System.out.println("\n\n1 - Qual o seu nome? \n2 - Quantos anos você tem? \n");
                                        opcao = read.nextInt();
                                        
                                        while(opcao < 1 || opcao > 2)
                                        {
                                            System.out.println("\nSim, só essas 2 perguntas.");
                                            System.out.println("\n1 - Qual o seu nome? \n2 - Quantos anos você tem? \n");
                                            opcao = read.nextInt();
                                        }
                                        
                                        switch(opcao)
                                        {
                                            case 1:
                                                texto = "\n'Ah, eu me chamo Nina.' \n"
                                                        + "'Qual o seu nome?' \n\n"
                                                        + "Você responde. \n"
                                                        + "'"+Nome+".' \n\n"
                                                        + "Você acha que ela tenha repetido seu nome para fixar ele na memória. \n"
                                                        + "'Então, "+Nome+", você veio de onde?' \n\n"
                                                        + "Parando para pensar, nem você lembra direito de seu passado. \n"
                                                        + "É difícil de definir o que exatamente você fazia, mas você lembra de sua antiga profissão.";
                                                typeWriter(texto, velocidadeTexto);
                                                
                                                System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                                                read.nextLine();
                                                resposta = read.nextLine();
                                                
                                                dado = aleatorio(20)+bonusInte;
                                                
                                                if(antecedente.equals("Cidadão"))
                                                {
                                                    texto = "\nVocê conta que era apenas um cidadão de bem. \n\n"
                                                            + "Isso intriga Nina, que pergunta. \n"
                                                            + "'E o que levou a você se aventurar?' \n\n"
                                                            + "Continuando, seu passado é ofuscado, o que gera uma resposta inconclusiva. \n"
                                                            + "Mas você dá uma razão mais palpável. \n\n"
                                                            + "'Dinheiro? Não é todo mundo que vai pegar numa espada e partir caçando monstros.' \n"
                                                            + "'Deve ter alguma coisa que você não esteja lembrando.' \n\n"
                                                            + "Você tenta lembrar.";
                                                    typeWriter(texto, velocidadeTexto);
                                                    
                                                    if(dado >= 15)
                                                    {
                                                        texto = "\n\nVocê se mostrou ter um talento especial ao ter defendido sua aldeia de um ataque de monstros. \n"
                                                                + "Que te levou numa sequência incansável de pequenas aventuras. \n\n"
                                                                + "Ela se mostra interessada nessa história incrível de um simples ex-assalariado. \n"
                                                                + "Porém, o chefe dela chama atenção por ter feito essa pausa no serviço. \n"
                                                                + "'Ih, depois a gente se fala.' \n\n"
                                                                + "Já o tarveneiro, ele fala com você. \n"
                                                                + "'Se quer uma aventura, vá ao Norte. Feist está precisando de uma forcinha.' \n"
                                                                + "Você aceita a sugestão dele, apesar de ter outro objetivo em mente após ter conversado com Nina.";
                                                    }
                                                    else
                                                    {
                                                        texto = "\n\nVocê não se lembra de nada praticamente. \n"
                                                                + "Mas não é de todo ruim, Nina continua a conversa. \n"
                                                                + "'E agora pretende fazer o quê?' \n\n"
                                                                + "Finalmente chegando nesse assunto, você lembra que veio aqui sem ter um objetivo. \n"
                                                                + "Mas antes que pudesse perguntar por informações, ela é advertida. \n\n"
                                                                + "O tarveneiro a despacha para que ela volte ao trabalho, e ele diz para você. \n"
                                                                + "'Era para aventureiros, como você, estarem buscando por aventuras, e não isso. \n\n"
                                                                + "Continuando, o tarveneiro lhe passa informações vitais. \n"
                                                                + "'Só seguir ao Norte, para Feist, presumo que saiba onde seja. \n\n"
                                                                + "Você gosta da ideia e então começa indo para lá.";
                                                    }
                                                    typeWriter(texto, velocidadeTexto);
                                                }  
                                                else if(antecedente.equals("Viajante"))
                                                {
                                                    texto = "\nVocê conta que era um viajante. \n\n"
                                                            + "Isso gera curiosidade em Nina, que pergunta. \n"
                                                            + "'Então já deve ter viajado bastante, lembra de algum lugar interessante? \n\n'"
                                                            + "Você fala que já encontrou com algumas cerejeiras. \n"
                                                            + "'Cerejeiras!? Eu gostaria de ver uma!' \n\n"
                                                            + "Você claramente consegue enxergar a expressão de uma criança curiosa em Nina. \n"
                                                            + "'Onde mais ou menos era esse lugar?' \n\n"
                                                            + "Você não tem a mínima ideia. \n"
                                                            + "Mas você tenta dar um palpite.";
                                                    typeWriter(texto, velocidadeTexto);
                                                    
                                                    if(dado >= 15)
                                                    {
                                                        texto = "\n\nVocê lembra de ter as encontrado numa região muito inacessível. \n"
                                                                + "Logo, você começa descrevendo como foi chegar em tal lugar recluso, como uma verdadeira aventura. \n\n"
                                                                + "Os olhos de Nina brilham ao ouvir sua história, como se fosse um conto épico. \n"
                                                                + "Você se sente agradável com essa reação, então começa a enaltecer sua grandiosidade. \n\n"
                                                                + "Enquanto estava relatando, você nem percebe a chegada do tarveneiro na mesa. \n"
                                                                + "De pé ao lado da mesa, ele faz um aceno para ela voltar ao trabalho. \n"
                                                                + "Já para você, ele lhe olha e diz. \n\n"
                                                                + "'Que tal vivenciar outra viagem indo ao Norte?' \n"
                                                                + "'Para aí sim voltar aqui e contar com mais legitimidade.' \n\n"
                                                                + "Soando meio ameaçador, você sai do estabelecimento. \n"
                                                                + "Mas antes de ir, ele esclarece as interpretações com você.";
                                                    }
                                                    else
                                                    {
                                                        texto = "\n\nVocê não tem ideia de onde era tal lugar. \n"
                                                                + "Porém, usa desse artifício para inventar algo extraordinário. \n\n"
                                                                + "Inocentemente, você parece achar que ela está acreditando nesta história. \n"
                                                                + "Mesmo que pareça absurdo em alguns momentos, ambos estão felizes. \n\n"
                                                                + "Contudo, a graça acaba quando o tarveneiro chega para interromper a diversão. \n"
                                                                + "Mandando-a de volta ao trabalho, você está a sós com ele. \n\n"
                                                                + "'Você pode contar uma história de verdade na próxima.' \n"
                                                                + "'Basta seguir ao Norte, lá estará uma ótima história de aventura te aguardando.' \n\n"
                                                                + "Como não há nada a perder, você parte naquela direção.";
                                                    }
                                                }
                                                else if(antecedente.equals("Mercenário"))
                                                {
                                                    texto = "\nVocê conta que era um mercenário. \n\n"
                                                            + "Isso assusta um pouco Nina, mas que pergunta. \n"
                                                            + "'Então você já matou uma pessoa?' \n\n"
                                                            + "É incerto, mas pelo tanto que você já lutou para chegar até aqui... \n"
                                                            + "Você enxerga a expressão acuada dela, então a acalma. \n\n"
                                                            + "'Então você não matou ninguém, né?' \n"
                                                            + "Você acena que sim, que nunca matou uma pessoa. \n\n"
                                                            + "Com isso, ela parte para outra pergunta. \n"
                                                            + "'E por que saiu dessa vida? Tava sendo mal remunerado? \n\n"
                                                            + "Você não lembra com exatidão, mas tenta.";
                                                    typeWriter(texto, velocidadeTexto);
                                                    
                                                    if(dado >= 15)
                                                    {
                                                        texto = "\n\nSim, você lembra bem, lembra bem até que demais. \n"
                                                                + "Você começa contando como que uma caçada a um ogro falhou. \n\n"
                                                                + "Mesmo que evite todos os detalhes vicerais, a expressão imaginativa dela diz muita coisa. \n"
                                                                + "'Que horror...' \n\n"
                                                                + "Na tentativa de apaziguar esse clima amargo, você conta o que houve depois. \n"
                                                                + "Mas tempos melhores ainda não chegarão, pois o tarveneiro chega na mesa de vocês. \n\n"
                                                                + "'Quem sabe dias melhores cheguem se deixar ela trabalhar, hein?' \n"
                                                                + "'Ah! Foi mal, chefe.' \n\n"
                                                                + "Voltando ao trabalho, você recebe uma proposta de aventura. \n"
                                                                + "'A ameaça ainda não foi neutralizada, siga o Norte que eventualmente achará o caminho.' \n\n"
                                                                + "Meio enigmático, você segue a sugestão após obter um propósito.";
                                                    }
                                                    else
                                                    {
                                                        texto = "\n\nVocê não lembra do motivo principal. \n"
                                                                + "O que faz Nina criar suposições aliviadoras. \n\n"
                                                                + "'Será porquê tomou uma flechada no joelho?' \n"
                                                                + "'Ou será que foi traído pela sua companhia?' \n"
                                                                + "'Hmm...' \n\n"
                                                                + "E mais uma suposição é dada pelo tarveneiro. \n"
                                                                + "'Ou será que você está ocupando tempo demais do aventureiro?' \n\n"
                                                                + "Notando a chegada de seu superior, ela continua o serviço. \n"
                                                                + "Quanto a você, também estará daqui a pouco trabalhando. \n\n"
                                                                + "Pois ele oferta uma interessante aventura para você. \n"
                                                                + "'Indo ao Norte, você encontrará muitas lutas que farão entrar em forma.' \n\n"
                                                                + "Como se fosse um gatilho, você é impulsionado por uma vontade interior. \n"
                                                                + "Que te motiva a trilhar tal caminho.";
                                                    }
                                                }
                                                else
                                                {
                                                    texto = "\nVocê conta que era um nobre. \n\n"
                                                            + "Isso surpreende Nina, que pergunta. \n"
                                                            + "'Nobre? Como foi se tornar um aventureiro?' \n\n"
                                                            + "Você não lembra, mas tenta lembrar com a ajuda dela. \n"
                                                            + "Ela começa a dar sugestões de rumos que poderia ter tomado. \n"
                                                            + "'Acabou o dinheiro? Incentivo dos pais? Motivo pessoal?'";
                                                    typeWriter(texto, velocidadeTexto);
                                                    
                                                    System.out.println("\n\nQual sugestão deseja escolher?");
                                                    System.out.println("\n1 - Falta de dinheiro \n2 - Influência dos pais \n3 - Motivação pessoal \n");
                                                    opcao = read.nextInt();
                                                    
                                                    while(opcao < 1 || opcao > 3)
                                                    {
                                                        System.out.println("\nVocê quer mais diálogos!? Já tá bom, eu acho.");
                                                        System.out.println("\nQual sugestão deseja escolher?");
                                                        System.out.println("\n1 - Falta de dinheiro \n2 - Influência dos pais \n3 - Motivação pessoal \n");
                                                        opcao = read.nextInt();
                                                    }
                                                    
                                                    switch(opcao)
                                                    {
                                                        case 1:
                                                            texto = "\nÉ o motivo mais fácil de supor, pois o dinheiro uma hora acaba. \n"
                                                                    + "'Se o dinheiro acabou, no que você gastou?' \n\n"
                                                                    + "Você confere seu equipamento, mas nada extravagante. \n"
                                                                    + "Logo, percebe-se o quão mão de vaca você virou após a falência. \n"
                                                                    + "Retendo uma boa quantia de dinheiro e poupando nas despesas \n\n"
                                                                    + "E de repente, o tarveneiro está aqui jogando cara ou coroa consigo mesmo. \n"
                                                                    + "'Se você não trabalhar, mocinha, não vai ter dinheiro caindo na sua conta.' \n\n"
                                                                    + "Fazendo com que ela volte a atender outros clientes com um esforço ainda maior. \n"
                                                                    + "Enquanto isso, o tarveneiro guarda a moeda e faz uma oferta para você. \n"
                                                                    + "'Lá ao Norte, em Feist, estará encontrando uma boa recompensa-' \n\n"
                                                                    + "Falando em recompensa, você imediatamente sai da taverna enquanto come rapidamente todo o café da manhã.";
                                                        break;
                                                        
                                                        case 2:
                                                            texto = "\nVocê não se recorda de seus pais serem aventureiros. \n"
                                                                    + "Mas gosta da ideia, que traz um novo significado para todo o trajeto que você fez até agora. \n"
                                                                    + "'Eu queria ter pais aventureiros, no mínimo algum conhecido que seja aventureiro.' \n\n"
                                                                    + "Falando tão alto um desejo particular, você fica sem resposta por um momento. \n"
                                                                    + "'Ah! Você será o primeiro!' \n\n"
                                                                    + "Nina percebe a oportunidade que está ganhando. \n"
                                                                    + "Mas que logo estará sendo interrompida pelo tarveneiro. \n"
                                                                    + "'O primeiro de muitos, se continuar trabalhando.' \n\n"
                                                                    + "Tendo a atenção chamada pelo chefe, ela volta a trabalhar. \n"
                                                                    + "Já o tarveneiro, ele lhe conta um fato curioso. \n\n"
                                                                    + "'Sabe, conheço um paladino que seu filho também é paladino.' \n"
                                                                    + "'Você não está sozinho nessa. Então é melhor começar a sua história, primeiramente, indo ao Norte.' \n\n"
                                                                    + "Você gostou da forma que ele disse isso, te fazendo rumar ao Norte.";
                                                        break;
                                                        
                                                        default:
                                                            texto = "\nSe é um motivo pessoal, que ele seja muito específico. \n"
                                                                    + "Que abre um leque de opções ainda maior. \n\n"
                                                                    + "'Se eu fosse uma nobre donzela, eu apenas abandonaria a nobreza para me tornar...' \n"
                                                                    + "'Uma feiticeira!' \n\n"
                                                                    + "Ela gosta de exclamar de vez em quando. \n"
                                                                    + "Que chama a atenção do chefe dela, o tarveneiro. \n\n"
                                                                    + "'Então seu primeiro feitiço será trazer uma bandeja de cerveja para a mesa 3.' \n"
                                                                    + "Você acha cômico, mas não ri, só sorrindo de canto. \n\n"
                                                                    + "Sem ela por perto, você volta a estaca quase zero. \n"
                                                                    + "Quase zero, pois o tarveneiro tem a solução para seu vazio. \n\n"
                                                                    + "'Quem sabe possa convidá-la pra uma próxima aventura?' \n"
                                                                    + "'Mas não dessa de agora, que estou propondo.' \n"
                                                                    + "'O local é ao Norte, próximo de Feist. Consegue ir lá?' \n\n"
                                                                    + "Tendo nenhuma objeção, você parte diretamente para lá.";
                                                    }
                                                }
                                                typeWriter(texto, velocidadeTexto);
                                                
                                                if(antecedente.equals("Nobre"))
                                                {
                                                    System.out.println("\n\nPressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 2.");
                                                    read.nextLine();
                                                    resposta = read.nextLine();      
                                                }
                                                else
                                                {
                                                    System.out.println("\n\nPressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 2.");
                                                    resposta = read.nextLine();
                                                }
                                                
                                                rodandoParte1 = false;
                                            break;
                                            
                                            default:
                                                if(!raca.equals("Humano"))
                                                {
                                                    texto = "\nVocê percebe a pequena pausa para ela raciocinar. \n"
                                                            + "Pois a sua noção de idade é diferente, uma vez que não é humano. \n\n"
                                                            + "Com essa confusão engraçada, ela não vê problema em dizer a idade. \n"
                                                            + "'Tenho 18.' \n\n"
                                                            + "Independentemente, essa pergunta somente saciou sua curiosidade. \n"
                                                            + "E você não sabe como prosseguir porque o assunto morreu. \n\n"
                                                            + "Logo, quem chega para enterrar o caixão é o tarveneiro. \n"
                                                            + "'Vocês têm tempo para papo furado, mas para trabalhar não né?' \n\n"
                                                            + "Rapidamente, a moça volta ao trabalho. \n"
                                                            + "Enquanto que um objetivo lhe é dado. \n"
                                                            + "'Siga ao Norte, olhe para o lado, eventualmente vai achar algo interessante.' \n\n"
                                                            + "Tendo isso em mente, você parte.";
                                                }
                                                else
                                                {
                                                    texto = "\nÉ inadequado perguntar isso a uma mulher. \n"
                                                            + "Mas não é muito problema para a moça compreensível. \n"
                                                            + "'Tenho 18.' \n\n"
                                                            + "A forma ríspida dela responder pareceu te afetar. \n"
                                                            + "Não tendo tempo para construir uma conversa, logo lhe é questionado. \n"
                                                            + "'Por que a pergunta?' \n\n"
                                                            + "De forma impulsiva, você fala com honestidade para tentar tirar o peso dos ombros. \n"
                                                            + "'Oh. Obrigada. Hihi.' \n\n"
                                                            + "Tendo aceito o elogio, parece que resolveu a situação contransgedora. \n"
                                                            + "Mas nada mais constrangedor que isso é o supervisor dela ter escutado tudo isso. \n"
                                                            + "'Qual foi, vocês não são mais crianças, por que essa lenga lenga toda?' \n\n"
                                                            + "Percebendo que estava matando trabalho, ela volta a servir outros clientes. \n"
                                                            + "'Quanto a você, deve estar na idade para umas boas aventuras.' \n\n"
                                                            + "O tarveneiro lhe conta sobre ir ao Norte pois encontrará algo interessante. \n"
                                                            + "Você parte em desventura.";
                                                }
                                                typeWriter(texto, velocidadeTexto);
                                                
                                                System.out.println("\n\nPressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 2.");
                                                read.nextLine();
                                                resposta = read.nextLine();
                                                
                                                rodandoParte1 = false;
                                        }
                                }
                        }
                }
        }
                
        limpaTela();
                
        int budget = 1000, aumento = 1, contadorPR = 1, contadorUpgrade = 1, contadorCouro = 1, contadorTalas = 1, contador = 1, strUp = 0, dexUp = 0, inteUp = 0;
        int vidaInimigo = 0, CAInimigo = 0, bonusAtaqueInimigo = 0, bonusDanoInimigo = 0, indicieDanoInimigo = 0;
        int resultado[] = new int[5];
        String inimigo = null;
        char ultimaLetra = 0;
                
        while(rodandoParte2)
        {
            String nomeSeparado[] = nome.split(" ");
            
            char letraMaiuscula[];
            
            for (int i = 0; i < nomeSeparado.length; i++)
            {
                letraMaiuscula = nomeSeparado[i].toCharArray();
                letraMaiuscula[0] = Character.toUpperCase(letraMaiuscula[0]);
                Nome = new String(letraMaiuscula);
                nomeSeparado[i] = Nome;
            }
            
            chance = aleatorio(100);
                    
            System.out.println("PARTE 2 \n");
                    
            //Missão da Carta
            if(inv.contains("Carta"))
            {
                texto = "Tarde. Praça das Luzes. \n\n"
                        + "Você segue as recomendações do recado, demorando um pouco para achar o centro comercial da cidade. \n"
                        + "Mas aí está você, sentado na beirada do chafariz desta praça decidindo para onde ir. \n";
                typeWriter(texto, velocidadeTexto);
                        
                while(rodandoCompra)
                {
                    System.out.println("\nOnde deseja fazer compras?");
                    System.out.println("\nOrçamento: "+budget);
                    System.out.println("\n1 - Casa do Verde \n2 - Botalar Ferrarias \n3 - Ninho da Coruja \n\n4 - Encerrar compra \n");
                    opcao = read.nextInt();
                        
                    while(opcao < 1 || opcao > 4)
                    {
                        System.out.println("\nClaro que há mais lojas além destas, mas elas não são de seu interesse.");
                        System.out.println("\nOnde deseja fazer compras?");
                        System.out.println("\n1 - Casa do Verde \n2 - Botalar Ferrarias \n3 - Ninho da Coruja \n\n4 - Encerrar compra \n");
                        opcao = read.nextInt();
                    }
                        
                    switch(opcao)
                    {
                        case 1:
                            System.out.println("\nO que deseja comprar?");
                            System.out.println("\nOrçamento: "+budget);
                            System.out.println("\n1 - Poção de Cura [50 Moedas] \n2 - Poção de Cura Retardada [500 Moedas] \n\n3 - Cancelar compra \n");
                            opcao = read.nextInt();
                               
                            while(opcao < 1 || opcao > 3)
                            {
                                System.out.println("\nSomente estes itens.");
                                System.out.println("\nOrçamento: "+budget);
                                System.out.println("\n1 - Poção de Cura [50 Moedas] \n2 - Poção de Cura Retardada [500 Moedas] \n\n3 - Cancelar compra \n");
                                opcao = read.nextInt();
                            }
                                
                            switch(opcao)
                            {
                                case 1: inv.add("Poção de Cura"); budget -= 50; break;
                                case 2:
                                    if(contadorPR == 1)
                                    {
                                        texto = "\nVocê acha um tanto engraçado uma poção ser nomeada dessa forma. \n"
                                                + "O dono da loja nota a sua obsessão por tal produto. \n"
                                                + "'Deseja comprar? Ela é a última do estoque.' \n\n"
                                                + "Primeiramente, você pergunta o que ela faz. \n"
                                                + "'Ela te cura assim que você fica inconsciente ou perto de morrer.' \n\n"
                                                + "Pelo modo que ele falou, não tem como achar que seja um golpe. \n"
                                                + "Portanto, decide comprar?";
                                        typeWriter(texto, velocidadeTexto);
                                        
                                        System.out.println("\n\nSim ou Não?");
                                        read.nextLine();
                                        resposta = read.nextLine().toUpperCase();
                                        
                                        while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                                        {
                                            System.out.println("\nAinda errando isso?");
                                            System.out.println("\nSim ou Não?");
                                            resposta = read.nextLine().toUpperCase();
                                        }
                                        if(resposta.equals("SIM") || resposta.equals("S"))
                                        {
                                            System.out.println("\nVocê imediatamente bebe a poção assim que a compra.");
                                            inv.add("Poção de Cura Retardada");
                                            budget -= 500;
                                            contadorPR = 3;
                                            
                                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                            resposta = read.nextLine();
                                        }
                                        else
                                        {
                                            System.out.println("\nVocê não compra.");
                                            contadorPR = 2;
                                        }
                                    }
                                    else if(contadorPR == 2)
                                    {
                                        System.out.println("\nDeseja comprar? Sim ou Não?");
                                        read.nextLine();
                                        resposta = read.nextLine().toUpperCase();
                                        
                                        while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                                        {
                                            System.out.println("\nAinda errando isso?");
                                            System.out.println("\nSim ou Não?");
                                            resposta = read.nextLine().toUpperCase();
                                        }
                                        
                                        if(resposta.equals("SIM") || resposta.equals("S"))
                                        {
                                            System.out.println("\nVocê imediatamente bebe a poção assim que a compra.");
                                            inv.add("Poção de Cura Retardada");
                                            budget -= 500;
                                            contadorPR = 3;
                                            
                                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                            resposta = read.nextLine();
                                        }
                                        else
                                            System.out.println("\nVocê não compra.");
                                    }
                                    else
                                        System.out.println("\nSó se pode comprar uma vez.");
                                break;
                                default: System.out.println("\nVocê cancela a compra.");
                            }
                        break;
                            
                        case 2:
                            System.out.println("\nO que deseja comprar?");
                            System.out.println("\nOrçamento: "+budget);
                            System.out.println("\n1 - Aprimorar Arma [200 Moedas] \n2 - Armadura de Couro Batido [50 Moedas] \n3 - Cota de Talas [200 Moedas] \n\n4 - Cancelar compra \n");
                            opcao = read.nextInt();
                                
                            while(opcao < 1 || opcao > 4)
                            {
                                System.out.println("\nSomente estes itens.");
                                System.out.println("\nOrçamento: "+budget);
                                System.out.println("\n1 - Aprimorar Arma [200 Moedas] \n2 - Armadura de Couro Batido [50 Moedas] \n3 - Cota de Talas [200 Moedas] \n\n4 - Cancelar compra \n");
                                opcao = read.nextInt();
                            }
                                    
                            switch(opcao)
                            {
                                case 1:
                                    if(contadorUpgrade <= 3)
                                    {
                                        System.out.println("\nVocê aprimorou sua arma. \nEla agora dá +"+aumento+" no ataque e dano.");
                                        budget -= 200;
                                        ataqueJogador++;
                                        bonusDanoJogador++;
                                        contadorUpgrade++;
                                        aumento++;
                                    }
                                    else
                                        System.out.println("\nVocê chegou ao limite de aprimoramentos.");
                                break;
                                        
                                case 2:
                                    if(contadorCouro == 1)
                                    {
                                        System.out.println("\nVocê obteve Armadura de Couro Batido.");
                                        budget -= 50;
                                        contadorCouro++;
                                        inv.add("Armadura de Couro Batido");
                                        if(classe.equals("Ladino"))
                                        {
                                            System.out.println("Sua Armadura aumentou em +1.");
                                            CA++;
                                        }
                                        else
                                            System.out.println("\nParabéns, você comprou um item que será inútil.");
                                    }
                                    else
                                        System.out.println("\nSó se pode comprar uma vez.");
                                break;
                                        
                                case 3:
                                    if(contadorTalas == 1)
                                    {
                                        System.out.println("\nVocê obteve Cota de Talas.");
                                        budget -= 200;
                                        contadorTalas++;
                                        inv.add("Cota de Talas");
                                        if(classe.equals("Guerreiro"))
                                        {
                                            System.out.println("Sua Armadura aumentou em +1.");
                                            CA++;
                                        }
                                        else
                                            System.out.println("\nParabéns, você comprou um item que será inútil.");
                                    }
                                    else
                                        System.out.println("\nSó se pode comprar uma vez.");
                                break;
                                        
                                default:
                                    System.out.println("\nVocê cancela a compra.");
                            }
                        break;
                                
                        case 3:
                            System.out.println("\nO que deseja comprar?");
                            System.out.println("\nOrçamento: "+budget);
                            System.out.println("\n1 - Aumento Temporário de Força [300 Moedas] \n2 - Aumento Temporário de Destreza [300 Moedas] \n3 - Aumento Temporário de Inteligência [300 Moedas] \n\n4 - Cancelar compra \n");
                            opcao = read.nextInt();
                                    
                            while(opcao < 1 || opcao > 4)
                            {
                                System.out.println("\nÉ só isso.");
                                System.out.println("\nOrçamento: "+budget);
                                System.out.println("\n1 - Aumento Temporário de Força [300 Moedas] \n2 - Aumento Temporário de Destreza [300 Moedas] \n3 - Aumento Temporário de Inteligência [300 Moedas] \n\n4 - Cancelar compra \n");
                                opcao = read.nextInt();
                            }
                                    
                            switch(opcao)
                            {
                                case 1:
                                    if(contador == 1)
                                    {
                                        if(str >= 10)
                                        {
                                            System.out.println("\nVocê aumentou sua Força em 14.");
                                            str = 14;
                                            budget -= 300;
                                            contador++;
                                        }
                                        else
                                        {
                                            System.out.println("\nVocê aumentou sua Força em 10.");
                                            str = 10;
                                            budget -= 300;
                                            contador++;
                                        }
                                    }
                                    else
                                        System.out.println("\nVocê só pode comprar uma única vez um deles.");
                                break;
                                        
                                case 2:
                                    if(contador == 1)
                                    {
                                        if(dex >= 10)
                                        {
                                            System.out.println("\nVocê aumentou sua Destreza em 14.");
                                            dex = 14;
                                            budget -= 300;
                                            contador++;
                                        }
                                        else
                                        {
                                            System.out.println("\nVocê aumentou sua Destreza em 10.");
                                            dex = 10;
                                            budget -= 300;
                                            contador++;
                                        }
                                    }
                                    else
                                        System.out.println("\nVocê só pode comprar uma única vez um deles.");
                                break;
                                        
                                case 3:
                                    if(contador == 1)
                                    {
                                        if(inte >= 10)
                                        {
                                            System.out.println("\nVocê aumentou sua Inteligência em 14.");
                                            inte = 14;
                                            budget -= 300;
                                            contador++;
                                        }
                                        else
                                        {
                                            System.out.println("\nVocê aumentou sua Inteligência em 10.");
                                            inte = 10;
                                            budget -= 300;
                                            contador++;
                                        }
                                    }
                                    else
                                        System.out.println("\nVocê só pode comprar uma única vez um deles.");
                                break;
                                        
                                default:
                                    System.out.println("\nVocê cancela a compra.");
                            }
                        break;
                                
                        default:
                            System.out.println("\nVocê encerra suas compras.");
                            rodandoCompra = false;
                    }
                }
                        
                if(budget < 0)
                {
                    texto = "Parece que você realmente exagerou nas compras. \n"
                            + "Ficando no negativo, você fica indeciso no que vai fazer quanto a isso.";
                    typeWriter(texto, velocidadeTexto);
                    
                    if(budget+moedas >= 0)
                    {
                        texto = "\n\nPorém, você lembra que ainda possui moedas. \n"
                                + "E elas são suficiente para quitar esta dívida. \n\n"
                                + "Com um pouco de receio, você dá andamento na missão.";
                        typeWriter(texto, velocidadeTexto);
                                
                        System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                        read.nextLine();
                        resposta = read.nextLine();
                        limpaTela();
                    }
                    else if(budget+moedas < 0)
                    {
                        texto = "\n\nNem com sua quantia de moedas consegue suprir o valor negativado. \n"
                                + "Obrigando a você deixar de pensar na recompensa e te fazendo pensar numa decisão.";
                        typeWriter(texto, velocidadeTexto);
                                
                        System.out.println("\n\nDeseja continuar? Sim ou Não?");
                        read.nextLine();
                        resposta = read.nextLine().toUpperCase();
                                
                        while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                        {
                            System.out.println("\nNão há como fugir desta decisão.");
                            System.out.println("\nDeseja continuar? Sim ou Não?");
                            resposta = read.nextLine().toUpperCase();
                        }
                                
                        if(resposta.equals("SIM") || resposta.equals("S"))
                        {
                            texto = "\nVocê está esperançoso e espera que esse tal Duque compreenda sua situação. \n"
                                    + "Decidindo continuar trilhando indo, definitivamente, para o Norte.";
                            typeWriter(texto, velocidadeTexto);
                            
                            System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                            resposta = read.nextLine();
                            limpaTela();
                        }
                        else
                        {
                            texto = "\nVocê pega a carta e tudo que você tem. \n"
                                    + "E decide ir embora, que muito provavelmente um grupo estará perseguindo você nos próximos dias.";
                            typeWriter(texto, velocidadeTexto);
                                    
                            System.out.println("\n\nParabéns! Você gastou as moedas de forma irresponsável! \n\nFinal 3 de 6");
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                            read.nextLine();
                            resposta = read.nextLine();
                            rodandoParte2 = false;
                            rodandoParte3 = false;
                        }
                    }
                }
                        
                if(contador != 1)
                {
                    vidaMaxJogador -= bonusStr; vidaMaxJogador -= bonusStr; vidaMaxJogador -= bonusStr;
                       
                    if(!classe.equals("Guerreiro"))
                        CA -= bonusDex;
                            
                    if(classe.equals("Guerreiro"))
                        ataqueJogador -= bonusStr;
                    else if(classe.equals("Ladino"))
                        ataqueJogador -= bonusDex;
                    else
                        ataqueJogador -= bonusInte;
                        
                    percepcaoPassiva -= bonusInte;
                            
                    bonusStr = str/2; bonusDex = dex/2; bonusInte = inte/2; percepcaoPassiva += bonusInte;
                        
                    vidaMaxJogador += bonusStr+bonusStr+bonusStr;
                    vidaJogador = vidaMaxJogador;
                        
                    if(!classe.equals("Guerreiro"))
                        CA += bonusDex;
                            
                    if(classe.equals("Guerreiro"))
                        {ataqueJogador += bonusStr; bonusDanoJogador = bonusStr;}
                    else if(classe.equals("Ladino"))
                        {ataqueJogador += bonusDex; bonusDanoJogador = bonusDex;}
                    else
                        {ataqueJogador += bonusInte; bonusDanoJogador = bonusInte;}
                        
                    texto = "Após tomar uma mágica muito forte, que foi capaz de aumentar suas habilidades. \n"
                            + "Você se sente mais forte, portanto, confira como está seu personagem: \n\n";
                    typeWriter(texto, velocidadeTexto);
                            
                    ficha(inv, nomeSeparado, idade, classe, raca, antecedente, vidaMaxJogador, CA, str, bonusStr, dex, bonusDex, inte, bonusInte, moedas);
                         
                    if(budget > 0)
                    {
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 3.");
                        read.nextLine();
                        resposta = read.nextLine();
                    }
                    else
                    {
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 3.");
                        resposta = read.nextLine();
                    }
                            
                    rodandoParte2 = false;
                }
                else
                {
                    System.out.println("\nPressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 3.");
                    read.nextLine();
                    resposta = read.nextLine();
                            
                    rodandoParte2 = false;
                }
            }
            //Missão da Dungeon
            else
            {
                texto = "Tarde. Estraga Longa. \n\n"
                        +"Você já está há um tempo percorrendo esta estrada de terra. \n"
                        + "Que decide acampar sentando em volta de uma fogueira. \n\n"
                        + "Comendo seu pão com ovo, você até agora não encontrou ameaças. \n"
                        + "Mas você dá andamento com seu caminho.";
                typeWriter(texto, velocidadeTexto);
                        
                System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                resposta = read.nextLine();
                
                limpaTela();
                            
                while(rodandoTrilha)
                {
                    chance = aleatorio(100);
                                
                    vidaJogador = descanso(rodandoDescanso, vidaJogador, vidaMaxJogador);
                                
                    //Monstros CR 1/8 a 1/4
                    if(chance >= 30 && chance < 50)
                    {
                        String inimigos[] = {"Rato Gigante", "Espada Voadora", "Goblin", "Cobra Constritora"};
                        inimigo = inimigos[aleatorio(inimigos.length)-1];
                                   
                        ultimaLetra = inimigo.charAt(inimigo.length()-1);
                                   
                        switch(inimigo)
                        {
                            case "Rato Gigante": resultado = valoresInimigo(aleatorio(6)+aleatorio(6), 12, 4, 2, 4); break;
                            case "Espada Voadora": resultado = valoresInimigo(aleatorio(6)+aleatorio(6)+aleatorio(6)+aleatorio(6)+aleatorio(6), 17, 3, 1, 8); break;
                            case "Goblin": resultado = valoresInimigo(aleatorio(6)+aleatorio(6), 15, 4, 2, 6); break;
                            default: resultado = valoresInimigo((aleatorio(10)+aleatorio(10))+2, 12, 4, 2, 6);
                        }
                                   
                        vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    }
                    //Monstros CR 1/2
                    else if(chance >= 50 && chance < 80)
                    {
                        String inimigos[] = {"Orc", "Vespa Gigante", "Cocatriz", "Gnoll"};
                        inimigo = inimigos[aleatorio(inimigos.length)-1];
                                 
                        ultimaLetra = inimigo.charAt(inimigo.length()-1);
                        
                        switch(inimigo)
                        {
                            case "Orc": resultado = valoresInimigo((aleatorio(8)+aleatorio(8))+6, 13, 5, 3, 12); break;
                            case "Vespa Gigante": resultado = valoresInimigo(aleatorio(8)+aleatorio(8)+aleatorio(8), 12, 4, 2, 6); ultimaLetra = 'a'; break;
                            case "Cocatriz": resultado = valoresInimigo((aleatorio(6)+aleatorio(6)+aleatorio(6)+aleatorio(6)+aleatorio(6)+aleatorio(6))+6, 11, 3, 1, 4); ultimaLetra = 'a'; break;
                            default: resultado = valoresInimigo(aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8), 15, 4, 2, 8);
                        }
                                    
                        vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    }
                    //Monstros CR 1/2 a 1
                    else if(chance >= 80 && chance < 100)
                    {
                        String inimigos[] = {"Worg", "Carniçal", "Harpia", "Armadura Animada"};
                        inimigo = inimigos[aleatorio(inimigos.length)-1];
                                   
                        ultimaLetra = inimigo.charAt(inimigo.length()-1);
                                    
                        switch(inimigo)
                        {
                            case "Worg": resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+4, 13, 5, 3, 6); break;
                            case "Carniçal": resultado = valoresInimigo(aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8), 12, 4, 2, 4); break;
                            case "Harpia": resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+7, 11, 6, 3, 6); break;
                            default: resultado = valoresInimigo(((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+6), 18, 4, 2, 6);
                        }
                                    
                        vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    }
                    else if(chance == 100)
                    {
                        texto = "\nEnquanto você está caminhando, um poço chama sua atenção. \n";
                        typeWriter(texto, velocidadeTexto);
                                
                        System.out.println
                             ("\t                 __ \n"
                            + "\t               .'/"+"\\"+"'. \n"
                            + "\t             .'-/__"+"\\"+"-'. \n"
                            + "\t           .'--/____"+"\\"+"--'. \n"
                            + "\t         .'--./______"+"\\"+".--'. \n"
                            + "\t       .'--../________"+"\\"+"..--'. \n"
                            + "\t     .'--.._/__________"+"\\"+"_..--'. \n"
                            + "\t   .'--..__/____________"+"\\"+"__..--'. \n"
                            + "\t .'--..___/______________"+"\\"+"___..--'. \n"
                            + "\t'========'================'========' \n"
                            + "\t      [_|__]            [_|__] \n"
                            + "\t     =[__|_]=====\"\"=====[__|_]==. \n"
                            + "\t      [_|__]     '|     [_|__]  | \n"
                            + "\t      [__|_]     |'     [__|_]  | \n"
                            + "\t      [_|__]  .--JL--.  [_|__]  '===O \n"
                            + "\t      [__|_]   "+"\\"+"====/   [__|_] \n"
                            + "\t      [_|__]_.-| .; |-._[_|__] \n"
                            + "\t      [__|_]'._ "+"\\"+"__/(_.'[__|_] \n"
                            + "\t      [.-._]            [_.-.] \n"
                            + "\t      [_.-.'--..____..--'.-._] \n"
                            + "\t (o)  [(_.'   .-.     .-.'._)"+"\\"+" (o) \n"
                            + "\t("+"\\"+"'/) [  .-. (_.'.-. (_.' .-.]("+"\\"+"'/) \n"
                            + "\t   ;: [ (_.'.-. (_.' .-. (_.'| ;:' \n"
                            + "\t;:    [ .-. '._) .-. '._).-. ]   ;:. \n"
                            + "\t      [(_.'  .-. '._) .-.'._)] \n"
                            + "\t  (o) /.-.  (_.'.-.  (_.' .-.];:(o) \n"
                            + "\t ("+"\\"+"'/)['._).-. (_.'   .-.(_.'] ("+"\\"+"'/) \n"
                            + "\t      [   (_.'.-.  .-.'._)   \\ ;: \n"
                            + "\t;:'   '-._    '._) '._)   _.-' \n"
                            + "\t           `---..____..---'   ;:` \n"
                            + "\t   ;:'      ;:'.:;     ;;"+"\" \n");
                                
                        System.out.println("O que deseja fazer?");
                        System.out.println("\n1 - Beber \n2 - Ignorar \n");
                        opcao = read.nextInt();
                                
                        while(opcao < 1 || opcao > 2)
                        {
                            System.out.println("\nNão, não dá para se jogar no poço.");
                            System.out.println("O que deseja fazer?");
                            System.out.println("\n1 - Beber \n2 - Ignorar \n");
                            opcao = read.nextInt();
                        }
                                
                        if(opcao == 1)
                        {
                            System.out.println("\nVocê bebe e nada mudou... aparentemente.");
                            vidaMaxJogador += 30;
                            vidaJogador = vidaMaxJogador;
                                    
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                            read.nextLine();
                            resposta = read.nextLine();
                        }
                        else
                        {
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                            read.nextLine();
                            resposta = read.nextLine();
                        }
                                
                        contador++;
                    }
                    else
                    {
                        texto = "\nVocê passa despercebido pelos monstros. \n";
                        typeWriter(texto, velocidadeTexto);
                                
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para para continuar.");
                        resposta = read.nextLine();
                                
                        limpaTela();
                                
                        contador++;
                    }
                    
		    if(chance >= 30 && chance < 100)
	 	    {
                    	if(ultimaLetra == 'a')
                            texto = "\nVocê se depara com uma "+inimigo+"! \n\n";
                        else
                            texto = "\nVocê se depara com um "+inimigo+"! \n\n";
                        typeWriter(texto, velocidadeTexto);
                                   
                        vidaJogador = combate(vidaMaxJogador, velocidadeTexto, inv, rodandoCombate, classe, inimigo, vidaInimigo, bonusAtaqueInimigo, bonusDanoInimigo, indicieDanoInimigo, CAInimigo, vidaJogador, ataqueJogador, danoJogador, bonusDanoJogador, indicieDanoJogador, CA, bonusDex);
                               
                        if(vidaJogador > 0)
                            contador++;
			else
                        {
                            rodandoTrilha = false;
                            rodandoParte2 = false;
                            rodandoParte3 = false;
                        }
		    }
                            
                    if(contador == 10)
                        rodandoTrilha = false;
                }
                        
                if(vidaJogador > 0)
                {
                    limpaTela();
                        
                    texto = "Após lutar com diversos monstros, você sobe de nível! \n";
                    typeWriter(texto, velocidadeTexto);
                        
                    System.out.println("No que deseja distribuir seus 4 pontos? \n");
                    System.out.print("Força: ");
                    strUp = read.nextInt();
                    System.out.print("Destreza: ");
                    dexUp = read.nextInt();
                    System.out.print("Inteligência: ");
                    inteUp = read.nextInt();
                        
                    while(strUp+dexUp+inteUp != 4)
                    {
                        System.out.println("\nHouve algum erro de cálculo.");
                        System.out.print("Força: ");
                        strUp = read.nextInt();
                        System.out.print("Destreza: ");
                        dexUp = read.nextInt();
                        System.out.print("Inteligência: ");
                        inteUp = read.nextInt();
                    }
                        
                    while(strUp < 0 || dexUp < 0 || inteUp < 0)
                    {
                        System.out.print("\nNão pode ser negativo.");
                        System.out.print("Força: ");
                        strUp = read.nextInt();
                        System.out.print("Destreza: ");
                        dexUp = read.nextInt();
                        System.out.print("Inteligência: ");
                        inteUp = read.nextInt();
                    }
                    
                    System.out.println("\nDeseja pegar vida fixa? Sim ou Não?");
                    read.nextLine();
                    resposta = read.nextLine().toUpperCase();
                    
                    while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                    {
                        System.out.println("Confirme novamente. Sim ou Não?");
                        resposta = read.nextLine().toUpperCase();
                    }
                        
                    vidaMaxJogador -= bonusStr; vidaMaxJogador -= bonusStr; vidaMaxJogador -= bonusStr;
                       
                    if(!classe.equals("Guerreiro"))
                        CA -= bonusDex;
                            
                    if(classe.equals("Guerreiro"))
                        ataqueJogador -= bonusStr;
                    else if(classe.equals("Ladino"))
                        ataqueJogador -= bonusDex;
                    else
                        ataqueJogador -= bonusInte;
                        
                    percepcaoPassiva -= bonusInte;
                        
                    str += strUp; dex += dexUp; inte += inteUp;
                    bonusStr = str/2; bonusDex = dex/2; bonusInte = inte/2; percepcaoPassiva += bonusInte;
                        
                    vidaMaxJogador += bonusStr+bonusStr+bonusStr;
                    
                    if(resposta.equals("SIM") || resposta.equals("S"))
                    {
                        if(classe.equals("Guerreiro"))
                            vidaMaxJogador += aleatorio(10)+bonusStr;
                        else if(classe.equals("Ladino"))
                            vidaMaxJogador += aleatorio(8)+bonusStr;
                        else
                            vidaMaxJogador += aleatorio(6)+bonusStr;
                    }
                    else
                    {
                        if(classe.equals("Guerreiro"))
                            vidaMaxJogador += 6+bonusStr;
                        else if(classe.equals("Ladino"))
                            vidaMaxJogador += 5+bonusStr;
                        else
                            vidaMaxJogador += 4+bonusStr;
                    }
                    
                    vidaJogador = vidaMaxJogador;
                        
                    if(!classe.equals("Guerreiro"))
                        CA += bonusDex;
                            
                    if(classe.equals("Guerreiro"))
                        {ataqueJogador += bonusStr; bonusDanoJogador = bonusStr;}
                    else if(classe.equals("Ladino"))
                        {ataqueJogador += bonusDex; bonusDanoJogador = bonusDex;}
                    else
                        {ataqueJogador += bonusInte; bonusDanoJogador = bonusInte;}
                        
                    System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                    resposta = read.nextLine();
                          
                    limpaTela();
                        
                    ficha(inv, nomeSeparado, idade, classe, raca, antecedente, vidaMaxJogador, CA, str, bonusStr, dex, bonusDex, inte, bonusInte, moedas);
                        
                    System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                    resposta = read.nextLine();
                        
                    limpaTela();
                            
                    texto = "Contentando-se após superar um obstáculo como esse, você vê ao longe uma entrada. \n";
                    typeWriter(texto, velocidadeTexto);
                        
                    System.out.println
                                 ("\t ____________________________________________ \n"
                                + "\t|____________________________________________| \n"
                                + "\t|__||  ||___||  |_|___|___|__|  ||___||  ||__| \n"
                                + "\t||__|  |__|__|  |___|___|___||  |__|__|  |__|| \n"
                                + "\t|__||  ||___||  |_|___|___|__|  ||___||  ||__| \n"
                                + "\t||__|  |__|__|  |    || |    |  |__|__|  |__|| \n"
                                + "\t|__||  ||___||  |    || |    |  ||___||  ||__| \n"
                                + "\t||__|  |__|__|  |    || |    |  |__|__|  |__|| \n"
                                + "\t|__||  ||___||  |    || |    |  ||___||  ||__| \n"
                                + "\t||__|  |__|__|  |    || |    |  |__|__|  |__|| \n"
                                + "\t|__||  ||___||  |   O|| |O   |  ||___||  ||__| \n"
                                + "\t||__|  |__|__|  |    || |    |  |__|__|  |__|| \n"
                                + "\t|__||  ||___||  |    || |    |  ||___||  ||__| \n"
                                + "\t||__|  |__|__|__|____||_|____|  |__|__|  |__|| \n"
                                + "\t|LLL|  |LLLLL|______________||  |LLLLL|  |LLL| \n"
                                + "\t|LLL|  |LLL|______________|  |  |LLLLL|  |LLL| \n"
                                + "\t|LLL|__|L|______________|____|__|LLLLL|__|LLL| \n");
                        
                    System.out.println("Pressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 3.");
                    resposta = read.nextLine();
                        
                    rodandoParte2 = false;
                }
                else
                {
                    System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                    resposta = read.nextLine();
                }
            }
        }
                
        limpaTela();
        contador = 1;
                
        while(rodandoParte3)
        {
            String nomeSeparado[] = nome.split(" ");
            
            char letraMaiuscula[];
            
            for (int i = 0; i < nomeSeparado.length; i++)
            {
                letraMaiuscula = nomeSeparado[i].toCharArray();
                letraMaiuscula[0] = Character.toUpperCase(letraMaiuscula[0]);
                Nome = new String(letraMaiuscula);
                nomeSeparado[i] = Nome;
            }
            
            System.out.println("PARTE 3 \n");
                    
            if(inv.contains("Carta"))
            {
                texto = "Noite. Estrada Longa. \n\n"
                        + "Você está preparado após fazer suas compras. \n"
                        + "Porém, ao mesmo tempo, os monstros tiveram tempo para crescerem em quantidade. \n\n"
                        + "A noite prolifera o mal.";
                typeWriter(texto, velocidadeTexto);
                        
                System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                resposta = read.nextLine();
                        
                rodandoTrilha = true;
                        
                while(rodandoTrilha)
                {
                    chance = aleatorio(100);
                           
                    vidaJogador = descanso(rodandoDescanso, vidaJogador, vidaMaxJogador);
                            
                    //Monstros CR 1/4 a 1/2
                    if(chance >= 30 && chance < 50)
                    {
                        String inimigos[] = {"Zumbi", "Esqueleto", "Morcego Gigante", "Sombra"};
                        inimigo = inimigos[aleatorio(inimigos.length-1)];
                                
                        ultimaLetra = inimigo.charAt(inimigo.length()-1);
                                
                        switch(inimigo)
                        {
                            case "Zumbi": resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8))+9, 8, 3, 1, 6); break;
                            case "Esqueleto": resultado = valoresInimigo((aleatorio(8)+aleatorio(8))+4, 13, 4, 2, 6); break;
                            case "Morcego Gigante": resultado = valoresInimigo(aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10), 13, 4, 2, 6); break;
                            default: resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8))+3, 12, 4, 2, 8);
                        }
                                
                        vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    }
                    //Monstros CR 1/2 a 1
                    else if(chance >= 50 && chance < 80)
                    {
                        String inimigos[] = {"Diabrete", "Urso Pardo", "Hiena Gigante", "Espectro"};
                        inimigo = inimigos[aleatorio(inimigos.length-1)];
                                
                        ultimaLetra = inimigo.charAt(inimigo.length()-1);
                                
                        switch(inimigo)
                        {
                            case "Diabrete": resultado = valoresInimigo((aleatorio(4)+aleatorio(4)+aleatorio(4))+3, 13, 5, 3, 4); break;
                            case "Urso Pardo": resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+12, 11, 5, 4, 8); break;
                            case "Hiena Gigante": resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+12, 12, 5, 3, 6); ultimaLetra = 'a'; break;
                            default: resultado = valoresInimigo(aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8), 12, 4, 2, 10);
                        }
                                
                        vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    }
                    //Monstros CR 2
                    else if(chance >= 80 && chance < 100)
                    {
                        String inimigos[] = {"Ratomem", "Gárgula", "Slime", "Cobra Constritora Gigante"};
                        inimigo = inimigos[aleatorio(inimigos.length-1)];
                                
                        ultimaLetra = inimigo.charAt(inimigo.length()-1);
                                
                        switch(inimigo)
                        {
                            case "Ratomem": resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+6, 12, 4, 2, 4); break;
                            case "Gárgula": resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+21, 15, 4, 2, 6); break;
                            case "Slime": resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+12, 8, 4, 2, 6); break;
                            default: resultado = valoresInimigo((aleatorio(12)+aleatorio(12)+aleatorio(12)+aleatorio(12)+aleatorio(12)+aleatorio(12)+aleatorio(12)+aleatorio(12))+8, 12, 6, 4, 6); ultimaLetra = 'a';
                        }
                                
                        vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    }
                    //Monstros CR 3
                    else if(chance == 100)
                    {
                        String inimigos[] = {"Lobisomem", "Manticora", "Cão Infernal", "Pesadelo"};
                        inimigo = inimigos[aleatorio(inimigos.length-1)];
                                
                        ultimaLetra = inimigo.charAt(inimigo.length()-1);
                                
                        switch(inimigo)
                        {
                            case "Lobisomem": resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+18, 12, 4, 2, 8); break;
                            case "Manticora": resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+24, 14, 5, 3, 8); break;
                            case "Cão Infernal": resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+14, 15, 5, 3, 8); break;
                            default: resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+24, 13, 6, 4, 8);
                        }
                                
                        vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    }
                    else
                    {
                        texto = "\nVocê passa despercebido pelos monstros. \n";
                        typeWriter(texto, velocidadeTexto);
                               
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para para continuar.");
                        resposta = read.nextLine();
                               
                        limpaTela();
                                
                        contador++;
                    }
                    
		    if(chance >= 30 && chance < 100)
		    {
                    	if(ultimaLetra == 'a')
                        	texto = "\nVocê se depara com uma "+inimigo+"! \n\n";
                    	else
                        	texto = "\nVocê se depara com um "+inimigo+"! \n\n";
                    	typeWriter(texto, velocidadeTexto);
                              
                    	vidaJogador = combate(vidaMaxJogador, velocidadeTexto, inv, rodandoCombate, classe, inimigo, vidaInimigo, bonusAtaqueInimigo, bonusDanoInimigo, indicieDanoInimigo, CAInimigo, vidaJogador, ataqueJogador, danoJogador, bonusDanoJogador, indicieDanoJogador, CA, bonusDex);
                               
                    	if(vidaJogador > 0)
                            contador++;
                    	else if(vidaJogador <= 0 && inv.contains("Poção de Cura Retardada"))
                    	{
                            System.out.println("\nSó que não!");
                            System.out.println("\nA poção fez efeito e você recupera metade dos seus pontos de vida.");
                            vidaJogador = vidaMaxJogador / 2;
                            inv.remove("Poção de Cura Retardada");
                            
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                            resposta = read.nextLine();
                            contador++;
                            
                            limpaTela();
                    	}
                    	else
                    	{
                            rodandoTrilha = false;
                            rodandoParte3 = false;
                    	}
                    }

                    if(contador == 10)
                    {
                        limpaTela();
                        
                        texto = "Após lutar com diversos monstros, você sobe de nível! \n";
                        typeWriter(texto, velocidadeTexto);
                        
                        System.out.println("No que deseja distribuir seus 4 pontos? \n");
                        System.out.print("Força: ");
                        strUp = read.nextInt();
                        System.out.print("Destreza: ");
                        dexUp = read.nextInt();
                        System.out.print("Inteligência: ");
                        inteUp = read.nextInt();
                   
                        while(strUp+dexUp+inteUp != 4)
                        {
                            System.out.println("\nHouve algum erro de cálculo.");
                            System.out.print("Força: ");
                            strUp = read.nextInt();
                            System.out.print("Destreza: ");
                            dexUp = read.nextInt();
                            System.out.print("Inteligência: ");
                            inteUp = read.nextInt();
                        }
                    
                        while(strUp < 0 || dexUp < 0 || inteUp < 0)
                        {
                            System.out.println("\nNão pode ser negativo.");
                            System.out.print("Força: ");
                            strUp = read.nextInt();
                            System.out.print("Destreza: ");
                            dexUp = read.nextInt();
                            System.out.print("Inteligência: ");
                            inteUp = read.nextInt();
                        }
                        
                        System.out.println("\nDeseja pegar vida fixa? Sim ou Não?");
                        read.nextLine();
                        resposta = read.nextLine().toUpperCase();
                        
                        while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                        {
                            System.out.println("\nConfirme novamente, Sim ou Não?");
                            resposta = read.nextLine().toUpperCase();
                        }
                    
                        vidaMaxJogador -= bonusStr; vidaMaxJogador -= bonusStr; vidaMaxJogador -= bonusStr;
                    
                        if(!classe.equals("Guerreiro"))
                            CA -= bonusDex;
                    
                        if(classe.equals("Guerreiro"))
                            ataqueJogador -= bonusStr;
                        else if(classe.equals("Ladino"))
                            ataqueJogador -= bonusDex;
                        else
                            ataqueJogador -= bonusInte;

                        percepcaoPassiva -= bonusInte;
                    
                        str += strUp; dex += dexUp; inte += inteUp;
                        bonusStr = str/2; bonusDex = dex/2; bonusInte = inte/2; percepcaoPassiva += bonusInte;
                    
                        vidaMaxJogador += bonusStr+bonusStr+bonusStr;
                        
                        if(resposta.equals("SIM") || resposta.equals("S"))
                        {
                            if(classe.equals("Guerreiro"))
                                vidaMaxJogador += aleatorio(10)+bonusStr;
                            else if(classe.equals("Ladino"))
                                vidaMaxJogador += aleatorio(8)+bonusStr;
                            else
                                vidaMaxJogador += aleatorio(6)+bonusStr;
                        }
                        else
                        {
                            if(classe.equals("Guerreiro"))
                                vidaMaxJogador += 6+bonusStr;
                            else if(classe.equals("Ladino"))
                                vidaMaxJogador += 5+bonusStr;
                            else
                                vidaMaxJogador += 4+bonusStr;
                        }
                        
                        vidaJogador = vidaMaxJogador;
                        
                        if(!classe.equals("Guerreiro"))
                            CA += bonusDex;
                    
                        if(classe.equals("Guerreiro"))
                            {ataqueJogador += bonusStr; bonusDanoJogador = bonusStr;}
                        else if(classe.equals("Ladino"))
                            {ataqueJogador += bonusDex; bonusDanoJogador = bonusDex;}
                        else
                            {ataqueJogador += bonusInte; bonusDanoJogador = bonusInte;}
                    
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                        resposta = read.nextLine();
                    
                        limpaTela();
                    
                        ficha(inv, nomeSeparado, idade, classe, raca, antecedente, vidaMaxJogador, CA, str, bonusStr, dex, bonusDex, inte, bonusInte, moedas);
                    
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                        resposta = read.nextLine();
                        
                        limpaTela();
                    }
                            
                    if(contador == 20)
                        rodandoTrilha = false;
                }
                        
                if(vidaJogador > 0)
                {
                    limpaTela();
                    
                    texto = "Você finalmente chega no seu destino. \n";
                    typeWriter(texto, velocidadeTexto);
                    
                    System.out.println
                                 ("                                                           |>>> \n"
                                + "                   _                      _                | \n"
                                + "    ____________ .' '.    _____/----/-"+"\\"+" .' './========"+"\\"+"   / "+"\\"+"\n"
                                + "   //// ////// /V_.-._"+"\\"+"  |.-.-.|===| _ |-----| u    u |  /___"+"\\"+"\n"
                                + "  // /// // ///=="+"\\"+" u |.  || | ||===||||| |T| |   ||   | .| u |_ _ _ _ _ _ \n"
                                + " ///////-"+"\\"+"////===="+"\\"+"==|:::::::::::::::::::::::::::::::::::|u u| U U U U U \n"
                                + " |----/"+"\\"+"u |--|++++|..|'''''''''''::::::::::::::''''''''''|+++|+-+-+-+-+-+ \n"
                                + " |u u|u | |u ||||||..|              '::::::::'           |===|>=== _ _ == \n"
                                + " |===|  |u|==|++++|==|              .::::::::.           | T |....| V |.. \n"
                                + " |u u|u | |u ||HH||         "+"\\"+"|/    .::::::::::. \n"
                                + " |===|_.|u|_.|+HH+|_              .::::::::::::.              _ \n"
                                + "                __(_)___         .::::::::::::::.         ___(_)__ \n"
                                + "---------------/  / "+"\\"+"  /|       .:::::;;;:::;;:::.       |"+"\\"+"  / "+"\\"+"  "+"\\"+"------- \n"
                                + "______________/_______/ |      .::::::;;:::::;;:::.      | "+"\\"+"_______"+"\\"+"________ \n"
                                + "|       |     [===  =] /|     .:::::;;;::::::;;;:::.     |"+"\\"+" [==  = ]   | \n"
                                + "|_______|_____[ = == ]/ |    .:::::;;;:::::::;;;::::.    | "+"\\"+"[ ===  ]___|____ \n"
                                + "     |       |[  === ] /|   .:::::;;;::::::::;;;:::::.   |"+"\\"+" [=  ===] | \n"
                                + "_____|_______|[== = =]/ |  .:::::;;;::::::::::;;;:::::.  | "+"\\"+"[ ==  =]_|______ \n"
                                + " |       |    [ == = ] /| .::::::;;:::::::::::;;;::::::. |"+"\\"+" [== == ]      | \n"
                                + "_|_______|____[=  == ]/ |.::::::;;:::::::::::::;;;::::::.| "+"\\"+"[  === ]______|_ \n"
                                + "   |       |  [ === =] /.::::::;;::::::::::::::;;;:::::::."+"\\"+" [===  =]   | \n"
                                + "___|_______|__[ == ==]/.::::::;;;:::::::::::::::;;;:::::::."+"\\"+"[=  == ]___|_____ \n");
                            
                    System.out.println("Pressione ENTER ou digite qualquer coisa para continuar.");
                    resposta = read.nextLine();
                            
                    limpaTela();
                            
                    texto = "Antes que pudesse entrar na cidade, um guarda armadurado com uma alabarda interrompe sua entrada. \n";
                    typeWriter(texto, velocidadeTexto);
                            
                    System.out.println
                                 ("\t  ,   A           {} \n"
                                + "\t / "+"\\"+", | ,        .--. \n"
                                + "\t|    =|= >      /.--."+"\\"+" \n"
                                + "\t "+"\\"+" /` | `       |====| \n"
                                + "\t  `   |         |`::`|   \n"
                                + "\t      |     .-;`"+"\\"+"..../`;_.-^-._ \n"
                                + "\t     /"+"\\"+"\\"+"/  /  |...::..|`   :   `| \n"
                                + "\t     |:'"+"\\"+" |   /'''::''|   .:.   | \n"
                                + "\t      "+"\\"+" /"+"\\"+";-,/"+"\\"+"   ::  |..:::::..| \n"
                                + "\t      |"+"\\"+" <` >  >._::_.| ':::::' | \n"
                                + "\t      | `\"\"`  /   ^^  |   ':'   | \n"
                                + "\t      |       |       "+"\\"+"    :    / \n"
                                + "\t      |       |        "+"\\"+"   :   /  \n"
                                + "\t      |       |___/"+"\\"+"___|`-.:.-` \n"
                                + "\t      |        "+"\\"+"_ || _/    ` \n"
                                + "\t      |        <_ >< _> \n"
                                + "\t      |        |  ||  | \n"
                                + "\t      |        |  ||  | \n"
                                + "\t      |       _"+"\\"+".:||:./_ \n"
                                + "\t      |      /____/"+"\\"+"____"+"\\");
                            
                    texto = "\nPrimeiramente, ele lhe faz uma pergunta. \n"
                            + "'Por que está querendo entrar?'";
                    typeWriter(texto, velocidadeTexto);
                            
                    System.out.println("\n\nComo deseja responder?");
                    System.out.println("\n1 - Entregar carta \n2 - Falar sobre o Conde de Feist \n");
                    opcao = read.nextInt();
                    
                    while(opcao < 1 || opcao > 3)
                    {
                        System.out.println("\nVamos direto ao assunto, né?");
                        System.out.println("\nComo deseja responder?");
                        System.out.println("\n1 - Entregar carta \n2 - Falar sobre o Conde de Feist \n");
                        opcao = read.nextInt();
                    }
                    
                    switch(opcao)
                    {
                        case 1:
                            texto = "\nVocê entrega a carta para ele. \n\n"
                                    + "O guarda confere o selo e rapidamente entende do que se trata. \n"
                                    + "Logo, você é recompensado com as devidas moedas. \n"
                                    + "'Obrigado pelo seu serviço.' \n\n";
                            typeWriter(texto, velocidadeTexto);
                            
                            if(budget <= 0)
                            {
                                texto = "Mas é uma pena, você recebe nada na verdade. \n"
                                        + "Pelo menos fez um bom investimento em si mesmo comprando tantos equipamentos.";
                                typeWriter(texto, velocidadeTexto);
                            }
                            else
                            {
                                System.out.println("Você obteve "+budget+" moedas.");
                                moedas += budget;
                            }
                        
                            System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                            read.nextLine();
                            resposta = read.nextLine();
                            
                            limpaTela();
                        
                            texto = "Tendo terminado a missão, você novamente volta a perambular por aí. \n"
                                    + "Até encontrar mais uma vez alguma aventura como esta.";
                            typeWriter(texto, velocidadeTexto);
                        
                            System.out.println("\n\nParabéns! Você terminou o jogo! \n\nFinal 1 de 6");
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                            resposta = read.nextLine();
                            rodandoParte3 = false;
                        break;
                        
                        case 2:
                            texto = "\nVocê conta sobre o Conde e que precisa encontrar com ele. \n\n"
                                    + "O guarda questiona os seus motivos. \n"
                                    + "Com isso, você só mostra a carta para ele. \n\n"
                                    + "'Ah, foi-me avisado que algum mensageiro viria.' \n"
                                    + "'Não esperava que fosse um aventureiro.' \n"
                                    + "'Enfim, aqui está suas moedas.' \n\n";
                            typeWriter(texto, velocidadeTexto);
                            
                            if(budget <= 0)
                            {
                                texto = "Mas é uma pena, você recebe nada na verdade. \n"
                                        + "Pelo menos fez um bom investimento em si mesmo comprando tantos equipamentos.";
                                typeWriter(texto, velocidadeTexto);
                            }
                            else
                            {
                                System.out.println("Você obteve "+budget+" moedas.");
                                moedas += budget;
                            }
                        
                            System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                            read.nextLine();
                            resposta = read.nextLine();
                            
                            limpaTela();
                        
                            texto = "Tendo terminado a missão, você novamente volta a perambular por aí. \n"
                                    + "Até encontrar mais uma vez alguma aventura como esta.";
                            typeWriter(texto, velocidadeTexto);
                        
                            System.out.println("\n\nParabéns! Você terminou o jogo! \n\nFinal 1 de 6");
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                            resposta = read.nextLine();
                            rodandoParte3 = false;
                        break;
                                    
                        default:
                            texto = "\nParabéns! Você achou um segredo! \n"
                                    + "Apesar de não ser nada favorável para você. \n"
                                    + "Pois você acaba de começar um combate com o guarda.";
                            typeWriter(texto, velocidadeTexto);
                            
                            System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                            read.nextLine();
                            resposta = read.nextLine();
                            
                            inimigo = "Guarda";
                            resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+8, 16, 5, 3, 10);
                            vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                            
                            vidaJogador = combate(vidaMaxJogador, velocidadeTexto, inv, rodandoCombate, classe, inimigo, vidaInimigo, bonusAtaqueInimigo, bonusDanoInimigo, indicieDanoInimigo, CAInimigo, vidaJogador, ataqueJogador, danoJogador, bonusDanoJogador, indicieDanoJogador, CA, bonusDex);
                                    
                            if(vidaJogador > 0)
                            {
                                texto = "\nVocê não tem a mínima ideia do porquê fez isso. \n"
                                        + "Mas agora terá que escolher entre perpetuar esse caminho ou render-se antes que piore.";
                                typeWriter(texto, velocidadeTexto);
                                
                                System.out.println("\n1 - Continuar \n2 - Parar \n");
                                opcao = read.nextInt();
                                    
                                while(opcao < 1 || opcao > 2)
                                {
                                    System.out.println("\nNão vai ter dois segredos seguidos.");
                                    System.out.println("\n1 - Continuar \n2 - Parar \n");
                                    opcao = read.nextInt();
                                }
                                            
                                if(opcao == 1)
                                {
                                    texto = "\nVocê escolheu ser um fora da lei procurado por incomodar a guarnição. \n\n"
                                            + "Final 4 de 6";   
                                    typeWriter(texto, velocidadeTexto);
                                    System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                                    read.nextLine();
                                    resposta = read.nextLine();
                                    rodandoParte3 = false;
                                }
                                else
                                {
                                    texto = "\nVocê foi preso na cena do crime, agora tendo que passar algum tempo numa prisão. \n\n"
                                            + "Final 5 de 6";
                                    typeWriter(texto, velocidadeTexto);
                                    System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                                    read.nextLine();
                                    resposta = read.nextLine();
                                    rodandoParte3 = false;
                                }
                            }
                            else if(vidaJogador <= 0 && inv.contains("Poção de Cura Retardada"))
                            {
                                System.out.println("\nSó que não!");
                                System.out.println("\nA poção fez efeito e você recupera metade dos seus pontos de vida.");
                                vidaJogador += vidaMaxJogador / 2;
                                inv.remove("Poção de Cura Retardada");
                            
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                            }
                            else
                            {
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                                resposta = read.nextLine();
                                rodandoParte3 = false;
                            }
                    }
                }
                else
                {
                    System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                    resposta = read.nextLine();
                }
            }
            else
            {
                texto = "Assim que você entra nestas ruínas de pedra, você se vê diante de uma escada que desce. \n"
                        + "Mas antes que pudesse descê-las, no mesmo instante um papel velho cai aos seus pés. \n"
                        + "Você visualiza e parece ser um mapa de um calabouço.";
                typeWriter(texto, velocidadeTexto);
                
                System.out.println("\n\nVocê obteve Mapa da Masmorra.");
                inv.add("Mapa da Masmorra");
                
                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                resposta = read.nextLine();
                        
                limpaTela();
                
                texto = "Após descer as escadas, você enxerga uma porta já aberta. \n"
                        + "Ao passar por ela, ela imediatamente fecha-se te aprisionando.";
                typeWriter(texto, velocidadeTexto);
                
                System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                resposta = read.nextLine();
                
                limpaTela();
                
                String m[][] =
                           {{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
                            {"#", "S", ".", ".", ".", ".", ".", ".", "D", "#", ".", "M", ".", "M", ".", ".", "D", "M", "?", "#"},
                            {"#", "T", ".", ".", ".", ".", ".", ".", ".", "P", "B", ".", "M", "M", ".", ".", ".", "M", "M", "#"},
                            {"#", "T", ".", ".", ".", ".", ".", ".", "#", "#", "M", "M", ".", "M", ".", ".", ".", "M", ".", "#"},
                            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "M", ".", ".", ".", ".", ".", "M", ".", "M", "#"},
                            {"#", "#", "#", "D", ".", ".", ".", "#", "#", "#", "M", "M", "M", "M", ".", ".", "#", "P", "#", "#"},
                            {"#", ".", ".", ".", ".", ".", ".", "#", "#", "#", ".", ".", "M", ".", "M", "#", "#", ".", ".", "#"},
                            {"#", ".", ".", ".", ".", ".", "N", "?", "#", "#", ".", ".", ".", "M", "#", "#", "M", "M", "M", "#"},
                            {"#", "P", "-", "-", "-", "-", "-", "-", "#", "#", ".", ".", ".", "M", "#", ".", "M", ".", ".", "#"},
                            {"#", "M", "M", ".", "M", ".", ".", "M", "M", "#", "M", ".", ".", "#", "#", ".", ".", "M", ".", "#"},
                            {"#", "M", ".", "M", "M", ".", "M", "M", ".", "P", ".", "M", ".", "#", ".", ".", ".", ".", "M", "#"},
                            {"#", "#", ".", "M", ".", ".", ".", "M", ".", "#", "M", ".", "D", "#", ".", "M", "M", "M", "D", "#"},
                            {"#", "#", "M", ".", ".", ".", ".", "#", "#", "#", "#", "#", "#", "#", "#", "#", "P", "#", "#", "#"},
                            {"#", "#", "#", ".", ".", ".", "P", ".", "M", ".", ".", ".", ".", "#", "#", "#", "M", ".", ".", "#"},
                            {"#", "#", "#", "P", "#", "#", ".", "M", ".", ".", ".", ".", ".", ".", "#", "#", "?", "M", ".", "#"},
                            {"#", "#", ".", "M", ".", "#", "M", ".", ".", "M", ".", ".", ".", "M", "#", ".", "M", ".", "M", "#"},
                            {"#", ".", ".", ".", ".", "#", ".", ".", "M", ".", "M", ".", "M", "M", "P", ".", ".", "M", ".", "#"},
                            {"#", ".", "M", "M", ".", "#", "#", ".", ".", ".", ".", ".", "M", "M", "#", ".", ".", ".", "M", "#"},
                            {"#", ".", "M", "?", "M", "#", "#", "#", ".", ".", ".", ".", "?", "#", "#", "#", ".", ".", ".", "#"},
                            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}};
                boolean rodandoMasmorra = true;
        
                String jogador = "J";
                int x = 0, y = 0, jogadorX = 0, jogadorY = 0, contadorMimico = 1;
        
                m[18][10] = jogador;
        
                while(rodandoMasmorra)
                {
                    limpaTela();
            
                    jogadorX = 0; jogadorY = 0;
            
                    for(int i = 0; i < 20; i++)
                    {
                        for(int j = 0; j < 20; j++)
                        {
                            System.out.print(m[i][j]+" ");
                        }
                        System.out.println("");
                    }
            
                    for (int i = 0; i < 20; i++)
                    {
                        for (int j = 0; j < 20; j++)
                        {
                            if(m[i][j].equals(jogador))
                            {
                                y = i; 
                                x = j;
                            }
                        }
                    }
            
                    System.out.println("\nLEGENDA");
                    System.out.println("\nJ - Jogador | M - Monstro | P - Porta | S - Saída | D - Locais de Descanso | ? - Item | # - Parede | . - Vazio");
                    System.out.println("\nSTATUS");
                    System.out.println("Pontos de Vida Máximo: "+vidaMaxJogador);
                    System.out.println("Pontos de Vida Atual: "+vidaJogador);
                    System.out.println("\nPara onde deseja ir?");
                    System.out.println("\nW - Cima | A - Esquerda | S - Baixo | D - Direita \n");
                    resposta = read.nextLine().toUpperCase();
            
                    while(!resposta.equals("W") && !resposta.equals("A") && !resposta.equals("S") && !resposta.equals("D"))
                    {
                        System.out.println("\nOpção inválida.");
                        System.out.println("\nPara onde deseja ir?");
                        System.out.println("\nW - Cima | A - Esquerda | S - Baixo | D - Direita \n");
                        resposta = read.nextLine().toUpperCase();
                    }
                    
                    switch(resposta)
                    {
                        case "W":{jogadorY = -1; jogadorX = 0;}break;
                        case "S":{jogadorY = 1; jogadorX = 0;}break;
                        case "A":{jogadorY = 0; jogadorX = -1;}break;
                        default:{jogadorY = 0; jogadorX = 1;}
                    }
            
                    if(y+jogadorY >= 0 && y+jogadorY < 20 && x+jogadorX >= 0 && x+jogadorX < 20)
                    {
                        if(m[y+jogadorY][x+jogadorX].equals("#") || m[y+jogadorY][x+jogadorX].equals("-"))
                        {
                            System.out.println("\nVocê não pode se mover para cá.");
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                            resposta = read.nextLine();
                        }
                        else if(m[y+jogadorY][x+jogadorX].equals("M"))
                        {
                            m[y][x] = " ";
                            y = y+jogadorY;
                            x = x+jogadorX;
                            m[y][x] = jogador;
                    
                            String inimigos[] = {"Aranha Gigante", "Zumbi", "Esqueleto", "Morcego Gigante", "Rato Gigante", "Slime"};
                            inimigo = inimigos[aleatorio(inimigos.length-1)];
                    
                            ultimaLetra = inimigo.charAt(inimigo.length()-1);
                    
                            switch(inimigo)
                            {
                                case "Aranha Gigante": resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+4, 14, 5, 3, 8); ultimaLetra = 'a'; break;
                                case "Zumbi": resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8))+9, 8, 3, 1, 6); break;
                                case "Esqueleto": resultado = valoresInimigo((aleatorio(8)+aleatorio(8))+4, 13, 4, 2, 6); break;
                                case "Morcego Gigante": resultado = valoresInimigo(aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10), 13, 4, 2, 6); break;
                                case "Rato Gigante": resultado = valoresInimigo(aleatorio(6)+aleatorio(6), 12, 4, 2, 4); break;
                                default: resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+12, 8, 4, 2, 6);
                            }
                    
                            if(ultimaLetra == 'a')
                                texto = "\nVocê se depara com uma "+inimigo+"! \n\n";
                            else
                                texto = "\nVocê se depara com um "+inimigo+"! \n\n";
                            typeWriter(texto, velocidadeTexto);
                    
                            vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    
                            vidaJogador = combate(vidaMaxJogador, velocidadeTexto, inv, rodandoCombate, classe, inimigo, vidaInimigo, bonusAtaqueInimigo, bonusDanoInimigo, indicieDanoInimigo, CAInimigo, vidaJogador, ataqueJogador, danoJogador, bonusDanoJogador, indicieDanoJogador, CA, bonusDex);

                            if(vidaJogador <= 0)
                            {
                                rodandoMasmorra = false;
                                rodandoParte3 = false;
                            }
                        }
                        else if(m[y+jogadorY][x+jogadorX].equals("D"))
                        {
                            m[y][x] = " ";
                            y = y+jogadorY;
                            x = x+jogadorX;
                            m[y][x] = jogador;
                    
                            System.out.println("\nVocê recuperou totalmente seus pontos de vida!");
                            vidaJogador = vidaMaxJogador;
                    
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                            resposta = read.nextLine();
                        }
                        else if(m[y+jogadorY][x+jogadorX].equals("B"))
                        {
                            m[y][x] = " ";
                            y = y+jogadorY;
                            x = x+jogadorX;
                            m[y][x] = jogador;
                    
                            texto = "\nVocê finalmente alcança o tal do necromante. \n"
                                    + "Só que ele já estava preparando um formidável inimigo para você enfrentar. \n\n"
                                    + "Um enorme ogro zumbi ergue-se com vida enquanto o necromante fica em cima dele.";
                            typeWriter(texto, velocidadeTexto);
                    
                            System.out.println("\n\nPressione ENTER ou digite qualquer coisa para lutar contra o Chefe.");
                            resposta = read.nextLine();
                    
                            inimigo = "Ogro Zumbi";
                            resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+36, 8, 6, 4, 12);
                            vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    
                            vidaJogador = combate(vidaMaxJogador, velocidadeTexto, inv, rodandoCombate, classe, inimigo, vidaInimigo, bonusAtaqueInimigo, bonusDanoInimigo, indicieDanoInimigo, CAInimigo, vidaJogador, ataqueJogador, danoJogador, bonusDanoJogador, indicieDanoJogador, CA, bonusDex);
                    
                            if(vidaJogador > 0)
                            {
                                texto = "Você destrói o grande ogro zumbi e, consequentemente, levando o necromante junto. \n"
                                        + "Porém, chegando perto de onde ele caiu, já desapareceu num instante. \n\n"
                                        + "Dando de ombros pela situação, você continua seu caminho.";
                                typeWriter(texto, velocidadeTexto);
                                
                                System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                                
                                texto = "\n'Achou que havia acabado?' \n"
                                        + "O necromante retira o manto. \n\n"
                                        + "E mostra presas e garras como a de um vampiro. \n"
                                        + "Você volta e prepara-se para mais um combate.";
                                typeWriter(texto, velocidadeTexto);
                                
                                System.out.println("\n\nPressione ENTER ou digite qualquer coisa para lutar contra o Chefe.");
                                resposta = read.nextLine();
                                
                                inimigo = "Necromante";
                                resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+33, 15, 6, 3, 8);
                                vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    
                                vidaJogador = combate(vidaMaxJogador, velocidadeTexto, inv, rodandoCombate, classe, inimigo, vidaInimigo, bonusAtaqueInimigo, bonusDanoInimigo, indicieDanoInimigo, CAInimigo, vidaJogador, ataqueJogador, danoJogador, bonusDanoJogador, indicieDanoJogador, CA, bonusDex);
                                
                                if(vidaJogador > 0)
                                {
                                    texto = "Você finalmente derrota este necromante, mas ele misteriosamente desaparece na sua frente. \n"
                                            + "Parece que você eventualmente vá se encontrar com ele futuramente. \n"
                                            + "Mas hora de receber os tesouros.";
                                    typeWriter(texto, velocidadeTexto);
                                    
                                    System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                                    resposta = read.nextLine();
                                }
                                else
                                {
			            System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                                    resposta = read.nextLine();
                                    rodandoMasmorra = false;
                                    rodandoParte3 = false;
                                }
                            }
                            else
                            {
				System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                                resposta = read.nextLine();
                                rodandoMasmorra = false;
                                rodandoParte3 = false;
                            }
                        }
                        else if(m[y+jogadorY][x+jogadorX].equals("N"))
                        {
                            texto = "\nUm enorme esqueleto de minotauro está guardando um precioso item atrás dele. \n"
                                    + "Você não consegue passar, a não ser que suba nos ossos.";
                            typeWriter(texto, velocidadeTexto);
                            
                            System.out.println("\n\nO que decide fazer?");
                            System.out.println("\n1 - Vou querer o item \n2 - Deixa pra lá \n");
                            opcao = read.nextInt();
                            
                            while(opcao < 1 || opcao > 2)
                            {
                                System.out.println("\nNem tente outras coisas.");
                                System.out.println("\n\nO que decide fazer?");
                                System.out.println("\n1 - Vou querer o item \n2 - Deixa pra lá \n");
                                opcao = read.nextInt();
                            }
                            
                            if(opcao == 1)
                            {
                                m[y][x] = " ";
                                y = y+jogadorY;
                                x = x+jogadorX;
                                m[y][x] = jogador;
                                
                                chance = aleatorio(2);
                                if(chance == 1)
                                {
                                    texto = "\nEra óbvio que ele ia despertar. \n"
                                            + "Você está diante de um minotauro esquelético!";
                                    typeWriter(texto, velocidadeTexto);
                                    
                                    System.out.println("\n\nPressione ENTER ou digite qualquer coisa para lutar contra Chefe.");
                                    read.nextLine();
                                    resposta = read.nextLine();
                                    
                                    inimigo = "Esqueleto de Minotauro";
                                    resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+18, 12, 6, 4, 12);
                                    vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    
                                    vidaJogador = combate(vidaMaxJogador, velocidadeTexto, inv, rodandoCombate, classe, inimigo, vidaInimigo, bonusAtaqueInimigo, bonusDanoInimigo, indicieDanoInimigo, CAInimigo, vidaJogador, ataqueJogador, danoJogador, bonusDanoJogador, indicieDanoJogador, CA, bonusDex);
                    
                                    if(vidaJogador > 0)
                                    {
                                        System.out.println("Você derrotou o Chefe!");
                                        System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                        resposta = read.nextLine();
                                    }
                                    else
                                    {
                                        System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                                        resposta = read.nextLine();
                                        rodandoMasmorra = false;
                                        rodandoParte3 = false;
                                    }
                                }
                                else
                                {
                                    texto = "\nPor incrível que pareça, o esqueleto não despertou para te arregaçar.";
                                    typeWriter(texto, velocidadeTexto);
                                    
                                    System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                                    read.nextLine();
                                    resposta = read.nextLine();
                                }
                            }
                            else
                            {
                                m[y][x] = "N";
                                m[y][x-1] = jogador;
                            }
                        }
                        else if(m[y+jogadorY][x+jogadorX].equals("?"))
                        {
                            m[y][x] = " ";
                            y = y+jogadorY;
                            x = x+jogadorX;
                            m[y][x] = jogador;
                            
                            if(m[y][x] == m[18][3])
                            {
                                System.out.println("\nVocê obteve Espada da Luz Lunar");
                                System.out.println("\nEsta espada pode ser usada por qualquer classe.");
                                inv.add("Espada da Luz Lunar");
                                
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                            }
                            else if(m[y][x] == m[18][12])
                            {
                                System.out.println("\nVocê obteve 10 Poções de Cura.");
                                inv.add("Poção de Cura"); inv.add("Poção de Cura"); inv.add("Poção de Cura"); inv.add("Poção de Cura"); inv.add("Poção de Cura"); inv.add("Poção de Cura"); inv.add("Poção de Cura"); inv.add("Poção de Cura"); inv.add("Poção de Cura"); inv.add("Poção de Cura");
                               
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                            }
                            else if(m[y][x] == m[14][16])
                            {
                                System.out.println("\nVocê obteve Anel Vampírico.");
                                System.out.println("\nEste anel regenera vida conforme você acerta ataques.");
				inv.add("Anel Vampírico");				

                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                            }
                            else if(m[y][x] == m[7][7])
                            {
                                System.out.println("\nVocê obteve Anel do Ataque Bestial.");
                                System.out.println("\nEste anel concede um bônus no dano em ataques sucessivos.");
                                inv.add("Anel do Ataque Bestial");
                                
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                            }
                            else if(m[y][x] == m[1][18])
                            {
                                System.out.println("\nVocê obteve Capa Dissimuladora");
                                System.out.println("\nEsta capa concede um aumento na sua Armadura.");
                                inv.add("Capa Dissimuladora");
                                
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                            }
                        }
                        else if(m[y+jogadorY][x+jogadorX].equals("T"))
                        {
                            m[y][x] = " ";
                            y = y+jogadorY;
                            x = x+jogadorX;
                            m[y][x] = jogador;
                            
                            texto = "\nVocê está diante de dois báus. \n";
                            typeWriter(texto, velocidadeTexto);
                                
                            if(m[y][x] == m[2][1])
                            {
                                texto = "Mas optou o báu da direita.";
                                typeWriter(texto, velocidadeTexto);
                                
                                texto = "\n\nAo abrir tal baú de tesouros, você se depara com uma surpresa. \n"
                                        + "Dentes afiados, uma enorme língua, longos braços e pernas aparecerem. \n\n"
                                        + "Você engaja em combate.";
                                typeWriter(texto, velocidadeTexto);
                                
                                System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                               
                                inimigo = "Baú Mímico";
                                resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+18, 12, 5, 3, 8);
                                vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    
                                vidaJogador = combate(vidaMaxJogador, velocidadeTexto, inv, rodandoCombate, classe, inimigo, vidaInimigo, bonusAtaqueInimigo, bonusDanoInimigo, indicieDanoInimigo, CAInimigo, vidaJogador, ataqueJogador, danoJogador, bonusDanoJogador, indicieDanoJogador, CA, bonusDex);
                              
                                if(vidaJogador > 0)
                                {
                                    System.out.println("Você o derrota e obteve Símbolo da Avareza.");
                                    inv.add("Símbolo da Avareza");

                                    System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                    resposta = read.nextLine();
                                }
                                else
                                {
                                    System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                                    resposta = read.nextLine();
                                    rodandoMasmorra = false;
                                    rodandoParte3 = false;
                                }
                            }
                            else if(m[y][x] == m[3][1])
                            {
                                texto = "Mas optou o báu da esquerda.";
                                typeWriter(texto, velocidadeTexto);
                                
                                texto = "\n\nAbrindo o baú, você se depara com muita riqueza acumulada.";
                                typeWriter(texto, velocidadeTexto);
                                   
                                System.out.println("\n\nVocê obteve 1000 moedas.");
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                                moedas += 1000;
                            }
                        }
			else if(m[y+jogadorY][x+jogadorX].equals("S"))
			{
			    m[y][x] = " ";
			    y = y+jogadorY;
			    x = x+jogadorX;
			    m[y][x] = jogador;

			    limpaTela();

                                texto = "Você finalmente sai dessa masmorra. \n"
                                        + "Subindo as escadas, você enxerga o pôr do sol. \n"
                                        + "E muitas aventuras como essa irão chegar.";
                                typeWriter(texto, velocidadeTexto);
                                
                                System.out.println
                                             ("\n\n            ^^                   @@@@@@@@@ \n"
                                            + "       ^^       ^^            @@@@@@@@@@@@@@@ \n"
                                            + "                            @@@@@@@@@@@@@@@@@@              ^^ \n"
                                            + "                           @@@@@@@@@@@@@@@@@@@@ \n"
                                            + " ~~~~ ~~ ~~~~~ ~~~~~~~~ ~~ &&&&&&&&&&&&&&&&&&&& ~~~~~~~ ~~~~~~~~~~~ ~~~ \n"
                                            + " ~         ~~   ~  ~       ~~~~~~~~~~~~~~~~~~~~ ~       ~~     ~~ ~ \n"
                                            + "   ~      ~~      ~~ ~~ ~~  ~~~~~~~~~~~~~ ~~~~  ~     ~~~    ~ ~~~  ~ ~~ \n"
                                            + "   ~  ~~     ~         ~      ~~~~~~  ~~ ~~~       ~~ ~ ~~  ~~ ~ \n"
                                            + " ~  ~       ~ ~      ~           ~~ ~~~~~~  ~      ~~  ~             ~~ \n"
                                            + "       ~             ~        ~      ~      ~~   ~             ~");
                                
                                System.out.println("\nParabéns! Você terminou o jogo! \n\nFinal 2 de 6");
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                                resposta = read.nextLine();
                                rodandoMasmorra = false;
                                rodandoParte3 = false;
			}
                        else
                        {
                            m[y][x] = " ";
                            y = y+jogadorY; 
                            x = x+jogadorX;
                            m[y][x] = jogador;
                        }
                    }
                    else
                    {
                        System.out.println("\nNão é um movimento possível.");
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                        resposta = read.nextLine();
                    }
                }
            }
        }
        }
    }
    
    //Funções
    public static void limpaTela() throws IOException, InterruptedException
    {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }
    
    public static void typeWriter(String texto, int velocidadeTexto)
    {
        for(int i = 0; i < texto.length(); i++)
        {
            System.out.print(texto.charAt(i));
            try
            {
                Thread.sleep(velocidadeTexto);
            }
            catch(InterruptedException e)
            {}
        }
    }
    
    public static void ficha(List<String> inv, String[] nomeSeparado, int idade, String classe, String raca, String antecedente, int vidaMaxJogador, int CA, int str, int bonusStr, int dex, int bonusDex, int inte, int bonusInte, int moedas)
    {
        System.out.println("FICHA DO PERSONAGEM");
        System.out.print("Nome: ");
        
        for (int i = 0; i < nomeSeparado.length; i++)
        {
            System.out.print(nomeSeparado[i]+" ");
        }
        
        System.out.println("\nIdade: "+idade+"\nClasse: "+classe+"\nRaça: "+raca+"\nAntecedente: "+antecedente);       
        System.out.println("\nATRIBUTOS");
        System.out.println("Pontos de Vida: "+vidaMaxJogador+"\nArmadura: "+CA+"\nForça: "+str+" [+"+bonusStr+"] \nDestreza: "+dex+" [+"+bonusDex+"] \nInteligência: "+inte+" [+"+bonusInte+"] \n\nMoedas: "+moedas);
        System.out.println("\nInventário: "+inv);
    }
    
    public static int aleatorio(int i)
    {
        Random sort = new Random();
        return sort.nextInt(i)+1;
    }
    
    public static int[] valoresInimigo(int vidaInimigo, int CAInimigo, int bonusAtaqueInimigo, int bonusDanoInimigo, int indicieDanoInimigo)
    {
        int resultado[] = new int[5];
        resultado[0] = vidaInimigo;
        resultado[1] = CAInimigo;
        resultado[2] = bonusAtaqueInimigo;
        resultado[3] = bonusDanoInimigo;
        resultado[4] = indicieDanoInimigo;
        return resultado;
    }
    
    public static int descanso(boolean rodandoDescanso, int vidaJogador, int vidaMaxJogador) throws IOException, InterruptedException
    {
        Scanner read = new Scanner(System.in);
        int opcao = 0;
        String resposta;
        
        while(rodandoDescanso)
        {
            System.out.println("DESCANSO");
            System.out.println("\nSTATUS");
            System.out.println("Pontos de Vida Máxima: "+vidaMaxJogador);
            System.out.println("Pontos de Vida Atual: "+vidaJogador+"\n");
            System.out.println
                         ("        ______ \n"
                        + "       /     /\\ \n"
                        + "      /     /  \\ \n"
                        + "     /_____/----\\_    (   \n"
                        + "    \"     \"          ).   \n"
                        + "   _ ___          o (:') o    \n"
                        + "  (@))_))        o ~/~~\\~ o    \n"
                        + "                  o  o  o \n");
            System.out.println("1 - Continuar \n2 - Descansar \n");
            opcao = read.nextInt();
            
            while(opcao < 1 || opcao > 2)
            {
                System.out.println("\nSó tem isso para fazer. Trabalho acima do lazer.");
                System.out.println("\nDESCANSO");
                System.out.println("\n1 - Continuar \n2 - Descansar \n");
                opcao = read.nextInt();
            }
            
            if(opcao == 1)
                rodandoDescanso = false;
            else
            {
                System.out.println("\nVocê descansa e recupera toda a sua vida.");
                vidaJogador = vidaMaxJogador;
                
                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                read.nextLine();
                resposta = read.nextLine();
                
                rodandoDescanso = false;
            }
        }
        return vidaJogador;
    }
    
    public static int recuperarVida(List<String> inv, int vidaJogador)
    {
        Scanner read = new Scanner(System.in);
        int vidaCurada;
        String resposta;
        
        if(inv.contains("Poção de Cura"))
        {
            vidaCurada = (aleatorio(6)+aleatorio(6))+2;
            System.out.println("\nVocê recupera "+vidaCurada+" de vida.");
            vidaJogador += vidaCurada;
                            
            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
            resposta = read.nextLine();
                            
            removerPocao(inv);
        }
        else
        {
            System.out.println("\nVocê não tem poções de cura.");
            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
            resposta = read.nextLine();
        }
        return vidaJogador;
    }
    
    public static List<String> removerPocao(List<String> inv)
    {
        inv.remove("Poção de Cura");
        return inv;
    }
    
    public static int combate(int vidaMaxJogador, int velocidadeTexto, List<String> inv, boolean rodandoCombate, String classe, String inimigo, int vidaInimigo, int bonusAtaqueInimigo, int bonusDanoInimigo, int indicieDanoInimigo,  int CAInimigo, int vidaJogador, int ataqueJogador, int danoJogador, int bonusDanoJogador,int indicieDanoJogador, int CA, int bonusDex) throws IOException, InterruptedException
    {
        Scanner read = new Scanner(System.in);
        
        int opcao, turno, chance, dado, vidaMaxInimigo, ataqueInimigo, danoInimigo, vidaCurada, danoExtra, sequencia = 0, danoAtaqueFurtivo;
        char ultimaLetra = inimigo.charAt(inimigo.length()-1);
        String resposta, texto;
        
        vidaMaxInimigo = vidaInimigo;
        
        if(inimigo.equals("Cocatriz") || inimigo.equals("Vespa Gigante") || inimigo.equals("Hiena Gigante") || inimigo.equals("Cobra Constritora Gigante"))
            ultimaLetra = 'a';
        
        if(inimigo.equals("Guarda"))
            ultimaLetra = 'o';
        
        if(inv.contains("Capa Dissimuladora"))
            CA++;
        
        if(inv.contains("Espada da Luz Lunar"))
            indicieDanoJogador = 12;
        
        while(rodandoCombate)
        {
            turno = 1;
            if(ultimaLetra == 'a')
                System.out.println("Uma "+inimigo+" é seu inimigo. \n");
            else
                System.out.println("Um "+inimigo+" é seu inimigo. \n");
            
            while(vidaInimigo > 0)
            {
                chance = 0;
                dado = aleatorio(20);
                ataqueJogador = dado+bonusDanoJogador;
                danoJogador = aleatorio(indicieDanoJogador)+bonusDanoJogador;
                danoAtaqueFurtivo = aleatorio(6)+aleatorio(6);
                danoExtra = aleatorio(6);
                
                if(inv.contains("Anel do Ataque Bestial"))
                {
                    if(sequencia == 1)
                        danoJogador++;
                    else if(sequencia == 2)
                        danoJogador += 2;
                    else if(sequencia >= 3)
                        danoJogador += 3;
                }
                
                ataqueInimigo = aleatorio(20)+bonusAtaqueInimigo;
                danoInimigo = aleatorio(indicieDanoInimigo)+bonusDanoInimigo;
                
                System.out.println("Turno: "+turno+"\nPontos de Vida do Inimigo: "+vidaInimigo+"\nSeus Pontos de Vida: "+vidaJogador+"\n\nO que deseja fazer? \n\n1 - Atacar \n2 - Usar Poção de Cura \n3 - Fugir \n");
                opcao = read.nextInt();
                
                while(opcao < 1 || opcao > 3)
                {
                    System.out.println("\nOpção Inválida.");
                    System.out.println("\nO que deseja fazer?");
                    System.out.println("\n1 - Atacar \n2 - Usar Poção de Cura \n3 - Fugir \n");
                    opcao = read.nextInt();
                }
                 
                switch(opcao)
                {
                    case 1:
                        
                        if(classe.equals("Mago"))
                        {
                            System.out.println("\nQual magia deseja usar?");
                            System.out.println("\n1 - Raio de Fogo \n2 - Raio de Gelo \n");
                            opcao = read.nextInt();
                        
                            while(opcao < 1 || opcao > 2)
                            {
                                System.out.println("\nMagia indisponível.");
                                System.out.println("\nQual magia deseja usar?");
                                System.out.println("\n1 - Raio de Fogo \n2 - Raio de Gelo \n");
                                opcao = read.nextInt();
                            }
                        
                            if(opcao == 1)
                                danoJogador = aleatorio(10)+bonusDanoJogador;
                            else
                            {
                                danoJogador = aleatorio(8)+bonusDanoJogador;
                                chance = aleatorio(100);
                            }
                        }
                        
                        if(dado == 20)
                        {
                            System.out.println("\nCrítico! Todo seu dano é dobrado!");
                            danoJogador = danoJogador * 2;        
                            danoAtaqueFurtivo = danoAtaqueFurtivo * 2;
                            danoExtra = danoExtra * 2;
                        }
                        
                        if(ataqueJogador >= CAInimigo && chance < 50)
                        {
                            if(inv.contains("Espada da Luz Lunar") && classe.equals("Mago"))
                                danoJogador += danoExtra;
                            
                            if(classe.equals("Ladino") && vidaMaxInimigo == vidaInimigo)
                            {
                                System.out.println("\nComo o inimigo está com a vida cheia, você dá "+danoAtaqueFurtivo+" a mais de dano.");
                                vidaInimigo -= danoAtaqueFurtivo;
                            }
                            
                            if(ultimaLetra == 'a')
                                System.out.println("\nVocê ataca a "+inimigo+" e causa "+danoJogador+" de dano.");
                            else
                                System.out.println("\nVocê ataca o "+inimigo+" e causa "+danoJogador+" de dano.");
                            vidaInimigo -= danoJogador;
                            
                            if(inv.contains("Anel Vampírico") && vidaJogador < vidaMaxJogador)
                            {
                                vidaJogador++;
                                if(vidaJogador > vidaMaxJogador)
                                    vidaJogador = vidaMaxJogador;
                            }
                            
                            sequencia++;
                        }
                        else if(ataqueJogador >= CAInimigo && chance >= 50)
                        {
                            if(inv.contains("Espada da Luz Lunar") && classe.equals("Mago"))
                                danoJogador += danoExtra;
                            
                            if(ultimaLetra == 'a')
                                System.out.println("\nVocê ataca a "+inimigo+" e causa "+danoJogador+" de dano.");
                            else
                                System.out.println("\nVocê ataca o "+inimigo+" e causa "+danoJogador+" de dano.");
                            System.out.println("O inimigo é congelado, perdendo a vez.");
                            ataqueInimigo = 0;
                            vidaInimigo -= danoJogador;
                            
                            if(inv.contains("Anel Vampírico") && vidaJogador < vidaMaxJogador)
                            {
                                vidaJogador++;
                                if(vidaJogador > vidaMaxJogador)
                                    vidaJogador = vidaMaxJogador;
                            }
                            
                            sequencia++;
                        }
                        else
                        {
                            System.out.println("\nVocê erra o ataque.");
                            sequencia = 0;
                        }
                        
                        if(vidaInimigo > 0)
                        {   
                            if(ataqueInimigo >= CA)
                            {
                                if(ultimaLetra == 'a')
                                    System.out.println("\nA "+inimigo+" te acerta e causa "+danoInimigo+" de dano.");
                                else
                                    System.out.println("\nO "+inimigo+" te acerta e causa "+danoInimigo+" de dano.");
                                vidaJogador -= danoInimigo;

				if(inimigo.equals("Necromante"))
                            	{
                                	vidaCurada = danoInimigo/2;
                                	System.out.println("\nO necromante recupera "+vidaCurada+" de vida.");
                                	vidaInimigo += vidaCurada;
                            	}
                            }
                            else if(ataqueInimigo == 0)
                            {}
                            else
                            {
                                if(ultimaLetra == 'a')
                                    System.out.println("\nA "+inimigo+" erra o ataque.");
                                else
                                    System.out.println("\nO "+inimigo+" erra o ataque.");
                            }
                            
                            if(inimigo.equals("Ogro Zumbi") && turno % 3 == 0)
                            {
                                vidaCurada = aleatorio(12)+4;
                                System.out.println("\nO necromante recupera "+vidaCurada+" de vida do ogro");
                                vidaInimigo += vidaCurada;
                            }
                        }
                        else
                        {
                            if(ultimaLetra == 'a')
                                System.out.println("\nA "+inimigo+" é derrotada.");
                            else
                                System.out.println("\nO "+inimigo+" é derrotado.");
                            rodandoCombate = false;
                        }
                        
                        if(vidaJogador > 0 || vidaInimigo <= 0)
                        {
                           System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                           read.nextLine();
                           resposta = read.nextLine();
                           
                           limpaTela();
                        }
                        else
                        {
                            System.out.println("\nVocê morreu.");
                            vidaInimigo = 0;
                            rodandoCombate = false;
                        }
                        
                        turno++;
                    break;
                        
                    case 2:
                        vidaJogador = recuperarVida(inv, vidaJogador);
                    break;
                    
                    default:
                        dado += bonusDex;
                        texto = "\nVocê tenta fugir...";
                        typeWriter(texto, velocidadeTexto);
                        if(dado >= 15)
                        {
                            System.out.print(" Você conseguiu!");
                            rodandoCombate = false;
                            vidaInimigo = 0;
                                
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                            read.nextLine();
                            resposta = read.nextLine();
                        }
                        else
                        {
                            System.out.print(" Você falhou. \n");
                                
                            if(ataqueInimigo >= CA)
                            {
                                if(ultimaLetra == 'a')
                                    System.out.println("\nA "+inimigo+" te acerta e causa "+danoInimigo+" de dano.");
                                else
                                    System.out.println("\nO "+inimigo+" te acerta e causa "+danoInimigo+" de dano.");
                                vidaJogador -= danoInimigo;
                            }
                            else
                            {
                                if(ultimaLetra == 'a')
                                    System.out.println("\nA "+inimigo+" erra o ataque.");
                                else
                                    System.out.println("\nO "+inimigo+" erra o ataque.");
                            }
                                
                            if(vidaJogador <= 0)
                            {
                                System.out.println("\nVocê morreu.");
                                vidaInimigo = 0;
                                rodandoCombate = false;
                            }
                            
                            turno++;
                        }
                }
            }
        }
        return vidaJogador;
    }
    
    public static void carta()
    {
        System.out.println(
                "\t   ______________________________ \n"+
                "\t / \\                             \\. \n"+
                "\t|   | Peço que entregue esta     |. \n"+
                "\t \\_ | carta para o Conde de Feist|. \n"+
                "\t    | que fica ao Norte.         |. \n"+
                "\t    |                            |. \n"+
                "\t    | O caminho está repleto de  |. \n"+
                "\t    | monstros, vá à Botalar     |. \n"+
                "\t    | Ferrarias e à Casa do      |. \n"+
                "\t    | Verde. Não exacerba nas    |. \n"+
                "\t    | compras, o orçamento está  |. \n"+
                "\t    | previsto em 1000 moedas.   |. \n"+
                "\t    |                            |. \n"+
                "\t    | Se gastar tudo ou mais do  |. \n"+
                "\t    | que deveria, não terá      |. \n"+
                "\t    | recompensa.                |. \n"+
                "\t    |                            |. \n"+
                "\t    | Jamais olhe o conteúdo da  |. \n"+
                "\t    | carta, senão irá morrer.   |. \n"+
                "\t    |                            |. \n"+
                "\t    | - Duque Deterroui          |. \n"+
                "\t    |   _________________________|___ \n"+
                "\t    |  /                            /. \n"+
                "\t    \\_/dc__________________________/. \n");
    }
}