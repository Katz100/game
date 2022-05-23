
/**
 * Write a description of class GameTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.util.Random;

public class GameTest
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);

        System.out.print("Please tell us your name, adventurer >>> ");
        String playerName = scan.nextLine();
        System.out.println();

        Player player = new Player(playerName, 100, 100, 30, 0, 15, 5, 1.00, 1);
        System.out.println("Welcome, " + player.getName() + ", have a safe journey.\n");

        Enemy bat = new Enemy("Bat", 30, 30, 5, 5, 20,3);
        Enemy vampire = new Enemy("Vampire", 70, 70, 10, 15, 20,8);
        Enemy zombie = new Enemy("Zombie", 90, 90, 20, 10, 5,10);

        Enemy[] enemyList = {bat, vampire, zombie};

        //player.addGold(10000);
        main(enemyList, player);
        
        


    }

    public static void shop(Enemy[] enemylist, Player player)
    {
        Scanner scan4 = new Scanner(System.in);
        System.out.println("\t\t|---------------|\n\t\t|-----Shop------|\n\t\t|---------------|\n\n");
        System.out.println("Welcome to the shop, adventurer. Choose some of the items below you want to buy only if you have enough gold, my friend.\n\n");
        System.out.println("Note: Upgrading your stats increases your price level. The higher your price level is, the more expensive upgrades get.\n\nCurrent Price Level: "+player.getPriceLevel()+"\n\n");
        System.out.println("Name: " + player.getName());
        System.out.println("Available gold: " + player.getGold()+"\n");
        
        System.out.println("1. Upgrade damage (" + (int)(5*player.getPriceValue()) + "g) \n2. Upgrade defense (" + (int) (20*player.getPriceValue()) + "g) \n3. Upgrade heal amount (" + (int) (10 * player.getPriceValue())+"g)\n4. Increase health ("+ (int) (15*player.getPriceValue())+"g)\n5. Leave shop\n>>> ");
        int input = scan4.nextInt();
        
        
        
        
        if (input == 1){
            if (player.getGold() >= ((int)5 * player.getPriceValue())){
            player.addDamage( (int)(player.getDamage()*0.25));
            System.out.println("Pleasure doing business with you!");
            player.loseGold((int) (5*player.getPriceValue()));
            player.increasePriceValue();
            player.increasePriceLevel();
            //System.out.println("Price Increase: " + player.getPriceValue());
            
        }
            else if (player.getGold() < 5*player.getPriceValue()){
            System.out.println("Not enough gold.");
            wait(1000);
            shop(enemylist, player);}
        }
        else if (input == 2){
            if (player.getGold() >= ((int)20)*player.getPriceValue()){
            player.addDefense((int)(player.getDefense()*0.25));
            //System.out.println("Defense : " + player.getDefense());
            System.out.println("Pleasure doing business with you!");
            player.loseGold( (int)( 20 * player.getPriceValue()));
            player.increasePriceValue();
            player.increasePriceLevel();
        }
            else if (player.getGold() < (int) (20*player.getPriceValue())){
            System.out.println("Not enough gold.");
            wait(1000);
            shop(enemylist, player);}
        }
        else if (input == 3){
            if (player.getGold() >= (int) (10*player.getPriceValue())){
            player.addHealAmount( (int)(player.getHealAmount()*0.25));
            System.out.println("Pleasure doing business with you!");
            player.loseGold((int) (10*player.getPriceValue()));
            player.increasePriceValue();
            player.increasePriceLevel();
        }
            else if (player.getGold() < (int) (10*player.getPriceValue())){
            System.out.println("Not enough gold.");
            wait(1000);
            shop(enemylist, player);}
        }
        else if (input == 4){
            if (player.getGold() >= (int) (15*player.getPriceValue())){
            player.addMaxHealth( (int)(player.getMaxHealth()*0.25));
            System.out.println("Pleasure doing business with you!");
            player.loseGold((int)(15*player.getPriceValue()));
            player.increasePriceValue();
            player.increasePriceLevel();
            player.setHealth(player.getMaxHealth());
        }
            else if (player.getGold() < (int) (15*player.getPriceValue())){
            System.out.println("Not enough gold.");
            wait(1000);
            shop(enemylist, player);}
        }
        else if (input == 5){
           System.out.println("Thanking for shopping at Shop\nSee you around, adventurer!");
           wait(2000);
           main(enemylist, player);
        }
        else
        System.out.println("Sorry, I don't sell that here.");
        wait(2000);
        shop(enemylist, player);
        
        
    }
    

        
        
        
    

    public static void main(Enemy[] enemyList, Player player){ // main menu
        Scanner scan3 = new Scanner(System.in);

        System.out.println("\t\t|---------------|\n\t\t|---Main menu---|\n\t\t|---------------|\n\n");

        System.out.println("Name : " + player.getName()+"\n");
        System.out.println("Attack damage: " + player.getDamage()+"\n");
        System.out.println("Total HP: " + player.getHealth()+"\n");
        System.out.println("Heal amount: " + player.getHealAmount()+"\n");
        System.out.println("Defense: " + player.getDefense()+"\n");
        System.out.println("Gold: " + player.getGold()+"\n");
        System.out.print("1. Begin Battle \n2. Shop \n3. Quit \n>>> ");
        int answer = scan3.nextInt();
        if (answer == 1)
            battle(enemyList, player);
        else if( answer == 2)
            shop(enemyList, player);
        else if ( answer == 3)
            System.exit(0);
        else
            System.out.println("Not a valid option");
            main(enemyList, player);
            

    }
    public static void wait(int ms) // timer
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void battle(Enemy[] enemyList, Player player) // main battle
    {
        Random rand = new Random();
        Scanner scan2 = new Scanner(System.in);
        Enemy enemy = enemyList[rand.nextInt(enemyList.length)];

        int turn = 1;

        System.out.println("You encountered a(n) "+ enemy.getName() + " --- HP: " + enemy.getHealth() + " --- DF: "+enemy.getDefense());
        System.out.println();
        boolean playing = true;
        while (playing){

            if (turn == 1)
            {
                System.out.print("1. Attack --- 2. Heal >>> ");
                int input = scan2.nextInt();
                System.out.println();
                if (input == 1)
                {
                    int pdamage = player.getDamage() - enemy.getDefense();
                    if (enemy.getDefense() > player.getDamage())
                        pdamage = 0;

                    enemy.loseHealth(pdamage);
                    System.out.println(player.getName() + " did " + pdamage + " damage to " + enemy.getName());
                    wait(1000);
                    System.out.println(enemy.getName() + " now has  " + enemy.getHealth() + " health\n");
                    wait(1000);

                }

                if (input == 2)
                {
                    player.healPlayer(player.getHealAmount());
                    System.out.println(player.getName() + " healed for " + player.getHealAmount() + " poins\n");
                    wait(1000);
                }

                turn = 2;
            }

            if (enemy.getHealth() <= 0)
            {
                System.out.println("The "+enemy.getName() + " was defeated");
                wait(1000);
                System.out.println("Returning to main menu...\n");
                wait(3000);
                player.setHealth(player.getMaxHealth());

                player.addGold(enemy.getDroppedGold());
                enemy.setMaxHealth((int)(enemy.getMaxHealth()+(enemy.getMaxHealth()*0.4)));
                enemy.setHealth(enemy.getMaxHealth());
                enemy.addHealAmount((int)(enemy.getHealAmount()*0.25));
                enemy.addDamage( (int)(enemy.getDamage()*0.25));
                enemy.addDefense( (int)(enemy.getDefense()*0.15));
                enemy.addDroppedGold( (int)(enemy.getDroppedGold()*0.5));
                playing = false;
                main(enemyList, player);
                break;
            }

            if (turn ==  2)
            {
                int attackOrHeal = (int)(Math.random()*3 + 1);

                int edamage = enemy.getDamage()-player.getDefense();
                if (player.getDefense() > enemy.getDamage())
                    edamage = 0;

                if (attackOrHeal == 1 || attackOrHeal == 2)
                {
                    player.loseHealth(edamage);
                    System.out.println(enemy.getName() + " did " + edamage + " damage to " + player.getName());
                    wait(1000);
                    System.out.println(player.getName() + " now has " + player.getHealth() + " health\n");
                    wait(1000);

                }

                if (attackOrHeal == 3)
                {
                    int healE = (int)(Math.random() * 20 + 1);
                    enemy.healEnemy(healE);
                    System.out.println(enemy.getName() + " healed for " + healE + " health points");
                    wait(1000);
                    System.out.println(enemy.getName() + " now has " + enemy.getHealth()+ " health\n");
                    wait(1000);

                }
                turn = 1;
            }

            if (player.getHealth() <= 0)
            {
                System.out.println("You were defeated...");
                wait(1000);
                System.out.println("Returning to main menu\n");
                wait(1000);
                player.setHealth(player.getMaxHealth());
                enemy.setHealth(enemy.getMaxHealth());
                playing = false;
                main(enemyList, player);
                break;
            }
        }

    }

}
