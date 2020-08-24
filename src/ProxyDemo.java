
public class ProxyDemo {
    public static void main(String[] args) {
    
    //create empty rules
    Rules rule_employee = new Rules();
	Rules rule_manager = new Rules();
	Rules rule_boss = new Rules();
	
	//add webs in the rules
	rule_employee.addfilter("www.youtube.com");
	rule_employee.addfilter("www.facebook.com");
	rule_manager.addfilter("www.facebook.com");
	
	//create some rules prototypes
	Worker employee_prototype = new Worker("employee",rule_employee);
	Worker manager_prototype = new Worker("manager",rule_manager);
	Worker boss_prototype = new Worker("boss",rule_boss);
	
	//use prototype to initialize workers
	Worker employee1 = employee_prototype.clone();
	Worker manager1 = manager_prototype.clone();
	Worker boss1 = boss_prototype.clone();
	
	Internet internet = new ProxyInternet();

	internet.connectTo(employee1, "www.youtube.com");
	internet.connectTo(manager1, "www.facebook.com");
	internet.connectTo(boss1, "www.youtube.com");

	employee1.rule_x.addfilter("www.snapchat.com");
	employee1.rule_x.addfilter("www.instagram.com");
	manager1.rule_x.addfilter("www.instagram.com");
	
	internet.connectTo(employee1, "www.snapchat.com");
	internet.connectTo(employee1, "www.instagram.com");
	internet.connectTo(manager1, "www.instagram.com");
	internet.connectTo(boss1, "www.facebook.com");
	
    }

}

