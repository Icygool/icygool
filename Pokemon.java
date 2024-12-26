/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Final_Project;

/**
 *
 * @author 27144004
 */
public class Pokemon
{
    public String name;
    public String type;
    public int hp;
    public Attacks attack1;
    public Attacks attack2;
    
    public int damage;
    
    
    public Pokemon(String name, String type, int hp, Attack attack1, Attack attack2)
    {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attack1 = attack1;
        this.attack2 = attack2;
    }

    public getName()
    {
        return name;
    }

    public getAttack1()
    {
        return attack1;
    }

    public getAttack2()
    {
        return attack2;
    }

    public getHP()
    {
        return hp;
    }
    
    public takeDamage(Pokemon Target, Attack attackUsed)
    {
        double typeEffectiveness = 0;
        if(Target.getType().equals("fire") and attackUsed.getType().equals("water"))
        {
            typeEffectiveness = 2;
        }
        else if(Target.getType().equals("water") and attackUsed.getType().equals("grass"))
        {
            typeEffectiveness = 2;
        }
        else if(Target.getType().equals("grass") and attackUsed.getType().equals("fire"))
        {
            typeEffectiveness = 2;
        }
        else if(Target.getType().equals("fire") and attackUsed.getType().equals("grass"))
        {
            typeEffectiveness = 0.5;
        }
        else if(Target.getType().equals("water") and attackUsed.getType().equals("fire"))
        {
            typeEffectiveness = 0.5;
        }
        else if(Target.getType().equals("grass") and attackUsed.getType().equals("water"))
        {
            typeEffectiveness = 0.5;
        }
        else
        {
            typeEffectiveness = 1;
        }
        
        double damage = attackUsed.getDamage() * typeEffectiveness;
        int targetHP = target.getHP();
        targetHP -= damage;
        return targetHp;
    }

    public isAlive()
    {
        if(hp <= 0)
        {
            return false;
        }
        return true;
    }
}
