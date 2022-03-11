import Weapons.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        // Как настоящие программисты мы имеем в виду, что исчисление начинается с 0
        int slot;
        // TODO главный цикл игры:
        // запрашивать номер с клавиатуры
        // с помощью scanner.nextInt(),
        // пока не будет введено -1
        int count;

        while (true) {
            System.out.format("У игрока %d слотов с оружием,"
                            + " выберите номер, чтобы атаковать,"
                            + " -1 чтобы выйти%n",
                    player.getSlotsCount()
            );

            count = player.getSlotsCount();

            slot = scanner.nextInt();
            if (slot < count && slot >= 0){
                player.shotWithWeapon(slot);
            }else {
                System.out.println("В этом слоте нет оружия");
            }
            if (slot == -1){
                break;
            }
        }
        System.out.println("Игра окончена!");
    }
}

class Player {
    // Указываем тип данных Weapon, который будет храниться в "слотах игрока"
    private Weapon[] weaponSlots;

    public Player() {
        // Снаряжаем нашего игрока
        weaponSlots = new Weapon[] {
                // TODO заполнить слоты оружием
                // new BigGun(),
                // new WaterPistol()
                new Knife(),
                new Cannon(),
                new Crossbow(),
                new PlazmaGun(),
                new Bazooka(),
                new SniperRifle()
        };
    }

    public int getSlotsCount() {
        // length - позволяет узнать, сколько всего слотов с оружием у игрока
        return weaponSlots.length;
    }

    public void shotWithWeapon(int slot) {
        // TODO проверить на выход за границы
        // если значение slot некорректно, то
        // выйти из метода написав об этом в консоль

        // Получаем оружие из выбранного слота
        Weapon weapon = weaponSlots[slot];
        // Огонь!
        weapon.shot();
    }
}
