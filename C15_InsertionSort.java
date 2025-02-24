import java.util.ArrayList;


public class C15_InsertionSort {
    private ArrayList registrations = new ArrayList();

    public C15_InsertionSort() {
        // Initialize the list of registrations

        registrations.add(new Registration("SGL-6855", "Tyler Lennon"));
        registrations.add(new Registration("SDN-2659", "Margaret Finn"));
        registrations.add(new Registration("ANA-2866", "Zane Hallworth"));
        registrations.add(new Registration("DYC-5707", "Jodi Gatfield"));
        registrations.add(new Registration("GIG-1870", "Harvey Kenny"));
        registrations.add(new Registration("NWK-2057", "Janice Hudson"));
        registrations.add(new Registration("BYJ-6279", "Larry Newman"));
        registrations.add(new Registration("ENY-2915", "Helen Pryor"));
        registrations.add(new Registration("OYW-0632", "Quincy Cromwell"));
        registrations.add(new Registration("KEC-3996", "Kathy Myers"));
        registrations.add(new Registration("HOZ-1224", "Hugh Haines"));
        registrations.add(new Registration("KGJ-5010", "Tammy Mallard"));
        registrations.add(new Registration("FVA-4467", "Michael Knowles"));
        registrations.add(new Registration("NEV-9119", "Michael Knowles"));
        registrations.add(new Registration("BJT-9772", "Karl Yardley"));
        registrations.add(new Registration("YQD-3410", "Andrea Elsworth"));
        registrations.add(new Registration("DUY-0288", "Jay Zagorski"));
        registrations.add(new Registration("ATZ-9783", "Sally Oakes"));
        registrations.add(new Registration("IAG-6602", "Patrick Hewitt"));
        registrations.add(new Registration("DCP-2974", "Donna Wardman"));
        registrations.add(new Registration("FAH-2515", "Jay Newton"));
        registrations.add(new Registration("GYF-3958", "Carla Collins"));
        registrations.add(new Registration("NCL-9068", "James McBride"));
        registrations.add(new Registration("UBJ-1923", "Helen Gibbs"));
        registrations.add(new Registration("UUG-4837", "Conrad Pryor"));
        registrations.add(new Registration("GMD-6786", "Tracy Gilbert"));
        registrations.add(new Registration("QTW-6473", "Donald Gatfield"));
        registrations.add(new Registration("QQE-3264", "Charlotte Newport"));
        registrations.add(new Registration("WAO-8258", "Rodney Gilbert"));

    }

    public void printAll(){
        for (Object obj : registrations) {
            Registration reg = (Registration) obj;
            System.out.println(reg);
        }
    }




    public void insertionSort() {
        int regCount = registrations.size();

        for (int i = 1; i < regCount; i++) {
            // Current value to insert
            Registration current = (Registration) registrations.get(i);

            // Begin making comparisons with the previous element
            int index = i - 1;

            // Mover elementos mayores hacia la derecha
            while (index >= 0 && current.license.compareTo(((Registration) registrations.get(index)).license) > 0) {
                registrations.set(index + 1, registrations.get(index)); // Mueve el objeto, no el `license`
                index--;
            }

            // Insertar en la posición correcta
            registrations.set(index + 1, current);
        }
    }



    public void bubbleSort() {
        int n = registrations.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                Registration currentReg = (Registration) registrations.get(j);
                Registration nextReg = (Registration) registrations.get(j + 1);
                if (currentReg.license.compareTo(nextReg.license) > 0) {
                    registrations.set(j, nextReg);
                    registrations.set(j + 1, currentReg);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        C15_InsertionSort db = new C15_InsertionSort();


        //db.bubbleSort();
        db.insertionSort();

        System.out.println("\n******* Sorted List ******\n");
        db.printAll();
    }
}
