/**
 * Created by student on 22.10.16.
 */
import org.apache.commons.cli.*;

public class Parser
{
    //���� ������
    String[] args;// = null;
    Options options = new Options();



    //���������� ��� ����� ��� ��������
    public Parser(String[] args)
    {
        this.args = args;

        options.addOption(new Option("login", "login", true, "Login: "));
        //�����, ���� -l
        options.addOption(new Option("pass", "password", true, "Password: "));

    }

    //�������� ���������� �� ������ Args
    public Args parse()
    {
        CommandLineParser cmdLineParser = new DefaultParser();
        //CommandLineParser - ��� ������, DefaultParser - ��� �������
        CommandLine cmdLine;
        //CommandLine �� ��� ������, parse ������ �����, cmdLine �������� ������
        //cmdLine.hasOption("login");
        //cmdLine.getOptionValue("login");

        Args parse1 = new Args();
        //parse1.login=cmdLine.getOptionValue("login");
        //parse1.password=cmdLine.getOptionValue("password");


        //��������,try - ��������� ������� � ������� ������
        //catch - � ������ ������,����� - Parse error
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



