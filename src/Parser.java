/**
 * Created by student on 14.11.2016.
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
        options.addOption(new Option("pass", "password", true, "Password: "));
        options.addOption(new Option("role", "role", true, "Role: "));
        options.addOption(new Option("res", "resource", true, "Resource: "));

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

            if (cmdLine.hasOption("role")) {
                parse1.role = cmdLine.getOptionValue("role");
            }

            if (cmdLine.hasOption("res")) {
                parse1.resource = cmdLine.getOptionValue("res");
            }


        } catch (ParseException e) {
            System.out.println("Parse error");
        }
        System.out.println(parse1.login);
        System.out.println(parse1.password);
        return parse1;
    }
}
