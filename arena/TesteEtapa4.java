// Autor: Ariel Pyetro Fernandes pinheiro (2026006586)
package arena;

public class TesteEtapa4 {
    public static void main(String[] args) {
        Personagem[] equipe = new Personagem[3];
    equipe[0] = new Guerreiro("Thorin", 120, 15, 5, 3);
    equipe[1] = new Mago("Merlin", 70, 12, 2, 30);
    equipe[2] = new Arqueiro("Legolas", 85, 13, 3, 2);
    Personagem boneco = new Personagem("Boneco", 300, 0, 4);
    for (int rodada = 1; rodada <= 4; rodada++) {
    System.out.println("--- Rodada " + rodada + " ---");
            for (Personagem p : equipe) {
            p.atacar(boneco);
            }
            System.out.println(boneco.status());
        }
    }
}
