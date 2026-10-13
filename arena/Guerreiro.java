package arena;

public class Guerreiro extends Personagem {
   private int armadura;
    Guerreiro(String nome, int vidaMaxima, int ataque, int defesa, int armadura) {
        super(nome, vidaMaxima, ataque, defesa);
        this.armadura = armadura;
   }
    void gritoDeGuerra() {
        System.out.println( getNome() + " solta um grito de guerra! " + " ataque agora: " + getAtaque()+5);
   }
   @Override
public int receberDano(int dano) {
    dano -= armadura;
    if(dano <= 0) {
        dano = 1;
    }
    return super.receberDano(dano);
}

   public int getArmadura() {
       return armadura;
   }
}