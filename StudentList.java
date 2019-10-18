
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
		try {
			BufferedReader FileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.mainfile)));
			alllines = FileStream.readLine();
		} catch (Exception e) {
			System.out.println(e);
		}
		return alllines;
	}
	public  static  void WriteDate( String[] args) {
		System.out.println(Constants.showloadingdata);
		try {
			BufferedWriter FileStream = new BufferedWriter(
					new FileWriter(Constants.mainfile, true));
			String Input = args[0].substring(1);
			Date todaydate = new Date();
			String timestamp = Constants.showdateformat;
			DateFormat dateFormat = new SimpleDateFormat(timestamp);
			String fd = dateFormat.format(todaydate);
			FileStream.write(", " + Input + "\n List last updated on ");
			FileStream.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(Constants.showloadingdata);
	}
	//read write method optimization end
	public static void main(String[] args) {
		//early guard during argument pass
		if(args.length != 1)
		{
			System.out.println(Constants.showusagemessage);
		}
		//Check arguments
		if(args[0].equals(Constants.showall))
		{
			String alllines = LoadData();
			String words[] = alllines.split(",");
			for(String word : words)
				System.out.println(word);
			System.out.println(Constants.showloadingdata);
		}
		else if(args[0].equals(Constants.showrandom))
		{
			String alllines = LoadData();
			String words[] = alllines.split(",");
			Random x = new Random();
			int y = x.nextInt(1);
			System.out.println(words[y]);
			System.out.println(Constants.showloadingdata);
		}
		else if(args[0].contains(Constants.showadd)){
			WriteDate(args);
		}
		else if(args[0].contains(Constants.showsearch))
		{
			String  contents = LoadData();
			String wrods[] = contents.split(",");
			boolean done = false;
			String Query = args[0].substring(1);
			System.out.println(Constants.shwowefoundit);
			done=true;
			System.out.println(Constants.showloadingdata);
		}

		//processing
		else if(args[0].contains(Constants.showcount)) {
			String alllines = LoadData();
			char charactararry[] = alllines.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char eachcharactar:charactararry) {
				if(eachcharactar ==' ') {
					if (!in_word) {
						count++;
						in_word =true;
					} else {
						in_word=false;
					}
				}
			}
			System.out.println(count +Constants.showwordfound + charactararry.length);
			System.out.println(Constants.showloadingdata);
		}
	}
}