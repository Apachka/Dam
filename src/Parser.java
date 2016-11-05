/**
 * Created by student on 22.10.16.
 */
import org.apache.commons.cli.*;

public class Parser
{
    //созд параме
    String[] args;// = null;
    Options options = new Options();



    //добавление еще опций для парсинга
    public Parser(String[] args)
    {
        this.args = args;

        options.addOption(new Option("login", "login", true, "Login: "));
        //опции, ключ -l
        options.addOption(new Option("pass", "password", true, "Password: "));

    }

    //передача параметров из класса Args
    public Args parse()
    {
        CommandLineParser cmdLineParser = new DefaultParser();
        //CommandLineParser - тип данных, DefaultParser - тип парсера
        CommandLine cmdLine;
        //CommandLine эт тип данных, parse массив опций, cmdLine разбитая строка
        //cmdLine.hasOption("login");
        //cmdLine.getOptionValue("login");

        Args parse1 = new Args();
        //parse1.login=cmdLine.getOptionValue("login");
        //parse1.password=cmdLine.getOptionValue("password");


        //проверка,try - возможное условие с исходом ошибки
        //catch - в случае ошибки,вывод - Parse error
        try {
            cmdLine = cmdLineParser.parse(options, args);

            if (cmdLine.hasOption("login")) {
                parse1.login = cmdLine.getOptionValue("login");
            }

            if (cmdLine.hasOption("pass")) {
                parse1.password = cmdLine.getOptionValue("pass");
            }


        } catch (ParseException e) {
            System.out.println("Parse error");
        }
        System.out.println(parse1.login);
        System.out.println(parse1.password);
        return parse1;
    }
}



