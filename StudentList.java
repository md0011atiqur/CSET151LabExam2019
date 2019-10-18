
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
public class StudentList {
	//read write method optimization start
	public  static  String LoadData() {
		System.out.println(Constants.showloadingdata);
		String alllines = null;
		//alllines initialized as null
		try {
			BufferedReader FileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.mainfile)));
			alllines = FileStream.readLine();
		}
		catch (Exception e)
		{
		System.out.println(e);
		}
		return alllines;
	}
	//file write function
	public  static  void WriteDate( String[] args) {
		System.out.println(Constants.showloadingdata);
		try {
			BufferedWriter FileStream = new BufferedWriter(
			new FileWriter(Constants.mainfile, true));
			String Input = args[0].substring(1);
			Date d = new Date();
			//date taken in d variable by using date function
			String df = Constants.showdateformat;
			DateFormat dateFormat = new SimpleDateFormat(df);
			String fd = dateFormat.format(d);
			FileStream.write(", " + Input + "\n List last updated on ");
			//new name added in list with date and time
			FileStream.close();
			//after write file closed
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(Constants.showloadingdata);
	}
	//read write method optimization end
	public static void main(String[] args) {
		//early guard during argument pass
		if(args.length != 1 || args[0] != args[Constants.showall] |args[0] != args[Constants.showrandom] || args[0] != args[Constants.showsearch] || args[0] != args[Constants.showcount] || args[0] != args[Constants.showadd])
		{
			System.out.println(Constants.showusagemessage);
		}
		//Check arguments
		if(args[0].equals(Constants.showall))
		{
			String alllines = LoadData();
			//use loaddata method to read file
			String words[] = alllines.split(",");
			//split word from line by using regular expression
			for(String word : words)
				System.out.println(word);
			System.out.println(Constants.showloadingdata);
		}
		else if(args[0].equals(Constants.showrandom))
		{
			String alllines = LoadData();
			//use loaddata method to read file
			String words[] = alllines.split(",");
			//split word from line by using regular expression
			Random x = new Random();
			//random function used
			int y = x.nextInt(1);
			//taken single random number
			System.out.println(words[y]);
			System.out.println(Constants.showloadingdata);
		}
		else if(args[0].contains(Constants.showadd)){
			WriteDate(args);
		//write method use to add new student in list
		}

		else if(args[0].contains(Constants.showsearch))
		{
			String  contents = LoadData();
			//use loaddata method to read file
			String wrods[] = contents.split(",");
			//split word from line by using regular expression
			String Query = args[0].substring(1);
			for(int indexlocation = 0; indexlocation<wrods.length; indexlocation++) {
			if(wrods[indexlocation].equals(Query))
			{
				System.out.println(Constants.shwowefoundit);
				break;
			}
		//processing
		else if(args[0].contains(Constants.showcount)) {
			String allstudentlist = LoadData();
			//use loaddata method to read file
			String words[] = allstudentlist.split(",");
			//split word from line by using regular expression
			char charArray[] = allstudentlist.toCharArray();
			int WordCount = words.length;
			System.out.println(WordCount + " word(s) and " + charArray.length + " Characters Found");
			System.out.println(Constants.shwowefoundit);
	}
}