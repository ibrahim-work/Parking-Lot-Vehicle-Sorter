import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
public class ParkingLot_VehicleSorter {
    public static void main(String[] args) {
        try {
            //step1) create a file object to reference the input text file.
            File text = new File("logfile.txt");
            //step2) create a Scanner object to read the file object.
            Scanner input = new Scanner(text);
            //step3) create a ParkingLot object called parkingCars.
            ParkingLot parkingCars=new ParkingLot();
            //step4) declare an integer variable for counting the lines in the input file with default value.
            int countLines=0;
            //step4) using a while loop to read the input file line by line till reaching the end of the file.
            while(input.hasNextLine()) {
                //step4.1) each line of input file is assigned to a string variable called line.
                String line = input.nextLine();
                //step4.2) create a Date object called and use strToDate method in the main class to take substrings of line string
                // and return a date to be assigned to dd. Note that trim method of class String takes spaces off a string.
                Date dd=strToDate(line.substring(29,33).trim(),line.substring(35,37).trim(),line.substring(37,39).trim(),
                                  line.substring(40,42).trim(),line.substring(43,45).trim(),line.substring(46,48).trim());
                //step4.3) call addCar method of the ParkingLot object (parkingCars) which receives dd and sub-strings of
                // line containing the model, make and color of the line's car
                parkingCars.addCar(dd,line.substring(1,10).trim(),line.substring(11,19).trim(),line.substring(20,28).trim());
                //step4.4) add one to countLines.
                countLines++;
            }
            //step5) printing elements from the attribute (cars) of the ParkingLot object (parkingCars).
            // cars is an array of a type which entities (attributes) are dateIn, make, plate, and color.
            System.out.println(countLines);
            System.out.println(parkingCars.cars.get(2).dateIn);
            System.out.println(parkingCars.cars.get(3).make);
            System.out.println(parkingCars.cars.get(0).plate);
            System.out.println(parkingCars.cars.get(1).color);

            //Add your Exercise11 statement after this line:
                  

        //step6) exceptions due to io of File or classes used in strToDate method.
        } catch (Exception e) {
            System.out.println("Something is wrong in reading the text file, OR in converting the string to date!");
        }
    }
    public static Date strToDate(String year, String month, String day,String hour, String minute, String second)
            // method strToDate receives 6 strings for date and hours and returns a Date value with a specific Date format.
            throws ParseException {
                String dateStr =""+day+"/"+month+"/"+year+" "+hour+":"+minute+":"+second;
                SimpleDateFormat frmt=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return frmt.parse(dateStr);
    }
}



class ParkingLot{
    ArrayList <Cars> cars;
    ParkingLot(){cars=new ArrayList<>();}
    void addCar(Date date,String make,String color,String plate){
        cars.add(new Cars(date,make,color,plate));
    }
}

class Cars{
    String make;
    String color;
    String plate;
    Date dateIn;
    Cars(Date date, String make, String color, String plate){
        this.make=make;
        this.color=color;
        this.plate=plate;
        this.dateIn=date;
    }
}
