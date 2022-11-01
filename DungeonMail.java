import java.util.*; //Importa��es usadas: ArrayList, List, Scanner, Random
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
            System.out.println("\n1 - Jogar \n2 - Instru��es \n3 - Cr�ditos \n4 - Op��es \n\n5 - Sair \n");
            opcao = read.nextInt();
            switch(opcao)
            {
                case 1:
                    if(chance >= 80)
                    {
                        System.out.println("\nDeseja realmente jogar? Sim ou N�o?");
                        read.nextLine();
                        resposta = read.nextLine().toUpperCase();
                        while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                        {
                            System.out.println("\nVamos de novo. Sim ou N�o?");
                            resposta = read.nextLine().toUpperCase();
                        }
                        if(resposta.equals("SIM") || resposta.equals("S"))
                            rodandoMenu = false;
                        else
                        {
                            System.out.println("\nParab�ns! Voc� j� desistiu antes mesmo de come�ar! \n\nFinal 6 de 6");
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
                    System.out.println("INSTRU��ES");
                    System.out.println("\nIMPORTANTE");
                    System.out.println("\nEste jogo foi fortemente baseado em D&D, Dungeons and Dragons, s� que de forma mais limitada e simplificada.");
                    System.out.println("\nAcentos e cedilhas n�o ser�o lidos como respostas v�lidas, portanto n�o os utilize.");
                    System.out.println("\nDICAS");
                    System.out.println("\nH� segredos espalhados pelo jogo, ser� que consegue descobrir todos eles?");
                    System.out.println("\nO B�nus de For�a ir� te auxiliar para obter mais vida, assim como o B�nus de Destreza ir� ajudar o Ladino e o Mago a terem mais Armadura.");
                    System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU. \n");
                    read.nextLine();
                    resposta = read.nextLine();
                    limpaTela();
                break;
                
                case 3:
                    limpaTela();
                    System.out.println("CR�DITOS");
                    System.out.println("\nJogo feito por Rafael Yu e Jo�o Henrique Viana.");
                    System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                    read.nextLine();
                    resposta = read.nextLine();
                    limpaTela();
                break;
                
                case 4:
                    while(rodandoConfig)
                    {
                        limpaTela();
                        System.out.println("OP��ES");
                        System.out.println("\nValor Padr�o de Velocidade de Texto: Lento");
                        System.out.println("Valor Atual de Velocidade de Texto: "+velocidadeTextoConfig);
                        System.out.println("\n1 - Modo de Texto Lento \n2 - Modo de Texto R�pido \n3 - Modo de Texto Customizado \n\n4 - Voltar \n");
                        opcao = read.nextInt();
                    
                        while(opcao < 1 || opcao > 4)
                        {
                            System.out.println("\nApenas isso de configura��o.");
                            System.out.println("\n1 - Modo de Texto Lento \n2 - Modo de Texto R�pido \n3 - Modo de Texto Customizado \n\n4 - Voltar \n");
                            opcao = read.nextInt();
                        }
                    
                        if(opcao == 1)
                            velocidadeTexto = 70;
                        else if(opcao == 2)
                        {
                            velocidadeTexto = 30;
                            velocidadeTextoConfig = "R�pido";
                        }
                        else if(opcao == 3)
                        {
                            System.out.println("\nQual velocidade deseja colocar?");
                            System.out.println("Lembrando que a unidade utilizada � em milissegundos.");
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
                    System.out.println("\nVoc� saiu do jogo.");
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
                        System.out.println("\nCalma l�, t� cedo demais para tentar achar erros.");
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
            System.out.println("CRIA��O DE PERSONAGEM");
            
            //Nome do personagem
            do{
                rodandoValidarNome = true;
                validar = true;
                
                System.out.println("\nQual ser� o nome de seu personagem?");
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
                        
                        System.out.println("\nTem certeza que quer esse nome? Sim ou N�o?");        
                        resposta = read.nextLine().toUpperCase();
                        while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                        {
                            System.out.println("\nVamos de novo. Sim ou N�o?");
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
            System.out.println("\nQual ser� a idade de seu personagem?");
            idade = read.nextInt();
            while(idade < 15 || idade >= 60)
            {
                if(idade < 0)
                    System.out.println("\nSeu personagem tem idade negativa.");
                else if(idade >= 0 && idade < 15)
                    System.out.println("\nSeu personagem � novo demais para uma aventura.");
                else
                    System.out.println("\nSeu personagem � muito velho para uma aventura.");
                
                System.out.println("\nQual ser� a idade de seu personagem?");
                idade = read.nextInt();
            }
            
            //Distribui��o de atributos
            System.out.println("\nEst� na hora de distribuir pontos nos seus 3 atributos, que consistem em: \n\n\tFOR�A      DESTREZA      INTELIG�NCIA");
            System.out.println("\nA soma dos valores destes atributos precisam dar 10! \n");
            System.out.print("For�a: ");
            str = read.nextInt();
            System.out.print("Destreza: ");
            dex = read.nextInt();
            System.out.print("Intelig�ncia: ");
            inte = read.nextInt();
            while(str <= 0 || dex <= 0 || inte <= 0)
            {
                System.out.println("\nN�o ser� aceito n�meros negativos e nulos em prol de obter vantagem. \n");
                System.out.print("For�a: ");
                str = read.nextInt();
                System.out.print("Destreza: ");
                dex = read.nextInt();
                System.out.print("Intelig�ncia: ");
                inte = read.nextInt();
            }
            while(str+dex+inte < 10 || str+dex+inte > 10)
            {
                System.out.println("\nTudo bem, erros de c�lculo acontecem. Preencha novamente. \n");
                System.out.print("For�a: ");
                str = read.nextInt();
                System.out.print("Destreza: ");
                dex = read.nextInt();
                System.out.print("Intelig�ncia: ");
                inte = read.nextInt();
            }
            
            //Classe do personagem
            System.out.println("\nQual ser� a classe de seu personagem?");
            System.out.println("\n1 - Guerreiro [+2 For�a | +1 Destreza] \n2 - Ladino [+2 Destreza | +1 Intelig�ncia] \n3 - Mago [+3 Intelig�ncia] \n");
            opcao = read.nextInt();
            
            while(opcao < 1 || opcao > 3)
            {
                System.out.println("\nSim, s� essas 3 classes b�sicas.");
                System.out.println("\n1 - Guerreiro [+2 For�a | +1 Destreza] \n2 - Ladino [+2 Destreza | +1 Intelig�ncia] \n3 - Mago [+3 Intelig�ncia] \n");
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
                    inv.add("Espada Longa"); inv.add("Escudo"); inv.add("Cota de Malha"); inv.add("Po��o de Cura");
                    CA = 18;
                    moedas = (aleatorio(4)+aleatorio(4)+aleatorio(4)+aleatorio(4)+aleatorio(4))*10;
                break;
                
                case "Ladino":
                    dex += 2;
                    inte++;
                    indicieDanoJogador = 10;
                    inv.add("Rapieira"); inv.add("Ferramentas de Ladr�o"); inv.add("Armadura de Couro"); inv.add("Po��o de Cura");
                    CA = 11;
                    moedas = (aleatorio(4)+aleatorio(4)+aleatorio(4)+aleatorio(4))*10;
                break;
                
                default:
                    inte += 3;
                    indicieDanoJogador = 6;
                    inv.add("Cajado"); inv.add("Grim�rio"); inv.add("Po��o de Cura");
                    CA = 10;
                    moedas = (aleatorio(4)+aleatorio(4)+aleatorio(4)+aleatorio(4))*10;
            }
            
            //Ra�a do personagem
            System.out.println("\nQual ser� a ra�a de seu personagem?");
            System.out.println("\n1 - Humano [+1 Intelig�ncia] \n2 - Elfo [+1 Destreza] \n3 - An�o [+1 For�a] \n");
            opcao = read.nextInt();
            
            while(opcao < 1 || opcao > 3)
            {
                System.out.println("\nInfelizmente s� h� essas 3 op��es.");
                System.out.println("\n1 - Humano [+1 Intelig�ncia] \n2 - Elfo [+1 Destreza] \n3 - An�o [+1 For�a] \n");    
                opcao = read.nextInt();
            }
            
            switch(opcao)
            {
                case 1: raca = "Humano"; break;
                case 2: raca = "Elfo"; break;
                default: raca = "An�o";
            }
            switch(raca)
            {
                case "Humano": inte++; break;
                case "Elfo": dex++; break;
                default: str++;
            }
            
            //Antecedente do personagem
            System.out.println("\nQual ser� o antecedente de seu personagem?");
            System.out.println("\n1 - Cidad�o [+2 Intelig�ncia] \n2 - Viajante [+2 Destreza] \n3 - Mercen�rio [+2 For�a] \n4 - Nobre [+250 de Ouro no come�o] \n");
            opcao = read.nextInt();
            
            while(opcao < 1 || opcao > 4)
            {
                System.out.println("\nPor enquanto s� h� essas op��es.");
                System.out.println("\n1 - Cidad�o [+2 Intelig�ncia] \n2 - Viajante [+2 Destreza] \n3 - Mercen�rio [+2 For�a] \n4 - Nobre [+250 de Ouro no come�o] \n");
                opcao = read.nextInt();
            }
            
            switch(opcao)
            {
                case 1: antecedente = "Cidad�o"; break;
                case 2: antecedente = "Viajante"; break;
                case 3: antecedente = "Mercen�rio"; break;
                default: antecedente = "Nobre";
            }
            switch(antecedente)
            {
                case "Cidad�o": inte += 2; break;
                case "Viajante": dex += 2; break;
                case "Mercen�rio": str += 2; break;
                default: moedas += 250;
            }
            
            bonusStr = str/2; bonusDex = dex/2; bonusInte = inte/2; percepcaoPassiva += bonusInte;
            
            //Op��o de vida fixa
            System.out.println("\nDeseja pegar vida fixa? Sim ou N�o?");
            read.nextLine();
            resposta = read.nextLine().toUpperCase();
            
            while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
            {
                System.out.println("\nSim ou N�o? \n");
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
            
            //Nomes com a primeira letra mai�scula
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
            System.out.println("\nDeseja continuar com esse personagem? Sim ou N�o?");
            resposta = read.nextLine().toUpperCase();
            
            while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
            {
                System.out.println("\nConfirme novamente. Sim ou N�o?");
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
                    case "Guerreiro": inv.remove("Espada Longa"); inv.remove("Escudo"); inv.remove("Po��o de Cura"); break;
                    case "Ladino": inv.remove("Rapieira"); inv.remove("Ferramentas de Ladr�o"); inv.remove("Po��o de Cura"); break;
                    default: inv.remove("Cajado"); inv.remove("Grim�rio"); inv.remove("Po��o de Cura");
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
                texto = "Manh�. Taverna do Drag�o Prateado. \n\n"
                        + "Voc�, aventureiro, se encontra nesta taverna tomando seu caf� da manh� ap�s chegar de viagem na cidade de Queda de Ferro. \n"
                        + "Seu objetivo � desconhecido.";
                typeWriter(texto, velocidadeTexto);
                    
                System.out.println("\n\nO que deseja fazer?");
                System.out.println("\n1 - Terminar refei��o \n2 - Buscar informa��o \n");
                opcao = read.nextInt();
                
                while(opcao < 1 || opcao > 2)
                {
                    System.out.println("\n�, as op��es n�o s�o muitas.");
                    System.out.println("\nO que deseja fazer?");
                    System.out.println("\n1 - Terminar refei��o \n2 - Buscar informa��o \n");
                    opcao = read.nextInt();
                }
                
                switch(opcao)
                {
                    case 1:
                        System.out.println("\nVoc� termina sua refei��o e nada mudou.");
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                        read.nextLine();
                        resposta = read.nextLine();        
                        
                        texto = "\nAp�s terminar sua refei��o, voc� � abordado pelo pr�prio tarveneiro que cuida deste lugar. \n"
                                + "'Bom dia, estava bom o prato que pediu?'";
                        typeWriter(texto, velocidadeTexto);
                                    
                        System.out.println("\n\n1 - Bom \n2 - Satisfat�rio \n3 - [Droga, a comida estava t�o boa que n�o d� para falar mal] \n4 - Qual seu nome? \n");
                        opcao = read.nextInt();
                        
                        while(opcao < 1 || opcao > 4)
                        {
                                System.out.println("\nOp��o inv�lida.");
                                System.out.println("\n1 - Bom \n2 - Satisfat�rio \n3 - [Droga, a comida estava t�o boa que n�o d� para falar mal] \n4 - Qual seu nome? \n");
                                opcao = read.nextInt();
                        }
                        
                        switch(opcao)
                        {
                            case 1:
                                texto = "\n'Que bom. Mas que tal um trabalho para um aventureiro como voc�?' \n"
                                        + "O tarveneiro puxa uma carta e te d� em m�os. \n";
                                typeWriter(texto, velocidadeTexto);
                                    
                                System.out.println("\nVoc� obteve Carta.");
                                inv.add("Carta");
                            break;
                                
                            case 2:
                                texto = "\n'S� satisfeito? Creio que contentar�-se com isso daqui.' \n"
                                        + "Uma carta � puxada de dentro do uniforme de barman e ele lhe entrega.";
                                typeWriter(texto, velocidadeTexto);
                                    
                                System.out.println("\n\nVoc� obteve Carta.");
                                inv.add("Carta");
                            break;
                                
                            case 3:
                                texto = "\nEle percebe seu sil�ncio e prossegue com o que precisa dizer. \n"
                                        + "'Acho que isso � um sim pois n�o tem como a nossa comida de casa ser ruim.' \n\n"
                                        + "Com isso, voc� acha que � a hora de pagar pelo caf� da manh� e j� pega algumas moedas de sua algibeira. \n"
                                        + "'Voc� j� pagou... mas eu tenho um �timo servi�o de aventureiro pra ti.' \n\n"
                                        + "� um tanto surpreendente, mas era esperado num ambiente inicial clich� como esse para os mais habituados. \n"
                                        + "Ele pega uma carta e entrega a voc�.";
                                typeWriter(texto, velocidadeTexto);
                                    
                                System.out.println("\n\nVoc� obteve Carta.");
                                inv.add("Carta");
                            break;
                                
                            default:
                                texto = "\n'Meu nome � Louis, mas isso � o de menos. Tenho um servi�o para voc�, aventureiro.' \n"
                                        + "Parece que esse tarveneiro � experiente quando o assunto s�o aventureiros. \n\n"
                                        + "Ele te passa uma carta.";
                                typeWriter(texto, velocidadeTexto);
                                     
                                System.out.println("\n\nVoc� obteve Carta.");
                                inv.add("Carta");
                        }
                            
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                        read.nextLine();
                        resposta = read.nextLine();
                            
                        texto = "\nVisualmente, esta carta possui um selo t�o ornamentado que parece at� m�gico. \n"
                                + "O tarveneiro sai de perto da sua mesa e volta ao servi�o na movimentada taverna. \n\n"
                                + "Estando sozinho, voc� abre o pergaminho retirando o la�o verde. \n"
                                + "E voc� se depara com essa mensagem: \n";
                        typeWriter(texto, velocidadeTexto);
                        carta();
                            
                        System.out.println("Pressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 2.");
                        resposta = read.nextLine();
                            
                        rodandoParte1 = false;
                    break;
                        
                    default:
                        System.out.println("\nCom quem voc� deseja buscar informa��o?");
                        System.out.println("\n1 - Tarveneiro \n2 - Cliente \n3 - Gar�onete \n");
                        opcao = read.nextInt();
                        
                        while(opcao < 1 || opcao > 3)
                        {
                            System.out.println("\nOp��o inv�lida.");
                            System.out.println("\nCom quem voc� deseja buscar informa��o?");
                            System.out.println("\n1 - Tarveneiro \n2 - Cliente \n3 - Gar�onete \n");
                            opcao = read.nextInt();
                        }
                        
                        switch(opcao)
                        {
                            case 1:
                                texto = "\nVoc� se aproxima do balc�o do tarveneiro e ele est� passando pano nos copos. \n"
                                        + "'Voc� ainda n�o terminou seu caf� da manh�.' \n\n"
                                        + "Sendo a primeira coisa que ele nota em voc�, mas n�o � algo preocupante. \n"
                                        + "Voc� pede por informa��o pra ele. \n\n"
                                        + "Enquanto continua limpando os copos, ele te responde. \n"
                                        + "'Hmm, tenho exatamente o que voc� precisa.' \n\n"
                                        + "Terminando de limpar todos os copos, ele pega uma carta numa gaveta e te passa. \n"
                                        + "'Pegue. Esta carta trar� bastante informa��o.'";
                                typeWriter(texto, velocidadeTexto);
                                    
                                System.out.println("\n\nVoc� obteve Carta.");
                                inv.add("Carta");
                                
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                read.nextLine();
                                resposta = read.nextLine();
                                
                                texto = "\nLogo em seguida, voc� j� come�a abrindo a carta. \n"
                                        + "Mas o tarveneiro exclama para n�o fazer isso. \n"
                                        + "'N�o � para abrir!' \n\n"
                                        + "Ele indica para ler o pergaminho, que acompanha a carta, primeiro. \n"
                                        + "E o conte�do do recado se encontra assim: \n";
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
                                    texto = "\nVoc� vai at� a mesa de um aventureiro que nem voc�. \n\n"
                                            + "As marcas de garras pela armadura met�lica caracterizam um guerreiro, deve ter lutado com alguma besta. \n"
                                            + "Ele est� tomando um calmante e voc� disp�e-se ocupando a cadeira que fica de frente para ele. \n\n"
                                            + "'Pois n�o?'";
                                    typeWriter(texto, velocidadeTexto);
                                       
                                    System.out.println("\n\n1 - Tem alguma informa��o? \n2 - Quer se juntar a mim? \n3 - Conte-me sobre voc� \n");
                                    opcao = read.nextInt();
                                    
                                    while(opcao < 1 || opcao > 3)
                                    {
                                            System.out.println("\nSem di�logos secretos.");
                                            System.out.println("\n1 - Tem alguma informa��o? \n2 - Quer se juntar a mim? \n3 - Conte-me sobre voc� \n");
                                            opcao = read.nextInt();
                                    }
                                      
                                    switch(opcao)
                                    {
                                        case 1:
                                            texto = "\n'Que tipo de informa��o?' \n"
                                                    + "Voc� informa apropriadamente. \n\n"
                                                    + "'S� de trabalho ap�s o Eclipse, voc� vai achar v�rios contratos de exterm�nio de monstros. \n"
                                                    + "Voc� pergunta de forma aprofundada sobre algum trabalho que enquadre com seu caso. \n\n"
                                                    + "'Cara, ainda tem algumas criaturas das trevas que rondam o Norte, mesmo ap�s a queda dos Ambrosia.' \n"
                                                    + "Institivamente, voc� levanta da mesa pois achou seu objetivo. \n\n"
                                                    + "Voc� agradece pela coopera��o, j� o guerreiro continua tomando seu caf� da manh�.";
                                            typeWriter(texto, velocidadeTexto);
                                        break;
                                            
                                        case 2:
                                            texto = "\n'Prefiro fazer tudo sozinho, nada vai me convencer do contr�rio.' \n"
                                                    + "De qualquer modo, voc� nem ao menos tem algum objetivo em mente para sair convidando as pessoas pra uma aventura. \n\n"
                                                    + "Portanto, voc� pergunta sobre trabalhos que possam ser feitos sem companhia. \n"
                                                    + "'Seguindo a estrada que leva ao Norte, encontrar� alde�es que pagam uma boa grana por eliminar os mortos-vivos.' \n\n"
                                                    + "Conseguindo o que queria, voc� agradece o guerreiro e despede-se dele.";
                                            typeWriter(texto, velocidadeTexto);
                                        break;
                                            
                                        default:
                                            texto = "\nO exaurido guerreiro do rosto marcado toma mais um gole e come�a a falar mais sobre si. \n"
                                                    + "'Vim de Feist e venho sendo treinado para me tornar um Ca�ador...' \n\n"
                                                    + "Ele nota que esqueceu das apresenta��es e logo faz. \n"
                                                    + "'Ah, e prazer te conhecer. Meu nome � Johann.' \n"
                                                    + "'Qual o seu nome?' \n\n"
                                                    + "Voc� responde devidamente. \n"
                                                    + "'"+Nome+ "... vou guardar esse nome.' \n\n"
                                                    + "Johann olha pro rel�gio da taverna e demonstra estar atrasado, logo termina com sua bebida e se preparar pra sair. \n"
                                                    + "'Perd�o, mas tenho que partir. Se queria alguma informa��o relevante, tente procurar pela estrada que leva ao Norte.' \n"
                                                    + "Certamente ele conseguiu sentir que sua inten��o foi de obter algum objetivo. \n\n"
                                                    + "Voc� faz uma �ltima pergunta pra saber para onde ele estar� indo. \n"
                                                    + "'Estou indo ao Velho Mundo, faz parte do treinamento.' \n\n"
                                                    + "Com isso, voc� agora est� sozinho. \n"
                                                    + "Mas voc� nota algo sobre a mesa, um punhado de moedas deixado para voc�.";
                                            typeWriter(texto, velocidadeTexto);
                                                
                                            System.out.println("\n\nVoc� obteve 50 moedas.");
                                            moedas += 50;
                                    }
                                }
                                else if(dado == 2 && chance < 90)
                                {
                                    texto = "\nVoc� vai at� a mesa de um grupo de aventureiros. \n\n"
                                            + "Chegando, com ou sem ansiedade, o caf� da manh� do grupo � interrompido por voc�. \n"
                                            + "Voc� observa a composi��o da equipe de 4 membros, e s�o, respectativamente, um paladino, um monge, uma maga e uma druida. \n\n"
                                            + "De tanto tempo calado encarando pra eles, voc� sente na necessidade de interagir.";
                                    typeWriter(texto, velocidadeTexto);
                                        
                                    System.out.println("\n\n1 - Pedir informa��o \n2 - Pedir para participar do grupo \n");
                                    opcao = read.nextInt();
                                    
                                    while(opcao < 1 || opcao > 2)
                                    {
                                            System.out.println("\nAparentemente, seu personagem n�o � muito soci�vel para s� ter 2 op��es.");
                                            System.out.println("\n1 - Pedir informa��o \n2 - Pedir para participar do grupo \n");
                                            opcao = read.nextInt();
                                    }  
                                        
                                    switch(opcao)
                                    {
                                        case 1:
                                            texto = "\nDispostos a ajudar, o paladino, aparentemente l�der da equipe, repassa o que sabem. \n"
                                                    + "'Muitos mortos-vivos ainda est�o a solta por conta do foragido necromante, ex-servo do arruinado Lorde Ambrosia.' \n"
                                                    + "'Sabe-se que ele deve estar escondido em algum lugar do subterr�neo.' \n\n"
                                                    + "Havendo essa pequena pausa, voc� anda percebendo o leve desconforto gerado por sua chegada. \n"
                                                    + "Mas que est� sendo camuflada com a simpatia do porta-voz do grupo.\n\n"
                                                    + "'E N�S iremos ach�-lo...'\n"
                                                    + "'Portanto, isso � um trabalho de um grupo que nem a gente.' \n\n"
                                                    + "Com isso, j� bastou para voc�. Somente agradecendo por terem ao menos falado contigo. \n"
                                                    + "Provavelmente aquele grupo n�o est� interessado num novo membro, e muito menos concorrentes. \n";
                                            typeWriter(texto, velocidadeTexto);
                                        break;
                                                
                                        default:
                                            texto = "\nTodos do grupo entram no consenso de te rejeitarem de forma inconsciente. \n"
                                                    + "Por�m, o paladino come�a com sua explica��o para abafar essa sensa��o. \n\n"
                                                    + "'����... sinto muito por isso, mas nem te conhecemos direito.' \n"
                                                    + "'Claro que ajuda � sempre bem-vinda, mas n�o estamos aceitando novos membros no momento.' \n\n"
                                                    + "Chateado, revoltado, ou seja l� o que esteja sentindo com isso, voc� d� as costas para sair dali. \n"
                                                    + "Mas antes, o senso de bondade de um paladino fala mais alto. \n\n"
                                                    + "'Espere. Talvez a miss�o de encontrar um necromante fugitivo lhe interesse.' \n"
                                                    + "Voc� volta a eles, mas agora sem interesse em participar do grupo, somente querendo a informa��o. \n\n"
                                                    + "'Dizem que ele est� rondando a estrada que leva ao Norte e...' \n"
                                                    + "Antes que ele pudesse terminar de falar, voc� bate a porta da taverna partindo em busca desse objetivo. \n";
                                            typeWriter(texto, velocidadeTexto);  
                                    }
                                }
                                else
                                {
                                    texto = "\nVoc� confere os clientes presentes e decide abordar um isolado encapuzado. \n\n"
                                            + "Nada est� servido na mesa dele e tudo parece t�o tenso ao aproximar-se. \n"
                                            + "Voc� fita ele de cima a baixo mas nenhum suave movimento de cabe�a como rea��o, parecendo te ignorar. \n\n"
                                            + "Antes de voc� dar as costas, um sibilante sussurro incompreens�vel lhe chama de volta. \n"
                                            + "O rosto dele est� emparelhado com o seu, por�m, voc� apenas enxerga a si mesmo. \n"
                                            + "Sendo, ent�o, uma m�scara de espelho. \n\n"
                                            + "Este misterioso ente apenas d� um aceno de cabe�a para voc� ir em dire��o ao balc�o. \n"
                                            + "A express�o do tarveneiro � neutra, como se estivesse acostumado com esse tipo de bizarrice. \n\n"
                                            + "Voc� vai at� o balc�o, seguindo a sugest�o daquele enigm�tico estranho.";
                                    typeWriter(texto, velocidadeTexto);
                                     
                                    System.out.println("\n\n1 - Tem alguma coisa para mim? \n2 - Quem � ele? \n");
                                    opcao = read.nextInt();
                                    
                                    while(opcao < 1 || opcao > 2)
                                    {
                                        System.out.println("\nSim, coloquei while em todas as vezes para validar op��es.");
                                        System.out.println("\n1 - Tem alguma coisa para mim? \n2 - Quem � ele? \n");
                                        opcao = read.nextInt();
                                    }
                                      
                                    switch(opcao)
                                    {
                                        case 1:
                                            texto = "\n'Tenho.' \n"
                                                    + "Ele puxa uma gaveta e lhe entrega uma carta. \n\n"
                                                    + "'N�o quero falar muito agora, aquele cara ali est� nos encarando.' \n"
                                                    + "Voc� olha para tr�s e v� o rosto espelhado refletindo para onde mostra, e nem ligando se est� sendo esquisito. \n\n"
                                                    + "Entendendo a situa��o, voc� apenas sai com a carta.";
                                            typeWriter(texto, velocidadeTexto);
                                                
                                            System.out.println("\n\nVoc� obteve Carta.");
                                            inv.add("Carta");
                                                
                                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                            read.nextLine();
                                            resposta = read.nextLine();
                                        break;
                                            
                                        default:
                                            texto = "\n'N�o tenho ideia.' \n"
                                                    + "'Nunca vi ele na cidade, deve ser um viajante como voc�.' \n\n"
                                                    + "Voc� indaga o jeito estranho e egoc�ntrico do cara de espelho. \n"
                                                    + "'Seja l� o que ou quem ele seja, ele parece saber bastante...' \n\n"
                                                    + "O tarveneiro puxa uma gaveta e traz consigo uma carta, que � dada a voc�. \n"
                                                    + "'Tome. Essa carta j� n�o est� mais segura nessa taverna.' \n\n"
                                                    + "Ent�o, voc� sai da taverna com a carta.";
                                            typeWriter(texto, velocidadeTexto);
                                               
                                            System.out.println("\n\nVoc� obteve Carta.");
                                            inv.add("Carta");
                                                
                                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                            read.nextLine();
                                            resposta = read.nextLine();
                                    }
                                }
                                    
                                if(inv.contains("Carta"))
                                {
                                    texto = "\nA carta traz junto um papel enrolado num la�o verde. \n"
                                            + "Voc� retira o la�o e o pergaminho se trata de uma mensagem: \n";
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
                                texto = "\nVoc� levanta a m�o para a gar�onete ir na sua mesa. \n"
                                        + "Inicialmente, voc� j� tinha a pergunta na ponta da sua l�ngua. \n"
                                        + "Mas a beleza estonteante da mo�a causa um branco em voc�.";
                                typeWriter(texto, velocidadeTexto);
                                
                                System.out.println("\n\nO que deseja fazer?");
                                System.out.println("\n1 - Tentar lembrar \n2 - Puxar conversa \n");
                                opcao = read.nextInt();
                                
                                while(opcao < 1 || opcao > 2)
                                {
                                    System.out.println("\nRelaxa, voc� consegue.");
                                    System.out.println("\n1 - Tentar lembrar \n2 - Puxar conversa \n");
                                    opcao = read.nextInt();
                                }
                                
                                switch(opcao)
                                {
                                    case 1:
                                        dado = aleatorio(20)+bonusInte;
                                        
                                        if(dado >= 12)
                                            texto = "\nVoc� consegue lembrar com sucesso. \n\n"
                                                    + "Recompondo-se, voc� pergunta sobre as novidades naturalmente. \n"
                                                    + "Ela est� se mostrando uma �tima ouvinte e ent�o come�a a dizer. \n\n"
                                                    + "'N�o h� muito tempo atr�s, um lorde vampiro morreu.' \n"
                                                    + "'Logo, seus servos est�o espalhados por a� nessa regi�o.' \n\n"
                                                    + "Mesmo conseguindo ter agido de forma expl�ndida, voc� n�o consegue desviar o olhar. \n"
                                                    + "Parecendo at� que ela saiu de um conto de fadas. \n"
                                                    + "'... siga a estrada que leva ao Norte.' \n\n"
                                                    + "Voc� ficou perdido nas suas observa��es e escutou apenas essa �ltima parte. \n"
                                                    + "Como seria demais pedir para repetir, voc� acena que entendeu como se n�o tivesse d�vida. \n\n"
                                                    + "'Tenho que ir, boa sorte na aventura!' \n"
                                                    + "A mo�a despede-se para continuar seu trabalho. \n\n"
                                                    + "Enquanto isso, voc� se sente mais inspirado e motivado.";
                                        else
                                            texto = "\nVoc� n�o consegue lembrar. \n\n"
                                                    + "Um sil�ncio constrangedor invade a pequena intera��o entre voc�s. \n"
                                                    + "Mas n�o obstante, ela toma a iniciativa. \n"
                                                    + "'Vai querer mais alguma coisa?' \n\n"
                                                    + "Voc� v� a oportunidade para pedir por informa��es. \n"
                                                    + "E inesperadamente, a jovem consegue lhe dizer as not�cias mais frescas. \n\n"
                                                    + "'Voc� pode procurar por trabalho indo para Feist, no Norte.' \n"
                                                    + "'Muitos mortos-vivos continuam na espreita e est�o come�ando a migrar para c�.' \n\n"
                                                    + "Voc� j� cria interesse e anota isso para mais tarde. \n"
                                                    + "Visto isso, ela volta ao servi�o e voc� termina sua refei��o.";
                                        
                                        typeWriter(texto, velocidadeTexto);
                                        
                                        System.out.println("\n\nPressione ENTER ou digite qualquer coisa para prosseguir pra PARTE 2.");
                                        read.nextLine();
                                        resposta = read.nextLine();
                                        
                                        rodandoParte1 = false;
                                    break;
                                    
                                    default:
                                        texto = "\nVoc� inicia uma conversa. \n\n"
                                                + "Por onde come�a?";
                                        typeWriter(texto, velocidadeTexto);
                                        
                                        System.out.println("\n\n1 - Qual o seu nome? \n2 - Quantos anos voc� tem? \n");
                                        opcao = read.nextInt();
                                        
                                        while(opcao < 1 || opcao > 2)
                                        {
                                            System.out.println("\nSim, s� essas 2 perguntas.");
                                            System.out.println("\n1 - Qual o seu nome? \n2 - Quantos anos voc� tem? \n");
                                            opcao = read.nextInt();
                                        }
                                        
                                        switch(opcao)
                                        {
                                            case 1:
                                                texto = "\n'Ah, eu me chamo Nina.' \n"
                                                        + "'Qual o seu nome?' \n\n"
                                                        + "Voc� responde. \n"
                                                        + "'"+Nome+".' \n\n"
                                                        + "Voc� acha que ela tenha repetido seu nome para fixar ele na mem�ria. \n"
                                                        + "'Ent�o, "+Nome+", voc� veio de onde?' \n\n"
                                                        + "Parando para pensar, nem voc� lembra direito de seu passado. \n"
                                                        + "� dif�cil de definir o que exatamente voc� fazia, mas voc� lembra de sua antiga profiss�o.";
                                                typeWriter(texto, velocidadeTexto);
                                                
                                                System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                                                read.nextLine();
                                                resposta = read.nextLine();
                                                
                                                dado = aleatorio(20)+bonusInte;
                                                
                                                if(antecedente.equals("Cidad�o"))
                                                {
                                                    texto = "\nVoc� conta que era apenas um cidad�o de bem. \n\n"
                                                            + "Isso intriga Nina, que pergunta. \n"
                                                            + "'E o que levou a voc� se aventurar?' \n\n"
                                                            + "Continuando, seu passado � ofuscado, o que gera uma resposta inconclusiva. \n"
                                                            + "Mas voc� d� uma raz�o mais palp�vel. \n\n"
                                                            + "'Dinheiro? N�o � todo mundo que vai pegar numa espada e partir ca�ando monstros.' \n"
                                                            + "'Deve ter alguma coisa que voc� n�o esteja lembrando.' \n\n"
                                                            + "Voc� tenta lembrar.";
                                                    typeWriter(texto, velocidadeTexto);
                                                    
                                                    if(dado >= 15)
                                                    {
                                                        texto = "\n\nVoc� se mostrou ter um talento especial ao ter defendido sua aldeia de um ataque de monstros. \n"
                                                                + "Que te levou numa sequ�ncia incans�vel de pequenas aventuras. \n\n"
                                                                + "Ela se mostra interessada nessa hist�ria incr�vel de um simples ex-assalariado. \n"
                                                                + "Por�m, o chefe dela chama aten��o por ter feito essa pausa no servi�o. \n"
                                                                + "'Ih, depois a gente se fala.' \n\n"
                                                                + "J� o tarveneiro, ele fala com voc�. \n"
                                                                + "'Se quer uma aventura, v� ao Norte. Feist est� precisando de uma forcinha.' \n"
                                                                + "Voc� aceita a sugest�o dele, apesar de ter outro objetivo em mente ap�s ter conversado com Nina.";
                                                    }
                                                    else
                                                    {
                                                        texto = "\n\nVoc� n�o se lembra de nada praticamente. \n"
                                                                + "Mas n�o � de todo ruim, Nina continua a conversa. \n"
                                                                + "'E agora pretende fazer o qu�?' \n\n"
                                                                + "Finalmente chegando nesse assunto, voc� lembra que veio aqui sem ter um objetivo. \n"
                                                                + "Mas antes que pudesse perguntar por informa��es, ela � advertida. \n\n"
                                                                + "O tarveneiro a despacha para que ela volte ao trabalho, e ele diz para voc�. \n"
                                                                + "'Era para aventureiros, como voc�, estarem buscando por aventuras, e n�o isso. \n\n"
                                                                + "Continuando, o tarveneiro lhe passa informa��es vitais. \n"
                                                                + "'S� seguir ao Norte, para Feist, presumo que saiba onde seja. \n\n"
                                                                + "Voc� gosta da ideia e ent�o come�a indo para l�.";
                                                    }
                                                    typeWriter(texto, velocidadeTexto);
                                                }  
                                                else if(antecedente.equals("Viajante"))
                                                {
                                                    texto = "\nVoc� conta que era um viajante. \n\n"
                                                            + "Isso gera curiosidade em Nina, que pergunta. \n"
                                                            + "'Ent�o j� deve ter viajado bastante, lembra de algum lugar interessante? \n\n'"
                                                            + "Voc� fala que j� encontrou com algumas cerejeiras. \n"
                                                            + "'Cerejeiras!? Eu gostaria de ver uma!' \n\n"
                                                            + "Voc� claramente consegue enxergar a express�o de uma crian�a curiosa em Nina. \n"
                                                            + "'Onde mais ou menos era esse lugar?' \n\n"
                                                            + "Voc� n�o tem a m�nima ideia. \n"
                                                            + "Mas voc� tenta dar um palpite.";
                                                    typeWriter(texto, velocidadeTexto);
                                                    
                                                    if(dado >= 15)
                                                    {
                                                        texto = "\n\nVoc� lembra de ter as encontrado numa regi�o muito inacess�vel. \n"
                                                                + "Logo, voc� come�a descrevendo como foi chegar em tal lugar recluso, como uma verdadeira aventura. \n\n"
                                                                + "Os olhos de Nina brilham ao ouvir sua hist�ria, como se fosse um conto �pico. \n"
                                                                + "Voc� se sente agrad�vel com essa rea��o, ent�o come�a a enaltecer sua grandiosidade. \n\n"
                                                                + "Enquanto estava relatando, voc� nem percebe a chegada do tarveneiro na mesa. \n"
                                                                + "De p� ao lado da mesa, ele faz um aceno para ela voltar ao trabalho. \n"
                                                                + "J� para voc�, ele lhe olha e diz. \n\n"
                                                                + "'Que tal vivenciar outra viagem indo ao Norte?' \n"
                                                                + "'Para a� sim voltar aqui e contar com mais legitimidade.' \n\n"
                                                                + "Soando meio amea�ador, voc� sai do estabelecimento. \n"
                                                                + "Mas antes de ir, ele esclarece as interpreta��es com voc�.";
                                                    }
                                                    else
                                                    {
                                                        texto = "\n\nVoc� n�o tem ideia de onde era tal lugar. \n"
                                                                + "Por�m, usa desse artif�cio para inventar algo extraordin�rio. \n\n"
                                                                + "Inocentemente, voc� parece achar que ela est� acreditando nesta hist�ria. \n"
                                                                + "Mesmo que pare�a absurdo em alguns momentos, ambos est�o felizes. \n\n"
                                                                + "Contudo, a gra�a acaba quando o tarveneiro chega para interromper a divers�o. \n"
                                                                + "Mandando-a de volta ao trabalho, voc� est� a s�s com ele. \n\n"
                                                                + "'Voc� pode contar uma hist�ria de verdade na pr�xima.' \n"
                                                                + "'Basta seguir ao Norte, l� estar� uma �tima hist�ria de aventura te aguardando.' \n\n"
                                                                + "Como n�o h� nada a perder, voc� parte naquela dire��o.";
                                                    }
                                                }
                                                else if(antecedente.equals("Mercen�rio"))
                                                {
                                                    texto = "\nVoc� conta que era um mercen�rio. \n\n"
                                                            + "Isso assusta um pouco Nina, mas que pergunta. \n"
                                                            + "'Ent�o voc� j� matou uma pessoa?' \n\n"
                                                            + "� incerto, mas pelo tanto que voc� j� lutou para chegar at� aqui... \n"
                                                            + "Voc� enxerga a express�o acuada dela, ent�o a acalma. \n\n"
                                                            + "'Ent�o voc� n�o matou ningu�m, n�?' \n"
                                                            + "Voc� acena que sim, que nunca matou uma pessoa. \n\n"
                                                            + "Com isso, ela parte para outra pergunta. \n"
                                                            + "'E por que saiu dessa vida? Tava sendo mal remunerado? \n\n"
                                                            + "Voc� n�o lembra com exatid�o, mas tenta.";
                                                    typeWriter(texto, velocidadeTexto);
                                                    
                                                    if(dado >= 15)
                                                    {
                                                        texto = "\n\nSim, voc� lembra bem, lembra bem at� que demais. \n"
                                                                + "Voc� come�a contando como que uma ca�ada a um ogro falhou. \n\n"
                                                                + "Mesmo que evite todos os detalhes vicerais, a express�o imaginativa dela diz muita coisa. \n"
                                                                + "'Que horror...' \n\n"
                                                                + "Na tentativa de apaziguar esse clima amargo, voc� conta o que houve depois. \n"
                                                                + "Mas tempos melhores ainda n�o chegar�o, pois o tarveneiro chega na mesa de voc�s. \n\n"
                                                                + "'Quem sabe dias melhores cheguem se deixar ela trabalhar, hein?' \n"
                                                                + "'Ah! Foi mal, chefe.' \n\n"
                                                                + "Voltando ao trabalho, voc� recebe uma proposta de aventura. \n"
                                                                + "'A amea�a ainda n�o foi neutralizada, siga o Norte que eventualmente achar� o caminho.' \n\n"
                                                                + "Meio enigm�tico, voc� segue a sugest�o ap�s obter um prop�sito.";
                                                    }
                                                    else
                                                    {
                                                        texto = "\n\nVoc� n�o lembra do motivo principal. \n"
                                                                + "O que faz Nina criar suposi��es aliviadoras. \n\n"
                                                                + "'Ser� porqu� tomou uma flechada no joelho?' \n"
                                                                + "'Ou ser� que foi tra�do pela sua companhia?' \n"
                                                                + "'Hmm...' \n\n"
                                                                + "E mais uma suposi��o � dada pelo tarveneiro. \n"
                                                                + "'Ou ser� que voc� est� ocupando tempo demais do aventureiro?' \n\n"
                                                                + "Notando a chegada de seu superior, ela continua o servi�o. \n"
                                                                + "Quanto a voc�, tamb�m estar� daqui a pouco trabalhando. \n\n"
                                                                + "Pois ele oferta uma interessante aventura para voc�. \n"
                                                                + "'Indo ao Norte, voc� encontrar� muitas lutas que far�o entrar em forma.' \n\n"
                                                                + "Como se fosse um gatilho, voc� � impulsionado por uma vontade interior. \n"
                                                                + "Que te motiva a trilhar tal caminho.";
                                                    }
                                                }
                                                else
                                                {
                                                    texto = "\nVoc� conta que era um nobre. \n\n"
                                                            + "Isso surpreende Nina, que pergunta. \n"
                                                            + "'Nobre? Como foi se tornar um aventureiro?' \n\n"
                                                            + "Voc� n�o lembra, mas tenta lembrar com a ajuda dela. \n"
                                                            + "Ela come�a a dar sugest�es de rumos que poderia ter tomado. \n"
                                                            + "'Acabou o dinheiro? Incentivo dos pais? Motivo pessoal?'";
                                                    typeWriter(texto, velocidadeTexto);
                                                    
                                                    System.out.println("\n\nQual sugest�o deseja escolher?");
                                                    System.out.println("\n1 - Falta de dinheiro \n2 - Influ�ncia dos pais \n3 - Motiva��o pessoal \n");
                                                    opcao = read.nextInt();
                                                    
                                                    while(opcao < 1 || opcao > 3)
                                                    {
                                                        System.out.println("\nVoc� quer mais di�logos!? J� t� bom, eu acho.");
                                                        System.out.println("\nQual sugest�o deseja escolher?");
                                                        System.out.println("\n1 - Falta de dinheiro \n2 - Influ�ncia dos pais \n3 - Motiva��o pessoal \n");
                                                        opcao = read.nextInt();
                                                    }
                                                    
                                                    switch(opcao)
                                                    {
                                                        case 1:
                                                            texto = "\n� o motivo mais f�cil de supor, pois o dinheiro uma hora acaba. \n"
                                                                    + "'Se o dinheiro acabou, no que voc� gastou?' \n\n"
                                                                    + "Voc� confere seu equipamento, mas nada extravagante. \n"
                                                                    + "Logo, percebe-se o qu�o m�o de vaca voc� virou ap�s a fal�ncia. \n"
                                                                    + "Retendo uma boa quantia de dinheiro e poupando nas despesas \n\n"
                                                                    + "E de repente, o tarveneiro est� aqui jogando cara ou coroa consigo mesmo. \n"
                                                                    + "'Se voc� n�o trabalhar, mocinha, n�o vai ter dinheiro caindo na sua conta.' \n\n"
                                                                    + "Fazendo com que ela volte a atender outros clientes com um esfor�o ainda maior. \n"
                                                                    + "Enquanto isso, o tarveneiro guarda a moeda e faz uma oferta para voc�. \n"
                                                                    + "'L� ao Norte, em Feist, estar� encontrando uma boa recompensa-' \n\n"
                                                                    + "Falando em recompensa, voc� imediatamente sai da taverna enquanto come rapidamente todo o caf� da manh�.";
                                                        break;
                                                        
                                                        case 2:
                                                            texto = "\nVoc� n�o se recorda de seus pais serem aventureiros. \n"
                                                                    + "Mas gosta da ideia, que traz um novo significado para todo o trajeto que voc� fez at� agora. \n"
                                                                    + "'Eu queria ter pais aventureiros, no m�nimo algum conhecido que seja aventureiro.' \n\n"
                                                                    + "Falando t�o alto um desejo particular, voc� fica sem resposta por um momento. \n"
                                                                    + "'Ah! Voc� ser� o primeiro!' \n\n"
                                                                    + "Nina percebe a oportunidade que est� ganhando. \n"
                                                                    + "Mas que logo estar� sendo interrompida pelo tarveneiro. \n"
                                                                    + "'O primeiro de muitos, se continuar trabalhando.' \n\n"
                                                                    + "Tendo a aten��o chamada pelo chefe, ela volta a trabalhar. \n"
                                                                    + "J� o tarveneiro, ele lhe conta um fato curioso. \n\n"
                                                                    + "'Sabe, conhe�o um paladino que seu filho tamb�m � paladino.' \n"
                                                                    + "'Voc� n�o est� sozinho nessa. Ent�o � melhor come�ar a sua hist�ria, primeiramente, indo ao Norte.' \n\n"
                                                                    + "Voc� gostou da forma que ele disse isso, te fazendo rumar ao Norte.";
                                                        break;
                                                        
                                                        default:
                                                            texto = "\nSe � um motivo pessoal, que ele seja muito espec�fico. \n"
                                                                    + "Que abre um leque de op��es ainda maior. \n\n"
                                                                    + "'Se eu fosse uma nobre donzela, eu apenas abandonaria a nobreza para me tornar...' \n"
                                                                    + "'Uma feiticeira!' \n\n"
                                                                    + "Ela gosta de exclamar de vez em quando. \n"
                                                                    + "Que chama a aten��o do chefe dela, o tarveneiro. \n\n"
                                                                    + "'Ent�o seu primeiro feiti�o ser� trazer uma bandeja de cerveja para a mesa 3.' \n"
                                                                    + "Voc� acha c�mico, mas n�o ri, s� sorrindo de canto. \n\n"
                                                                    + "Sem ela por perto, voc� volta a estaca quase zero. \n"
                                                                    + "Quase zero, pois o tarveneiro tem a solu��o para seu vazio. \n\n"
                                                                    + "'Quem sabe possa convid�-la pra uma pr�xima aventura?' \n"
                                                                    + "'Mas n�o dessa de agora, que estou propondo.' \n"
                                                                    + "'O local � ao Norte, pr�ximo de Feist. Consegue ir l�?' \n\n"
                                                                    + "Tendo nenhuma obje��o, voc� parte diretamente para l�.";
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
                                                    texto = "\nVoc� percebe a pequena pausa para ela raciocinar. \n"
                                                            + "Pois a sua no��o de idade � diferente, uma vez que n�o � humano. \n\n"
                                                            + "Com essa confus�o engra�ada, ela n�o v� problema em dizer a idade. \n"
                                                            + "'Tenho 18.' \n\n"
                                                            + "Independentemente, essa pergunta somente saciou sua curiosidade. \n"
                                                            + "E voc� n�o sabe como prosseguir porque o assunto morreu. \n\n"
                                                            + "Logo, quem chega para enterrar o caix�o � o tarveneiro. \n"
                                                            + "'Voc�s t�m tempo para papo furado, mas para trabalhar n�o n�?' \n\n"
                                                            + "Rapidamente, a mo�a volta ao trabalho. \n"
                                                            + "Enquanto que um objetivo lhe � dado. \n"
                                                            + "'Siga ao Norte, olhe para o lado, eventualmente vai achar algo interessante.' \n\n"
                                                            + "Tendo isso em mente, voc� parte.";
                                                }
                                                else
                                                {
                                                    texto = "\n� inadequado perguntar isso a uma mulher. \n"
                                                            + "Mas n�o � muito problema para a mo�a compreens�vel. \n"
                                                            + "'Tenho 18.' \n\n"
                                                            + "A forma r�spida dela responder pareceu te afetar. \n"
                                                            + "N�o tendo tempo para construir uma conversa, logo lhe � questionado. \n"
                                                            + "'Por que a pergunta?' \n\n"
                                                            + "De forma impulsiva, voc� fala com honestidade para tentar tirar o peso dos ombros. \n"
                                                            + "'Oh. Obrigada. Hihi.' \n\n"
                                                            + "Tendo aceito o elogio, parece que resolveu a situa��o contransgedora. \n"
                                                            + "Mas nada mais constrangedor que isso � o supervisor dela ter escutado tudo isso. \n"
                                                            + "'Qual foi, voc�s n�o s�o mais crian�as, por que essa lenga lenga toda?' \n\n"
                                                            + "Percebendo que estava matando trabalho, ela volta a servir outros clientes. \n"
                                                            + "'Quanto a voc�, deve estar na idade para umas boas aventuras.' \n\n"
                                                            + "O tarveneiro lhe conta sobre ir ao Norte pois encontrar� algo interessante. \n"
                                                            + "Voc� parte em desventura.";
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
                    
            //Miss�o da Carta
            if(inv.contains("Carta"))
            {
                texto = "Tarde. Pra�a das Luzes. \n\n"
                        + "Voc� segue as recomenda��es do recado, demorando um pouco para achar o centro comercial da cidade. \n"
                        + "Mas a� est� voc�, sentado na beirada do chafariz desta pra�a decidindo para onde ir. \n";
                typeWriter(texto, velocidadeTexto);
                        
                while(rodandoCompra)
                {
                    System.out.println("\nOnde deseja fazer compras?");
                    System.out.println("\nOr�amento: "+budget);
                    System.out.println("\n1 - Casa do Verde \n2 - Botalar Ferrarias \n3 - Ninho da Coruja \n\n4 - Encerrar compra \n");
                    opcao = read.nextInt();
                        
                    while(opcao < 1 || opcao > 4)
                    {
                        System.out.println("\nClaro que h� mais lojas al�m destas, mas elas n�o s�o de seu interesse.");
                        System.out.println("\nOnde deseja fazer compras?");
                        System.out.println("\n1 - Casa do Verde \n2 - Botalar Ferrarias \n3 - Ninho da Coruja \n\n4 - Encerrar compra \n");
                        opcao = read.nextInt();
                    }
                        
                    switch(opcao)
                    {
                        case 1:
                            System.out.println("\nO que deseja comprar?");
                            System.out.println("\nOr�amento: "+budget);
                            System.out.println("\n1 - Po��o de Cura [50 Moedas] \n2 - Po��o de Cura Retardada [500 Moedas] \n\n3 - Cancelar compra \n");
                            opcao = read.nextInt();
                               
                            while(opcao < 1 || opcao > 3)
                            {
                                System.out.println("\nSomente estes itens.");
                                System.out.println("\nOr�amento: "+budget);
                                System.out.println("\n1 - Po��o de Cura [50 Moedas] \n2 - Po��o de Cura Retardada [500 Moedas] \n\n3 - Cancelar compra \n");
                                opcao = read.nextInt();
                            }
                                
                            switch(opcao)
                            {
                                case 1: inv.add("Po��o de Cura"); budget -= 50; break;
                                case 2:
                                    if(contadorPR == 1)
                                    {
                                        texto = "\nVoc� acha um tanto engra�ado uma po��o ser nomeada dessa forma. \n"
                                                + "O dono da loja nota a sua obsess�o por tal produto. \n"
                                                + "'Deseja comprar? Ela � a �ltima do estoque.' \n\n"
                                                + "Primeiramente, voc� pergunta o que ela faz. \n"
                                                + "'Ela te cura assim que voc� fica inconsciente ou perto de morrer.' \n\n"
                                                + "Pelo modo que ele falou, n�o tem como achar que seja um golpe. \n"
                                                + "Portanto, decide comprar?";
                                        typeWriter(texto, velocidadeTexto);
                                        
                                        System.out.println("\n\nSim ou N�o?");
                                        read.nextLine();
                                        resposta = read.nextLine().toUpperCase();
                                        
                                        while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                                        {
                                            System.out.println("\nAinda errando isso?");
                                            System.out.println("\nSim ou N�o?");
                                            resposta = read.nextLine().toUpperCase();
                                        }
                                        if(resposta.equals("SIM") || resposta.equals("S"))
                                        {
                                            System.out.println("\nVoc� imediatamente bebe a po��o assim que a compra.");
                                            inv.add("Po��o de Cura Retardada");
                                            budget -= 500;
                                            contadorPR = 3;
                                            
                                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                            resposta = read.nextLine();
                                        }
                                        else
                                        {
                                            System.out.println("\nVoc� n�o compra.");
                                            contadorPR = 2;
                                        }
                                    }
                                    else if(contadorPR == 2)
                                    {
                                        System.out.println("\nDeseja comprar? Sim ou N�o?");
                                        read.nextLine();
                                        resposta = read.nextLine().toUpperCase();
                                        
                                        while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                                        {
                                            System.out.println("\nAinda errando isso?");
                                            System.out.println("\nSim ou N�o?");
                                            resposta = read.nextLine().toUpperCase();
                                        }
                                        
                                        if(resposta.equals("SIM") || resposta.equals("S"))
                                        {
                                            System.out.println("\nVoc� imediatamente bebe a po��o assim que a compra.");
                                            inv.add("Po��o de Cura Retardada");
                                            budget -= 500;
                                            contadorPR = 3;
                                            
                                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                            resposta = read.nextLine();
                                        }
                                        else
                                            System.out.println("\nVoc� n�o compra.");
                                    }
                                    else
                                        System.out.println("\nS� se pode comprar uma vez.");
                                break;
                                default: System.out.println("\nVoc� cancela a compra.");
                            }
                        break;
                            
                        case 2:
                            System.out.println("\nO que deseja comprar?");
                            System.out.println("\nOr�amento: "+budget);
                            System.out.println("\n1 - Aprimorar Arma [200 Moedas] \n2 - Armadura de Couro Batido [50 Moedas] \n3 - Cota de Talas [200 Moedas] \n\n4 - Cancelar compra \n");
                            opcao = read.nextInt();
                                
                            while(opcao < 1 || opcao > 4)
                            {
                                System.out.println("\nSomente estes itens.");
                                System.out.println("\nOr�amento: "+budget);
                                System.out.println("\n1 - Aprimorar Arma [200 Moedas] \n2 - Armadura de Couro Batido [50 Moedas] \n3 - Cota de Talas [200 Moedas] \n\n4 - Cancelar compra \n");
                                opcao = read.nextInt();
                            }
                                    
                            switch(opcao)
                            {
                                case 1:
                                    if(contadorUpgrade <= 3)
                                    {
                                        System.out.println("\nVoc� aprimorou sua arma. \nEla agora d� +"+aumento+" no ataque e dano.");
                                        budget -= 200;
                                        ataqueJogador++;
                                        bonusDanoJogador++;
                                        contadorUpgrade++;
                                        aumento++;
                                    }
                                    else
                                        System.out.println("\nVoc� chegou ao limite de aprimoramentos.");
                                break;
                                        
                                case 2:
                                    if(contadorCouro == 1)
                                    {
                                        System.out.println("\nVoc� obteve Armadura de Couro Batido.");
                                        budget -= 50;
                                        contadorCouro++;
                                        inv.add("Armadura de Couro Batido");
                                        if(classe.equals("Ladino"))
                                        {
                                            System.out.println("Sua Armadura aumentou em +1.");
                                            CA++;
                                        }
                                        else
                                            System.out.println("\nParab�ns, voc� comprou um item que ser� in�til.");
                                    }
                                    else
                                        System.out.println("\nS� se pode comprar uma vez.");
                                break;
                                        
                                case 3:
                                    if(contadorTalas == 1)
                                    {
                                        System.out.println("\nVoc� obteve Cota de Talas.");
                                        budget -= 200;
                                        contadorTalas++;
                                        inv.add("Cota de Talas");
                                        if(classe.equals("Guerreiro"))
                                        {
                                            System.out.println("Sua Armadura aumentou em +1.");
                                            CA++;
                                        }
                                        else
                                            System.out.println("\nParab�ns, voc� comprou um item que ser� in�til.");
                                    }
                                    else
                                        System.out.println("\nS� se pode comprar uma vez.");
                                break;
                                        
                                default:
                                    System.out.println("\nVoc� cancela a compra.");
                            }
                        break;
                                
                        case 3:
                            System.out.println("\nO que deseja comprar?");
                            System.out.println("\nOr�amento: "+budget);
                            System.out.println("\n1 - Aumento Tempor�rio de For�a [300 Moedas] \n2 - Aumento Tempor�rio de Destreza [300 Moedas] \n3 - Aumento Tempor�rio de Intelig�ncia [300 Moedas] \n\n4 - Cancelar compra \n");
                            opcao = read.nextInt();
                                    
                            while(opcao < 1 || opcao > 4)
                            {
                                System.out.println("\n� s� isso.");
                                System.out.println("\nOr�amento: "+budget);
                                System.out.println("\n1 - Aumento Tempor�rio de For�a [300 Moedas] \n2 - Aumento Tempor�rio de Destreza [300 Moedas] \n3 - Aumento Tempor�rio de Intelig�ncia [300 Moedas] \n\n4 - Cancelar compra \n");
                                opcao = read.nextInt();
                            }
                                    
                            switch(opcao)
                            {
                                case 1:
                                    if(contador == 1)
                                    {
                                        if(str >= 10)
                                        {
                                            System.out.println("\nVoc� aumentou sua For�a em 14.");
                                            str = 14;
                                            budget -= 300;
                                            contador++;
                                        }
                                        else
                                        {
                                            System.out.println("\nVoc� aumentou sua For�a em 10.");
                                            str = 10;
                                            budget -= 300;
                                            contador++;
                                        }
                                    }
                                    else
                                        System.out.println("\nVoc� s� pode comprar uma �nica vez um deles.");
                                break;
                                        
                                case 2:
                                    if(contador == 1)
                                    {
                                        if(dex >= 10)
                                        {
                                            System.out.println("\nVoc� aumentou sua Destreza em 14.");
                                            dex = 14;
                                            budget -= 300;
                                            contador++;
                                        }
                                        else
                                        {
                                            System.out.println("\nVoc� aumentou sua Destreza em 10.");
                                            dex = 10;
                                            budget -= 300;
                                            contador++;
                                        }
                                    }
                                    else
                                        System.out.println("\nVoc� s� pode comprar uma �nica vez um deles.");
                                break;
                                        
                                case 3:
                                    if(contador == 1)
                                    {
                                        if(inte >= 10)
                                        {
                                            System.out.println("\nVoc� aumentou sua Intelig�ncia em 14.");
                                            inte = 14;
                                            budget -= 300;
                                            contador++;
                                        }
                                        else
                                        {
                                            System.out.println("\nVoc� aumentou sua Intelig�ncia em 10.");
                                            inte = 10;
                                            budget -= 300;
                                            contador++;
                                        }
                                    }
                                    else
                                        System.out.println("\nVoc� s� pode comprar uma �nica vez um deles.");
                                break;
                                        
                                default:
                                    System.out.println("\nVoc� cancela a compra.");
                            }
                        break;
                                
                        default:
                            System.out.println("\nVoc� encerra suas compras.");
                            rodandoCompra = false;
                    }
                }
                        
                if(budget < 0)
                {
                    texto = "Parece que voc� realmente exagerou nas compras. \n"
                            + "Ficando no negativo, voc� fica indeciso no que vai fazer quanto a isso.";
                    typeWriter(texto, velocidadeTexto);
                    
                    if(budget+moedas >= 0)
                    {
                        texto = "\n\nPor�m, voc� lembra que ainda possui moedas. \n"
                                + "E elas s�o suficiente para quitar esta d�vida. \n\n"
                                + "Com um pouco de receio, voc� d� andamento na miss�o.";
                        typeWriter(texto, velocidadeTexto);
                                
                        System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                        read.nextLine();
                        resposta = read.nextLine();
                        limpaTela();
                    }
                    else if(budget+moedas < 0)
                    {
                        texto = "\n\nNem com sua quantia de moedas consegue suprir o valor negativado. \n"
                                + "Obrigando a voc� deixar de pensar na recompensa e te fazendo pensar numa decis�o.";
                        typeWriter(texto, velocidadeTexto);
                                
                        System.out.println("\n\nDeseja continuar? Sim ou N�o?");
                        read.nextLine();
                        resposta = read.nextLine().toUpperCase();
                                
                        while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                        {
                            System.out.println("\nN�o h� como fugir desta decis�o.");
                            System.out.println("\nDeseja continuar? Sim ou N�o?");
                            resposta = read.nextLine().toUpperCase();
                        }
                                
                        if(resposta.equals("SIM") || resposta.equals("S"))
                        {
                            texto = "\nVoc� est� esperan�oso e espera que esse tal Duque compreenda sua situa��o. \n"
                                    + "Decidindo continuar trilhando indo, definitivamente, para o Norte.";
                            typeWriter(texto, velocidadeTexto);
                            
                            System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                            resposta = read.nextLine();
                            limpaTela();
                        }
                        else
                        {
                            texto = "\nVoc� pega a carta e tudo que voc� tem. \n"
                                    + "E decide ir embora, que muito provavelmente um grupo estar� perseguindo voc� nos pr�ximos dias.";
                            typeWriter(texto, velocidadeTexto);
                                    
                            System.out.println("\n\nParab�ns! Voc� gastou as moedas de forma irrespons�vel! \n\nFinal 3 de 6");
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
                        
                    texto = "Ap�s tomar uma m�gica muito forte, que foi capaz de aumentar suas habilidades. \n"
                            + "Voc� se sente mais forte, portanto, confira como est� seu personagem: \n\n";
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
            //Miss�o da Dungeon
            else
            {
                texto = "Tarde. Estraga Longa. \n\n"
                        +"Voc� j� est� h� um tempo percorrendo esta estrada de terra. \n"
                        + "Que decide acampar sentando em volta de uma fogueira. \n\n"
                        + "Comendo seu p�o com ovo, voc� at� agora n�o encontrou amea�as. \n"
                        + "Mas voc� d� andamento com seu caminho.";
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
                        String inimigos[] = {"Worg", "Carni�al", "Harpia", "Armadura Animada"};
                        inimigo = inimigos[aleatorio(inimigos.length)-1];
                                   
                        ultimaLetra = inimigo.charAt(inimigo.length()-1);
                                    
                        switch(inimigo)
                        {
                            case "Worg": resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+4, 13, 5, 3, 6); break;
                            case "Carni�al": resultado = valoresInimigo(aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8), 12, 4, 2, 4); break;
                            case "Harpia": resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+7, 11, 6, 3, 6); break;
                            default: resultado = valoresInimigo(((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+6), 18, 4, 2, 6);
                        }
                                    
                        vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    }
                    else if(chance == 100)
                    {
                        texto = "\nEnquanto voc� est� caminhando, um po�o chama sua aten��o. \n";
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
                            System.out.println("\nN�o, n�o d� para se jogar no po�o.");
                            System.out.println("O que deseja fazer?");
                            System.out.println("\n1 - Beber \n2 - Ignorar \n");
                            opcao = read.nextInt();
                        }
                                
                        if(opcao == 1)
                        {
                            System.out.println("\nVoc� bebe e nada mudou... aparentemente.");
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
                        texto = "\nVoc� passa despercebido pelos monstros. \n";
                        typeWriter(texto, velocidadeTexto);
                                
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para para continuar.");
                        resposta = read.nextLine();
                                
                        limpaTela();
                                
                        contador++;
                    }
                    
		    if(chance >= 30 && chance < 100)
	 	    {
                    	if(ultimaLetra == 'a')
                            texto = "\nVoc� se depara com uma "+inimigo+"! \n\n";
                        else
                            texto = "\nVoc� se depara com um "+inimigo+"! \n\n";
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
                        
                    texto = "Ap�s lutar com diversos monstros, voc� sobe de n�vel! \n";
                    typeWriter(texto, velocidadeTexto);
                        
                    System.out.println("No que deseja distribuir seus 4 pontos? \n");
                    System.out.print("For�a: ");
                    strUp = read.nextInt();
                    System.out.print("Destreza: ");
                    dexUp = read.nextInt();
                    System.out.print("Intelig�ncia: ");
                    inteUp = read.nextInt();
                        
                    while(strUp+dexUp+inteUp != 4)
                    {
                        System.out.println("\nHouve algum erro de c�lculo.");
                        System.out.print("For�a: ");
                        strUp = read.nextInt();
                        System.out.print("Destreza: ");
                        dexUp = read.nextInt();
                        System.out.print("Intelig�ncia: ");
                        inteUp = read.nextInt();
                    }
                        
                    while(strUp < 0 || dexUp < 0 || inteUp < 0)
                    {
                        System.out.print("\nN�o pode ser negativo.");
                        System.out.print("For�a: ");
                        strUp = read.nextInt();
                        System.out.print("Destreza: ");
                        dexUp = read.nextInt();
                        System.out.print("Intelig�ncia: ");
                        inteUp = read.nextInt();
                    }
                    
                    System.out.println("\nDeseja pegar vida fixa? Sim ou N�o?");
                    read.nextLine();
                    resposta = read.nextLine().toUpperCase();
                    
                    while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                    {
                        System.out.println("Confirme novamente. Sim ou N�o?");
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
                            
                    texto = "Contentando-se ap�s superar um obst�culo como esse, voc� v� ao longe uma entrada. \n";
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
                        + "Voc� est� preparado ap�s fazer suas compras. \n"
                        + "Por�m, ao mesmo tempo, os monstros tiveram tempo para crescerem em quantidade. \n\n"
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
                        String inimigos[] = {"Ratomem", "G�rgula", "Slime", "Cobra Constritora Gigante"};
                        inimigo = inimigos[aleatorio(inimigos.length-1)];
                                
                        ultimaLetra = inimigo.charAt(inimigo.length()-1);
                                
                        switch(inimigo)
                        {
                            case "Ratomem": resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+6, 12, 4, 2, 4); break;
                            case "G�rgula": resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+21, 15, 4, 2, 6); break;
                            case "Slime": resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+12, 8, 4, 2, 6); break;
                            default: resultado = valoresInimigo((aleatorio(12)+aleatorio(12)+aleatorio(12)+aleatorio(12)+aleatorio(12)+aleatorio(12)+aleatorio(12)+aleatorio(12))+8, 12, 6, 4, 6); ultimaLetra = 'a';
                        }
                                
                        vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    }
                    //Monstros CR 3
                    else if(chance == 100)
                    {
                        String inimigos[] = {"Lobisomem", "Manticora", "C�o Infernal", "Pesadelo"};
                        inimigo = inimigos[aleatorio(inimigos.length-1)];
                                
                        ultimaLetra = inimigo.charAt(inimigo.length()-1);
                                
                        switch(inimigo)
                        {
                            case "Lobisomem": resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+18, 12, 4, 2, 8); break;
                            case "Manticora": resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+24, 14, 5, 3, 8); break;
                            case "C�o Infernal": resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+14, 15, 5, 3, 8); break;
                            default: resultado = valoresInimigo((aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10)+aleatorio(10))+24, 13, 6, 4, 8);
                        }
                                
                        vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    }
                    else
                    {
                        texto = "\nVoc� passa despercebido pelos monstros. \n";
                        typeWriter(texto, velocidadeTexto);
                               
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para para continuar.");
                        resposta = read.nextLine();
                               
                        limpaTela();
                                
                        contador++;
                    }
                    
		    if(chance >= 30 && chance < 100)
		    {
                    	if(ultimaLetra == 'a')
                        	texto = "\nVoc� se depara com uma "+inimigo+"! \n\n";
                    	else
                        	texto = "\nVoc� se depara com um "+inimigo+"! \n\n";
                    	typeWriter(texto, velocidadeTexto);
                              
                    	vidaJogador = combate(vidaMaxJogador, velocidadeTexto, inv, rodandoCombate, classe, inimigo, vidaInimigo, bonusAtaqueInimigo, bonusDanoInimigo, indicieDanoInimigo, CAInimigo, vidaJogador, ataqueJogador, danoJogador, bonusDanoJogador, indicieDanoJogador, CA, bonusDex);
                               
                    	if(vidaJogador > 0)
                            contador++;
                    	else if(vidaJogador <= 0 && inv.contains("Po��o de Cura Retardada"))
                    	{
                            System.out.println("\nS� que n�o!");
                            System.out.println("\nA po��o fez efeito e voc� recupera metade dos seus pontos de vida.");
                            vidaJogador = vidaMaxJogador / 2;
                            inv.remove("Po��o de Cura Retardada");
                            
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
                        
                        texto = "Ap�s lutar com diversos monstros, voc� sobe de n�vel! \n";
                        typeWriter(texto, velocidadeTexto);
                        
                        System.out.println("No que deseja distribuir seus 4 pontos? \n");
                        System.out.print("For�a: ");
                        strUp = read.nextInt();
                        System.out.print("Destreza: ");
                        dexUp = read.nextInt();
                        System.out.print("Intelig�ncia: ");
                        inteUp = read.nextInt();
                   
                        while(strUp+dexUp+inteUp != 4)
                        {
                            System.out.println("\nHouve algum erro de c�lculo.");
                            System.out.print("For�a: ");
                            strUp = read.nextInt();
                            System.out.print("Destreza: ");
                            dexUp = read.nextInt();
                            System.out.print("Intelig�ncia: ");
                            inteUp = read.nextInt();
                        }
                    
                        while(strUp < 0 || dexUp < 0 || inteUp < 0)
                        {
                            System.out.println("\nN�o pode ser negativo.");
                            System.out.print("For�a: ");
                            strUp = read.nextInt();
                            System.out.print("Destreza: ");
                            dexUp = read.nextInt();
                            System.out.print("Intelig�ncia: ");
                            inteUp = read.nextInt();
                        }
                        
                        System.out.println("\nDeseja pegar vida fixa? Sim ou N�o?");
                        read.nextLine();
                        resposta = read.nextLine().toUpperCase();
                        
                        while(!resposta.equals("SIM") && !resposta.equals("S") && !resposta.equals("NAO") && !resposta.equals("N"))
                        {
                            System.out.println("\nConfirme novamente, Sim ou N�o?");
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
                    
                    texto = "Voc� finalmente chega no seu destino. \n";
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
                            + "'Por que est� querendo entrar?'";
                    typeWriter(texto, velocidadeTexto);
                            
                    System.out.println("\n\nComo deseja responder?");
                    System.out.println("\n1 - Entregar carta \n2 - Falar sobre o Conde de Feist \n");
                    opcao = read.nextInt();
                    
                    while(opcao < 1 || opcao > 3)
                    {
                        System.out.println("\nVamos direto ao assunto, n�?");
                        System.out.println("\nComo deseja responder?");
                        System.out.println("\n1 - Entregar carta \n2 - Falar sobre o Conde de Feist \n");
                        opcao = read.nextInt();
                    }
                    
                    switch(opcao)
                    {
                        case 1:
                            texto = "\nVoc� entrega a carta para ele. \n\n"
                                    + "O guarda confere o selo e rapidamente entende do que se trata. \n"
                                    + "Logo, voc� � recompensado com as devidas moedas. \n"
                                    + "'Obrigado pelo seu servi�o.' \n\n";
                            typeWriter(texto, velocidadeTexto);
                            
                            if(budget <= 0)
                            {
                                texto = "Mas � uma pena, voc� recebe nada na verdade. \n"
                                        + "Pelo menos fez um bom investimento em si mesmo comprando tantos equipamentos.";
                                typeWriter(texto, velocidadeTexto);
                            }
                            else
                            {
                                System.out.println("Voc� obteve "+budget+" moedas.");
                                moedas += budget;
                            }
                        
                            System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                            read.nextLine();
                            resposta = read.nextLine();
                            
                            limpaTela();
                        
                            texto = "Tendo terminado a miss�o, voc� novamente volta a perambular por a�. \n"
                                    + "At� encontrar mais uma vez alguma aventura como esta.";
                            typeWriter(texto, velocidadeTexto);
                        
                            System.out.println("\n\nParab�ns! Voc� terminou o jogo! \n\nFinal 1 de 6");
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                            resposta = read.nextLine();
                            rodandoParte3 = false;
                        break;
                        
                        case 2:
                            texto = "\nVoc� conta sobre o Conde e que precisa encontrar com ele. \n\n"
                                    + "O guarda questiona os seus motivos. \n"
                                    + "Com isso, voc� s� mostra a carta para ele. \n\n"
                                    + "'Ah, foi-me avisado que algum mensageiro viria.' \n"
                                    + "'N�o esperava que fosse um aventureiro.' \n"
                                    + "'Enfim, aqui est� suas moedas.' \n\n";
                            typeWriter(texto, velocidadeTexto);
                            
                            if(budget <= 0)
                            {
                                texto = "Mas � uma pena, voc� recebe nada na verdade. \n"
                                        + "Pelo menos fez um bom investimento em si mesmo comprando tantos equipamentos.";
                                typeWriter(texto, velocidadeTexto);
                            }
                            else
                            {
                                System.out.println("Voc� obteve "+budget+" moedas.");
                                moedas += budget;
                            }
                        
                            System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                            read.nextLine();
                            resposta = read.nextLine();
                            
                            limpaTela();
                        
                            texto = "Tendo terminado a miss�o, voc� novamente volta a perambular por a�. \n"
                                    + "At� encontrar mais uma vez alguma aventura como esta.";
                            typeWriter(texto, velocidadeTexto);
                        
                            System.out.println("\n\nParab�ns! Voc� terminou o jogo! \n\nFinal 1 de 6");
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                            resposta = read.nextLine();
                            rodandoParte3 = false;
                        break;
                                    
                        default:
                            texto = "\nParab�ns! Voc� achou um segredo! \n"
                                    + "Apesar de n�o ser nada favor�vel para voc�. \n"
                                    + "Pois voc� acaba de come�ar um combate com o guarda.";
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
                                texto = "\nVoc� n�o tem a m�nima ideia do porqu� fez isso. \n"
                                        + "Mas agora ter� que escolher entre perpetuar esse caminho ou render-se antes que piore.";
                                typeWriter(texto, velocidadeTexto);
                                
                                System.out.println("\n1 - Continuar \n2 - Parar \n");
                                opcao = read.nextInt();
                                    
                                while(opcao < 1 || opcao > 2)
                                {
                                    System.out.println("\nN�o vai ter dois segredos seguidos.");
                                    System.out.println("\n1 - Continuar \n2 - Parar \n");
                                    opcao = read.nextInt();
                                }
                                            
                                if(opcao == 1)
                                {
                                    texto = "\nVoc� escolheu ser um fora da lei procurado por incomodar a guarni��o. \n\n"
                                            + "Final 4 de 6";   
                                    typeWriter(texto, velocidadeTexto);
                                    System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                                    read.nextLine();
                                    resposta = read.nextLine();
                                    rodandoParte3 = false;
                                }
                                else
                                {
                                    texto = "\nVoc� foi preso na cena do crime, agora tendo que passar algum tempo numa pris�o. \n\n"
                                            + "Final 5 de 6";
                                    typeWriter(texto, velocidadeTexto);
                                    System.out.println("\nPressione ENTER ou digite qualquer coisa para voltar ao MENU.");
                                    read.nextLine();
                                    resposta = read.nextLine();
                                    rodandoParte3 = false;
                                }
                            }
                            else if(vidaJogador <= 0 && inv.contains("Po��o de Cura Retardada"))
                            {
                                System.out.println("\nS� que n�o!");
                                System.out.println("\nA po��o fez efeito e voc� recupera metade dos seus pontos de vida.");
                                vidaJogador += vidaMaxJogador / 2;
                                inv.remove("Po��o de Cura Retardada");
                            
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
                texto = "Assim que voc� entra nestas ru�nas de pedra, voc� se v� diante de uma escada que desce. \n"
                        + "Mas antes que pudesse desc�-las, no mesmo instante um papel velho cai aos seus p�s. \n"
                        + "Voc� visualiza e parece ser um mapa de um calabou�o.";
                typeWriter(texto, velocidadeTexto);
                
                System.out.println("\n\nVoc� obteve Mapa da Masmorra.");
                inv.add("Mapa da Masmorra");
                
                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                resposta = read.nextLine();
                        
                limpaTela();
                
                texto = "Ap�s descer as escadas, voc� enxerga uma porta j� aberta. \n"
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
                    System.out.println("\nJ - Jogador | M - Monstro | P - Porta | S - Sa�da | D - Locais de Descanso | ? - Item | # - Parede | . - Vazio");
                    System.out.println("\nSTATUS");
                    System.out.println("Pontos de Vida M�ximo: "+vidaMaxJogador);
                    System.out.println("Pontos de Vida Atual: "+vidaJogador);
                    System.out.println("\nPara onde deseja ir?");
                    System.out.println("\nW - Cima | A - Esquerda | S - Baixo | D - Direita \n");
                    resposta = read.nextLine().toUpperCase();
            
                    while(!resposta.equals("W") && !resposta.equals("A") && !resposta.equals("S") && !resposta.equals("D"))
                    {
                        System.out.println("\nOp��o inv�lida.");
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
                            System.out.println("\nVoc� n�o pode se mover para c�.");
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
                                texto = "\nVoc� se depara com uma "+inimigo+"! \n\n";
                            else
                                texto = "\nVoc� se depara com um "+inimigo+"! \n\n";
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
                    
                            System.out.println("\nVoc� recuperou totalmente seus pontos de vida!");
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
                    
                            texto = "\nVoc� finalmente alcan�a o tal do necromante. \n"
                                    + "S� que ele j� estava preparando um formid�vel inimigo para voc� enfrentar. \n\n"
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
                                texto = "Voc� destr�i o grande ogro zumbi e, consequentemente, levando o necromante junto. \n"
                                        + "Por�m, chegando perto de onde ele caiu, j� desapareceu num instante. \n\n"
                                        + "Dando de ombros pela situa��o, voc� continua seu caminho.";
                                typeWriter(texto, velocidadeTexto);
                                
                                System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                                
                                texto = "\n'Achou que havia acabado?' \n"
                                        + "O necromante retira o manto. \n\n"
                                        + "E mostra presas e garras como a de um vampiro. \n"
                                        + "Voc� volta e prepara-se para mais um combate.";
                                typeWriter(texto, velocidadeTexto);
                                
                                System.out.println("\n\nPressione ENTER ou digite qualquer coisa para lutar contra o Chefe.");
                                resposta = read.nextLine();
                                
                                inimigo = "Necromante";
                                resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+33, 15, 6, 3, 8);
                                vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    
                                vidaJogador = combate(vidaMaxJogador, velocidadeTexto, inv, rodandoCombate, classe, inimigo, vidaInimigo, bonusAtaqueInimigo, bonusDanoInimigo, indicieDanoInimigo, CAInimigo, vidaJogador, ataqueJogador, danoJogador, bonusDanoJogador, indicieDanoJogador, CA, bonusDex);
                                
                                if(vidaJogador > 0)
                                {
                                    texto = "Voc� finalmente derrota este necromante, mas ele misteriosamente desaparece na sua frente. \n"
                                            + "Parece que voc� eventualmente v� se encontrar com ele futuramente. \n"
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
                            texto = "\nUm enorme esqueleto de minotauro est� guardando um precioso item atr�s dele. \n"
                                    + "Voc� n�o consegue passar, a n�o ser que suba nos ossos.";
                            typeWriter(texto, velocidadeTexto);
                            
                            System.out.println("\n\nO que decide fazer?");
                            System.out.println("\n1 - Vou querer o item \n2 - Deixa pra l� \n");
                            opcao = read.nextInt();
                            
                            while(opcao < 1 || opcao > 2)
                            {
                                System.out.println("\nNem tente outras coisas.");
                                System.out.println("\n\nO que decide fazer?");
                                System.out.println("\n1 - Vou querer o item \n2 - Deixa pra l� \n");
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
                                    texto = "\nEra �bvio que ele ia despertar. \n"
                                            + "Voc� est� diante de um minotauro esquel�tico!";
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
                                        System.out.println("Voc� derrotou o Chefe!");
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
                                    texto = "\nPor incr�vel que pare�a, o esqueleto n�o despertou para te arrega�ar.";
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
                                System.out.println("\nVoc� obteve Espada da Luz Lunar");
                                System.out.println("\nEsta espada pode ser usada por qualquer classe.");
                                inv.add("Espada da Luz Lunar");
                                
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                            }
                            else if(m[y][x] == m[18][12])
                            {
                                System.out.println("\nVoc� obteve 10 Po��es de Cura.");
                                inv.add("Po��o de Cura"); inv.add("Po��o de Cura"); inv.add("Po��o de Cura"); inv.add("Po��o de Cura"); inv.add("Po��o de Cura"); inv.add("Po��o de Cura"); inv.add("Po��o de Cura"); inv.add("Po��o de Cura"); inv.add("Po��o de Cura"); inv.add("Po��o de Cura");
                               
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                            }
                            else if(m[y][x] == m[14][16])
                            {
                                System.out.println("\nVoc� obteve Anel Vamp�rico.");
                                System.out.println("\nEste anel regenera vida conforme voc� acerta ataques.");
				inv.add("Anel Vamp�rico");				

                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                            }
                            else if(m[y][x] == m[7][7])
                            {
                                System.out.println("\nVoc� obteve Anel do Ataque Bestial.");
                                System.out.println("\nEste anel concede um b�nus no dano em ataques sucessivos.");
                                inv.add("Anel do Ataque Bestial");
                                
                                System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                            }
                            else if(m[y][x] == m[1][18])
                            {
                                System.out.println("\nVoc� obteve Capa Dissimuladora");
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
                            
                            texto = "\nVoc� est� diante de dois b�us. \n";
                            typeWriter(texto, velocidadeTexto);
                                
                            if(m[y][x] == m[2][1])
                            {
                                texto = "Mas optou o b�u da direita.";
                                typeWriter(texto, velocidadeTexto);
                                
                                texto = "\n\nAo abrir tal ba� de tesouros, voc� se depara com uma surpresa. \n"
                                        + "Dentes afiados, uma enorme l�ngua, longos bra�os e pernas aparecerem. \n\n"
                                        + "Voc� engaja em combate.";
                                typeWriter(texto, velocidadeTexto);
                                
                                System.out.println("\n\nPressione ENTER ou digite qualquer coisa para continuar.");
                                resposta = read.nextLine();
                               
                                inimigo = "Ba� M�mico";
                                resultado = valoresInimigo((aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8)+aleatorio(8))+18, 12, 5, 3, 8);
                                vidaInimigo = resultado[0]; CAInimigo = resultado[1]; bonusAtaqueInimigo = resultado[2]; bonusDanoInimigo = resultado[3]; indicieDanoInimigo = resultado[4];
                    
                                vidaJogador = combate(vidaMaxJogador, velocidadeTexto, inv, rodandoCombate, classe, inimigo, vidaInimigo, bonusAtaqueInimigo, bonusDanoInimigo, indicieDanoInimigo, CAInimigo, vidaJogador, ataqueJogador, danoJogador, bonusDanoJogador, indicieDanoJogador, CA, bonusDex);
                              
                                if(vidaJogador > 0)
                                {
                                    System.out.println("Voc� o derrota e obteve S�mbolo da Avareza.");
                                    inv.add("S�mbolo da Avareza");

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
                                texto = "Mas optou o b�u da esquerda.";
                                typeWriter(texto, velocidadeTexto);
                                
                                texto = "\n\nAbrindo o ba�, voc� se depara com muita riqueza acumulada.";
                                typeWriter(texto, velocidadeTexto);
                                   
                                System.out.println("\n\nVoc� obteve 1000 moedas.");
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

                                texto = "Voc� finalmente sai dessa masmorra. \n"
                                        + "Subindo as escadas, voc� enxerga o p�r do sol. \n"
                                        + "E muitas aventuras como essa ir�o chegar.";
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
                                
                                System.out.println("\nParab�ns! Voc� terminou o jogo! \n\nFinal 2 de 6");
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
                        System.out.println("\nN�o � um movimento poss�vel.");
                        System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                        resposta = read.nextLine();
                    }
                }
            }
        }
        }
    }
    
    //Fun��es
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
        
        System.out.println("\nIdade: "+idade+"\nClasse: "+classe+"\nRa�a: "+raca+"\nAntecedente: "+antecedente);       
        System.out.println("\nATRIBUTOS");
        System.out.println("Pontos de Vida: "+vidaMaxJogador+"\nArmadura: "+CA+"\nFor�a: "+str+" [+"+bonusStr+"] \nDestreza: "+dex+" [+"+bonusDex+"] \nIntelig�ncia: "+inte+" [+"+bonusInte+"] \n\nMoedas: "+moedas);
        System.out.println("\nInvent�rio: "+inv);
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
            System.out.println("Pontos de Vida M�xima: "+vidaMaxJogador);
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
                System.out.println("\nS� tem isso para fazer. Trabalho acima do lazer.");
                System.out.println("\nDESCANSO");
                System.out.println("\n1 - Continuar \n2 - Descansar \n");
                opcao = read.nextInt();
            }
            
            if(opcao == 1)
                rodandoDescanso = false;
            else
            {
                System.out.println("\nVoc� descansa e recupera toda a sua vida.");
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
        
        if(inv.contains("Po��o de Cura"))
        {
            vidaCurada = (aleatorio(6)+aleatorio(6))+2;
            System.out.println("\nVoc� recupera "+vidaCurada+" de vida.");
            vidaJogador += vidaCurada;
                            
            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
            resposta = read.nextLine();
                            
            removerPocao(inv);
        }
        else
        {
            System.out.println("\nVoc� n�o tem po��es de cura.");
            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
            resposta = read.nextLine();
        }
        return vidaJogador;
    }
    
    public static List<String> removerPocao(List<String> inv)
    {
        inv.remove("Po��o de Cura");
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
                System.out.println("Uma "+inimigo+" � seu inimigo. \n");
            else
                System.out.println("Um "+inimigo+" � seu inimigo. \n");
            
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
                
                System.out.println("Turno: "+turno+"\nPontos de Vida do Inimigo: "+vidaInimigo+"\nSeus Pontos de Vida: "+vidaJogador+"\n\nO que deseja fazer? \n\n1 - Atacar \n2 - Usar Po��o de Cura \n3 - Fugir \n");
                opcao = read.nextInt();
                
                while(opcao < 1 || opcao > 3)
                {
                    System.out.println("\nOp��o Inv�lida.");
                    System.out.println("\nO que deseja fazer?");
                    System.out.println("\n1 - Atacar \n2 - Usar Po��o de Cura \n3 - Fugir \n");
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
                                System.out.println("\nMagia indispon�vel.");
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
                            System.out.println("\nCr�tico! Todo seu dano � dobrado!");
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
                                System.out.println("\nComo o inimigo est� com a vida cheia, voc� d� "+danoAtaqueFurtivo+" a mais de dano.");
                                vidaInimigo -= danoAtaqueFurtivo;
                            }
                            
                            if(ultimaLetra == 'a')
                                System.out.println("\nVoc� ataca a "+inimigo+" e causa "+danoJogador+" de dano.");
                            else
                                System.out.println("\nVoc� ataca o "+inimigo+" e causa "+danoJogador+" de dano.");
                            vidaInimigo -= danoJogador;
                            
                            if(inv.contains("Anel Vamp�rico") && vidaJogador < vidaMaxJogador)
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
                                System.out.println("\nVoc� ataca a "+inimigo+" e causa "+danoJogador+" de dano.");
                            else
                                System.out.println("\nVoc� ataca o "+inimigo+" e causa "+danoJogador+" de dano.");
                            System.out.println("O inimigo � congelado, perdendo a vez.");
                            ataqueInimigo = 0;
                            vidaInimigo -= danoJogador;
                            
                            if(inv.contains("Anel Vamp�rico") && vidaJogador < vidaMaxJogador)
                            {
                                vidaJogador++;
                                if(vidaJogador > vidaMaxJogador)
                                    vidaJogador = vidaMaxJogador;
                            }
                            
                            sequencia++;
                        }
                        else
                        {
                            System.out.println("\nVoc� erra o ataque.");
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
                                System.out.println("\nA "+inimigo+" � derrotada.");
                            else
                                System.out.println("\nO "+inimigo+" � derrotado.");
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
                            System.out.println("\nVoc� morreu.");
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
                        texto = "\nVoc� tenta fugir...";
                        typeWriter(texto, velocidadeTexto);
                        if(dado >= 15)
                        {
                            System.out.print(" Voc� conseguiu!");
                            rodandoCombate = false;
                            vidaInimigo = 0;
                                
                            System.out.println("\nPressione ENTER ou digite qualquer coisa para continuar.");
                            read.nextLine();
                            resposta = read.nextLine();
                        }
                        else
                        {
                            System.out.print(" Voc� falhou. \n");
                                
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
                                System.out.println("\nVoc� morreu.");
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
                "\t|   | Pe�o que entregue esta     |. \n"+
                "\t \\_ | carta para o Conde de Feist|. \n"+
                "\t    | que fica ao Norte.         |. \n"+
                "\t    |                            |. \n"+
                "\t    | O caminho est� repleto de  |. \n"+
                "\t    | monstros, v� � Botalar     |. \n"+
                "\t    | Ferrarias e � Casa do      |. \n"+
                "\t    | Verde. N�o exacerba nas    |. \n"+
                "\t    | compras, o or�amento est�  |. \n"+
                "\t    | previsto em 1000 moedas.   |. \n"+
                "\t    |                            |. \n"+
                "\t    | Se gastar tudo ou mais do  |. \n"+
                "\t    | que deveria, n�o ter�      |. \n"+
                "\t    | recompensa.                |. \n"+
                "\t    |                            |. \n"+
                "\t    | Jamais olhe o conte�do da  |. \n"+
                "\t    | carta, sen�o ir� morrer.   |. \n"+
                "\t    |                            |. \n"+
                "\t    | - Duque Deterroui          |. \n"+
                "\t    |   _________________________|___ \n"+
                "\t    |  /                            /. \n"+
                "\t    \\_/dc__________________________/. \n");
    }
}