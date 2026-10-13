package arena;

public class TesteEtapa2 {
public static void main(String[] args) {
    Guerreiro thorin = new Guerreiro("Thorin", 120, 15, 5, 3);
    Mago merlin = new Mago("Merlin", 70, 12, 2, 30);
    Arqueiro legolas = new Arqueiro("Legolas", 85, 13, 3, 2);
    System.out.println(thorin.status() + " armadura: " + thorin.
    getArmadura());
    System.out.println(merlin.status() + " mana: " + merlin.getMana());
    System.out.println(legolas.status() + " flechas: " + legolas.getFlechas());
    System.out.println("Ataque do Merlin: " + merlin.getAtaque());
    }
}
