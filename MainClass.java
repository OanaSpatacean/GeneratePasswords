import java.util.Random;
import java.util.Scanner;

class Generator
{
    private int choice = 0;
    private int length = 0;
    private char[] password = null;
    private String strength;

    public String generateRandom()
    {   
        System.out.println("Choose what your passwords should contain:\n\nType '1' for 'Uppercase letters'\nType '2' for 'Lowercase letters'\nType '3' for 'Numbers'\nType '4' for 'Symbols'\nType '5' for all characters combined\n\n");
        
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        System.out.println("\nEnter the desired length of the password: ");
        length = sc.nextInt();

        password = new char[length];
        
        Random r = new Random();

        switch(choice)
        {
            case 1:
            {
                for(int i = 0;i<length;i++)
                {
                    char type = (char)(r.nextInt(26) + 'A');

                    if(Character.isUpperCase(type))
                    {
                        password[i] = type;
                    }
                }
                break;
            }
            case 2:
            {
                for(int i = 0;i<length;i++)
                {
                    char type = (char)(r.nextInt(26) + 'a');

                    if(Character.isLowerCase(type))
                    {
                        password[i] = type;
                    }
                }
                break;
            }
            case 3:
            {
                for(int i = 0;i<length;i++)
                {
                    int type = r.nextInt(48,57);
                    password[i] = (char)type;
                    
                }
                break;
            }
            case 4:
            {
                for(int i = 0;i<length;i++)
                {
                    char type = (char)(r.nextInt(127));

                    if(!(Character.isLowerCase(type)) && !(Character.isUpperCase(type)) && !(Character.isDigit((type))))
                    {
                        password[i] = type;
                    }
                    else
                    {   
                        i--;
                    }
                }
                break;
            }
            case 5:
            {
                for(int i = 0;i<length;i++)
                {
                    char type = (char)(r.nextInt(127));

                    password[i] = type;  
                }
                break;
            }
            default:
            {
                System.out.println("You chose an unexistent option\n");
                return null;
            }
        }
        String result = String.valueOf(password);
        return result;
    }

    public String checkStrength(String pass)
    {
        for(int i = 0;i<pass.length();i++)
        {
            if(0 < length && length <= 8)
            {
                strength = "weak";
            }
            else
            if(length > 8 && length < 16)
            {
                strength = "medium";
            }
            else
            if(length >= 16 && length <= 24)
            {
                strength = "good";
            }
            else
            if(length > 24)
            {
                strength = "great";
            }
        }
        return strength;
    }

    public void displayInfo()
    {
        System.out.println("\nAvoid using the same password twice/ Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences\n");
    }
}

public class MainClass
{
    public static void main(String[] args) 
        {
            Generator g = new Generator();
            g.displayInfo();
            String password = g.generateRandom();
            System.out.println("\n" + password + " - " + g.checkStrength(password) + "\n");
        }
}
