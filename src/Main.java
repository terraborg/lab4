import characters.Owl;
import characters.Person;
import characters.Pooh;
import exceptions.CantActException;
import places.House;
import places.OutDoor;
import places.Place;

public class Main {
    public static void main(String[] args) {
        Place house = new House();
        Place outdoor = new OutDoor();
        house.setNearPlaces(outdoor);
        Person[] people = new Person[]{new Owl(house), new Pooh(house)};
        while(true)
        {
            boolean isEnded = false;
            System.out.println("----------------------------------------------------------------");
            System.out.println();
            for(var person : people)
            {
                try {
                    if(!person.act()) {
                        isEnded = true;
                    }
                }catch (CantActException e)
                {
                    System.out.println(e.getMessage());
                    return;
                }
            }
            if(isEnded) {
                System.out.println("История завершилась");
                return;
            }
            for(var person : people)
                person.getConditionChecker().checkCondition();
        }
    }
}