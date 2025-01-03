import java.util.Scanner;
import java.util.Random;

public class Encounter
{
  public Pokemon player;
  public Pokemon opponant;
  
  public Encounter(Pokemon player, Pokemon opponant)
  {
    this.player = player;
    this.opponant = opponant;
  }

  public battle()
  {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    
    System.out.println("You sent out " + player.getName() + ", your opponant sent out a " + opponant.getName());
    boolean victory;

    int currentHpOpponant;
    int currentHpPlayer;

    while(true)
    {
      currentHpOpponant = opponant.getHP();
      currentHpPlayer = player.getHP();
      
        System.out.println(opponant.getName() + " HP:" + currentHpOpponant);
        System.out.println(player.getName() + " HP: " + currentHpPlayer);

        int numHits;
        int damage;
        Attack playerChoice;
        Attack opponantChoice;

        while(true)
        {
          System.out.println("What will you like to do?" 
          + "Opion 1: " + player.Attack1().getName() + ": damage" +  + " pp: " + player.Attack1().getPP()
          + "\n Option2:" + player.Attack2().getName() + ": damage" +  + " pp: " + player.Attack2().getPP());
          String choice = scanner.nextLine();
          if(choice.equalsIgnoreCase(player.getAttack1().getName()))
          {
            playerChoice = player.getAttack1();
            break;
          }
          else if(choice.equalsIgnoreCase(player.Attack2().getName()))
          {  
            playerChoice = player.getAttack2();
            break;
          }
          else
          {
            System.out.println("That is not an option, please choose again");
          }
        }
                
        System.out.println("");
        if(playerChoice.isUseable() = false)
        {
          System.out.println("You do not have enough pp to use this move.");
          numHits = rand.nextInt(5);
          damage = struggle(opponant, player, numHits);
          currentHpOpponant -= damage;
        }
        else
        {
          damage = calculateDamage(opponant, playerChoice);
          playerChoice.decreasePP();
          System.out.println("You used " + playerChoice.getName()  
                              + "dealing " + damage + " damage to the opposing " + opponant.getName() + ".");
          currentHpOpponant -= damage;
        }
        opponant.setHp(opponantCurrentHp);
        if(opponant.isAlive() == false)
        {
          System.out.println("Congratulations, you win!");
          victory = true;
            break;
        }
            
        int opponantMove = rand.nextInt(2) + 1;
        if(opponantMove == 1)
        {
          opponantChoice = opponant.getAttack1();
        }
        else if(opponantMove == 2)
        {
          opponantChoice = opponant.getAttack2();
        }
    
        System.out.println("");
        if(opponantChoice.isUseable() == false)
        {
          System.out.println("The opponant does not have pp to use this move. ");
          int numHits = rand.nextInt(5);
          int damage = struggle(player, opponant, numHits);
          currentHpPlayer -= damage;
        }
        else
        {
          int damage = calculateDamage(player, opponantChoice);
          opponant.getAttack2().decreasePP();
          System.out.println("The opponant used " + opponantChoice.getName()  
                              + "dealing " + damage + " damage to your " + player.getName() + ".");
          currentHpPlayer -= damage;
        }
      
        player.setHp(currentPlayerHp);
        if(player.isAlive() == false)
        {
          System.out.println("You lose the battle.");
          victory = false;
          break;
        }
      }
    return victory;
  }        

  public calculateDamage(Pokemon target,Attack attackUsed)
  {
      double typeEffectiveness = 0;
      if((target.getType().equals("fire") and attackUsed.getType().equals("water"))
          || (target.getType().equals("water") and attackUsed.getType().equals("grass"))
          || (target.getType().equals("grass") and attackUsed.getType().equals("fire")))
      {
          typeEffectiveness = 2;
      }
      else if((target.getType().equals("fire") and attackUsed.getType().equals("grass"))
          || (target.getType().equals("water") and attackUsed.getType().equals("fire"))
          || (target.getType().equals("grass") and attackUsed.getType().equals("water")))
      {
          typeEffectiveness = 0.5;
      }
      else
      {
          typeEffectiveness = 1;
      }
          
       double damage = attackUsed.getDamage() * typeEffectiveness;
      return damage;
  }

  public static int struggle(Pokemon target, Pokemon attacker, int num)
  {
      if(num == 0)
      {
          return 0;
      }
      System.out.println("The " + attacker.getName() + " Struggled against " + target.getName() + ", hitting " + num 
                         + " time(s), dealing " + (10 * num) + " damage.");
    
      return 10 * num + struggle(target, attacker, num - 1);
  }
}
