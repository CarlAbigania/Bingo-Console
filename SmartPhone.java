
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartPhone {
	
	//Class fields
	String brand;
    String model;
    String os;
    double storageCapacity;
    double storageCapacityInMB;
    int usedStorage;
    int volume;
    int batteryPercentage;
    boolean isOn;
    boolean isCallInProgress;
    List<String> photoGallery = new ArrayList<>();
    
    // Default Constructor
    SmartPhone() { 
    	
    	brand = "iPhone";
    	model = "X";
    	os = "iOS";
    	storageCapacity = 64;
    	storageCapacityInMB = this.storageCapacity * 1000;
    	isCallInProgress = false;
    	volume = 16;
        batteryPercentage = 0;
        
        System.out.println("\nSystem:\nDefault Smartphone created!");
        DisplayAttributes();
    }
    
    //Constructor with parameter of string,string,string,integer
    SmartPhone(String brand, String model, String os, int storageCapacity) {
    	
        this.brand = brand;
        this.model = model;
        this.os = os;
        this.storageCapacity = storageCapacity;
        this.storageCapacityInMB = this.storageCapacity * 1000;
        
        isCallInProgress = false;
        volume = 16;
        batteryPercentage = 0;
        
        System.out.println("\nSystem:\nSmartphone created!");
        DisplayAttributes();
    }
    
    //Constructor with parameter of integer
    SmartPhone(int storageCapacity) {
    	
    	brand = "iPhone";
        model = "X";
        os = "iOS";
        this.storageCapacity = storageCapacity;
        this.storageCapacityInMB = this.storageCapacity * 1000;
        isCallInProgress = false;
        
        volume = 16;
        batteryPercentage = 0;
        
        System.out.println("\nSystem:\nSmartphone created!");
        DisplayAttributes();
    }
    
    // Method to charge the phone
 	public void ChargingPhone() {
 		if (this.batteryPercentage < 100) {
 			this.batteryPercentage = 100;
 			System.out.println("\nSystem:\nThe device is already fully charged!");
 			DisplayAttributes();
 		}
 		else {
 			System.out.println("\nSystem:\nThe device is currently in full charged!");
 		}
 	}
    
 	//Method to switch the power on
 	public void SwitchPower(){
 		if (this.batteryPercentage > 0 && this.batteryPercentage <= 100) {
 			this.isOn = !this.isOn;
 	 		System.out.println("\nSystem:\nThe device is already turned " + (this.isOn == true  ? "ON!" : "OFF!"));
 	 		DisplayAttributes();
 		}
 		else {
 			System.out.println("\nSystem:\nBattery critically low, Please charge your device!");
 		}	
 	}
 	
 	//method for adjusting the volume
 	public void AdjustVolume() {
 		boolean isOpen = false;
 		
 		if(this.isOn == true) {
 			isOpen = true;

 			do {
 				System.out.println(" |--|-------------------|--|");
 				System.out.println("          Volume: " + volume + "       ");
 				System.out.println(" |--|-------------------|--|");
 				System.out.println(" |     [1]. Volume Up      |");
	    		System.out.println(" |     [2]. Volume Down    |");
	    		System.out.println(" |     [3]. Exit           |");
	    		System.out.println(" |-------------------------|");
 			int response = read.nextInt();
 			if(response == 1) {
 				if(volume >= 16) {
 					System.out.println("\nSystem: Maximum volume reached!");
 				}
 				else {volume += 1;
 				}
 			}
 			else if(response == 2) {
 				if(volume <= 0) {
 					System.out.println("\nSystem: Minimum volume reached!");
 				}
 				else{volume -= 1;
 				}
 			}
 			else if(response == 3) {
 				isOpen = false;
 			}
 			else {
 				System.out.println("System:\nInvalid choice!");
 			}
 			}while(isOpen == true);
 		}
 	}
 	
 	//method to use the camera
 	public void UseCamera() {
 		boolean appOpened = false;
 		
 		if(this.isOn == true) {
 			appOpened = true;
 			DisplayAttributes();
 			
 			do {
 				System.out.println(" |--|-------------------|--|");
 				System.out.println(" |   (Camera) app opened!  |");
 				System.out.println(" |--|-------------------|--|");
 				System.out.println(" |       [1]. Camera       |");
	    		System.out.println(" |       [2]. Video        |");
	    		System.out.println(" |       [3]. Exit         |");
	    		System.out.println(" |-------------------------|");
	    	   	
	    		System.out.print("Enter your choice: ");
	    		int cameraChoice = read.nextInt();
	    		
	    		if(cameraChoice == 1) {
	    			System.out.print("Photo captured! Enter filename to save: ");
	    			String cameraResponse = read.next();
	    			this.StorePhotos(cameraResponse, 5);
	    			this.batteryPercentage -= 1;
	    		}
	    		else if(cameraChoice == 2) {
	    			System.out.print("Video recorded! Enter filename to save: ");
	    			String cameraResponse = read.next();
	    			this.StoreVideos(cameraResponse, 10);
	    			this.batteryPercentage -= 3;
	    		}
	    		else if(cameraChoice == 3) {
	    			appOpened = false;
	    			System.out.println("System:\nApp successfully closed!");
	    		}
	    		else {
	    			System.out.println("Invalid Choice!");
	    		}
	    		
 			}while(appOpened == true);
		}
		else {
			System.out.println("\nSystem:\nPlease turn on the phone first");
		}
 	}
 	
 	//method to store the photo to gallery
 	public void StorePhotos(String photoFileName, int photoSize) {
 		
 		if(this.usedStorage + photoSize <= this.storageCapacityInMB) {
			photoFileName = photoFileName + ".jpg";
			this.photoGallery.add(photoFileName);
			this.usedStorage += photoSize;
			System.out.println("Photo captured and saved: " + photoFileName);
		}
		else {
		System.out.println("Not enough storage to save photo: " + photoFileName + " " + photoSize + " MB");
		}	
	}
 	
 	//method to store the video to gallery
 	public void StoreVideos(String videoFileName, int videoSize) {
 		
		if(this.usedStorage + videoSize <= this.storageCapacityInMB) {
			videoFileName = videoFileName + ".mp4";
			this.photoGallery.add(videoFileName);
			this.usedStorage += videoSize;
			System.out.println("Recorded video has been saved: " + videoFileName);
		}
		else {
		System.out.println("Not enough storage to save photo: " + videoFileName + " " + videoSize + " MB");
		}
 	}
 	
 	//Method to show the phone gallery
 	public void ShowPhoneGallery() {
 		double currentStorageInMB = this.storageCapacityInMB - this.usedStorage;
 		this.storageCapacity = currentStorageInMB/1000.0;	
 		
 		if(this.isOn == true) {
 			DisplayAttributes();
 			System.out.println("\nPhoto Gallery for " + this.brand);
 			
 			for(String photo : this.photoGallery) {
 				System.out.println(photo);
 			}
 			
		System.out.println("Used Storage: " + this.usedStorage + " MB");
		System.out.println("Available Storage " + this.storageCapacity + " GB");
		this.batteryPercentage -= 2;
 		}
 		else {
 			System.out.println("\nSystem:\nPlease turn on the phone first!");
		}	
 	}

 	//method to use the calculator
    public void Calculator(){
    	boolean appOpened = false;
    	int firstNumber;
    	int secondNumber;
 		
    	if(this.isOn == true) {
 			appOpened = true;
 			
    		do {
    			System.out.println(" |----------------------------------| ");
 				System.out.println(" |------------calculate-------------| ");
 				System.out.println(" |----------------------------------| ");
 				System.out.println(" |        [1]: Addition             | ");
 				System.out.println(" |        [2]: Subtraction          | ");
 				System.out.println(" |        [3]: Multiplication       | ");
 				System.out.println(" |        [4]: Division             | ");
 				System.out.println(" |        [5]: Exit                 | ");
 				System.out.println(" |----------------------------------| ");
       
 				System.out.print("Please select operation: ");
 				int chosenOperation = read.nextInt();
 				

 				switch (chosenOperation){
 				case 1 : 
 					System.out.print("\nFirst number: ");
 	 				firstNumber = read.nextInt();
 	 				System.out.print("Second number: ");
 	 				secondNumber = read.nextInt();
 	 				
 					int sum = firstNumber + secondNumber;
 					System.out.println(firstNumber + " + " + secondNumber + " = " + sum);
 					this.batteryPercentage -= 1;
 					break;
	       		case 2 : 
	       			System.out.print("\nFirst number: ");
 	 				firstNumber = read.nextInt();
 	 				System.out.print("Second number: ");
 	 				secondNumber = read.nextInt();
 	 				
	       			int difference = firstNumber - secondNumber;
	       			System.out.println(firstNumber + " - " + secondNumber + " = " + difference);
	       			this.batteryPercentage -= 1;
	       			break;
	       		case 3 : 
	       			System.out.print("\nFirst number: ");
 	 				firstNumber = read.nextInt();
 	 				System.out.print("Second number: ");
 	 				secondNumber = read.nextInt();
 	 				
	       			int product = firstNumber * secondNumber;
	       			System.out.println(firstNumber + " * " + secondNumber + " = " + product);
	       			this.batteryPercentage -= 1;
	       			break;	       			
	       		case 4 : 
	       			System.out.print("\nFirst number: ");
 	 				firstNumber = read.nextInt();
 	 				System.out.print("Second number: ");
 	 				secondNumber = read.nextInt();
 	 				
	       			double quotient = firstNumber / secondNumber;
	       			System.out.println(firstNumber + " / " + secondNumber + " = " + quotient);
	       			this.batteryPercentage -= 1;
	       			break;
	       		case 5 : 
	       			appOpened = false;
	       			break;
	       		default:
	       			System.out.println("Invalid input, choose from number 1-5");
	       			break;
 				}
 				
 			}while (appOpened == true);
 		}
    }
 	
    //method to make a call
    public void MakeCall() {
 		
 		while(true) {
 			System.out.println(" |--|-------------------|--|");
			System.out.println(" |   (Contact) app opened! |");
			System.out.println(" |--|-------------------|--|");
    		System.out.println(" |       [1]. Call         |");
    		System.out.println(" |       [2]. EndCall      |");
    		System.out.println(" |       [3]. Exit         |");
    		System.out.println(" |-------------------------|");
    		
    		System.out.print("Enter your choice : ");
    		int callChoice = read.nextInt();
    		
    		if(callChoice == 1) {
    	 		if (!isCallInProgress) {
        			isCallInProgress = true;
    	            if (batteryPercentage >= 10) {
    	                isCallInProgress = true;
    	                batteryPercentage -= 5;
    	                System.out.println("\nCalling " + "...");
    	                System.out.println("Call in progress.");
    	            } else {
    	                System.out.println("Battery too low to make a call. Please charge your phone.");
    	            }
    	        } else {
    	            System.out.println("Call is already in progress.");
    	        }
    		}else if(callChoice == 2) {
    			if (isCallInProgress) {
    	            isCallInProgress = false;
    	            System.out.println("Call ended.");
    	        } else {
    	            System.out.println("No call in progress.");
    	        }
    		}else {
    			DisplayAttributes();
    			return;
    		}
 		}
 	}
    
    //method to diplay the attributes
	public void DisplayAttributes() {
		System.out.println("\n>>>>>>>>DETAILS<<<<<<<<" + "\nBrand: " + brand
				+ "\nModel: " + model 
				+ "\nOS: " + os 
				+ "\nPower: "+ (isOn == true  ? "ON" : "OFF") 
				+ "\nStorage Capacity: " + storageCapacity + "GB"
				+ "\nVolume: " + volume 
				+ "\nCall in Progress: " + (isCallInProgress ? "Yes" : "No")
				+ "\nBattery Percent: " + batteryPercentage + "%");
	}
	
	//static scanner to accesed scanner globally
	static Scanner read = new Scanner(System.in);
}
