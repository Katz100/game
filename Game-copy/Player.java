
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private String name;
    private int health;
    private int maxHealth;
    private int damage;
    private int gold;
    private int healAmount;
    private int defense;
    private double priceValue;
    private int priceLevel;
    
    public Player(String n, int h, int mh, int d, int g, int hm, int df, double pv, int pl)
    {
        name = n;
        health = h;
        maxHealth = mh;
        damage = d;
        gold = g;
        healAmount = hm;
        defense = df;
        priceValue = pv;
        priceLevel = pl;
    }
    
    // getters
    public int getPriceLevel()
    {
        return priceLevel;
    }
    public String getName()
    {
        return name;
    }
    
    public double getPriceValue()
    {
        return priceValue;
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
    
    public int getGold()
    {
        return gold;
    }
    
    public int getHealAmount()
    {
        return healAmount;
    }
    
    public int getDefense()
    {
     return defense;   
    }
    
    // setters
    
    public void setHealth(int h)
    {
     health = h;   
    }
    
    public void addDefense(int d)
    {
        defense+=d;
    }
    
    public void loseHealth(int h)
    {
        health -= h;
        
    }
    
    public void increasePriceValue() {
        
        priceValue*=1.2;
    }
    
    public void loseGold(int g)
    {
        gold-=g;
    }
    
    public void setMaxHealth(int m) // for shop
    {
        maxHealth = m;
        health = maxHealth;
    }
    
    public void addDamage(int d)
    {
        damage += d;
    }
    
    public void addGold(int g)
    {
        gold +=g;
    }
    
    public void setHealAmount(int hm)
    {
        healAmount = hm;
    }
    
    public void addHealAmount(int hm)
    {
        healAmount+=hm;
    }
    
    public void addMaxHealth(int h)
    {
        maxHealth+=h;
    }
    
    public void increasePriceLevel(){
        priceLevel+=1;
    }
    public void healPlayer(int amount)
    {
      this.setHealth(this.getHealth()+amount);
      
      if (this.getHealth() > this.getMaxHealth())
        this.setHealth(this.getMaxHealth());
    }
}
