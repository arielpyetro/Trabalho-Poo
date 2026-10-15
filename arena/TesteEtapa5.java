package arena;

public class TesteEtapa5 {
public static void main(String[] args) {
    Personagem[] equipe = new Personagem[3];
    equipe[0] = new Guerreiro("Thorin", 120, 15, 5, 3);
    equipe[1] = new Mago("Merlin", 70, 12, 2, 30);
    equipe[2] = new Arqueiro("Legolas", 85, 13, 3, 0);
    Personagem dragao = new Personagem("Dragao", 500, 60, 10);
    dragao.atacar(equipe[0]);
    for (Personagem p : equipe) {
        usarHabilidade(p, equipe);
    }
}
public static void usarHabilidade(Personagem p, Personagem[]
equipe) {
        if(p instanceof Guerreiro) {
                Guerreiro guerreiro = (Guerreiro) p;
                guerreiro.gritoGuerra();
        }
        else if(p instanceof Mago) {
                Mago mago = (Mago) p;
                Personagem aliado = null;

                for (int i = 0; i < equipe.length; i++) {
                    if(equipe[i].estaVivo() == true) {
                        if(aliado == null) {
                            aliado = equipe[i];
                        }
                        else if(equipe[i].getVida() < aliado.getVida() ){
                            aliado = equipe[i];
                        }
                    }
                }
                if(aliado != null) {
                    mago.curarAliado(aliado);
                }

            }
        else if(p instanceof Arqueiro) {
            Arqueiro arqueiro = (Arqueiro) p;
            arqueiro.recarregar();
        }   
    }
}
