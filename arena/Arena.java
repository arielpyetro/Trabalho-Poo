// Autor: Ariel Pyetro Fernandes pinheiro (2026006586)
package arena;

import  java.util.Scanner;

public class Arena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personagem[] herois = new Personagem[3];
        herois[0] = new Guerreiro("Rick Grimes", 120, 15, 5, 3);
        herois[1] = new Mago("Hershel Greene", 70, 12, 2, 40);
        herois[2] = new Arqueiro("Daryl Dixon", 85, 13, 3, 5);
        Personagem[] monstros = new Personagem[3];
        monstros[0] = new Personagem("Walker", 40, 12, 2);
        monstros[1] = new Personagem("Biter", 80, 18, 4);
        monstros[2] = new Personagem("Variant Walker", 140, 22, 6);


        
        int turno = 1;
        while (algumVivo(herois) && algumVivo(monstros)) {
            System.out.println("===== TURNO " + turno + " =====");
            mostrarTimes(herois, monstros);

            for(int i = 0; i < herois.length; i++) {
                if(herois[i].estaVivo() && algumVivo(monstros)) {
                    System.out.println("É a vez de " + herois[i].getNome());
                        int opcao = 0;
                        while (opcao != 1 && opcao != 2) {
                            System.out.println("1 - Atacar");
                            System.out.println("2 - Usar habilidade especial");
                            System.out.println("Escolha um: ");
                            opcao = sc.nextInt();
                        }
                        if(opcao == 1) {
                            Personagem alvo = escolherAlvo(monstros, sc);
                            herois[i].atacar(alvo);
                        }
                        else if(opcao == 2) {
                            usarHabilidade(herois[i], herois, sc);
                        }
                }
            }

            for(int i = 0; i < monstros.length; i++) {
                if(monstros[i].estaVivo() && algumVivo(herois)) {
                    monstros[i].atacar(maisFraco(herois));
                }
            }
            turno++;
        }
        // TODO: mensagem de vitoria ou derrota
        if(algumVivo(monstros) == true) {
            System.out.println("Vitória!\n Os sobreviventes venceram!!");
            System.out.println("Ganharam no turno " + (turno-1));
        }
        else {
            System.out.println("Derrota!\n Sobrevivente foram derrotados!");
            System.out.println("Foram derrotados no turno: " + (turno-1));
        }
    }
    // true se pelo menos um personagem do time esta vivo
    public static boolean algumVivo(Personagem[] time) {
        int vivo = 0;
        for(int i = 0; i < time.length; i++) {
            if(time[i].estaVivo() == true ){
                vivo = 1;
            }
        }
        if(vivo == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    // imprime "Herois:" e "Monstros:" com " <ındice>) <status>" em cada linha
    public static void mostrarTimes(Personagem[] herois, Personagem[] monstros) {
        System.out.println("Herois: ");
        for(int i = 0; i < herois.length; i++) {
            System.out.println(i + " - " + herois[i].status());
        }

        System.out.println("Monstros: ");
        for(int i = 0; i < monstros.length; i++){
            System.out.println(i + " - " + monstros[i].status());
        }
    }

    public static Personagem escolherAlvo(Personagem[] time, Scanner sc) {
       for(int i =0; i < time.length; i++) {
            if(time[i].estaVivo()) {
                System.out.println(i + " - " + time[i].status());
            }
       }
       while (true) {
        System.out.println("Escolha: ");
            int escolha = sc.nextInt();
            if(escolha>= 0 && escolha < time.length) {
                if(time[escolha].estaVivo()){
                    return time[escolha];
                }
                else {
                    System.out.println("Personagem escolhido esta morto!");
                }
            }

            if(escolha < 0 || escolha >= time.length) {
                System.out.println("Parametro invalido!\n Digite novamente: ");
            }
       }
    }
    // o personagem vivo com menos vida (null se ninguem estiver vivo)

    public  static Personagem maisFraco(Personagem[] time) {
        Personagem fraco = null;
        for(int i = 0; i < time.length; i++) {
            if(time[i].estaVivo()) {
                if(fraco == null) {
                    fraco = time[i];
                }
            
                else if(time[i].getVida() < fraco.getVida()) {
                    fraco = time[i];
                }
            }
        }
        return  fraco;
    }

    // a da Etapa 5, agora perguntando ao jogador quem o Mago cura
    public static void usarHabilidade(Personagem p, Personagem[] herois, Scanner sc) {
       if(p instanceof Guerreiro) {
            Guerreiro guerreiro = (Guerreiro) p;
            guerreiro.gritoGuerra();
       }
       else if(p instanceof Mago) {
            Mago mago = (Mago) p;
            Personagem aliado = escolherAlvo(herois, sc);
            mago.curarAliado(aliado);
       }
       else if (p instanceof Arqueiro) {
            Arqueiro arqueiro = (Arqueiro) p;
            arqueiro.recarregar();
       }
    }
}