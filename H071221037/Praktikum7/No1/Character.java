package No1;

abstract class Character {

    public int attackPower;

    public Character(int attackPower) {
        this.attackPower = attackPower;
    }

    public abstract int attackPower();

    abstract int attackPower(String attackType);
}

class Fighter extends Character {

    public Fighter(int attackPower) {
        super(attackPower);
    }

    @Override
    public int attackPower(String attackType) {
        if (attackType.equals("melee")) {
            return attackPower * 2;
        } else if (attackType.equals("ranged")) {
            return attackPower;
        } else {
            return 0;
        }
    }

    @Override
    public int attackPower() {
        return attackPower;
    }
}

class Mage extends Character {

    public Mage(int attackPower) {
        super(attackPower);
    }

    @Override
    public int attackPower(String attackType) {
        if (attackType.equals("fire")) {
            return attackPower * 2;
        } else if (attackType.equals("frost")) {
            return attackPower * 3;
        } else {
            return 0;
        }
    }

    @Override
    public int attackPower() {
        return attackPower;
    }
}

class Main {

    public static void printAttack(Character character) {
        System.out.println("attack power = " + character.attackPower());
        if (character instanceof Fighter) {
            System.out.println("Melee attack power = " + character.attackPower("melee"));
            System.out.println("Ranged attack power = " + character.attackPower("ranged"));

        } else if (character instanceof Mage) {
            System.out.println("Fire attack power = " + character.attackPower("fire"));
            System.out.println("Frost attack power = " + character.attackPower("frost"));
        }
    }

    public static void main(String[] args) {
        Character[] karakter = new Character[5];
        karakter[0] = new Fighter(2);
        karakter[1] = new Mage(5);
        karakter[2] = new Fighter(10);
        karakter[3] = new Fighter(15);
        karakter[4] = new Mage(20);

        for (Character character : karakter) {
            printAttack(character);
            System.out.println();
        }

    }
}