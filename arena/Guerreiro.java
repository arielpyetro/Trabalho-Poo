package arena;

public class Guerreiro extends Personagem {
   private int armadura;
    Guerreiro(String nome, int vidaMaxima, int ataque, int defesa, int armadura) {
        super(nome, vidaMaxima, ataque, defesa);
        this.armadura = armadura;
   }
   @Override
public int receberDano(int dano) {
    dano -= armadura;
    if(dano <= 0) {
        dano = 1;
    }
    return super.receberDano(dano);
}
public void gritoGuerra() {
    modificarGuerreiro();
    System.out.println( getNome() + "Solta um grito de guerra!\nAtaque agora: " + getAtaque());
}
   public int getArmadura() {
       return armadura;
   }
}