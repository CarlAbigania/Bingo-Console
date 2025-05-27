
import java.util.Scanner;

public class SmartPhoneMain {
	
	//static scanner to accesed scanner globally
	static Scanner read = new Scanner(System.in);
	
	//main method, entry point of program
	public static void main(String[] args) {
		
		SmartPhone smartphone = new SmartPhone();
		
		//infinite loop
		while (true) {
			//check if smartphone is on
			if (smartphone.isOn == true) {
				//call OnswitchMenu method
				OnSwitchMenu();
	            int choice = read.nextInt();

	            switch(choice) {
	            case 1:
	            	while(true) {
	            		//call CreateSmartPhoneOption
	            		CreateSmartPhoneOption();
		            	choice = read.nextInt();
		    			
		    			if (choice == 1) {
		    				//call the SmartPhone() constructor in SmartPhone class 
                          	smartphone = new SmartPhone();
                          	break;
		    			}
		    			else if (choice == 2) {
		    				//call CreateSmartPhone1 method
                          	smartphone = CreateSmartPhone1();
		    				break;
		    			}
		    			else if (choice == 3) {
		    				//call CreateSmartphone2 method
		    				smartphone = CreateSmartPhone2();
		    				break;
		    			}
		    			else {
		    				System.out.println("\nInvalid choice. Please select again.");
		    			}
	    			}
	            	break;
	            case 2:
	            	//call DisplayAttributes method in SmartPhone class
	            	smartphone.DisplayAttributes();
	                break;
	            case 3:
	            	//call ChargingPhone method in SmartPhone class
	            	smartphone.ChargingPhone();
	            	break;
	            case 4:
	            	//call SwitchPower method in SmartPhone class
	            	smartphone.SwitchPower();
	            	break;
	            case 5:
	            	//call AdjustVolume method in SmartPhone class
	            	smartphone.AdjustVolume();
	            	break;
	            case 6:
	            	//call UseCamera method in SmartPhone class
	            	smartphone.UseCamera();
	            	break;
	            case 7:
	            	//call Calculator method in SmartPhone class
	            	smartphone.ShowPhoneGallery();
	            	break;
	            case 8:
	            	//call DisplayAttributes method in SmartPhone class
	            	smartphone.Calculator();
	            	break;
	            case 9:
	            	//call MakeCall method in SmartPhone class
                    smartphone.MakeCall();
                    break;
	            case 10:
	            	//Exit the program
	            	System.out.println("Exiting the program.");
	                System.exit(0);
                    break;
	            default:
	            	System.out.println("\nInvalid choice. Please select again.");
	            }
			}
			else {
				//call OffSwitchMenu method
				OffSwitchMenu();
				int choice = read.nextInt();
	            
	            switch(choice) {
	            case 1:
	            	while(true) {
	            		//call CreateSmartPhoneOption
	            		CreateSmartPhoneOption();
		            	choice = read.nextInt();
		    			
		    			if (choice == 1) {
		    				//call the SmartPhone() constructor in SmartPhone class
                          	smartphone = new SmartPhone();
                          	break;
		    			}
		    			else if (choice == 2) {
		    				//call CreateSmartPhone1 method
                          	smartphone = CreateSmartPhone1();
		    				break;
		    			}
		    			else if (choice == 3) {
		    				//call CreateSmartphone2 method
		    				smartphone = CreateSmartPhone2();
		    				break;
		    			}
		    			else {
		    				System.out.println("\nInvalid choice. Please select again.");
		    			}
	    			}
	            	break;
	            case 2:
	            	//call DisplayAttributes method in SmartPhone class
	            	smartphone.DisplayAttributes();
	                break;
	            case 3:
	            	//call ChargingPhone method in SmartPhone class
	            	smartphone.ChargingPhone();
	            	break;
	            case 4:
	            	//call SwitchPower method in SmartPhone class
	            	smartphone.SwitchPower();
	            	break;
	            case 5:
	            	//Exit the program
	            	System.out.println("Exiting the program.");
	                System.exit(0);
	            	break;
	            default:
	            	System.out.println("\nInvalid choice. Please select again.");
                }
			}
		}
	}
	
	//Method that helps to change the value of brand, model, os, storage capacity
	static SmartPhone CreateSmartPhone1() {
		System.out.print("Enter Brand: ");
		String brand = read.next();
		System.out.print("Enter Model: ");
		String model = read.next();
		System.out.print("Enter OS: ");
		String os = read.next();
		
		int storageCapacity;
		System.out.println(" |------------| ");
		System.out.println(" |--1Storage--| ");
		System.out.println(" |------------| ");
		System.out.println(" | [1]. 64 GB |\n | [2].128 GB |\n | [3].256 GB |");  
		System.out.println(" |------------| ");
        System.out.print("Enter your storage capacity: ");
        int constructorChoice = read.nextInt();
        
        switch (constructorChoice) {
        case 1:
        	storageCapacity = 64;
        	return new SmartPhone(brand, model, os, storageCapacity);
        case 2:
        	storageCapacity = 128;
        	return new SmartPhone(brand, model, os, storageCapacity);
        case 3:
        	storageCapacity = 256;
        	return new SmartPhone(brand, model, os, storageCapacity);
        default:
        	System.out.println("ERROR: Wrong inputted number, default storage is 64 GB");
        	storageCapacity = 64;
        	return new SmartPhone(brand, model, os, storageCapacity);
		}
    }
	
	//Method that helps to change the value of Storage capacity
	static SmartPhone CreateSmartPhone2() {
		int storageCapacity;
		System.out.println("1. 64 GB\n2.128 GB\n3.256 GB");  
        System.out.print("Enter your storage capacity: ");
        
        int constructorChoice = read.nextInt();

        switch (constructorChoice) {
        case 1:
        	storageCapacity = 64;
        	return new SmartPhone(storageCapacity);
        case 2:
        	storageCapacity = 128;
        	return new SmartPhone(storageCapacity);
        case 3:
        	storageCapacity = 256;
        	return new SmartPhone(storageCapacity);
        default:
        	System.out.println("ERROR: Wrong inputted number, default storage is 64 GB");
        	storageCapacity = 64;
        	return new SmartPhone(storageCapacity);
			
		}
    }
	
	//options for on switch menu
	static void OnSwitchMenu() {
		System.out.println(" |-----------------------------------| ");
		System.out.println(" |               Menu:               | ");
		System.out.println(" |-----------------------------------| ");
		System.out.println(" |                                   | ");
        System.out.println(" | [1]. Create SmartPhone            | ");
        System.out.println(" | [2]. Display Attributes           | ");
        System.out.println(" | [3]. Charge Device                | ");
        System.out.println(" | [4]. Switching Power              | ");
        System.out.println(" | [5]. Volume                       | ");
    	System.out.println(" | [6]. Camera                       | ");
    	System.out.println(" | [7]. Gallery                      | ");
        System.out.println(" | [8]. Calculator                   | ");
        System.out.println(" | [9]. MakeCall                     | ");
    	System.out.println(" | [10]. Exit                        | ");
		System.out.println(" |                                   | ");
        System.out.println(" |-----------------------------------| ");
        
        System.out.print("Enter your choice: ");
    }
	
	//options for off switch menu
	static void OffSwitchMenu() {
		System.out.println(" |-----------------------------------| ");
		System.out.println(" |              Menu:                | ");
		System.out.println(" |-----------------------------------| ");
		System.out.println(" |                                   | ");
        System.out.println(" | [1]. Create SmartPhone            | ");
        System.out.println(" | [2]. Display SmartPhone Details   | ");
        System.out.println(" | [3]. Charging Phone               | ");
        System.out.println(" | [4]. Switching Power              | ");
    	System.out.println(" | [5]. Exit                         | ");           
		System.out.println(" |                                   | ");
        System.out.println(" |-----------------------------------| ");
        
        System.out.print("Enter your choice: ");
	}
	
	//options for creating smartphone
	static void CreateSmartPhoneOption() {
		System.out.println(" |------------|-----------------|------------| ");
		System.out.println(" |             Create SmartPhone             | ");
		System.out.println(" |------------|-----------------|------------| ");
		System.out.println(" |   [1]. Default Phone                      | ");
		System.out.println(" |   [2]. Change all SmartPhone Attributes   | ");
		System.out.println(" |   [3]. Change the storage capacity        | ");
		System.out.println(" |-------------------------------------------| ");
		
		System.out.print("Choose a number: ");
	}
}
