public class MobilePhone{
	int num;
	Boolean status;
	Exchange base ;

	public MobilePhone(int number){
		num = number ;
		status = true;
	}

	public int number(){return num;}

	public Boolean status(){return status ;}

	public void switchOn(){status = true;}

	public void switchOff(){status = false;}

	public Exchange location() throws Exception{
		if(status == true){
			return base;
		}
		else{throw new Exception("Error - MobilePhone is OFF, location inaccessible");}
	}
}