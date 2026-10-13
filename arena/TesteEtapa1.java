package arena;

public class TesteEtapa1 {
    public static void main(String[] args) {
    Personagem heroi = new Personagem("Heroi", 100, 20, 5);
    Personagem goblin = new Personagem("Goblin", 40, 12, 2);
    System.out.println(heroi.status());
    System.out.println(goblin.status());
    heroi.atacar(goblin);
    goblin.atacar(heroi);
    System.out.println(heroi.status());
    heroi.curar(50);
    System.out.println(heroi.status());
    heroi.atacar(goblin);
    heroi.atacar(goblin);
    System.out.println(goblin.status() + " vivo? " + goblin.estaVivo());
    Personagem muralha = new Personagem("Muralha", 50, 0, 30);
    heroi.atacar(muralha);
    }
}
