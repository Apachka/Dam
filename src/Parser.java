/**
 * Created by student on 22.10.16.
 */
import org.apache.commons.cli.*;

public class Parser {
    Options options = new Options();
    //public static void main(String[] args) {}

    //добавление еще опций для парсинга
    public Parser() {
        options.addOption(new Option("-l", "login", true, "Login: "));
        //опции, ключ -l
        options.addOption(new Option("-p", "password", true, "Password: "));

    }




    public Args parse(String[] args) throws ParseException//исключание для cmdLineParser.parse
    {


        CommandLineParser cmdLineParser = new DefaultParser();
        //CommandLineParser - тип данных, DefaultParser - тип парсера
        CommandLine cmdLine = cmdLineParser.parse(options, args);
//CommandLine эт тип данных, parse массив опций, cmdLine разбитая строка
       cmdLine.hasOption("login");
        cmdLine.getOptionValue("login");

        Args parse1=new Args();
        parse1.login=cmdLine.getOptionValue("login");
        parse1.password=cmdLine.getOptionValue("password");
        return parse1;





    }



}

/*
    Option option1 = new Option("l", "login", true, "Login:");
    Option option2 = new Option("2", "pass", true, "Password:");
    Option option3 = new Option("3", "role", true, "Role:");

        Option count = new Option("l", "limit", true, "ограничивает количество отображаемых изменений");
        //Parser p = new Parser();
        Options options = new Options();
        options.addOption(count);
        if( line.hasOption( "l" ) ) {
            String count = line.getOptionValue( "l" );
        }


            for (int i = 0; i < users.size(); i++)
            {
                if (users.get(i).equals("jdoe"))
                {
                    System.out.println("Bingo!");
                }
                else System.out.println("ftgft!");
                break;
            }

        }
}
*/


//Проверка на логин jrow у всех пользователей


