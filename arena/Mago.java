// Autor: Ariel Pyetro Fernandes pinheiro (2026006586)
package arena;

public class Mago extends Personagem {
    private int mana;

    Mago(String nome, int vidaMaxima, int ataque, int defesa, int mana) {
        super(nome, vidaMaxima, ataque, defesa);
        this.mana = mana;
    }
    public int getMana() {
        return mana;
    }
    
    @Override 
    public void atacar(Personagem alvo) {
        if(mana>= 10) {
            mana -= 10;
            System.out.println(getNome() + " lança uma bola de fogo em " + alvo.getNome() + " e causa " + alvo.receberDano(getAtaque() * 2) + " de dano" + " (mana: " + getMana() + " restante" );
        }
        else {
            super.atacar(alvo);
        }
    }

    public void curarAliado(Personagem aliado) {
        if(estaVivo() == true) {
            if(mana >= 15) {
                mana-= 15;
                aliado.curar(25);
                System.out.println(getNome() + " cura " + aliado.getNome() +". " + aliado.status() + " (mana: " + getMana() + ")");
            }
            else {
                System.out.println(getNome() + " não tem mana para curar");
            }
        }
    }
}
