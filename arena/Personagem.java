// Autor: Ariel Pyetro Fernandes pinheiro (2026006586)

package arena;

public class Personagem {
    private String nome;
    private int vidaMaxima;
    private int vida;
    private int ataque;
    private int defesa;


public Personagem(String nome, int vidaMaxima, int ataque, int defesa) {
    this.nome = nome;
    this.vidaMaxima = vidaMaxima;
    this.ataque = ataque;
    this.defesa = defesa;
    this.vida = vidaMaxima;
}

public String getNome() {
    return nome;
}

public int getVida() {
    return vida;
}

public int getAtaque() {
    return ataque;
}

public int getDefesa() {
    return defesa;
}

public int getvidaMaxima() {
    return vidaMaxima;
}

public boolean estaVivo() {
    if (vida > 0) {
        return true;
    }
    else {
        return false;
    }
}    

public int receberDano(int dano) {
    dano -=defesa;
    if(dano <= 0) {
        dano = 1;
    }
    vida -= dano;
    if(vida < 0) {
        vida = 0;
    }
    return dano;
}

public void curar(int pontos) {
    if(estaVivo() == false ) {
        return;
    }
    else {
        vida += pontos;
        if(vida > vidaMaxima) {
            vida = vidaMaxima;
        }
    }
}

public void atacar(Personagem alvo) {
    System.out.println(nome  + " Ataca " + alvo.getNome() + " e causa " + alvo.receberDano(ataque) + " de dano" );
}

public String status() {
    return getNome() + "[HP " + getVida() + "/" + vidaMaxima + "]";
    }


protected void modificarGuerreiro() {
        ataque += 5;
    }

/* protected void modificarvida() {
    vida = vidaMaxima;
} */

}
