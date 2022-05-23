
/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy
{
    private String name;
    private int health;
    private int maxHealth;
    private int damage;
    
    private int healAmount;
    private int defense;
    private int dropGold;
    public Enemy(String n, int h, int mh, int d, int hm, int df, int dg)
    {
        name = n;
        health = h;
        maxHealth = mh;
        damage = d;
        dropGold = dg;
        healAmount = hm;
        defense = df;
    }

    // getters
    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public int getDamage(){
        return damage;
    }

    
    public int getHealAmount()
    {
        return healAmount;
    }

    public int getDefense()
    {
        return defense;   
    }
    
    public int getDroppedGold()
    {
        return dropGold;
    }

    // setters
    
    public void addDroppedGold(int g)
    {
        dropGold+=g;
    }
    
    public void loseHealth(int h)
    {
        health -= h;

    }

    public void setHealth(int h)
    {
        health = h;   
    }

    public void setMaxHealth(int m) // after being defeated
    {
        maxHealth = m;
        health = maxHealth;
    }

    public void addDamage(int d)
    {
        damage += d;
    }

    public void addDefense(int d)
    {
        defense+=d;
    }

    public void addHealAmount(int hm)
    {
        healAmount += hm;
    }

    public void healEnemy(int amount)
    {
        this.setHealth(this.getHealth()+amount);

        if (this.getHealth() > this.getMaxHealth())
            this.setHealth(this.getMaxHealth());
    }
}
