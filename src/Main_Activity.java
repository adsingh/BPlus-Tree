import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main_Activity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream inputStream;
		Scanner sc;
		boolean isOrder = true;
		BPlus_Tree bPlusTree = null;
		try{
			inputStream= new FileInputStream("C:/Gainesville/Fall 2017/ADS/Project/src/input.txt");
			sc = new Scanner(inputStream);
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				if(isOrder){
					isOrder = false;
					int order = Integer.parseInt(line);
					bPlusTree = new BPlus_Tree(order);
				}
				else{
					String[] cmdParts = line.split("\\(");
					String cmd = cmdParts[0].toLowerCase();
					String[] params = cmdParts[1].split(",");
					
					switch(cmd){
					case "insert":
						
						bPlusTree.insert(Double.parseDouble(params[0]), params[1].substring(0, params[1].length()-1));
						break;
						
					case "search":
						
						if(params.length == 1){
							bPlusTree.search(Double.parseDouble(params[0].substring(0, params[0].length()-1)));
						}
						else{
							bPlusTree.search(Double.parseDouble(params[0]), Double.parseDouble(params[1].substring(0,params[1].length()-1)));
						}
						break;
					}
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
