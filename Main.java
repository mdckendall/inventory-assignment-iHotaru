import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

class Inventory {
  public String Name;
  public String serialNum;
  public int value;

  Inventory(String a, String b, int c){
    Name = a;
    serialNum = b;
    value = c;
  }

  public String toString(){
    return Name + "," + serialNum + "," + value;
  }
}

class Main {
  
	public static void main(String[] args) {
    ArrayList<Inventory> arrayList = new ArrayList<>();;
    Scanner choice = new Scanner(System.in);

    int num = 0;
    String nameTemp;
    String serialTemp;
    int costTemp;

    while(num != 5){
      choices();
      num = choice.nextInt();
      choice.nextLine();
      switch (num) {
        case 1:
          System.out.println("Enter the name:");
          nameTemp = choice.nextLine();
          System.out.println("Enter the serial number:");
          serialTemp = choice.nextLine();
          System.out.println("Enter the value in dollars (whole number):");
          costTemp = choice.nextInt();
          choice.nextLine(); //removes /n
          arrayList.add(new Inventory(nameTemp, serialTemp, costTemp));
          break;
        case 2:
          System.out.println("Enter the serial number of the item to delete:");
          serialTemp = choice.nextLine();
          for(int i = 0; i<arrayList.size(); i++){
            if(arrayList.get(i).serialNum.equals(serialTemp)){
              arrayList.remove(i);
              break;
            }
          }
          break;
        case 3:
          System.out.println("Enter the serial number of the item to change:");
          serialTemp = choice.nextLine();
          System.out.println("Enter the new name:");
          nameTemp = choice.nextLine();
          System.out.println("Enter the value new in dollars (whole number):");
          costTemp = choice.nextInt();
          choice.nextLine(); //removes /n
          for(int i = 0; i<arrayList.size(); i++){
            if(arrayList.get(i).serialNum.equals(serialTemp)){
              arrayList.get(i).Name = nameTemp;
              arrayList.get(i).value = costTemp;
              break;
            }
          }
          break;
        case 4:
          for(int i = 0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
          }
          break;
        case 5:
          break;
        default:
          System.out.println("please select a valid number");
          break;
      }
    }
	}

  public static void choices(){
    System.out.println("Press 1 to add an item.");
    System.out.println("Press 2 to delete an item.");
    System.out.println("Press 3 to update an item.");
    System.out.println("Press 4 to show all items.");
    System.out.println("Press 5 to quit the program.");
  }
  
}