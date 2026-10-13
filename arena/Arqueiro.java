package arena;

public class Arqueiro extends Personagem {
    private int flechas;

    Arqueiro(String nome, int vidaMaxima, int ataque, int defesa, int flechas) {
        super(nome, vidaMaxima, ataque, defesa);
        this.flechas = flechas;
    }
    void recarregar() {
        flechas +=3;
        System.out.println(getNome() + " recolhe flechas do chao. (flechas: " + flechas + ")");
        
    }
    public int getFlechas() {
        return flechas;
    }
    
    @Override 
    public void atacar(Personagem alvo) {
    if(flechas > 0) {
        flechas -= 1;
        System.out.println(getNome()  + " dispara uma flecha em " + alvo.getNome() + " e causa " + alvo.receberDano(getAtaque()+ 5) + " de dano" + " (flechas: " + getFlechas() + " restantes" );
    }
    else {
            System.out.println(getNome()  + " está sem flechas e dá um soco em " + alvo.getNome() + ": " + alvo.receberDano(getAtaque()/2) + " de dano" );
        }
    }
}
